import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String inputStr = br.readLine();
            int result = checkPalindome(inputStr);
            if (result == -1) {
                System.out.println(0);
                continue;
            }
            System.out.println("result = " + result);
            String newStr1 = inputStr.substring(0, result) + inputStr.substring(result + 1);
            String newStr2 = inputStr.substring(0, inputStr.length() - result - 1)
                    + inputStr.substring(inputStr.length() - result);
            System.out.println("newStr1 = " + newStr1);
            System.out.println("newStr2 = " + newStr2);
            if (checkPalindome(newStr1) == -1) {
                System.out.println(1);
                continue;
            }
            if (checkPalindome(newStr2) == -1) {
                System.out.println(1);
                continue;
            }
            System.out.println(2);
        }
    }

    private static int checkPalindome(String str) {
        int startIndex = 0;
        int endIndex = str.length() - 1;

        for (int i = 0; i < (int) str.length() / 2; i++) {
            if (str.charAt(startIndex) == str.charAt(endIndex)) {
                startIndex++;
                endIndex--;
                continue;
            }
            return i;
        }
        return -1;
    }
}