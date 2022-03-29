package io.atlant.ledger.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "t_debt")
public class Debt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Transaction transaction;

    @Column
    private String borrower;

    @Column
    private String creditor;

    @Column
    private Date dueDate;
}
