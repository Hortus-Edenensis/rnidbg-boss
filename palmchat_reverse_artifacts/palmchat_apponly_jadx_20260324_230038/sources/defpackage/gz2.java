package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.circle.app.keep.model.KeepMotionParam;
import com.zenmen.palmchat.circle.app.keep.model.KeepShareData;
import com.zenmen.palmchat.circle.app.keep.model.KeepTrainData;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class gz2 {
    public static String a(String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        String str5 = str2 + " 用时" + str4;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(str);
            try {
                jSONObject.put("subject", str5);
                jSONObject.put("authorName", str3);
            } catch (JSONException e) {
                e = e;
                jSONObject2 = jSONObject;
                e.printStackTrace();
                jSONObject = jSONObject2;
            }
        } catch (JSONException e2) {
            e = e2;
        }
        return jSONObject == null ? str : jSONObject.toString();
    }

    public static KeepShareData b(KeepTrainData keepTrainData, String str, String str2) {
        KeepShareData keepShareData = new KeepShareData();
        keepShareData.trainData = keepTrainData;
        keepShareData.appInfo = str;
        keepShareData.shareMessage = str2;
        return keepShareData;
    }

    public static KeepTrainData c(KeepMotionParam keepMotionParam, int i, String str) {
        if (keepMotionParam == null) {
            return null;
        }
        KeepTrainData keepTrainData = new KeepTrainData();
        keepTrainData.shareName = keepMotionParam.name;
        keepTrainData.count = keepMotionParam.nums;
        keepTrainData.background = keepMotionParam.cover;
        keepTrainData.lessonId = keepMotionParam.lessonId;
        keepTrainData.actId = keepMotionParam.actionId;
        keepTrainData.source = i;
        keepTrainData.time = str;
        keepTrainData.date = new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis()));
        String strP = AccountUtils.p(AppContext.getContext());
        keepTrainData.headUrl = e(bo0.r().l(strP));
        keepTrainData.userName = bo0.r().l(strP).getNickName();
        keepTrainData.repeat = "重复";
        keepTrainData.unit = "次";
        return keepTrainData;
    }

    public static KeepTrainData d(List<mz2> list, int i, int i2, String str) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        KeepTrainData keepTrainData = new KeepTrainData();
        keepTrainData.shareName = list.get(list.size() - 1).f19395a.lessonName;
        keepTrainData.count = i;
        keepTrainData.background = list.get(list.size() - 1).f19395a.cover;
        keepTrainData.lessonId = list.get(list.size() - 1).f19395a.lessonId;
        keepTrainData.actId = list.get(list.size() - 1).f19395a.actionId;
        keepTrainData.planId = list.get(list.size() - 1).f19395a.planId;
        keepTrainData.source = i2;
        keepTrainData.time = str;
        keepTrainData.date = new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis()));
        String strP = AccountUtils.p(AppContext.getContext());
        keepTrainData.headUrl = e(bo0.r().l(strP));
        keepTrainData.userName = bo0.r().l(strP).getNickName();
        keepTrainData.repeat = "动作";
        keepTrainData.unit = "组";
        return keepTrainData;
    }

    public static String e(ContactInfoItem contactInfoItem) {
        return TextUtils.isEmpty(contactInfoItem.getBigIconURL()) ? contactInfoItem.getIconURL() : contactInfoItem.getBigIconURL();
    }
}
