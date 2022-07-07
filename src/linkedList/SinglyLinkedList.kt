package linkedList

class SinglyLinkedList {
    var head: Node? = null
    var tail: Node? = null


    fun insertNode(data: Int) {
        val newNode = Node(data)
        if (head == null) {
            head = newNode
        } else {
            tail?.next = newNode
        }
        tail = newNode
    }
    fun print() {
        var current = head
        while (current != null) {
            println(current.data)
            current = current.next
        }
    }
    fun remove_duplicates() {
        var ptr1: Node? = null
        var ptr2: Node? = null
        val dup: Node? = null
        ptr1 = head

        /* Pick elements one by one */
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1

            /* Compare the picked element with rest
                of the elements */
            while (ptr2!!.next != null) {

                /* If duplicate then delete it */
                if (ptr1.data == ptr2.next!!.data) {

                    /* sequence of steps is important here
                     */
                    ptr2.next = ptr2.next!!.next
                    System.gc()
                } else  /* This is tricky */ {
                    ptr2 = ptr2.next
                }
            }
            ptr1 = ptr1.next
        }
    }


    fun removeDups(){
        var current = head

        while(current?.next != null){
            var inner = current
            while(inner?.next != null){
                if(current.data == inner.next?.data){
                    inner.next = inner.next?.next
                }else{
                    inner = inner.next
                }
            }
            current = current.next

        }
    }
}