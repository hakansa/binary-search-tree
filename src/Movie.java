
public class Movie implements IMedia {
	private String mediaName;
	private int mediaPrice;
	private String mediaType;
	private int mediaYear;
	private String directorName;
	private String actressName;
	private String actorName;
	
	public Movie(String mediaName, int mediaPrice, int mediaYear, String directorName, String actressName, String actorName) {
		this.mediaName=mediaName;
		this.mediaPrice=mediaPrice;
		this.mediaYear=mediaYear;
		this.directorName=directorName;
		this.actressName=actressName;
		this.actorName=actorName;
		mediaType="Movie";
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

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
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

	

	public String getActressName() {
		return actressName;
	}

	public void setActressName(String actressName) {
		this.actressName = actressName;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public void setMediaPrice(int mediaPrice) {
		mediaPrice = mediaPrice;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public void setMediaYear(int mediaYear) {
		this.mediaYear = mediaYear;
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
		return mediaType+","+mediaName+","+mediaPrice+","+mediaYear+","+directorName+","+actressName+","+actorName;
	}
	@Override
	public String getAuthorOrDirector() {
		// TODO Auto-generated method stub
		return directorName;
	}

}
