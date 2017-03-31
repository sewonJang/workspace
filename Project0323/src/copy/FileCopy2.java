/*예외 처리의 목적
-비정상 종료의 방지 (즉 안정적인 시스템 운영을 목적)

일반적으로 프로그램이 정상 수행될 수 없는 상황을 가리켜 에러라고 한다.
sun에서는 에러에 대한 나름 분류함
1. 프로그래머가 대처할 수 없는 불가항력적 에러
	Error
2. 프로그래머가 대처할 수 있는 에러 (예외 함)
	자바의 관심 사항은 바로 "예외"
	sun에서는 이 예외를 상황에 따라 체계적인 클레스로 
	지원하고 있다. 

	이 예외 객체들은 다시 크게 2가지 유형으로 분류
		(1)컴파일 타임에 예외처리를 강요하는 경우
			checked Exception
		(2)컴파일 타임에 예외처리를 강요하지 않는 경우
			Unchecked Exception = Runtime Exception

3.
*/
package copy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


class FileCopy2{
	FileInputStream fis;// 파일을 대상으로한 입력스트림
	FileOutputStream fos; //파일을 대상으로한 출력스트림
	public FileCopy2(){
		//아래의 코드는 장차, 에러가 발생할 수 있는 가능서이 있는 코드이다..
		//따라서 개발자가 문법을 잘 작성했음에도 불고하고, 특별한 안전장치를
		//마련하기를 강요한다.
		try{
			fis=new FileInputStream("C:/java_workspace2/Project0323/res/sc.png");
			fos=new FileOutputStream("C:/java_workspace2/Project0323/data/sc_copy.png");
			//System.out.println("파일에 스트림 생성했어요");
			
			int data;
			while(true){
				data=fis.read(); //1byte 를 익어 들임;
				fos.write(data); //1byte 쓰기;

				if(data==-1) break;
				System.out.println(data);
				
			}
		}
		catch(FileNotFoundException e){//에러가 발생하면 실행부가 이 영역으로 진입한다.
					//catch문을 수행하게 되면 프로그램이 비정상종료가 
					//되지 ㅇ낳고 정상수행을 하게 된다. 사용자에게 안내하는 용도도
					//catch문을 사용하게 된다.
					System.out.println("파일을 찾을 수 없습니다.");
		
		}
		catch(IOException e){
			System.out.println("파일을 읽을 수 없습니다.");
		}finally{
			//finally를 선언하면,
			//try문을 수행하던, catch문을 수행하던 실행부가 무조건 이영역
			//실행부가 무조건 이 영역을 거쳐서 간다.
			//finally 코드의 사용목적
			/*
				주로 database연동과 스트림 사용시
				성공여부를 떠나서 무조건 자원을 닫거나 마무리
				하려면 try문이던 catch문을 수행하던 상관 없이
				무저건 거쳐가야할 코드 영역을 두기위함
			*/

				try{
					//스트림 연결 해제!!
						if(fis!=null){fis.close();}
						if(fos!=null){fos.close();}
					}
				catch(IOException e){
				
				}
			}

		//모든 업무가 끝나는 시점
	
	}
	public static void main(String[] args){
		new FileCopy2();
	}
}
