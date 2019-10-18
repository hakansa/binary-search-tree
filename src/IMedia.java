
public interface IMedia extends Comparable<IMedia> {
	public String mediaName();
	public String mediaType();
	public int mediaPrice();
	public int mediaYear();
	public String getAuthorOrDirector();
	public int compareTo(IMedia media);
}
