
//KLASH PLAYER
public class Player {
	int playerId;
	String name;
	int score;
	Board board;
	//Kenos Constructor
	public Player() {
		playerId=0;
		name=" ";
		score=0;
		board=new Board();
	}
	//Constructor me orismata
	public Player(int pid,String n,int sc,Board b) {
		playerId=pid;
		name=n;
		score=sc;
		board=b;
}
	//Getters
	public int getplayerid() {
		return playerId;
	}
	public String getname() {
		return name;
	}
	public int getscore() {
		return score;
	}
	public Board getboard() {
		return board;
	}
	//Setters
	public void setplayerid(int pid) {
		playerId=pid;
	}
	public void setname(String n) {
		name=n;
	}
	public void setscore(int sc) {
		score=sc;
	}
	public void setboard(Board b) {
		board=b;
	}
	//SYNARTHSH MOVE
	public int[] move(int id, int die) {
		int newPosition = id + die;
		boolean flag;
		int[] result = new int[6];
		for (int i = 0; i < result.length; i++) {
			result[i] = 0;
		}
		
		do {
			flag = false;
			// check for snake' s head
			for (int j = 0; j < board.snakes.length ; j++) {
				 if (board.snakes[j].getheadId() == newPosition) {
					 flag = true;
					 newPosition = board.snakes[j].getTailId();
					 result[1]++;
					
					 break;
				 }
			 }
			
			// check for ladder's downstep 
			for (int j = 0; j < board.ladders.length ; j++) {
				 if (board.ladders[j].getdownStepId() == newPosition) {
					 if (board.ladders[j].getbroken() == false) {
						 flag = true;
						 newPosition = board.ladders[j].getupStepId();
						 result[2]++;
						 
						 board.ladders[j].setbroken(true);
						 break;
					 }
				 }
			 }
			
			// check for apple
			for (int j = 0; j < board.apples.length ; j++) {
				 if (board.apples[j].getappleTileId() == newPosition) {
					 if (board.apples[j].getcolor() == "red"){
					     score += board.apples[j].getpoints(); 
					     result[3]++;
					     result[5]+= board.apples[j].getpoints();
					 }else {
						 score -= board.apples[j].getpoints();
						 result[4]++;
						 result[5]-= board.apples[j].getpoints();
					 }
					 board.apples[j].setpoints(0); 
					 
				 }
			 }
		} while(flag);

		result[0] = newPosition;
		return(result);
	}
		
	}

