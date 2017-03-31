/*
	1.스트림 방향성에 따라 분류
	-입력, 출력
	2.스트림의 데이터 처리방법에 따른 분류
		(1) 바이트 기반 스트림 
			(입출력시 1byte 씩 처리)
		(2) 문자기반 스트림
			(입출력시 2byte씩 묶어서 이해할 수 있는 스트림)
			주의!! 2byte씩 읽거나, 쓰는게 아니다!! 
			문자기반스트림의 명명규칙
			입력스트림 - ~~Reader 끝남
			출력스트림- ~~Writer 끝남
		(3) 버퍼 스트림
*/
package editor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardInput {

	public static void main(String[] args) {
		InputStream is=System.in; //추상클레스라 new가 안된다 그 대신 시스템이 받아놈
		InputStreamReader reader=null;
		reader = new InputStreamReader(is);
		
		int data;
		try {
			
			data= reader.read();	//1byte
			System.out.print((char)data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
