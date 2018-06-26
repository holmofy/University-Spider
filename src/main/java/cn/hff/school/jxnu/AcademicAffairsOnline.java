package cn.hff.school.jxnu;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.hff.entity.Gender;
import cn.hff.entity.JxnuStudentInfo;
import cn.hff.entity.JxnuStudentInfo.CourseScore;
import cn.hff.http.Headers;
import static cn.hff.school.jxnu.Constants.ACADEMIC_AFFAIRS_ONLINE_SITE;
import cn.hff.util.DateUtils;
import cn.hff.util.NumberUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 江西师范大学教务在线系统
 * <p>
 * Created by Holmofy on 2018/6/26.
 */
@Slf4j
public class AcademicAffairsOnline {

    private static final String baseUrl = ACADEMIC_AFFAIRS_ONLINE_SITE;

    private static final HttpClient client = HttpClients.createDefault();

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMdd");

    public JxnuStudentInfo baseInfo() {
        String url = baseUrl + "/MyControl/Student_InforCheck.aspx";
        HttpUriRequest request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            String html = EntityUtils.toString(response.getEntity());
            Document doc = Jsoup.parse(html);
            JxnuStudentInfo studentInfo = new JxnuStudentInfo();
            studentInfo.setStuNum(doc.getElementById("lblXH").text().trim());
            studentInfo.setName(doc.getElementById("lblXM").text().trim());
            studentInfo.setClassName(doc.getElementById("lblBJ").text().trim());
            studentInfo.setCandidateNum(doc.getElementById("lblKSH").text().trim());
            studentInfo.setGender(Gender.valueOf(doc.getElementById("lblXB").text().trim()));
            studentInfo.setEthnic(doc.getElementById("lblMZ").text().trim());
            studentInfo.setBirthday(DateUtils.parseDate(doc.getElementById("lblCSRQ").text().trim(), formatter));
            studentInfo.setIdCardNum(doc.getElementById("lblSFZH").text().trim());
            return studentInfo;
        } catch (IOException e) {
            log.warn("网络请求失败：" + url);
        }
        return null;
    }

    public boolean login(String stuNum, String password) {
        String url = baseUrl + "/Default_Login.aspx";
        // ASP.NET的VIEWSTATE可以不用管
        String params = "__EVENTTARGET=&__EVENTARGUMENT=&__LASTFOCUS=" +
                "&__VIEWSTATE=%2FwEPDwUJNjk1MjA1MTY0D2QWAgIBD2QWBAIBD2QWBGYPEGRkFgFmZAIBDxAPFgYeDURhdGFUZXh0RmllbGQFDOWNleS9jeWQjeensB4ORGF0YVZhbHVlRmllbGQFCeWNleS9jeWPtx4LXyFEYXRhQm91bmRnZBAVPxjkv53ljavlpITvvIjkv53ljavpg6jvvIkJ6LSi5Yqh5aSEEui0ouaUv%2BmHkeiejeWtpumZohLln47luILlu7rorr7lrabpmaIS5Yid562J5pWZ6IKy5a2m6ZmiJ%2BWIm%2BaWsOWIm%2BS4muaVmeiCsueglOeptuS4juaMh%2BWvvOS4reW%2FgwnmoaPmoYjppoYV5Zyw55CG5LiO546v5aKD5a2m6ZmiMOWPkeWxleinhOWIkuWKnuWFrOWupO%2B8iOecgemDqOWFseW7uuWKnuWFrOWupO%2B8iQ%2Fpq5jnrYnnoJTnqbbpmaIt5Yqf6IO95pyJ5py65bCP5YiG5a2Q5pWZ6IKy6YOo6YeN54K55a6e6aqM5a6kReWbvemZheWQiOS9nOS4juS6pOa1geWkhOOAgeaVmeiCsuWbvemZheWQiOS9nOS4jueVmeWtpuW3peS9nOWKnuWFrOWupBLlm73pmYXmlZnogrLlrabpmaIw5Zu95a625Y2V57OW5YyW5a2m5ZCI5oiQ5bel56iL5oqA5pyv56CU56m25Lit5b%2BDEuWMluWtpuWMluW3peWtpumZojDln7rlu7rnrqHnkIblpITvvIjlhbHpnZLmoKHljLrlu7rorr7lip7lhazlrqTvvIkb6K6h566X5py65L%2Bh5oGv5bel56iL5a2m6ZmiEue7p%2Be7reaVmeiCsuWtpumZohvmsZ%2Fopb%2Fnu4%2FmtY7lj5HlsZXnoJTnqbbpmaIP5pWZ5biI5pWZ6IKy5aSECeaVmeWKoeWkhBjmlZnogrLmlZnlrabor4TkvLDkuK3lv4MM5pWZ6IKy5a2m6ZmiD%2BaVmeiCsueglOeptumZoh7lhpvkuovmlZnnoJTpg6jvvIjmraboo4Xpg6jvvIk556eR5oqA5Zut566h55CG5Yqe5YWs5a6k77yI56eR5oqA5Zut5Y%2BR5bGV5pyJ6ZmQ5YWs5Y%2B477yJD%2BenkeWtpuaKgOacr%2BWkhBLnp5HlrabmioDmnK%2FlrabpmaIS56a76YCA5LyR5bel5L2c5aSEG%2BWOhuWPsuaWh%2BWMluS4juaXhea4uOWtpumZohXpqazlhYvmgJ3kuLvkuYnlrabpmaIM576O5pyv5a2m6ZmiEuWFjei0ueW4iOiMg%2BeUn%2BmZojbphLHpmLPmuZbmub%2FlnLDkuI7mtYHln5%2FnoJTnqbbmlZnogrLpg6jph43ngrnlrp7pqozlrqQe6Z2S5bGx5rmW5qCh5Yy6566h55CG5Yqe5YWs5a6kCeS6uuS6i%2BWkhAzova%2Fku7blrabpmaIJ5ZWG5a2m6ZmiD%2BekvuS8muenkeWtpuWkhBLnlJ%2Flkb3np5HlrablrabpmaI%2F5biI6LWE5Z%2B56K6t5Lit5b%2BD77yI5rGf6KW%2F55yB6auY562J5a2m5qCh5biI6LWE5Z%2B56K6t5Lit5b%2BD77yJM%2BWunumqjOWupOW7uuiuvuS4jueuoeeQhuS4reW%2Fg%2BOAgeWIhuaekOa1i%2BivleS4reW%2FgxvmlbDlrabkuI7kv6Hmga%2Fnp5HlrablrabpmaIM5L2T6IKy5a2m6ZmiCeWbvuS5pummhg%2FlpJblm73or63lrabpmaIz572R57uc5YyW5pSv5pKR6L2v5Lu25Zu95a625Zu96ZmF56eR5oqA5ZCI5L2c5Z%2B65ZywD%2BaWh%2BWMlueglOeptumZognmloflrabpmaIt5peg5py66Iac5p2Q5paZ5Zu95a625Zu96ZmF56eR5oqA5ZCI5L2c5Z%2B65ZywG%2BeJqeeQhuS4jumAmuS%2FoeeUteWtkOWtpumZohjnjrDku6PmlZnogrLmioDmnK%2FkuK3lv4MM5b%2BD55CG5a2m6ZmiFeaWsOmXu%2BS4juS8oOaSreWtpumZohLkv6Hmga%2FljJblip7lhazlrqQP5a2m5oql5p2C5b%2BX56S%2BHuWtpueUn%2BWkhO%2B8iOWtpueUn%2BW3peS9nOmDqO%2B8iTznoJTnqbbnlJ%2FpmaLvvIjlrabnp5Hlu7rorr7lip7lhazlrqTjgIHnoJTnqbbnlJ%2Flt6XkvZzpg6jvvIkM6Z%2Bz5LmQ5a2m6ZmiD%2BaLm%2BeUn%2BWwseS4muWkhAzmlL%2Fms5XlrabpmaIP6LWE5Lqn566h55CG5aSEHui1hOS6p%2Be7j%2BiQpeaciemZkOi0o%2BS7u%2BWFrOWPuBU%2FCDE4MCAgICAgCDE3MCAgICAgCDY4MDAwICAgCDYzMDAwICAgCDgyMDAwICAgCDg5MDAwICAgCDEwOSAgICAgCDQ4MDAwICAgCDEzNiAgICAgCDEzMCAgICAgCEswMzAwICAgCDE2MCAgICAgCDY5MDAwICAgCDM2NSAgICAgCDYxMDAwICAgCDE0NCAgICAgCDYyMDAwICAgCDQ1MCAgICAgCDMyNCAgICAgCDI1MCAgICAgCDI0MDAwICAgCDM2MiAgICAgCDUwMDAwICAgCDM5MCAgICAgCDM3MDAwICAgCDEzMiAgICAgCDE0MCAgICAgCDgxMDAwICAgCDEwNCAgICAgCDU4MDAwICAgCDQ2MDAwICAgCDY1MDAwICAgCDU3MDAwICAgCDMyMCAgICAgCDQwMiAgICAgCDE1MCAgICAgCDY3MDAwICAgCDU0MDAwICAgCDM2MCAgICAgCDY2MDAwICAgCDMxMCAgICAgCDEwNiAgICAgCDU1MDAwICAgCDU2MDAwICAgCDI5MCAgICAgCDUyMDAwICAgCDMwMCAgICAgCDM1MCAgICAgCDUxMDAwICAgCDM4MDAwICAgCDYwMDAwICAgCDM2MSAgICAgCDQ5MDAwICAgCDY0MDAwICAgCDMwNCAgICAgCDQyMCAgICAgCDExMCAgICAgCDE5MCAgICAgCDUzMDAwICAgCDQ0MCAgICAgCDU5MDAwICAgCDg3MDAwICAgCDMzMCAgICAgFCsDP2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2RkAgMPDxYCHgdWaXNpYmxlaGRkGAEFHl9fQ29udHJvbHNSZXF1aXJlUG9zdEJhY2tLZXlfXxYBBQpSZW1lbmJlck1lmRh7bC86%2F0gpGiZdCeee6krhnUmsXvRBN2NgKiOAsLI%3D&__EVENTVALIDATION=%2FwEWSgLwtPqZDgLr6%2B%2FkCQK3yfbSBAKDspbeCQL21fViApC695MMAsjQmpEOAsjQpo4OAv3S2u0DAv3S9t4DAqPW8tMDAqPW3ugDArWVmJEHAr%2FR2u0DAqrwhf4KAsjQtoIOAuHY1soHAsjQooMOAv3S3ugDArfW7mMC%2FdL%2B0AMCvJDK9wsC%2FdLy0wMCr9GugA4C8pHSiQwC6dGugA4C%2BdHq0QMChLCSig0C3NH61QMCjtCenA4CntDm2gMCxrDmjQ0CyNCqhQ4Co9b%2B0AMCvJDaiwwC3NHa7QMCv9Hi3wMC%2FdLu3AMC3NHm2gMCjtCyhw4CpbHqgA0CyNCugA4C%2FdLm2gMC3NHq0QMCjtCigw4C%2FdLi3wMCjtC%2BhA4CqvCJ9QoC3NHu3AMC3NHi3wMC6dGenA4C3NHy0wMCjtC6mQ4CjtCugA4C3NH%2B0AMCntDa7QMC%2FdL61QMCw5bP%2FgICv9He6AMC%2FdLq0QMC8pHaiwwCr9Gyhw4CyNC%2BhA4CyNCenA4C3NH23gMCr9GqhQ4C3NHe6AMCo9bm2gMCjtC2gg4C%2BeuUqg4C2tqumwgC0sXgkQ8CuLeX%2BQECj8jxgApF%2F%2Bi5q0uHVrBvAB7amIg23y7jCc1hDr4AP324ybMZtg%3D%3D" +
                "&rblUserType=Student" +
                "&ddlCollege=180+++++" +
                "&StuNum=" + stuNum +
                "&TeaNum=" +
                "&Password=" + password +
                "&login=%E7%99%BB%E5%BD%95";
        HttpUriRequest request = RequestBuilder.post(url)
                .addHeader(Headers.USER_AGENT)
                .setEntity(new StringEntity(params, ContentType.APPLICATION_FORM_URLENCODED))
                .build();
        try {
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            // 登录成功后会重定向到/student/Index.aspx页面
            EntityUtils.consume(response.getEntity());
            return statusCode == HttpStatus.SC_MOVED_TEMPORARILY;
        } catch (IOException e) {
            log.info("网络请求失败,学号：{},密码：{}", stuNum, password);
        }
        return false;
    }

    public String photoUrl(String stuNum) {
        return baseUrl + "/StudentPhoto/" + stuNum + ".jpg";
    }

    public Map<String, List<CourseScore>> getCourseScore() {
        String url = baseUrl + "/MyControl/All_Display.aspx?UserControl=xfz_cj.ascx&Action=Personal";
        HttpUriRequest request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            String html = EntityUtils.toString(response.getEntity());
            Document doc = Jsoup.parse(html);
            Element table = doc.getElementById("_ctl11_dgContent");
            Elements trs = table.getElementsByTag("tr");
            Elements spanTds = trs.select("rowspan");
            int[] rowspans = spanTds.stream().map(e -> e.attr("rowspan")).mapToInt(Integer::valueOf).toArray();
            // 去除标题栏
            List<Element> elements = trs.subList(1, trs.size());
            int skipRow = 0;
            Map<String, List<CourseScore>> map = new HashMap<>(rowspans.length);
            for (int i = 0; i < rowspans.length; i++) {
                // 取出rowspan列也就是时间列
                String time = elements.get(skipRow).child(0).text().trim();
                // 取出n列并转成CourseScore对象，其中n等于rowspan跨越的行
                List<CourseScore> scores = elements.stream().skip(skipRow).limit(rowspans[i]).map(e -> {
                    CourseScore courseScore = new CourseScore();
                    courseScore.setRemark(e.child(e.childNodeSize()).text().trim());
                    courseScore.setStandardScore(NumberUtils.safeParseDouble(e.child(e.childNodeSize() - 1).text().trim()));
                    courseScore.setSecondGrade(NumberUtils.safeParseInteger(e.child(e.childNodeSize() - 2).text().trim()));
                    courseScore.setGrade(NumberUtils.safeParseInteger(e.child(e.childNodeSize() - 3).text().trim()));
                    courseScore.setCredit(NumberUtils.safeParseInteger(e.child(e.childNodeSize() - 4).text().trim()));
                    courseScore.setCourseName(e.child(e.childNodeSize() - 5).text().trim());
                    courseScore.setCourseId(NumberUtils.safeParseInteger(e.child(e.childNodeSize() - 5).text().trim()));
                    return courseScore;
                }).collect(Collectors.toList());
                skipRow += rowspans[i];
                map.put(time, scores);
            }
            return map;
        } catch (IOException e) {
            log.info("网络请求失败", e);
        }
        return null;
    }
}
