import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Graph {

	
	HashMap<String,Node> vertex;
	
	public Graph() {
		vertex = new HashMap<String,Node>();
	}
	
	public void add_vertex(String element) {
		
		if(vertex.isEmpty()) {
			
			Node node = new Node(element);
			vertex.put(element, node);
		
		}
		else {
			
			if( !vertex.containsKey(element) ) {
				
				Node node = new Node(element);
				vertex.put(element, node);
			
			}
			
		}
		
	}
	
	
	
	public boolean isVertex_available( String element ) {
		
		return vertex.containsKey(element);
	}
	
	public void add_edges(String vertex1 , String vertex2) {
	
	
		if( vertex.containsKey(vertex1) &&  vertex.containsKey(vertex2)) {
			
			Node node = vertex.get(vertex1);
		    node.add(vertex2);
		    vertex.put(vertex1, node );
		    
			node = vertex.get(vertex2);
		    node.add(vertex1);
		    vertex.put(vertex2, node );
		    
		}
		else {
			System.out.println("vertex not exist");
		}
		
		
		
	}
	
	public List<String> find_shortest_path(String vertex1 , String vertex2) {
	
		List<String> path = new ArrayList<>();
		
		path.add(vertex1);
		
		Node node = vertex.get(vertex1);
		if(vertex.get(vertex1).getNode().contains(vertex2)) {
			
		}
		else {
			
			List<String> nodes = vertex.get(vertex1).getNode();
	        Collections.sort(nodes); 

			for(int i=0 ; i < nodes.size() ; i++ ) {
				
				
				if(vertex.get(nodes.get(i)).getNode().contains(vertex2)  ) {
					path.add(nodes.get(i));
					break;
				}
				
			}
			
		}
		
		
		
		
		path.add(vertex2);
		
		return path;
	}
	
	
}
