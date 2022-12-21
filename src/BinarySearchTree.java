import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {

    protected TreeNode<E> root;
    protected int size = 0;

    /**
     * Create a default binary tree
     */
    public BinarySearchTree() {
    }

    /**
     * Create a binary tree from an array of objects
     */
    public BinarySearchTree(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    /**
     * Returns true if the element is in the tree
     */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                return true; // Element is found
        }
        return false;
    }

    /**
     * Insert element o into the binary tree
     * Return true if the element is inserted successfully.
     * Uses an iterative algorithm
     */
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; // Element inserted
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<E>(e);
    }

    /**
     * Inorder traversal from the root
     */
    public void inorder() {
        inorder(root);
    }

    /**
     * Inorder traversal from a subtree
     */
    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }


    /**
     * Postorder traversal from the root
     *////root
    public void postorder() {
        postorder(root);
    }

    /**
     * Postorder traversal from a subtree
     */
    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    /**
     * Preorder traversal from the root
     */
    public void preorder() {
        preorder(root);
    }

    /**
     * Preorder traversal from a subtree
     */
    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * Inner class tree node
     */
    public static class TreeNode<E extends Comparable<E>> {
        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    /**
     * Get the number of nodes in the tree
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    public TreeNode getRoot() {
        return root;
    }

    /**
     * Create an ArrayList
     * Iterate through the tree such as in search and add each element to the ArrayList.
     * Break the loop upon reaching the element.
     * Will the loop break upon reaching the element?
     * Return the Arraylist
     */

    /**
     * Returns an ArrayList containing elements in the path from the root leading to the specified element, returns an empty ArrayList if no  such element exists.
     */
    public ArrayList<E> path(E e) {
        java.util.ArrayList<E> list = new java.util.ArrayList<E>();
        TreeNode<E> current = root; // Start from the root
        //implement the code here as in search method.
        if (root != null && search(e)) {
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    list.add(current.element);
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    list.add(current.element);
                    current = current.right;

                } else break; // element matches current.element
            }
        }
        return list; // Return an array of elements
    }

    /**
     * Check if tree is empty
     * Check if each node is a leaf; if it is a leaf, increment the count.
     * Postorder search is used.
     * Complete Post order
     *
     * @return the count.
     */
    /* Returns the number of leaf nodes in this tree, returns 0 if tree is empty*/
    public int getNumberOfLeaves() {
        //left for you to implement in Lab 7
        int count = 0; //count of leaf nodes
        if (root == null) return count;
        count = getNumberOfLeaves(root);
        return count;
    }

    private int getNumberOfLeaves(TreeNode<E> root) {
        int count = 0;
        TreeNode<E> current = root;
        //Check if tree is empty
        if (root == null) return count;
        count += getNumberOfLeaves(root.left);
        count += getNumberOfLeaves(root.right);

        if (current.left == null && current.right == null) {
            count++;
        }
        return count;
    }

    /**
     * Check if tree is empty
     * Create an ArrayList.
     * Iterate through the tree in preorder and add each element starting from specified element.
     * Root is not specified element.
     * Return the ArrayList.
     * Does it need to search for the element before returning the empty ArrayList?
     *
     * @param e Eleemnet to be searched.
     * @return Return the array empty or not.
     */
    /* Returns an ArrayList containing all elements in preorder of the specified element’s left sub-tree, returns an empty ArrayList if no  such element exists. */
    public ArrayList<E> leftSubTree(E e) {
        //left for you to implement in Lab 7
        java.util.ArrayList<E> list = new java.util.ArrayList<>();
        if (root.left == null) return list;
        TreeNode<E> current = root.left;//Start from the root's left tree.
        leftSubTree(current);
        //while (root != null && search(e)) {}

return list;
    }

    private ArrayList<E> leftSubTree(TreeNode<E> current) {
        java.util.ArrayList<E> list = new java.util.ArrayList<>();

        /**while (root != null) {
         TreeNode<E> current = root.left;//Start from the root's left tree.
         //base case
         list.add(current.element);
         //currently looping indefinitely.
         list.add(leftSubTree(root.right));
         list.add(leftSubTree(current.right));

         } **/
        return list;
    }

    /**
     * Check if tree is empty.
     * Create an ArrayList.
     * Iterate through the tree in
     * preorder and add each element starting from specified element.
     * Iterate recursively or through a loop.
     * Root is not the specified element.
     * Return all elements in the tree.
     * Return the ArrayList.
     * Does it need to search for the element before returning the empty ArrayList?
     *
     * @param e Eleemnet to be searched.
     * @return Return the array empty or not.
     */
    /* Returns an ArrayList containing all elements in preorder of the specified element’s right sub-tree, returns an empty ArrayList if no  such element exists. */
    public ArrayList<E> rightSubTree(E e) {
        //left for you to implement in Lab 7
        //path to the specified element.
        java.util.ArrayList<E> list = new java.util.ArrayList<E>();
        if (root != null && search(e)) {
            TreeNode<E> current = root;//Start from the root.
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    current = current.right;

                } else break; // element matches current.element
            }
            //loop to iterate through selected node's subtree.
            //If element is found && current = element, find all elements in the tree.
            //Start from specifiied elemetn's right subtree.
            if (current.right != null) {
                list.addAll(rightSubTree(current.right));
                
            }
            //try adding a for loop to add current.left.element and current.right.element.

            /*while (current != null) {
                //list.add(current.element);
                if (current.left != null) {
                    current = current.left;
                    list.add(current.element);
                } else if (current.right != null) {
                    current = current.right;
                    list.add(current.element);
                }
            } */
        }
        return list;
    }



    //Recursive function to get a specified subtree in preorder
