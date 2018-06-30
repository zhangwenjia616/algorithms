import java.util.*;

/**
 * 犹克斯特拉算法
 * <p>
 * 加权图 查找最优路径
 * <p>
 * 一旦某个节点处理了 就认为没有更小的开销到达这个节点 不会重复处理
 */
public class DijkstrasAlgorithm {

    public static final String pointStart = "START";
    public static final String pointA = "A";
    public static final String pointB = "B";
    public static final String pointFin = "FIN";

    static HashMap<String, HashMap<String, Integer>> graphMap; // 描述图
    static HashMap<String, Integer> costsMap; // 除了起点以外的 所有节点的开销表
    static HashMap<String, String> parentMap; // 除了起点以外的 所有节点的父节点表
    static HashMap<String, Boolean> processedMap; // 已处理过的节点表

    public static void main(String args[]) {
        prepareForWork();
        findPath();
        descriptFinalPath();
    }

    /**
     * 准备工作
     * 准备数据 建模 加权图
     */
    public static void prepareForWork() {
        // 1. 将图的 所有点和边上的权值 抽象出来 形成hashmap
        graphMap = new HashMap();

        // 起点
        HashMap<String, Integer> start = new HashMap();
        start.put(pointA, 6);
        start.put(pointB, 2);
        graphMap.put(pointStart, start); // start节点 可到达的节点和权重

        // A点
        HashMap<String, Integer> A = new HashMap();
        A.put(pointFin, 1);
        graphMap.put(pointA, A);

        // B点
        HashMap<String, Integer> B = new HashMap();
        B.put(pointA, 3);
        B.put(pointFin, 5);
        graphMap.put(pointB, B);

        // 终点 没有元素
        HashMap<String, Integer> fin = new HashMap();
        graphMap.put(pointFin, fin);

        // ----- graph表画完 -----

        // 对于不知道多长时间的 先设置为无穷大
        int infinity = Integer.MAX_VALUE;

        // 2. 创建开销表 到达这个点的(当前的)最优开销 需要不断更新value优化最优开销
        costsMap = new HashMap();
        costsMap.put(pointStart, 0);
        costsMap.put(pointA, 6); // 起始节点的邻居节点开销 这个开销不用累加的 因为就是从起点开始算的
        costsMap.put(pointB, 2);
        costsMap.put(pointFin, infinity); // 对于节点未知的开销 统一为无限大

        // 3. 创建父节点表 到达这个点的最优路径 记录这个点的父节点 需要不断更新
        parentMap = new HashMap();
        parentMap.put(pointA, pointStart);
        parentMap.put(pointB, pointStart);
        parentMap.put(pointFin, null); // 对于节点未知的父节点 为null

        // 4. 记录处理过的节点 对于处理过的节点不用处理多次
        processedMap = new HashMap();
    }

    /**
     * 查找最优路径 这个最重要
     */
    public static void findPath() {
        // 1. 每次查找开销最少的节点
        String node = finaLowestCostNode();
        while (node != null && !node.isEmpty()) {
            // 2. 找到node的所有邻居节点
            // 3. 更新到达这些节点的最少开销 如果需要的话 更新costs表
            // 4. 如果更新了开销 则更新这个节点的父节点
            HashMap<String, Integer> neighbors = graphMap.get(node); // 就是这个节点的子节点
            for (Map.Entry<String, Integer> entry : neighbors.entrySet()) {
                String tempNode = entry.getKey(); // node节点下的每个邻居节点

                int oldCost = costsMap.get(tempNode);
                int newCost = costsMap.get(node) + entry.getValue();

                if (newCost < oldCost) {
                    costsMap.put(tempNode, newCost); // 更新开销表
                    parentMap.put(tempNode, node); // 更新父节点
                }
            }

            // 5. 当前的这个node节点标记为已处理
            processedMap.put(node, true);

            // 6. 查找下一个最少开销的节点
            node = finaLowestCostNode();
        }
    }

    /**
     * 寻找开销最少的节点
     * 开销是 从起点开始算 到达这个点的最小开销
     */
    public static String finaLowestCostNode() {
        int lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = "";

        for (Map.Entry<String, Integer> entry : costsMap.entrySet()) {
            String tempNode = entry.getKey();
            int tempCost = entry.getValue();

            if ((tempCost < lowestCost) && (processedMap.get(tempNode) == null || (processedMap.get(tempNode) == false))) {
                lowestCost = tempCost;
                lowestCostNode = tempNode;
            }
        }

        System.out.println("lowestCostNode = " + lowestCostNode + ", lowestCost = " + lowestCost);
        return lowestCostNode;
    }

    /**
     * 打印最终查找到的路径和开销 回溯路径
     *
     */
    public static void descriptFinalPath() {
        List<Node> list = new ArrayList(); // 所有的节点和其开销 用链表串起来 谁是谁的父节点

        // 初始化 先加入终点
        Node node = new Node();
        node.nodeName = pointFin;
        node.cost = costsMap.get(node.nodeName);
        list.add(node);

        while (parentMap.get(node.nodeName) != null) { // 当没有父节点时 就是起点 退出循环
            Node parentNode = new Node();
            parentNode.nodeName = parentMap.get(node.nodeName);
            parentNode.cost = costsMap.get(parentNode.nodeName);
            list.add(0, parentNode);

            node = parentNode;
        }

        for (Node node1 : list) {
            System.out.println("节点: " + node1.nodeName + " 开销: " + node1.cost);
        }
    }

    public static class Node {
        public String nodeName;
        public int cost;
    }


}
