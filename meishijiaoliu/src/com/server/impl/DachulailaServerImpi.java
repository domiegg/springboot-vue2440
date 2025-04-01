package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DachulailaMapper;
import com.entity.Dachulaila;
import com.server.DachulailaServer;
@Service
public class DachulailaServerImpi implements DachulailaServer {
   @Resource
   private DachulailaMapper gdao;
	@Override
	public int add(Dachulaila po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Dachulaila po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Dachulaila> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Dachulaila> getsydachulaila1(Map<String, Object> map) {
		return gdao.getsydachulaila1(map);
	}
	public List<Dachulaila> getsydachulaila2(Map<String, Object> map) {
		return gdao.getsydachulaila2(map);
	}
	public List<Dachulaila> getsydachulaila3(Map<String, Object> map) {
		return gdao.getsydachulaila3(map);
	}
	
	@Override
	public Dachulaila quchongDachulaila(Map<String, Object> account) {
		return gdao.quchongDachulaila(account);
	}

	@Override
	public List<Dachulaila> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Dachulaila> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Dachulaila getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

