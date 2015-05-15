package com.sdngeeks.snapshot.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "SNAPSHOT")
@DynamicUpdate(true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Snapshot implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "IS_GOLDEN_CONFIG")
	private Boolean goldenConfig;

	@OneToMany(mappedBy = "snapshot", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<SnapshotFlows> flows = new HashSet<SnapshotFlows>();

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getGoldenConfig() {
		return goldenConfig;
	}

	public void setGoldenConfig(Boolean goldenConfig) {
		this.goldenConfig = goldenConfig;
	}

	public Set<SnapshotFlows> getFlows() {
		return flows;
	}

	public void setFlows(Set<SnapshotFlows> flows) {
		this.flows = flows;
	}

}
