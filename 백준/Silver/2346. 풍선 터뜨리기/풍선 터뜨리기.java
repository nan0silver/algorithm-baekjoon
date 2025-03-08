import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Deque<Pair> deque = new ArrayDeque<>(N);
        for (int i = 1; i <= N; i++) {
            deque.add(new Pair(Integer.parseInt(st.nextToken()), i));
        }

        Pair indexPair = deque.removeFirst();
        sb.append("1 ");
        int index = indexPair.getValue();
        while(!deque.isEmpty()) {
            if (index > 0) {
                for (int i = 0; i < index-1; i++) {
                    Pair tmpPair = deque.removeFirst();
                    deque.addLast(tmpPair);
                }
                Pair outPair = deque.removeFirst();
                sb.append(outPair.getIndex()).append(" ");
                index = outPair.getValue();
            } else {
                for (int i = 0; i < Math.abs(index)-1; i++) {
                    Pair tmpPair = deque.removeLast();
                    deque.addFirst(tmpPair);
                }
                Pair outPair = deque.removeLast();
                sb.append(outPair.getIndex()).append(" ");
                index = outPair.getValue();
            }
        }
        System.out.println(sb);

    }


}

class Pair {
    private int value;
    private int index;

    public Pair(int value, int index) {
        this.value=value;
        this.index=index;
    }

    public int getValue(){
        return value;
    }

    public int getIndex() {
        return index;
    }
}
