package table;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class table extends JFrame{
	JTable table1;
	Object a[][];
	JPanel panel;
	
	JScrollPane scroll;
	
	public table(){
		panel = (JPanel)this.getContentPane();
		this.setTitle("�������");
		this.setSize(400,300);
		panel.setLayout(new BorderLayout());
		Object[][] data = {
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"��","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"����","Ů","�赸"},
				{"��","Ů","�赸"}
		};
		
		Object[] name = {"����","�Ա�","����"};
		
		table1 = new JTable(data,name);
		table1.setRowHeight(20);
		scroll = new JScrollPane(table1);
		panel.add(scroll,"Center");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		table ta = new table();
		
		ta.setVisible(true);
	}
	
}
