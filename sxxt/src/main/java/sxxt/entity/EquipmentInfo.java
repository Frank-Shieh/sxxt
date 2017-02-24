package sxxt.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EquipmentInfo {

	int id;
	Site site;
	String name;
	int num;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date buyDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date produceDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date inspectionDate; // 下次年检日期
	double inspectionTime; // 设备年检期限
	EquipmentManager equipmentManager;
	TrainningTeacher trainningTeacher;
	// state 0-已删除 1-可用 2-自身已用 3-借用 4-已出租
	int state;
	int rentFee;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date rentDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date returnDate;
	String rentPeople;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public Date getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}

	public Date getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public double getInspectionTime() {
		return inspectionTime;
	}

	public void setInspectionTime(double inspectionTime) {
		this.inspectionTime = inspectionTime;
	}

	public EquipmentManager getEquipmentManager() {
		return equipmentManager;
	}

	public void setEquipmentManager(EquipmentManager equipmentManager) {
		this.equipmentManager = equipmentManager;
	}

	public TrainningTeacher getTrainningTeacher() {
		return trainningTeacher;
	}

	public void setTrainningTeacher(TrainningTeacher trainningTeacher) {
		this.trainningTeacher = trainningTeacher;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getRentFee() {
		return rentFee;
	}

	public void setRentFee(int rentFee) {
		this.rentFee = rentFee;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getRentPeople() {
		return rentPeople;
	}

	public void setRentPeople(String rentPeople) {
		this.rentPeople = rentPeople;
	}

	@Override
	public String toString() {
		return "EquipmentInfo [id=" + id + ", site=" + site + ", name=" + name + ", num=" + num + ", buyDate=" + buyDate
				+ ", produceDate=" + produceDate + ", inspectionDate=" + inspectionDate + ", inspectionTime="
				+ inspectionTime + ", equipmentManager=" + equipmentManager + ", trainningTeacher=" + trainningTeacher
				+ ", state=" + state + ", rentFee=" + rentFee + ", rentDate=" + rentDate + ", returnDate=" + returnDate
				+ ", rentPeople=" + rentPeople + "]";
	}
}
