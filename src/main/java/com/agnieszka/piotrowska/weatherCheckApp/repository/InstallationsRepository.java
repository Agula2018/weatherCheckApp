package com.agnieszka.piotrowska.weatherCheckApp.repository;

import com.agnieszka.piotrowska.weatherCheckApp.model.Installations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallationsRepository extends JpaRepository <Installations, Long> {



}
