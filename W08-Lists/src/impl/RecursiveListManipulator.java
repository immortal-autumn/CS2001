package impl;

import java.util.Comparator;

import common.InvalidIndexException;
import common.ListNode;
import interfaces.IListManipulator;
import interfaces.IOperator;
import interfaces.ITransformation;

/**
 * This class represents the recursive implementation of the IListManipulator interface.
 *
 */
public class RecursiveListManipulator implements IListManipulator {
    private ListNode combinedList = null;

    @Override
    public int size(ListNode head) {
        // TODO Auto-generated method stub
        if(head == null) return 0;
        else return size(head.next) + 1;
    }

    @Override
    public boolean contains(ListNode head, Object element) {
        // TODO Auto-generated method stub
        if(head == null) return false;
        else {
            if(head.element.equals(element)) return true;
            else return contains(head.next, element);
        }
    }

    @Override
    public int count(ListNode head, Object element) {
        // TODO Auto-generated method stub
        if(head == null) return 0;
        else {
            if(head.element.equals(element)) return count(head.next, element) + 1;
            else return count(head.next, element);
        }
    }

    @Override
    public String convertToString(ListNode head) {
        // TODO Auto-generated method stub
        if(head == null) return "";
        else {
            if(head.next != null) return convertToString(head.next) + "," + head.element;
            else return convertToString(null) + head.element;
        }
    }

    @Override
    public Object getFromFront(ListNode head, int n) throws InvalidIndexException {
        // TODO Auto-generated method stub
        ListNode root = head;
        if(root != null) {
            for(int i = 0; i < n; i++) {
                if(root.next != null) {
                    root = root.next;
                }
                else throw new InvalidIndexException();
            }
            return root.element;
        }
        else {
            throw new InvalidIndexException();
        }
    }

    @Override
    public Object getFromBack(ListNode head, int n) throws InvalidIndexException {
        // TODO Auto-generated method stub
        int size_of = size(head); //similar to root = head but get size
        ListNode root = head;
        if(root != null && size_of >= n + 1) {
            for(int i = 0; i < size_of - n - 1; i++) {
//                System.out.println(i + " " + size_of + " " + root.next + " " + root.element + " " + n);
                if(root.next != null) {
                    root = root.next;
                }
                else throw new InvalidIndexException();
            }
            return root.element;
        }
        else {
            throw new InvalidIndexException();
        }
    }

    @Override
    public boolean deepEquals(ListNode head1, ListNode head2) {
        // TODO Auto-generated method stub
        if(head1 == null && head2 == null) {
            return true;
        }
        if(head1 == null || head2 == null) {
            return false;
        }
        if(head1.element == head2.element) {
            return deepEquals(head1.next, head2.next);
        }
        else return false;

    }

    @Override
    public ListNode deepCopy(ListNode head) {
        // TODO Auto-generated method stub
        if(head == null) return null;
        return new ListNode(head.element,deepCopy(head.next));
    }

    @Override
    public boolean containsDuplicates(ListNode head) {
        // TODO Auto-generated method stub
        if(head == null) return false;
        if(count(head, head.element) >= 2) return true;
        return containsDuplicates(head.next);
    }

    @Override
    public ListNode append(ListNode head1, ListNode head2) {
        // TODO Auto-generated method stub
        if(head1 == null && head2 == null) return null;
        if(head1 != null) {
            return new ListNode(head1.element, append(head1.next, head2));
        }
        return new ListNode(head2.element, append(null, head2.next));
    }

    @Override
    public ListNode flatten(ListNode head) {
        // TODO Auto-generated method stub
        if (head == null) return combinedList;
        if (head.element == null) return flatten(head.next);

        combinedList = append(combinedList, (ListNode) head.element);

        return flatten(head.next);
    }

    @Override
    public boolean isCircular(ListNode head) {
        // TODO Auto-generated method stub
        if(head == null) return false;
        return false;
    }

    @Override
    public boolean containsCycles(ListNode head) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ListNode sort(ListNode head, Comparator comparator) {
        // TODO Auto-generated method stub
        if(head == null) return head;
        ListNode root = head;
        for(int i = 0; i < size(head); i ++) {
            if (comparator.compare(root.element, root.next.element) > 0) {
                Object element = root.next.element;
                root.next.element = root.element;
                root.element = element;
            }
            else return sort(head.next, comparator);
        }
        return sort(head, comparator);
    }

    @Override
    public ListNode map(ListNode head, ITransformation transformation) {
        // TODO Auto-generated method stub
        if(head == null) return null;
        return new ListNode(transformation.transform(head.element), map(head.next, transformation));
    }

    @Override
    public Object reduce(ListNode head, IOperator operator, Object initial) {
        // TODO Auto-generated method stub
        if (head == null) return operator.operate(initial, 0);
        return reduce(head.next, operator, operator.operate(initial, head.element));
    }

}
