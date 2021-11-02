package com.moglix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moglix.dto.Supplier;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, String> {

}
