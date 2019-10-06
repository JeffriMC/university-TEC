package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Add_View;
import view.Main_View;

public class C_Add_View implements ActionListener{
	private Main_View current_view;
	private Add_View add_view;
	
	public C_Add_View(Main_View current_view) 
	{
		
		this.current_view = current_view;
		add_view =  new Add_View("AGREGAR SENSORES");
		
		this.current_view.btn_add_sensor.addActionListener(this);
		this.current_view.btn_delete_sensor.addActionListener(this);
		this.current_view.btn_details_sensor.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "add_sensor":
			add_view.prepare_window();
			
			break;
		case "delete_sensor":
			
			break;
		case "details_sensor":
	
			break;

		default:
			break;
		}
	}
}
