import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static boolean[] people, party;
    static List<Integer>[] graph, personToParties;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int people_num = Integer.parseInt(input[0]);
        int party_num = Integer.parseInt(input[1]);

        graph = new List[party_num];
        for (int i = 0; i < party_num; i++) {
            graph[i] = new ArrayList<>();
        }

        personToParties = new List[people_num+1];
        for (int i = 0; i <= people_num; i++) {
            personToParties[i] = new ArrayList<>();
        }

        people = new boolean[people_num+1]; //1부터 시작
        party = new boolean[party_num]; //0부터 시작

        String[] input2 = br.readLine().split(" ");
        int truth_people = Integer.parseInt(input2[0]);
        int[] truth = new int[truth_people];
        if (truth_people > 0) {
            for (int i = 1; i <= truth_people; i++) {
                int p = Integer.parseInt(input2[i]);
                truth[i-1] = p;
                people[p] = true;
            }
        }

        for (int i = 0; i < party_num; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 1; j <= Integer.parseInt(tmp[0]); j++) {
                int p = Integer.parseInt(tmp[j]);
                graph[i].add(p);
                personToParties[p].add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < truth.length; i++) {
            queue.offer(truth[i]);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < party_num; i++) {
                if (graph[i].contains(cur)) {
                    party[i] = true;
                    for(int next : graph[i]) {
                        if (!people[next]) {
                            people[next] = true;
                            queue.offer(next);
                        }
                    }
                }

            }
        }

        int answer = 0;
        for (int i = 0; i < party_num; i++) {
            if(!party[i]) answer++;
        }

        System.out.println(answer);
    }

}