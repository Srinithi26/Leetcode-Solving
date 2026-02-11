class Solution {
    public TreeNode sortedListToBST(ListNode head) {
         if (head == null) {
                return null;
            }
            if (head.next == null) {
                return new TreeNode(head.val);
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = head, fast = head, prev = dummy;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode newHead = slow.next;
            prev.next = null; 

            TreeNode root = new TreeNode(slow.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(newHead);

            return root;
    }
}