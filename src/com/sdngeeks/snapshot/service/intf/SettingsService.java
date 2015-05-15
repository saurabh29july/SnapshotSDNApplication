package com.sdngeeks.snapshot.service.intf;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sdngeeks.snapshot.models.Settings;

@Path("/settings")
public interface SettingsService {

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Settings saveSettings(Settings settingsDto);

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Settings getSettings();

}
