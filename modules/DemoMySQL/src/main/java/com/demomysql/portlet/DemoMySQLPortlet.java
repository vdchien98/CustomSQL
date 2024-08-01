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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
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
	
	public void OpenExxcel(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ServiceContext serviceContext = new ServiceContext();
      System.out.println("da va dc day ---- ");
      
      
      
      List<Pet> petsList = PetLocalServiceUtil.getPets(-1, -1);

   			// Khởi tạo workbook và tạo một sheet mới
   			HSSFWorkbook workbook = new HSSFWorkbook();
   			HSSFSheet sheet = workbook.createSheet("Pet123s");

   			// Tạo hàng header
   			HSSFRow headerRow = sheet.createRow(0);
   			headerRow.createCell(0).setCellValue("ID");
   			headerRow.createCell(1).setCellValue("Name");
   			// Thêm các cột khác nếu cần

   			
   			HSSFCellStyle headerCellStyle = workbook.createCellStyle();

   			// Tạo một font mới và thiết lập font chữ và màu
   			HSSFFont headerFont = workbook.createFont();
   			headerFont.setFontName("Times New Roman");
   			headerFont.setFontHeightInPoints((short) 12);
   			headerFont.setColor(IndexedColors.ORANGE.getIndex());
   			headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD); // hoặc headerFont.setBold(true);

   			// Áp dụng font vào CellStyle
   			headerCellStyle.setFont(headerFont);

   			// Thiết lập màu nền cho CellStyle
   			headerCellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex()); // Yellow là một lựa chọn gần giống với màu của btn-warning
   			headerCellStyle.setFillPattern((short) FillPatternType.SOLID_FOREGROUND.ordinal());

   			// Áp dụng CellStyle vào các ô trong hàng header
   			for (int i = 0; i < headerRow.getLastCellNum(); i++) {
   			    headerRow.getCell(i).setCellStyle(headerCellStyle);
   			}
   			
   			
   			
   			
   			
   			System.out.println("petsList ----- "+ petsList);
   			
   			// Lặp qua danh sách pets và tạo hàng cho mỗi pet
   			int rowNum = 1; // Bắt đầu từ hàng thứ nhất, vì hàng đầu tiên đã là header
   			for (Pet pet : petsList) {
   				HSSFRow row = sheet.createRow(rowNum++);
   				row.createCell(0).setCellValue(pet.getPid());
   				row.createCell(1).setCellValue(pet.getPname());
   				// Thêm dữ liệu cho các cột khác nếu cần
   			}

   			// Lưu workbook vào một file Excel có tên là pet5555555s
   			//String filename = "C:\\Users\\User\\Downloads\\pets.xls";
   			   
   			long timestamp = System.currentTimeMillis();
   			String tenfile = "BaoCao - "+ Long.toString(timestamp) ;
   			String baseFilePath = "D:\\CustomSQL\\liferay-ce-portal-tomcat-7.4.3.42-ga42-20220913145951615\\liferay-ce-portal-7.4.3.42-ga42\\excel\\";
   			String extension = ".xls";
   			String filename = baseFilePath + tenfile + extension;
   			try (FileOutputStream fileOut = new FileOutputStream(filename)) {
   				workbook.write(fileOut);
   				System.out.println("Excel file has been generated successfully.");
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
      
      
 
		// lấy file từ server về  và download về có tên là pet5555555s
      String baseFilePathServer = "D:\\CustomSQL\\liferay-ce-portal-tomcat-7.4.3.42-ga42-20220913145951615\\liferay-ce-portal-7.4.3.42-ga42\\excel\\";
      String filePath = baseFilePathServer + tenfile + extension;
      File file = new File(filePath);

      // Kiểm tra nếu file tồn tại
      if (!file.exists()) {
          throw new IOException("File not found: " + filePath);
      }

      // Thiết lập phản hồi HTTP để tải xuống file
      HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
      httpResponse.setContentType("application/vnd.ms-excel");
      httpResponse.setHeader("Content-Disposition", "attachment; filename=" + tenfile + extension);
      httpResponse.setContentLength((int) file.length());

      // Ghi nội dung file vào phản hồi HTTP
      try (FileInputStream inputStream = new FileInputStream(file);
           OutputStream outputStream = httpResponse.getOutputStream()) {
          byte[] buffer = new byte[4096];
          int bytesRead;
          while ((bytesRead = inputStream.read(buffer)) != -1) {
              outputStream.write(buffer, 0, bytesRead);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
      
      
      response.sendRedirect("/");
      
      
      
      
	
	}

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
//      đây là đoạn test lấy custom sql
//		List<Pet> Danhsach = PetLocalServiceUtil.getPetsByName("Chiến");
//		System.out.println("Danhsach ===== " + Danhsach);

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		List<Pet> usersList = PetLocalServiceUtil.getPets(-1, -1);
		httpServletRequest.setAttribute("usersList", usersList);

		
		// Tạo 1 file Excel 
		
		
	     
	      
	      
	   
		

		super.render(renderRequest, renderResponse);
	}

}