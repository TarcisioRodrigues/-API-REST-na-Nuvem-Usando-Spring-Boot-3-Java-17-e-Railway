package DesafioAPIRest.ApiRest.modules.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(precision = 13, scale = 2)
    private String balance;
    @Column(precision = 13, scale = 2,name = "available_limit")
    private BigDecimal limit;
}
