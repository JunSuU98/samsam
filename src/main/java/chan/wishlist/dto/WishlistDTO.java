package chan.wishlist.dto;

import java.util.Date;

public class WishlistDTO {
private int wishlist_number;
private String product_title;
private int product_number;
private int member_number;
private Date wishlist_create;
public int getWishlist_number() {
	return wishlist_number;
}
public void setWishlist_number(int wishlist_number) {
	this.wishlist_number = wishlist_number;
}
public String getProduct_title() {
	return product_title;
}
public void setProduct_title(String product_title) {
	this.product_title = product_title;
}
public int getProduct_number() {
	return product_number;
}
public void setProduct_number(int product_number) {
	this.product_number = product_number;
}
public int getMember_number() {
	return member_number;
}
public void setMember_number(int member_number) {
	this.member_number = member_number;
}
public Date getWishlist_create() {
	return wishlist_create;
}
public void setWishlist_create(Date wishlist_create) {
	this.wishlist_create = wishlist_create;
}
@Override
public String toString() {
	return "WishlistDTO [wishlist_number=" + wishlist_number + ", product_title=" + product_title + ", product_number="
			+ product_number + ", member_number=" + member_number + "]";
}
}