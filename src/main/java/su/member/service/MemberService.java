package su.member.service;

import java.util.ArrayList;

import su.member.dto.MemberDTO;

public interface MemberService {
	public ArrayList<MemberDTO> memberSelectAll();
	
	public MemberDTO memberSelect(int member_number);
	
	public MemberDTO memberInsert(MemberDTO memberDTO);
	
	public MemberDTO memberUpdate(MemberDTO memberDTO);
	
	public MemberDTO memberDelete(int member_number);
	
	public MemberDTO memberLogin(MemberDTO memberDTO);
	
	public MemberDTO memberSearchId(MemberDTO memberDTO);
	
	public MemberDTO memberSearchPassword(MemberDTO memberDTO);
	
	public int memberIdCheck(String member_id);
}
