import java.util.*;

class TreeNode {
    int data;
    TreeNode right;
    TreeNode left;

    public TreeNode(int item) {
        this.data = item;
        this.left = this.right = null;
    }
}

public class constructBTfromIN_PRE {

    public static TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        int preStart = 0, preEnd = preorder.size()-1;
        int inStart = 0, inEnd = inorder.size()-1;
        
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=inStart; i<=inEnd; i++) {
            mp.put(inorder.get(i), i);
        }

        return constructTree(preorder, preStart, preEnd, inorder, inStart, inEnd, mp);

    }

    public static TreeNode constructTree(ArrayList<Integer> preorder, int preStart, int preEnd, ArrayList<Integer> inOrder, int inStart, int inEnd, HashMap<Integer, Integer> mp) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder.get(preStart));   
        int elem = mp.get(root.data);
        int nElem = elem - inStart;

        root.left = constructTree(preorder, preStart+1, preStart+nElem, inOrder, inStart, elem-1, mp);
        root.right = constructTree(preorder, preStart+nElem+1, preEnd, inOrder, elem+1, inEnd, mp);

        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> preorder = new ArrayList<>(Arrays.asList(1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7));
        ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7));
    
        TreeNode root = buildTree(preorder, inorder);

        BT(root);
    }
}
