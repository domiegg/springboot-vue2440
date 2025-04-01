package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Dachulaila;
import com.server.DachulailaServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class DachulailaController {
	@Resource
	private DachulailaServer dachulailaService;


   
	@RequestMapping("addDachulaila.do")
	public String addDachulaila(HttpServletRequest request,Dachulaila dachulaila,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		dachulaila.setAddtime(time.toString().substring(0, 19));
		dachulailaService.add(dachulaila);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "dachulailaList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:dachulailaList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateDachulaila.do")
	public String doUpdateDachulaila(int id,ModelMap map,Dachulaila dachulaila){
		dachulaila=dachulailaService.getById(id);
		map.put("dachulaila", dachulaila);
		return "dachulaila_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("dachulailaDetail.do")
	public String dachulailaDetail(int id,ModelMap map,Dachulaila dachulaila){
		dachulaila=dachulailaService.getById(id);
		map.put("dachulaila", dachulaila);
		return "dachulaila_detail";
	}
//	前台详细
	@RequestMapping("dcllDetail.do")
	public String dcllDetail(int id,ModelMap map,Dachulaila dachulaila){
		dachulaila=dachulailaService.getById(id);
		map.put("dachulaila", dachulaila);
		return "dachulailadetail";
	}
//	
	@RequestMapping("updateDachulaila.do")
	public String updateDachulaila(int id,ModelMap map,Dachulaila dachulaila,HttpServletRequest request,HttpSession session){
		dachulailaService.update(dachulaila);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:dachulailaList.do";
	}

//	分页查询
	@RequestMapping("dachulailaList.do")
	public String dachulailaList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dachulaila dachulaila, String bianhao, String caiming, String zhutu, String caixi, String tese, String xiangqing, String yonghuming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(caiming==null||caiming.equals("")){pmap.put("caiming", null);}else{pmap.put("caiming", caiming);}		if(zhutu==null||zhutu.equals("")){pmap.put("zhutu", null);}else{pmap.put("zhutu", zhutu);}		if(caixi==null||caixi.equals("")){pmap.put("caixi", null);}else{pmap.put("caixi", caixi);}		if(tese==null||tese.equals("")){pmap.put("tese", null);}else{pmap.put("tese", tese);}		if(xiangqing==null||xiangqing.equals("")){pmap.put("xiangqing", null);}else{pmap.put("xiangqing", xiangqing);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		
		int total=dachulailaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dachulaila> list=dachulailaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dachulaila_list";
	}
	
	@RequestMapping("dachulailaList2.do")
	public String dachulailaList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dachulaila dachulaila, String bianhao, String caiming, String zhutu, String caixi, String tese, String xiangqing, String yonghuming, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("yonghuming", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(caiming==null||caiming.equals("")){pmap.put("caiming", null);}else{pmap.put("caiming", caiming);}		if(zhutu==null||zhutu.equals("")){pmap.put("zhutu", null);}else{pmap.put("zhutu", zhutu);}		if(caixi==null||caixi.equals("")){pmap.put("caixi", null);}else{pmap.put("caixi", caixi);}		if(tese==null||tese.equals("")){pmap.put("tese", null);}else{pmap.put("tese", tese);}		if(xiangqing==null||xiangqing.equals("")){pmap.put("xiangqing", null);}else{pmap.put("xiangqing", xiangqing);}		
		
		int total=dachulailaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dachulaila> list=dachulailaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dachulaila_list2";
	}	
	
	@RequestMapping("dcllList.do")
	public String dcllList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dachulaila dachulaila, String bianhao, String caiming, String zhutu, String caixi, String tese, String xiangqing, String yonghuming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(caiming==null||caiming.equals("")){pmap.put("caiming", null);}else{pmap.put("caiming", caiming);}		if(zhutu==null||zhutu.equals("")){pmap.put("zhutu", null);}else{pmap.put("zhutu", zhutu);}		if(caixi==null||caixi.equals("")){pmap.put("caixi", null);}else{pmap.put("caixi", caixi);}		if(tese==null||tese.equals("")){pmap.put("tese", null);}else{pmap.put("tese", tese);}		if(xiangqing==null||xiangqing.equals("")){pmap.put("xiangqing", null);}else{pmap.put("xiangqing", xiangqing);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		
		int total=dachulailaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dachulaila> list=dachulailaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dachulailalist";
	}
	
	@RequestMapping("deleteDachulaila.do")
	public String deleteDachulaila(int id,HttpServletRequest request){
		dachulailaService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:dachulailaList.do";
	}
	
	
}
