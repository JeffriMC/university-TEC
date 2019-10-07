package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Add_View;
import view.Delete_View;

public class C_Delete_View implements ActionListener{
	private Delete_View current_view;
	
	public C_Delete_View(Delete_View current_view) 
	{
		
		this.current_view = current_view;
		this.current_view.prepare_window();
		this.current_view.btn_delete_sensor.addActionListener(this);
		this.current_view.btn_cancel.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "btn_delete":
			
			break;
		case "btn_cancel":
			current_view.dispose();
			break;
		default:
			break;
		}
	}
}
