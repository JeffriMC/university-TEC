package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.sun.codemodel.internal.JOp;

import aplication.GLOBALS;
import models.Sensor;
import view.Add_View;
import view.Main_View;

public class C_Add_View implements ActionListener{
	private Add_View current_view;
	public C_Add_View(Add_View current_view) 
	{
		
		this.current_view = current_view;
		this.current_view.prepare_window();
		this.current_view.btn_add_sensor.addActionListener(this);
		this.current_view.btn_cancel.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "btn_add":
			add_sensor();
			break;
		case "btn_cancel":
			current_view.txt_id.setText("Obligatorio...");
			current_view.txt_canton.setText("Obligatorio...");
			current_view.dispose();
			break;
		default:
			break;
		}
	}
	
	private void add_sensor() 
	{
		String id = this.current_view.txt_id.getText();
		String name_canton = this.current_view.txt_canton.getText();
		String name_district = this.current_view.txt_district.getText();
		String name_neighborhood = this.current_view.txt_neighborhood.getText();
		if(name_canton.equals("") || name_canton.equals("Obligatorio...") || id.equals("") || id.equals("Obligatorio...")) 
		{
			JOptionPane.showMessageDialog(current_view, "Por favor llenar los espacios obligatorios");
		}
		else
		{
			Sensor new_sensor = new Sensor( id, name_canton, name_district, name_neighborhood, 0, null);
			String res = GLOBALS.AYA_DB.insert_sensor(new_sensor);
			if(res.equals("c_not")) JOptionPane.showMessageDialog(current_view, "Sensor cantón repetido");
			else if(res.equals("d_not")) JOptionPane.showMessageDialog(current_view, "Sensor distrito repetido");
			else if(res.equals("c_not_yet")) JOptionPane.showMessageDialog(current_view, "Sensor cantón no existe");
			else if(res.equals("n_not")) JOptionPane.showMessageDialog(current_view, "Sensor barrio repetido");
			else if(res.equals("d_not_yet")) JOptionPane.showMessageDialog(current_view, "Sensor distrito no existe");
			else 
			{
				JOptionPane.showMessageDialog(current_view, "Sensor insertado correctamente!!");
			}
		}
		
	}
}
