package datastructures;

/**
 * 
 * @author 
 * ibagr Graph class for implementing Node and Edge structures as well
 * as functions for finding node, path,adding edge, finding shortest
 * path between two publications, BFS and printing the graph in console
 */
public class Graph {
    /**
    * Node class represents a node in the graph
    * Implements Comparable
    */
	public class Node implements Comparable {

		private Comparable info;
		private Vector edges;
		private boolean isVisited = false;
        /**
        * constructor to initialize the properties of the node
        * @param label : label of the node
        */
		public Node(Comparable label) {
			info = label;
			edges = new Vector(6);
		}
        /**
        * method to add edges to the node
        * @param e : edge to be added
        */
		public void addEdge(Edge e) {
			edges.addLast(e);
		}
        /**
        * method to compare the node with another node
        * @param o : node object to be compared
        * @return : 0 if nodes are equal. 1 if the current node is greater than the node passed. -1 if the current node is smaller than the passed node.
        */
		public int compareTo(Object o) {
			Node n = (Node) o;
			return n.info.compareTo(info);
		}
        /**
        * getter method to get the label of the node
        * @return : label of the node
        */
		public Comparable getLabel() {
			return info;
		}

        /**
        * getter method to check if the node has been visited
        * @return : (boolean) true if the node has been visited, false otherwise
        */
		public boolean isVisited() {
			return isVisited;
		}

