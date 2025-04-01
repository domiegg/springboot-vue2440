package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Dachulaila;

public interface DachulailaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dachulaila record);

    int insertSelective(Dachulaila record);

    Dachulaila selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dachulaila record);
	
    int updateByPrimaryKey(Dachulaila record);
	public Dachulaila quchongDachulaila(Map<String, Object> yonghuming);
	public List<Dachulaila> getAll(Map<String, Object> map);
	public List<Dachulaila> getsydachulaila1(Map<String, Object> map);
	public List<Dachulaila> getsydachulaila3(Map<String, Object> map);
	public List<Dachulaila> getsydachulaila2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Dachulaila> getByPage(Map<String, Object> map);
	public List<Dachulaila> select(Map<String, Object> map);
//	所有List
}

