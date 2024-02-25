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

package com.mysqlservice.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mysqlservice.model.Pet;
import com.mysqlservice.service.base.PetLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mysqlservice.model.Pet",
	service = AopService.class
)
public class PetLocalServiceImpl extends PetLocalServiceBaseImpl {
	
	
	// test customsql
	public List<Pet> getPetsByName(String pName){
		return petFinder.getPetsByName(pName);
	}
	public Pet addName(String name, ServiceContext serviceContext) throws PortalException, SystemException {
		    
		int IdPet = (int) counterLocalService.increment();
		Pet pet = petPersistence.create(IdPet);  
		pet.setPname(name);
		    petPersistence.update(pet);
    		return pet;
	}
	
	
	
	
}