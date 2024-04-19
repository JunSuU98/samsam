package ji.img.dto;

public class ImgDTO {
	private int img_number;
	private String img_upload;
	private String img_update;
	private String img_url;
	
	public int getImg_number() {
		return img_number;
	}
	public void setImg_number(int img_number) {
		this.img_number = img_number;
	}
	public String getImg_upload() {
		return img_upload;
	}
	public void setImg_upload(String img_upload) {
		this.img_upload = img_upload;
	}
	public String getImg_update() {
		return img_update;
	}
	public void setImg_update(String img_update) {
		this.img_update = img_update;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
	@Override
	public String toString() {
		return "ImgDTO [img_number=" + img_number + ", img_upload=" + img_upload + ", img_update=" + img_update
				+ ", img_url=" + img_url + "]";
	}
	
}
