package su.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import su.member.dto.MemberDTO;
import su.member.service.MemberService;

public class MemberDAO implements MemberService {
	
	private static Log log = LogFactory.getLog(MemberDAO.class);

	@Override
	public ArrayList<MemberDTO> memberSelectAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();		
			
			String sql = "select * from member";
			log.info("전체 조회 SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);		
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setMember_number(resultSet.getInt("member_number"));
				memberDTO.setMember_create(resultSet.getString("member_create").substring(0, 10));
				memberDTO.setMember_update(resultSet.getString("member_update").substring(0, 10));
				memberDTO.setMember_status(resultSet.getString("member_status"));
				memberDTO.setMember_id(resultSet.getString("member_id"));
				memberDTO.setMember_password(resultSet.getString("member_password"));
				memberDTO.setMember_name(resultSet.getString("member_name"));
				memberDTO.setMember_birth(resultSet.getString("member_birth").substring(0, 10));
				memberDTO.setMember_email(resultSet.getString("member_email"));
				memberDTO.setMember_phone(resultSet.getString("member_phone"));
				memberDTO.setMember_rate(resultSet.getInt("member_rate"));
				memberDTO.setMember_address(resultSet.getString("member_address"));
				
				arrayList.add(memberDTO);
			}
			
			resultSet.getRow();

