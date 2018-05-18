package cn.hff.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 江西农大专业信息
 * http://jwgl.jxau.edu.cn/XueJiManage/XueJiManage/ProfessionalManage/77ef6ccc-f301-4898-b1d9-f981c2ee1d8c
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
@Data
@Entity
@Table(name = "tb_jxau_major")
public class JxauMajorInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 专业名称
     */
    @Column(name = "major_name", length = 20)
    private String majorName;

    /**
     * 专业代码
     */
    @Column(name = "major_code", length = 10)
    private String majorCode;

    /**
     * 专业简称
     */
    @Column(name = "major_abbr", length = 10)
    private String majorAbbr;

    /**
     * 专业方向
     */
    @Column(name = "major_direction", length = 20)
    private String majorDirection;

    /**
     * 英文名
     */
    @Column(name = "english_name", length = 20)
    private String englishName;

    /**
     * 学院代码
     */
    @Column(name = "department_id", length = 10)
    private String departmentId;

    /**
     * 学院
     */
    @Column(name = "department_name", length = 20)
    private String departmentName;

    /**
     * 学年制：四年
     */
    @Column(length = 3)
    private String years;

    /**
     * 学位：农学学士，管理学学士，工学学士
     */
    @Column(length = 10)
    private String degree;

    /**
     * 培养层次：本科，三校生
     */
    @Column(length = 10)
    private String level;

    /**
     * 招生类型：秋季入学
     */
    @Column(name = "admission_type", length = 6)
    private String admissionType;

    /**
     * 专业介绍
     */
    private String description;
}
