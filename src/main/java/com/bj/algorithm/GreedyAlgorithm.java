package com.bj.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet> broadcast = new HashMap<>();

        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("北京");
        hashSet2.add("广州");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcast.put("k1",hashSet1);
        broadcast.put("k2",hashSet2);
        broadcast.put("k3",hashSet3);
        broadcast.put("k4",hashSet4);
        broadcast.put("k5",hashSet5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("杭州");
        allAreas.add("天津");
        allAreas.add("成都");
        allAreas.add("大连");

        ArrayList<String> selects = new ArrayList<>();
        HashSet<String> tempSet = new HashSet<>();

        String maxKey ;

        while (allAreas.size()!=0){
            maxKey =null;

            for (String key:broadcast.keySet()){
                tempSet.clear();
                HashSet<String> areas = broadcast.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);
                if (tempSet.size()>0&&
                        (maxKey==null||tempSet.size()>broadcast.get(maxKey).size())){
                    maxKey=key;
                }
            }
            if (maxKey!=null){
                selects.add(maxKey);
                allAreas.removeAll(broadcast.get(maxKey));
            }
        }
        System.out.println(selects);
    }
}
