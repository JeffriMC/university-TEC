package view;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Add_View extends JFrame{
	public JButton btn_add_sensor;
	public JButton btn_cancel;
	public JLabel lb_id;
	public JLabel lb_canton;
	public JLabel lb_district;
	public JLabel lb_neighborhood;
	public JTextField txt_id;
	public JTextField txt_canton;
	public JTextField txt_district;
	public JTextField txt_neighborhood;
	
	public Add_View() {}
	
	public Add_View(String name_window) 
	{
		super(name_window);
		init_components();
	}
	
	private void init_components() 
	{
		btn_add_sensor = new JButton();
		btn_cancel = new JButton();
		lb_id = new JLabel();
		lb_canton = new JLabel();
		lb_district = new JLabel();
		lb_neighborhood = new JLabel();
		txt_id = new JTextField();
		txt_canton = new JTextField();
		txt_district = new JTextField();
		txt_neighborhood = new JTextField();
		config_components();
		add_components();
	}
	
	public void prepare_window() 
	{
		this.setLayout(null);
		setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setExtendedState(Frame.NORMAL);
		setVisible(true);
	}
	
	private void config_components() 
	{
		btn_add_sensor.setText("Agregar sensor");
		btn_add_sensor.setBounds(550, 450, 160, 30);
		btn_add_sensor.setActionCommand("btn_add");
		
		btn_cancel.setText("Cancelar");
		btn_cancel.setBounds(100, 450, 160, 30);
		btn_cancel.setActionCommand("btn_cancel");
		
		lb_id.setText("ID : ");
		lb_id.setBounds(100, 50, 100, 10);

		lb_canton.setText("CANTÓN : ");
		lb_canton.setBounds(100, 150, 100, 10);
		
		lb_district.setText("DISTRITO : ");
		lb_district.setBounds(100, 250, 100, 10);
		
		lb_neighborhood.setText("BARRIO : ");
		lb_neighborhood.setBounds(100, 350, 100, 10);		

		txt_id.setBounds(280, 40, 450, 30);
		txt_id.setText("Obligatorio...");
		txt_canton.setBounds(280, 140, 450, 30);
		txt_canton.setText("Obligatorio...");
		txt_district.setBounds(280, 240, 450, 30);
		txt_neighborhood.setBounds(280, 340, 450, 30);
	}
	
	private void add_components() 
	{
		add(btn_add_sensor);
		add(btn_cancel);
		
		add(lb_id);
		add(lb_canton);
		add(lb_district);
		add(lb_neighborhood);
	
		add(txt_id);
		add(txt_canton);
		add(txt_district);
		add(txt_neighborhood);
		
	}
}
