package com.sdngeeks.snapshot.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.sdngeeks.snapshot.base.intf.BaseDao;
import com.sdngeeks.snapshot.models.SnapshotUser;

public class DetailsService implements UserDetailsService {

	private static final transient Log LOG = LogFactory
			.getLog(DetailsService.class);

	@Autowired
	private BaseDao baseDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		boolean isEnabled = true;

		LOG.error("Username logging in -- " + arg0);
		SnapshotUser userDetails = (SnapshotUser) baseDao.getByPrimaryKey(
				SnapshotUser.class, arg0);

		if (userDetails != null) {
			LOG.info("User first name being fetched: "
					+ userDetails.getFullname());
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("Administrator"));

			return new User(userDetails.getUsername(),
					userDetails.getPassword(), isEnabled, accountNonExpired,
					credentialsNonExpired, accountNonLocked, authorities);
		} else {
			LOG.error("User not found");
			return null;
		}
	}
}
