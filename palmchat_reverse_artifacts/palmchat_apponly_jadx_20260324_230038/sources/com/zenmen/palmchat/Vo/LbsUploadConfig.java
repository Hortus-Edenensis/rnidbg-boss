package com.zenmen.palmchat.Vo;

import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LbsUploadConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12157a = true;
    public long b = 21600000;
    public boolean c = true;
    public ArrayList<String> d = new ArrayList<>();

    public LbsUploadConfig() {
        a();
    }

    public static LbsUploadConfig b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        LogUtil.i("LbsUploadConfig", "parseLogConfig" + jSONObject);
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("lbsConfig")) == null) {
            return null;
        }
        LbsUploadConfig lbsUploadConfig = new LbsUploadConfig();
        lbsUploadConfig.f12157a = jSONObjectOptJSONObject.optBoolean("enable", true);
        lbsUploadConfig.b = jSONObjectOptJSONObject.optLong("uploadIntervalInSec", 21600L) * 1000;
        lbsUploadConfig.c = jSONObjectOptJSONObject.optBoolean("showFakeBadge", true);
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("matchedChannels");
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    arrayList.add(jSONArrayOptJSONArray.getString(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        lbsUploadConfig.d = arrayList;
        LogUtil.i("LbsUploadConfig", "result.autoFriendApplyEnabled " + lbsUploadConfig.f12157a);
        return lbsUploadConfig;
    }

    public final void a() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.d = arrayList;
        arrayList.add("*");
    }
}
