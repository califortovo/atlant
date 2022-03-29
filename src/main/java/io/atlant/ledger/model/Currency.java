package io.atlant.ledger.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "t_currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String ticker;

    @Column
    private BigDecimal priceInUsd;

    /*
     * https://www.compart.com/en/unicode/category/Sc - unicode of currencies symbol
     */

    @Column
    private Character symbol;

    @Column
    private String name;

    @Column
    private String shortName;

}
