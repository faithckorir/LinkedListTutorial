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


    fun removeDups() {
        var current = head

        while (current?.next != null) {
            var inner = current
            while (inner?.next != null) {
                if (current.data == inner.next?.data) {
                    inner.next = inner.next?.next
                } else {
                    inner = inner.next
                }
            }
            current = current.next

        }
    }

    fun rDups(){
       var current = head

        while(current!= null){
            var temp = current

            while(temp != null
                && temp.data == current.data){
                temp =temp.next
            }
            current.next = temp
            current = current.next

        }
    }

    fun removeDuplicate() {
        // Hash to store seen values
        val hs = HashSet<Int>()

        /* Pick elements one by one */
        var current = head
        var prev :Node? = null
        while (current != null) {
            val curval = current.data

            // If current value is seen before
            if (hs.contains(curval)) {
                prev?.next = current.next
            } else {
                hs.add(curval)
                prev = current
            }
            current = current.next
        }
    }

    fun removeByHushing(){
        //time complexity 0(n)
        //space complexity O(1)
        var current = head
        var prev : Node? = null
        val hashSet = HashSet<Int>()
        while(current != null){
            val data = current.data

            if(hashSet.contains(data)){
                prev?.next = current.next

            }else{
                hashSet.add(data)
                prev = current
            }


            current = current.next
        }
    }
    fun length():Int{
        if(head == null){
            return 0
        }
        var count = 1
        var current = head
        while(current?.next != null){
            count++
            current = current.next
        }

        return count
    }
}