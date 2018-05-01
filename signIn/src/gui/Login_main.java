package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_main frame = new Login_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_main() {
		setTitle("\u7BA1\u7406\u5458");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u516C\u544A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Announce().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(38, 68, 95, 87);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u7528\u6237\u7BA1\u7406");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User_manage().setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(165, 68, 95, 87);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u767B\u5F55");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User_Login().setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(293, 68, 95, 87);
		contentPane.add(button_1);
		
	}
}
