package sxxt.entity;

public class ClassTeacherRelationship {

	private int id;
	private Class classId;
	private TrainningTeacher trainningTeacher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Class getClassId() {
		return classId;
	}

	public void setClassId(Class classId) {
		this.classId = classId;
	}

	public TrainningTeacher getTrainningTeacher() {
		return trainningTeacher;
	}

	public void setTrainningTeacher(TrainningTeacher trainningTeacher) {
		this.trainningTeacher = trainningTeacher;
	}

	@Override
	public String toString() {
		return "ClassTeacherRelationship [id=" + id + ", classId=" + classId + ", trainningTeacher=" + trainningTeacher
				+ "]";
	}

}
