package edu.mum.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.repository.ProductRepository;

@Service
@Transactional
public class ProductService   {
	
	@Autowired
	private ProductRepository productRepository;
		
	public Product save(Product product) {
		return productRepository.save(product);
	}

	public void delete(int id) {
		productRepository.delete(id);
	}

	public Product getProduct(int id) {
		return  (Product) productRepository.findOne(id);
	}

	public List<Product> getAllProduct() {
		return  (List<Product>) productRepository.findAll() ;
	}
	public void update(int id, Product product) {
		//productRepository.update(id,product);
		//product.setDescription(product.getDescription());
		//product.setProductName(product.getProductName());
		//product.setPrice(product.getPrice());
	}
	public List<Product> findByTextSearch(String criteria) {
		if (!criteria.contains("%")) {
			criteria = "%"+criteria+"%";
		}
		return productRepository.findByProductNameLikeOrDescriptionLikeAllIgnoreCase(criteria, criteria);
	}

	public List<Product> findByPrice(double minPrice, double maxPrice) {
		return  productRepository.findByPriceBetween(minPrice, maxPrice);
	}
	
	public List<Product> findByProductType(ProductType productType) {
		 return productRepository.findByProductType(productType);
	}
	public Product findById(int pId){
		return productRepository.findById(pId);			
	}
	
	
}
