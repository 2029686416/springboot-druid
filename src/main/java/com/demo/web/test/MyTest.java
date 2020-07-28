package com.demo.web.test;

import java.util.ArrayList;
import java.util.List;

import com.demo.web.model.Menu2;

/**
*@author:liuhao
*@version:2020年5月13日上午10:28:21
*@description:
*/
public class MyTest {
	public static void main(String[] args) {
		List<Menu2> menuList = new ArrayList<Menu2>();
		Menu2 mu = new Menu2();
		mu.setId("1");
		mu.setName("目录1");
		mu.setParentid("0");
		menuList.add(mu);
		
		Menu2 mu2 = new Menu2();
		mu2.setId("2");
		mu2.setName("目录1.1");
		mu2.setParentid("1");
		menuList.add(mu2);
		
		List<Menu2> list = new ArrayList<Menu2>();
		List<Menu2> childList = treeMenuList(menuList, 1);
		System.out.println(childList.get(1).getChildren().get(0).getName());
		for (Menu2 m : childList) {
			System.out.println(m.getId() + "   " + m.getName()+ "   " +m.getChildren());
		}
	}
	//子节点
		static List<Menu2> childMenu = new ArrayList<Menu2>();
	public static List<Menu2> treeMenuList(List<Menu2> menuList, int pid) {
		for (Menu2 menu2 : menuList) {
			if (Integer.valueOf(menu2.getParentid()) == pid) {//如果有节点的pid匹配
				//进入的属性是匹配成功的！
				List<Menu2> listT = new ArrayList<>();
				listT.add(menu2);
				System.out.println("00-"+menu2.getName());
				menu2.setChildren(listT);
			}
		}
		return menuList;
	}
	
}
