package oop.nhom2.simplerpg;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class Game extends JFrame {
	AreaMap current_map;
	/**
	 * Launch the application.
	 */
	public static void main(Map<String,AreaMap> maps, String current, Point player) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game(maps,current,player);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Game(Map<String,AreaMap> maps, String current, Point player) {
		setBackground(Color.BLACK);
		getContentPane().setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/icon.png")));
		setResizable(false);
		setTitle("OOP - Simple RPG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		getContentPane().setLayout(new BorderLayout(0,0));
		
		current_map = maps.get(current);
		current_map.setPlayed(true);
		getContentPane().add(current_map.getView());
	}

}
