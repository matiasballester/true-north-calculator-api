package com.truenorth.calculator.calculator.repositories;

import com.truenorth.calculator.calculator.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByUserId(Long userId);

    List<Record> findAllByUserIdOrderByDateDesc(Long userId);
}
