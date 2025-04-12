import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] wheel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheel = new String[5][8];
        for (int i = 1; i <= 4; i++) {
            wheel[i] = br.readLine().split("");
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] tmp = br.readLine().split(" ");
            int wheel_num = Integer.parseInt(tmp[0]);
            int direction = Integer.parseInt(tmp[1]);
            solution(wheel_num, direction);
        }

        System.out.println(cal_answer());
    }
    static int cal_answer() {
        int answer = 0;

        if (wheel[1][0].equals("1")) answer += 1;
        if (wheel[2][0].equals("1")) answer += 2;
        if (wheel[3][0].equals("1")) answer += 4;
        if (wheel[4][0].equals("1")) answer += 8;


        return answer;
    }
    static void solution(int wheel_num, int direction) {
        int[] rotationDir = new int[5];
        rotationDir[wheel_num] = direction;

        //왼쪽 전파
        for (int j = wheel_num; j >1; j-- ){
            if (!wheel[j][6].equals(wheel[j-1][2])) {
                rotationDir[j-1] = -rotationDir[j];
            }else {
                break;
            }
        }

        //오른쪽 전파
        for (int j = wheel_num; j <4; j++ ){
            if (!wheel[j][2].equals(wheel[j+1][6])) {
                rotationDir[j+1] = -rotationDir[j];
            }else {
                break;
            }
        }

        for (int j = 1; j <= 4; j++) {

            if (rotationDir[j] != 0){
                rotation(j, rotationDir[j]);
            }

        }
    }
    static void rotation(int wheel_num, int direction) {
        // 시계방향
        String[] change = new String[8];
        if (direction == 1){
            change[0] = wheel[wheel_num][7];
            for (int d = 0; d < 7; d++) {
                change[d+1] = wheel[wheel_num][d];
            }
        }else {
            change[7] = wheel[wheel_num][0];
            for (int d = 0; d < 7; d++) {
                change[d] = wheel[wheel_num][d+1];
            }
        }

        for(int d = 0; d < 8; d++) {
            wheel[wheel_num][d] = change[d];
        }
    }
}
