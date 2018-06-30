import java.util.*;

/**
 * 广度优先搜索
 *
 * !!!用队列存放数据
 *
 * 无权图
 *
 * 弹出队列第一个元素 检查是不是
 * 如果不是 把这个元素的所有邻居元素 都添加到队列的尾部
 *
 * 循环这个过程
 *
 * 将已经查看过的对象 添加到查看表中 防止重复查找
 *
 * 广度优先搜索 指出是否有从A到B的路径 是否的问题
 * 如果有 广度优先搜索将找出最短路径 最优的问题
 */
public class BreadthFirstSearch {

    public static void main(String args[]) {
        System.out.println("");
        System.out.println("******** BreadthFirstSearch 广度优先搜索 BFS *********");

        // 准备数据
        HashMap<String, String[]> map = new HashMap<>();
        String[] you = {"alice", "bob", "claire"};
        map.put("you", you);
        String[] bob = {"anuj", "peggy"};
        map.put("bob", bob);
        String[] alice = {"peggy"};
        map.put("alice", alice);
        String[] claire = {"thom", "jonny"};
        map.put("claire", claire);
        String[] anuj = {};
        map.put("anuj", anuj);
        String[] peggy = {};
        map.put("peggy", peggy);
        String[] thom = {};
        map.put("thom", thom);
        String[] jonny = {};
        map.put("jonny", jonny);

        List finded = breadthFirstSearch(map);
        if (finded == null || finded.size() == 0) {
            System.out.println("没有找到");
        } else {
            for (int i = 0; i < finded.size(); i++) {
                System.out.println("找到了 " + finded.get(i));
            }
        }
    }

    /**
     * 找到集合中 有没有指定元素
     *
     * @param map
     * @return
     */
    public static List<String> breadthFirstSearch(HashMap<String, String[]> map) {
        LinkedList<String> queue = new LinkedList<>();// 待查找的队列
        HashMap<String, Boolean> searchedList = new HashMap<>(); // 保存已经查找过的人
        List<String> findList = new ArrayList();

        // 先添加种子元素 到队列
        queue.addAll(Arrays.asList(map.get("you")));

        while (!queue.isEmpty()) {
            String people = queue.poll();
            if ((searchedList.get(people) == null) || (!searchedList.get(people))) {
                if (personIsASellor(people)) {
                    findList.add(people); // 加入到找到的队列
                } else {
                    queue.addAll(Arrays.asList(map.get(people))); // 把刚找的这个人的朋友加入进队列
                }
                searchedList.put(people, true); // 防止重复查找
            }
        }
        return findList;
    }

    /**
     * 查找 有没有销售
     *
     * @param name
     * @return
     */
    private static boolean personIsASellor(String name) {
        return name.startsWith("a");
    }
}
