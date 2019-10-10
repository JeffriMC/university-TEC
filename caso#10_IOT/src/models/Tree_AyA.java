package models;

import java.util.ArrayList;

public class Tree_AyA {
	private Water_Plant root;
	public Tree_AyA() {}
	public Tree_AyA(Water_Plant root) {
		this.root = root;
	}
	
	
	public void show_cantons() 
	{
		ArrayList<Sensor> list_cantons = root.getList_sensors();
		for(Sensor canton: list_cantons) 
		{
			System.out.println(canton.getCanton());
		}
	}
	
	public Water_Plant get_root() 
	{
		return root;
	}
	
	public boolean empty() 
	{
		return (root==null);
	}
	
	public boolean insert_root(Water_Plant new_root) 
	{
		if(empty())
		{
			root = new_root;
			return true;
		}else 
		{			
			return false;
		}		
	}
	
	public String insert_sensor(Sensor new_sensor) 
	{
		if(new_sensor.getDistrict().equals(""))
		{
			if(search_canton(new_sensor.getCanton()) == null) 
			{
				root.getList_sensors().add(new_sensor);
				return "c_yes";
			}
			return "c_not";
		}else if(new_sensor.getNeighborhood().equals(""))
		{
			Sensor canton = search_canton(new_sensor.getCanton());
			if( canton != null) 
			{
				Sensor district = search_district(canton, new_sensor.getDistrict());
				if( district == null) 
				{
					new_sensor.setFather(canton);
					canton.setSons(new_sensor);
					return "d_yes";
				}
				return "d_not";
			}else return "c_not_yet";
		}else 
		{
			Sensor canton = search_canton(new_sensor.getCanton());
			if(canton == null) return "c_not_yet";
			else 
			{
				Sensor district = search_district(canton, new_sensor.getDistrict());
				if(district == null) return "d_not_yet";
				else 
				{
					Sensor neighborhood = search_neighborhood(district, new_sensor.getNeighborhood());
					if( neighborhood == null) 
					{
						new_sensor.setFather(district);
						district.setSons(new_sensor);
						return "n_yes";
					}
					return "n_not";
				}
			}
		}
	}

	
	
	public Sensor search_canton(String name_canton) 
	{
		ArrayList<Sensor> list_canton = root.getList_sensors();
		
		for(Sensor canton : list_canton) 
		{
			if(canton.getCanton().equals(name_canton)) 
			{
				return canton;
			}
		}
		return null;
	}
	
	public Sensor search_district(Sensor canton, String name_district) 
	{
		if(canton.getSons() == null) 
		{
			return null;
		}else 
		{
			ArrayList<Sensor> list_districts = canton.getSons();
			for(Sensor district : list_districts) 
			{
				if(district.getDistrict().equals(name_district)) 
				{
					return district;
				}
			}
			return null;
		}
	}
	
	public Sensor search_neighborhood(Sensor district, String name_neighborhood)
	{
		if(district.getSons() == null) 
		{
			return null;
		}else 
		{
			ArrayList<Sensor> list_neighborhood = district.getSons();
			for(Sensor neighborhood : list_neighborhood) 
			{
				if(neighborhood.getNeighborhood().equals(name_neighborhood)) 
				{
					return neighborhood;
				}
			}
			return null;	
		}
	}
}
