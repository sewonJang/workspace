/*
 	컬렉션 프레임웍 중 순서 없는 객체들을
 	key-value 쌍으로 관리하는 Map을 학습한다.
 */
package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("2jm92", "장세원");
		map.put("aaaa", "김나영");
		map.put("jaemin0904", "장재민");

		Set set = map.keySet();

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String str=it.next();
			String a=map.get(str);
			System.out.println(a);
		}
	}

}
