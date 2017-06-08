package algo4;
import java.util.*;

public class algo4 {
	/*
	 * �ڵ����� Player�� ���������� ã�ư��� Class
	 */
	
	private Player p;
	private Com c;
	private boolean check = true;
	//check : �������� �����ϸ� ����Լ��� �����ϱ� ���� boolean
	//�������� �����ϸ� �ش� ���� false�� �����Ͽ� ����Լ� ����
	private LinkedList<Node> point = new LinkedList();
	//player�� com�� ��ġ������ ������ �ִ� Node
	//��ũ�帮��Ʈ�� �������, �ߺ��� �����Ͽ� ���ѷ��� ������
	private LinkedList<String> path = new LinkedList();
	//������� ��� �̵��ߴ����� ��Ÿ���� ��ũ�帮��Ʈ
	//�������� ť�� �����ϰ��� ������, ��带 �����ϴ� �������� LinkedList�� ������
	//������ ��带 ������ �� �ڿ��ִ� ��带 �����ؾ� ������, ť�δ� �ش� ������ ���� X
	
	public algo4(Player p, Com c)
	{
		this.p = p;
		this.c = c;
	}

	public boolean containNode(Node n)
	{
		/*
		 * �ش� ��尡 ������ LinkedList point�� �����ϴ��� Ȯ���ϴ� �Լ�
		 * �����ϸ� true, �������� ������ false
		 */
		for(int i=0;i<point.size();i++)
		{
			if(n.equals(point.get(i)))
				return true;
		}
		return false;
	}

	public void print(){
		/*
		 * ���±��� �̵��ߴ� ��θ� ó������ ������ ������ִ� �Լ�
		 */
		
		int size = path.size();
		while(!path.isEmpty()){			
			System.out.println(path.removeFirst());
		}
		System.out.println("�� " + size + "��ŭ �̵��� �߽��ϴ�");
	}

	public void run()
	{
		/*
		 * �ڵ����� player�� ���������� �̵��ϴ� �Լ�
		 * player�� ���� ������ �� �Ʒ� ������ �ش� ��ġ�� �̵��� �� �ִ��� Ȯ���� ��
		 * �� �� ������ �̵� --> ���� �̹� ���� ��ġ�ų� com�� ���� player�� ������ �ش� ��θ� ����
		 * �ƹ����� �� �� ������ �� ��嵵 ����
		 */
		System.out.println("Player : " + p.x +" , " + p.y + "  Computer : " + c.x + " , " + c.y);
	
		int px, py, cx, cy;
		px = p.getX();
		py = p.getY();
		cx = c.getX();
		cy = c.getY();
		//��带 ������ �� ���� ������ ������ �־, ���ư� �� �ְ� ��
		//������ �� ����� ����ϸ� if�� �ϳ��� ���� ���Ŀ� p.x,p.y,c.x,c.y�� �����ؾ� �ϱ� ������ �˰���� ������ �� ����
		//�� �Ӹ��δ� �ٸ� ����� �������� ����

		Node n = new Node(p,c);
		if(containNode(n) || c.catchPlayer(p))	//�̹� �� ��ġ�ų�, ������ ��� ����
		{ 
			System.out.println("Node del");
			path.removeLast();
			return;
		}
		else
		{
			point.addLast(n);
			if(p.goal()){	//Player�� �������� �����ϸ� check�� false�� �ξ� ����Լ��� ����� ��
				System.out.println("��ǥ�� �����߾��!");
				check = false;
				return;
			}
			else
			{
				if(p.canGo(1) && check)	//�������� �� �� ������ �̵��ϰ�, ��ǻ�Ͱ� 2�� �����ϰ�, �̵��� ��θ� LinkedList path�� ����
				{
					System.out.println("Player go left");
					p.go(1);
					c.run(p);
					c.run(p);
					path.offer("�������� �̵�");
					run();
				}
				p.setX(px); p.setY(py); c.setX(cx); c.setY(cy);	//�ش� ��� ������ ����Ͽ� ������ ������ �ٽ� �ʱ�ȭ
				if(p.canGo(2) && check)
				{
					System.out.println("Player go Right");
					p.go(2);
					c.run(p);
					c.run(p);
					path.offer("���������� �̵�");
					run();
				}
				p.setX(px); p.setY(py); c.setX(cx); c.setY(cy);
				if(p.canGo(4) && check)
				{
					System.out.println("Player go Up");
					p.go(4);
					c.run(p);
					c.run(p);
					path.offer("���� �̵�");
					run();
				}
				p.setX(px); p.setY(py); c.setX(cx); c.setY(cy);
				if(p.canGo(8) && check)
				{
					System.out.println("Player go down");
					p.go(8);
					c.run(p);
					c.run(p);
					path.offer("�Ʒ��� �̵�");
					run();
				}
				p.setX(px); p.setY(py); c.setX(cx); c.setY(cy);
				if(check)
				{
					System.out.println("Do Nothing");
					c.run(p);
					c.run(p);
					path.offer("���");
					run();
				}
				p.setX(px); p.setY(py); c.setX(cx); c.setY(cy);
				if(check && !path.isEmpty()){
				System.out.println("������ �����!");
				path.removeLast();
				}
				p.setX(px); p.setY(py); c.setX(cx); c.setY(cy);
			}
		}
	}
}
