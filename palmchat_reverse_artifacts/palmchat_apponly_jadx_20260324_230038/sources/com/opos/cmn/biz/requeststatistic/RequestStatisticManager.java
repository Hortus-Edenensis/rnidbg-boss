package com.opos.cmn.biz.requeststatistic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.lantern.auth.server.WkParams;
import com.opos.cmn.biz.requeststatistic.a;
import com.opos.cmn.biz.requeststatistic.cache.c;
import com.opos.cmn.biz.requeststatistic.cache.d;
import com.wifi.WkInitManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class RequestStatisticManager {
    private static RequestStatisticManager c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7859a;
    private InitParams b;

    private RequestStatisticManager() {
    }

    private static String b(Context context) {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static RequestStatisticManager getInstance() {
        RequestStatisticManager requestStatisticManager;
        RequestStatisticManager requestStatisticManager2 = c;
        if (requestStatisticManager2 != null) {
            return requestStatisticManager2;
        }
        synchronized (RequestStatisticManager.class) {
            if (c == null) {
                c = new RequestStatisticManager();
            }
            requestStatisticManager = c;
        }
        return requestStatisticManager;
    }

    public void init(Context context, InitParams initParams) {
        this.f7859a = context.getApplicationContext();
        d.c().a(context);
        this.b = initParams;
    }

    public void report(final StatisticEvent statisticEvent) {
        if (!a()) {
            throw new IllegalStateException("had not init yet ");
        }
        if (statisticEvent == null) {
            throw new IllegalArgumentException("event can not be null");
        }
        if (com.opos.cmn.an.f.a.a(this.f7859a)) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.RequestStatisticManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObjectA = RequestStatisticManager.this.a(statisticEvent);
                        String string = jSONObjectA.toString();
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObjectA);
                        String string2 = jSONArray.toString();
                        final c cVar = new c(string, System.currentTimeMillis());
                        d.c().a(cVar);
                        a.a(RequestStatisticManager.this.f7859a, string2, new a.b(this) { // from class: com.opos.cmn.biz.requeststatistic.RequestStatisticManager.1.1
                            @Override // com.opos.cmn.biz.requeststatistic.a.b
                            public void onFail() {
                                com.opos.cmn.an.f.a.b("RequestStatisticManager", "report request fail");
                            }

                            @Override // com.opos.cmn.biz.requeststatistic.a.b
                            public void onSuccess() {
                                d.c().b(cVar);
                                d.c().a();
                            }
                        });
                    } catch (JSONException e) {
                        com.opos.cmn.an.f.a.c("RequestStatisticManager", "request parse json fail", e);
                    }
                }
            });
        } else {
            com.opos.cmn.an.f.a.b("RequestStatisticManager", "log buried point switch is closed, cannot upload log buried point");
        }
    }

    public void reportCacheIfNeed() {
        if (!a()) {
            com.opos.cmn.an.f.a.c("RequestStatisticManager", "reportCacheIfNeed, but had not init yet");
        } else if (com.opos.cmn.an.f.a.a(this.f7859a)) {
            d.c().a();
        } else {
            com.opos.cmn.an.f.a.a("RequestStatisticManager", "log buried point switch is closed, cannot upload log buried point");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003d -> B:19:0x0044). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        String subtypeName;
        if (context != null) {
            try {
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("RequestStatisticManager", "net access fail", e);
            }
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || TextUtils.isEmpty(activeNetworkInfo.getTypeName())) {
                subtypeName = "";
            } else if ("WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
                subtypeName = activeNetworkInfo.getTypeName();
            } else if (!TextUtils.isEmpty(activeNetworkInfo.getSubtypeName())) {
                subtypeName = activeNetworkInfo.getSubtypeName();
            }
        }
        return subtypeName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(StatisticEvent statisticEvent) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("chn", statisticEvent.channel);
        jSONObject2.put(WkParams.IMEI, "");
        jSONObject2.put("pkg", this.f7859a.getPackageName());
        jSONObject2.put("svc", TextUtils.isEmpty(statisticEvent.sdkVersion) ? 2003000 : statisticEvent.sdkVersion);
        jSONObject2.put("evtId", statisticEvent.eventId);
        jSONObject2.put(WkParams.MODEL, b(this.f7859a));
        jSONObject2.put(TKDownloadReason.KSAD_TK_NET, a(this.f7859a));
        if (b.b(this.f7859a)) {
            jSONObject2.put("gaId", com.opos.cmn.g.a.b.f(this.f7859a));
        }
        jSONObject2.put(WkInitManager.sdk_bd, com.opos.cmn.biz.a.b.a(this.f7859a));
        jSONObject2.put("rn", com.opos.cmn.biz.a.d.a(this.f7859a));
        jSONObject2.put("duId", "");
        jSONObject2.put("ouId", com.opos.cmn.g.a.b.a(this.f7859a));
        jSONObject2.put("guId", "");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ct", statisticEvent.currentTime);
        jSONObject3.put("url", statisticEvent.url);
        jSONObject3.put("ret", statisticEvent.ret);
        jSONObject3.put("rt", statisticEvent.resolveTime);
        jSONObject3.put("mt", statisticEvent.maxResolveTime);
        jSONObject3.put("ext", statisticEvent.ext);
        jSONObject.put("h", jSONObject2);
        jSONObject.put(t.l, jSONObject3);
        return jSONObject;
    }

    private boolean a() {
        return (this.f7859a == null || this.b == null) ? false : true;
    }
}
