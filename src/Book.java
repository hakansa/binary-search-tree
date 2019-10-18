
public class Book implements IMedia {
	private String mediaName;
	private int mediaPrice;
	private int mediaYear;
	private String mediaType;
	private String authorName;
	
	public Book(String mediaName,int mediaPrice,int mediaYear,String authorName) {
		this.mediaName=mediaName;
		this.mediaPrice=mediaPrice;
		this.mediaYear=mediaYear;
		this.mediaType="Book";
		this.authorName=authorName;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public void setMediaPrice(int mediaPrice) {
		this.mediaPrice = mediaPrice;
	}

	public void setMediaYear(int mediaYear) {
		this.mediaYear = mediaYear;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String mediaName() {
		// TODO Auto-generated method stub
		return mediaName;
	}

	@Override
	public String mediaType() {
		// TODO Auto-generated method stub
		return mediaType;
	}

	@Override
	public int mediaPrice() {
		// TODO Auto-generated method stub
		return mediaPrice;
	}

	@Override
	public int mediaYear() {
		// TODO Auto-generated method stub
		return mediaYear;
	}
	public String authorName() {
		return authorName;
	}

	@Override
	public int compareTo(IMedia media) {
		if(this.mediaPrice()==media.mediaPrice())
			return 0;
		else if(this.mediaPrice()>media.mediaPrice())
			return 1;
		else
			return -1;
	}
	public String toString() {
		return mediaType+","+mediaName+","+mediaPrice+","+mediaYear+","+authorName;
	}
	@Override
	public String getAuthorOrDirector() {
		// TODO Auto-generated method stub
		return authorName;
	}

}
