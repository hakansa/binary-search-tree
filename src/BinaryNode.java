
public class BinaryNode<T> {
	
	private T data;
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;
	
	public BinaryNode() {
		this(null);
	}
	
	public BinaryNode(T data) {
		this(data,null,null);
	}
	public BinaryNode(T data,BinaryNode<T> leftChild,BinaryNode<T> rightChild) {
		this.data=data;
		this.leftChild=leftChild;
		this.rightChild=rightChild;
	}
	public boolean hasLeftChild() {
		return leftChild!=null;
	}
	public boolean hasRightChild() {
		return rightChild!=null;
	}
	public boolean isLeaf() {
		return leftChild==null & rightChild==null;
	}
	public BinaryNode<T> copy() {
		BinaryNode<T> copied= new BinaryNode<>(data);
		if(leftChild!=null) {
			copied.setLeftChild(leftChild.copy());
		}
		if(rightChild!=null) {
			copied.setRightChild(rightChild.copy());
		}
		return copied;
	}
	public int getHeight() {
		return getHeight(this);
	}
	public int getHeight(BinaryNode<T> node) {
		int height=0;
		if(node!=null) {
			height=1+Math.max(getHeight(node.leftChild),getHeight(node.rightChild));
		}
		return height;
	}
	public int getNumberOfNodes() {
		int leftNodes=0;
		int rightNodes=0;
		if(rightChild!=null)
			rightNodes=rightChild.getNumberOfNodes();
		if(leftChild!=null) 
			leftNodes=leftChild.getNumberOfNodes();
		return 1+rightNodes+leftNodes;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryNode<T> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryNode<T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	public String toString() {
		return data.toString();
	}
	
}
