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

package com.mysqlservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ChusohuuLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChusohuuLocalService
 * @generated
 */
public class ChusohuuLocalServiceWrapper
	implements ChusohuuLocalService, ServiceWrapper<ChusohuuLocalService> {

	public ChusohuuLocalServiceWrapper() {
		this(null);
	}

	public ChusohuuLocalServiceWrapper(
		ChusohuuLocalService chusohuuLocalService) {

		_chusohuuLocalService = chusohuuLocalService;
	}

	/**
	 * Adds the chusohuu to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChusohuuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chusohuu the chusohuu
	 * @return the chusohuu that was added
	 */
	@Override
	public com.mysqlservice.model.Chusohuu addChusohuu(
		com.mysqlservice.model.Chusohuu chusohuu) {

		return _chusohuuLocalService.addChusohuu(chusohuu);
	}

	/**
	 * Creates a new chusohuu with the primary key. Does not add the chusohuu to the database.
	 *
	 * @param pid the primary key for the new chusohuu
	 * @return the new chusohuu
	 */
	@Override
	public com.mysqlservice.model.Chusohuu createChusohuu(int pid) {
		return _chusohuuLocalService.createChusohuu(pid);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chusohuuLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the chusohuu from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChusohuuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chusohuu the chusohuu
	 * @return the chusohuu that was removed
	 */
	@Override
	public com.mysqlservice.model.Chusohuu deleteChusohuu(
		com.mysqlservice.model.Chusohuu chusohuu) {

		return _chusohuuLocalService.deleteChusohuu(chusohuu);
	}

	/**
	 * Deletes the chusohuu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChusohuuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pid the primary key of the chusohuu
	 * @return the chusohuu that was removed
	 * @throws PortalException if a chusohuu with the primary key could not be found
	 */
	@Override
	public com.mysqlservice.model.Chusohuu deleteChusohuu(int pid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chusohuuLocalService.deleteChusohuu(pid);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chusohuuLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _chusohuuLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _chusohuuLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _chusohuuLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _chusohuuLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mysqlservice.model.impl.ChusohuuModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _chusohuuLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mysqlservice.model.impl.ChusohuuModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _chusohuuLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _chusohuuLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _chusohuuLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mysqlservice.model.Chusohuu fetchChusohuu(int pid) {
		return _chusohuuLocalService.fetchChusohuu(pid);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _chusohuuLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the chusohuu with the primary key.
	 *
	 * @param pid the primary key of the chusohuu
	 * @return the chusohuu
	 * @throws PortalException if a chusohuu with the primary key could not be found
	 */
	@Override
	public com.mysqlservice.model.Chusohuu getChusohuu(int pid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chusohuuLocalService.getChusohuu(pid);
	}

	/**
	 * Returns a range of all the chusohuus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mysqlservice.model.impl.ChusohuuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chusohuus
	 * @param end the upper bound of the range of chusohuus (not inclusive)
	 * @return the range of chusohuus
	 */
	@Override
	public java.util.List<com.mysqlservice.model.Chusohuu> getChusohuus(
		int start, int end) {

		return _chusohuuLocalService.getChusohuus(start, end);
	}

	/**
	 * Returns the number of chusohuus.
	 *
	 * @return the number of chusohuus
	 */
	@Override
	public int getChusohuusCount() {
		return _chusohuuLocalService.getChusohuusCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _chusohuuLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chusohuuLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chusohuuLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the chusohuu in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChusohuuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chusohuu the chusohuu
	 * @return the chusohuu that was updated
	 */
	@Override
	public com.mysqlservice.model.Chusohuu updateChusohuu(
		com.mysqlservice.model.Chusohuu chusohuu) {

		return _chusohuuLocalService.updateChusohuu(chusohuu);
	}

	@Override
	public ChusohuuLocalService getWrappedService() {
		return _chusohuuLocalService;
	}

	@Override
	public void setWrappedService(ChusohuuLocalService chusohuuLocalService) {
		_chusohuuLocalService = chusohuuLocalService;
	}

	private ChusohuuLocalService _chusohuuLocalService;

}