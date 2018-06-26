package cn.hff.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 江西农大统一支付平台的数据
 * <p>
 * Created by Holmofy on 2018/6/27.
 */
@Entity
@Table(name = "tb_jxau_pay_stu")
public class JxauPayStudent extends CommonPayStudent {
}
