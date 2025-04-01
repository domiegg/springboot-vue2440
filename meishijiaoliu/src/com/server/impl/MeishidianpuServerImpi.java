package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.MeishidianpuMapper;
import com.entity.Meishidianpu;
import com.server.MeishidianpuServer;
@Service
public class MeishidianpuServerImpi implements MeishidianpuServer {
   @Resource
   private MeishidianpuMapper gdao;
	@Override
	public int add(Meishidianpu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Meishidianpu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Meishidianpu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Meishidianpu> getsymeishidianpu1(Map<String, Object> map) {
		return gdao.getsymeishidianpu1(map);
	}
	public List<Meishidianpu> getsymeishidianpu2(Map<String, Object> map) {
		return gdao.getsymeishidianpu2(map);
	}
	public List<Meishidianpu> getsymeishidianpu3(Map<String, Object> map) {
		return gdao.getsymeishidianpu3(map);
	}
	
	@Override
	public Meishidianpu quchongMeishidianpu(Map<String, Object> account) {
		return gdao.quchongMeishidianpu(account);
	}

	@Override
	public List<Meishidianpu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Meishidianpu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Meishidianpu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

