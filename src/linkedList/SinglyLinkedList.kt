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

    fun insertAtPosition(data: Int, pos: Int) {

        if (head == null) {
            return
        }
        var current = head
        var count = 0
        var newNode = Node(data)
        while (current?.next != null) {
            count++
            if (count == pos - 1) {
                return
            }
            current = current.next

        }

        val temp = current?.next
        current?.next = newNode
        newNode.next = temp


    }

    fun insertAtHead(data: Int) {
        var newNode = Node(data)
        if (head == null) {
            head = newNode
        } else {
            newNode.next = head
            head = newNode
        }
    }

    fun print() {
        var current = head
        while (current != null) {
            println(current.data)
            current = current.next
        }
    }
    fun deleteHead(){
        if (head == null){
            return
        }
        head = head?.next
    }
    fun deleteEnd(){
        if (head == null){
            return
        }
        var current = head
        while(current?.next?.next != null){
            current = current.next
        }
        current?.next = null

    }
    fun deleteNode(data : Int){
        if (head == null){
            return
        }
        var current = head
        while(current != null){
            if(current.next?.data == data){
                current.next = current.next?.next
                return
            }
            current = current.next
        }


    }
}