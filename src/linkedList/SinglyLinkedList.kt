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

    fun rDups() {
        var current = head

        while (current != null) {
            var temp = current

            while (temp != null
                && temp.data == current.data
            ) {
                temp = temp.next
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
        var prev: Node? = null
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

    fun printMiddle() {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next

        }
        println(slow?.data)
    }

    fun removeByHushing() {
        //time complexity 0(n)
        //space complexity O(1)
        var current = head
        var prev: Node? = null
        val hashSet = HashSet<Int>()
        while (current != null) {
            val data = current.data

            if (hashSet.contains(data)) {
                prev?.next = current.next

            } else {
                hashSet.add(data)
                prev = current
            }


            current = current.next
        }
    }

    fun length(): Int {
        if (head == null) {
            return 0
        }
        var count = 0
        var current = head
        while (current != null) {
            count++
            current = current.next

        }

        return count
    }

    fun detectLoopByHashing() {
        //time complexity O(n)
        //space complexity O(n) additional hashset
        var current = head
        val hs = HashSet<Node>()

        while (current != null) {

            if (hs.contains(current)) {
                println("There is  a loop")
                return
            } else {
                hs.add(current)
            }
            current = current.next
        }
        println("No Loop")
    }


    fun detectLoopByFloydsMethod() {
        var slow_pointer = head
        var fast_pointer = head

        while (fast_pointer?.next != null) {
            if (slow_pointer == fast_pointer) {
                println("yes looop")
                return
            } else {
                fast_pointer = fast_pointer.next?.next
                slow_pointer = slow_pointer?.next
            }
        }
        println("No Loop")
    }

    fun countNodesinLoop(list: Node?): Int {
        var slow_p = list
        var fast_p = list
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next
            fast_p = fast_p.next!!.next

            /* If slow_p and fast_p meet at some point
        then there is a loop */if (slow_p == fast_p) return countNodes(slow_p)
        }

        /* Return 0 to indicate that there is no loop*/return 0
    }

    private fun countNodes(slowP: Node?): Int {

        var count = 1
        var current = slowP
        while(current != slowP){
            count++
            current = current?.next
        }

        return count

    }


}