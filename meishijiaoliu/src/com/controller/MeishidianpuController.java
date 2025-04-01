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

import com.entity.Meishidianpu;
import com.server.MeishidianpuServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class MeishidianpuController {
	@Resource
	private MeishidianpuServer meishidianpuService;


   
	@RequestMapping("addMeishidianpu.do")
	public String addMeishidianpu(HttpServletRequest request,Meishidianpu meishidianpu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		meishidianpu.setAddtime(time.toString().substring(0, 19));
		meishidianpuService.add(meishidianpu);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "meishidianpuList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:meishidianpuList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateMeishidianpu.do")
	public String doUpdateMeishidianpu(int id,ModelMap map,Meishidianpu meishidianpu){
		meishidianpu=meishidianpuService.getById(id);
		map.put("meishidianpu", meishidianpu);
		return "meishidianpu_updt";
	}
	
	@RequestMapping("doUpdateMeishidianpu2.do")
	public String doUpdateMeishidianpu2(ModelMap map,Meishidianpu meishidianpu,HttpServletRequest request){
		meishidianpu=meishidianpuService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("meishidianpu", meishidianpu);
		return "meishidianpu_updt2";
	}
	
@RequestMapping("updateMeishidianpu2.do")
	public String updateMeishidianpu2(int id,ModelMap map,Meishidianpu meishidianpu){
		meishidianpuService.update(meishidianpu);
		return "redirect:doUpdateMeishidianpu2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("meishidianpuDetail.do")
	public String meishidianpuDetail(int id,ModelMap map,Meishidianpu meishidianpu){
		meishidianpu=meishidianpuService.getById(id);
		map.put("meishidianpu", meishidianpu);
		return "meishidianpu_detail";
	}
//	前台详细
	@RequestMapping("msdpDetail.do")
	public String msdpDetail(int id,ModelMap map,Meishidianpu meishidianpu){
		meishidianpu=meishidianpuService.getById(id);
		map.put("meishidianpu", meishidianpu);
		return "meishidianpudetail";
	}
//	
	@RequestMapping("updateMeishidianpu.do")
	public String updateMeishidianpu(int id,ModelMap map,Meishidianpu meishidianpu,HttpServletRequest request,HttpSession session){
		meishidianpuService.update(meishidianpu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:meishidianpuList.do";
	}

//	分页查询
	@RequestMapping("meishidianpuList.do")
	public String meishidianpuList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Meishidianpu meishidianpu, String yonghuming, String mima, String dianming, String dianzhao, String zhuying, String lianxiren, String lianxidianhua, String dianpudizhi, String zigezhengming, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(dianming==null||dianming.equals("")){pmap.put("dianming", null);}else{pmap.put("dianming", dianming);}
		if(dianzhao==null||dianzhao.equals("")){pmap.put("dianzhao", null);}else{pmap.put("dianzhao", dianzhao);}
		if(zhuying==null||zhuying.equals("")){pmap.put("zhuying", null);}else{pmap.put("zhuying", zhuying);}
		if(lianxiren==null||lianxiren.equals("")){pmap.put("lianxiren", null);}else{pmap.put("lianxiren", lianxiren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dianpudizhi==null||dianpudizhi.equals("")){pmap.put("dianpudizhi", null);}else{pmap.put("dianpudizhi", dianpudizhi);}
		if(zigezhengming==null||zigezhengming.equals("")){pmap.put("zigezhengming", null);}else{pmap.put("zigezhengming", zigezhengming);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=meishidianpuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Meishidianpu> list=meishidianpuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "meishidianpu_list";
	}
	
	
	
	@RequestMapping("msdpList.do")
	public String msdpList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Meishidianpu meishidianpu, String yonghuming, String mima, String dianming, String dianzhao, String zhuying, String lianxiren, String lianxidianhua, String dianpudizhi, String zigezhengming, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(dianming==null||dianming.equals("")){pmap.put("dianming", null);}else{pmap.put("dianming", dianming);}
		if(dianzhao==null||dianzhao.equals("")){pmap.put("dianzhao", null);}else{pmap.put("dianzhao", dianzhao);}
		if(zhuying==null||zhuying.equals("")){pmap.put("zhuying", null);}else{pmap.put("zhuying", zhuying);}
		if(lianxiren==null||lianxiren.equals("")){pmap.put("lianxiren", null);}else{pmap.put("lianxiren", lianxiren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dianpudizhi==null||dianpudizhi.equals("")){pmap.put("dianpudizhi", null);}else{pmap.put("dianpudizhi", dianpudizhi);}
		if(zigezhengming==null||zigezhengming.equals("")){pmap.put("zigezhengming", null);}else{pmap.put("zigezhengming", zigezhengming);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=meishidianpuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Meishidianpu> list=meishidianpuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "meishidianpulisttp";
	}
	
	@RequestMapping("deleteMeishidianpu.do")
	public String deleteMeishidianpu(int id,HttpServletRequest request){
		meishidianpuService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:meishidianpuList.do";
	}
	
	@RequestMapping("quchongMeishidianpu.do")
	public void quchongMeishidianpu(Meishidianpu meishidianpu,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yonghuming", meishidianpu.getYonghuming());
		   System.out.println("yonghuming==="+meishidianpu.getYonghuming());
		   System.out.println("yonghuming222==="+meishidianpuService.quchongMeishidianpu(map));
		   JSONObject obj=new JSONObject();
		   if(meishidianpuService.quchongMeishidianpu(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "用户名可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
