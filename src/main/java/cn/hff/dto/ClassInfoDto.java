package cn.hff.dto;

import cn.hff.entity.JxauClassInfo;
import cn.hff.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * <pre>
 * POST http://jwgl.jxau.edu.cn/XueJiManage/XueJiManage/ClassList/655887b7-a988-49f2-8a31-e5e338a6d15a
 * nodeid=11010100&start=0&limit=30
 * </pre>
 * GsonFormatter生成
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
public class ClassInfoDto {

    /**
     * Message : null
     * Result : false
     * Data : [{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1401","Bjjc":"农学1401","Bjdm":"11010100201401","Pycc":"本科","RenShu":52,"Nv":0,"Rxsj":"2014-09-01","Xz":"四年","Bz":"无","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"正常","OrderIndex":1,"IndexID":"0101001401","ID":1331,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1402","Bjjc":"农学1402","Bjdm":"11010100201402","Pycc":"本科","RenShu":52,"Nv":0,"Rxsj":"2014-09-01","Xz":"四年","Bz":"无","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"正常","OrderIndex":2,"IndexID":"0101001402","ID":1332,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1501","Bjjc":"农学1501","Bjdm":"11010100201501","Pycc":"本科","RenShu":52,"Nv":0,"Rxsj":"2015-09-01","Xz":"四年","Bz":"0","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"正常","OrderIndex":4,"IndexID":"0101001501","ID":1468,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1502","Bjjc":"农学1502","Bjdm":"11010100201502","Pycc":"本科","RenShu":53,"Nv":0,"Rxsj":"2015-09-01","Xz":"四年","Bz":"0","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"正常","OrderIndex":5,"IndexID":"0101001502","ID":1469,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1601","Bjjc":"农学1601","Bjdm":"11010100201601","Pycc":"本科","RenShu":52,"Nv":0,"Rxsj":"2016-09-01","Xz":"四年","Bz":" ","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"正常","OrderIndex":6,"IndexID":"0101001601","ID":1688,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1602","Bjjc":"农学1602","Bjdm":"11010100201602","Pycc":"本科","RenShu":53,"Nv":0,"Rxsj":"2016-09-01","Xz":"四年","Bz":" ","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"正常","OrderIndex":7,"IndexID":"0101001602","ID":1689,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1701","Bjjc":"农学1701","Bjdm":"11010100201701","Pycc":"本科","RenShu":53,"Nv":0,"Rxsj":"2017-09-01","Xz":"四年","Bz":" ","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"正常","OrderIndex":8,"IndexID":"0101001701","ID":1837,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1702","Bjjc":"农学1702","Bjdm":"11010100201702","Pycc":"本科","RenShu":52,"Nv":0,"Rxsj":"2017-09-01","Xz":"四年","Bz":" ","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"正常","OrderIndex":9,"IndexID":"0101001702","ID":1838,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学0201","Bjjc":"农学0201","Bjdm":"11010100200201","Pycc":"本科","RenShu":0,"Nv":0,"Rxsj":"2002-09-01","Xz":"四年","Bz":null,"Del":0,"Jb":null,"TeacherId":"2","TeacherName":"魏玲","State":"已毕业","OrderIndex":10000,"IndexID":"0","ID":180,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学0301","Bjjc":"农学0301","Bjdm":"11010100200301","Pycc":"本科","RenShu":0,"Nv":0,"Rxsj":"2003-09-01","Xz":"四年","Bz":null,"Del":0,"Jb":null,"TeacherId":"2","TeacherName":"魏玲","State":"已毕业","OrderIndex":10000,"IndexID":"0","ID":90,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学0401","Bjjc":"农学0401","Bjdm":"11010100200401","Pycc":"本科","RenShu":0,"Nv":0,"Rxsj":"2004-09-01","Xz":"四年","Bz":null,"Del":0,"Jb":null,"TeacherId":"2","TeacherName":"魏玲","State":"已毕业","OrderIndex":10000,"IndexID":"0","ID":101,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学0501","Bjjc":"农学0501","Bjdm":"11010100200501","Pycc":"本科","RenShu":0,"Nv":0,"Rxsj":"2005-09-01","Xz":"四年","Bz":null,"Del":0,"Jb":null,"TeacherId":"2","TeacherName":"魏玲","State":"已毕业","OrderIndex":10000,"IndexID":"0","ID":386,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学0601","Bjjc":"农学0601","Bjdm":"11010100200601","Pycc":"本科","RenShu":0,"Nv":0,"Rxsj":"2006-09-01","Xz":"四年","Bz":null,"Del":0,"Jb":null,"TeacherId":"2","TeacherName":"魏玲","State":"已毕业","OrderIndex":10000,"IndexID":"0","ID":415,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学0701","Bjjc":"农学0701","Bjdm":"11010100200701","Pycc":"本科","RenShu":0,"Nv":0,"Rxsj":"2007-09-01","Xz":"四年","Bz":null,"Del":0,"Jb":null,"TeacherId":"2","TeacherName":"魏玲","State":"已毕业","OrderIndex":10000,"IndexID":"0","ID":454,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学0801","Bjjc":"农学0801","Bjdm":"11010100200801","Pycc":"本科","RenShu":54,"Nv":12,"Rxsj":"2008-09-01","Xz":"四年","Bz":null,"Del":0,"Jb":null,"TeacherId":"2","TeacherName":"魏玲","State":"已毕业","OrderIndex":10000,"IndexID":"0","ID":606,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学0901","Bjjc":"农学0901","Bjdm":"11010100200901","Pycc":"本科","RenShu":45,"Nv":14,"Rxsj":"2009-09-01","Xz":"四年","Bz":null,"Del":0,"Jb":null,"TeacherId":"2","TeacherName":"魏玲","State":"已毕业","OrderIndex":10000,"IndexID":"0","ID":1,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学0902","Bjjc":"农学0902","Bjdm":"11010100200902","Pycc":"本科","RenShu":48,"Nv":16,"Rxsj":"2009-09-01","Xz":"四年","Bz":null,"Del":0,"Jb":null,"TeacherId":"2","TeacherName":"魏玲","State":"已毕业","OrderIndex":10000,"IndexID":"0","ID":2,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1001","Bjjc":"农学1001","Bjdm":"11010100201001","Pycc":"本科","RenShu":47,"Nv":12,"Rxsj":"2010-09-01","Xz":"四年","Bz":"0","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"已毕业","OrderIndex":10000,"IndexID":"01-01","ID":733,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1002","Bjjc":"农学1002","Bjdm":"11010100201002","Pycc":"本科","RenShu":45,"Nv":11,"Rxsj":"2010-09-01","Xz":"四年","Bz":"无","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"已毕业","OrderIndex":10000,"IndexID":"01-02","ID":734,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1101","Bjjc":"农学1101","Bjdm":"11010100201101","Pycc":"本科","RenShu":49,"Nv":12,"Rxsj":"2011-09-01","Xz":"四年","Bz":"0","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"已毕业","OrderIndex":10000,"IndexID":"9","ID":849,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1102","Bjjc":"农学1102","Bjdm":"11010100201102","Pycc":"本科","RenShu":48,"Nv":12,"Rxsj":"2011-09-01","Xz":"四年","Bz":"0","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"已毕业","OrderIndex":10000,"IndexID":"9","ID":850,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1201","Bjjc":"农学1201","Bjdm":"11010100201201","Pycc":"本科","RenShu":45,"Nv":19,"Rxsj":"2012-09-01","Xz":"四年","Bz":"无","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"已毕业","OrderIndex":10000,"IndexID":"01011201","ID":1001,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1202","Bjjc":"农学1202","Bjdm":"11010100201202","Pycc":"本科","RenShu":46,"Nv":19,"Rxsj":"2012-09-01","Xz":"四年","Bz":"无","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"已毕业","OrderIndex":10000,"IndexID":"01011202","ID":1002,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1301","Bjjc":"农学1301","Bjdm":"11010100201301","Pycc":"本科","RenShu":41,"Nv":14,"Rxsj":"2013-09-01","Xz":"四年","Bz":"无","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"已毕业","OrderIndex":10000,"IndexID":"0111301","ID":1196,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1302","Bjjc":"农学1302","Bjdm":"11010100201302","Pycc":"本科","RenShu":45,"Nv":17,"Rxsj":"2013-09-01","Xz":"四年","Bz":"无","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"已毕业","OrderIndex":10000,"IndexID":"0111302","ID":1197,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0},{"Dwdm":"1101","Dwmc":"农学院","Zydm":"11010100","Zymc":"农学","Zyfx":"无","Bjmc":"农学1303","Bjjc":"农学1303","Bjdm":"11010100201303","Pycc":"本科","RenShu":44,"Nv":16,"Rxsj":"2013-09-01","Xz":"四年","Bz":"无","Del":0,"Jb":null,"TeacherId":"0","TeacherName":null,"State":"已毕业","OrderIndex":10000,"IndexID":"0111303","ID":1198,"SetField":",[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]","OrderBy":null,"limit":0,"start":0}]
     * OtherData : null
     * totalCount : 26
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
         * Dwdm : 1101
         * Dwmc : 农学院
         * Zydm : 11010100
         * Zymc : 农学
         * Zyfx : 无
         * Bjmc : 农学1401
         * Bjjc : 农学1401
         * Bjdm : 11010100201401
         * Pycc : 本科
         * RenShu : 52
         * Nv : 0
         * Rxsj : 2014-09-01
         * Xz : 四年
         * Bz : 无
         * Del : 0
         * Jb : null
         * TeacherId : 0
         * TeacherName : null
         * State : 正常
         * OrderIndex : 1
         * IndexID : 0101001401
         * ID : 1331
         * SetField : ,[Bjdm],[Bjjc],[Bjmc],[Bz],[ID],[Del],[Dwdm],[Dwmc],[Nv],[Pycc],[RenShu],[Rxsj],[TeacherId],[TeacherName],[Xz],[Zydm],[Zyfx],[Zymc],[State]
         * OrderBy : null
         * limit : 0
         * start : 0
         */

