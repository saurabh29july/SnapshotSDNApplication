package com.sdngeeks.snapshot.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "SETTINGS")
@DynamicUpdate(true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Settings implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SETTINGS_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "SDN_CONTROLLER_IP")
	private String sdnControllerIp;

	@Column(name = "SDN_CONTROLLER_USERNAME")
	private String sdnControllerUsername;

	@Column(name = "SDN_CONTROLLER_PASSWORD")
	private String sdnControllerPassword;

	@Column(name = "SNAPSHOT_FLOWS")
	private String snapshotFlows;

	@Column(name = "SNAPSHOT_CONFIG")
	private String snapshotConfig;

	@Column(name = "SNAPSHOT_TOPOLOGY")
	private String snapshotTopology;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSdnControllerIp() {
		return sdnControllerIp;
	}

	public void setSdnControllerIp(String sdnControllerIp) {
		this.sdnControllerIp = sdnControllerIp;
	}

	public String getSdnControllerUsername() {
		return sdnControllerUsername;
	}

	public void setSdnControllerUsername(String sdnControllerUsername) {
		this.sdnControllerUsername = sdnControllerUsername;
	}

	public String getSdnControllerPassword() {
		return sdnControllerPassword;
	}

	public void setSdnControllerPassword(String sdnControllerPassword) {
		this.sdnControllerPassword = sdnControllerPassword;
	}

	public String getSnapshotFlows() {
		return snapshotFlows;
	}

	public void setSnapshotFlows(String snapshotFlows) {
		this.snapshotFlows = snapshotFlows;
	}

	public String getSnapshotConfig() {
		return snapshotConfig;
	}

	public void setSnapshotConfig(String snapshotConfig) {
		this.snapshotConfig = snapshotConfig;
	}

	public String getSnapshotTopology() {
		return snapshotTopology;
	}

	public void setSnapshotTopology(String snapshotTopology) {
		this.snapshotTopology = snapshotTopology;
	}

	@Override
	public String toString() {
		return "Settings [id=" + id + ", sdnControllerIp=" + sdnControllerIp
				+ ", sdnControllerUsername=" + sdnControllerUsername
				+ ", sdnControllerPassword=" + sdnControllerPassword
				+ ", snapshotFlows=" + snapshotFlows + ", snapshotConfig="
				+ snapshotConfig + ", snapshotTopology=" + snapshotTopology
				+ "]";
	}

}
