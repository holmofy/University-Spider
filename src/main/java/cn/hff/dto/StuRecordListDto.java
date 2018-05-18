package cn.hff.dto;

import cn.hff.entity.Gender;
import cn.hff.entity.JxauStudentInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.SignStyle;
import java.util.List;

import static java.time.temporal.ChronoField.*;

/**
 * <pre>
 * POST http://jwgl.jxau.edu.cn/XueJiManage/XueJiManage/GetXueJiList/655887b7-a988-49f2-8a31-e5e338a6d15a
 * bjdm=11060400201401&start=0&limit=100&sort=Xjzt&dir=ASC
 * </pre>
 * Created by Holmofy on 2018/5/13.
 */
public class StuRecordListDto {

    private static final Log log = LogFactory.getLog(StuRecordListDto.class);

    /**
     * Message : null
     * Result : false
     * Data : [{"Xh":"00040001","Xm":"公冶庆丰","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"人文与公共管理学院","Yxdm":"1109","Zyfx":"无","Zymc":"新闻学","Zydm":"11090600","Bjjc":"新闻0401","Bjmc":"新闻学0401","Bjdm":"11090600200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306062173)/","ID":1,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040002","Xm":"刘敏","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"软件学院","Yxdm":"1105","Zyfx":"无","Zymc":"软件工程","Zydm":"11050300","Bjjc":"软件0401","Bjmc":"软件工程0401","Bjdm":"11050300200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306063707)/","ID":2,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040003","Xm":"张亚华","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"园林与艺术学院","Yxdm":"1102","Zyfx":"无","Zymc":"城市规划","Zydm":"11020300","Bjjc":"城规0401","Bjmc":"城市规划0401","Bjdm":"11020300200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306065230)/","ID":3,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040004","Xm":"徐阳","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"经济管理学院","Yxdm":"1107","Zyfx":"无","Zymc":"财务管理","Zydm":"11070600","Bjjc":"财务0401","Bjmc":"财务管理0401","Bjdm":"11070600200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306066763)/","ID":4,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040005","Xm":"高超","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"经济管理学院","Yxdm":"1107","Zyfx":"无","Zymc":"农林经济管理","Zydm":"11070100","Bjjc":"经管0401","Bjmc":"农林经济管理0401","Bjdm":"11070100200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306068393)/","ID":5,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040006","Xm":"徐建","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"经济管理学院","Yxdm":"1107","Zyfx":"无","Zymc":"国际经济与贸易","Zydm":"11070400","Bjjc":"国贸0401","Bjmc":"国际经济与贸易0401","Bjdm":"11070400200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306069923)/","ID":6,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040007","Xm":"代洪军","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"工学院","Yxdm":"1104","Zyfx":"无","Zymc":"机械设计制造及其自动化","Zydm":"11040200","Bjjc":"机制0401","Bjmc":"机械设计制造及其自动化0401","Bjdm":"11040200200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306071460)/","ID":7,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040008","Xm":"蔡亭","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"工学院","Yxdm":"1104","Zyfx":"无","Zymc":"机械设计制造及其自动化","Zydm":"11040200","Bjjc":"机制0402","Bjmc":"机械设计制造及其自动化0402","Bjdm":"11040200200402","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306072987)/","ID":8,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040009","Xm":"龚亚萍","Cym":"无","Xb":"女","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"三年","Yxmc":"工学院","Yxdm":"1104","Zyfx":"无","Zymc":"汽车运输工程","Zydm":"11041000","Bjjc":"汽运0401","Bjmc":"汽车运输工程0401","Bjdm":"11041000200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"专科","Sfzh":"***","Ksh":"***","Xxnx":"4","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306074517)/","ID":9,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040010","Xm":"李刚","Cym":"无","Xb":"男","Csny":"1986-06-02","Mz":"汉族","Jg":"湖北武汉","Zzmm":"中共党员","Rxlb":"秋季入学","Rxsj":"2006-03-21","Xz":"四年","Yxmc":"农学院","Yxdm":"1101","Zyfx":"无","Zymc":"植物保护","Zydm":"11010300","Bjjc":"植保0401","Bjmc":"植物保护0401","Bjdm":"11010300200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":"湖北省襄樊市襄阳轴承厂家属区8-23-4-6","Homezip":"441022","Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306076170)/","ID":35524,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[HomeAddress],[Homezip],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040011","Xm":"赵涛","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"农学院","Yxdm":"1101","Zyfx":"无","Zymc":"农学","Zydm":"11010100","Bjjc":"农学0401","Bjmc":"农学0401","Bjdm":"11010100200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306077693)/","ID":10,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040012","Xm":"黄伟发","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"农学院","Yxdm":"1101","Zyfx":"无","Zymc":"园艺","Zydm":"11010200","Bjjc":"园艺0401","Bjmc":"园艺0401","Bjdm":"11010200200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306079227)/","ID":11,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040013","Xm":"张乙林","Cym":"无","Xb":"男","Csny":"1984-01-09","Mz":"汉族","Jg":"江西赣州","Zzmm":"中共预备党员","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"五年","Yxmc":"计算机与信息工程学院","Yxdm":"1106","Zyfx":"无","Zymc":"计算机科学与技术","Zydm":"11060100","Bjjc":"计科0403","Bjmc":"计算机科学与技术0403","Bjdm":"11060100200403","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":"江西赣州市崇义县关田镇柯树岭","Homezip":"341306","Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346726617110)/","ID":36378,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[HomeAddress],[Homezip],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040014","Xm":"孙刚","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"计算机与信息工程学院","Yxdm":"1106","Zyfx":"无","Zymc":"计算机科学与技术","Zydm":"11060100","Bjjc":"计科0401","Bjmc":"计算机科学与技术0401","Bjdm":"11060100200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346725262200)/","ID":12,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040015","Xm":"陈前方","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"食品科学与工程学院","Yxdm":"1114","Zyfx":"无","Zymc":"轻化工程","Zydm":"11140200","Bjjc":"轻化0401","Bjmc":"轻化工程0401","Bjdm":"11140200200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306081467)/","ID":13,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040016","Xm":"王趁弟","Cym":"无","Xb":"女","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"三年","Yxmc":"职业师范（技术）学院","Yxdm":"1115","Zyfx":"无","Zymc":"中英文秘书","Zydm":"11150600","Bjjc":"职.文秘0402","Bjmc":"中英文秘书0402","Bjdm":"11150600200402","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"专科","Sfzh":"***","Ksh":"***","Xxnx":"4","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306083007)/","ID":14,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040017","Xm":"岳悦","Cym":"无","Xb":"女","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"外国语学院","Yxdm":"1113","Zyfx":"无","Zymc":"英语","Zydm":"11130100","Bjjc":"英语0401","Bjmc":"英语0401","Bjdm":"11130100200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306084533)/","ID":15,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00040018","Xm":"何峥峥     ","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"三年","Yxmc":"职业师范（技术）学院","Yxdm":"1115","Zyfx":"无","Zymc":"电脑艺术设计","Zydm":"11150500","Bjjc":"职.设计0401","Bjmc":"电脑艺术设计0401","Bjdm":"11150500200401","Dqszj":"2004","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"专科","Sfzh":"***","Ksh":"***","Xxnx":"4","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312135577)/","ID":3553,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200201","Xm":"白鹏","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"农学院","Yxdm":"1101","Zyfx":"无","Zymc":"农村区域发展","Zydm":"11010400","Bjjc":"区发0201","Bjmc":"农村区域发展0201","Bjdm":"11010400200201","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312207493)/","ID":16,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200202","Xm":"徐清武","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"工学院","Yxdm":"1104","Zyfx":"无","Zymc":"电子信息工程","Zydm":"11040600","Bjjc":"信工0201","Bjmc":"电子信息工程0201","Bjdm":"11040600200201","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312209053)/","ID":17,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200203","Xm":"王剑","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"工学院","Yxdm":"1104","Zyfx":"无","Zymc":"交通运输","Zydm":"11040300","Bjjc":"交通0201","Bjmc":"交通运输0201","Bjdm":"11040300200201","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312210757)/","ID":18,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200204","Xm":"刘俊","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"计算机与信息工程学院","Yxdm":"1106","Zyfx":"无","Zymc":"计算机科学与技术","Zydm":"11060100","Bjjc":"计科0202","Bjmc":"计算机科学与技术0202","Bjdm":"11060100200202","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312212367)/","ID":19,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200205","Xm":"彭照华","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"计算机与信息工程学院","Yxdm":"1106","Zyfx":"无","Zymc":"信息管理与信息系统","Zydm":"11060200","Bjjc":"信管0201","Bjmc":"信息管理与信息系统0201","Bjdm":"11060200200201","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312214037)/","ID":20,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200206","Xm":"黄丽平","Cym":"无","Xb":"女","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"五年","Yxmc":"计算机与信息工程学院","Yxdm":"1106","Zyfx":"无","Zymc":"计算机科学与技术","Zydm":"11060100","Bjjc":"计科0205","Bjmc":"计算机科学与技术0205","Bjdm":"11060100200205","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346725263547)/","ID":21,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200207","Xm":"徐骏","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"经济管理学院","Yxdm":"1107","Zyfx":"无","Zymc":"经济学","Zydm":"11070200","Bjjc":"经济0202","Bjmc":"经济学0202","Bjdm":"11070200200202","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312216100)/","ID":22,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200208","Xm":"余建平","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"经济管理学院","Yxdm":"1107","Zyfx":"无","Zymc":"会计学","Zydm":"11070300","Bjjc":"会计0201","Bjmc":"会计学0201","Bjdm":"11070300200201","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312217710)/","ID":23,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200209","Xm":"吴杰伦","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"人文与公共管理学院","Yxdm":"1109","Zyfx":"无","Zymc":"公共事业管理","Zydm":"11090200","Bjjc":"公管0201","Bjmc":"公共事业管理0201","Bjdm":"11090200200201","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312219577)/","ID":24,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200210","Xm":"吴民荣","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"人文与公共管理学院","Yxdm":"1109","Zyfx":"无","Zymc":"汉语言","Zydm":"11090300","Bjjc":"语言0201","Bjmc":"汉语言0201","Bjdm":"11090300200201","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312221410)/","ID":25,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200211","Xm":"黄永泉","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"五年","Yxmc":"外国语学院","Yxdm":"1113","Zyfx":"无","Zymc":"英语","Zydm":"11130100","Bjjc":"英语0205","Bjmc":"英语0205","Bjdm":"11130100200205","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346725264917)/","ID":26,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200212","Xm":"熊兴","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"生物科学与工程学院","Yxdm":"1112","Zyfx":"无","Zymc":"生物技术","Zydm":"11120200","Bjjc":"生技0202","Bjmc":"生物技术0202","Bjdm":"11120200200202","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312223397)/","ID":27,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200213","Xm":"张敏","Cym":"无","Xb":"女","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"三年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"专科科","Sfzh":"***","Ksh":"***","Xxnx":"4","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312225073)/","ID":28,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200214","Xm":"曾刚","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"2002-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312226760)/","ID":29,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200301","Xm":"王典火","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"农学院","Yxdm":"1101","Zyfx":"无","Zymc":"农村区域发展","Zydm":"11010400","Bjjc":"区发0301","Bjmc":"农村区域发展0301","Bjdm":"11010400200301","Dqszj":"2003","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312228420)/","ID":14189,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200302","Xm":"刘会文","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"工学院","Yxdm":"1104","Zyfx":"无","Zymc":"农业机械化及其自动化","Zydm":"11040100","Bjjc":"农机0301","Bjmc":"农业机械化及其自动化0301","Bjdm":"11040100200301","Dqszj":"2003","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312230043)/","ID":14190,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200303","Xm":"胡会永","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"工学院","Yxdm":"1104","Zyfx":"无","Zymc":"交通运输","Zydm":"11040300","Bjjc":"交通0302","Bjmc":"交通运输0302","Bjdm":"11040300200302","Dqszj":"2003","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312231677)/","ID":14191,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200304","Xm":"刘亮","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"工学院","Yxdm":"1104","Zyfx":"无","Zymc":"交通运输","Zydm":"11040300","Bjjc":"交通0302","Bjmc":"交通运输0302","Bjdm":"11040300200302","Dqszj":"2003","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312233277)/","ID":14192,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200305","Xm":"于建磊","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"计算机与信息工程学院","Yxdm":"1106","Zyfx":"无","Zymc":"信息管理与信息系统","Zydm":"11060200","Bjjc":"信管0301","Bjmc":"信息管理与信息系统0301","Bjdm":"11060200200301","Dqszj":"2003","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292296425190)/","ID":14193,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200306","Xm":"涂善群","Cym":"无","Xb":"女","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304480177)/","ID":30,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200307","Xm":"廖为林","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304481663)/","ID":31,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200308","Xm":"刘阳","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"人文与公共管理学院","Yxdm":"1109","Zyfx":"无","Zymc":"公共事业管理","Zydm":"11090200","Bjjc":"公管0301","Bjmc":"公共事业管理0301","Bjdm":"11090200200301","Dqszj":"2003","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304483217)/","ID":14194,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200309","Xm":"何根晖","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"生物科学与工程学院","Yxdm":"1112","Zyfx":"无","Zymc":"生物工程","Zydm":"11120100","Bjjc":"生工0302","Bjmc":"生物工程0302","Bjdm":"11120100200302","Dqszj":"2003","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304484877)/","ID":32,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200310","Xm":"郑文俊","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"其他","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"2006-03-21","Xz":"四年","Yxmc":"计算机与信息工程学院","Yxdm":"1106","Zyfx":"无","Zymc":"信息管理与信息系统","Zydm":"11060200","Bjjc":"信管0601","Bjmc":"信息管理与信息系统0601","Bjdm":"11060200200601","Dqszj":"2006","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346725705310)/","ID":3554,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200311","Xm":"陈道煌","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"理学院","Yxdm":"1108","Zyfx":"无","Zymc":"应用化学","Zydm":"11080100","Bjjc":"应化0301","Bjmc":"应用化学0301","Bjdm":"11080100200301","Dqszj":"2003","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304486777)/","ID":14195,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200312","Xm":"罗来正","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"理学院","Yxdm":"1108","Zyfx":"无","Zymc":"应用化学","Zydm":"11080100","Bjjc":"应化0301","Bjmc":"应用化学0301","Bjdm":"11080100200301","Dqszj":"2003","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304488317)/","ID":14196,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200313","Xm":"张珏","Cym":"无","Xb":"女","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"理学院","Yxdm":"1108","Zyfx":"无","Zymc":"信息与计算科学","Zydm":"11080200","Bjjc":"信计0301","Bjmc":"信息与计算科学0301","Bjdm":"11080200200301","Dqszj":"2003","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304489867)/","ID":14197,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00200320","Xm":"李晓文","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"1900-01-01","Xz":"四年","Yxmc":"国土资源与环境学院","Yxdm":"1110","Zyfx":"无","Zymc":"环境科学","Zydm":"11100500","Bjjc":"环科0301","Bjmc":"环境科学0301","Bjdm":"11100500200301","Dqszj":"2003","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304491410)/","ID":14198,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00992065","Xm":"邹立平","Cym":"无","Xb":"男","Csny":"1900-1-1","Mz":"其他","Jg":"NULL","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-1-1","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346725538627)/","ID":3407,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00992104","Xm":"王洪仕","Cym":"无","Xb":"男","Csny":"1900-1-1","Mz":"其他","Jg":"NULL","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-1-1","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346725539980)/","ID":3408,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00992111","Xm":"唐勇金","Cym":"无","Xb":"男","Csny":"1900-1-1","Mz":"其他","Jg":"NULL","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-1-1","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346725541317)/","ID":3409,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00992115","Xm":"童祖军","Cym":"无","Xb":"男","Csny":"1900-1-1","Mz":"其他","Jg":"NULL","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-1-1","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346725542830)/","ID":3410,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00992172","Xm":"王桐庆","Cym":"无","Xb":"男","Csny":"1900-1-1","Mz":"其他","Jg":"NULL","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-1-1","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346725544180)/","ID":3411,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00992180","Xm":"郑子霞","Cym":"无","Xb":"女","Csny":"1900-1-1","Mz":"其他","Jg":"NULL","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-1-1","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346725545540)/","ID":3412,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00992232","Xm":"帅小园","Cym":"无","Xb":"女","Csny":"1900-1-1","Mz":"其他","Jg":"NULL","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-1-1","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346725546897)/","ID":3413,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"00992239","Xm":"侯海珠","Cym":"无","Xb":"男","Csny":"1900-1-1","Mz":"其他","Jg":"NULL","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"1900-1-1","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1346725548283)/","ID":3414,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01000042","Xm":"俞小平     ","Cym":"无","Xb":"男","Csny":"1900-01-01","Mz":"汉族","Jg":"不详","Zzmm":"不详","Rxlb":"秋季入学","Rxsj":"2002-09-01","Xz":"四年","Yxmc":"农学院","Yxdm":"1101","Zyfx":"无","Zymc":"农学","Zydm":"11010100","Bjjc":"农学0201","Bjmc":"农学0201","Bjdm":"11010100200201","Dqszj":"2002","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304492947)/","ID":463,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010001","Xm":"王林华     ","Cym":"无","Xb":"男","Csny":"1982-11-11","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304494540)/","ID":14199,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010002","Xm":"李锋      ","Cym":"无","Xb":"男","Csny":"1983-03-08","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304496027)/","ID":14200,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010003","Xm":"胡永庆     ","Cym":"无","Xb":"男","Csny":"1983-07-28","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304497523)/","ID":14201,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010004","Xm":"林惠梅     ","Cym":"无","Xb":"女","Csny":"1981-10-14","Mz":"汉族","Jg":"福建长泰","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304499020)/","ID":14202,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010005","Xm":"谢志清     ","Cym":"无","Xb":"男","Csny":"1982-10-30","Mz":"汉族","Jg":"不详","Zzmm":"群众","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304500537)/","ID":33698,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010006","Xm":"杨振岗     ","Cym":"无","Xb":"男","Csny":"1983-07-04","Mz":"汉族","Jg":"福建石狮","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304502147)/","ID":14203,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010008","Xm":"蓝望明     ","Cym":"无","Xb":"男","Csny":"1983-05-08","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292304962917)/","ID":14204,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010009","Xm":"孙焕明     ","Cym":"无","Xb":"男","Csny":"1982-06-16","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305872350)/","ID":14205,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010010","Xm":"李珍      ","Cym":"无","Xb":"女","Csny":"1983-07-15","Mz":"汉族","Jg":"江西东乡","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305873817)/","ID":14206,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010011","Xm":"胡海飞     ","Cym":"无","Xb":"男","Csny":"1982-10-16","Mz":"汉族","Jg":"江西玉山","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305875287)/","ID":14207,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010013","Xm":"林敏      ","Cym":"无","Xb":"男","Csny":"1983-10-30","Mz":"汉族","Jg":"江西吉安","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305876750)/","ID":14208,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010014","Xm":"曾敏清     ","Cym":"无","Xb":"男","Csny":"1982-02-13","Mz":"汉族","Jg":"江西会昌","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305878230)/","ID":14209,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010015","Xm":"杨健生     ","Cym":"无","Xb":"男","Csny":"1982-11-26","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305879817)/","ID":14210,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010016","Xm":"刘刚      ","Cym":"无","Xb":"男","Csny":"1984-04-23","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305881300)/","ID":14211,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010017","Xm":"杨仁辉     ","Cym":"无","Xb":"男","Csny":"1983-12-01","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305882777)/","ID":14212,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010018","Xm":"刘芬      ","Cym":"无","Xb":"女","Csny":"1981-10-14","Mz":"汉族","Jg":"江西南昌","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305884250)/","ID":14213,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010019","Xm":"宋甫青     ","Cym":"无","Xb":"男","Csny":"1983-05-15","Mz":"汉族","Jg":"江西余干","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305885730)/","ID":14214,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010020","Xm":"向丹      ","Cym":"无","Xb":"女","Csny":"1983-08-14","Mz":"汉族","Jg":"江西湘东区","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305887297)/","ID":14215,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010021","Xm":"刘龙桂     ","Cym":"无","Xb":"男","Csny":"1982-10-04","Mz":"汉族","Jg":"江西兴国","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305888783)/","ID":14216,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010022","Xm":"韦金洪     ","Cym":"无","Xb":"男","Csny":"1982-08-04","Mz":"汉族","Jg":"江西德兴","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305890260)/","ID":14217,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010023","Xm":"尹良鸿     ","Cym":"无","Xb":"男","Csny":"1982-09-16","Mz":"汉族","Jg":"江西泰和","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305891737)/","ID":14218,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010024","Xm":"曾学伟     ","Cym":"无","Xb":"男","Csny":"1983-11-28","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305893220)/","ID":14219,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010025","Xm":"黄天宝     ","Cym":"无","Xb":"男","Csny":"1981-09-10","Mz":"汉族","Jg":"江西修水","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305894807)/","ID":14220,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010026","Xm":"艾峰      ","Cym":"无","Xb":"男","Csny":"1982-05-01","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305896290)/","ID":14221,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010027","Xm":"施庆山     ","Cym":"无","Xb":"男","Csny":"1984-04-20","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305897783)/","ID":14222,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010028","Xm":"陈何良     ","Cym":"无","Xb":"男","Csny":"1983-09-27","Mz":"汉族","Jg":"江西上栗区","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305899263)/","ID":14223,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010029","Xm":"祝金飞     ","Cym":"无","Xb":"男","Csny":"1982-07-04","Mz":"汉族","Jg":"江西德兴","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305900753)/","ID":14224,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010030","Xm":"张永超     ","Cym":"无","Xb":"男","Csny":"1983-05-06","Mz":"汉族","Jg":"江西城关区","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305902350)/","ID":14225,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010031","Xm":"万建义     ","Cym":"无","Xb":"男","Csny":"1985-06-23","Mz":"汉族","Jg":"江西余干","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292305903840)/","ID":14226,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010032","Xm":"廖秋平     ","Cym":"无","Xb":"男","Csny":"1980-08-15","Mz":"汉族","Jg":"江西渝水区","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292306086120)/","ID":14227,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010033","Xm":"吴凌      ","Cym":"无","Xb":"男","Csny":"1983-02-01","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292311997007)/","ID":14228,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010034","Xm":"徐教国     ","Cym":"无","Xb":"男","Csny":"1982-08-15","Mz":"汉族","Jg":"江西九江","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292311999050)/","ID":14229,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010035","Xm":"桂文华     ","Cym":"无","Xb":"男","Csny":"1984-05-20","Mz":"汉族","Jg":"江西德安","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312000550)/","ID":14230,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010036","Xm":"章新武     ","Cym":"无","Xb":"男","Csny":"1982-09-11","Mz":"汉族","Jg":"江西进贤","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312002163)/","ID":14231,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010038","Xm":"肖雄      ","Cym":"无","Xb":"男","Csny":"1982-09-27","Mz":"汉族","Jg":"江西赣县","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312003797)/","ID":14232,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010039","Xm":"张国军     ","Cym":"无","Xb":"男","Csny":"1981-12-08","Mz":"汉族","Jg":"江西永丰","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312005500)/","ID":14233,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010040","Xm":"林桂贤     ","Cym":"无","Xb":"女","Csny":"1982-09-27","Mz":"汉族","Jg":"江西修水","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312006990)/","ID":14234,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010041","Xm":"王宜江     ","Cym":"无","Xb":"男","Csny":"1982-02-17","Mz":"汉族","Jg":"江西湾里区","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312008643)/","ID":14235,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010042","Xm":"袁淑贞     ","Cym":"无","Xb":"女","Csny":"1983-11-26","Mz":"汉族","Jg":"江西南丰","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312010323)/","ID":14236,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010043","Xm":"张英      ","Cym":"无","Xb":"女","Csny":"1982-12-19","Mz":"汉族","Jg":"江西湘东区","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312011887)/","ID":14237,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010044","Xm":"谢上海     ","Cym":"无","Xb":"男","Csny":"1982-11-09","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312013550)/","ID":14238,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010045","Xm":"蔡伟      ","Cym":"无","Xb":"男","Csny":"1982-02-10","Mz":"汉族","Jg":"不详","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312015067)/","ID":14239,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010046","Xm":"甘传辉     ","Cym":"无","Xb":"男","Csny":"1981-11-23","Mz":"汉族","Jg":"江西玉山","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312016587)/","ID":14240,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010047","Xm":"吕绪明     ","Cym":"无","Xb":"男","Csny":"1983-02-18","Mz":"汉族","Jg":"江西上栗区","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312018183)/","ID":14241,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0},{"Xh":"01010048","Xm":"王志勇     ","Cym":"无","Xb":"男","Csny":"1982-11-29","Mz":"汉族","Jg":"江西永丰","Zzmm":"共青团员","Rxlb":"秋季入学","Rxsj":"2001-09-01","Xz":"四年","Yxmc":null,"Yxdm":null,"Zyfx":"无","Zymc":"0","Zydm":"00000000","Bjjc":"无","Bjmc":"无","Bjdm":"00000000000000","Dqszj":"1900","Dexwdwdm":"无","Dexwdwmc":"无","Dexwzydm":null,"Dexwzymc":null,"Dexwbjdm":"无","Dexwbjjc":"无","Dexwbjmc":"无","Dexwxjzt":"无","Pycc":"本科","Sfzh":"***","Ksh":"***","Xxnx":"5","Xjzt":"已毕业","Zczt":"未注册","Zjzt":null,"Sfsd":null,"Xjbz":"","HomeAddress":null,"Homezip":null,"Gkzt":0,"ZcTime":"/Date(-62135596800000)/","ZcIp":null,"ZcBy":null,"Tbzt":1,"TbTime":"/Date(1292312019900)/","ID":14242,"SetField":",[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]","OrderBy":null,"limit":0,"start":0}]
     * OtherData : null
     * totalCount : 75946
     * success : true
     */

