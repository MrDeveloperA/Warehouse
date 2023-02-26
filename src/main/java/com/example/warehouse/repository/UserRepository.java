package com.example.warehouse.repository;

import com.example.warehouse.entity.User1;
import com.example.warehouse.projection.CustomUser1;
import com.example.warehouse.projection.CustomWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "user", collectionResourceRel = "list", excerptProjection = CustomUser1.class)
public interface UserRepository extends JpaRepository<User1, Integer> {

}
