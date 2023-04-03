package com.java4.ngoclbph26472.repositories;

import com.java4.ngoclbph26472.entity.Product;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

//    @Query("update Product p set p.deleted = true where p.id=:cid")
//    void updateProduct(@Param("cid") Long id);
}
