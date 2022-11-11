    // Time Complexity : O(n)
    // Space Complexity : O(1)

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if(parentVal>pVal && parentVal>qVal)
            return lowestCommonAncestor(root.left, p, q);
        else if (parentVal<pVal && parentVal<qVal)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
