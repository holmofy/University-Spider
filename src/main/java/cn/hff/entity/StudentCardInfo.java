package cn.hff.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 学生校园卡信息
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
@Data
@Entity
@Table(name = "tb_stu_card_info")
public class StudentCardInfo {

    @Id
    private Integer id;

    /**
     * 学工号
     */
    @Column(name = "stu_job_num", length = 10)
    private String jobNum;

    /**
     * 姓名
     */
    @Column(length = 10)
    private String name;

    /**
     * 性别
     */
    @Enumerated
    private Gender gender;

    /**
     * 民族
     */
    @Column(length = 10)
    private String ethnic;

    /**
     * 主钱包余额(单位：分)
     * <p>
     * 不保存小数位，将单位置为分，转换回元需乘100
     */
    @Column(name = "wallet_balance")
    private Integer walletBalance;

    /**
     * 补助余额(单位：分)
     */
    @Column(name = "grant_balance")
    private Integer grantBalance;

    /**
     * 身份职位
     */
    @Column(length = 12)
    private String job;

    /**
     * 校园卡状态：正常卡
     */
    @Column(length = 12)
    private String status;

    /**
     * 部门：学生/本科生/计算机信息工程/网络工程/2014级/网络工程1401
     * <p>
     * 和{@link Student#department}不一样
     */
    @Column(length = 128)
    private String department;
}
