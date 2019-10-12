package com.kevinbradley.data.repository;

import com.kevinbradley.data.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PersonRepository interface providing CRUD capability
 */
@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
    public List<PersonEntity> findByNameIgnoreCase(@Param("name")String name);
    public List<PersonEntity> findAll();
    public long deleteByNameIgnoreCase(@Param("name")String name);
}
