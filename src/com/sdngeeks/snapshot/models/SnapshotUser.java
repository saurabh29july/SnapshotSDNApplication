package com.sdngeeks.snapshot.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "SNAPSHOT_USER")
@DynamicUpdate(true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SnapshotUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/** The email. */
	@Id
	@Column(name = "Username", unique = true, nullable = false)
	private String username;

	/** The fullname. */
	@Column(name = "FULLNAME", nullable = false)
	private String fullname;

	/** The password. */
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	/** The question. */
	@Column(name = "SECURITY_QUESTION")
	private String securityQuestion;

	/** The answer. */
	@Column(name = "SECURITY_ANSWER")
	private String securityAnswer;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

}
