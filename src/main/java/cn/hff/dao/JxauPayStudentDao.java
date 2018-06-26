package cn.hff.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.hff.entity.JxauPayStudent;

/**
 * {@link JxauPayStudent}的数据访问对象
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
public interface JxauPayStudentDao extends JpaRepository<JxauPayStudent, Integer> {

    JxauPayStudent findByStuNumber(String stuNumber);

    int countByStuNumber(String stuNumber);

}
