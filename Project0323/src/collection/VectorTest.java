/*
 	컬렉션 프레임웍의 api 객체 중 List 계열의 하위 객체인 Vector를 학습해보자
 	
 	참고) List계열은 사실 우리가 흔히 써왓던 배열과 거의 같다.
 	
 					배열							List
 크기:			반드시 명시						선택사항, 유연함
 대상:		자바의 기본자료형+객체               	오직 객체형
 
 */
package collection;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//컬렉션 프레임웍 객체에 Generic Type을
		//명시하면, 객체가 섞이는 것을
		//컴파일 타임에 방지해 준다.
		Vector<String> v= new Vector<String>();
		
		v.add("사과");
		v.add("딸기");
	
		v.add("바나나");
		v.add("오렌지");
		
		for(int i=0; i<v.size(); i++){
			
			System.out.println((String)v.get(i));	
		}
		
	}

}
