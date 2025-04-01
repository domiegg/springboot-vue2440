package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Meishidianpu;

public interface MeishidianpuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Meishidianpu record);

    int insertSelective(Meishidianpu record);

    Meishidianpu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Meishidianpu record);
	
    int updateByPrimaryKey(Meishidianpu record);
	public Meishidianpu quchongMeishidianpu(Map<String, Object> yonghuming);
	public List<Meishidianpu> getAll(Map<String, Object> map);
	public List<Meishidianpu> getsymeishidianpu1(Map<String, Object> map);
	public List<Meishidianpu> getsymeishidianpu3(Map<String, Object> map);
	public List<Meishidianpu> getsymeishidianpu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Meishidianpu> getByPage(Map<String, Object> map);
	public List<Meishidianpu> select(Map<String, Object> map);
//	所有List
}

