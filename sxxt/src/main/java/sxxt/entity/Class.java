package sxxt.entity;

public class Class {
private int id;
private String name;
private Major major;
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
public Major getMajor() {
	return major;
}
public void setMajor(Major major) {
	this.major = major;
}
@Override
public String toString() {
	return "Class [id=" + id + ", name=" + name + ", major=" + major + "]";
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
