package view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CardsPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private FirstPanel card1 = new FirstPanel();
	private SecondPanel card2 = new SecondPanel();
	private ThirdPanel card3 = new ThirdPanel();
	
	public CardsPanel(String initialPanel)
	{
		CardLayout layout = new CardLayout();
		setLayout(layout);
		setBorder(new LineBorder(Color.BLACK));
		add(card1, "FirstState");
		add(card2, "SecondState");
		add(card3, "ThirdState");
		layout.show(this, initialPanel);
	}
}