    private Object Message;
    private boolean Result;
    private Object OtherData;
    private int totalCount;
    private boolean success;
    private List<DataBean> Data;

    @JsonProperty("Message")
    public Object getMessage() {
        return Message;
    }

    public void setMessage(Object Message) {
        this.Message = Message;
    }

    @JsonProperty("Result")
    public boolean isResult() {
        return Result;
    }

    public void setResult(boolean Result) {
        this.Result = Result;
    }

    @JsonProperty("OtherData")
    public Object getOtherData() {
        return OtherData;
    }

    public void setOtherData(Object OtherData) {
        this.OtherData = OtherData;
    }

    @JsonProperty("totalCount")
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("success")
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @JsonProperty("Data")
    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * Xh : 00040001
         * Xm : 公冶庆丰
         * Cym : 无
         * Xb : 男
         * Csny : 1900-01-01
         * Mz : 其他
         * Jg : 不详
         * Zzmm : 不详
         * Rxlb : 秋季入学
         * Rxsj : 1900-01-01
         * Xz : 四年
         * Yxmc : 人文与公共管理学院
         * Yxdm : 1109
         * Zyfx : 无
         * Zymc : 新闻学
         * Zydm : 11090600
         * Bjjc : 新闻0401
         * Bjmc : 新闻学0401
         * Bjdm : 11090600200401
         * Dqszj : 2004
         * Dexwdwdm : 无
         * Dexwdwmc : 无
         * Dexwzydm : null
         * Dexwzymc : null
         * Dexwbjdm : 无
         * Dexwbjjc : 无
         * Dexwbjmc : 无
         * Dexwxjzt : 无
         * Pycc : 本科
         * Sfzh : ***
         * Ksh : ***
         * Xxnx : 5
         * Xjzt : 已毕业
         * Zczt : 未注册
         * Zjzt : null
         * Sfsd : null
         * Xjbz :
         * HomeAddress : null
         * Homezip : null
         * Gkzt : 0
         * ZcTime : /Date(-62135596800000)/
         * ZcIp : null
         * ZcBy : null
         * Tbzt : 1
         * TbTime : /Date(1292306062173)/
         * ID : 1
         * SetField : ,[Xh],[Xm],[Cym],[Xb],[Csny],[Mz],[Jg],[Zzmm],[Rxlb],[Rxsj],[Xz],[Yxmc],[Yxdm],[Zyfx],[Zymc],[Zydm],[Bjjc],[Bjmc],[Bjdm],[Dqszj],[Dexwdwdm],[Dexwdwmc],[Dexwbjdm],[Dexwbjjc],[Dexwbjmc],[Dexwxjzt],[Pycc],[Xxnx],[Xjzt],[Zczt],[Xjbz],[Tbzt],[TbTime],[ID],[Sfzh],[Ksh]
         * OrderBy : null
         * limit : 0
         * start : 0
         */

