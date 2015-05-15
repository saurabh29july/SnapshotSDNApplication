package com.sdngeeks.snapshot.service.intf;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sdngeeks.snapshot.dto.SnapshotList;
import com.sdngeeks.snapshot.models.Snapshot;

@Path("/snapshot")
public interface SnapshotService {

	@POST
	@Path("/take")
	@Produces(MediaType.APPLICATION_JSON)
	public Snapshot takeSnapshot();

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public SnapshotList getSnapshots();

	@GET
	@Path("/details/{snapshotId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Snapshot getDetails(@PathParam("snapshotId") String id);

	@DELETE
	@Path("/delete/{snapshotId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean delete(@PathParam("snapshotId") String id);

	@GET
	@Path("/goldenConfigToggle/{snapshotId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean goldenConfigToggle(@PathParam("snapshotId") String id);

}
