import java.util.Scanner;

public class N1157 {
	
	/*
	 * 알파벳 대소문자로 된 단어가 주어질 때, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오
	 * (대문자와 소문자를 구분하지 않는다)
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[26];
		String S = sc.next();
		
		sc.close();
		
		/*
		 * 입력받은 단어의 길이만큼 반복
		 * 입력받은 문자열을 문자 단위로 저장
		 * 
		 * 아스키 코드의 대문자 'A~Z'값과 소문자 'a~z'를 기준으로 배열의 인덱스 값을 증가시킬 'if'문 실행
		 * 
		 */

		for (int i = 0; i < S.length(); i++) { 
			char ch = S.charAt(i);  

			if (65 <= ch && ch <= 90) {  	// 대문자 ('A'대신 65 사용 가능)
				arr[ch - 'A']++;  
			} else { 						// 소문자 ('a'대신 97 사용 가능)
				arr[ch - 'a']++;  
			}
		}
		
		/*
		 * 최대값을 저장할 변수 'max'선언 후 초기화
		 * 출력할 변수 'c'선언 후 초기화
		 * 
		 * 알파벳의 개수만큼 반복문 실행
		 * 배열의 원소값이 'max'보다 클 경우: 'max'= 해당 원소값으로 대치 / 'c'=대치된 'max'값에 대응하는 문자로 대치
		 * 
		 * 'c'출력
		 */

		int max = -1;  
		char c = '?'; 

		for (int i = 0; i < 26; i++) {
			if (arr[i] > max) { 
				max = arr[i]; 
				c = (char) (i + 65); 
			} else if (arr[i] == max) {
				c = '?';
			}
		}

		System.out.println(c);
	}

}