        private String Xh;
        private String Xm;
        private String Cym;
        private String Xb;
        private String Csny;
        private String Mz;
        private String Jg;
        private String Zzmm;
        private String Rxlb;
        private String Rxsj;
        private String Xz;
        private String Yxmc;
        private String Yxdm;
        private String Zyfx;
        private String Zymc;
        private String Zydm;
        private String Bjjc;
        private String Bjmc;
        private String Bjdm;
        private String Dqszj;
        private String Dexwdwdm;
        private String Dexwdwmc;
        private Object Dexwzydm;
        private Object Dexwzymc;
        private String Dexwbjdm;
        private String Dexwbjjc;
        private String Dexwbjmc;
        private String Dexwxjzt;
        private String Pycc;
        private String Sfzh;
        private String Ksh;
        private String Xxnx;
        private String Xjzt;
        private String Zczt;
        private Object Zjzt;
        private Object Sfsd;
        private String Xjbz;
        private Object HomeAddress;
        private Object Homezip;
        private int Gkzt;
        private String ZcTime;
        private Object ZcIp;
        private Object ZcBy;
        private int Tbzt;
        private String TbTime;
        private int ID;
        private String SetField;
        private Object OrderBy;
        private int limit;
        private int start;

        @JsonProperty("Xh")
        public String getXh() {
            return Xh;
        }

