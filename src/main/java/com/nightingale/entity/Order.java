package com.nightingale.entity;

import com.nightingale.utils.enumMetodoPago;
import com.nightingale.entity.Product;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // llave foranea user id
    
    @Column(name = "reg_date", nullable = false, updatable = false )// fecha
    private LocalDateTime regDate;
    
    @Column(name = "total", nullable = false)
    private Double total;


    // lista de productos
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> productList;

    @NotNull
    @Enumerated(EnumType.STRING)
    private enumMetodoPago metodo;

    @Column(name = "estado", nullable = true)
    private Boolean estado;
}
