package kdb.product.serviec;

import java.util.ArrayList;

import kdb.product.dao.ProductDAO;
import kdb.product.dto.ProductDTO;

public interface ProductService {
	public ArrayList<ProductDTO>productSelectAll();
	public ProductDTO productSelect(int PRODUCT_NUMBER);
	public ProductDTO productInsert(ProductDTO productDTO);
	public ProductDTO productUpdate(ProductDTO productDTO);
	public ProductDTO productDelete(int PRODUCT_NUMBER);

}
