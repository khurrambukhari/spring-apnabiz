package com.krobusiness.model.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krobusiness.model.entities.AppClient;

import java.util.Optional;

@Repository
public interface AppClientRepository extends JpaRepository<AppClient, Long> {
    Optional<AppClient> findByUsername(String username);
}
