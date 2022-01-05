package main.kotlin.linked_list

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun addMany(linkedList: LinkedList, values: List<Int>): LinkedList {
    var current = linkedList
    while (current.next != null) {
        current = current.next!!
    }
    for (value in values) {
        current.next = LinkedList(value)
        current = current.next!!
    }
    return linkedList
}

fun getNodesInArray(linkedList: LinkedList?): List<Int> {
    val nodes = mutableListOf<Int>()
    var current: LinkedList? = linkedList
    while (current != null) {
        nodes.add(current.value)
        current = current.next
    }
    return nodes
}

fun removeDuplicatesFromLinkedList(linkedList: LinkedList): LinkedList {
    var currentNode: LinkedList? = linkedList
    while (currentNode != null) {
        var nextDistinctNode = currentNode.next
        while (nextDistinctNode != null && nextDistinctNode.value == currentNode.value) {
            nextDistinctNode = nextDistinctNode.next
        }

        currentNode.next = nextDistinctNode
        currentNode = nextDistinctNode
    }
    return linkedList
}

fun main() {
    val linkedList = addMany(LinkedList(1), listOf(1, 2, 3, 4, 5, 6, 7, 8))
    removeDuplicatesFromLinkedList(linkedList)
    println(getNodesInArray(linkedList))
}