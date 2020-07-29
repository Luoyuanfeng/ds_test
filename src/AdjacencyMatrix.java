import java.util.*;

/**
 * 邻接矩阵判断图中是否有环
 */
public class AdjacencyMatrix {

    public static void main(String[] args) {
        int[][] m = {
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0},
        };
        boolean has = hasLoop(m);
        System.out.println(has);
    }

    private static boolean hasLoop(int[][] matrix) {
        if (matrix == null) {
            return false;
        }
        int nodeNum = matrix.length; // n阶邻接矩阵的行数n就是整个图的节点个数n
        if (nodeNum == 0) {
            return false;
        }
        int[] inEdge = new int[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            for (int j = 0; j < nodeNum; j++) {
                if (matrix[i][j] != 0) {
                    inEdge[j]++; // 统计各个节点的入度
                }
            }
        }
        System.out.println(Arrays.toString(inEdge));

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < inEdge.length; i++) {
            if (inEdge[i] == 0) { // 入度为0的节点先入栈
                s.push(i);
            }
        }

        int visitedCount = 0;
        while (!s.isEmpty()) {
            int top = s.pop();
            visitedCount++; // 这部分算法只访问入度为0的节点
            for (int i = 0; i < nodeNum; i++) { // 每访问一个节点，就把当前访问节点出栈，并减少其后续节点的入度
                if (matrix[top][i] == 1) {
                    inEdge[i]--;
                    if (inEdge[i] == 0) { // 入度减到0，入栈。若某节点在环内，则其入度不可能被减为0，即不会被该算法访问到
                        s.push(i);        // 如果是 1 -> 2 -> 4 的情况，虽然4的入度为2，但是访问1时会把2和3的入度都减为0，则4的入度也可以被减为0，故这种case不成环
                    }                     //       |__> 3 ___^
                }                         //
            }                             // 如果是 1 -> 2 -> 3 -> 4 的情况，访问1时只能把2的入度减为1，后面再无可能产生入度为0的节点，故这种case成环
        }                                 //            ^_________|

        System.out.println(Arrays.toString(inEdge));
        return visitedCount != nodeNum; // 最终判断是不是图中的所有节点都被访问过
    }
}
