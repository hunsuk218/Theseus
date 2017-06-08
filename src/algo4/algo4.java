package algo4;
import java.util.*;

public class algo4 {
	/*
	 * 자동으로 Player가 목적지까지 찾아가는 Class
	 */
	
	private Player p;
	private Com c;
	private boolean check = true;
	//check : 목적지에 도달하면 재귀함수를 종료하기 위한 boolean
	//목적지에 도착하면 해당 값을 false로 변경하여 재귀함수 종료
	private LinkedList<Node> point = new LinkedList();
	//player와 com의 위치정보를 가지고 있는 Node
	//링크드리스트로 묶어놓고, 중복을 방지하여 무한루프 방지함
	private LinkedList<String> path = new LinkedList();
	//현재까지 어떻게 이동했는지를 나타내는 링크드리스트
	//기존에는 큐로 구현하고자 했지만, 노드를 삭제하는 과정에서 LinkedList로 변경함
	//이유는 노드를 삭제할 때 뒤에있는 노드를 삭제해야 하지만, 큐로는 해당 사항을 실현 X
	
	public algo4(Player p, Com c)
	{
		this.p = p;
		this.c = c;
	}

	public boolean containNode(Node n)
	{
		/*
		 * 해당 노드가 기존에 LinkedList point에 존재하는지 확인하는 함수
		 * 존재하면 true, 존재하지 않으면 false
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
		 * 여태까지 이동했던 경로를 처음부터 끝까지 출력해주는 함수
		 */
		
		int size = path.size();
		while(!path.isEmpty()){			
			System.out.println(path.removeFirst());
		}
		System.out.println("총 " + size + "만큼 이동을 했습니다");
	}

	public void run()
	{
		/*
		 * 자동으로 player가 목적지까지 이동하는 함수
		 * player는 왼쪽 오른쪽 위 아래 순으로 해당 위치로 이동할 수 있는지 확인한 후
		 * 갈 수 있으면 이동 --> 만일 이미 갔던 위치거나 com에 의해 player가 잡히면 해당 경로를 삭제
		 * 아무곳도 갈 수 없으면 그 노드도 삭제
		 */
		System.out.println("Player : " + p.x +" , " + p.y + "  Computer : " + c.x + " , " + c.y);
	
		int px, py, cx, cy;
		px = p.getX();
		py = p.getY();
		cx = c.getX();
		cy = c.getY();
		//노드를 삭제할 때 이전 정보를 가지고 있어서, 돌아갈 수 있게 함
		//하지만 이 방법을 사용하면 if문 하나가 끝난 이후에 p.x,p.y,c.x,c.y를 변경해야 하기 때문에 알고리즘상 안좋을 것 같음
		//내 머리로는 다른 방안이 떠오르지 않음

		Node n = new Node(p,c);
		if(containNode(n) || c.catchPlayer(p))	//이미 간 위치거나, 잡히면 노드 삭제
		{ 
			System.out.println("Node del");
			path.removeLast();
			return;
		}
		else
		{
			point.addLast(n);
			if(p.goal()){	//Player가 목적지에 도착하면 check를 false로 두어 재귀함수를 벗어나게 함
				System.out.println("목표에 도착했어요!");
				check = false;
				return;
			}
			else
			{
				if(p.canGo(1) && check)	//왼쪽으로 갈 수 있으면 이동하고, 컴퓨터가 2턴 실행하고, 이동한 경로를 LinkedList path에 저장
				{
					System.out.println("Player go left");
					p.go(1);
					c.run(p);
					c.run(p);
					path.offer("왼쪽으로 이동");
					run();
				}
				p.setX(px); p.setY(py); c.setX(cx); c.setY(cy);	//해당 경로 삭제를 대비하여 이전의 정보로 다시 초기화
				if(p.canGo(2) && check)
				{
					System.out.println("Player go Right");
					p.go(2);
					c.run(p);
					c.run(p);
					path.offer("오른쪽으로 이동");
					run();
				}
				p.setX(px); p.setY(py); c.setX(cx); c.setY(cy);
				if(p.canGo(4) && check)
				{
					System.out.println("Player go Up");
					p.go(4);
					c.run(p);
					c.run(p);
					path.offer("위로 이동");
					run();
				}
				p.setX(px); p.setY(py); c.setX(cx); c.setY(cy);
				if(p.canGo(8) && check)
				{
					System.out.println("Player go down");
					p.go(8);
					c.run(p);
					c.run(p);
					path.offer("아래로 이동");
					run();
				}
				p.setX(px); p.setY(py); c.setX(cx); c.setY(cy);
				if(check)
				{
					System.out.println("Do Nothing");
					c.run(p);
					c.run(p);
					path.offer("대기");
					run();
				}
				p.setX(px); p.setY(py); c.setX(cx); c.setY(cy);
				if(check && !path.isEmpty()){
				System.out.println("갈곳이 없어요!");
				path.removeLast();
				}
				p.setX(px); p.setY(py); c.setX(cx); c.setY(cy);
			}
		}
	}
}
