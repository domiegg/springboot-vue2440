package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shequmeishi;

public interface ShequmeishiServer {

  public int add(Shequmeishi po);

  public int update(Shequmeishi po);
  
  
  
  public int delete(int id);

  public List<Shequmeishi> getAll(Map<String,Object> map);
  public List<Shequmeishi> getsyshequmeishi1(Map<String,Object> map);
  public List<Shequmeishi> getsyshequmeishi2(Map<String,Object> map);
  public List<Shequmeishi> getsyshequmeishi3(Map<String,Object> map);
  public Shequmeishi quchongShequmeishi(Map<String, Object> acount);

  public Shequmeishi getById( int id);

  public List<Shequmeishi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shequmeishi> select(Map<String, Object> map);
}
//	所有List
