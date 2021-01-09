package cn.edu.jsu.mx.vo;

public class Xm {
private String xmm;
private String jf;
private String fzr;
private String id;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Xm(){}
public Xm(String xmm,String jf,String fzr,String id){
	this.xmm=xmm;
	this.jf=jf;
	this.fzr=fzr;
	this.id=id;
}
public String getXmm() {
	return xmm;
}
public void setXmm(String xmm) {
	this.xmm = xmm;
}
public String getJf() {
	return jf;
}
public void setJf(String jf) {
	this.jf = jf;
}
public String getFzr() {
	return fzr;
}
public void setFzr(String fzr) {
	this.fzr = fzr;
}
public String toString(){
	return xmm+"  "+id+"  "+fzr+"  "+jf;
	
}
}
