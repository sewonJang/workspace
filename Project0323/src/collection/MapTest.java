/*
 	�÷��� �����ӿ� �� ���� ���� ��ü����
 	key-value ������ �����ϴ� Map�� �н��Ѵ�.
 */
package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("2jm92", "�弼��");
		map.put("aaaa", "�質��");
		map.put("jaemin0904", "�����");

		Set set = map.keySet();

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String str=it.next();
			String a=map.get(str);
			System.out.println(a);
		}
	}

}