public ArrayList<E> rightSubTree(TreeNode<E> root) {
    java.util.ArrayList<E> subList = new java.util.ArrayList<E>();
    if (root == null) return subList;

    subList.add(root.element);
    subList.addAll(rightSubTree(root.left));
    subList.addAll(rightSubTree(root.right));


    return subList;
    }
    /**
     * Check if the tree is empty.
     * Search for the element within the tree.
     * Does it need the "parent" var for the
     * Is inorderPredecessor called recursively?
     *
     * @param
     * @return
     */
    /* Returns the inorder predecessor of the specified element, returns null if tree is empty or element 'e' is not in the tree. */
    public E inorderPredecessor(E e) {
        //left for you to implement in Lab 7
        if (root != null && search(e)) {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return parent.element;
                }
            }
        }
        return null;
    }

    /**
     * Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree
     */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break; // Element is in the tree pointed by current
        }
        if (current == null)
            return false; // Element is not in the tree
        // Case 1: current has no left children
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {
            // Case 2 & 3: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }
            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
        }
        size--;
        return true; // Element inserted
    }

    /**
     * Obtain an iterator. Use inorder.
     */
    public java.util.Iterator iterator() {
        return inorderIterator();
    }

    /**
     * Obtain an inorder iterator
     */
    public java.util.Iterator inorderIterator() {
        return new InorderIterator();
    }

    // Inner class InorderIterator
    class InorderIterator implements java.util.Iterator {
        // Store the elements in a list
        private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
        private int current = 0; // Point to the current element in list

        public InorderIterator() {
            inorder(); // Traverse binary tree and store elements in list
        }

        /**
         * Inorder traversal from the root
         */
        private void inorder() {
            inorder(root);
        }

        /**
         * Inorder traversal from a subtree
         */
        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        /**
         * Next element for traversing?
         */
        public boolean hasNext() {
            if (current < list.size())
                return true;
            return false;
        }

        /**
         * Get the current element and move cursor to the next
         */
        public Object next() {
            return list.get(current++);
        }

        /**
         * Remove the current element and refresh the list
         */
        public void remove() {
            delete(list.get(current)); // Delete the current element
            list.clear(); // Clear the list
            inorder(); // Rebuild the list
        }
    }

    /**
     * Remove all elements from the tree
     */
    public void clear() {
        root = null;
        size = 0;
    }
}
