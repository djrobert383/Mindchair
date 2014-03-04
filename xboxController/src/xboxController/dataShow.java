package xboxController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.java.games.input.Component;

public class dataShow extends JFrame {
	private Component yAxis, xAxis;
	private JPanel panel;

	public dataShow(Component xAxis, Component yAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		panel = new JPanel();
		add(panel);
		setVisible(true);
		setSize(new Dimension(500, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Graphics g = panel.getGraphics();
		g.setColor(Color.BLACK);
		while (true) {
			g.fillOval(500, 500, (int) ((xAxis.getPollData() * 100) + 250),
					(int) ((yAxis.getPollData() * 100) + 250));
		}
	}
}
