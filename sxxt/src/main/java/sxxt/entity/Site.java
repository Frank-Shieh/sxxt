package sxxt.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Site {
	private int id;
	private String areaName;
	private String building;
	private String floor;
	private String classroomCode;
	// 场所容纳人数
	private int num;
	// state 0-已删除 1-可用 2-自身已用 3-借用 4-已出租
	private int state;
	private SiteManager siteManager;
	private TrainningTeacher trainningTeacher;
	private double rentFee;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rentDATE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;
	private Company company;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getClassroomCode() {
		return classroomCode;
	}

	public void setClassroomCode(String classroomCode) {
		this.classroomCode = classroomCode;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public SiteManager getSiteManager() {
		return siteManager;
	}

	public void setSiteManager(SiteManager siteManager) {
		this.siteManager = siteManager;
	}

	public TrainningTeacher getTrainningTeacher() {
		return trainningTeacher;
	}

	public void setTrainningTeacher(TrainningTeacher trainningTeacher) {
		this.trainningTeacher = trainningTeacher;
	}

	public double getRentFee() {
		return rentFee;
	}

	public void setRentFee(double rentFee) {
		this.rentFee = rentFee;
	}

	public Date getRentDATE() {
		return rentDATE;
	}

	public void setRentDATE(Date rentDATE) {
		this.rentDATE = rentDATE;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Site [id=" + id + ", areaName=" + areaName + ", building=" + building + ", floor=" + floor
				+ ", classroomCode=" + classroomCode + ", num=" + num + ", state=" + state + ", siteManager="
				+ siteManager + ", trainningTeacher=" + trainningTeacher + ", rentFee=" + rentFee + ", rentDATE="
				+ rentDATE + ", returnDate=" + returnDate + ", company=" + company + "]";
	}

}
