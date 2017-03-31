/*
	���ӿ� ������ ��� ��ü�� �ֻ��� Ŭ������ �����Ѵ�.
	��? ����� �̿��ϸ� �ڵ� �ߺ��� ������ �� �ְ�, �ֻ��� Ŭ���� �ڷ�������
	�ڽĵ��� ����ų���� �����Ƿ�, �ڵ尡 ����������.
	
*/
package game;

import java.awt.Graphics;
import java.awt.Rectangle;

abstract public class GameObject {
	ObjectManager objectManager;
	ObjectId id;// ��� ���� ��ü�� �Ҵ�� ���̵�
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;

	Rectangle rect;// ���� �׽�Ʈ�� ����� �簢�� ��ü

	public GameObject(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		this.objectManager=objectManager;
		this.id =id; //� �������� �����ϱ� ����
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		rect=new Rectangle(x, y, width, height);
	}

	abstract public void tick();

	abstract public void render(Graphics g);
}
