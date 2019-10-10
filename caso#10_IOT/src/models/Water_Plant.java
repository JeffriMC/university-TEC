package models;

import java.util.ArrayList;

public class Water_Plant {
	private String name;
	private ArrayList<Sensor> list_sensors;
	
	public Water_Plant() {
		this.list_sensors =  new ArrayList<Sensor>();
	}
	public Water_Plant(String name) 
	{
		this.name = name;
		this.list_sensors =  new ArrayList<Sensor>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Sensor> getList_sensors() {
		return list_sensors;
	}
	public void setList_sensors(ArrayList<Sensor> list_sensors) {
		this.list_sensors = list_sensors;
	}
	
	
}