        public void setXh(String Xh) {
            this.Xh = Xh;
        }

        @JsonProperty("Xm")
        public String getXm() {
            return Xm;
        }

        public void setXm(String Xm) {
            this.Xm = Xm;
        }

        @JsonProperty("Cym")
        public String getCym() {
            return Cym;
        }

        public void setCym(String Cym) {
            this.Cym = Cym;
        }

        @JsonProperty("Xb")
        public String getXb() {
            return Xb;
        }

        public void setXb(String Xb) {
            this.Xb = Xb;
        }

        @JsonProperty("Csny")
        public String getCsny() {
            return Csny;
        }

        public void setCsny(String Csny) {
            this.Csny = Csny;
        }

        @JsonProperty("Mz")
        public String getMz() {
            return Mz;
        }

        public void setMz(String Mz) {
            this.Mz = Mz;
        }

        @JsonProperty("Jg")
        public String getJg() {
            return Jg;
        }

        public void setJg(String Jg) {
            this.Jg = Jg;
        }

        @JsonProperty("Zzmm")
        public String getZzmm() {
            return Zzmm;
        }

        public void setZzmm(String Zzmm) {
            this.Zzmm = Zzmm;
        }

        @JsonProperty("Rxlb")
        public String getRxlb() {
            return Rxlb;
        }

