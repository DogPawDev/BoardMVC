package foodev.spring.board;

public class BoardVO {

	private String division;
	private int post_id;
	private String title;
	private String writer;
	private String date;
	private int up_count;
	private int lookup_count;
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUp_count() {
		return up_count;
	}
	public void setUp_count(int up_count) {
		this.up_count = up_count;
	}
	public int getLookup_count() {
		return lookup_count;
	}
	public void setLookup_count(int lookup_count) {
		this.lookup_count = lookup_count;
	}
	@Override
	public String toString() {
		return "BoardVO [division=" + division + ", post_id=" + post_id + ", title=" + title + ", writer=" + writer
				+ ", date=" + date + ", up_count=" + up_count + ", lookup_count=" + lookup_count + "]";
	}
	

	
	
}
