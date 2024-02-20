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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mysqlservice.exception.NoSuchChusohuuException;
import com.mysqlservice.model.Chusohuu;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the chusohuu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChusohuuUtil
 * @generated
 */
@ProviderType
public interface ChusohuuPersistence extends BasePersistence<Chusohuu> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChusohuuUtil} to access the chusohuu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the chusohuu in the entity cache if it is enabled.
	 *
	 * @param chusohuu the chusohuu
	 */
	public void cacheResult(Chusohuu chusohuu);

	/**
	 * Caches the chusohuus in the entity cache if it is enabled.
	 *
	 * @param chusohuus the chusohuus
	 */
	public void cacheResult(java.util.List<Chusohuu> chusohuus);

	/**
	 * Creates a new chusohuu with the primary key. Does not add the chusohuu to the database.
	 *
	 * @param pid the primary key for the new chusohuu
	 * @return the new chusohuu
	 */
	public Chusohuu create(int pid);

	/**
	 * Removes the chusohuu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pid the primary key of the chusohuu
	 * @return the chusohuu that was removed
	 * @throws NoSuchChusohuuException if a chusohuu with the primary key could not be found
	 */
	public Chusohuu remove(int pid) throws NoSuchChusohuuException;

	public Chusohuu updateImpl(Chusohuu chusohuu);

	/**
	 * Returns the chusohuu with the primary key or throws a <code>NoSuchChusohuuException</code> if it could not be found.
	 *
	 * @param pid the primary key of the chusohuu
	 * @return the chusohuu
	 * @throws NoSuchChusohuuException if a chusohuu with the primary key could not be found
	 */
	public Chusohuu findByPrimaryKey(int pid) throws NoSuchChusohuuException;

	/**
	 * Returns the chusohuu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pid the primary key of the chusohuu
	 * @return the chusohuu, or <code>null</code> if a chusohuu with the primary key could not be found
	 */
	public Chusohuu fetchByPrimaryKey(int pid);

	/**
	 * Returns all the chusohuus.
	 *
	 * @return the chusohuus
	 */
	public java.util.List<Chusohuu> findAll();

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
	public java.util.List<Chusohuu> findAll(int start, int end);

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
	public java.util.List<Chusohuu> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Chusohuu>
			orderByComparator);

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
	public java.util.List<Chusohuu> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Chusohuu>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the chusohuus from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of chusohuus.
	 *
	 * @return the number of chusohuus
	 */
	public int countAll();

}