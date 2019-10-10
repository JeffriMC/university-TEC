package models;

import java.util.ArrayList;

public class Sensor 
{
	private String id;
	private String canton;
	private String district;
	private String neighborhood;
	private float consumption;
	private Sensor father;
	private ArrayList<Sensor> sons;
	public Sensor() {}
	public Sensor(String id, String canton, String district, String neighborhood, float consumption, Sensor father) 
	{
		this.id = id;
		this.canton = canton;
		this.district = district;
		this.neighborhood = neighborhood;
		this.consumption = consumption;
		this.father = father;
		this.sons = new ArrayList<Sensor>();
	}
	
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public String getCanton() 
	{
		return canton;
	}
	public void setCanton(String canton) 
	{
		this.canton = canton;
	}
	
	public String getDistrict() 
	{
		return district;
	}
	public void setDistrict(String district) 
	{
		this.district = district;
	}
	
	public String getNeighborhood() 
	{
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) 
	{
		this.neighborhood = neighborhood;
	}
	
	public float getConsumption() 
	{
		return consumption;
	}
	public void setConsumption(float consumption) 
	{
		this.consumption = consumption;
	}
	
	public Sensor getFather() 
	{
		return father;
	}
	public void setFather(Sensor father) 
	{
		this.father = father;
	}
	
	public ArrayList<Sensor> getSons() 
	{
		return sons;
	}
	public void setSons(Sensor son) 
	{
		this.sons.add(son);
	}

	
		
}
