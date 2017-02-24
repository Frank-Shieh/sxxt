package sxxt.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class equipmentInspection {
	int id;
	EquipmentInfo equipmentInfo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date inspectionDate;
	String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EquipmentInfo getEquipmentInfo() {
		return equipmentInfo;
	}

	public void setEquipmentInfo(EquipmentInfo equipmentInfo) {
		this.equipmentInfo = equipmentInfo;
	}

	public Date getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "equipmentInspection [id=" + id + ", equipmentInfo=" + equipmentInfo + ", inspectionDate="
				+ inspectionDate + ", content=" + content + "]";
	}

}
