/**
 * 
 */
package com.djh.test;

/**
 * @author Jun_dan
 *
 */
public class Student {
	private int flowId;
	private String myType;
	private String idCard;
	private String examCard;
	private String studentName;
	private String location;
	private int grade;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int flowId, String myType, String idCard, String examCard,
			String studentName, String location, int grade) {
		super();
		this.flowId = flowId;
		this.myType = myType;
		this.idCard = idCard;
		this.examCard = examCard;
		this.studentName = studentName;
		this.location = location;
		this.grade = grade;
	}

	public String getMyType() {
		return myType;
	}
	public void setMyType(String myType) {
		this.myType = myType;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getExamCard() {
		return examCard;
	}
	public void setExamCard(String examCard) {
		this.examCard = examCard;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getFlowId() {
		return flowId;
	}
	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
