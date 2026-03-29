package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class pf2 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f20006a;
        public String b;

        public a(String str, String str2) {
            this.f20006a = str;
            this.b = str2;
        }
    }

    public static ArrayList<a> a() {
        ArrayList<a> arrayList = new ArrayList<>();
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.WEBURLLIST);
        if (dynamicConfig != null && dynamicConfig.isEnable()) {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    JSONArray jSONArray = new JSONObject(extra).getJSONArray("webUrlList");
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string = jSONObject.getString("pattern");
                            String string2 = jSONObject.getString("icon_url");
                            if (string != null && string2 != null) {
                                arrayList.add(new a(string, string2));
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (a aVar : a()) {
            if (str.indexOf(aVar.f20006a) >= 0) {
                return aVar.b;
            }
        }
        return null;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strC = zy4.c(str);
        if (TextUtils.isEmpty(strC)) {
            return false;
        }
        return strC.contains("mp.weixin.qq.com");
    }
}
