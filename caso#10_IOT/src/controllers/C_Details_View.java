package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import aplication.GLOBALS;
import models.Sensor;
import view.Add_View;
import view.Details_View;
import view.Show_Details_View;

public class C_Details_View implements ActionListener{
	private Details_View current_view;
	private Show_Details_View show_details;
	public C_Details_View(Details_View current_view) 
	{
		this.show_details = new Show_Details_View("DETALLES DEL SENSOR");
		this.current_view = current_view;
		this.current_view.prepare_window();
		current_view.btn_cancel.addActionListener(this);
		current_view.btn_search_sensor.addActionListener(this);
		show_details.btn_return.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "btn_search":
			this.show_details = new Show_Details_View("DETALLES DEL SENSOR");
			if(check_fields() && show_details()) 
			{
				show_details.prepare_window();
			}
			break;
		case "btn_cancel":
			current_view.dispose();
			current_view = null;
			break;
		case "btn_return":
			show_details.dispose();
			show_details = null;
			break;
		default:
			break;
		}
	}
	
	public boolean check_fields() 
	{
		if(current_view.txt_name_sensor.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(current_view, "Por favor insertar el nombre del sensor.");
			return false;
		}
		return true;
	}
	
	public boolean show_details() 
	{
		if(show_canton()) return true;
		else if(search_district() != null) {
			show(search_district());
			return true;
		}
		else if(search_neighborhood() != null) {
			show(search_neighborhood());
			return true;
		}
		else 
		{
			JOptionPane.showMessageDialog(current_view, "Este sensor no existe.");
			return false;
		}
		
		
	}
	
	public boolean show_canton()
	{
		Sensor canton = GLOBALS.AYA_DB.search_canton(current_view.txt_name_sensor.getText());
		if(canton!=null) 
		{
			String txt = show_details.lb_id.getText();
			txt += "				"+canton.getId();
			show_details.lb_id.setText(txt);
			txt = show_details.lb_canton.getText();
			txt += "				"+canton.getCanton();
			show_details.lb_canton.setText(txt);
			txt = show_details.lb_district.getText();
			txt += "				"+canton.getDistrict();
			show_details.lb_district.setText(txt);
			txt = show_details.lb_neighborhood.getText();
			txt += "				"+canton.getNeighborhood();
			show_details.lb_neighborhood.setText(txt);
			txt = show_details.lb_consumption.getText();
			txt += "				"+canton.getConsumption();
			show_details.lb_consumption.setText(txt);
			txt = show_details.lb_father.getText();
			txt += "				Planta AyA";
			show_details.lb_father.setText(txt);
			ArrayList<Sensor> sons = canton.getSons();
			if(sons.isEmpty()) 
			{
				txt = show_details.lb_sons.getText();
				txt += "				No hay hijos.";
				show_details.lb_sons.setText(txt);
			}else 
			{
				txt = show_details.lb_sons.getText();
				for(int index = 0; index < sons.size(); index++) 
				{
					txt += "				"+sons.get(index).getDistrict()+" - ";
				}
				show_details.lb_sons.setText(txt);
			}
			return true;
		}else 
		{
			return false;
		}
	}
	public Sensor search_district() 
	{
		ArrayList<Sensor> cantons = GLOBALS.AYA_DB.get_root().getList_sensors();
		String name_district = current_view.txt_name_sensor.getText();
		for(Sensor canton: cantons) 
		{
			ArrayList<Sensor> districts = canton.getSons();
			for(Sensor district : districts) 
			{
				if(district.getDistrict().equals(name_district)) 
				{
					return district;
				}
			}
			return null;
		}
		return null;
	}
	
	public boolean show(Sensor sensor)
	{
		
		if(sensor!=null) 
		{
			String txt = show_details.lb_id.getText();
			txt += "				"+sensor.getId();
			show_details.lb_id.setText(txt);
			txt = show_details.lb_canton.getText();
			txt += "				"+sensor.getCanton();
			show_details.lb_canton.setText(txt);
			txt = show_details.lb_district.getText();
			txt += "				"+sensor.getDistrict();
			show_details.lb_district.setText(txt);
			txt = show_details.lb_neighborhood.getText();
			txt += "				"+sensor.getNeighborhood();
			show_details.lb_neighborhood.setText(txt);
			txt = show_details.lb_consumption.getText();
			txt += "				"+sensor.getConsumption();
			show_details.lb_consumption.setText(txt);
			txt = show_details.lb_father.getText();
			if(sensor.getNeighborhood().equals("")) txt += "				"+sensor.getFather().getCanton();
			else txt += "				"+sensor.getFather().getDistrict();
			show_details.lb_father.setText(txt);
			ArrayList<Sensor> sons = sensor.getSons();
			if(sons.isEmpty()) 
			{
				txt = show_details.lb_sons.getText();
				txt += "				No hay hijos.";
				show_details.lb_sons.setText(txt);
			}else 
			{
				txt = show_details.lb_sons.getText();
				for(Sensor son: sons) 
				{
					txt += "				"+son.getNeighborhood()+" - ";
				}
				show_details.lb_sons.setText(txt);
			}
			return true;
		}else 
		{
			return false;
		}
	}
	
	public Sensor search_neighborhood() 
	{
		ArrayList<Sensor> cantons = GLOBALS.AYA_DB.get_root().getList_sensors();
		String name_neighborhood = current_view.txt_name_sensor.getText();
		for(Sensor canton: cantons) 
		{
			ArrayList<Sensor> districts = canton.getSons();
			for(Sensor district : districts) 
			{
				ArrayList<Sensor>  neighborhoods = district.getSons();
				for(Sensor neighborhood: neighborhoods) 
				{
					if(neighborhood.getNeighborhood().equals(name_neighborhood)) 
					{
						return neighborhood;
					}
				}
				return null;
			}
			return null;
		}
		return null;
	}
}
