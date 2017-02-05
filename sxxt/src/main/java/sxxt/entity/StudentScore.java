package sxxt.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StudentScore {

	private int id;
	private Class classId;
	private Student student;
	private TrainningTeacher trainningTeacher;
	private int inducingAbility;
	private int planExecute;
	private int designImplement;
	private int skillLearning;
	private int teamAbility;
	private int professionalism;
	private int writingLevel;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date scoreDate;
	private int state;

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

	public int getInducingAbility() {
		return inducingAbility;
	}

	public void setInducingAbility(int inducingAbility) {
		this.inducingAbility = inducingAbility;
	}

	public int getPlanExecute() {
		return planExecute;
	}

	public void setPlanExecute(int planExecute) {
		this.planExecute = planExecute;
	}

	public int getDesignImplement() {
		return designImplement;
	}

	public void setDesignImplement(int designImplement) {
		this.designImplement = designImplement;
	}

	public int getSkillLearning() {
		return skillLearning;
	}

	public void setSkillLearning(int skillLearning) {
		this.skillLearning = skillLearning;
	}

	public int getTeamAbility() {
		return teamAbility;
	}

	public void setTeamAbility(int teamAbility) {
		this.teamAbility = teamAbility;
	}

	public int getProfessionalism() {
		return professionalism;
	}

	public void setProfessionalism(int professionalism) {
		this.professionalism = professionalism;
	}

	public int getWritingLevel() {
		return writingLevel;
	}

	public void setWritingLevel(int writing_level) {
		this.writingLevel = writing_level;
	}

	public Date getScoreDate() {
		return scoreDate;
	}

	public void setScoreDate(Date scoreDate) {
		this.scoreDate = scoreDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Class getClassId() {
		return classId;
	}

	public void setClassId(Class classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "StudentScore [id=" + id + ", classId=" + classId + ", student=" + student + ", trainningTeacher="
				+ trainningTeacher + ", inducingAbility=" + inducingAbility + ", planExecute=" + planExecute
				+ ", designImplement=" + designImplement + ", skillLearning=" + skillLearning + ", teamAbility="
				+ teamAbility + ", professionalism=" + professionalism + ", writingLevel=" + writingLevel
				+ ", scoreDate=" + scoreDate + ", state=" + state + "]";
	}

}
