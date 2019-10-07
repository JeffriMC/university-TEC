package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Add_View;
import view.Details_View;
import view.Show_Details_View;

public class C_Details_View implements ActionListener{
	private Details_View current_view;
	
	public C_Details_View(Details_View current_view) 
	{
		
		this.current_view = current_view;
		this.current_view.prepare_window();
		current_view.btn_cancel.addActionListener(this);
		current_view.btn_search_sensor.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "btn_search":
			
			break;
		case "btn_cancel":
			current_view.dispose();
			break;
		default:
			break;
		}
	}
}
