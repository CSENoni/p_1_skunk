package skunk.domain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class SkunkGUI extends JFrame {

	private JPanel contentPane;

	public SkunkGUI(Game game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbSkunk = new JLabel("SKUNK");
		lbSkunk.setForeground(Color.RED);
		lbSkunk.setFont(new Font("Rockwell Condensed", Font.BOLD, 72));
		lbSkunk.setHorizontalAlignment(SwingConstants.CENTER);
		lbSkunk.setBounds(199, 103, 313, 140);
		contentPane.add(lbSkunk);
		
		Window skunk = this;
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyDialogPopup dialog = new MyDialogPopup("Names?", skunk);
				dialog.setModal(true);
				dialog.setVisible(true);
				game.addPlayer(dialog.getContend());
			}
		});
		btnAdd.setBounds(154, 315, 124, 45);
		contentPane.add(btnAdd);
		
		JButton btnGuide = new JButton("Guide");
		
		GuideGUI guide = new GuideGUI();
		btnGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guide.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				guide.setVisible(true);
				skunk.setEnabled(false);
			}
		});
		
		guide.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				skunk.setEnabled(true);
			}
		});
		btnGuide.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnGuide.setBounds(451, 315, 124, 45);
		contentPane.add(btnGuide);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GameGUI(game).setVisible(true);
				dispose();
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnStart.setBounds(301, 315, 124, 45);
		contentPane.add(btnStart);
	}
}
