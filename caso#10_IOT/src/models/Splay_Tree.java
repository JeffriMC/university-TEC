package models;

public class Splay_Tree {
	private Binary_Node root;

	public Splay_Tree() {
		root = null;
	}

	/**
	 * Insert into the tree.
	 * 
	 * @param x the item to insert.
	 * @throws DuplicateItemException if x is already present.
	 */
	public void insert(Comparable value) {
		Binary_Node n;
		int c;
		if (root == null) {
			root = new Binary_Node(value);
			return;
		}
		splay(value);
		if ((c = value.compareTo(root.value)) == 0) {
			// throw new DuplicateItemException(x.toString());
			return;
		}
		n = new Binary_Node(value);
		if (c < 0) {
			n.left = root.left;
			n.right = root;
			root.left = null;
		} else {
			n.right = root.right;
			n.left = root;
			root.right = null;
		}
		root = n;
	}

	/**
	 * Remove from the tree.
	 * 
	 * @param x the item to remove.
	 * @throws ItemNotFoundException if x is not found.
	 */
	public void remove(Comparable value) {
		Binary_Node x;
		splay(value);
		if (value.compareTo(root.value) != 0) {
			// throw new ItemNotFoundException(x.toString());
			return;
		}
		// Now delete the root
		if (root.left == null) {
			root = root.right;
		} else {
			x = root.right;
			root = root.left;
			splay(value);
			root.right = x;
		}
	}

	/**
	 * Find the smallest item in the tree.
	 */
	public Comparable findMin() {
		Binary_Node x = root;
		if (root == null)
			return null;
		while (x.left != null)
			x = x.left;
		splay(x.value);
		return x.value;
	}

	/**
	 * Find the largest item in the tree.
	 */
	public Comparable findMax() {
		Binary_Node x = root;
		if (root == null)
			return null;
		while (x.right != null)
			x = x.right;
		splay(x.value);
		return x.value;
	}

	/**
	 * Find an item in the tree.
	 */
	public Comparable find(Comparable value) {
		if (root == null)
			return null;
		splay(value);
		if (root.value.compareTo(value) != 0)
			return null;
		return root.value;
	}

	/**
	 * Test if the tree is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * this method just illustrates the top-down method of implementing the
	 * move-to-root operation
	 */
	private void moveToRoot(Comparable value) {
		Binary_Node l, r, t, y;
		l = r = header;
		t = root;
		header.left = header.right = null;
		for (;;) {
			if (value.compareTo(t.value) < 0) {
				if (t.left == null)
					break;
				r.left = t; /* link right */
				r = t;
				t = t.left;
			} else if (value.compareTo(t.value) > 0) {
				if (t.right == null)
					break;
				l.right = t; /* link left */
				l = t;
				t = t.right;
			} else {
				break;
			}
		}
		l.right = t.left; /* assemble */
		r.left = t.right;
		t.left = header.right;
		t.right = header.left;
		root = t;
	}

	private static Binary_Node header = new Binary_Node(null); // For splay

	/**
	 * Internal method to perform a top-down splay.
	 * 
	 * splay(value) does the splay operation on the given value. If value is in the
	 * tree, then the Binary_Node containing that value becomes the root. If value
	 * is not in the tree, then after the splay, value.root is either the greatest
	 * value < value in the tree, or the lest value > value in the tree.
	 *
	 * This means, among other things, that if you splay with a value that's larger
	 * than any in the tree, the rightmost node of the tree becomes the root. This
	 * property is used in the delete() method.
	 */

	private void splay(Comparable value) {
		Binary_Node l, r, t, y;
		l = r = header;
		t = root;
		header.left = header.right = null;
		for (;;) {
			if (value.compareTo(t.value) < 0) {
				if (t.left == null)
					break;
				if (value.compareTo(t.left.value) < 0) {
					y = t.left; /* rotate right */
					t.left = y.right;
					y.right = t;
					t = y;
					if (t.left == null)
						break;
				}
				r.left = t; /* link right */
				r = t;
				t = t.left;
			} else if (value.compareTo(t.value) > 0) {
				if (t.right == null)
					break;
				if (value.compareTo(t.right.value) > 0) {
					y = t.right; /* rotate left */
					t.right = y.left;
					y.left = t;
					t = y;
					if (t.right == null)
						break;
				}
				l.right = t; /* link left */
				l = t;
				t = t.right;
			} else {
				break;
			}
		}
		l.right = t.left; /* assemble */
		r.left = t.right;
		t.left = header.right;
		t.right = header.left;
		root = t;
	}
}
