package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.bq;
import com.zenmen.openapi.OpenApiManager;
import com.zenmen.openapi.webapp.WebAppManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class bu3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashMap<String, Intent> f1822a;
    public boolean b;
    public String c;
    public String d;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final bu3 f1823a = new bu3();
    }

    public static bu3 g() {
        return b.f1823a;
    }

    public static HashMap<String, String> h(String str) {
        int iIndexOf;
        String[] strArrSplit;
        HashMap<String, String> map = null;
        if (str != null && str.length() != 0 && (iIndexOf = str.indexOf(63)) >= 0 && (strArrSplit = str.substring(iIndexOf + 1).split(ContainerUtils.FIELD_DELIMITER)) != null && strArrSplit.length > 0) {
            map = new HashMap<>();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (strArrSplit2 != null && strArrSplit2.length == 2) {
                    try {
                        map.put(strArrSplit2[0], URLDecoder.decode(strArrSplit2[1], "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return map;
    }

    public static Bundle i(String str) {
        HashMap<String, String> mapH = h(str);
        if (mapH == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : mapH.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    public void a(String str, String str2, Intent intent) {
        this.f1822a.put(String.format("%s/%s/%s", "innerapp", str, str2), intent);
    }

    public void b(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setClassName(OpenApiManager.getContext(), str3);
        a(str, str2, intent);
    }

    public void c() {
        Intent intent = new Intent();
        intent.setClassName(OpenApiManager.getContext(), "com.zenmen.openapi.webapp.MainActivity");
        intent.addFlags(268435456);
        d(intent);
    }

    public void d(Intent intent) {
        this.f1822a.put("webapp", intent);
    }

    public Intent e(Context context, String str) {
        ma3.a("canHandle:" + str, new Object[0]);
        Intent intentK = k(context, str, false);
        ma3.a("res intent:" + intentK, new Object[0]);
        return intentK;
    }

    public Intent f(Context context, String str, boolean z) {
        ma3.a("canHandle:" + str, new Object[0]);
        Intent intentK = k(context, str, z);
        ma3.a("res intent:" + intentK, new Object[0]);
        return intentK;
    }

    public boolean j(Context context, String str) {
        ma3.a("go:" + str, new Object[0]);
        Intent intentK = k(context, str, false);
        ma3.a("res intent:" + intentK, new Object[0]);
        if (intentK != null) {
            try {
                context.startActivity(intentK);
                return true;
            } catch (Exception e) {
                ma3.c(e);
            }
        }
        return false;
    }

    public final Intent k(Context context, String str, boolean z) {
        String str2;
        Intent value = null;
        if (str == null || str.length() == 0 || !str.startsWith(this.d)) {
            ma3.d("Invalid Url");
            return null;
        }
        String strSubstring = str.substring(this.d.length());
        Iterator<Map.Entry<String, Intent>> it = this.f1822a.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Intent> next = it.next();
            if (strSubstring.startsWith(next.getKey())) {
                value = next.getValue();
                Bundle bundleI = i(strSubstring);
                if (bundleI == null) {
                    bundleI = new Bundle();
                }
                value.replaceExtras(bundleI);
                if (!this.b && (str2 = this.c) != null && str2.length() > 0) {
                    Intent intent = new Intent();
                    intent.setClassName(context, this.c);
                    intent.putExtra(bq.f.L, value);
                    return intent;
                }
                ComponentName component = value.getComponent();
                if (component != null && "com.zenmen.openapi.webapp.MainActivity".equals(component.getClassName())) {
                    if (WebAppManager.isInnerApp(bundleI.getString("appId"))) {
                        Intent intent2 = new Intent(value);
                        intent2.setFlags(0);
                        intent2.putExtra("back2MainTab", z);
                        intent2.setClassName(OpenApiManager.getContext(), "com.zenmen.openapi.webapp.WebAppCenterActivity");
                        return intent2;
                    }
                    if (z) {
                        Intent intent3 = new Intent(value);
                        intent3.addFlags(268435456);
                        intent3.putExtra("back2MainTab", true);
                        intent3.setClassName(OpenApiManager.getContext(), component.getClassName());
                        return intent3;
                    }
                }
            }
        }
        return value;
    }

    public final void l() {
        c();
        b("lxed7e31ca58cc4def", "openApiTest", "com.zenmen.openapi.test.OpenApiTestAct");
    }

    public bu3() {
        this.d = "zenxin://";
        this.f1822a = new LinkedHashMap<>();
        l();
    }
}
