package cn.edu.jsu.mx.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TxtDao {
public static void In(String str) throws IOException {
	File file =new File("D:/课程设计：项目资金管理系统/time.txt");
	FileOutputStream fo =new FileOutputStream(file,true);
	SimpleDateFormat ds= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String ans="账号为："+str+"的用户于"+ds.format(new Date())+"成功登陆\r\n";
	fo.write(ans.getBytes());
	fo.close();
}
public void export() throws Exception{
	File f=new File("D:/课程设计：项目资金管理系统/time.txt");
	Reader reader=new FileReader(f);
	char c[]=new char[1024];
	int len=reader.read(c);
	reader.close();
	System.out.println(new String(c,0,len));
}
}