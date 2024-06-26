package kdb.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import kdb.product.dto.ProductDTO;
import kdb.product.serviec.ProductService;

public class ProductDAO implements ProductService {
	private static Log log = LogFactory.getLog(ProductDAO.class);

	@Override
	public ArrayList<ProductDTO> productSelectAll() {
	Connection connection =null;
	PreparedStatement preparedStatement =null;
	ResultSet resultSet =null;
	ArrayList<ProductDTO>arrayList =new ArrayList<ProductDTO>();
	try {
		Context context = new InitialContext();
		DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
		connection =dataSource.getConnection();
		String sql="select * from PRODUCT";
		log.info("SQL 확인 - " + sql);
		preparedStatement =connection.prepareStatement(sql);
		resultSet =preparedStatement.executeQuery();

		while (resultSet.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct_number(resultSet.getInt("PRODUCT_NUMBER"));
			productDTO.setProduct_upload(resultSet.getString("PRODUCT_UPLOAD"));
			productDTO.setProduct_update(resultSet.getString("PRODUCT_UPDATE"));
			productDTO.setProduct_title(resultSet.getString("PRODUCT_TITLE"));
			productDTO.setProduct_price(resultSet.getInt("PRODUCT_PRICE"));
			productDTO.setProduct_content(resultSet.getString("PRODUCT_CONTENT"));
			productDTO.setProduct_status(resultSet.getString("PRODUCT_STATUS"));
			
			log.info(productDTO);
			
		arrayList.add(productDTO);
			resultSet.getRow();
			if (resultSet.getRow() ==0) {
				log.info("등록한 부서가 없습니다. 부서를 등록해 주세요");
			}
			
		}
	} catch (Exception e) {
		log.info("전체 부서 조회 실패 - " + e);
			}finally {
				try {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
	
		return arrayList;
	}

	@Override
	public ProductDTO productSelect(int product_number) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ProductDTO productDTO = new ProductDTO();
		try {
			Context context=new InitialContext();
			DataSource dataSource=(DataSource)context.lookup("java:comp/env/jdbc");
			connection= dataSource.getConnection();
			
			String sql="select * from PRODUCT ";
			sql+="where product_number=?";
			log.info("SQL확인" +sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, product_number);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				productDTO.setProduct_number(resultSet.getInt("product_number"));
				productDTO.setProduct_upload(resultSet.getString("product_upload"));
				productDTO.setProduct_update(resultSet.getString("product_update"));
				productDTO.setProduct_title(resultSet.getString("product_title"));
				productDTO.setProduct_price(resultSet.getInt("product_price"));
				productDTO.setProduct_content(resultSet.getString("product_content"));
				productDTO.setProduct_status(resultSet.getString("product_status"));
				productDTO.setImg_index(resultSet.getInt("img_index"));
				productDTO.setMember_number(resultSet.getInt("member_number"));
			}
		} catch (Exception e) {
			log.info("특정 부서 조회 실패 - " + e);
		}finally {
			try {
				resultSet.close( );
				preparedStatement.close( );
				connection.close( );
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return productDTO;
	}

	@Override
	public ProductDTO productInsert(ProductDTO productDTO) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    try {
	        Context context = new InitialContext();
	        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
	        connection = dataSource.getConnection();
	        connection.setAutoCommit(false);
	        String sql = "INSERT INTO PRODUCT(product_number, product_upload, product_update, product_title, product_price, product_content, product_status, img_index, member_number) ";
	        sql += "VALUES(product_seq.NEXTVAL, sysdate, sysdate, ?, ?, ?, ?, ?, ?)";
	        log.info("SQL 확인 - " + sql);
	       
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, productDTO.getProduct_title());
	        preparedStatement.setInt(2, productDTO.getProduct_price());
	        preparedStatement.setString(3, productDTO.getProduct_content());
	        preparedStatement.setString(4, productDTO.getProduct_status());
	        preparedStatement.setInt(5, productDTO.getImg_index());
	        preparedStatement.setInt(6, productDTO.getMember_number());
	        
	       
	        int count = preparedStatement.executeUpdate();
	        if (count > 0) {
	            connection.commit();
	            log.info("커밋되었습니다.");
	        } else {
	            connection.rollback();
	            log.info("롤백되었습니다.");
	        }
	    } catch (Exception e) {
	        log.info("부서 입력 실패 - " + e);
	    } finally {
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }

	    return productDTO;
	}


