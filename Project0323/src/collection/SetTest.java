/*
	�÷��� �����ӿ��� ���� 2���� ��
	�������� ��ü���� ������ Set������ �˾ƺ���
	
*/
package collection;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("�ٳ���");
		set.add("����");
		set.add("����");
		
		//�÷��� �����ӿ��� ��ü �� ���� ���� ��ü��
		//����ϴ� ����, �뷮�� ó�� �� �ݺ�����
		//���� ����Ҽ� ���ٴ� ����� �ε�ģ��
		//�ذ�å) �������� ���� ->�����ְ� ������
		//Enumeration, Iterator
		Iterator<String> it=set.iterator();
		
		//�ݺ������� for, while ���� �ִ�.
		//
		while(it.hasNext()){
		String e1=it.next();//���� ��ҿ� ����
		System.out.println(e1);
		}
		
		
	}

}
