package edu.eci.cvds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.eci.cvds.model.Configuration;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long>{
    boolean existsById(String propiedadId);

    Configuration findById(String propiedadId);
}