package com.sdngeeks.snapshot.models;

import java.io.Serializable;
import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "SNAPSHOT_FLOWS")
@DynamicUpdate(true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SnapshotFlows implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "NODE")
	private String node;

	@Column(name = "FLOW")
	private Clob flow;

	@OneToOne
	@JsonIgnore
	private Snapshot snapshot;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public Clob getFlow() {
		return flow;
	}

	public void setFlow(Clob flow) {
		this.flow = flow;
	}

	public Snapshot getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(Snapshot snapshot) {
		this.snapshot = snapshot;
	}
}
