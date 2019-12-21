package com.register_office.dao;

import com.register_office.domain.MarriageCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarriageDAO extends JpaRepository<MarriageCertificate, Long> {


}
