package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shequmeishi;

public interface ShequmeishiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shequmeishi record);

    int insertSelective(Shequmeishi record);

    Shequmeishi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shequmeishi record);
	
    int updateByPrimaryKey(Shequmeishi record);
	public Shequmeishi quchongShequmeishi(Map<String, Object> yonghuming);
	public List<Shequmeishi> getAll(Map<String, Object> map);
	public List<Shequmeishi> getsyshequmeishi1(Map<String, Object> map);
	public List<Shequmeishi> getsyshequmeishi3(Map<String, Object> map);
	public List<Shequmeishi> getsyshequmeishi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shequmeishi> getByPage(Map<String, Object> map);
	public List<Shequmeishi> select(Map<String, Object> map);
//	所有List
}

