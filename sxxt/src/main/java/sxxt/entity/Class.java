package sxxt.entity;

public class Class {
private int id;
private String name;
private Major major;
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

}
