import java.util.Scanner;

public class N10809 {

	/*
	 * 알파벳 소문자로만 이루어진 단어 'S'가 주어질 때 각각의 알파벳에 대해, 단어에 포함되어 있는 경우에는 처음 등장하는 위치 /포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오
	 * 
	 * 'Scanner'를 통해 'S'를 입력받는다
	 * 길이가 알파벳 소문자의 개수만큼인 배열 'arr'를 선언한다
	 * 반복문을 통해 'arr'의 원소를 -1로 초기화한다
	 * 
	 * 'String'변수 'S'를 통해 단어를 입력받는다
	 * 반복문을 통해'char'형 변수 'ch'에 'S'의 문자열의 각 문자를 추출하여 저장한다 (charAt() 사용)
	 * 
	 * 'ch'의 문자 위치를 'arr'배열의 값으로 바꿔준다
	 * 문자의 위치는 0부터 시작해야 하기 때문에 'ch'의 문자의 위치는 'i'와 같다
	 * 'ch - 'a''/'ch - 97'를 통해 'arr'배열 인덱스(원소 위치)를 0부터 시작하도록 설정한다 (아스키코드값 사용: a=97)
	 * 동일 문자가 포함된 경우 처음 나타나나 위치만 저장해야 하기 때문에 조건문을 통해 'arr[ch - 'a']'의 값이 초기화 상태인 -1일 때만 실행되도록 한다
	 * 
	 * 향상된 'for'문을 통해 'arr'배열의 값을 출력한다 
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}

		String S = sc.nextLine();
		sc.close();

		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);

			if (arr[ch - 'a'] == -1) {
				arr[ch - 'a'] = i;
			}
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}
	}
}
