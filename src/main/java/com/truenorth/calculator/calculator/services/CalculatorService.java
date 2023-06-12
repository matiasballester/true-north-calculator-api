package com.truenorth.calculator.calculator.services;

import com.truenorth.calculator.calculator.dtos.MathRequestDTO;
import com.truenorth.calculator.calculator.dtos.OperationResultDTO;
import com.truenorth.calculator.calculator.dtos.RecordDTO;
import com.truenorth.calculator.calculator.dtos.UserDTO;
import com.truenorth.calculator.calculator.exceptions.AppException;
import com.truenorth.calculator.calculator.exceptions.NotEnoughBalanceException;
import com.truenorth.calculator.calculator.mappers.RecordMapper;
import com.truenorth.calculator.calculator.entities.Operation;
import com.truenorth.calculator.calculator.entities.Record;
import com.truenorth.calculator.calculator.entities.User;
import com.truenorth.calculator.calculator.math.*;
import com.truenorth.calculator.calculator.models.OperationType;
import com.truenorth.calculator.calculator.repositories.OperationRepository;
import com.truenorth.calculator.calculator.repositories.RecordRepository;
import com.truenorth.calculator.calculator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CalculatorService {

    @Value("${math.initial-cost:10000}")
    private Double initialCost;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private CalculatorStrategyFactory strategyFactory;

    public RecordDTO calculate(MathRequestDTO mathRequestDTO, OperationType operationType) {
        UserDTO userDto = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> userOptional = userRepository.findByName(userDto.getName());
        Optional<Operation> operationOptional = operationRepository.findByOperationType(operationType.name());

        User user = userOptional.get();
        Operation operation = operationOptional.get();

        List<Record> records = recordRepository.findAllByUserIdOrderByDateDesc(user.getId());
        RecordDTO recordDTO = null;
        if (records.isEmpty()) {
            Record record = createRecord(mathRequestDTO, user, operation, initialCost);
            recordDTO = recordMapper.toRecordDTO(record);
        } else {
            Optional<Record> lastUserRecord = records.stream().limit(1).findFirst();

            if (lastUserRecord.isEmpty() || lastUserRecord.get().getUserBalance() <= 0)
                throw new NotEnoughBalanceException("user’s balance isn’t enough to cover the request cost");

            if (lastUserRecord.isPresent()) {
                Record record = createRecord(mathRequestDTO, user, operation, lastUserRecord.get().getUserBalance());
                recordDTO = recordMapper.toRecordDTO(record);
            }
        }
        return recordDTO;
    }

    private Record createRecord(MathRequestDTO mathRequestDTO, User user, Operation operation, Double userBalance) {
        Record record = new Record();
        record.setUser(user);
        record.setOperation(operation);

        CalculatorStrategy strategy = strategyFactory.
                findStrategy(CalculatorStrategyName.valueOfLabel(operation.getOperationType()));
        OperationResultDTO operationResultDTO = strategy.calculate(mathRequestDTO);

        record.setAmount(operationResultDTO.getResult().doubleValue());
        record.setUserBalance(userBalance - operation.getCost());
        record.setDate(LocalDateTime.now());
        recordRepository.save(record);
        return record;
    }
}
