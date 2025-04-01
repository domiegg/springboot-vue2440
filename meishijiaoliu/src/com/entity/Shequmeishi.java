package com.entity;

public class Shequmeishi {
    private Integer id;
	private String bianhao;	private String caiming;	private String zhutu;	private String caixi;	private String tese;	private String xiangqing;	private String yonghuming;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBianhao() {
        return bianhao;
    }
    public void setBianhao(String bianhao) {
        this.bianhao = bianhao == null ? null : bianhao.trim();
    }	public String getCaiming() {
        return caiming;
    }
    public void setCaiming(String caiming) {
        this.caiming = caiming == null ? null : caiming.trim();
    }	public String getZhutu() {
        return zhutu;
    }
    public void setZhutu(String zhutu) {
        this.zhutu = zhutu == null ? null : zhutu.trim();
    }	public String getCaixi() {
        return caixi;
    }
    public void setCaixi(String caixi) {
        this.caixi = caixi == null ? null : caixi.trim();
    }	public String getTese() {
        return tese;
    }
    public void setTese(String tese) {
        this.tese = tese == null ? null : tese.trim();
    }	public String getXiangqing() {
        return xiangqing;
    }
    public void setXiangqing(String xiangqing) {
        this.xiangqing = xiangqing == null ? null : xiangqing.trim();
    }	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
        this.yonghuming = yonghuming == null ? null : yonghuming.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