	@Override
	public ProductDTO productUpdate(ProductDTO productDTO) {
	Connection connection =null;
	PreparedStatement preparedStatement =null;
		try {
			Context context =new InitialContext();
			DataSource dataSource=(DataSource) context.lookup("java:comp/env/jdbc");
			connection =dataSource.getConnection();
			connection.setAutoCommit(false);
			String sql="update PRODUCT set product_title=?,product_price=?,product_update=sysdate,product_content=?,product_status=?";
			sql+="	where product_number = ?";
			log.info("SQL 확인"+sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productDTO.getProduct_title());
			preparedStatement.setInt(2, productDTO.getProduct_price());
			preparedStatement.setString(3, productDTO.getProduct_content());
			preparedStatement.setString(4, productDTO.getProduct_status());
			preparedStatement.setInt(5, productDTO.getProduct_number());
			int count = preparedStatement.executeUpdate();
			if (count>0) {
				connection.commit();
				log.info("커밋되었습니다");
				
			}else {
				connection.rollback();
				log.info("롤백되었습니다");
			}
	} catch (Exception e) {
		log.info("부서 수정 실패"+e);
	}finally {
		try {
		preparedStatement.close();
		connection.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
		return productDTO;
	}

	@Override
	public ProductDTO productDelete(int PRODUCT_NUMBER) {
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		try {
			Context context = new InitialContext();
			DataSource dataSource=(DataSource)context.lookup(("java:comp/env/jdbc"));
			connection =dataSource.getConnection();
			String sql= "delete  from PRODUCT  ";
			sql+=" where product_number =?";
			log.info("SQL 확인s"+sql);
			preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setInt(1, PRODUCT_NUMBER);
			int count =preparedStatement.executeUpdate();
			if (count>0) {
				connection.commit();
				log.info("커밋되었습니다.");
			}else
				connection.rollback();
			log.info("롤백되었습니다.");
		} catch (Exception e) {
			log.info("부서 삭제 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
	public ArrayList productSelectImgIndex() {
		
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet =null;
		ArrayList<ProductDTO>arrayList = new ArrayList<ProductDTO>();
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection =dataSource.getConnection();
			
			String sql="select img_index from PRODUCT";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement =connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				ProductDTO productDTO = new ProductDTO();
				productDTO.setImg_index(resultSet.getInt("img_index"));
				
				log.info("productDTO.img_index - " + productDTO.getImg_index());
				
				arrayList.add(productDTO);
				
				resultSet.getRow();
				if (resultSet.getRow() ==0) {
					log.info("등록한 이미지 번호가 없습니다.");
				}				
			}
			
		} catch (Exception e) {
				log.info("전체 부서 조회 실패 - " + e);
			
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
			return arrayList;
		
		
	}
	
	public String productSelectImgUrl(int img_index) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String img_url = null;
		
		try {
			Context context=new InitialContext();
			DataSource dataSource=(DataSource)context.lookup("java:comp/env/jdbc");
			connection= dataSource.getConnection();
			
	        String sql = "SELECT IMG_URL FROM IMG WHERE PRODUCT_INDEX = ?";
	        
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setInt(1, img_index);
	        
	        resultSet = preparedStatement.executeQuery();
						
			while (resultSet.next()) {
				img_url = resultSet.getString("img_url");
			}
		} catch (Exception e) {
			log.info("특정 img_url 조회 실패 - " + e);
		}finally {
			try {
				resultSet.close( );
				preparedStatement.close( );
				connection.close( );
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return img_url;
	}
	
	public int productSelectImgNumber(int img_index) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		int img_number = 0;
		
		try {
			Context context=new InitialContext();
			DataSource dataSource=(DataSource)context.lookup("java:comp/env/jdbc");
			connection= dataSource.getConnection();
			
	        String sql = "SELECT IMG_NUMBER FROM IMG WHERE PRODUCT_INDEX = ?";
	        
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setInt(1, img_index);
	        
	        resultSet = preparedStatement.executeQuery();
						
			while (resultSet.next()) {
				img_number = resultSet.getInt("img_number");
			}
		} catch (Exception e) {
			log.info("특정 img_url 조회 실패 - " + e);
		}finally {
			try {
				resultSet.close( );
				preparedStatement.close( );
				connection.close( );
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return img_number;
	}

	public ArrayList<ProductDTO> productSelectMine(int member_number){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		ArrayList<ProductDTO>arrayList = new ArrayList<ProductDTO>();
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection =dataSource.getConnection();
			
			String sql="select * from PRODUCT ";
			sql += "where member_number = ? ";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, member_number);
			
			
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ProductDTO productDTO = new ProductDTO();
				productDTO.setProduct_number(resultSet.getInt("PRODUCT_NUMBER"));
				productDTO.setProduct_upload(resultSet.getString("PRODUCT_UPLOAD"));
				productDTO.setProduct_update(resultSet.getString("PRODUCT_UPDATE"));
				productDTO.setProduct_title(resultSet.getString("PRODUCT_TITLE"));
				productDTO.setProduct_price(resultSet.getInt("PRODUCT_PRICE"));
				productDTO.setProduct_content(resultSet.getString("PRODUCT_CONTENT"));
				productDTO.setProduct_status(resultSet.getString("PRODUCT_STATUS"));
				productDTO.setImg_index(resultSet.getInt("img_index"));
				
				log.info(productDTO);
				
				arrayList.add(productDTO);
				
				resultSet.getRow();
				
				if (resultSet.getRow() ==0) {
					log.info("등록한 부서가 없습니다. 부서를 등록해 주세요");
				}
				
			}
		} catch (Exception e) {
			log.info("전체 부서 조회 실패 - " + e);
				}finally {
					try {
						resultSet.close();
						preparedStatement.close();
						connection.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
		
		return arrayList;
	}
}
