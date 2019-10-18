
public class BinarySearchTree<T extends Comparable<? super T>> implements BinarySearchTreeInterface<T> {
	
	private BinaryNode<T> root;
	
	
	public BinarySearchTree() {
		root=null;
	}
	public BinarySearchTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	public BinarySearchTree(T rootData,BinarySearchTree<T> leftTree,BinarySearchTree<T> rightTree) {
		privateSetTree(rootData,leftTree,rightTree);
	}
	public void setTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}
	public void setTree(T rootData,BinarySearchTree<T> leftTree,BinarySearchTree<T> rightTree) {
		privateSetTree(rootData,leftTree,rightTree);
	}
	private void privateSetTree(T rootData,BinarySearchTree<T> leftChild,BinarySearchTree<T> rightChild) {
		root = new BinaryNode<>(rootData);
		if(leftChild!=null)
			root.setLeftChild(leftChild.root);
		if(rightChild!=null)
			root.setLeftChild(rightChild.root);
	}
	
	

	@Override
	public T getRootData() {
		T dataOfRoot = null;
		if(root!=null)
			dataOfRoot=root.getData();
		return dataOfRoot;
	}
	@Override
	public BinaryNode<T> getRoot(){
		return root;
	}
	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}
	@Override
	public T getEntry(T entry) {
		// TODO Auto-generated method stub
		return search(root,entry);
	}

	@Override
	public T add(T entry) {
		T result = null;
		if(isEmpty())
			setRoot(new BinaryNode<>(entry));
		else
			result=addNode(getRoot(),entry);
		return result;
	}
	private T addNode(BinaryNode<T> node,T entry) {
		assert node!=null;
		T result=null;
		int compared = entry.compareTo(node.getData());
		if(compared==0) {
			result=node.getData();
			node.setData(entry);
		}
		else if(compared < 0) {
			if(node.hasLeftChild())
				result = addNode(node.getLeftChild(),entry);
			else
				node.setLeftChild(new BinaryNode<>(entry));
		}
		else {
			assert compared > 0;
			if(node.hasRightChild())
				result=addNode(node.getRightChild(),entry);
			else
				node.setRightChild(new BinaryNode<>(entry));
		}
		return result;
	}
	private T search(BinaryNode<T> rootNode,T entry) {
		T result = null;
		if(rootNode!=null) {
			T rootData=rootNode.getData();
			if(entry.equals(rootData))
				result=rootData;
			else if(entry.compareTo(rootData)<0)
				result = search(rootNode.getLeftChild(),entry);
			else
				result = search(rootNode.getRightChild(),entry);
		}
		return result;
	}

	@Override
	public boolean contains(T entry) {
		return getEntry(entry)!=null;
	}

	@Override
	public boolean isEmpty() {
		return root==null;
	}

	@Override
	public void clear() {
		root=null;
	}

	@Override
	public void inorderTraverse() {
		inorderTraverse(root);
	}
	private void inorderTraverse(BinaryNode<T> node) {
		if(node!=null) {
			inorderTraverse(node.getLeftChild());
			System.out.println(node.getData());
			inorderTraverse(node.getRightChild());
		}
	}
	
	public T findKthSmallest(int k, BinaryNode<T> rootNode) {
		if (k==1) {
			return rootNode.getData();
		}
		if (rootNode.hasLeftChild()) {
			findKthSmallest(k, rootNode.getLeftChild());
		}
		findKthSmallest(k-1, rootNode);
		if (rootNode.hasRightChild()) {
			findKthSmallest(k-2, rootNode.getRightChild());
		}
		return null;
	}
	

}
