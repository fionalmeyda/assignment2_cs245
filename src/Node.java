import java.util.ArrayList;
import java.util.List;

public class Node {

	String label;
	List<String> adjacencyList;
	
	public Node(String label) {
		this.label = label; 
		adjacencyList = new ArrayList<>();	
	}
	
	public void add(String item) {
		
		if(adjacencyList.isEmpty()) {
			adjacencyList.add(item);
		}
		else {
			
		
			if(!adjacencyList.contains(item) ) {
				adjacencyList.add(item);
			}
			
			
		}
		
		
	}
	
	public List<String> getNode(){
		
		return adjacencyList;
	}

	
	public String getlabel() {
		return label;
	}
	
	public boolean equals(Node obj) {
		
		if(obj.getlabel().equals(this.label)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	
}
