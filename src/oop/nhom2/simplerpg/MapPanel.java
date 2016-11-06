package oop.nhom2.simplerpg;

import java.util.Vector;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MapPanel extends JPanel {
	/**
	 * Terrain map:
	 * 0 = unused/unreachable
	 * 1 = grass
	 * 1.0 = tree on grass
	 * 2 = dirt
	 * 3 = water*/
	private BackgroundPanel [][] cells;
	public MapPanel(String [][] layout, int rows, int cols, Vector<NPC> npc) {
		this.setBorder(new LineBorder(Color.BLACK, 13));
		cells = new BackgroundPanel[rows][cols];
		setLayout(new GridLayout(rows, cols, 0, 0));
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				Image cell_bg = null;
				switch(layout[i][j]){
					case "0":
						cell_bg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/tiles/no_tile.png"));
						break;
					case "1":
						cell_bg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/tiles/grass_tile.png"));
						break;
					case "1.0":
						cell_bg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/tiles/grass_tree_tile.png"));
						break;
					case "2":
						cell_bg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/tiles/dirt_tile.png"));
						break;
					case "3":
						cell_bg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/tiles/water_tile.png"));
						break;
					default:
						cell_bg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/tiles/transition_tile.png"));
						break;
				}
				
				cells[i][j] = new BackgroundPanel(cell_bg,BackgroundPanel.ACTUAL);
				cells[i][j].setOpaque(true);
				this.add(cells[i][j]);
			}
		}
		
		for(NPC n : npc){
			//TODO Add NPC display
			cells[n.getPos().x][n.getPos().y].add(n.getLabel());
		}
	}
}
