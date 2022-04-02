package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.FirstState;
import model.Context;

public class Main extends JFrame implements Observer
{
	private static final long serialVersionUID = 1L;
	private Context context = new Context(FirstState.INSTANCE);

	private CardsPanel cards = new CardsPanel(context.getCurrentState().getName());
	private ButtonPanel buttons = new ButtonPanel(context);
	
	public Main()
	{
		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(cards, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		setTitle("Simple Wizard Demo");
		context.addObserver(this);
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				createAndShowGUI();
			}
		});
	}
	
	private static void createAndShowGUI()
	{
		new Main();
	}

	@Override
	public void update(Observable o, Object arg)
	{
		if(context == o)
		{
			((CardLayout) cards.getLayout()).show(cards, context.getCurrentState().getName());
		}
	}
}
