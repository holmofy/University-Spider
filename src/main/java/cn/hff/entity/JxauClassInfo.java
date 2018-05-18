package cn.hff.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 江西农大班级信息
 * http://jwgl.jxau.edu.cn/XueJiManage/XueJiManage/ClassManage/77ef6ccc-f301-4898-b1d9-f981c2ee1d8c
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
@Data
@Entity
@Table(name = "tb_jxau_class")
public class JxauClassInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 班级名：网络工程1401
     */
    @Column(name = "class_name", length = 20)
    private String className;

    /**
     * 班级简称：网工1401
     */
    @Column(name = "class_abbr", length = 16)
    private String classAbbr;

    /**
     * 班级编码(用于数据查询)
     */
    @Column(length = 16)
    private String code;

    /**
     * 院系ID
     */
    @Column(name = "department_id", length = 10)
    private String departmentId;

    /**
     * 学生人数
     */
    @Column(name = "stu_count")
    private Integer stuCount;

    /**
     * 女生人数
     */
    @Column(name = "girl_count")
    private Integer girlCount;

    /**
     * 入学时间
     */
    @Column(name = "start_time")
    private LocalDate startTime;

    /**
     * 班主任ID
     */
    @Column(name = "teacher_code", length = 16)
    private String teacherCode;

    /**
     * 班主任老师名字
     */
    @Column(name = "teacher_name", length = 10)
    private String teacherName;
}
