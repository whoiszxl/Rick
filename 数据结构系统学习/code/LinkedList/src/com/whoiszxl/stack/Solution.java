package com.whoiszxl.stack;

class Solution {

    private class LinkedList<E> {

        private class Node{
            public E e;
            public Node next;

            public Node(E e, Node next){
                this.e = e;
                this.next = next;
            }

            public Node(E e){
                this(e, null);
            }

            public Node(){
                this(null, null);
            }

            @Override
            public String toString(){
                return e.toString();
            }
        }

        private Node dummyHead;
        private int size;

        public LinkedList(){
            dummyHead = new Node();
            size = 0;
        }

        public int getSize(){
            return size;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void add(int index, E e){

            if(index < 0 || index > size)
                throw new IllegalArgumentException("Add failed. Illegal index.");

            Node prev = dummyHead;
            for(int i = 0 ; i < index ; i ++)
                prev = prev.next;

            prev.next = new Node(e, prev.next);
            size ++;
        }

        public void addFirst(E e){
            add(0, e);
        }

        public void addLast(E e){
            add(size, e);
        }


        public E get(int index){

            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed. Illegal index.");

            Node cur = dummyHead.next;
            for(int i = 0 ; i < index ; i ++)
                cur = cur.next;
            return cur.e;
        }


        public E getFirst(){
            return get(0);
        }


        public E getLast(){
            return get(size - 1);
        }


        public void set(int index, E e){
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Update failed. Illegal index.");

            Node cur = dummyHead.next;
            for(int i = 0 ; i < index ; i ++)
                cur = cur.next;
            cur.e = e;
        }


        public boolean contains(E e){
            Node cur = dummyHead.next;
            while(cur != null){
                if(cur.e.equals(e))
                    return true;
                cur = cur.next;
            }
            return false;
        }


        public E remove(int index){
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Remove failed. Index is illegal.");

            // E ret = findNode(index).e; // 涓ゆ閬嶅巻

            Node prev = dummyHead;
            for(int i = 0 ; i < index ; i ++)
                prev = prev.next;

            Node retNode = prev.next;
            prev.next = retNode.next;
            retNode.next = null;
            size --;

            return retNode.e;
        }


        public E removeFirst(){
            return remove(0);
        }


        public E removeLast(){
            return remove(size - 1);
        }


        public void removeElement(E e){

            Node prev = dummyHead;
            while(prev.next != null){
                if(prev.next.e.equals(e))
                    break;
                prev = prev.next;
            }

            if(prev.next != null){
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
        }

        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();

            Node cur = dummyHead.next;
            while(cur != null){
                res.append(cur + "->");
                cur = cur.next;
            }
            res.append("NULL");

            return res.toString();
        }
    }

    private interface Stack<E> {

        int getSize();
        boolean isEmpty();
        void push(E e);
        E pop();
        E peek();
    }

    private class LinkedListStack<E> implements Stack<E> {

        private LinkedList<E> list;

        public LinkedListStack(){
            list = new LinkedList<>();
        }

        @Override
        public int getSize(){
            return list.getSize();
        }

        @Override
        public boolean isEmpty(){
            return list.isEmpty();
        }

        @Override
        public void push(E e){
            list.addFirst(e);
        }

        @Override
        public E pop(){
            return list.removeFirst();
        }

        @Override
        public E peek(){
            return list.getFirst();
        }

        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            res.append("Stack: top ");
            res.append(list);
            return res.toString();
        }
    }

    public boolean isValid(String s) {

        LinkedListStack<Character> stack = new LinkedListStack<>();
        for(int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;

                char topChar = stack.pop();
                if(c == ')' && topChar != '(')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("([)]"));
    }
}
