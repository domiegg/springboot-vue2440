package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Dachulaila;

public interface DachulailaServer {

  public int add(Dachulaila po);

  public int update(Dachulaila po);
  
  
  
  public int delete(int id);

  public List<Dachulaila> getAll(Map<String,Object> map);
  public List<Dachulaila> getsydachulaila1(Map<String,Object> map);
  public List<Dachulaila> getsydachulaila2(Map<String,Object> map);
  public List<Dachulaila> getsydachulaila3(Map<String,Object> map);
  public Dachulaila quchongDachulaila(Map<String, Object> acount);

  public Dachulaila getById( int id);

  public List<Dachulaila> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Dachulaila> select(Map<String, Object> map);
}
//	所有List
