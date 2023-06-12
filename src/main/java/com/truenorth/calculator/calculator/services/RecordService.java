package com.truenorth.calculator.calculator.services;

import com.truenorth.calculator.calculator.dtos.RecordDTO;
import com.truenorth.calculator.calculator.entities.Record;
import com.truenorth.calculator.calculator.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;

    public List<RecordDTO> getRecordsByUserId(Long id) {
        List<Record> records = recordRepository.findByUserId(id);

        return null;
    }
}
