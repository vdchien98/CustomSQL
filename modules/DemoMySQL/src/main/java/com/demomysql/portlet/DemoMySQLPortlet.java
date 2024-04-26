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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
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
	
		
	
		
		  try {
	            // Declare file name to be created
	            String filename = "C:\\Users\\User\\Downloads\\excel\\sample.xls";

	            // Creating an instance of HSSFWorkbook class
	            HSSFWorkbook workbook = new HSSFWorkbook();

	            // Invoking createSheet() method and passing the name of the sheet to be created
	            HSSFSheet sheet = workbook.createSheet("January");

	            // Creating the 0th row using the createRow() method
	            HSSFRow rowhead = sheet.createRow((short) 0);

	            // Creating cells by using the createCell() method and setting the values to the cells by using the setCellValue() method
	            rowhead.createCell(0).setCellValue("S.No.");
	            rowhead.createCell(1).setCellValue("Customer Name");
	            rowhead.createCell(2).setCellValue("Account Number");
	            rowhead.createCell(3).setCellValue("e-mail");
	            rowhead.createCell(4).setCellValue("Balance");

	            // Creating the 1st row
	            HSSFRow row = sheet.createRow((short) 1);

	            // Inserting data in the first row
	            row.createCell(0).setCellValue("1");
	            row.createCell(1).setCellValue("John William");
	            row.createCell(2).setCellValue("9999999");
	            row.createCell(3).setCellValue("william.john@gmail.com");
	            row.createCell(4).setCellValue("700000.00");

	            // Creating the 2nd row
	            HSSFRow row1 = sheet.createRow((short) 2);

	            // Inserting data in the second row
	            row1.createCell(0).setCellValue("2");
	            row1.createCell(1).setCellValue("Mathew Parker");
	            row1.createCell(2).setCellValue("22222222");
	            row1.createCell(3).setCellValue("parker.mathew@gmail.com");
	            row1.createCell(4).setCellValue("200000.00");

	            // Creating FileOutputStream to write data into file
	            FileOutputStream fileOut = new FileOutputStream(filename);

	            // Writing data into the workbook
	            workbook.write(fileOut);

	            // Closing the FileOutputStream
	            fileOut.close();

	            // Prints the message on the console
	            System.out.println("Excel file has been generated successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
		
		super.render(renderRequest, renderResponse);
	}

}