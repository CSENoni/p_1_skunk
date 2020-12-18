package skunk.domain;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class ScoreBoardGUI extends JFrame {

	private JPanel contentPane;
	
	public ScoreBoardGUI(Game game) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNameLabel = new JLabel("Player Name");
		lblNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNameLabel.setBounds(61, 66, 95, 43);
		contentPane.add(lblNameLabel);
		
		JLabel lblTurnScoreLabel = new JLabel("Turn Score");
		lblTurnScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTurnScoreLabel.setBounds(166, 66, 95, 43);
		contentPane.add(lblTurnScoreLabel);
		
		JLabel lblGameScoreLabel = new JLabel("Game Score");
		lblGameScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGameScoreLabel.setBounds(271, 66, 95, 43);
		contentPane.add(lblGameScoreLabel);
		
		JLabel lblTotalChipLabel = new JLabel("Total Chips");
		lblTotalChipLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalChipLabel.setBounds(376, 66, 95, 43);
		contentPane.add(lblTotalChipLabel);
		
		JLabel lblKittyLabel = new JLabel("Kitty: ");
		lblKittyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKittyLabel.setBounds(61, 10, 70, 43);
		contentPane.add(lblKittyLabel);
		
		JLabel lblKitty = new JLabel("0");
		lblKitty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKitty.setBounds(111, 10, 70, 43);
		lblKitty.setText(game.getKitty().getChip() + "");
		contentPane.add(lblKitty);
		
		int y = 66;
		for(int i = 0; i < game.getNumOfPlayers(); i++) {
			y+=30;
			JLabel lblName = new JLabel(game.getPlayers().get(i).getName());
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblName.setBounds(61, y, 95, 43);
			
			JLabel lblTurnScore = new JLabel("" + game.getPlayers().get(i).getCurrentScore());
			lblTurnScore.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTurnScore.setBounds(166, y, 95, 43);
			
			JLabel lblGameScore = new JLabel("" + game.getPlayers().get(i).getTotalScores());
			lblGameScore.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblGameScore.setBounds(271, y, 95, 43);
			
			JLabel lblTotalChip = new JLabel("" + game.getPlayers().get(i).getChip());
			lblTotalChip.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTotalChip.setBounds(376, y, 95, 43);
			
			contentPane.add(lblName);
			contentPane.add(lblTurnScore);
			contentPane.add(lblGameScore);
			contentPane.add(lblTotalChip);
		}
	}
}
