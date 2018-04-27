package swingTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class swing extends JFrame implements ActionListener{
	int i =1;
	JButton button;
	JTextArea area;
	JTextField text1,text2,text3;
	public static void main(String[] args) {
		new swing();
	}
	
	public swing() {
		super("盒式布局");
		setLayout(new BorderLayout());
		Box box,baseBox,Boxv1,Boxv2;
		button = new JButton("记录");
		button.setSize(250, 20);
		area = new JTextArea(20,20);
		JScrollPane pane = new JScrollPane(area);
		pane.setSize(250,250);
		Boxv1 = Box.createVerticalBox();
		Boxv1.add(new JLabel("姓名"));
		Boxv1.add(Box.createVerticalStrut(8));
		Boxv1.add(new JLabel("email"));
		Boxv1.add(Box.createVerticalStrut(8));
		Boxv1.add(new JLabel("职业"));
		
		text1 = new JTextField(12);
		text2 = new JTextField(12);
		text3 = new JTextField(12);
		Boxv2 = Box.createVerticalBox();
		Boxv2.add(text1);
		Boxv2.add(Box.createVerticalStrut(8));
		Boxv2.add(text2);
		Boxv2.add(Box.createVerticalStrut(8));
		Boxv2.add(text3);
		
		baseBox = Box.createHorizontalBox();
		baseBox.add(Boxv1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(Boxv2);
		
		box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(8));
		
		box.add(baseBox);
		box.add(button);
		button.addActionListener(this);
		box.add(pane);
		
		add(box,"Center");
		
		
		setBounds(120,125,250,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e) {
	//	int i =1;
		if(e.getSource() == button) {
			for(int j=0;j<10000;j++) {
			area.append(i+"  name:"+text1.getText()+"    emali:"+text2.getText()+"    职业:"+text3.getText()+"\n");
			i++;
		}
		}
	}
}
