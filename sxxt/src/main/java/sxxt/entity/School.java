package sxxt.entity;

public class School {
private int id;
private String name;
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
@Override
public String toString() {
	return "School [id=" + id + ", name=" + name + "]";
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
