/*
	컬렉션 프레임웍의 유형 2가지 중
	순서없는 객체들의 집합인 Set유형을 알아보자
	
*/
package collection;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("바나나");
		set.add("딸기");
		set.add("수박");
		
		//컬랙션 프레임웍의 객체 중 순서 없는 객체를
		//사용하다 보면, 대량의 처리 시 반복문을
		//직접 사용할수 없다는 어려움에 부딪친다
		//해결책) 순서없는 것을 ->순서있게 만들자
		//Enumeration, Iterator
		Iterator<String> it=set.iterator();
		
		//반복문에는 for, while 문이 있다.
		//
		while(it.hasNext()){
		String e1=it.next();//다음 요소에 접근
		System.out.println(e1);
		}
		
		
	}

}
