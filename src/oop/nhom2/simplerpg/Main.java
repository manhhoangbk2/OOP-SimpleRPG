package oop.nhom2.simplerpg;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import java.io.*;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	private JPanel contentPane;
	private static final String DEFAULT_MAP = "PL";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/icon.png")));
		setResizable(false);
		setTitle("OOP - Simple RPG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		BackgroundPanel main_menu = new BackgroundPanel(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/menu_img_3.png")),BackgroundPanel.ACTUAL);
		main_menu.setImageAlignmentY(0.0f);
		main_menu.setImageAlignmentX(0.0f);
		contentPane.add(main_menu, "main_menu");
		FormLayout fl_main_menu = new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("400px"),
				ColumnSpec.decode("400px:grow"),
				ColumnSpec.decode("400px"),},
			new RowSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("200px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),});
		fl_main_menu.setHonorsVisibility(false);
		main_menu.setLayout(fl_main_menu);
		
		JLabel lblASimpleRpg = new JLabel("A SIMPLE RPG");
		lblASimpleRpg.setFont(new Font("Tempus Sans ITC", Font.BOLD, 62));
		lblASimpleRpg.setForeground(Color.WHITE);
		lblASimpleRpg.setHorizontalAlignment(SwingConstants.CENTER);
		main_menu.add(lblASimpleRpg, "2, 2");
		
		JButton NewGame = new JButton("New Game");
		NewGame.setFocusPainted(false);
		NewGame.setFocusable(false);
		NewGame.setContentAreaFilled(false);
		NewGame.setForeground(Color.WHITE);
		NewGame.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 55));
		NewGame.setBorder(null);
		NewGame.setOpaque(false);
		main_menu.add(NewGame, "2, 3");
		NewGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				startNewGame();
			}
		});
		
		JButton LoadGame = new JButton("Load Game");
		LoadGame.setContentAreaFilled(false);
		LoadGame.setBorderPainted(false);
		LoadGame.setForeground(Color.WHITE);
		LoadGame.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 55));
		LoadGame.setFocusable(false);
		LoadGame.setFocusPainted(false);
		main_menu.add(LoadGame, "2, 4");
		LoadGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		JButton Options = new JButton("Options");
		Options.setForeground(Color.WHITE);
		Options.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 55));
		Options.setFocusable(false);
		Options.setFocusPainted(false);
		Options.setContentAreaFilled(false);
		Options.setBorderPainted(false);
		main_menu.add(Options, "2, 5");
		Options.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		JButton Credits = new JButton("Credits");
		Credits.setHorizontalTextPosition(SwingConstants.LEFT);
		Credits.setVerticalTextPosition(SwingConstants.BOTTOM);
		Credits.setForeground(Color.WHITE);
		Credits.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		Credits.setFocusable(false);
		Credits.setFocusPainted(false);
		Credits.setContentAreaFilled(false);
		Credits.setBorderPainted(false);
		main_menu.add(Credits, "3, 6");
		Credits.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
	}
	
	/**
	 * Load maps for New Game
	 */
	private void startNewGame(){
		Map<String,AreaMap> maps = loadNewMaps();
		Game.main(maps, DEFAULT_MAP, null);
		dispose();
	}
	
	private Map<String,AreaMap> loadNewMaps(){
		Map<String,AreaMap> maps = new HashMap<String,AreaMap>(10);
		File dir = new File("res/maps");
		File [] map_list = dir.listFiles();
		NPCFactory factory = new NPCFactory();
		// Iterate through every map file
		for(File f : map_list){
			if(!(f.getName().contains(".map"))) continue;
			String [][] layout = new String [AreaMap.MAP_ROWS][AreaMap.MAP_COLS];
			String name = new String();
			try{
				BufferedReader inp = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				// Get map name and layout
				name = inp.readLine();
				for(int i=0;i<22;i++){
					String line = inp.readLine();
					layout[i] = line.split("\t",AreaMap.MAP_COLS);
				}
				
				Vector<NPC> npc = factory.getNPC(name);
				maps.put(name, new AreaMap(name,layout,npc));
				inp.close();
			}catch(IOException e){
				e.printStackTrace();
				continue;
			}catch(NullPointerException e){
				e.printStackTrace();
				continue;
			}
		}
		return maps;
	}
}
