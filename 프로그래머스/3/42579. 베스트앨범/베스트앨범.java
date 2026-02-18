import java.io.*;
import java.util.*; 
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 , 총재생수
        Map<String, Integer> map1 = new HashMap<>();
        // 장르, (고유번호, 재생수)
        Map<String, List<int[]>> map2 = new HashMap<>();
        // 결과
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++){
            map1.put(genres[i], map1.getOrDefault(genres[i], 0) + plays[i]);
            map2.putIfAbsent(genres[i], new ArrayList<>());
            map2.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        List<String> map1Sort = new ArrayList<>(map1.keySet());
        Collections.sort(map1Sort, (o1, o2) -> map1.get(o2) - map1.get(o1));
        
        for(String genre : map1Sort){
            List<int[]> songs = map2.get(genre);
            songs.sort((a,b) -> {
                if(b[1] != a[1]) return b[1] - a[1];
                return a[0] - b[0];
            });
            for(int i=0; i<Math.min(songs.size(),2); i++){
                result.add(songs.get(i)[0]);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray(); 
    }
}