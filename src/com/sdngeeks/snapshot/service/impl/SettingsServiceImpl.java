package com.sdngeeks.snapshot.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sdngeeks.snapshot.base.intf.BaseDao;
import com.sdngeeks.snapshot.caches.SettingsCache;
import com.sdngeeks.snapshot.models.Settings;
import com.sdngeeks.snapshot.service.intf.SettingsService;

@Transactional
public class SettingsServiceImpl implements SettingsService {

	private static final transient Log LOG = LogFactory
			.getLog(SettingsServiceImpl.class);

	@Autowired
	private BaseDao baseDao;

	@Override
	public Settings saveSettings(Settings settingsDto) {
		// TODO Auto-generated method stub

		LOG.info("Entered saveSettings method.");

		Settings settings = null;
		List<Settings> settingsList = (List<Settings>) baseDao
				.getList(Settings.class);

		if (settingsList != null && !settingsList.isEmpty()) {
			// Settings will always have only one row
			settings = settingsList.get(0);
		}

		boolean isUpdate = false;
		if (settings != null) {
			isUpdate = true;
			if (StringUtils.isNotEmpty(settingsDto.getSdnControllerIp())) {
				settings.setSdnControllerIp(settingsDto.getSdnControllerIp());
			}
			if (StringUtils.isNotEmpty(settingsDto.getSdnControllerUsername())) {
				settings.setSdnControllerUsername(settingsDto
						.getSdnControllerUsername());
			}
			if (StringUtils.isNotEmpty(settingsDto.getSdnControllerPassword())) {
				settings.setSdnControllerPassword(settingsDto
						.getSdnControllerPassword());
			}
			if (StringUtils.isNotEmpty(settingsDto.getSnapshotFlows())) {
				settings.setSnapshotFlows(settingsDto.getSnapshotFlows());
			}
			if (StringUtils.isNotEmpty(settingsDto.getSnapshotConfig())) {
				settings.setSnapshotConfig(settingsDto.getSnapshotConfig());
			}
			if (StringUtils.isNotEmpty(settingsDto.getSnapshotTopology())) {
				settings.setSnapshotTopology(settingsDto.getSnapshotTopology());
			}

		}

		if (isUpdate) {
			baseDao.update(settings);
		} else {
			settings = (Settings) baseDao.create(settingsDto);
		}

		// Notify Cache to update
		SettingsCache.refreshCache(settings);

		return settings;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Settings getSettings() {
		Settings settings = null;
		List<Settings> settingsList = (List<Settings>) baseDao
				.getList(Settings.class);

		if (settingsList != null && !settingsList.isEmpty()) {
			// Settings will always have only one row
			settings = settingsList.get(0);
		}

		// Notify Cache to update
		SettingsCache.refreshCache(settings);

		return settings;
	}

}
