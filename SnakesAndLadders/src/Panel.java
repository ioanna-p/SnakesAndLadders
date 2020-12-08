// IOANNA MARIA PAPAVASILEIOU, 9375, 6972055333, ipapavas@ece.auth.gr
// AIKATERINI PATSOURA , 9496, 6983582369, aikpatste@ece.auth.gr

import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JPanel;

//H Klassh auth tha zwgrafisei to tamplo tou paixnidiou

public class Panel extends JPanel{
	
	
	
	
	public void paint(Graphics g) {
		//DIMIOURGIA XRWMATISTWN TETRAGWNWN
		g.setColor(Color.red);
		g.fillRect(500, 500, 100, 100);
		g.fillRect(400, 100, 100, 100);
		g.fillRect(200, 100, 100, 100);
		g.fillRect(600, 200, 100, 100);
		g.fillRect(300, 200, 100, 100);
		g.fillRect(500, 300, 100, 100);
		g.fillRect(700, 400, 100, 100);
		g.fillRect(400, 400, 100, 100);
		g.fillRect(200, 400, 100, 100);
		g.setColor(Color.green);
		g.fillRect(400, 500, 100, 100);
		g.fillRect(600, 400, 100, 100);
		g.fillRect(300, 300, 100, 100);
		g.fillRect(500, 200, 100, 100);
		g.fillRect(300, 100, 100, 100);
		g.fillRect(700, 100, 100, 100);
		g.setColor(Color.blue);
		g.fillRect(300, 500, 100, 100);
		g.fillRect(600, 500, 100, 100);
		g.fillRect(200, 200, 100, 100);
		g.fillRect(400, 300, 100, 100);
		g.fillRect(600, 300, 100, 100);
		g.fillRect(700, 200, 100, 100);
		g.fillRect(500, 100, 100, 100);
		g.fillRect(200, 300, 100, 100);
		g.setColor(Color.yellow);
		g.fillRect(200, 500, 100, 100);
		g.fillRect(700, 500, 100, 100);
		g.fillRect(500, 400, 100, 100);
		g.fillRect(300, 400, 100, 100);
		g.fillRect(700, 300, 100, 100);
		g.fillRect(400, 200, 100, 100);
		g.fillRect(200, 200, 100, 100);
		g.fillRect(600, 100, 100, 100);

		
		//Noumera Plakidiwn
		g.setColor(Color.black);
		for(int i=0; i<6; i++) {
			g.drawString(""+(i+1),(210+100*i), 590);
			}
		for(int i=0; i<6; i++) {
			g.drawString(""+(i+13), (210+100*i), 390);
		}
		for(int i=0; i<6; i++) {
			g.drawString(""+(i+25), (210+100*i), 190);
		}
		
		for(int j=0; j<6; j++){
			g.drawString(""+(j+7), (710-100*j), 490);
		}
		for(int j=0; j<6; j++){
			g.drawString(""+(j+19), (710-100*j), 290);
		}
		
	}
	
	}
