package models;

class Binary_Node
{
    Binary_Node(Comparable value) {
        this.value = value;
        left = right = null;
    }

    Comparable value;          // The data in the node
    Binary_Node left;         // Left child
    Binary_Node right;        // Right child
}