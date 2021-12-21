import java.util.*;


public class Student implements Comparable<Student> {
	//features of Student class
	private int id;
	private String name;
	private int duration;
	private double rating;
	//Constructor
	public Student(int id, String name, int duration, double rating) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.rating = rating;
	}
	//compares according to id
	public int compareTo(Student o) {
		if(this.id-o.id<0) {
			return -1;}
		else if(this.id-o.id>0){
			return 1;
		}
		else {
		return 0;
		}
	}
	//getter 
	public int getDuration() {
		return duration;
	}
	//checks if there is a match and returns available houses
	public PriorityQueue<House> check(PriorityQueue<House>housess) {
		PriorityQueue<House> returnList=new PriorityQueue();
		for(House each:housess) {
			if(this.rating<=each.getRating() &&each.getDuration()==0&&this.duration>0)	{
				returnList.add(each);
			}		
		}
		return returnList;
		
	
	}
	//getter
	public String getName() {
		return name;
	}
	//for semesters
	public void decreaseDuration() {
		if(this.duration>=1) {
		this.duration = duration-1;
		}
		}
}
