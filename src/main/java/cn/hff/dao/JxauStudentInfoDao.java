package cn.hff.dao;

import cn.hff.entity.JxauStudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Holmofy on 2018/5/14.
 */
public interface JxauStudentInfoDao extends JpaRepository<JxauStudentInfo, Integer> {

    @Query(value = "select stu_num from tb_jxau_student group by stu_num having count(*) > 1", nativeQuery = true)
    List<String> findDistinctStuNum();

    JxauStudentInfo getFirstByStuNum(String stuNum);

    @Modifying
    @Transactional
    @Query(value = "delete from tb_jxau_student where stu_num = ? and id != ?", nativeQuery = true)
    void deleteByStuNumEqualsAndIdNotEquals(String stuNum, int id);

}
