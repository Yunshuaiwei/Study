package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author DELL
 * @Date 2020/2/18 11:43
 **/
public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
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
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);
        HashSet<String> allAreas = new HashSet<>();
        for (Map.Entry<String, HashSet<String>> entry : broadcasts.entrySet()) {
            HashSet<String> value = entry.getValue();
            allAreas.addAll(value);
        }
        ArrayList<String> selects = new ArrayList<>();
        //存放电台覆盖地区和当前还没有覆盖地区的交集
        HashSet<String> tempSet = new HashSet<>();
        String maxKet;
        while (allAreas.size() != 0) {
            maxKet = null;
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet和allAreas集合的交集，交集会赋给tempSet
                tempSet.retainAll(allAreas);
                //有交集，且tempSet的长度大于从maxKet中取出value的长度
                if (tempSet.size() > 0 &&
                        (maxKet == null || tempSet.size() > broadcasts.get(maxKet).size())) {
                    maxKet = key;
                }
            }
            if (maxKet != null) {
                selects.add(maxKet);
                //将maxKey指向的广播电台覆盖的地区从allAreas中去掉
                allAreas.removeAll(broadcasts.get(maxKet));
            }
        }
        System.out.println("得到的选择结果为：" + selects);
    }
}
