package sxxt.entity;

public class TaskClassRelationship {

	private int id;
	private TrainningTask trainningTask;
	private Class className;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TrainningTask getTrainningTask() {
		return trainningTask;
	}

	public void setTrainningTask(TrainningTask trainningTask) {
		this.trainningTask = trainningTask;
	}

	public Class getClassName() {
		return className;
	}

	public void setClassName(Class className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "TaskClassRelationship [id=" + id + ", trainningTask=" + trainningTask + ", className=" + className
				+ "]";
	}

}
