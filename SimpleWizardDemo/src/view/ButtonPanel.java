package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.Context;

public class ButtonPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JButton nextBtn = new JButton("Next");
	private JButton prevBtn = new JButton("Prev");
	
	private Context context;
	
	public ButtonPanel(Context context)
	{
		this.context = context;
		setBorder(new LineBorder(Color.BLACK));
		add(prevBtn);
		add(nextBtn);
		init();
	}
	
	public void init()
	{
		prevBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				context.goPrevious();
			}
		});
		
		nextBtn.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				context.goNext();
			}
		});
	}
}
