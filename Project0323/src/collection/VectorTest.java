/*
 	�÷��� �����ӿ��� api ��ü �� List �迭�� ���� ��ü�� Vector�� �н��غ���
 	
 	����) List�迭�� ��� �츮�� ���� ��Ӵ� �迭�� ���� ����.
 	
 					�迭							List
 ũ��:			�ݵ�� ���						���û���, ������
 ���:		�ڹ��� �⺻�ڷ���+��ü               	���� ��ü��
 
 */
package collection;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�÷��� �����ӿ� ��ü�� Generic Type��
		//����ϸ�, ��ü�� ���̴� ����
		//������ Ÿ�ӿ� ������ �ش�.
		Vector<String> v= new Vector<String>();
		
		v.add("���");
		v.add("����");
	
		v.add("�ٳ���");
		v.add("������");
		
		for(int i=0; i<v.size(); i++){
			
			System.out.println((String)v.get(i));	
		}
		
	}

}
