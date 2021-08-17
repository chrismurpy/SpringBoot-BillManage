package com.murphy.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 账单 - 实体类
 *
 * @author murphy
 * @since 2021/8/16 9:07 下午
 */
@Data
@Table(name = "bill_")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private Long id;
    @Column(name = "title_")
    private String title;
    @Column(name = "bill_time_")
    private Date billTime;
    @Column(name = "type_id_")
    private Long typeId;
    @Column(name = "price_")
    private Double price;
    @Column(name = "explain_")
    private String explain;

    /**
     * 类别名称
     */
    @Transient
    private String typeName;

    /**
     * 开始时间：用于查询
     */
    @Transient
    private Date date1;

    /**
     * 结束时间：用于查询
     */
    @Transient
    private Date date2;
}
