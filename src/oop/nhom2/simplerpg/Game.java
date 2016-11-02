package oop.nhom2.simplerpg;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class Game extends JFrame {
	private Map<String,AreaMap> maps;
	private String current;
	private AreaMap current_map;
	private Player player;
	
	/**
	 * Launch the application.
	 */
	public static void main(Map<String,AreaMap> maps, String current, Player player) {
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
	public Game(Map<String,AreaMap> maps, String current, Player player) {
		setBackground(Color.BLACK);
		getContentPane().setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/icon.png")));
		setResizable(false);
		setTitle("OOP - Simple RPG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		getContentPane().setLayout(new BorderLayout(0,0));
		addKeyListener(new Controls());
		
		this.maps = maps;
		this.current = current;
		this.player = player;
		mapChange();
	}
	
	private void mapChange(){
		current_map = maps.get(current);
		current_map.setPlayed(true);
		getContentPane().removeAll();
		getContentPane().add(current_map.getView(),BorderLayout.CENTER);
	}
	
	private class Controls implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int key = e.getKeyCode();
			switch(key){
				case KeyEvent.VK_UP:
					System.out.println("Up");
					break;
				case KeyEvent.VK_DOWN:
					System.out.println("Down");
					break;
				case KeyEvent.VK_RIGHT:
					System.out.println("Right");
					break;
				case KeyEvent.VK_LEFT:
					System.out.println("Left");
					break;
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub	
			
		}
	}
}
