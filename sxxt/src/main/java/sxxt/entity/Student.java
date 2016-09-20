package sxxt.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student {
private int id;
private String code;
private String name;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date birthDate;
private int sex;//1为男 ,0为女
private int age;
private String studentPhone;
private String familyAddress;
private String parentName;
private String parentPhone;
private String password;
private Role role;
/*private Site site;*/
private Class classId;
private School school;
private int state;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getBirthDate() {
	return birthDate;
}
public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}
public int getSex() {
	return sex;
}
public void setSex(int sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getStudentPhone() {
	return studentPhone;
}
public void setStudentPhone(String studentPhone) {
	this.studentPhone = studentPhone;
}
public String getFamilyAddress() {
	return familyAddress;
}
public void setFamilyAddress(String familyAddress) {
	this.familyAddress = familyAddress;
}
public String getParentName() {
	return parentName;
}
public void setParentName(String parentName) {
	this.parentName = parentName;
}
public String getParentPhone() {
	return parentPhone;
}
public void setParentPhone(String parentPhone) {
	this.parentPhone = parentPhone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public Class getClassId() {
	return classId;
}
public void setClassId(Class classId) {
	this.classId = classId;
}
public School getSchool() {
	return school;
}
public void setSchool(School school) {
	this.school = school;
}
@Override
public String toString() {
	return "Student [id=" + id + ", code=" + code + ", name=" + name + ", birthDate=" + birthDate + ", sex=" + sex
			+ ", age=" + age + ", studentPhone=" + studentPhone + ", familyAddress=" + familyAddress + ", parentName="
			+ parentName + ", parentPhone=" + parentPhone + ", password=" + password + ", role=" + role + ", classId="
			+ classId + ", school=" + school + "]";
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}

}
