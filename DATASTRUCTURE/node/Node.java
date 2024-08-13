package node;

public class Node {

	private String data;
	private Node link;
	
	public Node() {
		link = null;
	}
	
	public Node(String data) {
		this.data = data;
		link = null;
	}
	
	public Node(String data, Node link) {
		this.data = data;
		this.link = link;
	}
	
	public void setData(String data) { this.data = data; }
	public void setLink(Node link) { this.link=link; }
	public String getData() {return data; }
	public Node getLink() { return link; }
}
