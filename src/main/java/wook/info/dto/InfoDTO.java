	package wook.info.dto;



public class InfoDTO {
	  private  int info_Number;
	  private String info_Title;
	  private String info_Date;
	  private String info_Content;
	  private int info_Count;
	  
	  
	  
	public int getInfo_Number() {
		return info_Number;
	}
	public void setInfo_Number(int info_Number) {
		this.info_Number = info_Number;
	}
	public String getInfo_Title() {
		return info_Title;
	}
	public void setInfo_Title(String info_Title) {
		this.info_Title = info_Title;
	}
	public String getInfo_Date() {
		return info_Date;
	}
	public void setInfo_Date(String info_Date) {
		this.info_Date = info_Date;
	}
	public String getInfo_Content() {
		return info_Content;
	}
	public void setInfo_Content(String info_Content) {
		this.info_Content = info_Content;
		
	}
		public int getInfo_Count() {
		return info_Count;
	}
	public void setInfo_Count(int info_Count) {
		this.info_Count = info_Count;
	}
	
	
	@Override
	public String toString() {
		return "InfoDTO [info_Number=" + info_Number + ", info_Title=" + info_Title + ", info_Date=" + info_Date
				+ ", info_Content=" + info_Content + ", info_Count=" + info_Count + "]";
	}
		
	  
	
	}
	  
	  

