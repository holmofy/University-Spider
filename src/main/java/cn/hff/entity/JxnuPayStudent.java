package cn.hff.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 江西师大统一支付平台的数据
 * <p>
 * Created by Holmofy on 2018/6/27.
 */
@Entity
@Table(name = "tb_jxnu_pay_stu")
public class JxnuPayStudent extends CommonPayStudent {
}
