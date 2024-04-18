package kdb.product.dto;

public class ProductDTO {
	private int product_number;
	private String product_upload;
	private String product_update;
	private String product_title;
	private int product_price;
	private String product_content;
	private String product_status;
	public int getProduct_number() {
		return product_number;
	}
	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}
	public String getProduct_upload() {
		return product_upload;
	}
	public void setProduct_upload(String product_upload) {
		this.product_upload = product_upload;
	}
	public String getProduct_update() {
		return product_update;
	}
	public void setProduct_update(String product_update) {
		this.product_update = product_update;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_content() {
		return product_content;
	}
	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}
	public String getProduct_status() {
		return product_status;
	}
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}
	@Override
	public String toString() {
		return "ProductDTO [product_number=" + product_number + ", product_upload=" + product_upload
				+ ", product_update=" + product_update + ", product_title=" + product_title + ", product_price="
				+ product_price + ", product_content=" + product_content + ", product_status=" + product_status + "]";
	}
}
