package at.woodstick.lighter.entities;

public class UserStory {

	private long id;
	private String title;
	
	public UserStory(long id, String title) {
		this.id = id;
		this.title = title;
	}

	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
}
