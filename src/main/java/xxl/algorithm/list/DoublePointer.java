package xxl.algorithm.list;

/**
 * 双指针
 *
 * @author zhangliangbo
 * @since 2021/12/30
 */
public class DoublePointer {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.setNext(head);

        ListNode front = head;
        ListNode back = dummy;

        for (int i = 0; i < n; i++) {
            front = front.getNext();
        }

        while (front != null) {
            front = front.getNext();
            back = back.getNext();
        }

        back.setNext(back.getNext().getNext());
        return dummy.getNext();
    }

    public static void main(String[] args) {
        Dummy dummy = new Dummy();
        ListNode list = new ListNode(0);
        for (int i = 1; i < 10; i++) {
            dummy.append(list, i);
        }

        DoublePointer doublePointer = new DoublePointer();

        System.err.println(doublePointer.removeNthFromEnd(list, 3));
    }

}
