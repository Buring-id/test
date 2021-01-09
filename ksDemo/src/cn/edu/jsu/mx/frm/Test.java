package cn.edu.jsu.mx.frm;

import cn.edu.jsu.mx.dbc.Addinformation;
import junit.framework.TestCase;

public class Test extends TestCase{
	 public void testfind() {
		 String sql="select * from gly where zh=10001";
		 boolean bl=Addinformation.find(sql);
		 assertTrue(bl==true);
	 }

}