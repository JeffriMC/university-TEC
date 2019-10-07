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
		this.current_view.btn_exit.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "add_sensor":
			C_Add_View controller_add_view = new C_Add_View(add_view);			
			break;
		case "delete_sensor":
			delete_view.prepare_window();
			C_Delete_View controller_delete_view = new C_Delete_View(delete_view);
			break;
		case "details_sensor":
			C_Details_View controller_details_view = new C_Details_View(details_view);
			break;
		case "btn_exit":
			current_view.dispose();
			break;
		default:
			break;
		}
	}
}
