// IOANNA MARIA PAPAVASILEIOU, 9375, 6972055333, ipapavas@ece.auth.gr
// AIKATERINI PATSOURA , 9496, 6983582369, aikpatste@ece.auth.gr

//Klash Snake
public class Snake {
	int snakeId ;
	int headId;
	int TailId;
	//Akolouthoun 3 Constructor
	//O kenos
	public Snake() {
		snakeId = 0;
		headId = 0;
		TailId = 0;
	}
	//Me orismata
	public Snake(int a, int b, int c) {
		snakeId = a;
		headId = b;
		TailId = c;	
	}
	//Me orisma metavlith typou Snake
	public Snake(Snake s) {
		snakeId = s.snakeId;
		headId = s.headId;
		TailId = s.TailId;
	}
	//Getters
	public int getsnakeId() {
		return snakeId;
	}
	public int getheadId() {
		return headId;
	}
	public int getTailId() {
		return TailId;
	}
	//Setters
	public void setsnakeId(int i) {
		snakeId = i;
	}
	public void setheadId(int h) {
		headId = h;
	}
	public void setTailId(int t) {
		TailId = t;
	}
}
