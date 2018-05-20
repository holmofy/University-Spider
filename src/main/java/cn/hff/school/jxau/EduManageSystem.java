package cn.hff.school.jxau;

import cn.hff.dto.ClassInfoDto;
import cn.hff.dto.MajorInfoDto;
import cn.hff.dto.StuRecordListDto;
import cn.hff.dto.TreeNodeDto;
import cn.hff.http.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 教务管理系统
 * http://jwgl.jxau.edu.cn
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
public class EduManageSystem {

    private static final Log log = LogFactory.getLog(EduManageSystem.class);

    private static final HttpClient client = HttpClients.createDefault();

    private static final String baseUrl = Constants.EDU_MANAGE_SITE;

    private static final ObjectMapper mapper = new ObjectMapper();

    public InputStream getStudentImage(String stuNum) {
        String url = "http://codb.jxau.edu.cn/User/GetOnePhotoByCode/?Code=" + stuNum;
        return HttpUtils.get(url);
    }

    /**
     * 根据班级号查询所有学生信息
     * <pre>
     * POST http://jwgl.jxau.edu.cn/XueJiManage/XueJiManage/GetXueJiList/655887b7-a988-49f2-8a31-e5e338a6d15a
     * bjdm=11060400201401&start=0&limit=100&sort=Xjzt&dir=ASC
     * </pre>
     *
     * @param classInfo 班级号
     */
    public StuRecordListDto getStudentsByClass(String classInfo, String uuidToken) {
        String url = baseUrl + "/XueJiManage/XueJiManage/GetXueJiList/" + uuidToken;
        HttpUriRequest request = RequestBuilder.post(url)
                // 两个必要参数
                .addParameter("bjdm", classInfo)
                .addParameter("limit", "100")
                .build();
        try {
            HttpResponse response = client.execute(request);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                String json = EntityUtils.toString(response.getEntity());
                return mapper.readValue(json, StuRecordListDto.class);
            }
        } catch (IOException e) {
            log.warn("网络请求失败", e);
        }
        return null;
    }

    /**
     * 根据专业号查询班级
     *
     * @param majorCode 专业号
     */
    public ClassInfoDto getClassInfoByMajor(String majorCode, String uuidToken) {
        String url = baseUrl + "/XueJiManage/XueJiManage/ClassList/" + uuidToken;
        HttpUriRequest request = RequestBuilder.post(url)
                // 两个必要参数
                .addParameter("nodeid", majorCode)
                .addParameter("limit", "10000")
                .build();
        try {
            HttpResponse response = client.execute(request);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                String json = EntityUtils.toString(response.getEntity());
                return mapper.readValue(json, ClassInfoDto.class);
            }
        } catch (IOException e) {
            log.warn("网络请求失败", e);
        }
        return null;
    }

    /**
     * 根据学院编号获取专业信息
     *
     * @param departmentId 学院号
     */
    public MajorInfoDto getMajorInfoByDepartment(String departmentId, String uuidToken) {
        String url = baseUrl + "/XueJiManage/XueJiManage/GetProfessionalListPaging/" + uuidToken;
        HttpUriRequest request = RequestBuilder.post(url)
                // 两个必要参数
                .addParameter("Dwdm", departmentId)
                .addParameter("limit", "1000")
                .build();
        try {
            HttpResponse response = client.execute(request);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                String json = EntityUtils.toString(response.getEntity());
                return mapper.readValue(json, MajorInfoDto.class);
            }
        } catch (IOException e) {
            log.warn("网络请求失败", e);
        }
        return null;
    }

    /**
     * 获取院系或专业或班级
     * <pre>
     * treeroot
     * |--院系
     * |---|---专业
     * |---|---|---班级
     * </pre>
     *
     * @param nodeId 院系、专业编号或"treeroot"
     */
    public List<TreeNodeDto> getDepartmentOrMajor(String nodeId, String uuidToken) {
        String url = baseUrl + "/Common/BaseData/GetTreeListForCetCj/" + uuidToken;
        HttpUriRequest request = RequestBuilder.post(url)
                // 两个必要参数
                .addParameter("parentId", nodeId)
                .build();
        try {
            HttpResponse response = client.execute(request);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                String json = EntityUtils.toString(response.getEntity());
                CollectionType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, TreeNodeDto.class);
                return mapper.readValue(json, type);
            }
        } catch (IOException e) {
            log.warn("网络请求失败", e);
        }
        return null;
    }

    private static final String username = "20142529";

    private static final String password = "23493x";

    public String login() {
        String url = baseUrl + "/User/CheckLogin";
        HttpUriRequest request = RequestBuilder.post(url)
                // 两个必要参数
                .addParameter("UserName", username)
                .addParameter("PassWord", password)
                // 第一次登陆成功不需要验证码
                .addParameter("validation", "")
                .build();
        try {
            HttpResponse response = client.execute(request);
            if (HttpStatus.SC_MOVED_TEMPORARILY == response.getStatusLine().getStatusCode()) {
                EntityUtils.consume(response.getEntity());
                // 重定向地址中会包含一个UUID
                // /Main/Index/41d47c73-c764-4312-ad3f-3fc95d880ba5
                Header header = response.getHeaders("Location")[0];
                String location = header.getValue();
                return location.substring(location.lastIndexOf('/') + 1);
            }
        } catch (IOException e) {
            log.warn("网络请求失败", e);
        }
        return null;
    }
}
