package com.role.base.auth.service.impl;

import java.text.Format.Field;
import java.util.List;
import java.util.Map;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.role.base.auth.entity.Product;
import com.role.base.auth.exception.ProductNotFoundException;
import com.role.base.auth.repository.ProductRepository;

@Service
@Primary
public class ProductServiceImpl implements ProductService  {
	@Autowired
	private ProductRepository productRepository;
	
	boolean flag;
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> fetchAllProducts() {
		return productRepository.findAll();
	}

	public Product fetchProduct(Long id) throws ProductNotFoundException {
		Product product = null;
		if(id != null && id != 0) {
			flag = productRepository.existsById(id);
		}
		if(flag) 
			product = productRepository.findById(id).get();
		else
			throw new ProductNotFoundException("Product Not Found");
		return product;
	}

	public Product putUpdateProduct(Long id, Product product) throws ProductNotFoundException {
		Product productfromDB = null;
		if(id != null && id != 0) {
			flag = productRepository.existsById(id);
		}else
			throw new ProductNotFoundException("Product not found");
		if(flag) {
			productfromDB = productRepository.findById(id).get();
			productfromDB.setName(product.getName());
			productfromDB.setPrice(product.getPrice());
			productfromDB.setDepartment(product.getDepartment());
		}
		return productRepository.save(productfromDB);
	}

	public Product patchUpdateProduct(Long id, Map<String, Object> fields) throws ProductNotFoundException {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Product.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingProduct.get(), value);
            });
            return productRepository.save(existingProduct.get());
        }
        return null;
    }

	public String deleteProduct(Long id) {
		if(id != null && id != 0) {
			flag = productRepository.existsById(id);
		}
		if(flag) 
			productRepository.deleteById(id);
		return "Product deleted";
	}

}
