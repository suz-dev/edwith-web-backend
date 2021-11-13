import java.io.IOException;

public class N1152 {

	public static void main(String[] args) throws IOException {

		int cnt = 0;
		int pre_str = 32;
		int str;

		while (true) {
			str = System.in.read();

			if (str == 32) {
				if (pre_str != 32) {
					cnt++;
				}
			} else if (str == 10) {

				if (pre_str != 32) {
					cnt++;
				}
				break;

			}
			pre_str = str;
		}

		System.out.println(cnt);
	}

}
