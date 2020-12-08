
//KLASH BOARD
public class Board {
	int M,N;
	int [][] tiles;
	Snake[] snakes;
	Ladder[] ladders;
	Apple[] apples;
	//kenos Constructor
	public Board() {
		M=0;
		N=0;
		tiles = new int[0][0];
		snakes = new Snake [0];
		ladders = new Ladder [0];
		apples = new Apple [0];
	}
	//Constructor me orismata
	public Board(int m, int n, int s, int l,int a) {
		M =n;
		N = m;
		snakes = new Snake[s];
		ladders = new Ladder[l];
		apples = new Apple[a];
		tiles = new int[N][M];
	}
	//Constructor me orisma typou Board
	public Board (Board b) {
		M= b.M;
		N = b.N;
		snakes = new Snake[b.snakes.length];
		for (int i=0; i<b.snakes.length;i++) {
			snakes[i]= new Snake(b.snakes[i]);
		}
		ladders = new Ladder[b.ladders.length];
		for(int i=0; i<b.ladders.length;i++) {
			ladders[i] = new Ladder (b.ladders[i]);
		}
		apples = new Apple[b.apples.length];
		for(int i=0; i<b.apples.length;i++) {
			apples[i] = new Apple (b.apples[i]);
		}
		tiles = new int[N][M];
		
	}
	//Getters
	public int getM() {
		return M;
	}
	public int getN() {
		return N;
	}
	public Snake getSnake(int i) {
		return snakes[i];
	}
	public Ladder getLadder(int i) {
		return ladders[i];
	}
	public Apple getApple(int i) {
		return apples[i];
	}
	public int gettile(int i, int j) {
		return tiles[i][j];
	}
	//Setters
	public void setMandN(int i, int j) {
		N = i;
		M = j;
	}
	public void setSnake(int i, Snake s) {
		snakes[i]= s;
	}
	public void setLadder(int i, Ladder l) {
		ladders[i] = l;
	}
	public void setApple(int i , Apple a) {
		apples[i] = a;
	}
	public void createBoard() {
		// tiles
		for (int i = N-1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if ((i+1)%2 == 0) {
					tiles[i][j] = j+1 + (N-i-1)*M;
				}else {
					tiles[i][M-j-1] = j+1 + (N-i-1)*M;
				}	
			}
		}
		
		// snakes
		for (int i = 0; i < snakes.length ; i++) {
			int randomHead = N + (int)(Math.random()*(N*M - N)); //the head must not be at level 1
			int levelHead = (randomHead-1)/N;
			int randomTail = (int)(Math.random()*(N*levelHead)); 
			snakes[i] = new Snake(i, randomHead, randomTail);
		}
		
		// ladders
		for (int i = 0; i < ladders.length ; i++) {
			int randomUpStep =  N + (int)(Math.random()*(N*M - N)); 
			int levelUpStep = (randomUpStep-1)/N;
			int randomDownStep;
			boolean F;
			
			// avoid having a base of a ladder on a tile that there is a snake's head
			do {
				F = false;
				randomDownStep = (int)(Math.random()*(N*levelUpStep)); 
				 for (int j = 0; j < snakes.length ; j++) {
					 if (snakes[j].getheadId() == randomDownStep) {
						 F = true;
						 break;
					 }
				 }
			}while(F);
			ladders[i] = new Ladder(i, randomUpStep, randomDownStep, false);
		}		
		
		// apples
		for (int i = 0; i < apples.length ; i++) {
			String color = "";
			int points = 0;
			int tileId;
			boolean F;
			
			// avoid having an apple on a tile that there is a snake's head
			do {
				F = false;
				 tileId = (int)(Math.random()*(N*M))+1;
				 for (int j = 0; j < snakes.length ; j++) {
					 if (snakes[j].getheadId() == tileId) {
						 F = true;
						 break;
					 }
				 }
			}while(F);
			
			// color
			if ((int)(Math.random()*2)==1) {
				color = "red";
			}else {
				color = "black";
			}
			
			// points
			points = (int)(Math.random()*11);
			
			// create apple
			apples[i] = new Apple(i, tileId, color, points);
		}	
	}
	
	public void createElementBoard() {
		System.out.println("************ Element Board ************");
		System.out.println("Snakes");
		String[][] elementBoardSnake = new String[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				elementBoardSnake[i][j] = "___";
				// check for snake
				for (int t = 0; t < snakes.length ; t++) {
					 if (snakes[t].getheadId() == tiles[i][j]) {
						 elementBoardSnake[i][j] = "SH" + snakes[t].getsnakeId();
						 break;
					 }
					 if (snakes[t].getTailId() == tiles[i][j]) {
						 elementBoardSnake[i][j] = "ST" + snakes[t].getsnakeId();
						 break;
					 }
				 }
				
				System.out.print(elementBoardSnake[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Ladders");
		String[][] elementBoardLadder = new String[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				elementBoardLadder[i][j] = "___";
				// check for ladder 
				for (int t = 0; t < ladders.length ; t++) {
					 if (ladders[t].getupStepId() == tiles[i][j]) {
						 elementBoardLadder[i][j] = "LU" + ladders[t].getladderId();
						 break;
					 }
					 if (ladders[t].getdownStepId() == tiles[i][j]) {
						 elementBoardLadder[i][j] = "LD" + ladders[t].getladderId();
						 break;
					 }
				 }

				System.out.print(elementBoardLadder[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Apples");
		String[][] elementBoardApple = new String[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				elementBoardApple[i][j] = "___";
				// check for ladder 
				for (int t = 0; t < apples.length ; t++) {
					 if (apples[t].getappleTileId() == tiles[i][j]) {
						 if (apples[t].getcolor() == "red") {
							 elementBoardApple[i][j] = "AR" + apples[t].getappleId();
							 break; 
						 }else {
							 elementBoardApple[i][j] = "AB" + apples[t].getappleId();
							 break;
						 }
					 }
				 }

				System.out.print(elementBoardApple[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
}

	
