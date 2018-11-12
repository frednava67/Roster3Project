package com.freddo.roster3project.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 1, max = 200)
	private String fname;
	@Size(min = 1, max = 200)
	private String lname;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@JsonManagedReference	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "courses_students", 
        joinColumns = @JoinColumn(name = "student_id"), 
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;	

	public Student() {
	}
	public Student(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}

	// other getters and setters removed for brevity
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public Long getId() {
		return id;
	}
}