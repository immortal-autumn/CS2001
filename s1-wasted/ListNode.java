package common;

public class ListNode {
    public Object element = null;
    public ListNode next = null;
    public ListNode previous = null;

    public ListNode(Object element, ListNode next) {
        this.element = element;
        this.next = next;
    }

    public ListNode(Object element) {
        this(element, null);
    }
}
