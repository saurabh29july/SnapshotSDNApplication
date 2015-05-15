/**************************************************************************************************
 * Copyright Meru Networks 2014, All Rights Reserved
 **************************************************************************************************/
package com.sdngeeks.snapshot.base.intf;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * The Interface BaseDao
 * 
 * Base Data Access Object used for all DB operations.
 * 
 * @author Saurabh Agarwal
 */
public interface BaseDao {

	/**
	 * Gets the DB object by primary key.
	 * 
	 * @param clazz
	 *            the clazz
	 * @param id
	 *            the id
	 * @return the by primary key
	 */
	public Object getByPrimaryKey(Class<?> clazz, Serializable id);

	/**
	 * Creates the object in DB.
	 * 
	 * @param object
	 *            the object
	 * @return the object
	 */
	public Object create(Object object);

	/**
	 * Update the object in DB.
	 * 
	 * @param object
	 *            the object
	 * @return the object
	 */
	public Object update(Object object);

	/**
	 * Delete the object from DB.
	 * 
	 * @param object
	 *            the object
	 */
	public void delete(Object object);

	/**
	 * Gets the list of all objects of a specified class.
	 * 
	 * @param clazz
	 *            the clazz
	 * @return the list
	 */
	public List<?> getList(Class<?> clazz);

	/**
	 * Execute HQL query.
	 * 
	 * @param query
	 *            the query
	 * @return the list
	 */
	public List<?> executeQuery(String query);

	/**
	 * Gets the Hibernate session.
	 * 
	 * @return the Hibernate session
	 */
	public Session getHibernateSession();

	/**
	 * Execute HQL query.
	 * 
	 * @param query
	 *            the query
	 * @return the list
	 */
	public List<?> executeQuery(Query query);
	
	public Integer count(String query);
	
	public List<?> getPaginatedRecords(String query, int start, int pageSize);

}
