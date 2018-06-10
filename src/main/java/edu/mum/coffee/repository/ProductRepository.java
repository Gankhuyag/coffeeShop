package edu.mum.coffee.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;

@Repository
public interface ProductRepository  extends CrudRepository<Product, Integer>{

	public List<Product> findByProductNameLikeOrDescriptionLikeAllIgnoreCase(String productName, String description); 
	public List<Product> findByProductType(ProductType productType); 
	public List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
	
	//@Query(value= "delete from Product p where p.id=:id")
	//public void delete(int id);
	
	 
	@Query(value= "SELECT p from Product p WHERE p.id =:pId")
	public Product findById(int pId);
	//@Query(value= "update Product p  set  p.productName=?1,  WHERE p.id =:pId")
	//public Product update(int pId, Product product);
	
    
}
