// IOANNA MARIA PAPAVASILEIOU, 9375, 6972055333, ipapavas@ece.auth.gr
// AIKATERINI PATSOURA , 9496, 6983582369, aikpatste@ece.auth.gr



import java.awt.Color;

import java.awt.event.*;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;




//Klash GAME
public class Game {
	int round;
	
	//Constructors
	public Game() {
		round = 0;
	}
	public Game(int r) {
		round = r;
	}
	public Game(Game g) {
		round = g.getround();
	}
	//Getter kai Setter
	public int getround() {
		return round;
	}
	public void setround(int h) {
		round = h;
	}

	static int tile1=0,tile2=0;
	static 	Player p1=null,p2=null;
	static HeuristicPlayer p3=null,p4=null;
	
    //MAIN
	public static void main(String[] args) {
		Game g = new Game(0);
		Board b = new Board(6,5,3,3,3);
		
		
		JLabel winner = new JLabel();
		
		
		JLabel ltotalscoreA = new JLabel();
		JLabel ltotalscoreB = new JLabel();
		JLabel lmovescoreA = new JLabel();
		JLabel lmovescoreB = new JLabel();
		JLabel lround = new JLabel();
		JLabel lplayerA =new JLabel("PLAYER A");
		JLabel lplayerB = new JLabel("PLAYER B");
		JLabel ltileA = new JLabel();
		JLabel ltileB = new JLabel();
		
		lround.setBounds(500,600,100,100);
		
		lplayerA.setBounds(110, 600, 100, 100);
		lplayerB.setBounds(800, 600, 100, 100);
		ltotalscoreA.setBounds(110, 700, 100, 50);
		ltotalscoreB.setBounds(800, 700, 100, 50);
		ltotalscoreA.setText("Total Score: ");
		ltotalscoreB.setText("Total Score: ");
		lmovescoreA.setBounds(110, 650, 100, 50);
		lmovescoreB.setBounds(800, 650, 100, 50);
		lmovescoreA.setText("Move Score: ");
		lmovescoreB.setText("Move Score: ");
		ltileA.setBounds(110, 750, 100, 50);
		ltileB.setBounds(800, 750, 150, 50);
		ltileB.setText("Tile: ");
		ltileA.setText("Tile: ");
		
		winner.setBounds(500,100,100,50);
		
		
		JFrame frame = new JFrame();      //Dimiourgia Frame
		

		
		
		//3 Jbuttons
		JButton b1 = new JButton("Play");
		b1.setBounds(500, 800, 100, 50);
		b1.setEnabled(false); //arxika apenergopoihmeno
		
		JButton b2 = new JButton("Quit");
		b2.setBounds(610, 800, 100, 50);
		//Quitbutton 
		//Otan patithei termatizetai to programma
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			
			}
		});
		
		
		//To button auto dhmiourgei to board
		//kai meta apenergopoieitai
		JButton b3 = new JButton("Generate Board");
		b3.setBounds(300, 800, 190, 50);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.createBoard();      //Dhmioyrgia Board
				
				b.createElementBoard();
				b3.setEnabled(false); //apenergopoieitai
				b1.setEnabled(true);  // energopoieitai to koumpi play
			
			}
			
		});
		
		
		
		
		//2 Jcomboboxes
		final String[] s= {"Random Player", "Heuristic Player"} ;
		JComboBox jb1 = new JComboBox(s);
		jb1.setBounds(0, 800, 200, 100);
		jb1.setSelectedIndex(0);
		jb1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String choice = (String) jb1.getSelectedItem();
				setTypeOfPlayer(choice);
				jb1.setEnabled(false); //apenergopoieitai molis patithei
			}
		//Dhmiourgia protou paixth
		public  void setTypeOfPlayer(String s) {
			
			if(s=="Random Player") {
				p1= new Player(1,"Player A",0,b);
			}
			else  {
				p3= new HeuristicPlayer(1,"Player A",0,b,10);
			}
			
			
			}
		});
		
		JComboBox jb2 = new JComboBox(s);
		jb2.setBounds(780, 800, 200, 100);
		jb2.setSelectedIndex(0);
		
		jb2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String choice = (String) jb2.getSelectedItem();
				setTypeOfPlayer(choice); //synarthsh dhmiourgias 2ou paixth
				jb2.setEnabled(false); // apenergopoieitai molis patithei
			}
		
		public  void setTypeOfPlayer(String s) {
			
			if(s=="Random Player") {
				p2 =new Player(1,"Player A",0,b);
			}
			else {
				p4 =new HeuristicPlayer(1,"Player A",0,b,10);
			}
			
			
			}
		});
		
		
		//Ta koumpia kai ta ComboBoxes prostithontai sto frame
		frame.add(jb1);
		frame.add(b2);
		frame.add(b1);
		frame.add(b3);
		
		frame.add(jb2);
		
		frame.add(lplayerA);
		frame.add(lplayerB);
		
		
		
		//Xarakthristika Frame
		frame.setSize(1000, 1000); //Diastaseis
		frame.setLocationRelativeTo(null);
		frame.setTitle("Snake Game");
		
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JLabel 
		JLabel label = new JLabel();
		label.setText(" ");
		label.setBounds(500,50 , 90, 20);
		
		//Prosthikh twn JLabel sto Frame
		
		frame.add(lmovescoreA);
		frame.add(lmovescoreB);
		frame.add(ltotalscoreA);
		frame.add(ltotalscoreB);
		frame.add(lround);
		frame.add(ltileA);
		frame.add(ltileB);
		
		frame.add(label);
		
		
		
		frame.setVisible(true); //To frame einai orato
		
		
		frame.getContentPane().add(new Panel()); // Graghika tou frame 
		
		//Leitoutrgia PLAY BUTTON
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int[] array =PlayOneRound(); //Sunarthsh gia ena guro paixnidiou
				if(array!=null) {
				UpdateGraphics(array);} //Sunarthsh ananewshs grafikwn
			}
			
			
			
				public int[] PlayOneRound() {
					
					int[] array1 = new int[6]; 
					int[] array2=new int [6];
					int[] results = new int[5];
					int dice1=0;
					int dice2=0;
					
					if(p1!=null && p4!=null) { //random vs heuristic
						g.round++;
						dice1 = (int)((Math.random())*6);
						array1 =p1.move(tile1, dice1);
						tile1 = array1[0];
						tile2 =p4.getNextMove(tile2);
						results[0]= g.round;        //round
						results[1]= array1[5];      //round points of player A
						results[2]=p1.getscore();   // score of player A
						results[3]=(int) (p4.path.get(g.round-1)[5]);   //round points of player B
					    results[4]=p4.getscore();                       //score of player B
						
					    
					    if(g.round>=10 || tile1>=30 || tile2>=30) {
							b1.setEnabled(false); //AN TERMATISTEI TO PAIXNIDI TO PLAYBUTTON APENERGOPOIEITAI
					    if(g.round<10) {
				    		if(tile1>tile2) {
				    			winner.setText("PLAYER A WINS");
				    		}else {
				    			winner.setText("PLAYER B WINS");
				    		}
				    	} else {
				    		if(p1.getscore()> p4.getscore()) {
				    			winner.setText("PLAYER A WINS");
				    		}else if(tile1>tile2) {
				    			winner.setText("PLAYER A WINS");
				    		}
				    		else {
				    			winner.setText("PLAYER B WINS");
				    		}
				    	}
					    }
				    frame.add(winner);
						return results;
					}
					else if(p1!=null && p2!=null){ //random vs random
						g.round++;
						dice1 = (int)((Math.random())*6);
						dice2= (int)((Math.random())*6);
						array1 =p1.move(tile1, dice1);
						tile1 = array1[0];
						array2=p2.move(tile2, dice2);
						tile2=array2[0];
						results[0]= g.round;        //round
						results[1]= array1[5];      //round points of player A
						results[2]=p1.getscore();   // score of player A
						results[3]=array2[5];   //round points of player B
					    results[4]=p2.getscore();                       //score of player B
						
					   
					    if(g.round>=10 || tile1>=30 || tile2>=30) {
							b1.setEnabled(false);
					    if(g.round<10) {
				    		if(tile1>tile2) {
				    			winner.setText("PLAYER A WINS");
				    		}else {
				    			winner.setText("PLAYER B WINS");
				    		}
				    	} else {
				    		if(p1.getscore()> p2.getscore()) {
				    			winner.setText("PLAYER A WINS");
				    		}else if(tile1>tile2) {
				    			winner.setText("PLAYER A WINS");
				    		}
				    		else {
				    			winner.setText("PLAYER B WINS");
				    		}
				    	}
					    }
				    frame.add(winner);
						return results;
					}
					else if(p3!=null&& p2!=null) { //heuristic vs random
						g.round++;
						int dice = (int)((Math.random())*6);
						array1 =p2.move(tile2, dice);
						tile2 = array1[0];
						tile1 =p3.getNextMove(tile1);
						results[0]= g.round;        //round
						results[1]=(int) (p3.path.get(g.round-1)[5]);      //round points of player A
						results[2]=p3.getscore();   // score of player A
						results[3]=array1[5] ;  //round points of player B
					    results[4]=p2.getscore();                       //score of player B
						
					    
					    if(g.round>=10 || tile1>=30 || tile2>=30) {
							b1.setEnabled(false);
					    if(g.round<10) {
				    		if(tile1>tile2) {
				    			winner.setText("PLAYER A WINS");
				    		}else {
				    			winner.setText("PLAYER B WINS");
				    		}
				    	} else {
				    		if(p3.getscore()> p2.getscore()) {
				    			winner.setText("PLAYER A WINS");
				    		}else if(tile1>tile2) {
				    			winner.setText("PLAYER A WINS");
				    		}
				    		else {
				    			winner.setText("PLAYER B WINS");
				    		}
				    	}
					    }
				    frame.add(winner);
						return results;
					    }
					
					else if(p3!=null && p4!=null ){ //heuristic vs heuristic
						g.round++;
						tile1 = p3.getNextMove(tile1);
						tile2 =p4.getNextMove(tile2);
						results[0]= g.round;        //round
						results[1]= (int) (p3.path.get(g.round-1)[5]);;      //round points of player A
						results[2]=p3.getscore();   // score of player A
						results[3]=(int) (p4.path.get(g.round-1)[5]);   //round points of player B
					    results[4]=p4.getscore();                       //score of player B
						
					    
					    if(g.round>=10 || tile1>=30 || tile2>=30) {
							b1.setEnabled(false);
					    	if(g.round<10) {
					    		if(tile1>tile2) {
					    			winner.setText("PLAYER A WINS");
					    		}else {
					    			winner.setText("PLAYER B WINS");
					    		}
					    	} else {
					    		if(p3.getscore()> p4.getscore()) {
					    			winner.setText("PLAYER A WINS");
					    		}else if(tile1>tile2){
					    			winner.setText("PLAYER A WINS");
					    		}
					    		else {
					    			winner.setText("PLAYER B WINS");
					    		}
					    	}
					    }
					    frame.add(winner);
						return results;
					}
					else return null;
					
			}
			
			public void UpdateGraphics(int[] array) {
				
				//Nees times gia ta score kai thn thesh twn 2 paiktwn
				ltotalscoreA.setText("Total Score: " + array[2]);
				
				
				ltotalscoreB.setText("Total Score: " +array[4] );
				
				
				lmovescoreA.setText("Move Score: "+ array[1]);
				
				
				lmovescoreB.setText("Move Score: "+ array[3]);
				
				
				lround.setText("Round: "+ array[0]);
				
				ltileA.setText("Tile: " + tile1 );
				
				
				ltileB.setText("Tile: " + tile2 );
				
				
				
				
			}
		});
		
		
			
}

	
	
}
		

 