        public void setRxlb(String Rxlb) {
            this.Rxlb = Rxlb;
        }

        @JsonProperty("Rxsj")
        public String getRxsj() {
            return Rxsj;
        }

        public void setRxsj(String Rxsj) {
            this.Rxsj = Rxsj;
        }

        @JsonProperty("Xz")
        public String getXz() {
            return Xz;
        }

        public void setXz(String Xz) {
            this.Xz = Xz;
        }

        @JsonProperty("Yxmc")
        public String getYxmc() {
            return Yxmc;
        }

        public void setYxmc(String Yxmc) {
            this.Yxmc = Yxmc;
        }

        @JsonProperty("Yxdm")
        public String getYxdm() {
            return Yxdm;
        }

        public void setYxdm(String Yxdm) {
            this.Yxdm = Yxdm;
        }

        @JsonProperty("Zyfx")
        public String getZyfx() {
            return Zyfx;
        }

        public void setZyfx(String Zyfx) {
            this.Zyfx = Zyfx;
        }

        @JsonProperty("Zymc")
        public String getZymc() {
            return Zymc;
        }

        public void setZymc(String Zymc) {
            this.Zymc = Zymc;
        }

        @JsonProperty("Zydm")
        public String getZydm() {
            return Zydm;
        }

        public void setZydm(String Zydm) {
            this.Zydm = Zydm;
        }

