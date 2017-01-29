package sxxt.entity;

public class TaskTeacherRelationship {

	private int id;
	private TeachingTask teachingTask;
	private TrainningTeacher trainningTeacher;
	private int remindState;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TeachingTask getTeachingTask() {
		return teachingTask;
	}

	public void setTeachingTask(TeachingTask teachingTask) {
		this.teachingTask = teachingTask;
	}

	public TrainningTeacher getTrainningTeacher() {
		return trainningTeacher;
	}

	public void setTrainningTeacher(TrainningTeacher trainningTeacher) {
		this.trainningTeacher = trainningTeacher;
	}

	public int getRemindState() {
		return remindState;
	}

	public void setRemindState(int remindState) {
		this.remindState = remindState;
	}

	@Override
	public String toString() {
		return "TaskTeacherRelationship [id=" + id + ", teachingTask=" + teachingTask + ", trainningTeacher="
				+ trainningTeacher + ", remindState=" + remindState + "]";
	}

}
