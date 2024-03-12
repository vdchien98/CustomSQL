package com.liferay.docs.demobangchamcong.portlet.portlet;

import com.liferay.docs.demobangchamcong.portlet.constants.DemoBangChamCongPortletKeys;
import com.liferay.portal.kernel.management.jmx.SetAttributeAction;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.jsp.jstl.core.LoopTag;

import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DemoBangChamCong", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DemoBangChamCongPortletKeys.DEMOBANGCHAMCONG,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DemoBangChamCongPortlet extends MVCPortlet {

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

//		/LocalDate ngayHienTai = LocalDate.now();
		LocalDate ngayHienTai = LocalDate.of(2024, 5, 6);
		System.out.println("ngayHienTai " + ngayHienTai);
		int thang = ngayHienTai.getMonthValue();
		int nam = ngayHienTai.getYear();
		int songaytrongthang = ngayHienTai.lengthOfMonth();
		LocalDate ngayDauTienCuaThang = ngayHienTai.withDayOfMonth(1);
		DayOfWeek thuMay = ngayDauTienCuaThang.getDayOfWeek();

		System.out.println("nam " + nam);
		System.out.println("thang " + thang);
		System.out.println("ngayDauTienCuaThang " + ngayDauTienCuaThang);
		System.out.println("thuMay " + thuMay);
		System.out.println("songaytrongthang " + songaytrongthang);

		List<LocalDate> danhSachNgayTrongThang = new ArrayList<>();
		for (int i = 1; i <= songaytrongthang; i++) {
			danhSachNgayTrongThang.add(LocalDate.of(ngayHienTai.getYear(), ngayHienTai.getMonth(), i));
		}

		// In danh sách ngày trong tháng
		for (LocalDate NgayTrongThang : danhSachNgayTrongThang) {
			int ngaytrongThangNay = NgayTrongThang.getDayOfMonth();
			int currentIdx = danhSachNgayTrongThang.indexOf(NgayTrongThang) + 1;
			DayOfWeek dayOfWeek = getDayOfWeek(NgayTrongThang);
			System.out.println("ngaytrongThangNay " + "mung " + currentIdx + " - " + "Thu " + dayOfWeek);
		}
		int ngaydautien = 0;
		if (thuMay == DayOfWeek.MONDAY) {
			ngaydautien = 2;
		} else if (thuMay == DayOfWeek.TUESDAY) {
			ngaydautien = 3;
		} else if (thuMay == DayOfWeek.WEDNESDAY) {
			ngaydautien = 4;
		} else if (thuMay == DayOfWeek.THURSDAY) {
			ngaydautien = 5;
		} else if (thuMay == DayOfWeek.FRIDAY) {
			ngaydautien = 6;
		} else if (thuMay == DayOfWeek.SATURDAY) {
			ngaydautien = 7;
		} else if (thuMay == DayOfWeek.SUNDAY) {
			ngaydautien = 8;
		}
		System.out.println("ThuDauTiencuaThang " + ngaydautien);
		renderRequest.setAttribute("ThuDauTiencuaThang", ngaydautien);
		
		
		int soLuongNull = ngaydautien-2;
		List<LocalDate> danhSachNgayTrongThangMoi = new ArrayList<>();
        for (int i = 0; i < soLuongNull; i++) {
            danhSachNgayTrongThangMoi.add(null);
            System.out.println("da vao dc day ------ ");
        }
        danhSachNgayTrongThangMoi.addAll(danhSachNgayTrongThang);

		
        System.out.println("danhSachNgayTrongThang --- " + danhSachNgayTrongThang);
		System.out.println("danhSachNgayTrongThang --- " + danhSachNgayTrongThangMoi);
		renderRequest.setAttribute("danhSachNgayTrongThang", danhSachNgayTrongThangMoi);

		super.render(renderRequest, renderResponse);
	}

	public static DayOfWeek getDayOfWeek(LocalDate date) {
		return date.getDayOfWeek();
	}
}