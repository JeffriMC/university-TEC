/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author jeffri
 *
 */
public class Main_View extends JFrame {
	public JButton btn_add_sensor;
	public JButton btn_delete_sensor;
	public JButton btn_details_sensor;
	
	public Main_View() {}
	public Main_View(String name_window) {
		super(name_window);
		init_components();
		this.setLayout(null);
		setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setExtendedState(Frame.NORMAL);
		setVisible(true);
	}
	
	private void init_components() {
		
		btn_add_sensor = new JButton();
		btn_delete_sensor = new JButton();
		btn_details_sensor = new JButton();
		config_buttons();
		add_components();
	}
	
	private void config_buttons() {
		btn_add_sensor.setText("Agregar sensor");
		btn_add_sensor.setBounds(620, 10, 160, 30);
		btn_add_sensor.setEnabled(true);
		btn_add_sensor.setActionCommand("add_sensor");
		
		btn_delete_sensor.setText("Borrar sensor");
		btn_delete_sensor.setBounds(620, 50, 160, 30);
		btn_delete_sensor.setEnabled(true);
		btn_delete_sensor.setActionCommand("delete_sensor");

		btn_details_sensor.setText("Detalles sensor");
		btn_details_sensor.setBounds(620, 90, 160, 30);
		btn_details_sensor.setEnabled(true);
		btn_details_sensor.setActionCommand("details_sensor");
	}
	
	private void add_components() {
		add(btn_add_sensor);
		add(btn_delete_sensor);
		add(btn_details_sensor);
	}

}
