package com.zenmen.palmchat.Vo;

import com.lantern.auth.server.WkParams;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GreetConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, List<Word>> f12152a = new HashMap<>();
    public static HashMap<String, List<Word>> b = new HashMap<>();
    public static HashMap<String, List<Word>> c = new HashMap<>();
    public static String d;
    public static String e;

    /* JADX INFO: compiled from: SearchBox */
    public static class Word {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12153a;
        public String b;

        public Word(String str, String str2) {
            this.f12153a = str;
            this.b = str2;
        }
    }

    public static GreetConfig d(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        LogUtil.i("GreetConfig", "parseGreetConfig" + jSONObject);
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("dictConfig")) == null) {
            return null;
        }
        f12152a.clear();
        b.clear();
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("friendRequests");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject2.optString(WkParams.LANG);
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("words");
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    arrayList.add(new Word(jSONArrayOptJSONArray2.optJSONObject(i2).optString("reportType"), jSONArrayOptJSONArray2.optJSONObject(i2).optString("word")));
                }
                f12152a.put(strOptString, arrayList);
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("greetings");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i3);
                if (jSONObjectOptJSONObject3 != null) {
                    String strOptString2 = jSONObjectOptJSONObject3.optString(WkParams.LANG);
                    JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject3.optJSONArray("words");
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                        arrayList2.add(new Word(jSONArrayOptJSONArray4.optJSONObject(i4).optString("reportType"), jSONArrayOptJSONArray4.optJSONObject(i4).optString("word")));
                    }
                    b.put(strOptString2, arrayList2);
                }
            }
        }
        JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("recommendRequests");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray5.optJSONObject(i5);
                String strOptString3 = jSONObjectOptJSONObject4.optString(WkParams.LANG);
                JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject4.optJSONArray("words");
                ArrayList arrayList3 = new ArrayList();
                for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                    arrayList3.add(new Word(jSONArrayOptJSONArray6.optJSONObject(i6).optString("reportType"), jSONArrayOptJSONArray6.optJSONObject(i6).optString("word")));
                }
                if (jSONArrayOptJSONArray6.length() > 0) {
                    c.put(strOptString3, arrayList3);
                }
            }
        }
        d = jSONObjectOptJSONObject.optString("realNameContent");
        e = jSONObjectOptJSONObject.optString("realNameDes");
        return null;
    }

    public List<Word> a() {
        HashMap<String, List<Word>> map = c;
        if (map == null || map.size() == 0 || !Locale.getDefault().getLanguage().toString().equals("zh")) {
            return null;
        }
        return c.get(Locale.getDefault().getLanguage().toString());
    }

    public List<Word> b() {
        HashMap<String, List<Word>> map = f12152a;
        if (map == null || map.size() == 0 || !Locale.getDefault().getLanguage().toString().equals("zh")) {
            return null;
        }
        return f12152a.get(Locale.getDefault().getLanguage().toString());
    }

    public List<Word> c() {
        HashMap<String, List<Word>> map = b;
        if (map == null || map.size() == 0 || !Locale.getDefault().getLanguage().toString().equals("zh")) {
            return null;
        }
        return b.get(Locale.getDefault().getLanguage().toString());
    }
}
