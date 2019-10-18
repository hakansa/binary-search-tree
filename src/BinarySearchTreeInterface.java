
public interface BinarySearchTreeInterface<T extends Comparable<? super T>> {
	public void setTree(T rootData);
	public void setTree(T rootData, BinarySearchTree<T> leftTree,BinarySearchTree<T> rightTree);
	public T getRootData();
	public T getEntry(T entry);
	public T add(T entry);
	
	public boolean contains(T entry);
	public boolean isEmpty();
	public void clear();
	
	public void inorderTraverse();
	public BinaryNode<T> getRoot();
	public T findKthSmallest(int k, BinaryNode<T> rootNode);
	
	
}
