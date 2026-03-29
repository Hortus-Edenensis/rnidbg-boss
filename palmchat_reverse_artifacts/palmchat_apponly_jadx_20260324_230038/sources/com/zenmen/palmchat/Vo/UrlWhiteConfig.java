package com.zenmen.palmchat.Vo;

import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UrlWhiteConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<String> f12170a = new ArrayList<>();

    public UrlWhiteConfig() {
        b();
    }

    public static UrlWhiteConfig c(JSONObject jSONObject) {
        LogUtil.i("UrlWhiteConfig", "parseUrlWhiteConfig" + jSONObject);
        if (jSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("extUrlWhitelist");
            LogUtil.i("UrlWhiteConfig", "parseUrlWhiteConfig extUrlWhitelist list" + jSONArrayOptJSONArray);
            if (jSONArrayOptJSONArray == null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extUrlWhitelist");
                LogUtil.i("UrlWhiteConfig", "parseUrlWhiteConfig extUrlWhitelist obj" + jSONObjectOptJSONObject);
                if (jSONObjectOptJSONObject != null) {
                    jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("list");
                }
            }
            if (jSONArrayOptJSONArray != null) {
                UrlWhiteConfig urlWhiteConfig = new UrlWhiteConfig();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    try {
                        urlWhiteConfig.f12170a.add(jSONArrayOptJSONArray.getString(i));
                        LogUtil.i("UrlWhiteConfig", "result.urlWhiteList " + urlWhiteConfig.f12170a.get(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return urlWhiteConfig;
            }
        }
        return null;
    }

    public List<String> a() {
        return this.f12170a;
    }

    public final void b() {
    }
}
