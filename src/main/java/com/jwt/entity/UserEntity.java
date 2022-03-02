package com.jwt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

	@JMap
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@JMap
	@Column(name = "name")
	private String name;
	
	@JMap
	@Column(name = "email")
	private String email;

	@JMap
	@Column(name = "password")
	private String password;
	
	@Column(name = "created_on")
    private Timestamp createdOn;
	
}
