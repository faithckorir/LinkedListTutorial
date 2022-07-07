package linkedList

import java.util.*


fun main() {
    val list = SinglyLinkedList()
    /*  list.insertNode(34)
      list.insertNode(3)
      list.insertNode(4)
      list.print()
      list.insertAtHead(1)
      list.print()
      println("printint at pos")
      list.insertAtPosition(2, 2)
      list.print()
      println("delete head")

      list.deleteHead()
      list.print()
      println("delete end")
      list.deleteEnd()
      list.print()
      println("delete node")
      list.deleteNode(3)
      list.print()*/

    println("working with duplicates")
    list.insertNode(3)
    list.insertNode(3)
    list.insertNode(3)
    list.insertNode(4)
    list.insertNode(6)
    list.insertNode(7)
    list.insertNode(8)
    list.removeByHushing()
    list.print()
    println(list.length())


    list.printMiddle()
}

