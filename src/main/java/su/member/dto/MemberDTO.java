package su.member.dto;

public class MemberDTO {
	
	int member_number;
	String member_create;
	String member_update;
	String member_status;
	String member_id;
	String member_password;
	String member_name;
	String member_birth;
	String member_email;
	String member_phone;
	int member_rate;
	String member_address;
	
	public int getMember_number() {
		return member_number;
	}
	public void setMember_number(int member_number) {
		this.member_number = member_number;
	}
	public String getMember_create() {
		return member_create;
	}
	public void setMember_create(String member_create) {
		this.member_create = member_create;
	}
	public String getMember_update() {
		return member_update;
	}
	public void setMember_update(String member_update) {
		this.member_update = member_update;
	}
	public String getMember_status() {
		return member_status;
	}
	public void setMember_status(String member_status) {
		this.member_status = member_status;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public int getMember_rate() {
		return member_rate;
	}
	public void setMember_rate(int member_rate) {
		this.member_rate = member_rate;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [member_number=" + member_number + ", member_create=" + member_create + ", member_update="
				+ member_update + ", member_status=" + member_status + ", member_id=" + member_id + ", member_password="
				+ member_password + ", member_name=" + member_name + ", member_birth=" + member_birth
				+ ", member_email=" + member_email + ", member_phone=" + member_phone + ", member_rate=" + member_rate
				+ ", member_address=" + member_address + "]";
	}

}
