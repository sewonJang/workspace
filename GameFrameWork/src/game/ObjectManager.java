/*
	�츮�� �������� ������ ���ӷ����� ���� 1���� �����ϱ� ������, while ������ ���ӿ� ������
	��� ������Ʈ�� tick, render ȣ���ؾ� �� �ǹ��� �ִ�.
	������, ���ӿ� ������ ��ü���� �ʹ��� ���� Ŭ���� ���ļ� �����ϰ� �����ϱ� ������
	���ӷ����� while�� ������ ��� ��ü���� ���۷����� �����ϱ�� ���� �ʴ�.
	�ذ�å??
	���ӿ� ������ ��� ��ü���� ������ �ִ� ���簡 �ʿ��ϴ�. 
*/
package game;

import java.util.ArrayList;

public class ObjectManager {
	// �����ͺ��̽� ������ �� ����...
	ArrayList<GameObject> list = new ArrayList<GameObject>();

	// ��ü ���
	// ��� ���ӿ� ������ ��ü�� ������ �� �Ʒ��� �޼��带 ���� �����ͺ��̽��� ��ϵȴ�.
	public void addObject(GameObject obj) {
		list.add(obj);
	}
}