        private String Dwdm;
        private String Dwmc;
        private String Zydm;
        private String Zymc;
        private String Zyfx;
        private String Bjmc;
        private String Bjjc;
        private String Bjdm;
        private String Pycc;
        private int RenShu;
        private int Nv;
        private String Rxsj;
        private String Xz;
        private String Bz;
        private int Del;
        private Object Jb;
        private String TeacherId;
        private String TeacherName;
        private String State;
        private int OrderIndex;
        private String IndexID;
        private int ID;
        private String SetField;
        private Object OrderBy;
        private int limit;
        private int start;

        @JsonProperty("Dwdm")
        public String getDwdm() {
            return Dwdm;
        }

        public void setDwdm(String Dwdm) {
            this.Dwdm = Dwdm;
        }

        @JsonProperty("Dwmc")
        public String getDwmc() {
            return Dwmc;
        }

        public void setDwmc(String Dwmc) {
            this.Dwmc = Dwmc;
        }

        @JsonProperty("Zydm")
        public String getZydm() {
            return Zydm;
        }

        public void setZydm(String Zydm) {
            this.Zydm = Zydm;
        }

        @JsonProperty("Zymc")
        public String getZymc() {
            return Zymc;
        }

        public void setZymc(String Zymc) {
            this.Zymc = Zymc;
        }

