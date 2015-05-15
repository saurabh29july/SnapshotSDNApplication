package com.sdngeeks.snapshot.service.intf;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sdngeeks.snapshot.models.SnapshotUser;

@Path("/user")
public interface UserService {

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SnapshotUser update(SnapshotUser user);

	@GET
	@Path("/getLoggedInUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SnapshotUser getLoggedInUser();

	@GET
	@Path("/get/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SnapshotUser get(@PathParam("username") String username);

}
