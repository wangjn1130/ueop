package com.ueop.sconfig.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ueop.common.pojo.UEOPResult;
import com.ueop.common.util.ExceptionUtil;
import com.ueop.sconfig.service.WidgetService;

@Controller
public class PageController extends BaseController{
	@Autowired
	private WidgetService widgetService;
	
	@RequestMapping("/ueop/{pageid}/edit")
	@ResponseBody
	private UEOPResult edit(Long pageid){
		try {
			//1.请求信息获取
			System.out.println(session());
			//2.用户权限校验
			//3.获取用户组件列表
			UEOPResult widgets = widgetService.getAllWidget();
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("widgets",widgets.getData());
			
			return UEOPResult.ok(data);
		} catch (Exception e) {
			return UEOPResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
