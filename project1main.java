import java.io.*;
import java.util.*;

public class project1main {

	public static void main(String[] args) {
	
		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		
		PrintStream outstream1;//for printing outfile
		try {
		        outstream1 = new PrintStream(outFile);
		}catch(FileNotFoundException e2) {
		        e2.printStackTrace();
		        return;
		}
		Scanner reader;//to scan input
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			outstream1.close();
			return;
		}
		//priority queues of houses and students 
		PriorityQueue<House> houses=new PriorityQueue();
		PriorityQueue<Student> students=new PriorityQueue();
		PriorityQueue<Student> matchedstudents=new PriorityQueue();

		ArrayList<House> fullHouses=new ArrayList();

		//scanning input
		while(reader.hasNextLine()) {
				try {
					String decider=reader.next();
					//creates a new House object
					if(decider.equals("h")) {
						House house =new House(Integer.parseInt(reader.next()),Integer.parseInt(reader.next()),Double.parseDouble(reader.next()));
						if(house.getDuration()==0) {
							houses.add(house);
						}
						else {
							fullHouses.add(house);
						}
					}
					// creates a new Student object
					if(decider.equals("s")) {
						Student student= new Student(Integer.parseInt(reader.next()),reader.next(),Integer.parseInt(reader.next()),Double.parseDouble(reader.next()));
		//				System.out.println(student.toString());
						students.add(student);
					}
					}
				catch(Exception e) {
					break;
				}
			
		}
		// for 8 semesters processes will be applied
		for(int i =0;i<8;i++) {
			// a list for who can not be settled
			PriorityQueue<Student> unmatchedstudents=new PriorityQueue();
			// until students is empty, the program is looking for matches
			while(!students.isEmpty()) {
				Student each=students.poll();
				PriorityQueue<House> availableHouses=each.check(houses);

				if(!availableHouses.isEmpty()) {
					House matched=availableHouses.poll();				
					houses.remove(matched);
					matchedstudents.add(each);
					matched.setDuration(each.getDuration());
					fullHouses.add(matched);
				}
				else {
					unmatchedstudents.add(each);
					continue;
				}
			}
			//assigns unmatched list to students to check them next semester 
			students=unmatchedstudents;
			for(House each:houses) {
				each.decreaseDuration();
			}
			//an ArrayList keeps houses which will be erased fullhouses list 
			ArrayList<House> toErase=new ArrayList();
			for(House each: fullHouses) {
				each.decreaseDuration();
				if(each.getDuration()==0) {
					toErase.add(each);
					houses.add(each);
//					System.out.println("eklendi");
				}
			}
		
			for(House each:toErase) {
				fullHouses.remove(each);
			}
			// processing semesters
			for(Student each: students) {
				each.decreaseDuration();
		
			}
			
			}
		//printing the results
		while(!students.isEmpty()) {
			Student each=students.poll();
			outstream1.println(each.getName());
		}

	}
	
	}
	