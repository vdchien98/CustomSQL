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

package com.mysqlservice.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mysqlservice.model.Chusohuu;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Chusohuu in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChusohuuCacheModel
	implements CacheModel<Chusohuu>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChusohuuCacheModel)) {
			return false;
		}

		ChusohuuCacheModel chusohuuCacheModel = (ChusohuuCacheModel)object;

		if (pid == chusohuuCacheModel.pid) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pid);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{pid=");
		sb.append(pid);
		sb.append(", pchusohuu=");
		sb.append(pchusohuu);
		sb.append(", pthunuoi=");
		sb.append(pthunuoi);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Chusohuu toEntityModel() {
		ChusohuuImpl chusohuuImpl = new ChusohuuImpl();

		chusohuuImpl.setPid(pid);

		if (pchusohuu == null) {
			chusohuuImpl.setPchusohuu("");
		}
		else {
			chusohuuImpl.setPchusohuu(pchusohuu);
		}

		chusohuuImpl.setPthunuoi(pthunuoi);

		chusohuuImpl.resetOriginalValues();

		return chusohuuImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		pid = objectInput.readInt();
		pchusohuu = objectInput.readUTF();

		pthunuoi = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(pid);

		if (pchusohuu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pchusohuu);
		}

		objectOutput.writeInt(pthunuoi);
	}

	public int pid;
	public String pchusohuu;
	public int pthunuoi;

}