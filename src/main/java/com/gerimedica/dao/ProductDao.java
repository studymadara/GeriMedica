package com.gerimedica.dao;

import com.gerimedica.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<ProductDetails,Long> {

    List<ProductDetails> findByCode(String code);
}
