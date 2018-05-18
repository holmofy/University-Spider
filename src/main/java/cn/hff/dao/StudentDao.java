package cn.hff.dao;

import cn.hff.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@link Student}等数据访问对象
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
public interface StudentDao extends JpaRepository<Student, Integer> {

    Student findByStuNumber(String stuNumber);

}
