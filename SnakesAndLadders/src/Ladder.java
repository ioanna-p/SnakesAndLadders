
//KLASH LADDER
public class Ladder {
	int ladderId;
	int upStepId;
	int downStepId;
	boolean broken;
	//Akolouthoun 3 Constructor
	//O kenos
	public Ladder() {
		ladderId = 0;
		upStepId = 0;
		downStepId = 0;
		broken = false;
	}
	//Me orismata
	public Ladder(int a, int b, int c, boolean d) {
		ladderId = a;	
		upStepId = b;
		downStepId = c;
		broken = d;
	}
	//Me orisma Ladder
	public Ladder(Ladder l) {
		ladderId = l.ladderId;
		upStepId = l.upStepId;
		downStepId = l.downStepId;
		broken = l.broken;
	}
	//Getters
	public int getladderId() {
		return ladderId;
	}
	public int getupStepId() {
		return upStepId;
	}
	public int getdownStepId() {
		return downStepId;
	}
	public boolean getbroken() {
		return broken;
	}
	//Setters
	public void setladderId(int a) {
		ladderId = a;
	}
	public void setupStepId(int i) {
		upStepId = i;
	}
	public void setdownStepId(int i) {
		downStepId = i;
	}
	public void setbroken(boolean b) {
		broken = b;
	}
}
