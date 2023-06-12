package com.truenorth.calculator.calculator.repositories;

import com.truenorth.calculator.calculator.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    Optional<Operation> findByOperationType(String operationType);
}
