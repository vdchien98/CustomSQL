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

package com.mysqlservice.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Chusohuu}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Chusohuu
 * @generated
 */
public class ChusohuuWrapper
	extends BaseModelWrapper<Chusohuu>
	implements Chusohuu, ModelWrapper<Chusohuu> {

	public ChusohuuWrapper(Chusohuu chusohuu) {
		super(chusohuu);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pid", getPid());
		attributes.put("pchusohuu", getPchusohuu());
		attributes.put("pthunuoi", getPthunuoi());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer pid = (Integer)attributes.get("pid");

		if (pid != null) {
			setPid(pid);
		}

		String pchusohuu = (String)attributes.get("pchusohuu");

		if (pchusohuu != null) {
			setPchusohuu(pchusohuu);
		}

		Integer pthunuoi = (Integer)attributes.get("pthunuoi");

		if (pthunuoi != null) {
			setPthunuoi(pthunuoi);
		}
	}

	@Override
	public Chusohuu cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the pchusohuu of this chusohuu.
	 *
	 * @return the pchusohuu of this chusohuu
	 */
	@Override
	public String getPchusohuu() {
		return model.getPchusohuu();
	}

	/**
	 * Returns the pid of this chusohuu.
	 *
	 * @return the pid of this chusohuu
	 */
	@Override
	public int getPid() {
		return model.getPid();
	}

	/**
	 * Returns the primary key of this chusohuu.
	 *
	 * @return the primary key of this chusohuu
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the pthunuoi of this chusohuu.
	 *
	 * @return the pthunuoi of this chusohuu
	 */
	@Override
	public int getPthunuoi() {
		return model.getPthunuoi();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the pchusohuu of this chusohuu.
	 *
	 * @param pchusohuu the pchusohuu of this chusohuu
	 */
	@Override
	public void setPchusohuu(String pchusohuu) {
		model.setPchusohuu(pchusohuu);
	}

	/**
	 * Sets the pid of this chusohuu.
	 *
	 * @param pid the pid of this chusohuu
	 */
	@Override
	public void setPid(int pid) {
		model.setPid(pid);
	}

	/**
	 * Sets the primary key of this chusohuu.
	 *
	 * @param primaryKey the primary key of this chusohuu
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the pthunuoi of this chusohuu.
	 *
	 * @param pthunuoi the pthunuoi of this chusohuu
	 */
	@Override
	public void setPthunuoi(int pthunuoi) {
		model.setPthunuoi(pthunuoi);
	}

	@Override
	protected ChusohuuWrapper wrap(Chusohuu chusohuu) {
		return new ChusohuuWrapper(chusohuu);
	}

}