import java.util.*;

/**
 * 近似算法
 * 解决集合覆盖问题
 *
 *
 */
public class ApproximationAlgorithm {

    public static void main(String args[]) {
        // 1. 需要被电台覆盖的州
        String[] allStates = {"mt", "wa", "or", "id", "nv", "ut", "ca", "az"};
        HashSet states_needed_set = new HashSet(Arrays.asList(allStates));

        // 2. 所有电视台 包含对应电视台覆盖的州
        HashMap<String, HashSet> stations_set = new HashMap<>();

        String[] kone = {"id", "nv", "ut"};
        HashSet<String> kone_set = new HashSet(Arrays.asList(kone));

        String[] ktwo = {"wa", "id", "mt"};
        HashSet<String> ktwo_set = new HashSet(Arrays.asList(ktwo));

        String[] kthree = {"or", "nv", "ca"};
        HashSet<String> kthree_set = new HashSet(Arrays.asList(kthree));

        String[] kfour = {"nv", "ut"};
        HashSet<String> kfour_set = new HashSet(Arrays.asList(kfour));

        String[] kfive = {"ca", "az"};
        HashSet<String> kfive_set = new HashSet(Arrays.asList(kfive));

        stations_set.put("kone", kone_set);
        stations_set.put("ktwo", ktwo_set);
        stations_set.put("kthree", kthree_set);
        stations_set.put("kfour", kfour_set);
        stations_set.put("kfive", kfive_set);

        // 3. 最终选择的广播台
        HashSet<String> final_stations_set = new HashSet();


        // 开始查找 覆盖最多州的广播电台集合
        while (!states_needed_set.isEmpty()) { // 直到所有的广播台 都被覆盖完
            String best_station = "";
            HashSet<String> states_covered = new HashSet(); // 该广播台覆盖的所有未覆盖的州

            for (Map.Entry<String, HashSet> entry : stations_set.entrySet()) {
                String station = entry.getKey(); // 每个电视台名称
                HashSet states_for_station = entry.getValue(); // 每个电视台覆盖的州集合

                // 获取需要覆盖的未覆盖的州的 交集
                HashSet<String> covered = new HashSet<>();
                covered.addAll(states_needed_set);
                covered.retainAll(states_for_station);

                if (covered.size() > states_covered.size()) {
                    best_station = station;
                    states_covered = covered;
                }
            }

            // states_needed_set减去states_covered;
            // 得到所有未覆盖到的州集合 差集
            HashSet<String> result = new HashSet<>();
            result.addAll(states_needed_set);
            result.removeAll(states_covered); // 减去当前这个广播台 覆盖的未覆盖过的台
            states_needed_set = result;

            final_stations_set.add(best_station);
        }

        System.out.println("覆盖最多州的电台集合为: " + final_stations_set);

    }
}
