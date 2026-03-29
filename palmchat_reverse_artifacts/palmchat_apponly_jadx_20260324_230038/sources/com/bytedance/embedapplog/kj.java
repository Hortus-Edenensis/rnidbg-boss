package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class kj extends z {
    private final List<String> iz;
    private final Map<String, h> pn;

    public kj(Context context, dw dwVar, gi giVar) {
        super(context, dwVar, giVar);
        this.pn = new HashMap();
        this.iz = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx() {
        for (Map.Entry<String, h> entry : this.pn.entrySet()) {
            if (TextUtils.equals(entry.getKey(), "d_i0")) {
                JSONObject jSONObjectNr = entry.getValue().nr();
                x xVarX = gb.x();
                if (xVarX != null && jSONObjectNr != null) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectNr.optJSONObject("data");
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        arrayList.add(itKeys.next());
                    }
                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                    int[] iArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        iArr[i] = jSONObjectOptJSONObject.optInt(strArr[i]);
                    }
                    xVarX.u(strArr, iArr, false);
                    return;
                }
            }
        }
    }

    public void nr() {
        if (this.u.size() <= 0) {
            bg.u("__kite", "return");
            return;
        }
        for (int i = 0; i < this.u.size(); i++) {
            try {
                h hVar = this.u.get(i).get();
                this.pn.put(hVar.u(), hVar);
                if (bg.nr()) {
                    bg.u("__kite", "result: ".concat(String.valueOf(hVar)));
                }
            } catch (Exception e) {
                bg.b("__kite", "error " + e.getMessage());
            }
        }
    }

    @Override // com.bytedance.embedapplog.z
    public List<String> u() {
        this.iz.add("d_i0");
        this.iz.add("d_a0");
        return this.iz;
    }

    public void u(final JSONObject jSONObject, final String str) {
        bg.u("__kite", "doReport");
        ja.u().postDelayed(new Runnable() { // from class: com.bytedance.embedapplog.kj.1
            @Override // java.lang.Runnable
            public void run() {
                bg.u("__kite", "run()");
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObjectU = gb.u(jSONObject, str);
                    String strU = kj.this.fx.u("d_data");
                    if (TextUtils.isEmpty(strU)) {
                        JSONObject jSONObject3 = new JSONObject();
                        String strNr = gb.nr(jSONObjectU);
                        jSONObject3.putOpt("header", strNr);
                        if (bg.nr()) {
                            bg.u("__kite", "config 请求header进行sword加密：加密内容：".concat(String.valueOf(jSONObjectU)));
                            bg.u("__kite", "config 请求header进行sword加密：加密结果：".concat(String.valueOf(strNr)));
                        }
                        jSONObject3.putOpt("fetch_config", Boolean.TRUE);
                        jSONObject3.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        jSONObject2 = rh.u(kj.this.nr, jSONObject3, kj.this.u(jSONObjectU));
                        bg.u("__kite", "config from server.");
                    } else {
                        jSONObject2.putOpt("message", com.igexin.push.core.b.B);
                        jSONObject2.putOpt("data", strU);
                        bg.u("__kite", "config from cache");
                    }
                    if (bg.nr()) {
                        bg.u("__kite", "config: ".concat(String.valueOf(jSONObject2)));
                    }
                    kj.this.b.u(jSONObject2);
                    kj.this.u(5L);
                    kj.this.nr();
                    kj.this.fx();
                    kj.this.nr(jSONObjectU);
                } catch (Exception e) {
                    bg.b("__kite", "error " + e.getMessage());
                }
            }
        }, this.b.fx());
    }

    public void u(long j) {
        Map<String, JSONObject> mapU = this.b.u();
        if (mapU.isEmpty()) {
            bg.u("__kite", "map is empty");
        } else {
            u(mapU, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(final JSONObject jSONObject) {
        if (this.pn.size() <= 0) {
            return;
        }
        final JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, h> entry : this.pn.entrySet()) {
            try {
                JSONObject jSONObjectNr = entry.getValue().nr();
                jSONObject2.putOpt(entry.getKey(), gb.nr(jSONObjectNr));
                if (bg.nr()) {
                    bg.u("__kite", "report 请求data中的字段进行sword加密：加密内容：".concat(String.valueOf(jSONObjectNr)));
                }
            } catch (JSONException e) {
                bg.b("__kite", "error " + e.getMessage());
            }
        }
        ja.u(new Runnable() { // from class: com.bytedance.embedapplog.kj.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject.putOpt(bt.ac, Build.MODEL);
                    jSONObject.putOpt("device_platform", "android");
                    jSONObject3.putOpt("header", gb.nr(jSONObject));
                    if (bg.nr()) {
                        bg.u("__kite", "report 请求header进行sword加密：加密内容：" + jSONObject);
                    }
                    jSONObject3.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    jSONObject3.putOpt("data", jSONObject2);
                    jSONObject3.putOpt("version", Integer.valueOf(kj.this.b.nr()));
                } catch (Exception e2) {
                    bg.u("__kite", "error: " + e2.getMessage());
                }
                JSONObject jSONObjectU = rh.u(kj.this.nr, jSONObject3, kj.this.u(jSONObject));
                if (bg.nr()) {
                    bg.fx("__kite", "response:".concat(String.valueOf(jSONObjectU)));
                }
                kj.this.b.nr(jSONObjectU);
            }
        });
    }
}
