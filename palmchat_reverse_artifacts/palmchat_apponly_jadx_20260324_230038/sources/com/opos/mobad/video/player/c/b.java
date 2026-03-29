package com.opos.mobad.video.player.c;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10302a;
    private a b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        boolean a();

        boolean a(Map<String, String> map);

        void b();

        boolean c();
    }

    public b(Map<String, String> map, a aVar) {
        this.b = aVar;
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("ad_show", "init fail", e);
                }
            }
        }
        this.f10302a = jSONObject.toString();
    }

    @JavascriptInterface
    public String getAdConfig() {
        return this.f10302a;
    }

    @JavascriptInterface
    public boolean interactReport(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("ad_show", "report fail", e);
            }
        }
        a aVar = this.b;
        if (aVar == null) {
            return false;
        }
        aVar.a(map);
        return false;
    }

    @JavascriptInterface
    public boolean onAdClick() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    @JavascriptInterface
    public boolean onClose() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.c();
        }
        return false;
    }

    @JavascriptInterface
    public void onTransform(String str) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.b();
        }
    }
}