			if(resultSet.getRow() == 0) {
				log.info("등록한 회원이 없습니다. 회원을 등록해주세요");
			}
			
		} catch (Exception e) {
			log.info("전체 회원 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrayList;
	}

	@Override
	public MemberDTO memberSelect(int member_number) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		MemberDTO memberDTO = new MemberDTO();

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			
			String sql = "select * from member";
			sql += " where member_number = ? ";
			log.info("상세조회 SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, member_number);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				memberDTO.setMember_number(resultSet.getInt("member_number"));
				memberDTO.setMember_create(resultSet.getString("member_create").substring(0, 10));
				memberDTO.setMember_update(resultSet.getString("member_update").substring(0, 10));
				memberDTO.setMember_status(resultSet.getString("member_status"));
				memberDTO.setMember_id(resultSet.getString("member_id"));
				memberDTO.setMember_password(resultSet.getString("member_password"));
				memberDTO.setMember_name(resultSet.getString("member_name"));
				memberDTO.setMember_birth(resultSet.getString("member_birth").substring(0, 10));
				memberDTO.setMember_email(resultSet.getString("member_email"));
				memberDTO.setMember_phone(resultSet.getString("member_phone"));
				memberDTO.setMember_rate(resultSet.getInt("member_rate"));
				memberDTO.setMember_address(resultSet.getString("member_address"));
			}
			
		} catch (Exception e) {
			log.info("회원 상세 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return memberDTO;
	}

	@Override
	public MemberDTO memberInsert(MemberDTO memberDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);

			String sql = "insert into member (member_number, member_status, member_rate, member_id, member_password, member_name, member_email, member_phone, member_address, member_birth, member_create, member_update) ";
			sql += " values (number_seq.NEXTVAL, 'active', 0, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD') ) ";

			log.info("가입 SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, memberDTO.getMember_id());
			preparedStatement.setString(2, memberDTO.getMember_password());
			preparedStatement.setString(3, memberDTO.getMember_name());
			preparedStatement.setString(4, memberDTO.getMember_email());
			preparedStatement.setString(5, memberDTO.getMember_phone());
			preparedStatement.setString(6, memberDTO.getMember_address());
			preparedStatement.setString(7, memberDTO.getMember_birth());
			preparedStatement.setString(8, memberDTO.getMember_create());
			preparedStatement.setString(9, memberDTO.getMember_create());
			
			int count = preparedStatement.executeUpdate();
			
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
			
		} catch (Exception e) {
			log.info("회원 가입 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public MemberDTO memberUpdate(MemberDTO memberDTO) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);

			String sql = "update member set member_id = ?, member_password = ?, member_name = ?, member_email = ?, ";
			sql += "member_phone = ?, member_address = ?, member_birth = TO_DATE(?, 'YYYY-MM-DD'), member_update = TO_DATE(?, 'YYYY-MM-DD') ";
			sql += "where member_number = ? ";
			log.info("update SQl 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, memberDTO.getMember_id());
			preparedStatement.setString(2, memberDTO.getMember_password());
			preparedStatement.setString(3, memberDTO.getMember_name());
			preparedStatement.setString(4, memberDTO.getMember_email());
			preparedStatement.setString(5, memberDTO.getMember_phone());
			preparedStatement.setString(6, memberDTO.getMember_address());
			preparedStatement.setString(7, memberDTO.getMember_birth());
			preparedStatement.setString(8, memberDTO.getMember_update());
			preparedStatement.setInt(9, memberDTO.getMember_number());
			
			int count = preparedStatement.executeUpdate();
			
			if(count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("회원 정보 수정 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

		return memberDTO;
	}

	@Override
	public MemberDTO memberDelete(int member_number) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			String sql = "delete from member ";
			sql += " where member_number = ?";
			log.info("delete SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, member_number);
			
			int count = preparedStatement.executeUpdate();
			
			if(count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
			
		} catch (Exception e) {
			log.info("회원 삭제 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select * from member ";
			sql += "where member_id = ? ";
			log.info("login SQL 확인 - " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getMember_id());
			
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				memberDTO.setMember_number(resultSet.getInt("member_number"));
				memberDTO.setMember_name(resultSet.getString("member_name"));
				memberDTO.setMember_id(resultSet.getString("member_id"));
				log.info("회원 아이디 확인 - " + resultSet.getString("member_id"));
				
				if(resultSet.getString("member_password").equals(memberDTO.getMember_password())) {
					memberDTO.setMember_password(resultSet.getString("member_password"));
					log.info("회원 비밀번호 확인 - " + resultSet.getString("member_password"));
				} else {
					memberDTO.setMember_password("");
				} 
			} else {
				memberDTO.setMember_id("");
			}
			
			
		} catch (Exception e) {
			log.info("로그인 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberDTO;
	}

	@Override
	public MemberDTO memberSearchId(MemberDTO memberDTO) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select member_id from member ";
			sql += "where member_name = ? and member_birth = ? and member_phone = ? ";
			
			log.info("id search SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, memberDTO.getMember_name());
			preparedStatement.setString(2, memberDTO.getMember_birth());
			preparedStatement.setString(3, memberDTO.getMember_phone());
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				memberDTO.setMember_id(resultSet.getString("member_id"));
				
				log.info("조회 아이디 확인 - " + memberDTO.getMember_id());
			}
		} catch (Exception e) {
			log.info("아이디 찾기 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberDTO;
	}

	@Override
	public MemberDTO memberSearchPassword(MemberDTO memberDTO) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select * from member ";
			sql += "where member_id = ? and member_name = ? and member_birth = TO_DATE(?, 'YYYY-MM-DD') and member_phone = ? ";
			log.info("비밀번호 찾기 SQL 확인 - " + sql); 
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getMember_id());
			preparedStatement.setString(2, memberDTO.getMember_name());
			preparedStatement.setString(3, memberDTO.getMember_birth());
			preparedStatement.setString(4, memberDTO.getMember_phone());
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				memberDTO.setMember_number(resultSet.getInt("member_number"));
				memberDTO.setMember_id(resultSet.getString("member_id"));
				memberDTO.setMember_password(resultSet.getString("member_password"));
			}
			
			
		} catch (Exception e) {
			log.info("비밀번호 찾기 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return memberDTO;
	}

	@Override
	public int memberIdCheck(String member_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		int idCheck = 0;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select * from member ";
			sql += "where member_id = ? ";
			log.info("아이디 중복확인 SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member_id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next() || member_id.equals("")) {
				idCheck = 1;
			} else {
				idCheck = 0;
			}
			
		} catch (Exception e) {
			log.info("회원 아이디 체크 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return idCheck;
	}

}
