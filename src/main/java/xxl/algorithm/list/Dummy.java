package xxl.algorithm.list;

/**
 * 哨兵
 *
 * @author zhangliangbo
 * @since 2021/12/30
 */
public class Dummy {
    public ListNode append(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.setNext(head);

        ListNode newNode = new ListNode(value);
        ListNode node = dummy;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(newNode);
        return dummy.getNext();
    }

    public ListNode delete(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.setNext(head);

        ListNode node = dummy;
        while (node.getNext() != null) {
            if (node.getNext().getVal() == value) {
                node.setNext(node.getNext().getNext());
                break;
            }
            node = node.getNext();
        }
        return dummy.getNext();
    }

    public static void main(String[] args) {
        Dummy dummy = new Dummy();
        ListNode list = new ListNode(1);
        System.err.println(dummy.append(list, 2));
        System.err.println(dummy.append(list, 3));
        System.err.println(dummy.append(list, 4));
        System.err.println(dummy.append(list, 5));

        System.err.println(dummy.delete(list, 3));
    }
}
