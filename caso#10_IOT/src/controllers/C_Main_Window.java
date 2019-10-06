package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Add_View;
import view.Delete_View;
import view.Details_View;
import view.Main_View;

public class C_Main_Window implements ActionListener{
	private Main_View current_view;
	private Add_View add_view;
	private Delete_View delete_view;
	private Details_View details_view;
	public C_Main_Window(Main_View current_view) 
	{
		
		this.current_view = current_view;
		add_view =  new Add_View("AGREGAR SENSORES");
		delete_view =  new Delete_View("BORRAR SENSORES");
		details_view = new Details_View("DETALLES SENSORES");
		
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
			delete_view.prepare_window();
			break;
		case "details_sensor":
			details_view.prepare_window();
			break;

		default:
			break;
		}
	}
}