        /**
        * setter method to set the visited status of the node
        * @param isVisited : true if the node has been visited, false otherwise
        */
		public void setVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}

	}
	/**
	* Edge class represents an edge in the graph 
	*/
	public class Edge implements Comparable {
        /**
        * private variable toNode which is the node that this edge is connecting to
        */
		private Node toNode;
        /**
        * constructor to initialize the properties of the edge
        * @param to : node that the edge is connecting to
        */
		public Edge(Node to) {
			toNode = to;
		}
        /**
        * method to compare the edge with another edge
        * @param o : edge object to be compared
        * @return : 0 if the edges are equal. 1 if the current edge is greater than the passed one. -1 if the current edge is smaller than the passed one.
        */
		@Override
		public int compareTo(Object o) {
			Edge n = (Edge) o;
			return n.toNode.compareTo(toNode);
		}
	}
    /**
    * private variable nodes which is a Vector that stores the nodes in the graph
    */
	Vector nodes;
    /**
    * constructor to initialize the properties a graph datastructure
    */
	public Graph() {
		nodes = new Vector(6);
	}
    /**
    * method to add a node in the graph
    * @param label : label of the node to be added
    */
	public void addNode(Comparable label) {
		nodes.addLast(new Node(label));
	}
    /**
    * method to find a node in the graph
    * @param nodeLabel : label of the node to be found
    * @return : the node that matches the label
    */
	Node findNode(Comparable nodeLabel) {
		Node res = null; // variable to store the result
		//iterate through all nodes in the graph
		for (int i = 0; i < nodes.size(); i++) {
			Node n = (Node) nodes.get(i);
			//compare the label of the current node with the label passed as argument
			if (n.getLabel() == nodeLabel) {
				res = n; //if match is found, set the result to the current node
				break; //stop the loop
			}
		}
		return res; // returning result
	}
	/**
	 * Method to add an edge between two nodes in the graph
	 * @param nodeLabel1 : label of the first node
	 * @param nodeLabel2 : label of the second node
	 */
	public void addEdge(Comparable nodeLabel1, Comparable nodeLabel2) {
		// find the nodes with the given labels
		Node n1 = findNode(nodeLabel1);
		Node n2 = findNode(nodeLabel2);
		// add an edge from the first node to the second node
		n1.addEdge(new Edge(n2));
		// add an edge from the second node to the first node
		n2.addEdge(new Edge(n1));
	}
	/**
	 * Method to check if a path exists between two nodes in the graph
	 * @param nodeLabel1 : label of the first node
	 * @param nodeLabel2 : label of the second node
	 * @return : true if a path exists, false otherwise
	 */
	public boolean findPath(Comparable nodeLabel1, Comparable nodeLabel2) {
		
		//find the nodes with the given labels
		Node startState = findNode(nodeLabel1);
		Node endState = findNode(nodeLabel2);

		//if the nodes are the same, return true
		if (startState == endState) {
			return true;
		} else {
			startState.setVisited(true);
			for (int i = 0; i < startState.edges.size(); i++) {
				Edge e = (Edge) startState.edges.get(i);
				if (!e.toNode.isVisited) {
				//recursive call to check if a path exists through the neighboring nodes
					if (findPath(e.toNode.info, nodeLabel2)) {
						System.out.println(startState.info);
						return true;
					}
				}
			}
		}

		return false;
	}
	/**
	* @param src The label of the source node.
	* @param dest The label of the destination node.
	The following  method is used to find the shortest path between two nodes (source and destination).
	First, it checks if the source and destination are the same. If yes, it prints that they are in the same section and path length is 0.
	Otherwise, it initializes the variables v (nodes size), pred (vector of predecessors), dist (array of distances), and bfs.
	Then it calls the BFS method and checks if the result is false. If yes, it prints that the source and destination are not connected.
	If not, it initializes the variable path and sets the Node crawl to the destination node. After this, it uses a while loop to add the previous node to the path till
	it reaches the source node. Finally, it prints the shortest path length and the path.
	
	*/
	public void findShortestPathTowardsPublication(Comparable src, Comparable dest) {
		// check if source and destination are the same, if so, 
		// print out that they are in the same section and return
		if (src.equals(dest)) {
			System.out.println("They are in the same section. Path length is: 0");
			return;
		}

		int v = nodes.size();	// get the number of nodes in the graph

		Vector pred = new Vector(v); // create a Vector to store the predecessor of each node
		// add each node in reverse order
		for (int i = nodes.size() - 1; i >= 0; i--) {
			pred.addFirst(nodes.get(i));
		}
		// create an array to store the distance of each node from the source
		int dist[] = new int[v];
		// run BFS to find the if there is a shortest path from source to destination
		boolean bfs = BFS(src, dest, pred, dist);
		// if BFS returns false, print out that the source and destination are not connected and return
		if (bfs == false) {
			System.out.println("Given source and destination" + "are not connected");
			return;
		}

		Vector path = new Vector(v); // create a Vector to store the path

		Node crawl = findNode(dest); // set the node as the destination
		path.addFirst(crawl); // add the destination to the path
		// loop until the current node is the source
		while (true) {
			// add the current node's predecessor to the path
			path.addLast(pred.get(nodes.getIndex(crawl)));
			// set the current node as its predecessor
			crawl = (Node) pred.get(nodes.getIndex(crawl));
			// if the current node is the source, break the loop
			if (crawl.getLabel().equals(src)) {
				break;
			}
		}
		// print out the shortest path length and the path
		System.out.println("Shortest path length is: " + dist[nodes.getIndex(findNode(dest))]);
		System.out.print("Path is: ");
		// loop through the path Vector in reverse order
		for (int i = path.size() - 1; i >= 0; i--) {
			Node n = (Node) path.get(i);
			System.out.print(n.getLabel() + " ");
		}
		System.out.println("\n");
	}
	/**
	* This method finds the shortest path between two nodes in the graph by using Breadth-First Search (BFS) algorithm.
	*
	* @param src The label of the source node.
	* @param dest The label of the destination node.
	* @param pred A vector that holds the predecessors of each node.
	* @param dist An array that holds the distance between the source node and each other node.
	* 
	* @return true if a path exists between the source and destination, false otherwise.
	* 
	* The BFS method starts by setting all nodes to unvisited and sets the distance of all nodes to the maximum value. 
	* It then sets the source node as visited and its distance to 0 and adds it to the queue. 
	* It then enters a while loop that continues until the queue is empty. 
	* The method dequeues the first node from the queue, visits all its edges and if the edge's destination node is unvisited it sets it as visited, 
	* sets the distance to the destination node as the distance of the current node +1, sets the predecessor of the destination node as the current node, 
	* adds the destination node to the queue and if the destination node is the same as the target node it returns true. 
	* If the while loop ends and the queue is empty, it returns false indicating the source and destination are not connected.
	* 
	*/
	public boolean BFS(Comparable src, Comparable dest, Vector pred, int dist[]) {
		// Declare and initialize the source and destination nodes using the findNode method
		Node s = findNode(src);
		Node d = findNode(dest);
		
		// Initialize the number of nodes and create a new vector for the queue
		int v = nodes.size();
		Vector queue = new Vector(v);
		
		// Set all nodes to unvisited and set their distances to the MAX_VALUE.
		for (int i = 0; i < v; i++) {
			Node n = (Node) nodes.get(i);
			n.setVisited(false);
			dist[i] = Integer.MAX_VALUE;
		}
		// Mark the source node as visited and set its distance to 0
		s.setVisited(true);
		dist[nodes.getIndex(s)] = 0;
		// Add the source node to the queue
		queue.addLast(findNode(src));
		
		// Iterate through the queue
		while (!queue.isEmpty()) {
			Node u = (Node) queue.getFirst(); // Get the first node in the queue
			queue.removeFirst(); // Remove the first node from the queue
			// Iterate through the edges of the current node
			for (int i = 0; i < u.edges.size(); i++) {
				// Get the current edge
				Edge e = (Edge) u.edges.get(i);
				// If the destination node of the edge is unvisited, mark it as visited
				if (e.toNode.isVisited() == false) {
					e.toNode.setVisited(true);
					// Update the distance of the destination node 
					// and set the current node as the predecessor
					dist[nodes.getIndex(e.toNode)] = dist[nodes.getIndex(u)] + 1;
					pred.set(nodes.getIndex(e.toNode), u);
					// Add the destination node to the queue
					queue.addLast(e.toNode);
					// If the destination node label equals to required destination node label
					// return true
					if (e.toNode.getLabel().equals(d.getLabel())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	The prGraph method is used to print the graph in a readable format,
	showing the edges and connections between nodes.
	The method iterates through the list of nodes, and prints out the label of the current node
	followed by the labels of the nodes it is connected to through edges.
	*/
	public void prGraph() {
		// Initialize node1, node2, and edge1
		Node node1;
		Node node2 = null;
		Edge edge1 = null;
		// Get the number of nodes in the graph
		int numnodes = nodes.size();
		// Initialize variable to store the number of edges
		int numedges;
		// Iterate through all the nodes in the graph
		for (int i = 0; i < numnodes; i++) {
			// Assign the current node to node1
			node1 = (Node) nodes.get(i);
			// Print the label of the current node
			System.out.print(node1.info + ": ");
			// Get the number of edges of the current node
			numedges = node1.edges.size();
			// Iterate through all the edges of the current node
			for (int j = 0; j < numedges; j++) {
				// Assign the current edge to edge1
				edge1 = (Edge) node1.edges.get(j);
				// Assign the destination node of the current edge to node2
				node2 = edge1.toNode;
				// Print the label of the destination node of the current edge
				System.out.print(node2.info + "[ ]");
			}
			System.out.print("\n");
		}
	}
}
