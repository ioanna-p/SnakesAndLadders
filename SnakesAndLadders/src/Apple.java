// IOANNA MARIA PAPAVASILEIOU, 9375, 6972055333, ipapavas@ece.auth.gr
// AIKATERINI PATSOURA , 9496, 6983582369, aikpatste@ece.auth.gr

//KLASH APPLE 
public class Apple {
	int appleId;
	int appleTileId;
	String color;
	int points;
	//Akolouthoun 3 Constructor
	//O kenos
	public Apple() {
		appleId = 0;
		appleTileId = 0;
		color ="";
		points = 0;
	}
	//Me orismata
	public Apple(int a, int b, String c,int d) {
		appleId = a;
		appleTileId = b;
		color = c;
		points = d;
	}
	//Me orisma metavlhth typou Apple
	public Apple(Apple a) {
		appleId = a.appleId;
		appleTileId = a.appleTileId;
		color = a.color;
		points = a.points;
	}
	//Getters
	public int getappleId () {
		return appleId;
	}
	public int getappleTileId() {
		return appleTileId;
	}
	public String getcolor() {
		return color;
	}
	public int getpoints() {
		return points;
	}
	//Setters
	public void setappleId(int a) {
		appleId = a;
	}
	public void setappleTileId(int a) {
		appleTileId = a;
	}
	public void setcolor(String a) {
		color = a;
	}
	public void setpoints(int p) {
		points = p;
	}
}
