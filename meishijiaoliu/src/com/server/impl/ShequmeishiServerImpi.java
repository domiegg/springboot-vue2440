package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShequmeishiMapper;
import com.entity.Shequmeishi;
import com.server.ShequmeishiServer;
@Service
public class ShequmeishiServerImpi implements ShequmeishiServer {
   @Resource
   private ShequmeishiMapper gdao;
	@Override
	public int add(Shequmeishi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shequmeishi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shequmeishi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shequmeishi> getsyshequmeishi1(Map<String, Object> map) {
		return gdao.getsyshequmeishi1(map);
	}
	public List<Shequmeishi> getsyshequmeishi2(Map<String, Object> map) {
		return gdao.getsyshequmeishi2(map);
	}
	public List<Shequmeishi> getsyshequmeishi3(Map<String, Object> map) {
		return gdao.getsyshequmeishi3(map);
	}
	
	@Override
	public Shequmeishi quchongShequmeishi(Map<String, Object> account) {
		return gdao.quchongShequmeishi(account);
	}

	@Override
	public List<Shequmeishi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shequmeishi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shequmeishi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

