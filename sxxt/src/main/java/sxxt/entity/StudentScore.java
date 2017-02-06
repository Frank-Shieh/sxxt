package sxxt.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StudentScore {

	private int id;
	private Class classId;
	private Student student;
	private TrainningTeacher trainningTeacher;
	private double inducingAbility;
	private double planExecute;
	private double designImplement;
	private double skillLearning;
	private double teamAbility;
	private double professionalism;
	private double writingLevel;
	private double totalScore;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date scoreDate;
	private int state;
	private double avgScore;

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

	public double getInducingAbility() {
		return inducingAbility;
	}

	public void setInducingAbility(double inducingAbility) {
		this.inducingAbility = inducingAbility;
	}

	public double getPlanExecute() {
		return planExecute;
	}

	public void setPlanExecute(double planExecute) {
		this.planExecute = planExecute;
	}

	public double getDesignImplement() {
		return designImplement;
	}

	public void setDesignImplement(double designImplement) {
		this.designImplement = designImplement;
	}

	public double getSkillLearning() {
		return skillLearning;
	}

	public void setSkillLearning(double skillLearning) {
		this.skillLearning = skillLearning;
	}

	public double getTeamAbility() {
		return teamAbility;
	}

	public void setTeamAbility(double teamAbility) {
		this.teamAbility = teamAbility;
	}

	public double getProfessionalism() {
		return professionalism;
	}

	public void setProfessionalism(double professionalism) {
		this.professionalism = professionalism;
	}

	public double getWritingLevel() {
		return writingLevel;
	}

	public void setWritingLevel(double writingLevel) {
		this.writingLevel = writingLevel;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
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

	@Override
	public String toString() {
		return "StudentScore [id=" + id + ", classId=" + classId + ", student=" + student + ", trainningTeacher="
				+ trainningTeacher + ", inducingAbility=" + inducingAbility + ", planExecute=" + planExecute
				+ ", designImplement=" + designImplement + ", skillLearning=" + skillLearning + ", teamAbility="
				+ teamAbility + ", professionalism=" + professionalism + ", writingLevel=" + writingLevel
				+ ", totalScore=" + totalScore + ", scoreDate=" + scoreDate + ", state=" + state + "]";
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
