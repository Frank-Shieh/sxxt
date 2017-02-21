package sxxt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import sxxt.entity.DataInfo;
import sxxt.service.interfaces.DataInfoService;

@Controller
@RequestMapping(value = "/dataInfo")
public class DataInfoController {
	@Autowired
	private DataInfoService dataInfoService;

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

		// 新文件名
		String newFileName = dataInfo.getDataName();

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

}
