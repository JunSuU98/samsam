package wook.info.dao;

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


import wook.info.dao.InfoDAO;
import wook.info.dto.InfoDTO;
import wook.info.survice.InfoService;

public class InfoDAO implements InfoService{
	
	private static Log log = LogFactory.getLog(InfoDAO.class);
	
@Override
public ArrayList<InfoDTO> infoSelect() {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	ArrayList<InfoDTO> arrayList= new ArrayList<InfoDTO>();
	try {
		Context context = new InitialContext( );
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
		connection = dataSource.getConnection( );
	
		String sql = "select info_Number, info_Title, info_Date from INFO ORDER BY info_Number DESC ";
	
		log.info("SQL 확인 - " + sql);
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery( );
		while(resultSet.next( )) {
			InfoDTO infoDTO = new InfoDTO();
			infoDTO.setInfo_Number(resultSet.getInt("info_Number"));
			infoDTO.setInfo_Title(resultSet.getString("info_Title"));
			infoDTO.setInfo_Date(resultSet.getString("info_Date"));
			arrayList.add(infoDTO);

		}

	} catch(Exception e) {
		log.info("공지 목록보기 실패 - " + e);
	} finally {
		try {
			resultSet.close( );
			preparedStatement.close( );
			connection.close( );
		} catch(SQLException e) {
			e.printStackTrace( );
		}
	}
	return arrayList;

	
}

@Override
	public InfoDTO infoInsert(InfoDTO infoDTO) {
	Connection connection = null; 
	PreparedStatement preparedStatement = null; 
	try { 
	Context context = new InitialContext( ); 
	DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc"); 
	connection = dataSource.getConnection( ); 
	connection.setAutoCommit(false); // 자동 커밋 모드 비활성화
		
	String sql = "insert into INFO (info_Number , info_Title, info_Content ,info_Date) "; 
	sql += " values (INFO_SEQUENCE.nextval ,? , ? , ? ) "; 
	log.info("SQL 확인 - " + sql); 
	preparedStatement = connection.prepareStatement(sql); 
	preparedStatement.setString(1,infoDTO.getInfo_Title() ); 
	preparedStatement.setString(2,infoDTO.getInfo_Content() );
	preparedStatement.setString(3,infoDTO.getInfo_Date());
	int count = preparedStatement.executeUpdate( );
	if(count > 0) {
		
		
	connection.commit( );
	log.info("커밋되었습니다.");
	} else {
	connection.rollback( );
	log.info("롤백되었습니다.");
	}
	}
	

	 catch(Exception e) { 
		 log.info("부서 입력 실패 - " + e); 
	} finally { 
	try { 
		preparedStatement.close( ); 
		connection.close( ); 
	} catch(SQLException e) { 
		e.printStackTrace( ); 
	} 
	} 
	return infoDTO; 
	}
@Override
	public InfoDTO infoUpdate(InfoDTO infoDTO) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	try {
		Context context = new InitialContext( );
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
		connection = dataSource.getConnection( );
		connection.setAutoCommit(false); // 자동 커밋 모드 비활성화
		String sql = "update INFO set info_Title = ?, info_Content = ? , info_Date = ? ";
		sql += " where info_Number = ?";
		log.info("SQL 확인 - " + sql);
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, infoDTO.getInfo_Title());
		preparedStatement.setString(2, infoDTO.getInfo_Content());
		preparedStatement.setString(3, infoDTO.getInfo_Date());
		preparedStatement.setInt(4, infoDTO.getInfo_Number());
		// SQL인 update…set…where 문을 실행하고 데이터를 수정한다.
		int count = preparedStatement.executeUpdate( );
		if(count > 0) {
		connection.commit( );
		log.info("커밋되었습니다.");
		} else {
		connection.rollback( );
		log.info("롤백되었습니다.");
		}
		} catch(Exception e) {
		log.info("부서 수정 실패 - " + e);
		} finally {
		try {
		preparedStatement.close( );
		connection.close( );
		} catch(SQLException e) {
		e.printStackTrace( );
		}
		}
		return infoDTO;

	}
@Override
	public InfoDTO infoDelete(int info_Number) {
		
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	try {
		Context context = new InitialContext( );
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
		connection = dataSource.getConnection( );
		connection.setAutoCommit(false); // 자동 커밋 모드 비활성화
		String sql = "delete from INFO ";
		sql += " where info_Number = ?";
		log.info("SQL 확인 - " + sql);
		preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, info_Number);
		// SQL인 update…set…where 문을 실행하고 데이터를 수정한다.
		int count = preparedStatement.executeUpdate( );
		if(count > 0) {
		connection.commit( );
		log.info("커밋되었습니다.");
		} else {
		connection.rollback( );
		log.info("롤백되었습니다.");
		}
		} catch(Exception e) {
		log.info("부서 삭 실패 - " + e);
		} finally {
		try {
		preparedStatement.close( );
		connection.close( );
		} catch(SQLException e) {
		e.printStackTrace( );
		}
		}
		return null;

	}
	
	
	

@Override
	public InfoDTO infoSelectDetail(int info_Number) {
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
    InfoDTO infoDTO = new InfoDTO();

	try {
		Context context = new InitialContext( );
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
		connection = dataSource.getConnection( );
		
		String sql = "select info_Number , info_Title , info_Content , info_Date from INFO ";
		sql += " where info_Number= ? ";
		log.info("SQL 확인 - " + sql);
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,info_Number );
		resultSet = preparedStatement.executeQuery( );
		while(resultSet.next( )) {
			infoDTO.setInfo_Number(resultSet.getInt("info_Number"));
			infoDTO.setInfo_Title(resultSet.getString("info_Title"));
			infoDTO.setInfo_Content(resultSet.getString("info_Content"));
			infoDTO.setInfo_Date(resultSet.getString("info_Date"));
			
		}
		
	} catch(Exception e) {
		log.info("공지 내용 보기 실패 - " + e);
	} finally {
		try {
			resultSet.close( );
			preparedStatement.close( );
			connection.close( );
		} catch(SQLException e) {
			e.printStackTrace( );
		}
	}
	return infoDTO;

	}
}
