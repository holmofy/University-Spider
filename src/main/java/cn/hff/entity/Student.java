package cn.hff.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 核心实体类
 * <p>
 * Created by Holmofy on 2018/5/9.
 */
@Data
@Entity
@Table(name = "tb_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名，好像碰到了特别长的名字，估计不是汉族人
     */
    @Column(length = 32)
    private String name;

    /**
     * 学号
     */
    @Column(name = "stu_num", length = 16, unique = true)
    private String stuNumber;

    /**
     * 性别
     */
    @Enumerated
    private Gender gender;

    /**
     * 院系
     */
    @Column(length = 30)
    private String department;

    /**
     * 专业
     */
    @Column(length = 50)
    private String major;

    /**
     * 入学年份
     */
    @Column(name = "start_year", length = 4)
    private String startYear;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 班级
     */
    @Column(name = "class", length = 30)
    private String studentClass;

    /**
     * 身份证号
     */
    @Column(name = "id_cart_num", length = 18)
    private String idCartNum;

    /**
     * 银行卡号
     */
    @Column(name = "bank_cart_num", length = 20)
    private String bankCartNum;

}