        @JsonProperty("Zyfx")
        public String getZyfx() {
            return Zyfx;
        }

        public void setZyfx(String Zyfx) {
            this.Zyfx = Zyfx;
        }

        @JsonProperty("Bjmc")
        public String getBjmc() {
            return Bjmc;
        }

        public void setBjmc(String Bjmc) {
            this.Bjmc = Bjmc;
        }

        @JsonProperty("Bjjc")
        public String getBjjc() {
            return Bjjc;
        }

        public void setBjjc(String Bjjc) {
            this.Bjjc = Bjjc;
        }

        @JsonProperty("Bjdm")
        public String getBjdm() {
            return Bjdm;
        }

        public void setBjdm(String Bjdm) {
            this.Bjdm = Bjdm;
        }

        @JsonProperty("Pycc")
        public String getPycc() {
            return Pycc;
        }

        public void setPycc(String Pycc) {
            this.Pycc = Pycc;
        }

        @JsonProperty("RenShu")
        public int getRenShu() {
            return RenShu;
        }

        public void setRenShu(int RenShu) {
            this.RenShu = RenShu;
        }

        @JsonProperty("Nv")
        public int getNv() {
            return Nv;
        }

        public void setNv(int Nv) {
            this.Nv = Nv;
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

        @JsonProperty("Bz")
        public String getBz() {
            return Bz;
        }

        public void setBz(String Bz) {
            this.Bz = Bz;
        }

        @JsonProperty("Del")
        public int getDel() {
            return Del;
        }

        public void setDel(int Del) {
            this.Del = Del;
        }

        @JsonProperty("Jb")
        public Object getJb() {
            return Jb;
        }

        public void setJb(Object Jb) {
            this.Jb = Jb;
        }

        @JsonProperty("TeacherId")
        public String getTeacherId() {
            return TeacherId;
        }

        public void setTeacherId(String TeacherId) {
            this.TeacherId = TeacherId;
        }

        @JsonProperty("TeacherName")
        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }

        @JsonProperty("State")
        public String getState() {
            return State;
        }

        public void setState(String State) {
            this.State = State;
        }

        @JsonProperty("OrderIndex")
        public int getOrderIndex() {
            return OrderIndex;
        }

        public void setOrderIndex(int OrderIndex) {
            this.OrderIndex = OrderIndex;
        }

        @JsonProperty("IndexID")
        public String getIndexID() {
            return IndexID;
        }

        public void setIndexID(String IndexID) {
            this.IndexID = IndexID;
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

        public JxauClassInfo toClassInfo() {
            JxauClassInfo classInfo = new JxauClassInfo();
            classInfo.setCode(getBjdm());
            classInfo.setClassAbbr(getBjjc());
            classInfo.setClassName(getBjmc());
            classInfo.setStuCount(getRenShu());
            classInfo.setTeacherName(getTeacherName());
            classInfo.setGirlCount(getNv());
            classInfo.setStartTime(DateUtils.parseDate(getRxsj()));
            classInfo.setTeacherCode(getTeacherId());
            return classInfo;
        }
    }
}
