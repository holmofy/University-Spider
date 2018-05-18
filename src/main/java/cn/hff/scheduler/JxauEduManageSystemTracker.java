package cn.hff.scheduler;

import cn.hff.dao.JxauClassInfoDao;
import cn.hff.dao.JxauMajorInfoDao;
import cn.hff.dao.JxauStudentInfoDao;
import cn.hff.dto.ClassInfoDto;
import cn.hff.dto.MajorInfoDto;
import cn.hff.dto.StuRecordListDto;
import cn.hff.dto.TreeNodeDto;
import cn.hff.entity.JxauClassInfo;
import cn.hff.entity.JxauMajorInfo;
import cn.hff.entity.JxauStudentInfo;
import cn.hff.school.jxau.EduManageSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Holmofy on 2018/5/14.
 */
@Component
public class JxauEduManageSystemTracker {

    @Autowired
    private JxauStudentInfoDao studentInfoDao;

    @Autowired
    private JxauClassInfoDao classInfoDao;

    @Autowired
    private JxauMajorInfoDao majorInfoDao;

    private EduManageSystem eduManageSystem = new EduManageSystem();

    public void track() {
        String uuidToken = eduManageSystem.login();
        // 获取院系信息
        List<TreeNodeDto> departments = eduManageSystem.getDepartmentOrMajor("treeroot", uuidToken);
        departments.forEach((d) -> {
            String departmentId = d.getId();
            MajorInfoDto dto = eduManageSystem.getMajorInfoByDepartment(departmentId, uuidToken);
            List<JxauMajorInfo> majorInfos = dto.getData().stream().map(MajorInfoDto.DataBean::toMajorInfo).collect(Collectors.toList());
            majorInfoDao.saveAll(majorInfos);

            dto.getData().forEach((majarInfo -> {
                ClassInfoDto classInfoDto = eduManageSystem.getClassInfoByMajor(majarInfo.getZydm(), uuidToken);
                List<JxauClassInfo> classInfos = classInfoDto.getData().stream().map(ClassInfoDto.DataBean::toClassInfo).collect(Collectors.toList());
                classInfoDao.saveAll(classInfos);

                classInfoDto.getData().forEach((classInfo) -> {
                    StuRecordListDto studentDto = eduManageSystem.getStudentsByClass(classInfo.getBjdm(), uuidToken);

                    List<JxauStudentInfo> studentInfos = studentDto.getData().stream().map(StuRecordListDto.DataBean::toStudentInfo).collect(Collectors.toList());
                    studentInfoDao.saveAll(studentInfos);
                });
            }));
        });
    }
}
