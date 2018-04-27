import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class gridLayout extends JFrame implements ActionListener{
	private int number = 1;
	private JTextField text_number,text_name;
	private JRadioButton radio_male,radio_female;
	private Object cities[][];
	private JComboBox combox_province,combox_city;
	private JTextArea text_user;
	private JButton button_add;
	
	public gridLayout(Object province[],Object cities[][]) {
		super("输入用户信息");
		
		this.setBounds(300,240,360,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(1,2));
		text_user = new JTextArea();
		this.getContentPane().add(text_user);
		JPanel panel = new JPanel(new GridLayout(6,1));
		
		this.getContentPane().add(panel);
		text_number = new JTextField("1");
		text_number.setEditable(false);
		panel.add(text_number);
		text_name = new JTextField("姓名");
		panel.add(text_name);
		JPanel panel_rb = new JPanel(new GridLayout(1,2));
		panel.add(panel_rb);
		ButtonGroup group = new ButtonGroup();
		radio_male = new JRadioButton("男",true);
		panel_rb.add(radio_male);
		group.add(radio_male);
		radio_female = new JRadioButton("女");
		group.add(radio_female);
		panel_rb.add(radio_female);
		this.cities = cities;
		combox_province = new JComboBox(province);
		combox_province.setEditable(true);
		combox_province.addActionListener(this);
		panel.add(combox_province);
		combox_city = new JComboBox(cities[0]);
		panel.add(combox_city);
		button_add = new JButton("添加");
		button_add.addActionListener(this);
		panel.add(button_add);
		this.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == combox_province) {
				int i = combox_province.getSelectedIndex();
				combox_city.removeAllItems();
				for(int j = 0;j<this.cities.length;j++) {
					combox_city.addItem(this.cities[i][j]);
				 }
				}
				if(e.getSource() == button_add) {
					String aline = number+","+text_name.getText();
					if(radio_male.isSelected()) {
						aline += ","+radio_male.getText();
						
					}
					if(radio_female.isSelected()) {
						aline += ","+radio_female.getText();
					}
					aline += ","+combox_province.getSelectedItem();
					aline += ","+combox_city.getSelectedItem();
					text_user.append(aline+"\n");
					this.number++;
					text_number.setText(" "+this.number);
					text_name.setText("姓名");
				
			}
		}
		
		public static void main(String[] args) {
			Object province[] = {"江苏省","浙江省"};
			Object cities[][] = {{"南京市","苏州市","无锡市"},{"宁波市","温州市"}};
			new gridLayout(province,cities);
		
	}
}
