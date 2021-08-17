package com.murphy.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 账单类型 - 实体类
 *
 * @author murphy
 * @since 2021/8/16 8:15 下午
 */
@Data
@Table(name = "bill_type_")
public class BillType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private Long id;

    @Column(name = "name_")
    private String name;
}
