package skunk.domain;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class MyDialogPopup extends JDialog {

	private String contend;
	private JTextField textContend;
	
	public MyDialogPopup(String question, Window window) {
		getContentPane().setLayout(null);
		
		JLabel lblQuestion = new JLabel();
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuestion.setBounds(97, 57, 211, 28);
		lblQuestion.setText(question);
		getContentPane().add(lblQuestion);
		
		textContend = new JTextField();
		textContend.setBounds(97, 106, 211, 28);
		getContentPane().add(textContend);
		textContend.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contend = textContend.getText();
				dispose();
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				window.setEnabled(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(152, 203, 107, 28);
		getContentPane().add(btnNewButton);
		
		setBounds(100, 100, 425, 275);
	}
	
	public String getContend() {
		return contend;
	}
}
