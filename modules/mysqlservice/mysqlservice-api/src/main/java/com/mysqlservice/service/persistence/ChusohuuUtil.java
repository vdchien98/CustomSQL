/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mysqlservice.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mysqlservice.model.Chusohuu;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the chusohuu service. This utility wraps <code>com.mysqlservice.service.persistence.impl.ChusohuuPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChusohuuPersistence
 * @generated
 */
public class ChusohuuUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Chusohuu chusohuu) {
		getPersistence().clearCache(chusohuu);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Chusohuu> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Chusohuu> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Chusohuu> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Chusohuu> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Chusohuu> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Chusohuu update(Chusohuu chusohuu) {
		return getPersistence().update(chusohuu);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Chusohuu update(
		Chusohuu chusohuu, ServiceContext serviceContext) {

		return getPersistence().update(chusohuu, serviceContext);
	}

	/**
	 * Caches the chusohuu in the entity cache if it is enabled.
	 *
	 * @param chusohuu the chusohuu
	 */
	public static void cacheResult(Chusohuu chusohuu) {
		getPersistence().cacheResult(chusohuu);
	}

	/**
	 * Caches the chusohuus in the entity cache if it is enabled.
	 *
	 * @param chusohuus the chusohuus
	 */
	public static void cacheResult(List<Chusohuu> chusohuus) {
		getPersistence().cacheResult(chusohuus);
	}

	/**
	 * Creates a new chusohuu with the primary key. Does not add the chusohuu to the database.
	 *
	 * @param pid the primary key for the new chusohuu
	 * @return the new chusohuu
	 */
	public static Chusohuu create(int pid) {
		return getPersistence().create(pid);
	}

	/**
	 * Removes the chusohuu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pid the primary key of the chusohuu
	 * @return the chusohuu that was removed
	 * @throws NoSuchChusohuuException if a chusohuu with the primary key could not be found
	 */
	public static Chusohuu remove(int pid)
		throws com.mysqlservice.exception.NoSuchChusohuuException {

		return getPersistence().remove(pid);
	}

	public static Chusohuu updateImpl(Chusohuu chusohuu) {
		return getPersistence().updateImpl(chusohuu);
	}

	/**
	 * Returns the chusohuu with the primary key or throws a <code>NoSuchChusohuuException</code> if it could not be found.
	 *
	 * @param pid the primary key of the chusohuu
	 * @return the chusohuu
	 * @throws NoSuchChusohuuException if a chusohuu with the primary key could not be found
	 */
	public static Chusohuu findByPrimaryKey(int pid)
		throws com.mysqlservice.exception.NoSuchChusohuuException {

		return getPersistence().findByPrimaryKey(pid);
	}

	/**
	 * Returns the chusohuu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pid the primary key of the chusohuu
	 * @return the chusohuu, or <code>null</code> if a chusohuu with the primary key could not be found
	 */
	public static Chusohuu fetchByPrimaryKey(int pid) {
		return getPersistence().fetchByPrimaryKey(pid);
	}

	/**
	 * Returns all the chusohuus.
	 *
	 * @return the chusohuus
	 */
	public static List<Chusohuu> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the chusohuus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChusohuuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chusohuus
	 * @param end the upper bound of the range of chusohuus (not inclusive)
	 * @return the range of chusohuus
	 */
	public static List<Chusohuu> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the chusohuus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChusohuuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chusohuus
	 * @param end the upper bound of the range of chusohuus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chusohuus
	 */
	public static List<Chusohuu> findAll(
		int start, int end, OrderByComparator<Chusohuu> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chusohuus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChusohuuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chusohuus
	 * @param end the upper bound of the range of chusohuus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of chusohuus
	 */
	public static List<Chusohuu> findAll(
		int start, int end, OrderByComparator<Chusohuu> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the chusohuus from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of chusohuus.
	 *
	 * @return the number of chusohuus
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChusohuuPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ChusohuuPersistence _persistence;

}