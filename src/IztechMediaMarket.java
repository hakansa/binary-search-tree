import java.util.Scanner;


public class IztechMediaMarket {
	private static int recursiveCount =0;
	public static void main(String[] args) {
		FileIO fileIO = new FileIO();
		
		BinarySearchTreeInterface<IMedia> binarySearchTree =fileIO.ReadInventory();
		BinaryNode<IMedia> rootNode = binarySearchTree.getRoot();
		System.out.println("1)Print the minimum priced book with specified Author Name.");
		System.out.println("2)Print the maximum priced book with specified Author Name.");
		System.out.println("3)Print the minimum priced movie with specified Director Name.");
		System.out.println("4)Print the maximum priced movie with specified Director Name.");
		System.out.println("5)Print all media whose prices are less or equal than the amount taken from console.");
		System.out.println("6)Print all media whose prices are greater than the amount taken from console.");
		System.out.println("7)Print all media in descending order in terms of the price.");
		System.out.println("8)Print all media in ascending order in terms of the price.");
		System.out.println("9)Print all books in descending order in terms of the price.");
		System.out.println("10)Print all books in ascending order in terms of the price.");
		System.out.println("11)Print all movies in descending order in terms of the price.");
		System.out.println("12)Print all movies in ascending order in terms of the price.");
		
		
		while(true) {	
			Scanner scanner =new Scanner(System.in);
			System.out.println("Option: ");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1: 
				System.out.println("Enter an author name: ");
				Scanner authorNameMinScanner =new Scanner(System.in);
				String authorNameMin = authorNameMinScanner.nextLine();
				displayMinMedia(rootNode,authorNameMin);
				recursiveCount=0;
				break;
			case 2:
				System.out.println("Enter an author name: ");
				Scanner authorNameMaxScanner =new Scanner(System.in);
				String authorNameMax = authorNameMaxScanner.nextLine();
				displayMaxMedia(rootNode,authorNameMax);
				recursiveCount=0;
				break;
			case 3:
				System.out.println("Enter an director name: ");
				Scanner directorNameMinScanner =new Scanner(System.in);
				String directorNameMin = directorNameMinScanner.nextLine();
				displayMinMedia(rootNode,directorNameMin);
				recursiveCount=0;
				break;
			case 4:
				System.out.println("Enter an director name: ");
				Scanner directorNameMaxScanner =new Scanner(System.in);
				String directorNameMax = directorNameMaxScanner.nextLine();
				displayMaxMedia(rootNode,directorNameMax);
				recursiveCount=0;
				break;
			case 5:
				Scanner scannerPrice =new Scanner(System.in);
				System.out.println("Enter a price: ");
				int price=scannerPrice.nextInt();
				displayLessOrEqual(rootNode, price);
				break;
			case 6:
				Scanner scannerMaxPrice =new Scanner(System.in);
				System.out.println("Enter a price: ");
				int maxPrice=scannerMaxPrice.nextInt();
				displayGreater(rootNode, maxPrice);
				break;
			case 7:
				displayDescending(rootNode);
				break;
			case 8:
				displayAscending(rootNode);
				break;
			case 9:
				displayDescendingBooks(rootNode);
				break;
			case 10:
				displayAscendingBooks(rootNode);
				break;
			case 11:
				displayDescendingMovies(rootNode);
				break;
			case 12:
				displayAscendingMovies(rootNode);
				break;
			case 13:
				System.out.println(binarySearchTree.findKthSmallest(4,rootNode));
				break;
			}
			
			if(choice==0) {
				System.out.println("Terminated.");
				break;
			}
		
		}
		
	}
	public static void displayMinMedia(BinaryNode<IMedia> node, String authorName) {
		if(node!=null&recursiveCount==0) {
			displayMinMedia(node.getLeftChild(),authorName);
			if (node.getData().getAuthorOrDirector().equals(authorName)){
				recursiveCount=1;
				System.out.println(node.getData());
			}else {
				displayMinMedia(node.getRightChild(), authorName);

			}
		}
	}
	
	
	public static void displayMaxMedia(BinaryNode<IMedia> node, String authorName) {
		if(node!=null) {
			displayMaxMedia(node.getRightChild(),authorName);
			if(recursiveCount==0) {
				if (node.getData().getAuthorOrDirector().equals(authorName)){
					recursiveCount=1;
					System.out.println(node.getData());
					
			}
				else {
					displayMaxMedia(node.getLeftChild(), authorName);

				}
			}
		}
	}
	public static void displayLessOrEqual(BinaryNode<IMedia> node,int price) {
		if(node!=null) {
			displayLessOrEqual(node.getLeftChild(), price);
			if (node.getData().mediaPrice()<=price) {
				System.out.println(node.getData());

			}
			displayLessOrEqual(node.getRightChild(), price);
		}
	}
	public static void displayGreater(BinaryNode<IMedia> node,int price) {
		if(node!=null) {
			displayGreater(node.getLeftChild(), price);
			if (node.getData().mediaPrice()>price) {
				System.out.println(node.getData());

			}
			displayGreater(node.getRightChild(), price);
		}
	}
	public static void displayDescending(BinaryNode<IMedia> node) {
		if(node!=null) {
			displayDescending(node.getRightChild());
			System.out.println(node.getData());
			displayDescending(node.getLeftChild());
			
		}
	}
	public static void displayAscending(BinaryNode<IMedia> node) {
		if(node!=null) {
			displayAscending(node.getLeftChild());
			System.out.println(node.getData());
			displayAscending(node.getRightChild());

		}
	}
	public static void displayDescendingBooks(BinaryNode<IMedia> node) {
		if(node!=null) {
			displayDescendingBooks(node.getLeftChild());
			if(node.getData().mediaType()=="Book")
				System.out.println(node.getData());
			displayDescendingBooks(node.getRightChild());
			
		}
	}
	public static void displayAscendingBooks(BinaryNode<IMedia> node) {
		if(node!=null) {
			displayAscendingBooks(node.getRightChild());
			if(node.getData().mediaType()=="Book")
				System.out.println(node.getData());
			displayAscendingBooks(node.getLeftChild());
		}
	}
	public static void displayDescendingMovies(BinaryNode<IMedia> node) {
		if(node!=null) {
			displayDescendingMovies(node.getLeftChild());
			if(node.getData().mediaType()=="Movie")
				System.out.println(node.getData());
			displayDescendingMovies(node.getRightChild());
			
		}
	}
	public static void displayAscendingMovies(BinaryNode<IMedia> node) {
		if(node!=null) {
			displayAscendingMovies(node.getRightChild());
			if(node.getData().mediaType()=="Movie")
				System.out.println(node.getData());
			displayAscendingMovies(node.getLeftChild());
		}
	}
}
