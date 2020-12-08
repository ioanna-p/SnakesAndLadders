// IOANNA MARIA PAPAVASILEIOU, 9375, 6972055333, ipapavas@ece.auth.gr
// AIKATERINI PATSOURA , 9496, 6983582369, aikpatste@ece.auth.gr


import java.util.ArrayList;

//Klash HeuristicPlayer klhronomei thn Player

public class HeuristicPlayer  extends Player{
	ArrayList<Integer[]> path;
//Akolouthoun 2 Constructor
	public HeuristicPlayer() {
		super();
	    path = new ArrayList<Integer[]>();
	}
	public HeuristicPlayer(int i,String n,int s,Board b,int size) {
		super(i,n,s,b);
	    path = new ArrayList<Integer[]>(size);
	}
//Synarthsh evaluate
	public double evaluate(int currentPos, int dice) {
		int pos2;  //proswrinh metavlhth gia th nea thesh
		int gainPoints=0;  //pontoi pou kerdizei 
	    pos2=currentPos + dice;
	    boolean flag;
	    do {              //Elegxos gia sugkekrimeno dice 
	    flag=false;	
		for(int i=0; i<board.snakes.length; i++) {
			if (pos2==board.snakes[i].getheadId()) {
				pos2 = board.snakes[i].getTailId();
				flag = true;
				
				break;
			}
		}
		for(int i=0; i<board.ladders.length; i++) {
			if(pos2==board.ladders[i].getdownStepId()) {
				if(board.ladders[i].getbroken()==false) {
					
				
				pos2=board.ladders[i].getupStepId();
				flag = true;
				
				break;}
			}
		}
		for(int i=0;i<board.apples.length;i++) {
			if(pos2==board.apples[i].getappleTileId()) {
				if(board.apples[i].getcolor()=="red") {
					gainPoints= board.apples[i].getpoints();
				}else {
				gainPoints= -board.apples[i].getpoints();}
				
				break;
			}
		}
	}while(flag);
	    double f = 0.65*(pos2-currentPos) + 0.35*gainPoints;  //Ypologismos suntelesth
	    return f;	    
	}
//Synarthsh getNextMove
	public int getNextMove(int currentPos) {
		double[] array = new double[6];   //pinakas suntelestwn. To stoixeio i exei to suntelesth   
		for(int i=1; i<=6; i++) {         // gia thn kinhsh me zari i+1
			array[i-1] = evaluate(currentPos,i);                             
		}
		//Euresh ths kinhshs me ton kalutero suntelesth
		double max;
		max=array[0];
		int index = 0;
		for(int i=1; i<6; i++) {
			if(array[i]>max) {
				max =array[i];
				index = i;
			}
		}
		//Klhsh ths sunarthshs move gia thn kaluterh kinhsh
		//gia na sugkentrwsoume ta stoixeia tou gurou
		int [] array2 = new int[8];                //array[0] -> nea thesh, [1] -> num of snakes [2] -> ladders
		array2 = move(currentPos,(index+1));       //[3] -> red apples  [4] -> black apples [5] ->round points
		                      
		
		// Dhmiourgia array3 me ola ta stoixei tou gurou gia na 
		// perastei sto path
		Integer[] array3 = new Integer[8];
		for (int i=0; i<array2.length; i++) {
			array3[i] = (Integer) (array2[i]);
		}
		array3[6] = index+1;
		array3[7]= array2[0] - currentPos;
		path.add(array3);
		currentPos = array2[0];   //Ananewsh ths neas theshs
		
		
		return currentPos;
	}
	public void statistics() {
		
		//Ektypwsh Stoixewn Gyrwn
		   for(int i=0;i<path.size();i++) {
			   System.out.println("ROUND " + (i+1));
			   System.out.print("Dialexe zari: " + path.get(i)[6]);
			   if(path.get(i)[1]!=0) {
				   System.out.print(" .Epese se: " +path.get(i)[1] + " kefalia fidiwn");
			   }
			   if(path.get(i)[2]!=0) {
				   System.out.print(" .Epese se: " +path.get(i)[2] + " vaseis skalwn");
			   }
			   if(path.get(i)[3]!=0) {
				   System.out.print(" .Efage: " +path.get(i)[3] + " kokkina mhla");
			   }
			   if(path.get(i)[4]!=0) {
				   System.out.print(" .Efage: " +path.get(i)[4] + " maura mhla");
			   }
			   if(path.get(i)[5]!=0) {
				   System.out.print(" .Phre: " +path.get(i)[5] + " pontous");
			   }
			   System.out.println(" .Ekane: " + path.get(i)[7] + " vhmata");
			   
		   }
		//Ektypvsh Sunolikwn Stoixeiwn
		int a=0,b=0,c=0,d=0;
		for(int i=0; i<path.size(); i++ ) {
			a= a+ path.get(i)[1]; //athroisma fidiwn
			b= b + path.get(i)[2]; //athroisma skalwn
			c=c+ path.get(i)[3]; // athroisma kokkinwn mhlwn
			d = d + path.get(i)[4]; // athroisma maurwn mhlwn
		}
		System.out.println("Sunolika Stoixeia");
		System.out.println("O Heuristic paixths epese se: " +a + " kefalia fidiwn kai se: " + b+ " baseis skalwn. Efage: "+ c+ " kokkina mhla kai: "+ d+ " maura mhla");
		
	}

}
