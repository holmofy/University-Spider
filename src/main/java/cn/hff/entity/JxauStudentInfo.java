package cn.hff.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 江西农大学生信息
 * <p>
 * Created by Holmofy on 2018/5/14.
 */
@Data
@Entity
@Table(name = "tb_jxau_student")
public class JxauStudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学号
     */
    @Column(name = "stu_num", length = 8)
    private String stuNum;

    /**
     * 姓名
     */
    @Column(length = 16)
    private String name;

    /**
     * 性别
     */
    @Enumerated
    private Gender gender;

    /**
     * 出生年月
     */
    private LocalDate birthday;

    /**
     * 民族
     */
    @Column(length = 10)
    private String ethnic;

    /**
     * 籍贯：内蒙古呼和浩特
     */
    @Column(length = 255)
    private String origin;

    /**
     * 政治面貌
     */
    @Column(name = "political_status", length = 10)
    private String politicalStatus;

    /**
     * 入学时间
     */
    @Column(name = "start_time")
    private LocalDate startTime;

    /**
     * 班级编号
     */
    @Column(name = "class_code", length = 16)
    private String classCode;

    /**
     * 专业编号
     */
    @Column(name = "major_code", length = 16)
    private String majorCode;

    /**
     * 学籍注册：已注册
     */
    @Column(name = "register_status", length = 10)
    private String registerStatus;

    /**
     * 学籍状态：正常、在籍
     */
    @Column(length = 10)
    private String status;
}
