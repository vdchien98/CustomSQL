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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;Mysql_Chusohuu&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Chusohuu
 * @generated
 */
public class ChusohuuTable extends BaseTable<ChusohuuTable> {

	public static final ChusohuuTable INSTANCE = new ChusohuuTable();

	public final Column<ChusohuuTable, Integer> pid = createColumn(
		"pid", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<ChusohuuTable, String> pchusohuu = createColumn(
		"pchusohuu", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ChusohuuTable, Integer> pthunuoi = createColumn(
		"pthunuoi", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private ChusohuuTable() {
		super("Mysql_Chusohuu", ChusohuuTable::new);
	}

}