package com.bytedance.sdk.openadsdk.core.iz;

import android.text.TextUtils;
import com.bytedance.sdk.component.a.nr.b;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.gi.pn;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.u;
import com.bytedance.sdk.openadsdk.core.y.xw;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements u.nr {
    private static final String b = "com.bytedance.sdk.openadsdk.core.iz.u";
    private static final HashSet iz;
    private static HashMap<String, Long> pn;
    private static volatile u u;
    private com.bytedance.sdk.openadsdk.core.y.u fx;
    private CopyOnWriteArrayList<JSONObject> nr = new CopyOnWriteArrayList<>();

    static {
        String name = u.class.getName();
        pn = new HashMap<>();
        iz = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace", name));
    }

    private u() {
        com.bytedance.sdk.openadsdk.core.y.u uVarB = n.o().b();
        this.fx = uVarB;
        if (uVarB != null) {
            uVarB.fx(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList = this.nr;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = this.nr.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stats_list", jSONArray);
        } catch (JSONException unused) {
        }
        this.nr.clear();
        String strA = jp.a("/api/ad/union/sdk/callstack/batch/");
        xw xwVar = new xw(pn.u().nr().iz());
        xwVar.u(strA);
        xwVar.fx(jSONObject, "callstack");
        xwVar.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.iz.u.2
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                if (nrVar != null) {
                    nrVar.a();
                    nrVar.pn();
                }
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(b bVar, IOException iOException) {
                iOException.getMessage();
            }
        });
    }

    public static u fx() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
    public void nr() {
    }

    public void u(int i, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (nrVar == null) {
            return;
        }
        u(i, nrVar.b());
    }

    private boolean u(Long l) {
        return !u(new Date(), new Date(l.longValue()));
    }

    private boolean u(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    private boolean u(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Long l = pn.get(str);
            if (l != null && l.longValue() != 0) {
                if (!u(l)) {
                    return false;
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis > 0) {
                    pn.put(str, Long.valueOf(jCurrentTimeMillis));
                }
            }
            return true;
        } catch (Throwable th) {
            k.u("callstack error:" + th.getMessage());
            return true;
        }
    }

    public void u(final int i, final String str) {
        if (nr.u() && u(str)) {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            x.u(new a("callChainStatistic") { // from class: com.bytedance.sdk.openadsdk.core.iz.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.nr.add(u.this.u(i, str, stackTrace));
                    if (u.this.nr.size() < 3) {
                        return;
                    }
                    try {
                        u.this.b();
                    } catch (OutOfMemoryError unused) {
                    }
                }
            }, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject u(int i, String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", str);
            jSONObject.put("appid", n.o().c());
            jSONObject.put("app_version", jp.t());
            jSONObject.put("ad_sdk_version", d.b);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
            jSONObject.put("adtype", i);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("callstack", u(obj));
            jSONObject.put("type", "callstack");
            jSONObject.put("device_info", com.bytedance.sdk.openadsdk.core.fx.u.u(dw.getContext(), i));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private JSONArray u(Object obj) {
        JSONArray jSONArray = new JSONArray();
        if (obj == null) {
            return jSONArray;
        }
        for (StackTraceElement stackTraceElement : (StackTraceElement[]) obj) {
            if (stackTraceElement != null) {
                if (!iz.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                    String className = stackTraceElement.getClassName();
                    if (className != null && className.startsWith("android.app")) {
                        break;
                    }
                    jSONArray.put(stackTraceElement.toString());
                } else {
                    continue;
                }
            }
        }
        return jSONArray;
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
    public void u() {
        if (n.o().ja()) {
            return;
        }
        b();
    }
}
