package com.NewModsis.Repository;


import com.NewModsis.Entity.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionalRepository extends JpaRepository<Optional,Long> {
}
