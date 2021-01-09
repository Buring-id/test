package cn.edu.jsu.mx.vo;

public class gly {
	private String xm;
	private String xb;
	private String zh;
	private String mm;
	private String nl;
	public gly(){}
	public gly(String xm,String xb,String nl,String zh,String mm){
		this.xm=xm;
		this.xb=xb;
		this.nl=nl;
		this.zh=zh;
		this.mm=mm;
	}
	public String getXm() {
		return xm;
	}
	public  void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getNl() {
		return nl;
	}
	public void setNl(String nl) {
		this.nl = nl;
	}	
public String toString(){
	return "姓名="+xm+"性别="+xb+"年龄="+nl+"账号="+zh+"密码="+mm;
}	
public static void main(String[] args){
	
}
}
