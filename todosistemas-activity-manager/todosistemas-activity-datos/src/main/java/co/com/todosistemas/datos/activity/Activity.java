package com.co.todosistemas.datos.activity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Cacheable(value = false)
@Table(name = "activity")
@Data
public class ActivityEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "state")
    private Long idState;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm",timezone="America/Bogota")
    @Column(name = "estimatedDate ")
    private Date estimatedDate;

    @Column(name = "employee")
    private Long employee ;

}
