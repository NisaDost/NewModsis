package com.NewModsis.Repository;

import com.NewModsis.Entity.Karavan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface KaravanRepository extends JpaRepository<Karavan,Long> {

}