        @JsonProperty("Bjjc")
        public String getBjjc() {
            return Bjjc;
        }

        public void setBjjc(String Bjjc) {
            this.Bjjc = Bjjc;
        }

        @JsonProperty("Bjmc")
        public String getBjmc() {
            return Bjmc;
        }

        public void setBjmc(String Bjmc) {
            this.Bjmc = Bjmc;
        }

        @JsonProperty("Bjdm")
        public String getBjdm() {
            return Bjdm;
        }

        public void setBjdm(String Bjdm) {
            this.Bjdm = Bjdm;
        }

        @JsonProperty("Dqszj")
        public String getDqszj() {
            return Dqszj;
        }

        public void setDqszj(String Dqszj) {
            this.Dqszj = Dqszj;
        }

        @JsonProperty("Dexwdwdm")
        public String getDexwdwdm() {
            return Dexwdwdm;
        }

        public void setDexwdwdm(String Dexwdwdm) {
            this.Dexwdwdm = Dexwdwdm;
        }

        @JsonProperty("Dexwdwmc")
        public String getDexwdwmc() {
            return Dexwdwmc;
        }

        public void setDexwdwmc(String Dexwdwmc) {
            this.Dexwdwmc = Dexwdwmc;
        }

        @JsonProperty("Dexwzydm")
        public Object getDexwzydm() {
            return Dexwzydm;
        }

