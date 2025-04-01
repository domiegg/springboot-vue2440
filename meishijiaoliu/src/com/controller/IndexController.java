package com.controller;

import java.io.File;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.entity.Xinwentongzhi;
import com.entity.Yonghuzhuce;
import com.entity.Meishidianpu;import com.entity.Shequmeishi;import com.entity.Dachulaila;//jixacxishxu1

import com.server.XinwentongzhiServer;
import com.server.YonghuzhuceServer;
import com.server.MeishidianpuServer;import com.server.ShequmeishiServer;import com.server.DachulailaServer;//jixacxishxu2

import com.util.PageBean;

@Controller
public class IndexController {
	
	
	@Resource
	private XinwentongzhiServer xinwentongzhiService;
	@Resource
	private YonghuzhuceServer yonghuzhuceServer;
	@Resource	private MeishidianpuServer meishidianpuServer;	@Resource	private ShequmeishiServer shequmeishiServer;	@Resource	private DachulailaServer dachulailaServer;	//jixacxishxu3
	
	
	
//	首页显示内容
	@RequestMapping("index.do")
	public String showIndex(ModelMap map){

		List<Xinwentongzhi> syxinwentongzhi1=xinwentongzhiService.getsyxinwentongzhi1(null);
		List<Xinwentongzhi> syxinwentongzhi2=xinwentongzhiService.getsyxinwentongzhi2(null);
		List<Xinwentongzhi> syxinwentongzhi3=xinwentongzhiService.getsyxinwentongzhi3(null);

		List<Yonghuzhuce> syyonghuzhuce1=yonghuzhuceServer.getsyyonghuzhuce1(null);
		List<Meishidianpu> symeishidianpu1=meishidianpuServer.getsymeishidianpu1(null);		List<Meishidianpu> symeishidianpu2=meishidianpuServer.getsymeishidianpu2(null);		List<Meishidianpu> symeishidianpu3=meishidianpuServer.getsymeishidianpu3(null);		List<Shequmeishi> syshequmeishi1=shequmeishiServer.getsyshequmeishi1(null);		List<Shequmeishi> syshequmeishi2=shequmeishiServer.getsyshequmeishi2(null);		List<Shequmeishi> syshequmeishi3=shequmeishiServer.getsyshequmeishi3(null);		List<Dachulaila> sydachulaila1=dachulailaServer.getsydachulaila1(null);		List<Dachulaila> sydachulaila2=dachulailaServer.getsydachulaila2(null);		List<Dachulaila> sydachulaila3=dachulailaServer.getsydachulaila3(null);		//jixacxishxu4
		
	    map.put("syxinwentongzhi1", syxinwentongzhi1);
	    map.put("syxinwentongzhi2", syxinwentongzhi2);
	    map.put("syxinwentongzhi3", syxinwentongzhi3);
	    map.put("syyonghuzhuce1", syyonghuzhuce1);
	    map.put("symeishidianpu1", symeishidianpu1);	    map.put("symeishidianpu2", symeishidianpu2);	    map.put("symeishidianpu3", symeishidianpu3);	    map.put("syshequmeishi1", syshequmeishi1);	    map.put("syshequmeishi2", syshequmeishi2);	    map.put("syshequmeishi3", syshequmeishi3);	    map.put("sydachulaila1", sydachulaila1);	    map.put("sydachulaila2", sydachulaila2);	    map.put("sydachulaila3", sydachulaila3);	    //jixacxishxu5

		return "default";
	}

	

	
}
