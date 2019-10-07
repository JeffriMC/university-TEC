package view;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Delete_View extends JFrame{
	public JButton btn_delete_sensor;
	public JButton btn_cancel;
	public JLabel lb_title;
	public JTextField txt_id_sensor;
	
	public Delete_View() {}
	
	public Delete_View(String name_window) 
	{
		super(name_window);
		init_components();
	}
	
	private void init_components() 
	{
		btn_delete_sensor = new JButton();
		btn_cancel = new JButton();
		lb_title = new JLabel();
		txt_id_sensor = new JTextField();
		config_components();
		add_components();
	}
	
	public void prepare_window() 
	{
		this.setLayout(null);
		setSize(800, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setExtendedState(Frame.NORMAL);
		setVisible(true);
	}
	
	private void config_components() 
	{
		btn_delete_sensor.setText("Agregar sensor");
		btn_delete_sensor.setBounds(485, 150, 160, 30);
		btn_delete_sensor.setActionCommand("btn_delete");
		
		btn_cancel.setText("Cancelar");
		btn_cancel.setBounds(150, 150, 160, 30);
		btn_cancel.setActionCommand("btn_cancel");
		
		lb_title.setText("ID : ");
		lb_title.setBounds(100, 50, 100, 10);

		txt_id_sensor.setBounds(280, 40, 450, 30);
	}
	
	private void add_components() 
	{
		add(btn_delete_sensor);
		add(btn_cancel);
		
		add(lb_title);
		
		add(txt_id_sensor);
	}
}
