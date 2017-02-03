package sxxt.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReportAndSummary {

	private int id;
	private String selfComment;
	private Student student;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date writeDate;
	private String teacherComment;
	private TrainningTeacher trainningTeacher;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date commentDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSelfComment() {
		return selfComment;
	}

	public void setSelfComment(String selfComment) {
		this.selfComment = selfComment;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getTeacherComment() {
		return teacherComment;
	}

	public void setTeacherComment(String teacherComment) {
		this.teacherComment = teacherComment;
	}

	public TrainningTeacher getTrainningTeacher() {
		return trainningTeacher;
	}

	public void setTrainningTeacher(TrainningTeacher trainningTeacher) {
		this.trainningTeacher = trainningTeacher;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "ReportAndSummary [id=" + id + ", selfComment=" + selfComment + ", student=" + student + ", writeDate="
				+ writeDate + ", teacherComment=" + teacherComment + ", trainningTeacher=" + trainningTeacher
				+ ", commentDate=" + commentDate + "]";
	}

}
