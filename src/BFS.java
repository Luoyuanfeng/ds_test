import java.util.LinkedList;
import java.util.Queue;

/**
 * 带换行打印的BFS
 */
public class BFS {

    private static class BiTreeNode {
        public int value;
        public BiTreeNode left;
        public BiTreeNode right;

        public BiTreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BiTreeNode root = new BiTreeNode(1);
        root.left = new BiTreeNode(2);
        root.right = new BiTreeNode(3);
        root.left.right = new BiTreeNode(4);
        root.right.left = new BiTreeNode(5);
        root.right.right = new BiTreeNode(6);
        bfs(root);
    }

    public static void bfs(BiTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BiTreeNode> q = new LinkedList<>(); // 非递归dfs通过stack实现，非递归bfs通过queue实现
        q.add(root);
        BiTreeNode lineNode = root;
        BiTreeNode endOfLine = root;
        while (!q.isEmpty()) {
            BiTreeNode queueHead = q.poll();
            System.out.printf("%d ", queueHead.value);
            if (queueHead.left != null) {
                q.add(queueHead.left);
                lineNode = queueHead.left;
            }
            if (queueHead.right != null) {
                q.add(queueHead.right);
                lineNode = queueHead.right;
            }
            if (endOfLine == queueHead) { // 把上一层末尾节点的左右孩子入队之后，就认为最后一个入队的孩子节点是下一行的末尾了，此时记录下一行的末尾节点并为当前层打印一个换行
                System.out.print("\n");
                endOfLine = lineNode;
            }
        }
    }
}
