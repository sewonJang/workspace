/*
 	
 */

package editor;

import java.io.IOException;
import java.io.InputStream;

public class KeyBoardTest {

	public static void main(String[] args) {
		/*
		  keyboard는 개발자가 원할떄 생성할 수 있는 스트림이 아니라, 이미 시스템에서
		  컴퓨터 켤때, 미리 얻어놓기 때문에
		  개발자는 이미 존재하는 스트림을 얻어와
		  사용만 하면 된다.
		  자바에서는 os로부터 스트림을 이미 얻어와서 System 클래스의 멤버변수인
			in 변수에 받아놓았따.
			
			자바는 하드웨어를 직접 제어하지 않고 
			또한 하드웨어 자체는 현 시스템을 운영하는 OS가 제어하므로, 하드웨어에 대한
			입력 스트림은 자바가 아닌 OS이미 제어 해놓고 있다. 따라서 자바 언어를 이용하여
			키보드, 스캐너, 등등 입력하드웨어 값을 얻기 위해서는 각 하드웨어에 알맞는 스트림 클래스가 지원되는게 아니라 ,
			오직 표준 입력 스트림인 InputStream을 쓰면 된다.
			
		 */
		InputStream is =System.in;
		
		int data;
		try {
			//read() 메서드는 사용자의 입력이 있을떄까지 브럭 상태에 빠진다.
			//블럭상태란 대기상태를 말한다. 
			while(true){
			data=is.read(); //1byte 읽기
			System.out.print((char)data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
