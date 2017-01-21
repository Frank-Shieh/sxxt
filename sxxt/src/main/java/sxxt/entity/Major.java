package sxxt.entity;

public class Major {
private int id;
private String name;
private School school;
private int state;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public School getSchool() {
	return school;
}
public void setSchool(School school) {
	this.school = school;
}
@Override
public String toString() {
	return "Major [id=" + id + ", name=" + name + ", school=" + school + "]";
}
/**
 * @return the state
 */
public int getState() {
	return state;
}
/**
 * @param state the state to set
 */
public void setState(int state) {
	this.state = state;
}

}
