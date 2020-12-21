package skunk.domain;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.DropMode;

// This is the UI for Guide
public class GuideGUI extends JFrame {

	private JPanel contentPane;

	public GuideGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 556, 434);
		contentPane.add(scrollPane);

		JTextPane txtpnRulesOfSkunk = new JTextPane();
		
		
		txtpnRulesOfSkunk.getStyledDocument();
		txtpnRulesOfSkunk.setText(
				"Rules of Skunk\r\n\r\nDIRECTIONS FOR PLAYING\r\n\r\nThe object of the game is to accumulate a score of 100 points or more. "
				+ "A score is made by rolling the dice and combining the points on the two dice. "
				+ "For example: A 4 and 5 would be 9 points - if the player decides to take another roll of the dice and turns up a 3 and 5 (8 points), "
				+ "he would then have an accumulated total of 17 points for the two rolls. "
				+ "The player has the privilege of continuing to shake to increase his score or of passing the dice to wait for the next series, "
				+ "thus preventing the possibility of rolling a Skunk and losing his score.\r\n\r\n"
				+ "PENALTIES:\r\n\r\nA "
				+ "skunk in any series voids the score for that series only and draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.\r\n\r\n"
				+ "A skunk and a deuce voids the score for that series only and draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice.\r\n\r\n"
				+ "TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice. "
				+ "Player must again start to score from scratch.\r\n\r\nAny number can play. [Assume at least two players!] The suggested number of chips to start is 50. "
				+ "There are sufficient chips in the box to allow 8 players to start with 50 chips by placing a par value of \"one\" on white chips, "
				+ "5 for 1 on red chips and 10 for 1 on the blue chips.\r\n\r\n"
				+ "The first player to accumulate a total of 100 or more points can continue to score as many points over 100 as he believes is needed to win. "
				+ "When he decides to stop, his total score is the “goal.” Each succeeding player receives one more chance to better the goal and end the game.\r\n\r\n"
				+ "The winner of each game collects all chips in \"kitty\" and in addition ﬁve chips from each losing player or 10 chips from any player without a score.\r\n");
		scrollPane.setViewportView(txtpnRulesOfSkunk);
	}
}
