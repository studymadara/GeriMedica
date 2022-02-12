package com.gerimedica.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ProductDetails")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetails
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.NONE)
    private int id;

    @Column
    private String source;

    @Column
    private String codeListCode;

    @Column
    private String code;

    @Column
    private String displayValue;

    @Column
    private String longDescription;

    @Column
    private LocalDate fromDate;

    @Column
    private LocalDate toDate;

    @Column
    private Integer sortingPriority;
}
