package com.sdngeeks.snapshot.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sdngeeks.snapshot.models.Snapshot;

@XmlRootElement
public class SnapshotList {

	private List<Snapshot> snapshots = new ArrayList<Snapshot>();

	public List<Snapshot> getSnapshots() {
		return snapshots;
	}

	public void setSnapshots(List<Snapshot> snapshots) {
		this.snapshots = snapshots;
	}

}
