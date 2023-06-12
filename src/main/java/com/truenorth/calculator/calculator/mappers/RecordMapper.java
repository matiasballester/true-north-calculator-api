package com.truenorth.calculator.calculator.mappers;


import com.truenorth.calculator.calculator.dtos.RecordDTO;
import com.truenorth.calculator.calculator.entities.Record;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecordMapper {
    RecordDTO toRecordDTO(Record record);
}
