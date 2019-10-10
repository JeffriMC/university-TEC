package view;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Show_Details_View extends JFrame{
	public JButton btn_return;
	public JLabel lb_id;
	public JLabel lb_canton;
	public JLabel lb_district;
	public JLabel lb_neighborhood;
	public JLabel lb_consumption;
	public JLabel lb_father;
	public JLabel lb_sons;
	
	public Show_Details_View() {}
	
	public Show_Details_View(String name_window) 
	{
		super(name_window);
		init_components();
	}
	
	private void init_components() 
	{
		btn_return = new JButton();
		
		lb_id = new JLabel();
		lb_canton = new JLabel();
		lb_district = new JLabel();
		lb_neighborhood = new JLabel();
		lb_consumption = new JLabel();
		lb_father = new JLabel();
		lb_sons= new JLabel();
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
		btn_return.setText("Volver");
		btn_return.setBounds(600, 220, 160, 30);
		btn_return.setActionCommand("btn_return");
		
		lb_id.setText("ID : ");
		lb_id.setBounds(100, 10, 500, 15);
		lb_canton.setText("Cantón : ");
		lb_canton.setBounds(100, 40, 500, 15);
		lb_district.setText("Distrito : ");
		lb_district.setBounds(100, 70, 500, 15);
		lb_neighborhood.setText("Barrio : ");
		lb_neighborhood.setBounds(100, 100, 500, 15);
		lb_consumption.setText("Consumo cm3/minuto : ");
		lb_consumption.setBounds(100, 130, 500, 15);
		lb_father.setText("Padre : ");
		lb_father.setBounds(100, 160, 500, 15);
		lb_sons.setText("Hijos : ");
		lb_sons.setBounds(100, 190, 500, 15);		
	}
	
	private void add_components() 
	{
		add(btn_return);

		add(lb_id);
		add(lb_canton);
		add(lb_district);
		add(lb_neighborhood);
		add(lb_consumption);
		add(lb_father);
		add(lb_sons);
	}
}
