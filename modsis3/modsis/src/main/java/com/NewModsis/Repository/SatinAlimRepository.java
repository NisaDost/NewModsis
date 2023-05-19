package com.NewModsis.Repository;

import com.NewModsis.Entity.SatinAlim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SatinAlimRepository extends JpaRepository<SatinAlim,Long> {
    List<SatinAlim> findById(int id);
}
