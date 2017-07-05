package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.common.ExportController;
import com.demo.entity.DemoEntity;
import com.demo.service.DemoService;
import com.demo.util.export.XlsExporter;

import io.swagger.annotations.Api;

@Controller
@RequestMapping(value = "/login", method = RequestMethod.POST)
@Api(value = "exportDemo2", description = "用户相关api")
public class ExportDemo2 extends ExportController{
	
	@Autowired
	DemoService demoService;
	
	/**
	 * 导出告警过滤规则
	 * 
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/exportAlarmFilter", method = RequestMethod.GET)
	public void exportAlarmFilter(HttpServletRequest request, HttpServletResponse response) {
		String title = "告警过滤规则";
		String[] headsName = { "过滤名称", "创建人", "创建时间", "备注", "是否基于站点", "站点ID列表", "区域列表", "告警名称", "告警级别", "设备类型编号",
				"告警产生起始时间", "告警产生结束时间", "告警消除起始时间", "告警消除结束时间" };
		String[] properiesName = { "name", "creator", "tCreate", "remarks", "siteBased", "siteId", "tierCode",
				"alarmName", "alarmLevel", "deviceTypeCode", "tReportStart", "tReportEnd", "tRecoverStart",
				"tRecoverEnd" };
		final String uniqueCode = "";
		export(response, new XlsExporter.DataRetriver() {
			public List retrive(int start, int limit) {
				DemoEntity entity = new DemoEntity();
				List<DemoEntity> demoList =demoService.find(entity);
				return demoList;
			}
		}, properiesName, headsName, DemoEntity.class, title);
	}
	
	@RequestMapping(value = "/loginsubmit.do", method = RequestMethod.GET)
	public ModelAndView loginsubmit(HttpServletRequest request, HttpServletResponse response) {
		String title = "告警过滤规则";
		System.out.println("登录成功!:"+title);
		ModelAndView mav = new ModelAndView("redirect:/res/index2.jsp");
		return mav;
	}
	
}
