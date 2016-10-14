package oop.nhom2.simplerpg;

import java.util.Vector;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class MapPanel extends JPanel {
	private JLabel [][] cells;
	public MapPanel(String [][] layout, int rows, int cols, Vector<NPC> npc) {
		cells = new JLabel[rows][cols];
		
		setLayout(new GridLayout(rows, cols, 0, 0));
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				cells[i][j] = new JLabel();
				Color cell_color;
				switch(layout[i][j]){
					case "0":
						cell_color = Color.DARK_GRAY;
						break;
					case "1":
						cell_color = new Color(51,255,51);
						break;
					case "2":
						cell_color = new Color(51,25,0);
						break;
					case "3":
						cell_color = new Color(153,204,255);
						break;
					default:
						cell_color = new Color(255,255,102);
				}
				cells[i][j].setOpaque(true);
				cells[i][j].setBackground(cell_color);
				this.add(cells[i][j]);
			}
		}
		
		for(int i=0;i<npc.size();i++){
			//TODO Add NPC display
		}
	}
}
