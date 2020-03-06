package com.agnieszka.piotrowska.weatherCheckApp.repository;

import com.agnieszka.piotrowska.weatherCheckApp.model.Measurements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurements, Long> {

}
