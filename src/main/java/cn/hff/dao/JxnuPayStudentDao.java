package cn.hff.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.hff.entity.JxnuPayStudent;

/**
 * {@link JxnuPayStudent}的数据访问对象
 * <p>
 * Created by Holmofy on 2018/6/27.
 */
public interface JxnuPayStudentDao extends JpaRepository<JxnuPayStudent, Integer> {

    int countByStuNumber(String stuNum);

}
