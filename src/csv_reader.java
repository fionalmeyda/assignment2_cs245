import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class csv_reader {

	
	
	public static Graph read_csv(String path)  {
	
        Graph graph = new Graph();
		
		
		
		String csvFile = path.substring(1);
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String n ="";
        List<String> temp = new ArrayList<String>();
	       
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int z = 0;
            while ((line = br.readLine()) != null) {
        
            	if(z > 0) {

            	 n = line.substring(   line.indexOf("[")-1   ,  line.indexOf("]") +2  );
            	
            	 for (String cell : n.split(",")) { 
 	                
 	        		if(cell.contains("name")) {
 	        		
 	        			String [] p = cell.split(":");
 	        			String vertice = p[1].trim();
 	        			vertice = vertice.replace("\"", "");
 	        			//System.out.print(vertice + "\t"); 
 	        			graph.add_vertex(vertice);
 	        			temp.add( vertice );
 	        		}
 	        		   
 	          }
            	

            	 
            	    for(int i =0 ; i < temp.size(); i++) {
        	        	for(int j =0 ; j < temp.size(); j++) {
        	        		
        	        		if(i != j) {
        	        			
        	        			graph.add_edges(  temp.get(i) , temp.get(j)  );
        	        	        
        	        		}
        	        		
        	        	}
        	        }	
        	    
        	            temp.clear();
        	         
            	 

            	
            	}
            	z++;
            
            
            
            
            }
        	
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
	    return graph;

	}
	
	
}
