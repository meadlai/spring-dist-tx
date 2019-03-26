package com.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="teacher_id", unique = true)
	private int id;
	
	@Column(name="teacher_name", nullable = false)
	private String name;
	
	@Column(name="teacher_age", nullable = false)
	private int age;

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
