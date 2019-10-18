import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




public class FileIO {
	public BinarySearchTreeInterface<IMedia> ReadInventory(){
		BufferedReader reader;
		
		BinarySearchTreeInterface<IMedia> binarySearchTree = new BinarySearchTree<>();
		
		try {
			reader = new BufferedReader(new FileReader(
					"src/CENG112_HW4_Media.txt"));
			
			String line = reader.readLine();
			
			while (line != null && line.length()>1) {
				
				IMedia newMedia= null;
				String[] mediaArr=line.split(",");
				String mediaName= mediaArr[1];
				int mediaPrice = Integer.parseInt(mediaArr[2]);
				
				int mediaYear = Integer.parseInt(mediaArr[3]);
				if (mediaArr[0].equals("Book")) {
					
					String authorName=mediaArr[4];
					
					newMedia = new Book(mediaName,mediaPrice,mediaYear,authorName);
				}else {
					String directorName = mediaArr[4];
					String actressName= mediaArr[5];
					String actorName=mediaArr[6];
					
					newMedia = new Movie(mediaName,mediaPrice,mediaYear,directorName,actressName,actorName);
				}
				
				binarySearchTree.add(newMedia);
				
				
				
				// read next line
				line = reader.readLine();
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return binarySearchTree;
		
	}
	
}
