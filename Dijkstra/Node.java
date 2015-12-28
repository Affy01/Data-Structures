package shortestpath;

import java.util.LinkedList;
import java.util.List;

public class Node implements Comparable {
	int	x;
	int	y;
	List<Edge> 	out_list = new LinkedList<Edge>();	/* edges that start from this node */
	int	dist;		/* distance from the start node */
	Node 	parent;		/* previous node of the shortest path */
	boolean inqueue; 	/* node is in Queue to be scanned */
	String	name;
	@Override
	public int compareTo(Object other)
        {
            if (dist < ((Node)other).dist)
                return -1;
            if (dist > ((Node) other).dist) 
                return 1;
            return 0;
	}	
}
