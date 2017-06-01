package algo4;
public class Node {
	/*
	 * ����Ʈ�� �ִ� Node
	 * ����Ʈ�� �ߺ��� ���ֱ� ���ؼ� ����
	 * --> ���� ���� ����
	 * 
	 */
	
	private int px;
	private int py;
	private int cx;
	private int cy;
	
	public Node(Player p, Com c)
	{
		/*
		 * Player�� Com �÷��̾ ������ �ش� X,Y ���� ���� ����
		 */
		this.px = p.getX();
		this.py = p.getY();
		this.cx = c.getX();
		this.cy = c.getY();
	}

	public int getPx(){return px;}
	public int getPy(){return py;}
	public int getCx(){return cx;}
	public int getCy(){return cy;}
	
	public boolean equals(Node a)
	{
		if(this.px == a.getPx() && this.py == a.getPy() && this.cx == a.getCx() && this.cy == a.getCy())
			return true;
		
		return false;
	}
	
}
