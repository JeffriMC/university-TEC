package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		case "add_sensor":
			
			break;
		case "btn_cancel":
			current_view.dispose();
			break;
		default:
			break;
		}
	}
}
