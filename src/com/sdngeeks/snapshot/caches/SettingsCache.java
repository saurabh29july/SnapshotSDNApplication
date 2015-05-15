package com.sdngeeks.snapshot.caches;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sdngeeks.snapshot.models.Settings;

public class SettingsCache {

	private static final transient Log LOG = LogFactory
			.getLog(SettingsCache.class);

	private static Map<String, String> settingsCache = new HashMap<String, String>();

	public static final String SDN_CONTROLLER_IP = "SDN_CONTROLLER_IP";
	public static final String SDN_CONTROLLER_USERNAME = "SDN_CONTROLLER_USERNAME";
	public static final String SDN_CONTROLLER_PASSWORD = "SDN_CONTROLLER_PASSWORD";
	public static final String SNAPSHOT_FLOWS = "SNAPSHOT_FLOWS";
	public static final String SNAPSHOT_CONFIG = "SNAPSHOT_CONFIG";
	public static final String SNAPSHOT_TOPOLOGY = "SNAPSHOT_TOPOLOGY";

	public static void refreshCache(Settings settings) {

		LOG.info("Refreshing the complete system settings with new values");

		if (settings != null) {
			settingsCache.put(SDN_CONTROLLER_IP, settings.getSdnControllerIp());
			settingsCache.put(SDN_CONTROLLER_USERNAME,
					settings.getSdnControllerUsername());
			settingsCache.put(SDN_CONTROLLER_PASSWORD,
					settings.getSdnControllerPassword());
			settingsCache.put(SNAPSHOT_FLOWS, settings.getSnapshotFlows());
			settingsCache.put(SNAPSHOT_CONFIG, settings.getSnapshotConfig());
			settingsCache
					.put(SNAPSHOT_TOPOLOGY, settings.getSnapshotTopology());

			LOG.info("SYSTEM CACHE WORKING WITH FOLLOWING VALUES NOW:");
			LOG.info(settings.toString());

		}
	}

	public static String getSetting(String key) {
		return settingsCache.get(key);
	}

}
