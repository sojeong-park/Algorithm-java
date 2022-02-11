package tree;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/**
 * binary search tree 문제
 * 트리를 순회하면서 범위내의 값을 구해내자
 * 현재 노드의 값이 범위 안에 있을 경우 left, right 탐색을 해야 전체 탐색하지 않을수 있어 탐색시간을 줄일 수 있다.
 * 시간복잡도: O(N) -> N은 트리의 노드 개수
 * 공간복잡도: O(N) -> 재귀함수 사용시 함수 호출 스택에 추가 공간 사용함
 * */
public class LeetCode938 {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        traverse(root, low, high);
        return sum;
    }

    public void traverse(TreeNode root, int low, int high) {
        if (root == null) return;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.val > low)
            traverse(root.left, low, high);
        if (root.val < high)
            traverse(root.right, low, high);
    }
}
