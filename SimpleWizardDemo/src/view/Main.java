package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.State;
import model.Context;

public class Main extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private Context context;
	private CardsPanel cards;
	private ButtonPanel buttons;

	public Main(String initialPanel) {
		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			Enum<?> myEnum = getInstance("controller." + initialPanel);
			context = new Context((State) myEnum);
			cards = new CardsPanel(initialPanel);
			add(cards, BorderLayout.CENTER);

			buttons = new ButtonPanel(context);
			add(buttons, BorderLayout.SOUTH);

			setTitle("Simple Wizard Demo");
			context.addObserver(this);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			throw new RuntimeException("Need to pass state enum's name as a sigle argument (i.e. FirstState)");
		}
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI(args[0]);
			}
		});
	}

	@SuppressWarnings("unchecked")
	public static <T extends Enum<T>> T getInstance(String name) throws ClassNotFoundException {
		return Enum.valueOf((Class<T>) Class.forName(name), "INSTANCE");
	}

	private static void createAndShowGUI(String initialPanel) {
		new Main(initialPanel);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (context == o) {
			((CardLayout) cards.getLayout()).show(cards, context.getCurrentState().getName());
		}
	}
}
