import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> countTotal = new HashMap<>();
        HashMap<String, Map<Integer, Integer>> genresSong = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            countTotal.put(genres[i], countTotal.getOrDefault(genres[i], 0)+plays[i]);

            if (genresSong.containsKey(genres[i])){
                genresSong.get(genres[i]).put(i, plays[i]); //인덱스, 값

            }else {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                genresSong.put(genres[i], map);
            }
        }

        List<Map.Entry<String, Integer>> sortedMap = new ArrayList<>(countTotal.entrySet());
        sortedMap.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedMap) {
            Map<Integer, Integer> tmpMap = genresSong.get(entry.getKey());

            List<Map.Entry<Integer, Integer>> playSort = new ArrayList<>(tmpMap.entrySet());
            playSort.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
            for (int i = 0; i < Math.min(2, playSort.size()); i++) {
                result.add(playSort.get(i).getKey());
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}