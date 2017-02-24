package sxxt.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EquipmentInspection {
	int id;
	EquipmentInfo equipmentInfo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date inspectionDate;
	String content;
	int state;
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

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
