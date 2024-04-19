package chan.wishlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chan.wishlist.dto.WishlistDTO;
import chan.wishlist.service.WishlistService;
@SuppressWarnings("finally")
public class WishlistDAO implements WishlistService{
private static final Log log = LogFactory.getLog(WishlistDAO.class);
@Override
public ArrayList<WishlistDTO> wishlistSelectAll(){
	ArrayList<WishlistDTO> arrayList = new ArrayList<WishlistDTO>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	try {
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
		connection = dataSource.getConnection();
		String sql = "select wishlist_number, product_title, product_number, member_number, wishlist_create from wishlist";
		log.info("SQL - " + sql);
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			WishlistDTO wishlistDTO = new WishlistDTO();
			wishlistDTO.setWishlist_number(resultSet.getInt("wishlist_number"));
			wishlistDTO.setProduct_title(resultSet.getString("product_title"));
			wishlistDTO.setProduct_number(resultSet.getInt("product_number"));
			wishlistDTO.setMember_number(resultSet.getInt("member_number"));
			wishlistDTO.setWishlist_create(resultSet.getDate("wishlist_create"));
			arrayList.add(wishlistDTO);
			log.info("조회 데이터를 확인한다 - " +wishlistDTO);
		}
	if (resultSet.getRow() == 0) {
		log.info("찜 목록이 존재하지 않습니다.");
	}	
	} catch (Exception e) {
	log.info("전체 찜 목록 조회 실패 - " +e);
	}finally {
	try {
		resultSet.close();
		preparedStatement.close();
		connection.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	return arrayList;
	}

@Override
public WishlistDTO wishlistSelect(WishlistDTO wishlistDTO) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	try {
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
		connection = dataSource.getConnection();
		String sql = "select wishlist_number, product_title, product_number, member_number, wishlist_create from wishlist";
		sql+= " where member_number = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, wishlistDTO.getMember_number());
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			log.info("회원 고유 번호 확인 -" +resultSet.getInt("member_number"));
			wishlistDTO.setWishlist_number(resultSet.getInt("wishlist_number"));
			wishlistDTO.setProduct_title(resultSet.getString("product_title"));
			wishlistDTO.setProduct_number(resultSet.getInt("product_num"));
			wishlistDTO.setMember_number(resultSet.getInt("member_number"));
			wishlistDTO.setWishlist_create(resultSet.getDate("wishlist_create"));
		}
	} catch (Exception e) {
		log.info("찜 목록 상세 조회 실패 - " +e);
		e.printStackTrace();
	}finally {
		try {
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wishlistDTO;
	}
}
	@Override
	public WishlistDTO wishlistDelete(WishlistDTO wishlistDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			String sql = "delete from wishlist";
			sql += " where wishlist_number = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, wishlistDTO.getWishlist_number());
			int count = preparedStatement.executeUpdate();
			if (count>0) {
				connection.commit();
				log.info("커밋되었습니다.");
			}else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
	        try {
	            if (connection != null) {
	                connection.rollback();
	            }
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            if (connection != null) {
	                connection.setAutoCommit(true); // 자동 커밋 활성화
	                connection.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return wishlistDTO;
	}
	
	 @Override
	    public WishlistDTO wishlistInsert(WishlistDTO wishlistDTO) {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        try {
	            Context context = new InitialContext();
	            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
	            connection = dataSource.getConnection();
	            connection.setAutoCommit(false);
	            String Sql1 = "SELECT wishlist_seq.NEXTVAL FROM DUAL";
	            preparedStatement = connection.prepareStatement(Sql1);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                wishlistDTO.setWishlist_number(resultSet.getInt(1));
	            }
	            
	            // 현재 날짜를 가져와서 wishlist_create에 저장 (DATE 형식)
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            java.util.Date now = new java.util.Date();
	            wishlistDTO.setWishlist_create(now);
	            
	            String sql2 = "INSERT INTO wishlist(wishlist_number, product_title, product_number, member_number, wishlist_create) ";
	            sql2 += "VALUES (?, ?, ?, ?, ?)";
	            
	            preparedStatement = connection.prepareStatement(sql2);
	            preparedStatement.setInt(1, wishlistDTO.getWishlist_number());
	            preparedStatement.setString(2, wishlistDTO.getProduct_title());
	            preparedStatement.setInt(3, wishlistDTO.getProduct_number());
	            preparedStatement.setInt(4, wishlistDTO.getMember_number());
	            preparedStatement.setDate(5, new java.sql.Date(wishlistDTO.getWishlist_create().getTime()));
	            
	            int count = preparedStatement.executeUpdate();
	            if (count > 0) {
	                connection.commit();
	                log.info("커밋되었습니다");
	            } else {
	                connection.rollback();
	                log.info("롤백되었습니다");
	            }
	        } catch (Exception e) {
	            try {
	                if (connection != null) {
	                    connection.rollback();
	                }
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	            e.printStackTrace();
	        } finally {
	            try {
	                if (connection != null) {
	                    connection.setAutoCommit(true); // 자동 커밋 활성화
	                    connection.close();
	                }
	                if (preparedStatement != null) {
	                    preparedStatement.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return wishlistDTO;
	    }
	 @Override
	 public WishlistDTO wishlistDeleteAll(WishlistDTO wishlistDTO) {
		 Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 try {
		 Context context = new InitialContext();
		 DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
		 connection = dataSource.getConnection();
		 connection.setAutoCommit(false);
		 String sql = "delete from wishlist";
		 log.info("SQL - " +sql);
		 preparedStatement = connection.prepareStatement(sql);
		 int count = preparedStatement.executeUpdate();
		 if (count>0) {
				connection.commit();
				log.info("커밋되었습니다.");
			}else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
	        try {
	            if (connection != null) {
	                connection.rollback();
	            }
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            if (connection != null) {
	                connection.setAutoCommit(true); // 자동 커밋 활성화
	                connection.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return wishlistDTO;
}
}