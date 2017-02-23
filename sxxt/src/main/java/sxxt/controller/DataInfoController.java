package sxxt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import sxxt.entity.DataInfo;
import sxxt.entity.EducationManager;
import sxxt.entity.EquipmentManager;
import sxxt.entity.SchoolTeacher;
import sxxt.entity.SiteManager;
import sxxt.entity.Student;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.DataInfoService;
import sxxt.service.interfaces.EducationManagerService;
import sxxt.service.interfaces.EquipmentManagerService;
import sxxt.service.interfaces.SchoolTeacherService;
import sxxt.service.interfaces.SiteManagerService;
import sxxt.service.interfaces.StudentService;
import sxxt.service.interfaces.TrainningTeacherService;

@Controller
@RequestMapping(value = "/dataInfo")
public class DataInfoController {
	@Autowired
	private DataInfoService dataInfoService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private SiteManagerService siteManagerService;
	@Autowired
	private TrainningTeacherService trainningTeacherService;
	@Autowired
	private SchoolTeacherService schoolTeacherService;
	@Autowired
	private EducationManagerService educationManagerService;
	@Autowired
	private EquipmentManagerService equipmentManagerService;

	// 请求获取到列表页面
	@RequestMapping(value = "list")
	public String list(Model model, HttpSession httpSession) {
		try {
			List<DataInfo> result = dataInfoService.findAll();
			model.addAttribute("result", result);
			model.addAttribute("user", httpSession.getAttribute("user"));
			return "dataInfoManage/listDataInfo";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("errorMsg", "查找资料信息失败");
			return "dataInfoManage/listDataInfo";
		}
	}

	// 请求获取到上传资料页面
	@RequestMapping(value = "add")
	public String add(Model model, HttpSession httpSession) {
		model.addAttribute("user", httpSession.getAttribute("user"));
		return "dataInfoManage/addDataInfo";
	}

	// 请求获取到上传资料页面
	@RequestMapping(value = "doAdd")
	public String doAdd(DataInfo dataInfo, HttpServletRequest request, @RequestParam("file") CommonsMultipartFile file)
			throws Exception {
		// 获得原始文件名
		String fileName = file.getOriginalFilename();
		System.out.println("原始文件名:" + fileName);
		// 获取后缀
		String last = fileName.substring(fileName.indexOf("."), fileName.length());
		// 新文件名
		String newFileName = UUID.randomUUID() + dataInfo.getDataName() + last;

		// 获得项目的路径
		ServletContext sc = request.getSession().getServletContext();
		// 上传位置
		String path = sc.getRealPath("/upload") + "/"; // 设定文件保存的目录

		File f = new File(path);
		if (!f.exists())
			f.mkdirs();
		if (!file.isEmpty()) {
			try {
				FileOutputStream fos = new FileOutputStream(path + newFileName);
				InputStream in = file.getInputStream();
				int b = 0;
				while ((b = in.read()) != -1) {
					fos.write(b);
				}
				fos.close();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dataInfo.setUrl(path + newFileName);
		dataInfoService.addDataInfo(dataInfo);

		return "redirect:/dataInfo/list";
	}

	/**
	 * 下载文件
	 * 
	 * @param file
	 * @throws IOException
	 */
	@RequestMapping(value = "download/{id}")
	public ResponseEntity<byte[]> download(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") int id) throws IOException {
		DataInfo dataInfo = dataInfoService.findById(id);

		File file = new File(dataInfo.getUrl());
		System.out.println(file.getName());
		if (file.exists() && file.getName().length() >= 36) {
			String name = file.getName().substring(36, file.getName().length());
			String dFileName = new String(name.getBytes(), "ISO-8859-1");
			System.out.println(dFileName);
			// 下面开始设置HttpHeaders,使得浏览器响应下载
			HttpHeaders headers = new HttpHeaders();
			// 设置响应方式
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			// 设置响应文件
			headers.setContentDispositionFormData("attachment", dFileName);
			// 把文件以二进制形式写回
			ResponseEntity<byte[]> ret = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers,
					HttpStatus.CREATED);
			// 添加下載次數
			int temp = dataInfo.getDownloadTimes();
			temp++;
			dataInfo.setDownloadTimes(temp);
			dataInfoService.editDataInfo(dataInfo);
			return ret;
		} else {
			System.out.println("资源找不到！！！");
		}
		return new ResponseEntity<byte[]>(null, null, HttpStatus.CREATED);
	}

	// 请求获取到查看资料页面
	@RequestMapping(value = "view")
	public String view(int id, Model model, HttpSession httpSession) {
		DataInfo dataInfo = dataInfoService.findById(id);
		int role = dataInfo.getUploadRole();
		switch (role) {
		case 1: // 学生
			Student s = studentService.findById(dataInfo.getUploadId());
			model.addAttribute("uploader", s);
			break;
		case 2: // 实训场地管理员
			SiteManager siteManager = siteManagerService.findById(dataInfo.getUploadId());
			model.addAttribute("uploader", siteManager);
			break;
		case 3: // 实训基地教师
			TrainningTeacher t = trainningTeacherService.findById(dataInfo.getUploadId());
			model.addAttribute("uploader", t);
			break;
		case 4: // 学校教师
			SchoolTeacher schoolTeacher = schoolTeacherService.findById(dataInfo.getUploadId());
			model.addAttribute("uploader", schoolTeacher);
			break;
		case 5: // 实训教务主管
			EducationManager educationManager = educationManagerService.findById(dataInfo.getUploadId());
			model.addAttribute("uploader", educationManager);
			break;
		case 6:// 设备管理员
			EquipmentManager equipmentManager = equipmentManagerService.findById(dataInfo.getUploadId());
			model.addAttribute("uploader", equipmentManager);
			break;
		}
		model.addAttribute("result", dataInfo);
		return "dataInfoManage/viewDataInfo";
	}

	@RequestMapping(value = "listMyself/{id}/{role}")
	public String listMyself(Model model, HttpSession httpSession, @PathVariable("id") int id,
			@PathVariable("role") int role) {
		try {
			List<DataInfo> result = dataInfoService.findByMyself(id, role);
			model.addAttribute("result", result);
			model.addAttribute("user", httpSession.getAttribute("user"));
			return "dataInfoManage/listMyDataInfo";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("errorMsg", "查找资料信息失败");
			return "dataInfoManage/listMyDataInfo";
		}
	}

	// 请求跳转到删除单个班级信息
	@RequestMapping(value = "delete/{id}/{userId}/{role}")
	public String delDataInfo(@PathVariable("id") int id, @PathVariable("userId") int userId,
			@PathVariable("role") int role, Model model) {
		dataInfoService.delDataInfo(id);
		String r = "redirect:/dataInfo/listMyself/" + userId + "/" + role;
		return r;
	}

}
