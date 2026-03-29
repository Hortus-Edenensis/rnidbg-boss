package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import defpackage.bo2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class su extends bo2 {
    public static HashSet<String> d = new a();
    public Context c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashSet<String> {
        public a() {
            add("ss.shengpay.com");
            add("qr.95516.com");
            add("mposprotest.shengpay.com");
            add("mpospro.shengpay.com");
            add("a.yuanyipos.com");
        }
    }

    public su(FrameworkBaseActivity frameworkBaseActivity, bo2.a aVar) {
        super(frameworkBaseActivity, aVar);
        this.c = frameworkBaseActivity;
    }

    public static List<String> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tg.lianxinapp.com");
        arrayList.add("lx1.cn");
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SCAN_WHITE_LIST);
        if (dynamicConfig == null) {
            return arrayList;
        }
        String extra = dynamicConfig.getExtra();
        if (!TextUtils.isEmpty(extra)) {
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(extra).optJSONArray("list");
                if (jSONArrayOptJSONArray != null) {
                    arrayList.clear();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        arrayList.add(jSONArrayOptJSONArray.getString(i));
                    }
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strC = zy4.c(str);
        if (TextUtils.isEmpty(strC)) {
            return false;
        }
        return d.contains(strC) || b().contains(strC);
    }

    @Override // defpackage.bo2
    public void a(String str) {
        d(this.c, str);
        this.f1790a.onFinish(true);
    }

    public final void d(Context context, String str) {
        Intent intent = new Intent();
        intent.setClass(context, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtras(bundle);
        this.c.startActivity(intent);
    }
}
