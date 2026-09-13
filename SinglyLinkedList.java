public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        Node walk = this.head;

        StringBuilder sb = new StringBuilder();

        while (walk != null){
            sb.append(walk.getElement());
            walk = walk.getNext();
        }

        return sb.toString();
    }

    public E removeLast(){

        if (head == null) return null;

        if (head == tail){
            E element = head.getElement();
            
            head = null; 
            tail = null;

            return element;
        }

        Node newLast = head;
        while (newLast.getNext() != tail){
            newLast = newLast.getNext();
        }

        E element = tail.getElement();

        tail = newLast;

        tail.setNext(null);

        return element;
      
    }

    public void reverse(){       

        Node previous = null;
        Node walker = head;
        tail = head; 

        while (walker != null){
            Node next = walker.getNext();

            walker.setNext(previous);

            previous = walker;
            walker = next;
        }

        head = previous;
    }
}