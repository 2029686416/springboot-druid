package com.demo.web.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.demo.web.model.Menu;
import com.google.gson.Gson;

public class Test7 {
	private static List<Menu> treeList = new ArrayList<Menu>();  //全局变量

	public static void main(String[] args) {
//		List<Menu> menuList=new ArrayList<Menu>();
		List<Menu> pidList=new ArrayList<Menu>();
        Menu mu=new Menu();
        mu.setId(1);
        pidList.add(mu);
        mu.setName("目录");
        mu.setParentid("0");
        Menu mu1=new Menu();
        mu1.setId(2);
        mu1.setName("目录1");
        mu1.setParentid("1");
        Menu mu2=new Menu();
        mu2.setId(3);
        mu2.setName("目录2");
        mu2.setParentid("1");
        Menu mu3=new Menu();
        mu3.setId(4);
        mu3.setName("目录3");
        mu3.setParentid("1");
        
        //目录3下子节点
        Menu mu4=new Menu();
        mu4.setId(5);
        mu4.setName("目录4");
        mu4.setParentid("4");
        
        treeList.add(mu);
        treeList.add(mu1);
        treeList.add(mu2);
        treeList.add(mu3);
        treeList.add(mu4);
        //pid
        System.out.println("pidList:-------------------"+pidList);
		List<Menu> tree = getTree(treeList,pidList);
		for (Menu menu : tree) {
			System.out.println(menu.getId()+" ------- "+menu.getName()+"  "+menu.getChildren().get(2).getChildren());
		}
		
		System.out.println("7715-=-----------"+tree.get(0).getChildren());
		Gson gson = new Gson();//import com.google.gson.Gson;
		String result = gson.toJson(tree);//pojo
		System.out.println("我看看0---------"+result);
	}
	
	
	public static List<Menu> getTree(List<Menu> menu,List<Menu> parentList) {
	    //先获取到所有数据
//	    treeList=MenuMapper.getList();   
	    if(menu==null) return null;

	    //获取到所有一级节点
//	    List<Menu> parentList = this.MenuMapper.findParentList();
	    List<Menu> list = new ArrayList<Menu>();
	    if(parentList != null){
	        for (int i = 0; i < parentList.size(); i++) {
	            list.add(recursiveTree(parentList.get(i).getId()));
	        }
	    }
	    return list;
	}


	/**
	 * 递归算法解析成树形结构
	 * @param cid
	 */
	public static Menu recursiveTree(Integer cid) {
	    Menu node = getMenuById(cid);
	    List<Menu> childTreeNodes  = getChildTreeById(cid);
	    for(Menu child : childTreeNodes){
	    	Menu n = recursiveTree(child.getId());
	    	List<Menu> list = new ArrayList<Menu>();
	    	list.add(n);
	    	System.out.println(node.getChildren());
	    	if (node.getChildren()==null) {
	    		List<Menu> li = new ArrayList<Menu>();
	    		node.setChildren(li);
			}
//	    	node.setChildren(list);
	        node.getChildren().add(n);
	    }
	    return node;
	}

	/**
	 * 根据CID查询节点对象
	 */
	public static Menu getMenuById(Integer cid){
	    Map map =  getTreeMap();
	    return (Menu) map.get(cid);
	}

	/**
	 * 一次性取所有数据，为了减少对数据库查询操作
	 * @return
	 */
	public static Map<Integer, Menu> getTreeMap(){
	    Map<Integer, Menu> map =  new HashMap<Integer, Menu>();
	    if(null != treeList){
	        for(Menu d : treeList){
	            map.put(d.getId(), d);
	        }
	    }
	    return map;
	}

	/**
	 * 根据父节点CID获取所有了节点
	 */
	public static List<Menu> getChildTreeById(Integer cid){
	    List<Menu> list = new ArrayList<Menu>();
	    if(null != treeList){
	        for (Menu d : treeList) {
	            if(null != cid){
	                if (cid.equals(Integer.valueOf(d.getParentid()))) {
	                    list.add(d);
	                }
	            }
	        }
	    }
	    return list;
	}
}
