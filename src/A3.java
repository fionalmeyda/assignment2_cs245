import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class A3 {

	public static void main(String[] args) 
	{
		
		if(args.length > 0) {
	
		System.out.println( "reading from csv file" );
		    
		Graph graph = csv_reader.read_csv( args[0]  );
		
		System.out.println( "Read successfully. \n" );
		Scanner input = new Scanner(System.in);
		String ch ="";
		do {
		
			System.out.print( "Actor 1 name : " );
			String act1 = input.nextLine();
			
			if(   graph.isVertex_available( act1 )) {
		
				System.out.print( "Actor 2 name : " );
				String act2 = input.nextLine();
				if(  graph.isVertex_available( act2 ) ) {
				
					List<String> path = graph.find_shortest_path(  act1 , act2  );

					   System.out.print( "Path between "+act1+" and "+ act2 +" : " );
						
					for(int i=0 ; i < path.size() ; i++ ) {
					
						if(path.get(i).equals(act2)) {
							
							System.out.print( path.get(i)  );
							
						}
						else {
							
							System.out.print( path.get(i) + " --> "  );
							
						}
					}
					
					System.out.println( "" );
					
				}
				else {
					System.out.println( "No such actor." );
				}
				
			}
			else {
				System.out.println( "No such actor." );
			}
			
			
			System.out.println( "Press q for exit. " );
			ch = input.nextLine();
			
		}while( ! ch.equalsIgnoreCase("q") );
    	
		}
		else {
			
			System.out.println( "Sorry File Path not specified  " );
				
		}
		
	}
	
}
