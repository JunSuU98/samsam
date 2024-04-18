package hong.cs.dto;

public class CSDTO {
	private int cs_number;
	private String cs_title;
	private String cs_date;
	private String cs_content;

	public int getCs_number() {
		return cs_number;
	}

	public void setCs_number(int cs_number) {
		this.cs_number = cs_number;
	}

	public String getCs_title() {
		return cs_title;
	}

	public void setCs_title(String cs_title) {
		this.cs_title = cs_title;
	}

	public String getCs_date() {
		return cs_date;
	}

	public void setCs_date(String cs_date) {
		this.cs_date = cs_date;
	}

	public String getCs_content() {
		return cs_content;
	}

	public void setCs_content(String cs_content) {
		this.cs_content = cs_content;
	}

	@Override
	public String toString() {
		return "CSDTO [cs_number=" + cs_number + ", cs_title=" + cs_title + ", cs_date=" + cs_date + ", cs_content="
				+ cs_content + "]";
	}
}