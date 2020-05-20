package com.demo.web.test;
 
import java.util.ArrayList;
import java.util.List;

import com.demo.web.model.Menu2;
 
public class MenuRecursion {
	//子节点
	static List<Menu2> childMenu = new ArrayList<Menu2>();
 
	/**
	 * 获取某个父节点下面的所有子节点
	 * @param menuList
	 * @param pid
	 * @return
	 */
	public static List<Menu2> treeMenuList(List<Menu2> menuList, int pid) {
		for (Menu2 mu : menuList) {
			List<Menu2> list = new ArrayList<Menu2>();
			//遍历出父id等于参数的id，add进子节点集合
			if (Integer.valueOf(mu.getParentid()) == pid) {
				//递归遍历下一级
				treeMenuList(menuList, Integer.valueOf(mu.getId()));
				list.add(mu);
				mu.setChildren(list);
//				System.out.println(mu.getChildren().add(mu));
				childMenu.add(mu);
			}
		}
		return childMenu;
	}
	
	
 
	public static void main(String args[]) {
		List<Menu2> menuList = new ArrayList<Menu2>();
		Menu2 mu = new Menu2();
		mu.setId("1");
		mu.setName("目录");
		mu.setParentid("0");
		Menu2 mu1 = new Menu2();
		mu1.setId("2");
		mu1.setName("目录1");
		mu1.setParentid("1");
		Menu2 mu2 = new Menu2();
		mu2.setId("3");
		mu2.setName("目录1.1");
		mu2.setParentid("2");
		Menu2 mu3 = new Menu2();
		mu3.setId("4");
		mu3.setName("目录1.2");
		mu3.setParentid("2");
		Menu2 mu4 = new Menu2();
		mu4.setId("5");
		mu4.setName("目录2");
		mu4.setParentid("1");
		Menu2 mu5 = new Menu2();
		mu5.setId("6");
		mu5.setName("目录2.1");
		mu5.setParentid("5");
		Menu2 mu6 = new Menu2();
		mu6.setId("7");
		mu6.setName("目录2.2");
		mu6.setParentid("5");
		Menu2 mu7 = new Menu2();
		mu7.setId("8");
		mu7.setName("目录2.2.1");
		mu7.setParentid("7");
		menuList.add(mu);
		menuList.add(mu1);
		menuList.add(mu2);
		menuList.add(mu3);
		menuList.add(mu4);
		menuList.add(mu5);
		menuList.add(mu6);
		menuList.add(mu7);
 
		List<Menu2> childList = treeMenuList(menuList, 1);
		for (Menu2 m : childList) {
			System.out.println(m.getId() + "   " + m.getName()+ "   " +m.getChildren().get(0).getName());
		}
	}
 
}