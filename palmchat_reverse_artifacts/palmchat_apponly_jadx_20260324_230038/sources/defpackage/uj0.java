package defpackage;

import com.zenmen.palmchat.task1v1.ComplianceBoardBean;
import com.zenmen.palmchat.task1v1.CompliancePopBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class uj0 {
    public static ComplianceBoardBean a() {
        ComplianceBoardBean complianceBoardBean;
        Exception e;
        JSONObject config;
        ComplianceBoardBean complianceBoardBean2 = new ComplianceBoardBean();
        try {
            config = vs0.a().getConfig("1v1chat_comply_board");
        } catch (Exception e2) {
            complianceBoardBean = complianceBoardBean2;
            e = e2;
        }
        if (config == null) {
            return complianceBoardBean2;
        }
        complianceBoardBean = new ComplianceBoardBean();
        try {
            complianceBoardBean.mSwitch = config.optInt("switch", 0);
            complianceBoardBean.frequencyType = config.optInt("frequencyType", 2);
            List<Integer> arrayList = new ArrayList<>();
            JSONArray jSONArrayOptJSONArray = config.optJSONArray("showPosition");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
                }
            }
            Integer[] numArr = {1, 3, 7, 9, 12};
            if (arrayList.isEmpty()) {
                arrayList = Arrays.asList(numArr);
            }
            complianceBoardBean.showPosition = arrayList;
            complianceBoardBean.textPayer = config.optString("textPayer", "平台倡导绿色文明交友，请树立正确消费观、理性消费。如对方以陪玩、送礼等诱导充值、私下交易，请谨慎判断以防损失，若发现违规请举报。");
            complianceBoardBean.textProfit = config.optString("textProfit", "平台倡导绿色文明交友，不得出现违法违规、色情暴力、抹黑诋毁、污秽低俗不良行为，不得诱导充值。如有违规行为，将对账号降权、封禁处理。");
            complianceBoardBean.residentSwitch = config.optInt("residentSwitch", 2);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
        return complianceBoardBean;
        e.printStackTrace();
        return complianceBoardBean;
    }

    public static CompliancePopBean b() {
        CompliancePopBean compliancePopBean;
        Exception e;
        JSONObject config;
        try {
            config = vs0.a().getConfig("1v1chat_comply_popup");
        } catch (Exception e2) {
            compliancePopBean = null;
            e = e2;
        }
        if (config == null) {
            return null;
        }
        compliancePopBean = new CompliancePopBean();
        try {
            compliancePopBean.mSwitch = config.optInt("switch", 0);
            compliancePopBean.frequencyDays = config.optInt("frequencyDays", 7);
            compliancePopBean.bgUrl = config.optString("bgUrl");
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
        return compliancePopBean;
        e.printStackTrace();
        return compliancePopBean;
    }
}
