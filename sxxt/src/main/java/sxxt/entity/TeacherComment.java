package sxxt.entity;

public class TeacherComment {
	int id;
	Class classId;
	public Class getClassId() {
		return classId;
	}

	public void setClassId(Class classId) {
		this.classId = classId;
	}

	Student student;
	TrainningTeacher trainningTeacher;
	String content;
	int workHard;
	int teachingLevel;
	int theoryActual;
	int homeworkNum;
	int totalScore;
	int state;
	private double avgScore;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public TrainningTeacher getTrainningTeacher() {
		return trainningTeacher;
	}

	public void setTrainningTeacher(TrainningTeacher trainningTeacher) {
		this.trainningTeacher = trainningTeacher;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getWorkHard() {
		return workHard;
	}

	public void setWorkHard(int workHard) {
		this.workHard = workHard;
	}

	public int getTeachingLevel() {
		return teachingLevel;
	}

	public void setTeachingLevel(int teachingLevel) {
		this.teachingLevel = teachingLevel;
	}

	public int getTheoryActual() {
		return theoryActual;
	}

	public void setTheoryActual(int theoryActual) {
		this.theoryActual = theoryActual;
	}

	public int getHomeworkNum() {
		return homeworkNum;
	}

	public void setHomeworkNum(int homeworkNum) {
		this.homeworkNum = homeworkNum;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "TeacherComment [id=" + id + ", student=" + student + ", trainningTeacher=" + trainningTeacher
				+ ", content=" + content + ", workHard=" + workHard + ", teachingLevel=" + teachingLevel
				+ ", theoryActual=" + theoryActual + ", homeworkNum=" + homeworkNum + ", totalScore=" + totalScore
				+ ", state=" + state + "]";
	}

	/**
	 * @return the avgScore
	 */
	public double getAvgScore() {
		return avgScore;
	}

	/**
	 * @param avgScore the avgScore to set
	 */
	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

}