        public void setDexwzydm(Object Dexwzydm) {
            this.Dexwzydm = Dexwzydm;
        }

        @JsonProperty("Dexwzymc")
        public Object getDexwzymc() {
            return Dexwzymc;
        }

        public void setDexwzymc(Object Dexwzymc) {
            this.Dexwzymc = Dexwzymc;
        }

        @JsonProperty("Dexwbjdm")
        public String getDexwbjdm() {
            return Dexwbjdm;
        }

        public void setDexwbjdm(String Dexwbjdm) {
            this.Dexwbjdm = Dexwbjdm;
        }

        @JsonProperty("Dexwbjjc")
        public String getDexwbjjc() {
            return Dexwbjjc;
        }

        public void setDexwbjjc(String Dexwbjjc) {
            this.Dexwbjjc = Dexwbjjc;
        }

        @JsonProperty("Dexwbjmc")
        public String getDexwbjmc() {
            return Dexwbjmc;
        }

        public void setDexwbjmc(String Dexwbjmc) {
            this.Dexwbjmc = Dexwbjmc;
        }

        @JsonProperty("Dexwxjzt")
        public String getDexwxjzt() {
            return Dexwxjzt;
        }

        public void setDexwxjzt(String Dexwxjzt) {
            this.Dexwxjzt = Dexwxjzt;
        }

        @JsonProperty("Pycc")
        public String getPycc() {
            return Pycc;
        }

        public void setPycc(String Pycc) {
            this.Pycc = Pycc;
        }

        @JsonProperty("Sfzh")
        public String getSfzh() {
            return Sfzh;
        }

        public void setSfzh(String Sfzh) {
            this.Sfzh = Sfzh;
        }

        @JsonProperty("Ksh")
        public String getKsh() {
            return Ksh;
        }

        public void setKsh(String Ksh) {
            this.Ksh = Ksh;
        }

        @JsonProperty("Xxnx")
        public String getXxnx() {
            return Xxnx;
        }

        public void setXxnx(String Xxnx) {
            this.Xxnx = Xxnx;
        }

        @JsonProperty("Xjzt")
        public String getXjzt() {
            return Xjzt;
        }

        public void setXjzt(String Xjzt) {
            this.Xjzt = Xjzt;
        }

