package cn.hff.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.hff.entity.JxnuStudentInfo;

/**
 * {@link JxnuStudentInfo}数据访问对象
 * <p>
 * Created by Holmofy on 2018/6/28.
 */
public interface JxnuStudentInfoDao extends JpaRepository<JxnuStudentInfo, Integer> {

}
