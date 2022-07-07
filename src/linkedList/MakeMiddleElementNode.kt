package linkedList


fun main() {

}

class MMEList {
    /**
     * make middle element head of a linked list
     * traverse the list to get its length as well as the middle element for this we can use two pointers
     * keep track of the previous element to the middle element so as to join that to the element next after middle
     * make middle.next head
     * make head = middle
     *
     *
     *
     * */

    var head: Node? = null
    var tail: Node? = null

    fun insert(data: Int) {
        var newNode = Node(data)
        if (head == null) {
            head = newNode
        } else {
            tail?.next = newNode
        }
        tail = newNode
    }

    fun makeMiddleHead() {
        //traverse the list
        var slowP = head
        var fastP = head
        var prev: Node? = null

        while (fastP?.next != null) {
            fastP = fastP.next?.next
            prev = slowP
            slowP = slowP?.next

        }
        //we found the middle element
        prev?.next = slowP?.next
        slowP?.next = head
        head = slowP

    }


}