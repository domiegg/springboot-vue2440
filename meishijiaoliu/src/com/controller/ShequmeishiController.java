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

import com.entity.Shequmeishi;
import com.server.ShequmeishiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShequmeishiController {
	@Resource
	private ShequmeishiServer shequmeishiService;


   
	@RequestMapping("addShequmeishi.do")
	public String addShequmeishi(HttpServletRequest request,Shequmeishi shequmeishi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shequmeishi.setAddtime(time.toString().substring(0, 19));
		shequmeishiService.add(shequmeishi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shequmeishiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shequmeishiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShequmeishi.do")
	public String doUpdateShequmeishi(int id,ModelMap map,Shequmeishi shequmeishi){
		shequmeishi=shequmeishiService.getById(id);
		map.put("shequmeishi", shequmeishi);
		return "shequmeishi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shequmeishiDetail.do")
	public String shequmeishiDetail(int id,ModelMap map,Shequmeishi shequmeishi){
		shequmeishi=shequmeishiService.getById(id);
		map.put("shequmeishi", shequmeishi);
		return "shequmeishi_detail";
	}
//	前台详细
	@RequestMapping("sqmsDetail.do")
	public String sqmsDetail(int id,ModelMap map,Shequmeishi shequmeishi){
		shequmeishi=shequmeishiService.getById(id);
		map.put("shequmeishi", shequmeishi);
		return "shequmeishidetail";
	}
//	
	@RequestMapping("updateShequmeishi.do")
	public String updateShequmeishi(int id,ModelMap map,Shequmeishi shequmeishi,HttpServletRequest request,HttpSession session){
		shequmeishiService.update(shequmeishi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shequmeishiList.do";
	}

//	分页查询
	@RequestMapping("shequmeishiList.do")
	public String shequmeishiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shequmeishi shequmeishi, String bianhao, String caiming, String zhutu, String caixi, String tese, String xiangqing, String yonghuming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(caiming==null||caiming.equals("")){pmap.put("caiming", null);}else{pmap.put("caiming", caiming);}
		if(zhutu==null||zhutu.equals("")){pmap.put("zhutu", null);}else{pmap.put("zhutu", zhutu);}
		if(caixi==null||caixi.equals("")){pmap.put("caixi", null);}else{pmap.put("caixi", caixi);}
		if(tese==null||tese.equals("")){pmap.put("tese", null);}else{pmap.put("tese", tese);}
		if(xiangqing==null||xiangqing.equals("")){pmap.put("xiangqing", null);}else{pmap.put("xiangqing", xiangqing);}
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		
		int total=shequmeishiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shequmeishi> list=shequmeishiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shequmeishi_list";
	}
	
	@RequestMapping("shequmeishiList2.do")
	public String shequmeishiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shequmeishi shequmeishi, String bianhao, String caiming, String zhutu, String caixi, String tese, String xiangqing, String yonghuming,HttpServletRequest request){
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
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(caiming==null||caiming.equals("")){pmap.put("caiming", null);}else{pmap.put("caiming", caiming);}
		if(zhutu==null||zhutu.equals("")){pmap.put("zhutu", null);}else{pmap.put("zhutu", zhutu);}
		if(caixi==null||caixi.equals("")){pmap.put("caixi", null);}else{pmap.put("caixi", caixi);}
		if(tese==null||tese.equals("")){pmap.put("tese", null);}else{pmap.put("tese", tese);}
		if(xiangqing==null||xiangqing.equals("")){pmap.put("xiangqing", null);}else{pmap.put("xiangqing", xiangqing);}
		
		
		int total=shequmeishiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shequmeishi> list=shequmeishiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shequmeishi_list2";
	}
	
	
	@RequestMapping("sqmsList.do")
	public String sqmsList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shequmeishi shequmeishi, String bianhao, String caiming, String zhutu, String caixi, String tese, String xiangqing, String yonghuming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(caiming==null||caiming.equals("")){pmap.put("caiming", null);}else{pmap.put("caiming", caiming);}
		if(zhutu==null||zhutu.equals("")){pmap.put("zhutu", null);}else{pmap.put("zhutu", zhutu);}
		if(caixi==null||caixi.equals("")){pmap.put("caixi", null);}else{pmap.put("caixi", caixi);}
		if(tese==null||tese.equals("")){pmap.put("tese", null);}else{pmap.put("tese", tese);}
		if(xiangqing==null||xiangqing.equals("")){pmap.put("xiangqing", null);}else{pmap.put("xiangqing", xiangqing);}
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		
		int total=shequmeishiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shequmeishi> list=shequmeishiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shequmeishilisttp";
	}
	
	@RequestMapping("deleteShequmeishi.do")
	public String deleteShequmeishi(int id,HttpServletRequest request){
		shequmeishiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shequmeishiList.do";
	}
	
	
}
