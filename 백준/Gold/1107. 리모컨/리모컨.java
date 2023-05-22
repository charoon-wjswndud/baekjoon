import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //remoteController 고장난 button을 false
        boolean[] remoteController = new boolean[10];
        for (int i = 0; i < 10; i++)
            remoteController[i] = true;
        int M = Integer.parseInt(br.readLine());
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++)
                remoteController[Integer.parseInt(st.nextToken())] = false;
        }

        // 완전탐색,
        // 채널의 최댓값은 600_000
        // But 9빼고 모든 버튼이 고장날 경우 999_999도 가능
        int minPushCnt = Math.abs(N - 100);
        for (int channel = 0; channel <= 999_999; channel++) {
            String strChannel = Integer.toString(channel);
            if (!checkChannel(strChannel, remoteController))
                continue;

            int len = strChannel.length();
            minPushCnt = Math.min(minPushCnt, len + Math.abs(N - channel));
        }
        System.out.print(minPushCnt);
    }
    public static boolean checkChannel(String strChannel, boolean[] remoteController) {
        for (int c = 0; c < strChannel.length(); c++)
            if(!remoteController[strChannel.charAt(c) - '0'])
                return false;
        return true;
    }
}
