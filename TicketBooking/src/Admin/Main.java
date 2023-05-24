package Admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static   int ticketPrice = 300;
	
	public static final HashMap<String,Integer> showTimes = new HashMap<>();
	
	public static final HashMap<Character,Integer> rows = new HashMap<>();
	
	public static final List<Movie> ls = new ArrayList<Movie>();
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showTimes.put("9am", 0);
		showTimes.put("12pm", 1);
		showTimes.put("3pm", 2);
		showTimes.put("6pm", 3);
		
		ls.add(new Movie("DDLJ",300));
		ls.add(new Movie("3 idiots",300));
		
		
		
		HashMap<String, String> usernames =new HashMap<String,String>();
		usernames.put("abhay@pvr.com","1234");
		
 		System.out.println("Please enter Username");
 		
 		Scanner sc=new Scanner(System.in);
 		
 		String Username= sc.next();
 		
 		if(!usernames.containsKey(Username)) {
 			System.out.println("Please enter a valid Username");
 			return;
 		}
 		
 		System.out.println("Please enter your password");
 		
 		String password = sc.next();
 		
 		if(!password.equals(usernames.get(Username))) {
 			System.out.println("Username and Password do not match, Please try again.");
 			return;
 		}
 		
 		HashMap<String,List<boolean[][]>> dateTime = new HashMap<>();
 		
 		List<boolean[][]> shows = new ArrayList<boolean[][]>();
 		
 		boolean[][] firstShow = {{true,true,true},{true,false,true},{true,false,false}};
 		
 		shows.add(firstShow);
 		
 		dateTime.put("6aug", shows);
 		
 		System.out.println("Please choose the date of show");
 		String showDate=sc.next();
 		
 		System.out.println("These are the available shows, please choose your preference");
 		for(Movie m:ls) {
 			System.out.println(m.name+" ");
 			System.out.println("Ticket Price is"+m.ticketPrice);
 		}
 		
 		String movie=sc.next();
 		
 		
 		
 		System.out.println("Please choose time of show");
 		
 		String showTime=sc.next();
 		
 		int totalAmount=0;
 		
 		while(true){
 			
 		System.out.println("Here is the seating arrangement please choose");
 		
 		boolean[][] allSeats= dateTime.get(showDate).get(showTimes.get(showTime));
 		
 		for(int i=0;i<3;i++) {
 			System.out.println("\n");
 			for(int j=0;j<3;j++) {
 				if(allSeats[i][j]==true) System.out.print("available    ");
 				else {
 					System.out.print("not available    ");
 				}
 			}
 		}
 		int row=sc.nextInt();
 		int col=sc.nextInt();
 		
 		boolean available=true;
 		
 		
 		available=allSeats[row][col];
 		
 		if(!available) {
 			System.out.println("The seats are taken please try again with other seats");
 			continue;	
 		}
 		else {
 			allSeats[row][col]=false;
 			totalAmount=totalAmount+300;
 			System.out.println("I have booked this ticket for you!, The current total amount is rupees "+totalAmount+'\n');
 		}
 		
 		System.out.println("Is there anything else i can help you with?");
 		
 		String continu = sc.next();
 		
 		
 		
 		if(continu.equals("no")) {
 			System.out.println("Thankyou for choosing PVR, please pay the total amount and enjoy your show!");
 			return;
 		}
 		else if(continu.equals("yes")) {
 			continue;
 		}
 	
 		}
	}

}