        @JsonProperty("Zczt")
        public String getZczt() {
            return Zczt;
        }

        public void setZczt(String Zczt) {
            this.Zczt = Zczt;
        }

        @JsonProperty("Zjzt")
        public Object getZjzt() {
            return Zjzt;
        }

        public void setZjzt(Object Zjzt) {
            this.Zjzt = Zjzt;
        }

        @JsonProperty("Sfsd")
        public Object getSfsd() {
            return Sfsd;
        }

        public void setSfsd(Object Sfsd) {
            this.Sfsd = Sfsd;
        }

        @JsonProperty("Xjbz")
        public String getXjbz() {
            return Xjbz;
        }

        public void setXjbz(String Xjbz) {
            this.Xjbz = Xjbz;
        }

        @JsonProperty("HomeAddress")
        public Object getHomeAddress() {
            return HomeAddress;
        }

        public void setHomeAddress(Object HomeAddress) {
            this.HomeAddress = HomeAddress;
        }

        @JsonProperty("Homezip")
        public Object getHomezip() {
            return Homezip;
        }

        public void setHomezip(Object Homezip) {
            this.Homezip = Homezip;
        }

        @JsonProperty("Gkzt")
        public int getGkzt() {
            return Gkzt;
        }

        public void setGkzt(int Gkzt) {
            this.Gkzt = Gkzt;
        }

        @JsonProperty("ZcTime")
        public String getZcTime() {
            return ZcTime;
        }

        public void setZcTime(String ZcTime) {
            this.ZcTime = ZcTime;
        }

        @JsonProperty("ZcIp")
        public Object getZcIp() {
            return ZcIp;
        }

        public void setZcIp(Object ZcIp) {
            this.ZcIp = ZcIp;
        }

        @JsonProperty("ZcBy")
        public Object getZcBy() {
            return ZcBy;
        }

        public void setZcBy(Object ZcBy) {
            this.ZcBy = ZcBy;
        }

        @JsonProperty("Tbzt")
        public int getTbzt() {
            return Tbzt;
        }

        public void setTbzt(int Tbzt) {
            this.Tbzt = Tbzt;
        }

        @JsonProperty("TbTime")
        public String getTbTime() {
            return TbTime;
        }

        public void setTbTime(String TbTime) {
            this.TbTime = TbTime;
        }

        @JsonProperty("ID")
        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        @JsonProperty("SetField")
        public String getSetField() {
            return SetField;
        }

        public void setSetField(String SetField) {
            this.SetField = SetField;
        }

        @JsonProperty("OrderBy")
        public Object getOrderBy() {
            return OrderBy;
        }

        public void setOrderBy(Object OrderBy) {
            this.OrderBy = OrderBy;
        }

        @JsonProperty("limit")
        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        @JsonProperty("start")
        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        private static final DateTimeFormatter formatterMDY;

        private static final DateTimeFormatter formatterYMD;

        static {
            formatterMDY = new DateTimeFormatterBuilder()
                    .appendValue(MONTH_OF_YEAR, 1, 2, SignStyle.NEVER)
                    .appendLiteral('-')
                    .appendValue(DAY_OF_MONTH, 1, 2, SignStyle.NEVER)
                    .appendLiteral('-')
                    .appendValue(YEAR, 2, 4, SignStyle.NEVER)
                    .toFormatter();
            formatterYMD = new DateTimeFormatterBuilder()
                    .appendValue(YEAR, 2, 4, SignStyle.NEVER)
                    .appendLiteral('-')
                    .appendValue(MONTH_OF_YEAR, 1, 2, SignStyle.NEVER)
                    .appendLiteral('-')
                    .appendValue(DAY_OF_MONTH, 1, 2, SignStyle.NEVER)
                    .toFormatter();
        }

        public JxauStudentInfo toStudentInfo() {
            JxauStudentInfo stuInfo = new JxauStudentInfo();
            String birth = getCsny();
            if (!StringUtils.isEmpty(birth)) {
                try {
                    if (birth.indexOf(' ') >= 0) {
                        // 奇葩格式:02 23 1996
                        // 04  4 1997
                        birth = String.join("-", birth.split(" +"));
                        stuInfo.setBirthday(LocalDate.parse(birth, formatterMDY));
                    } else {
                        stuInfo.setBirthday(LocalDate.parse(birth, formatterYMD));
                    }
                } catch (DateTimeParseException e) {
                    log.warn("日期解析失败", e);
                }
            }
            stuInfo.setClassCode(getBjdm());
            stuInfo.setEthnic(getMz());
            stuInfo.setGender(Gender.fromText(getXb()));
            stuInfo.setMajorCode(getZydm());
            stuInfo.setName(getXm());
            stuInfo.setOrigin(getJg());
            stuInfo.setPoliticalStatus(getZzmm());
            stuInfo.setRegisterStatus(getZczt());
            String startTime = getRxsj();
            if (!StringUtils.isEmpty(startTime)) {
                try {
                    stuInfo.setStartTime(LocalDate.parse(startTime, formatterYMD));
                } catch (DateTimeParseException e) {
                    log.warn("日期解析异常", e);
                }
            }
            stuInfo.setStatus(getXjzt());
            stuInfo.setStuNum(getXh());
            return stuInfo;
        }
    }
}
