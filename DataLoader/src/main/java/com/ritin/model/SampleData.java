package com.ritin.model;

import java.util.HashMap;
import java.util.Map;

public class SampleData {
	
	public static Map<String, Map<String, Map<String, Map<String, Inventory>>>> returnTestData(){
		System.out.println("Begin SampleData");
		Map<String, Map<String , Map<String, Map<String,Inventory>>>> channelMap = null;
		Map<String , Map<String, Map<String,Inventory>>> sessionMap = null;
		Map<String, Map<String,Inventory>> roomTypeMap = null;
		Map<String,Inventory> mealPlanMap = null;
		Inventory inv = null;
		
		channelMap = new HashMap<String, Map<String,Map<String,Map<String,Inventory>>>>();
		
		//1st Channel Data
		//1st session data start
		sessionMap = new HashMap<String, Map<String,Map<String,Inventory>>>();		
		//1st Roomtype data
		roomTypeMap = new HashMap<String, Map<String,Inventory>>();
		mealPlanMap = new HashMap<String,Inventory>();
		inv = new Inventory();
		inv.setMaxOccupency(1);
		mealPlanMap.put("AP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(2);
		mealPlanMap.put("MAP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(3);
		mealPlanMap.put("CP", inv);
		roomTypeMap.put("1BR",mealPlanMap);
		//2nd Roomtype data
		mealPlanMap = new HashMap<String,Inventory>();
		inv = new Inventory();
		inv.setMaxOccupency(1);
		mealPlanMap.put("AP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(2);		
		mealPlanMap.put("MAP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(3);		
		mealPlanMap.put("CP", inv);
		roomTypeMap.put("2BR",mealPlanMap);
		sessionMap.put("Red", roomTypeMap);
		//1st session data end
		//2nd session data start
		//1st Roomtype data
		roomTypeMap = new HashMap<String, Map<String,Inventory>>();
		mealPlanMap = new HashMap<String,Inventory>();
		inv = new Inventory();
		inv.setMaxOccupency(1);		
		mealPlanMap.put("AP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(2);		
		mealPlanMap.put("MAP", inv);
		inv.setMaxOccupency(3);		
		mealPlanMap.put("CP", inv);
		roomTypeMap.put("1BR",mealPlanMap);
		//2nd Roomtype data
		mealPlanMap = new HashMap<String,Inventory>();
		inv.setMaxOccupency(1);		
		mealPlanMap.put("AP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(2);		
		mealPlanMap.put("MAP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(3);
		mealPlanMap.put("CP", inv);
		roomTypeMap.put("2BR",mealPlanMap);
		sessionMap.put("Blue", roomTypeMap);
		channelMap.put("Agent", sessionMap);
		//2nd channel data
		//1st session data start
		sessionMap = new HashMap<String, Map<String,Map<String,Inventory>>>();
		//1st Roomtype data
		roomTypeMap = new HashMap<String, Map<String,Inventory>>();
		mealPlanMap = new HashMap<String,Inventory>();
		inv = new Inventory();
		inv.setMaxOccupency(4);		
		mealPlanMap.put("AP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(5);		
		mealPlanMap.put("MAP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(6);		
		mealPlanMap.put("CP", inv);
		roomTypeMap.put("1BR",mealPlanMap);
		//2nd Roomtype data
		mealPlanMap = new HashMap<String,Inventory>();
		inv = new Inventory();
		inv.setMaxOccupency(1);		
		mealPlanMap.put("AP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(2);		
		mealPlanMap.put("MAP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(3);		
		mealPlanMap.put("CP", inv);
		roomTypeMap.put("2BR",mealPlanMap);
		sessionMap.put("Red", roomTypeMap);
		//1st session data end
		//2nd session data start
		//1st Roomtype data
		roomTypeMap = new HashMap<String, Map<String,Inventory>>();
		mealPlanMap = new HashMap<String,Inventory>();
		inv = new Inventory();
		inv.setMaxOccupency(1);		
		mealPlanMap.put("AP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(2);
		mealPlanMap.put("MAP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(3);		
		mealPlanMap.put("CP", inv);
		roomTypeMap.put("1BR",mealPlanMap);
		//2nd Roomtype data
		mealPlanMap = new HashMap<String,Inventory>();
		inv = new Inventory();
		inv.setMaxOccupency(1);		
		mealPlanMap.put("AP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(2);		
		mealPlanMap.put("MAP", inv);
		inv = new Inventory();
		inv.setMaxOccupency(3);
		mealPlanMap.put("CP", inv);
		roomTypeMap.put("2BR",mealPlanMap);
		sessionMap.put("Blue", roomTypeMap);
		channelMap.put("ThirdParty", sessionMap);
		System.out.println("End SampleData");
		//System.out.println(channelMap);
		return channelMap;
	}

}
