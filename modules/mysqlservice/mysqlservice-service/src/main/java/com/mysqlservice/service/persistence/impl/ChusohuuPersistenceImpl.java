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

package com.mysqlservice.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import com.mysqlservice.exception.NoSuchChusohuuException;
import com.mysqlservice.model.Chusohuu;
import com.mysqlservice.model.ChusohuuTable;
import com.mysqlservice.model.impl.ChusohuuImpl;
import com.mysqlservice.model.impl.ChusohuuModelImpl;
import com.mysqlservice.service.persistence.ChusohuuPersistence;
import com.mysqlservice.service.persistence.ChusohuuUtil;
import com.mysqlservice.service.persistence.impl.constants.MysqlPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the chusohuu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ChusohuuPersistence.class, BasePersistence.class})
public class ChusohuuPersistenceImpl
	extends BasePersistenceImpl<Chusohuu> implements ChusohuuPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChusohuuUtil</code> to access the chusohuu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChusohuuImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ChusohuuPersistenceImpl() {
		setModelClass(Chusohuu.class);

		setModelImplClass(ChusohuuImpl.class);
		setModelPKClass(int.class);

		setTable(ChusohuuTable.INSTANCE);
	}

	/**
	 * Caches the chusohuu in the entity cache if it is enabled.
	 *
	 * @param chusohuu the chusohuu
	 */
	@Override
	public void cacheResult(Chusohuu chusohuu) {
		entityCache.putResult(
			ChusohuuImpl.class, chusohuu.getPrimaryKey(), chusohuu);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the chusohuus in the entity cache if it is enabled.
	 *
	 * @param chusohuus the chusohuus
	 */
	@Override
	public void cacheResult(List<Chusohuu> chusohuus) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (chusohuus.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Chusohuu chusohuu : chusohuus) {
			if (entityCache.getResult(
					ChusohuuImpl.class, chusohuu.getPrimaryKey()) == null) {

				cacheResult(chusohuu);
			}
		}
	}

	/**
	 * Clears the cache for all chusohuus.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChusohuuImpl.class);

		finderCache.clearCache(ChusohuuImpl.class);
	}

	/**
	 * Clears the cache for the chusohuu.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Chusohuu chusohuu) {
		entityCache.removeResult(ChusohuuImpl.class, chusohuu);
	}

	@Override
	public void clearCache(List<Chusohuu> chusohuus) {
		for (Chusohuu chusohuu : chusohuus) {
			entityCache.removeResult(ChusohuuImpl.class, chusohuu);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ChusohuuImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ChusohuuImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new chusohuu with the primary key. Does not add the chusohuu to the database.
	 *
	 * @param pid the primary key for the new chusohuu
	 * @return the new chusohuu
	 */
	@Override
	public Chusohuu create(int pid) {
		Chusohuu chusohuu = new ChusohuuImpl();

		chusohuu.setNew(true);
		chusohuu.setPrimaryKey(pid);

		return chusohuu;
	}

	/**
	 * Removes the chusohuu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pid the primary key of the chusohuu
	 * @return the chusohuu that was removed
	 * @throws NoSuchChusohuuException if a chusohuu with the primary key could not be found
	 */
	@Override
	public Chusohuu remove(int pid) throws NoSuchChusohuuException {
		return remove((Serializable)pid);
	}

	/**
	 * Removes the chusohuu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chusohuu
	 * @return the chusohuu that was removed
	 * @throws NoSuchChusohuuException if a chusohuu with the primary key could not be found
	 */
	@Override
	public Chusohuu remove(Serializable primaryKey)
		throws NoSuchChusohuuException {

		Session session = null;

		try {
			session = openSession();

			Chusohuu chusohuu = (Chusohuu)session.get(
				ChusohuuImpl.class, primaryKey);

			if (chusohuu == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChusohuuException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(chusohuu);
		}
		catch (NoSuchChusohuuException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Chusohuu removeImpl(Chusohuu chusohuu) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chusohuu)) {
				chusohuu = (Chusohuu)session.get(
					ChusohuuImpl.class, chusohuu.getPrimaryKeyObj());
			}

			if (chusohuu != null) {
				session.delete(chusohuu);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (chusohuu != null) {
			clearCache(chusohuu);
		}

		return chusohuu;
	}

	@Override
	public Chusohuu updateImpl(Chusohuu chusohuu) {
		boolean isNew = chusohuu.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(chusohuu);
			}
			else {
				chusohuu = (Chusohuu)session.merge(chusohuu);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ChusohuuImpl.class, chusohuu, false, true);

		if (isNew) {
			chusohuu.setNew(false);
		}

		chusohuu.resetOriginalValues();

		return chusohuu;
	}

	/**
	 * Returns the chusohuu with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chusohuu
	 * @return the chusohuu
	 * @throws NoSuchChusohuuException if a chusohuu with the primary key could not be found
	 */
	@Override
	public Chusohuu findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChusohuuException {

		Chusohuu chusohuu = fetchByPrimaryKey(primaryKey);

		if (chusohuu == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChusohuuException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return chusohuu;
	}

	/**
	 * Returns the chusohuu with the primary key or throws a <code>NoSuchChusohuuException</code> if it could not be found.
	 *
	 * @param pid the primary key of the chusohuu
	 * @return the chusohuu
	 * @throws NoSuchChusohuuException if a chusohuu with the primary key could not be found
	 */
	@Override
	public Chusohuu findByPrimaryKey(int pid) throws NoSuchChusohuuException {
		return findByPrimaryKey((Serializable)pid);
	}

	/**
	 * Returns the chusohuu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pid the primary key of the chusohuu
	 * @return the chusohuu, or <code>null</code> if a chusohuu with the primary key could not be found
	 */
	@Override
	public Chusohuu fetchByPrimaryKey(int pid) {
		return fetchByPrimaryKey((Serializable)pid);
	}

	/**
	 * Returns all the chusohuus.
	 *
	 * @return the chusohuus
	 */
	@Override
	public List<Chusohuu> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Chusohuu> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Chusohuu> findAll(
		int start, int end, OrderByComparator<Chusohuu> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Chusohuu> findAll(
		int start, int end, OrderByComparator<Chusohuu> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Chusohuu> list = null;

		if (useFinderCache) {
			list = (List<Chusohuu>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHUSOHUU);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHUSOHUU;

				sql = sql.concat(ChusohuuModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Chusohuu>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the chusohuus from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Chusohuu chusohuu : findAll()) {
			remove(chusohuu);
		}
	}

	/**
	 * Returns the number of chusohuus.
	 *
	 * @return the number of chusohuus
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHUSOHUU);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "pid";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CHUSOHUU;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChusohuuModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the chusohuu persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setChusohuuUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setChusohuuUtilPersistence(null);

		entityCache.removeCache(ChusohuuImpl.class.getName());
	}

	private void _setChusohuuUtilPersistence(
		ChusohuuPersistence chusohuuPersistence) {

		try {
			Field field = ChusohuuUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, chusohuuPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MysqlPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MysqlPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MysqlPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CHUSOHUU =
		"SELECT chusohuu FROM Chusohuu chusohuu";

	private static final String _SQL_COUNT_CHUSOHUU =
		"SELECT COUNT(chusohuu) FROM Chusohuu chusohuu";

	private static final String _ORDER_BY_ENTITY_ALIAS = "chusohuu.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Chusohuu exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ChusohuuPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ChusohuuModelArgumentsResolver _chusohuuModelArgumentsResolver;

}