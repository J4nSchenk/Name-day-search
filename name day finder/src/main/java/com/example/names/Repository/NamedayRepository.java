package com.example.names.Repository;

import com.example.names.Entity.Nameday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NamedayRepository extends JpaRepository<Nameday, Long> {
    Optional<List<Nameday>> findByNameIgnoreCase(String name);

}
