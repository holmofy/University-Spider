package cn.hff.dto;

import cn.hff.entity.JxauMajorInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * <pre>
 * POST ttp://jwgl.jxau.edu.cn/XueJiManage/XueJiManage/GetProfessionalListPaging/2615ea45-8fcc-44b4-9940-83c4b32a8ead
 * Dwdm=1101&start=0&limit=30
 * </pre>
 * Created by Holmofy on 2018/5/14.
 */
public class MajorInfoDto {


    /**
     * Message : null
     * Result : false
     * Data : [{"Zydm":"11010100","Zymc":"农学","Ywmc":"无","Zyjc":"农学","Zyfxdm":null,"Zyfx":"无","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"农学","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11010101","Zymc":"农学","Ywmc":"无","Zyjc":"农学","Zyfxdm":null,"Zyfx":"农产品安全与贸易方向","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"农学","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11010102","Zymc":"农学","Ywmc":"Agriculture","Zyjc":"农学","Zyfxdm":null,"Zyfx":"卓越方向","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"无","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11010200","Zymc":"园艺","Ywmc":"无","Zyjc":"园艺","Zyfxdm":null,"Zyfx":"无","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"园艺","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11010201","Zymc":"园艺","Ywmc":"无","Zyjc":"园艺","Zyfxdm":null,"Zyfx":"绿地建植与养护方向","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"园艺","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11010300","Zymc":"植物保护","Ywmc":"无","Zyjc":"植保","Zyfxdm":null,"Zyfx":"无","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"植物保护","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11010301","Zymc":"植物保护","Ywmc":"无","Zyjc":"植保","Zyfxdm":null,"Zyfx":"动植物检疫方向","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"植物保护","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11010400","Zymc":"农村区域发展","Ywmc":"无","Zyjc":"区发","Zyfxdm":null,"Zyfx":"无","Xw":"管理学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"农村区域发展","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11010500","Zymc":"蚕学","Ywmc":"无","Zyjc":"蚕学","Zyfxdm":null,"Zyfx":"无","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"蚕学","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11010600","Zymc":"园艺","Ywmc":"null","Zyjc":"园艺","Zyfxdm":null,"Zyfx":"观赏园艺方向","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"园艺","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11010700","Zymc":"农学","Ywmc":"无","Zyjc":"农学","Zyfxdm":null,"Zyfx":"五年制","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"五年","Pycc":"三校生","Rxnf":0,"Zslb":"秋季入学","JieShao":"无","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11010800","Zymc":"动植物检疫","Ywmc":"无","Zyjc":"植检","Zyfxdm":null,"Zyfx":"无","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"无","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11010900","Zymc":"种子科学与工程","Ywmc":"无","Zyjc":"种科","Zyfxdm":null,"Zyfx":"无","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"无","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11011000","Zymc":"园艺","Ywmc":"无","Zyjc":"园艺","Zyfxdm":null,"Zyfx":"茶学方向","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"无","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11011100","Zymc":"茶学","Ywmc":"Tea Science","Zyjc":"茶学","Zyfxdm":null,"Zyfx":"无","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"无","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0},{"Zydm":"11011200","Zymc":"惟义农学","Ywmc":"无","Zyjc":"惟义农学","Zyfxdm":null,"Zyfx":"无","Xw":"农学学士","Dwdm":"1101","Dwmc":"农学院","Xz":"四年","Pycc":"本科","Rxnf":0,"Zslb":"秋季入学","JieShao":"为进一步推动高等农林教育综合改革，提高人才培养质量，促进\u201c卓越农林人才教育培养计划\u201d项目的实施，学校决定设立\u201c惟义实验班\u201d（简称惟义班）","SetField":",[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]","OrderBy":null,"limit":0,"start":0}]
     * OtherData : null
     * totalCount : 16
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
         * Zydm : 11010100
         * Zymc : 农学
         * Ywmc : 无
         * Zyjc : 农学
         * Zyfxdm : null
         * Zyfx : 无
         * Xw : 农学学士
         * Dwdm : 1101
         * Dwmc : 农学院
         * Xz : 四年
         * Pycc : 本科
         * Rxnf : 0
         * Zslb : 秋季入学
         * JieShao : 农学
         * SetField : ,[Dwdm],[Dwmc],[JieShao],[Pycc],[Rxnf],[Xw],[Xz],[Ywmc],[Zslb],[Zydm],[Zyfx],[Zyjc],[Zymc]
         * OrderBy : null
         * limit : 0
         * start : 0
         */

        private String Zydm;
        private String Zymc;
        private String Ywmc;
        private String Zyjc;
        private Object Zyfxdm;
        private String Zyfx;
        private String Xw;
        private String Dwdm;
        private String Dwmc;
        private String Xz;
        private String Pycc;
        private int Rxnf;
        private String Zslb;
        private String JieShao;
        private String SetField;
        private Object OrderBy;
        private int limit;
        private int start;

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

        @JsonProperty("Ywmc")
        public String getYwmc() {
            return Ywmc;
        }

        public void setYwmc(String Ywmc) {
            this.Ywmc = Ywmc;
        }

        @JsonProperty("Zyjc")
        public String getZyjc() {
            return Zyjc;
        }

        public void setZyjc(String Zyjc) {
            this.Zyjc = Zyjc;
        }

        @JsonProperty("Zyfxdm")
        public Object getZyfxdm() {
            return Zyfxdm;
        }

        public void setZyfxdm(Object Zyfxdm) {
            this.Zyfxdm = Zyfxdm;
        }

        @JsonProperty("Zyfx")
        public String getZyfx() {
            return Zyfx;
        }

        public void setZyfx(String Zyfx) {
            this.Zyfx = Zyfx;
        }

        @JsonProperty("Xw")
        public String getXw() {
            return Xw;
        }

        public void setXw(String Xw) {
            this.Xw = Xw;
        }

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

        @JsonProperty("Xz")
        public String getXz() {
            return Xz;
        }

        public void setXz(String Xz) {
            this.Xz = Xz;
        }

        @JsonProperty("Pycc")
        public String getPycc() {
            return Pycc;
        }

        public void setPycc(String Pycc) {
            this.Pycc = Pycc;
        }

        @JsonProperty("Rxnf")
        public int getRxnf() {
            return Rxnf;
        }

        public void setRxnf(int Rxnf) {
            this.Rxnf = Rxnf;
        }

        @JsonProperty("Zslb")
        public String getZslb() {
            return Zslb;
        }

        public void setZslb(String Zslb) {
            this.Zslb = Zslb;
        }

        @JsonProperty("JieShao")
        public String getJieShao() {
            return JieShao;
        }

        public void setJieShao(String JieShao) {
            this.JieShao = JieShao;
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

        public JxauMajorInfo toMajorInfo() {
            JxauMajorInfo majorInfo = new JxauMajorInfo();
            majorInfo.setMajorCode(getZydm());
            majorInfo.setMajorName(getZymc());
            majorInfo.setEnglishName(getYwmc());
            majorInfo.setMajorAbbr(getZyjc());
            majorInfo.setMajorDirection(getZyfx());
            majorInfo.setDepartmentId(getDwdm());
            majorInfo.setDepartmentName(getDwmc());
            majorInfo.setDegree(getXw());
            majorInfo.setYears(getXz());
            majorInfo.setLevel(getPycc());
            majorInfo.setAdmissionType(getZslb());
            majorInfo.setDescription(getJieShao());
            return majorInfo;
        }
    }
}
