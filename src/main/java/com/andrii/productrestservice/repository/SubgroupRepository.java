package com.andrii.productrestservice.repository;

import com.andrii.productrestservice.model.Subgroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubgroupRepository extends JpaRepository<Subgroup, Long> {
    List<Subgroup> findByNameContainingOrSubgroupDescriptionContaining(String searchByName, String searchByDescription);
}
