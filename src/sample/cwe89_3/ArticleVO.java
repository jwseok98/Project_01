package sample.cwe89_3;

public class ArticleVO {
	
	private int id;
	
	private String title;
	
	private String content;
	
	private long writeTime;
	
	private String writeUser;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getWriteTime() {
		return writeTime;
	}

	public void setWriteTime(long writeTime) {
		this.writeTime = writeTime;
	}

	public String getWriteUser() {
		return writeUser;
	}

	public void setWriteUser(String writeUser) {
		this.writeUser = writeUser;
	}

	@Override
	public String toString() {
		return "ArticleVO [id=" + id + ", title=" + title + ", content=" + content + ", writeTime=" + writeTime
				+ ", writeUser=" + writeUser + "]";
	}
}
