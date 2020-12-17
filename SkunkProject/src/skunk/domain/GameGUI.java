package skunk.domain;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GameGUI extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI frame = new GameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbDie1 = new JLabel();
		lbDie1.setForeground(Color.WHITE);
		JLabel lbDie2 = new JLabel();
		
		JButton btnRoll = new JButton("Roll");
		btnRoll.setBackground(Color.GREEN);
		btnRoll.setForeground(Color.WHITE);
		btnRoll.setFocusPainted(false);
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int random = (int) (Math.random() * 6) + 1 ;
				ImageIcon img1 = new ImageIcon(new ImageIcon("res/imgs/dice_" + random + ".png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
				random = (int) (Math.random() * 6) + 1 ;
				ImageIcon img2 = new ImageIcon(new ImageIcon("res/imgs/dice_" + random + ".png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
				lbDie1.setIcon(img1);
				lbDie2.setIcon(img2);
			}
		});
		btnRoll.setFont(new Font("Verdana", Font.BOLD, 28));
		btnRoll.setBounds(193, 430, 150, 50);
		contentPane.add(btnRoll);
		
		JButton btnSkip = new JButton("Skip");
		btnSkip.setBackground(Color.WHITE);
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		lbDie1.setBounds(193, 85, 150, 150);
		contentPane.add(lbDie1);
		
		lbDie2.setBounds(508, 85, 150, 150);
		contentPane.add(lbDie2);
		btnSkip.setFont(new Font("Verdana", Font.ITALIC, 28));
		btnSkip.setBounds(508, 430, 150, 50);
		contentPane.add(btnSkip);
		
		JLabel lblNameLabel = new JLabel("Name:");
		lblNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNameLabel.setBounds(283, 263, 60, 28);
		contentPane.add(lblNameLabel);
		
		JLabel lblName = new JLabel("");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(344, 263, 60, 28);
		contentPane.add(lblName);
		
		JLabel lblDiceLabel = new JLabel("Dice:");
		lblDiceLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiceLabel.setBounds(470, 263, 60, 28);
		contentPane.add(lblDiceLabel);
		
		JLabel lblDice = new JLabel("0");
		lblDice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDice.setBounds(519, 263, 60, 28);
		contentPane.add(lblDice);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMessage.setBounds(283, 301, 280, 98);
		contentPane.add(lblMessage);
		
		JButton btnPass = new JButton("Pass");
		btnPass.setFont(new Font("Verdana", Font.PLAIN, 28));
		btnPass.setBackground(Color.WHITE);
		btnPass.setBounds(353, 430, 150, 50);
		contentPane.add(btnPass);
	}
}
