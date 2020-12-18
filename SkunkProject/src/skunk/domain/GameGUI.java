package skunk.domain;

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
import javax.swing.JTextPane;

public class GameGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JButton btnRoll;
	private JTextPane textPaneMsg;
	private JLabel lblDice;
	
	public GameGUI(Game game) {
		game.play();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbDie1 = new JLabel();
		lbDie1.setForeground(Color.WHITE);
		JLabel lbDie2 = new JLabel();
		lblDice = new JLabel("0");
		textPaneMsg = new JTextPane();
		
		btnRoll = new JButton("Roll");
		btnRoll.setBackground(Color.GREEN);
		btnRoll.setForeground(Color.WHITE);
		btnRoll.setFocusPainted(false);
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean pen = game.roll();
				Dice dice = game.getDice();
				
				if(pen) {
					textPaneMsg.setText(game.getMsg());
					btnRoll.setEnabled(false);
				}
				
				lblDice.setText("" + dice.getLastRoll());
				ImageIcon img1 = new ImageIcon(new ImageIcon("res/imgs/dice_" + dice.lastDie1Roll() + ".png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
				ImageIcon img2 = new ImageIcon(new ImageIcon("res/imgs/dice_" + dice.lastDie2Roll() + ".png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
				lbDie1.setIcon(img1);
				lbDie2.setIcon(img2);
			}
		});
		btnRoll.setFont(new Font("Verdana", Font.BOLD, 28));
		btnRoll.setBounds(193, 430, 150, 50);
		contentPane.add(btnRoll);
		
		JButton btnPass = new JButton("Pass");
		btnPass.setBackground(Color.WHITE);
		btnPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.pass();
				reset(game);
			}
		});
		
		lbDie1.setBounds(193, 85, 150, 150);
		contentPane.add(lbDie1);
		
		lbDie2.setBounds(508, 85, 150, 150);
		contentPane.add(lbDie2);
		btnPass.setFont(new Font("Verdana", Font.ITALIC, 28));
		btnPass.setBounds(508, 430, 150, 50);
		contentPane.add(btnPass);
		
		JLabel lblNameLabel = new JLabel("Name:");
		lblNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNameLabel.setBounds(293, 263, 60, 28);
		contentPane.add(lblNameLabel);
		
		lblName = new JLabel("");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(350, 263, 60, 28);
		lblName.setText(game.getCurPlayer().getName());
		contentPane.add(lblName);
		
		JLabel lblDiceLabel = new JLabel("Dice:");
		lblDiceLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiceLabel.setBounds(470, 263, 60, 28);
		contentPane.add(lblDiceLabel);
		
		
		lblDice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDice.setBounds(519, 263, 60, 28);
		contentPane.add(lblDice);
		
		
		textPaneMsg.setForeground(Color.RED);
		textPaneMsg.setBackground(Color.WHITE);
		textPaneMsg.setEditable(false);
		textPaneMsg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPaneMsg.setBounds(293, 301, 264, 119);
		contentPane.add(textPaneMsg);
	}
	
	private void reset(Game game) {
		game.play();
		btnRoll.setEnabled(true);
		lblName.setText(game.getCurPlayer().getName());
		textPaneMsg.setText("");
		lblDice.setText("0");
	}
}
