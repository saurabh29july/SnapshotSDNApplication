/**************************************************************************************************
 * Copyright Meru Networks 2014, All Rights Reserved
 **************************************************************************************************/
package com.sdngeeks.snapshot.base.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdngeeks.snapshot.base.intf.BaseDao;

/**
 * The Class BaseDaoImpl
 * 
 * Implementation class for Data Access Object.
 * 
 * @author Saurabh Agarwal
 */
public class BaseDaoImpl implements BaseDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.meru.app.central.base.intf.BaseDao#getHibernateSession()
	 */
	@Override
	public Session getHibernateSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.meru.app.central.base.intf.BaseDao#getByPrimaryKey(java.lang.Class,
	 * java.io.Serializable)
	 */
	@Override
	public Object getByPrimaryKey(Class<?> clazz, Serializable id) {
		Object result = getHibernateSession().get(clazz, id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.meru.app.central.base.intf.BaseDao#create(java.lang.Object)
	 */
	@Override
	public Object create(Object object) {
		getHibernateSession().save(object);
		getHibernateSession().flush();
		return object;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.meru.app.central.base.intf.BaseDao#update(java.lang.Object)
	 */
	@Override
	public Object update(Object object) {
		getHibernateSession().saveOrUpdate(object);
		getHibernateSession().flush();
		return object;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.meru.app.central.base.intf.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object object) {
		getHibernateSession().delete(object);
		getHibernateSession().flush();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.meru.app.central.base.intf.BaseDao#getList(java.lang.Class)
	 */
	@Override
	public List<?> getList(Class<?> clazz) {
		String className = clazz.getName();
		String query = "FROM " + className;
		List<?> result = getHibernateSession().createQuery(query).list();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.meru.app.central.base.intf.BaseDao#executeQuery(java.lang.String)
	 */
	@Override
	public List<?> executeQuery(String query) {
		List<?> result = getHibernateSession().createQuery(query).list();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.meru.app.central.base.intf.BaseDao#executeQuery(org.hibernate.Query)
	 */
	@Override
	public List<?> executeQuery(Query query) {
		List<?> result = query.list();
		return result;
	}

	@Override
	public Integer count(String query) {
		Query q = getHibernateSession().createQuery(query);
		Long count = (Long) q.uniqueResult();
		return count.intValue();
	}

	@Override
	public List<?> getPaginatedRecords(String query, int start, int pageSize) {
		Query q = getHibernateSession().createQuery(query);
		if (start > 0) {
			q.setFirstResult(start);
		} else {
			q.setFirstResult(0);
		}

		if (pageSize > 0) {
			q.setMaxResults(pageSize);
		} else {
			q.setMaxResults(10);
		}
		List<?> result = q.list();
		return result;
	}

}
