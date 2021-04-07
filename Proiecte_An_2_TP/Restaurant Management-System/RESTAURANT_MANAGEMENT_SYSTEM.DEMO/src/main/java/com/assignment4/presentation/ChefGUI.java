package com.assignment4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import com.assignment4.business.Restaurant;

@SuppressWarnings("deprecation")
public class ChefGUI extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	JLabel l1 = new JLabel(" Comenzile in asteptare:");
	TextArea text = new TextArea("");
	Restaurant restaurant;

	public ChefGUI(Restaurant r) {
		this.restaurant = r;
		JPanel panelM = new JPanel();
		panelM.setLayout(new GridLayout(2, 1));
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 1));
		panel1.add(l1);
		l1.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 25));

		panelM.add(panel1);
		panelM.add(text);
		l1.setBackground(Color.decode("#F7DDC6"));
		l1.setOpaque(true);
		text.setBackground(Color.decode("#F7DDC6"));
		text.setFont(new Font("Sitka Banner", 0, 12));

		this.setContentPane(panelM);
		this.setTitle("Sef bucatar");
		this.setSize(500, 370);
		this.setLocation(1000, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {

		text.append((String) arg + "\n");
	}

}