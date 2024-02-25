package com.demomysql.portlet;

import com.demomysql.constants.DemoMySQLPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.mysqlservice.model.Pet;
import com.mysqlservice.service.PetLocalServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DemoMySQL", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + DemoMySQLPortletKeys.DEMOMYSQL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DemoMySQLPortlet extends MVCPortlet {

//	public void saveChucVu(ActionRequest request, ActionResponse response) throws IOException, PortletException {
//		System.out.println("da vào dc day ===== ");
//		response.sendRedirect("/home");
//
//	}

	public void addPet(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ServiceContext serviceContext = new ServiceContext();
		
		try {
			String name = ParamUtil.getString(request, "name");
			PetLocalServiceUtil.addName(name, serviceContext);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
//      đây là đoạn test lấy custom sql
//		List<Pet> Danhsach = PetLocalServiceUtil.getPetsByName("Chiến");
//		System.out.println("Danhsach ===== " + Danhsach);

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		List<Pet> usersList = PetLocalServiceUtil.getPets(-1, -1);
		httpServletRequest.setAttribute("usersList", usersList);
		super.render(renderRequest, renderResponse);
	}


}