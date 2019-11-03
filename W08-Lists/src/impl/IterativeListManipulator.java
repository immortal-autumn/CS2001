package impl;

import java.util.Comparator;

import common.InvalidIndexException;
import common.ListNode;
import interfaces.IListManipulator;
import interfaces.IOperator;
import interfaces.ITransformation;

/**
 * This class represents the iterative implementation of the IListManipulator interface.
 *
 */
public class IterativeListManipulator implements IListManipulator {
    @Override
    public int size(ListNode head) {
        // TODO Auto-generated method stub
        ListNode root = head;
        int current_size = 0;
        if(root != null && root.element != null) {
            current_size = 1;
//            System.out.println(root.element + ">" + root.next.element);
            while (root.next != null) {
                root = root.next;
                current_size += 1;
            }
        }
        return current_size;
    }

    @Override
    public boolean contains(ListNode head, Object element) {
        // TODO Auto-generated method stub
        ListNode root = head;
        boolean contains = false;
        if(root != null) {
            if (root.element.equals(element)) {
                contains = true;
            } else {
                while (root.next != null) {
                    if (root.next.equals(element)) {
                        contains = true;
                    }
                    root = root.next;
                }
            }
        }
        return contains;
    }

    @Override
    public int count(ListNode head, Object element) {
        // TODO Auto-generated method stub
        int counts = 0;
        ListNode root = head;
        if(root != null) {
            if(root.element.equals(element)) {
                counts += 1;
            }
            while (root.next != null) {
                if(root.next.element.equals(element)) {
                    counts += 1;
                }
                root = root.next;
            }
        }
        return counts;
    }

    @Override
    public String convertToString(ListNode head) {
        // TODO Auto-generated method stub
        String string_with_comma = "";
        ListNode root = head;
        if(root != null) {
            if(root.element != null) {
                string_with_comma += String.valueOf(root.element);
            }
            while (root.next != null) {
                string_with_comma += "," +String.valueOf(root.next.element);
                root = root.next;
            }
        }
        return string_with_comma;
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

    @Override //a bit confused
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
        ListNode root1 = head1, root2 = head2;
        //check if head is null
        if(head1 == null || head2 == null) {
            return head1 == null && head2 == null;
        }
        int size1 = size(head1), size2 = size(head2);
        if(size1 == size2) {
            for (int i = 0; i < size1; i++) {
                if(!root1.element.equals(root2.element)) {
                    return false;
                }
                root1 = root1.next;
                root2 = root2.next;
            }
            return true;
        }
        else return false;
    }

    @Override
    public ListNode deepCopy(ListNode head) {
        // TODO Auto-generated method stub
        /*
        1. Check the root is null.
        2. let root = head to prevent head to be changed.
         */
        ListNode root = head;
        if(root == null) return null;
        ListNode deepcopy = new ListNode(root.element);

        while (root.next != null) {
            ListNode newNode = new ListNode(root.next.element);
            deepcopy = append(deepcopy, newNode);
            root = root.next;
        }
//        System.out.println(size(deepcopy) + ">" + size(head));
        return deepcopy;
    }

    @Override
    public boolean containsDuplicates(ListNode head) {
        // TODO Auto-generated method stub
        ListNode root = head;
        if(root == null) return false;
        while (root.next != null) {
            if(count(head, root.element) >= 2) {
                return true;
            }
            root = root.next;
        }
        return false;
    }

    @Override
    public ListNode append(ListNode head1, ListNode head2) {
        if(head1 == null && head2 == null) return null;
        if(head1 == null) return new ListNode(head2.element, head2.next);
        if(head2 == null) return new ListNode(head1.element, head1.next);
        ListNode root = head1;
        while (root.next != null) {
            root = root.next;
        }
        root.next = head2;
        return new ListNode(head1.element, head1.next);
    }

    @Override
    public ListNode flatten(ListNode head) {
        // TODO Auto-generated method stub
        if (head == null) return null;
        ListNode root = head;
        ListNode combinedList = (ListNode)root.element;
        while (root.next != null) {
             combinedList = append(combinedList, (ListNode)root.next.element);
             root = root.next;
        }
        return combinedList;
    }

    @Override
    public boolean isCircular(ListNode head) {
        // TODO Auto-generated method stub
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
//            System.out.println(slow.element + ">" + fast.element);
            if(slow == head) {
                return true;
            }
            if(slow == fast) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean containsCycles(ListNode head) {
        // TODO Auto-generated method stub
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ListNode sort(ListNode head, Comparator comparator) {
        // TODO Auto-generated method stub
        ListNode root = head;
        int size = size(head);
        if (head == null) return null;
        for (int i = 0; i < size - 1;i++) {
            for (int j = 0; j < size - 1; j++) {
                if (comparator.compare(root.element, root.next.element) > 0) {
                    Object element = root.element;
                    root.element = root.next.element;
                    root.next.element = element;
//                    System.out.println(root.next.element + ">" + root.next.next.element);
                }
                root = root.next;
            }
            root = head;
        }
        return new ListNode(head.element, head.next);
    }

    @Override
    public ListNode map(ListNode head, ITransformation transformation) {
        // TODO Auto-generated method stub
        if(head == null) return null;
        ListNode root = head;
        ListNode new_Listnode = new ListNode(transformation.transform(root.element));
        while (root.next != null) {
            new_Listnode = append(new_Listnode, new ListNode(transformation.transform(root.next.element)));
//            System.out.println(transformation.transform(root.next.element));
            root = root.next;
        }
        return new_Listnode;
    }

    @Override
    public Object reduce(ListNode head, IOperator operator, Object initial) {
        // TODO Auto-generated method stub
        if(head == null) return initial;
        ListNode root = head;
        Object reduce = operator.operate(initial, root.element);
        while (root.next != null) {
            reduce = operator.operate(reduce, root.next.element);
            root = root.next;
        }
        return reduce;
    }

}
