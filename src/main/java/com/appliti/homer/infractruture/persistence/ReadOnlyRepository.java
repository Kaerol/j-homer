package com.appliti.homer.infractruture.persistence;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface ReadOnlyRepository<T, UUID extends Serializable> extends Repository<T, java.util.UUID> {

    Optional<T> findById(UUID uuid);
    List<T> findAll();
}
