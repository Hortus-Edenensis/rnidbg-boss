package com.zenmen.palmchat.Vo;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LogConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12158a = 129600000;
    public HashMap<LogUtil.LogType, Integer> b = new HashMap<LogUtil.LogType, Integer>() { // from class: com.zenmen.palmchat.Vo.LogConfig.1
        {
            put(LogUtil.LogType.LOG_TYPE_USER_ACTION, 2);
            put(LogUtil.LogType.LOG_TYPE_BACKGROUP, 0);
            put(LogUtil.LogType.LOG_TYPE_BACKGROUP_FAIL, 0);
            put(LogUtil.LogType.LOG_TYPE_BACKGROUND_NETWORK, 2);
            put(LogUtil.LogType.LOG_TYPE_CRASH, 2);
            put(LogUtil.LogType.LOG_TYPE_USER_ACTION_IMMEDIATE, 2);
            put(LogUtil.LogType.LOG_TYPE_ANR, 1);
            put(LogUtil.LogType.LOG_TYPE_ANR_NEW, 1);
            put(LogUtil.LogType.LOG_TYPE_QA_IMPORTANT, 2);
            put(LogUtil.LogType.LOG_TYPE_QA_NORMAL, 1);
            put(LogUtil.LogType.LOG_TYPE_QA_SOCKET, 1);
            put(LogUtil.LogType.LOG_TYPE_MESSAGE_NOTIFY, 1);
            put(LogUtil.LogType.LOG_TYPE_MESSAGE_COMMON, 1);
            put(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, 1);
            put(LogUtil.LogType.LOG_TYPE_KEEPALIVE, 2);
        }
    };
    public int c = 262144;
    public int d = 600000;
    public boolean e = true;
    public int f = BaseConstants.Time.DAY;
    public List<String> g = new ArrayList();
    public Set<Integer> h = new HashSet();
    public Set<Integer> i = new HashSet();

    public static LogConfig d(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("logConfig");
            LogUtil.i("LogConfig", "parseLogConfig" + jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject != null) {
                LogConfig logConfig = new LogConfig();
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("detail");
                if (jSONObjectOptJSONObject2 != null) {
                    for (LogUtil.LogType logType : EnumSet.allOf(LogUtil.LogType.class)) {
                        if (jSONObjectOptJSONObject2.has(String.valueOf(logType.value))) {
                            logConfig.b.put(logType, Integer.valueOf(jSONObjectOptJSONObject2.optInt(String.valueOf(logType.value))));
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("decType");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        try {
                            hashSet.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i)));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                logConfig.h = hashSet;
                HashSet hashSet2 = new HashSet();
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("gzipType");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        try {
                            hashSet2.add(Integer.valueOf(jSONArrayOptJSONArray2.getInt(i2)));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                logConfig.i = hashSet2;
                String strOptString = jSONObjectOptJSONObject.optString("getMfTokenLogChannels");
                if (strOptString != null) {
                    logConfig.g = Arrays.asList(strOptString.split(","));
                }
                int iOptInt = jSONObjectOptJSONObject.optInt(RemoteMessageConst.TTL);
                if (iOptInt > 0) {
                    logConfig.f12158a = iOptInt * 60 * 60 * 1000;
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("maxFileSize");
                if (iOptInt2 > 0) {
                    logConfig.c = iOptInt2;
                }
                int iOptInt3 = jSONObjectOptJSONObject.optInt("checkUploadIntervalSec");
                if (iOptInt3 > 0) {
                    logConfig.d = iOptInt3 * 1000;
                }
                logConfig.e = jSONObjectOptJSONObject.optBoolean("allowCellularUpload", true);
                int iOptInt4 = jSONObjectOptJSONObject.optInt("tmpFileRollingIntervalSec");
                if (iOptInt4 <= 0) {
                    return logConfig;
                }
                logConfig.f = iOptInt4 * 1000;
                return logConfig;
            }
        }
        return null;
    }

    public int a(LogUtil.LogType logType) {
        Integer num = this.b.get(logType);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public boolean b(int i) {
        return this.i.contains(Integer.valueOf(i));
    }

    public boolean c() {
        return true;
    }
}
