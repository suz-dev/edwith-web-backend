import java.io.IOException;

public class N1152 {

	public static void main(String[] args) throws IOException {

		int cnt = 0; // 단어의 개수
		int pre_str = 32; // 이전 단어
		int str; // 입력받은 단어

		while (true) {
			str = System.in.read();
			
			if (str == 32) { // 'str'이 공백일 때
				if (pre_str != 32) {
					cnt++;
				}
			} else if (str == 10) { // 'str'이 개행일 때

				if (pre_str != 32) {
					cnt++;
				}
				break;

			}
			pre_str = str; // 'pre_str'를 'str'로 대치
		}

		System.out.println(cnt);
	}

}
