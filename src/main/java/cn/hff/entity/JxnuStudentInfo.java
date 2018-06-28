package cn.hff.entity;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 江西师大学生实体类
 * <p>
 * Created by Holmofy on 2018/6/26.
 */
@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_jxnu_student")
public class JxnuStudentInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学号
     */
    @Column(name = "stu_num", length = 12)
    private String stuNum;

    /**
     * 姓名
     */
    @Column(length = 16)
    private String name;

    /**
     * 考生号
     */
    @Column(name = "candidate_num", length = 14)
    private String candidateNum;

    /**
     * 性别
     */
    @Enumerated
    private Gender gender;

    /**
     * 出生年月
     */
    private LocalDate birthday;

    /**
     * 民族
     */
    @Column(length = 10)
    private String ethnic;

    /**
     * 学院
     */
    @Column(length = 20)
    private String department;

    /**
     * 班级
     */
    @Column(name = "class_name", length = 24)
    private String className;

    /**
     * 身份证号
     */
    @Column(name = "id_card_num", length = 18)
    private String idCardNum;

    /**
     * 课程成绩
     */
    @Lob
    @Column(name = "course_scores")
    @Convert(converter = CourseScoreConverter.class)
    private Map<String, List<CourseScore>> courseScores;

    /**
     * 课程成绩
     */
    @Data
    public static class CourseScore {
        /**
         * 课程号
         */
        private Integer courseId;
        /**
         * 课程名
         */
        private String courseName;
        /**
         * 课程学分
         */
        private Integer credit;
        /**
         * 成绩(百分制)
         */
        private Integer grade;
        /**
         * 补考成绩
         */
        private Integer secondGrade;
        /**
         * 标准分
         */
        private Double standardScore;
        /**
         * 备注
         */
        private String remark;
    }

    @Converter
    public static class CourseScoreConverter implements AttributeConverter<Map<String, List<CourseScore>>, String> {

        private static final ObjectMapper mapper = new ObjectMapper();

        @Override
        public String convertToDatabaseColumn(Map<String, List<CourseScore>> attribute) {
            try {
                return mapper.writeValueAsString(attribute);
            } catch (JsonProcessingException e) {
                log.warn("成绩序列化异常", e);
                return "";
            }
        }

        @Override
        public Map<String, List<CourseScore>> convertToEntityAttribute(String dbData) {
            try {
                JavaType keyType = mapper.getTypeFactory().constructType(String.class);
                JavaType valueType = mapper.getTypeFactory().constructCollectionType(List.class, CourseScore.class);
                return mapper.readValue(dbData, mapper.getTypeFactory().constructMapType(Map.class, keyType, valueType));
            } catch (IOException e) {
                log.warn("成绩反序列化异常", e);
                return null;
            }
        }
    }
}
