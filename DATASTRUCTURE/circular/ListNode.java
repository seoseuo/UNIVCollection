package circular;

public class ListNode {

	private String name;
	private ListNode link;
	
	public ListNode() {
		link = null;
	}
	
	public ListNode(String name) {
		link = null;
		this.name = name;
	}
	
	public ListNode(String name,ListNode link) {
		link = null;
		this.name = name;
		this.link = link;
	}
	
	public void setName(String name) {this.name = name;}
	public void setLink(ListNode link) {this.link = link;}
	public String getName() { return name; }
	public ListNode getLink() {return link; }
	
	}
	

