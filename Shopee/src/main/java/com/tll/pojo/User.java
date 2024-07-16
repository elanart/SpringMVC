package com.tll.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "user_role", length = 10)
    private String userRole;

    @OneToMany(mappedBy = "user")
    private Set<SaleOrder> saleOrders = new LinkedHashSet<>();

}