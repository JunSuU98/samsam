package ji.img.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ji.img.dto.ImgDTO;
import ji.img.service.ImgService;

public class ImgDAO implements ImgService{
	private static Log log = LogFactory.getLog(ImgDAO.class);

	@Override
	public ArrayList<ImgDTO> imgSelectAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		ArrayList<ImgDTO> arrayList = new ArrayList<ImgDTO>();
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select img_number, img_upload, img_update, img_url from img";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				ImgDTO imgDTO = new ImgDTO();
				imgDTO.setImg_number(resultSet.getInt("img_number"));
				imgDTO.setImg_upload(resultSet.getString("img_upload").substring(0, 10));
				imgDTO.setImg_update(resultSet.getString("img_update").substring(0, 10));
				imgDTO.setImg_url(resultSet.getString("img_url"));
				System.out.println(imgDTO);
				arrayList.add(imgDTO);
			}
			
			resultSet.getRow();
			if (resultSet.getRow() == 0) {
				log.info("등록한 이미지가 없습니다. 이미지를 등록해주세요.");
			}
		} catch (Exception e) {
			log.info("전체 이미지 조회 실패 - " + e);
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
	public ImgDTO imgSelect(int img_number) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		ImgDTO imgDTO = new ImgDTO();
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select img_number, img_upload, img_update, img_url from img ";
			sql += "where img_number = ?";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, img_number);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				imgDTO.setImg_number(resultSet.getInt("img_number"));
				imgDTO.setImg_upload(resultSet.getString("img_upload").substring(0, 10));
				imgDTO.setImg_update(resultSet.getString("img_update").substring(0, 10));
				imgDTO.setImg_url(resultSet.getString("img_url"));
				System.out.println("result img_url - " + imgDTO.getImg_url());
			}
		} catch (Exception e) {
			log.info("특정 이미지 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return imgDTO;
	}

	@Override
	public ImgDTO imgInsert(ImgDTO imgDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "insert into img (img_number, img_upload, img_update, img_url ) ";
			sql += " values (img_seq.NEXTVAL, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'), ? ) ";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setInt(1, imgDTO.getImg_number());
			preparedStatement.setString(1, imgDTO.getImg_upload());
			preparedStatement.setString(2, imgDTO.getImg_update());
			preparedStatement.setString(3, imgDTO.getImg_url());
			
			int count = preparedStatement.executeUpdate();
			
			if (count > 0) {
//				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("이미지 업로드 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return imgDTO;
	}

	@Override
	public ImgDTO imgUpdate(ImgDTO imgDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "update img set img_update = ?, img_url = ? ";
			sql += " where img_number = ?";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, imgDTO.getImg_update());
			preparedStatement.setString(2, imgDTO.getImg_url());
			preparedStatement.setInt(3, imgDTO.getImg_number());
			
			int count = preparedStatement.executeUpdate();
			
			if (count > 0) {
//				connection.commit();
				log.info("커밋되었습니다.");
			} else {
//				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("이미지 수정 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return imgDTO;
	}

	@Override
	public ImgDTO imgDelete(int img_number) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "delete from img";
			sql += " where img_number = ?";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, img_number);
			
			int count = preparedStatement.executeUpdate();
			
			if (count > 0) {
//				connection.commit();
				log.info("커밋되었습니다.");
			} else {
//				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("이미지 삭제 실패 - " + e);
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
	
	
}
