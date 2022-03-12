package xxl.algorithm.list;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhangliangbo
 * @since 2021/12/30
 */

@Getter
@Setter
@ToString
public class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
