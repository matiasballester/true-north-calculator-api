package com.truenorth.calculator.calculator.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    private Operation operation;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "user_balance")
    private Double userBalance;

    @Column(name = "operation_response")
    private Double operationResponse;

    @Column(name = "date")
    private LocalDateTime date;

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                '}';
    }
}
