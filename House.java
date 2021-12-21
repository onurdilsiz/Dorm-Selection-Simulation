
public class House implements Comparable<House> {
	//features of House class
	private int id;
	private int duration;
	private double rating;
	//constructor
	public House(int id, int duration, double rating) {
		this.id = id;
		this.duration = duration;
		this.rating = rating;
	}
	
	//comparing according to id
	public int compareTo(House o) {
		if(this.id-o.id<0) {
			return -1;}
		else if(this.id-o.id>0){
			return 1;
		}
		else {
		return 0;
		}
	}
	//changing duration
	public void setDuration(int duration) {
		this.duration = duration;
	}
	//getter
	public int getDuration() {
		return duration;
	}
	//for semesters
	public void decreaseDuration() {
		if(this.duration!=0) {
			this.duration = duration-1;}
	}
	public int getId() {
		return id;
	}
	public double getRating() {
		return rating;
	}
	

	


}
