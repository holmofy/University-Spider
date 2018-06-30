package cn.hff.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.hff.entity.JxnuStudentInfo;

/**
 * {@link JxnuStudentInfo}数据访问对象
 * <p>
 * Created by Holmofy on 2018/6/28.
 */
public interface JxnuStudentInfoDao extends JpaRepository<JxnuStudentInfo, Integer> {

    List<JxnuStudentInfo> findByStuNumStartingWith(String stuNumPrefix);

    @Query(value = "select stu_num from tb_jxnu_student group by stu_num having count(*) > 1", nativeQuery = true)
    List<String> findDistinctStuNum();

    JxnuStudentInfo getFirstByStuNum(String stuNum);


    @Modifying
    @Transactional
    @Query(value = "delete from tb_jxnu_student where stu_num = ? and id != ?", nativeQuery = true)
    void deleteByStuNumEqualsAndIdNotEquals(String stuNum, int id);

}
