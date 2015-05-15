package com.sdngeeks.snapshot.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

import com.sdngeeks.snapshot.base.intf.BaseDao;
import com.sdngeeks.snapshot.models.SnapshotUser;
import com.sdngeeks.snapshot.service.intf.UserService;

@Transactional
public class UserServiceImpl implements UserService {

	private static final transient Log LOG = LogFactory
			.getLog(UserServiceImpl.class);

	@Autowired
	private BaseDao baseDao;

	@Override
	public SnapshotUser update(SnapshotUser user) {
		LOG.info("Update : " + user.getUsername());

		SnapshotUser userDetailObj = (SnapshotUser) baseDao.getByPrimaryKey(
				SnapshotUser.class, user.getUsername());

		if (userDetailObj != null) {
			userDetailObj.setFullname(user.getFullname());
			userDetailObj.setPassword(user.getPassword());
			userDetailObj.setSecurityQuestion(user.getSecurityQuestion());
			userDetailObj.setSecurityAnswer(user.getSecurityAnswer());
			baseDao.update(userDetailObj);
			return userDetailObj;
		}
		return null;
	}

	@Override
	public SnapshotUser getLoggedInUser() {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		return (SnapshotUser) baseDao.getByPrimaryKey(SnapshotUser.class,
				user.getUsername());
	}

	@Override
	public SnapshotUser get(String username) {
		return (SnapshotUser) baseDao.getByPrimaryKey(SnapshotUser.class,
				username);
	}

}
