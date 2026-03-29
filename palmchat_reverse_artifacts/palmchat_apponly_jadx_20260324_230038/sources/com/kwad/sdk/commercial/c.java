package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.location.LocationConst;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.h;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    private static float azH = -1.0f;
    private static float azI = -1.0f;
    private static float azJ = -1.0f;
    private static float azK = -1.0f;
    private static float azL = -1.0f;
    private static float azM = -1.0f;
    private static final AtomicBoolean azN = new AtomicBoolean();
    private static final AtomicBoolean azO = new AtomicBoolean();
    private static boolean azP;
    private static volatile boolean azQ;
    private static List<d> azR;
    private static a azS;
    private static Map<String, com.kwad.sdk.commercial.c.c> azT;
    private static Map<String, com.kwad.sdk.commercial.a> azU;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        @WorkerThread
        boolean Es();

        @WorkerThread
        boolean Et();

        @WorkerThread
        JSONObject Eu();

        @WorkerThread
        JSONObject Ev();

        String Ew();

        @WorkerThread
        void j(String str, String str2, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void FC() {
        try {
            azT = new HashMap();
            JSONObject jSONObjectEu = azS.Eu();
            if (jSONObjectEu == null) {
                return;
            }
            Iterator<String> itKeys = jSONObjectEu.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObjectEu.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    a(next, jSONObjectOptJSONObject.optJSONArray("ratio"));
                    b(next, jSONObjectOptJSONObject.optJSONArray("ratioApmRL"));
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void FD() {
        try {
            azU = new HashMap();
            JSONObject jSONObjectEv = azS.Ev();
            if (jSONObjectEv == null) {
                return;
            }
            Iterator<String> itKeys = jSONObjectEv.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObjectEv.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    com.kwad.sdk.commercial.a aVar = new com.kwad.sdk.commercial.a();
                    aVar.parseJson(jSONObjectOptJSONObject);
                    azU.put(next, aVar);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static synchronized void a(final a aVar, final boolean z) {
        if (azP) {
            return;
        }
        azP = true;
        azS = aVar;
        h.execute(new bg() { // from class: com.kwad.sdk.commercial.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    c.b(aVar, z);
                    c.FC();
                    c.FD();
                    c.azN.set(true);
                    c.oL();
                } catch (Throwable th) {
                    c.azO.set(true);
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    private static void b(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String strA = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = azT.get(strA);
                        if (cVar2 != null) {
                            cVar2.aAA = true;
                            cVar2.aAw = Double.parseDouble(str);
                        } else {
                            cVar.aAA = true;
                            cVar.aAw = Double.parseDouble(str);
                            azT.put(strA, cVar);
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static synchronized void d(d dVar) {
        if (com.kwad.framework.a.a.oy.booleanValue()) {
            if (dVar.category.equals(ILoggerReporter.Category.ERROR_LOG)) {
                com.kwad.sdk.core.d.c.e("KCLogReporter", "reportItem: " + dVar);
            } else {
                com.kwad.sdk.core.d.c.d("KCLogReporter", "reportItem: " + dVar);
            }
        }
        if (azN.get()) {
            b(dVar);
        } else {
            if (!azO.get()) {
                c(dVar);
            }
        }
    }

    public static void e(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O(z ? "ad_sdk_reward_callback_load" : "ad_sdk_fullscreen_callback_load", "callback_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_reward_check_result", "check_type").b(BusinessType.AD_REWARD).z(aVar).a(new com.kwai.adclient.kscommerciallogger.model.b("RESULT_CHECK_REWARD")));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.5d).O("ad_sdk_webview_track", "scene_id").b(BusinessType.AD_WEBVIEW).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void h(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(0.01d).O("ad_sdk_reward_performance", "reward_type").b(BusinessType.AD_REWARD).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void i(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_reward_performance", "page_status").b(BusinessType.AD_REWARD).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void j(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).DJ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.c.4
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    c.d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_sdk_splash_load", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_sdk_splash_load", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void k(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).DJ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.c.5
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    c.d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_sdk_splash_preload", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_sdk_splash_preload", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void l(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).DJ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.c.7
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    c.d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_cache", "cache").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjw));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_cache", "cache").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjw));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void m(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).DJ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.c.8
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    c.d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_show", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_show", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void n(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).DJ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.c.9
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    c.d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_view_error", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_view_error", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).DJ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.c.10
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    c.d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_template_data_error", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_template_data_error", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void oL() {
        List<d> list = azR;
        if (list == null) {
            return;
        }
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        azR.clear();
        azR = null;
    }

    public static void p(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).DJ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.c.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    c.d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_errorcode_error", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_errorcode_error", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void q(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_block_info", "block").a(com.kwai.adclient.kscommerciallogger.model.b.bjQ).z(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void r(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_image_load_perf", "image_perf").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void s(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(1.0d).O("ad_thread_monitor", "thread_perf").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void t(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.001d).O("ad_video_load_perf", "video_load_perf").cS("ad_video_load_perf").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void u(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.001d).O("ad_video_load_failed", "video_load_failed").cS("ad_video_load_failed").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void v(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(1.0d).O("ad_sdk_aggregation_monitor", "ranger").cS("ad_sdk_aggregation_monitor").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void w(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_wayne_player_vse_monitor", "status").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void x(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_installer_info", "status").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void y(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_uaid_data_performance", "status").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void c(d dVar) {
        if (azR == null) {
            azR = new CopyOnWriteArrayList();
        }
        azR.add(dVar);
    }

    public static void c(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O(z ? "ad_sdk_reward_page_show" : "ad_sdk_fullscreen_page_show", "page_status").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjn));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String strA = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = azT.get(strA);
                        if (cVar2 != null) {
                            cVar2.aAz = true;
                            cVar2.aAi = Double.parseDouble(str);
                        } else {
                            cVar.aAz = true;
                            cVar.aAi = Double.parseDouble(str);
                            azT.put(strA, cVar);
                        }
                    }
                }
            } catch (JSONException e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
    }

    public static void f(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O(z ? "ad_sdk_reward_play_error" : "ad_sdk_fullscreen_play_error", "reward_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.bjQ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(final boolean z, final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).DJ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.c.6
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    c.d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).O("ad_sdk_splash_single_cache", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjw));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).O("ad_sdk_splash_single_cache", "status").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjw));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void h(JSONObject jSONObject) {
        try {
            int iOptInt = jSONObject.optInt("load_status");
            d(d.FH().cR((iOptInt == 3 || iOptInt == 4 || iOptInt == 7) ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(1.0d).j(0.1d).k(0.001d).O("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.bjx).i(jSONObject));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O(z ? "ad_sdk_reward_callback_interaction" : "ad_sdk_fullscreen_callback_interaction", "callback_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void b(d dVar) {
        c.a aVarVg;
        if (azQ) {
            com.kwad.sdk.commercial.c.b bVarA = a(dVar);
            if (azH == -1.0f) {
                azH = new Random().nextFloat();
            }
            if (azK == -1.0f) {
                azK = new Random().nextFloat();
            }
            if (azS.Et() || !a(bVarA)) {
                try {
                    if (ILoggerReporter.Category.ERROR_LOG.equals(a(dVar.category, dVar))) {
                        aVarVg = c.a.Vf();
                    } else {
                        aVarVg = c.a.Vg();
                    }
                    com.kwai.adclient.kscommerciallogger.a.UW().a(aVarVg.c(dVar.aAc).b(dVar.aAd).ie(TextUtils.isEmpty(dVar.tag) ? dVar.eventId : dVar.tag).b(dVar.aAe).m69if(dVar.eventId).B(a(dVar.msg, bVarA)).Vh());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    public static void c(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(str).i(0.001d).O("ad_sdk_local_warmup", "warm_up").b(BusinessType.OTHER).z(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static String a(com.kwad.sdk.commercial.c.b bVar, String str) {
        try {
            int iLastIndexOf = str.lastIndexOf(95);
            int length = str.length() - 1;
            if (str.charAt(length) >= '0' && str.charAt(length) <= '9' && iLastIndexOf != -1) {
                bVar.aAx = str.substring(iLastIndexOf + 1);
                return str.substring(0, iLastIndexOf);
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    @NonNull
    private static com.kwad.sdk.commercial.c.b a(d dVar) {
        double d;
        double d2;
        Map<String, com.kwad.sdk.commercial.a> map;
        com.kwad.sdk.commercial.c.c cVar;
        com.kwad.sdk.commercial.c.c cVar2;
        com.kwad.sdk.commercial.c.b bVar = new com.kwad.sdk.commercial.c.b();
        try {
            Boolean bool = com.kwad.framework.a.a.oy;
            if (bool.booleanValue()) {
                bVar.aAi = dVar.aAa;
            } else {
                bVar.aAi = dVar.azZ;
            }
            bVar.aAw = dVar.aAb;
            if (!azT.containsKey(dVar.eventId) || (cVar2 = azT.get(dVar.eventId)) == null) {
                d = -1.0d;
                d2 = -1.0d;
            } else {
                d = cVar2.aAz ? cVar2.aAi : -1.0d;
                d2 = cVar2.aAA ? cVar2.aAw : -1.0d;
                if (!TextUtils.isEmpty(cVar2.aAx)) {
                    bVar.aAx = cVar2.aAx;
                }
            }
            if (TextUtils.isEmpty(dVar.primaryKey) && bool.booleanValue()) {
                throw new Exception("primaryKey为空");
            }
            String str = dVar.eventId;
            if (!TextUtils.isEmpty(dVar.primaryKey)) {
                String str2 = dVar.msg.has(dVar.primaryKey) ? str + "_" + dVar.msg.opt(dVar.primaryKey) : str + "_" + dVar.primaryKey;
                if (azT.containsKey(str2) && (cVar = azT.get(str2)) != null) {
                    if (cVar.aAz) {
                        d = cVar.aAi;
                    }
                    if (cVar.aAA) {
                        d2 = cVar.aAw;
                    }
                    if (!TextUtils.isEmpty(cVar.aAx)) {
                        bVar.aAx = cVar.aAx;
                    }
                }
            }
            map = azU;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        if (map != null && map.containsKey(dVar.eventId)) {
            com.kwad.sdk.core.d.c.d("KCLRefineReport", "命中精细化采样配置 " + dVar.eventId);
            com.kwad.sdk.commercial.a aVar = azU.get(dVar.eventId);
            if (aVar != null && aVar.azF > 0.0d) {
                String str3 = aVar.minVersion;
                bVar.aAx = str3;
                if (bx.aC(BuildConfig.VERSION_NAME, str3)) {
                    d = aVar.azF;
                }
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "默认采样率： " + aVar.azF + "  minVersion: " + aVar.minVersion);
                List<f> list = aVar.azG;
                if (list != null) {
                    for (f fVar : list) {
                        if (fVar != null && fVar.e(dVar)) {
                            d = fVar.aAi;
                            d2 = fVar.aAj;
                            bVar.aAx = fVar.minVersion;
                            bVar.aAy = bx.aC(fVar.maxVersion, "0") ? fVar.maxVersion : null;
                            bVar.aAk = fVar.aAk;
                            com.kwad.sdk.core.d.c.d("KCLRefineReport", "命中精细化采样规则: for msg " + dVar.msg + " minVersion: " + fVar.minVersion + " maxVersion: " + fVar.maxVersion + " deviceMode: " + fVar.aAk + " ratio: " + fVar.aAi + " convert: " + fVar.aAj);
                        }
                    }
                    d2 = -1.0d;
                } else {
                    d2 = -1.0d;
                }
                return bVar;
            }
        }
        if (d != -1.0d) {
            bVar.aAi = d;
        }
        if (d2 != -1.0d) {
            bVar.aAw = d2;
        } else {
            bVar.aAw = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Dt();
        }
        dVar.azZ = bVar.aAi;
        dVar.aAb = bVar.aAw;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final a aVar, boolean z) {
        boolean zEs = aVar.Es();
        azQ = zEs;
        if (zEs) {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "publish_type", 0);
            aa.putValue(jSONObject, "plug_sdk", z ? 1 : 0);
            com.kwai.adclient.kscommerciallogger.a aVarUW = com.kwai.adclient.kscommerciallogger.a.UW();
            b bVar = new b();
            com.kwai.adclient.kscommerciallogger.a.b bVar2 = new com.kwai.adclient.kscommerciallogger.a.b() { // from class: com.kwad.sdk.commercial.c.3
                private void N(String str, String str2) {
                    aVar.j(str, str2, false);
                }

                @Override // com.kwai.adclient.kscommerciallogger.a.b
                public final void M(@NonNull String str, @NonNull String str2) {
                    N(str, str2);
                }
            };
            Boolean bool = com.kwad.framework.a.a.oy;
            aVarUW.a(bVar, bVar2, jSONObject, bool.booleanValue(), bool.booleanValue());
            com.kwad.sdk.commercial.h.a.FP().df(aVar.Ew());
        }
    }

    public static void b(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O(z ? "ad_sdk_reward_download_error" : "ad_sdk_fullscreen_download_error", "download_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.bjK));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O(str, "status").b(BusinessType.OTHER).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.bjS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(d.FH().cR(str).i(ILoggerReporter.Category.ERROR_LOG.equals(str) ? 1.0d : 0.001d).O("union_web_cache_load_event", LocationConst.HDYawConst.KEY_HD_YAW_STATE).b(BusinessType.WEB_CACHE).z(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(j jVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(1.0E-5d).O("ad_perf_monitor_net_success", "network_monitor").z(jVar).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static boolean a(com.kwad.sdk.commercial.c.b bVar) {
        if (!bx.aC(BuildConfig.VERSION_NAME, bVar.aAx)) {
            return false;
        }
        if (azJ == -1.0f) {
            azJ = new Random().nextFloat();
        }
        if (azM == -1.0f) {
            azM = new Random().nextFloat();
        }
        azL = new Random().nextFloat();
        float fNextFloat = new Random().nextFloat();
        azI = fNextFloat;
        if (bVar.aAk != 0) {
            azH = azJ;
            azK = azL;
        } else {
            azH = fNextFloat;
            azK = azL;
        }
        com.kwad.sdk.core.d.c.d("KCLRefineReport", " 随机数采样率： " + azI + " 设备随机采样率：" + azJ + " 随机离线转实时采样率： " + azL + " 设备随机离线转实时采样率： " + azM + " 当前采用的采样率： " + azH + " 采用离线转实时采样率： " + azK + " 客户端埋点采样率： " + bVar.aAi);
        return ((double) azH) > bVar.aAi;
    }

    public static void b(i iVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_perf_monitor_net_error", "network_monitor").z(iVar).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(@NonNull com.kwad.sdk.utils.b.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_union_kv_fail_rate", "kv").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static String a(String str, d dVar) {
        return (!str.equals(ILoggerReporter.Category.APM_LOG) || ((double) azK) >= dVar.aAb) ? str : ILoggerReporter.Category.ERROR_LOG;
    }

    public static void a(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(str).i(0.001d).O(ILoggerReporter.Category.ERROR_LOG.equals(str) ? "ad_sdk_init_error_performance" : "ad_sdk_init_performance", "init_status").b(BusinessType.AD_SDK_INIT).z(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(str).i(0.001d).O("ad_sdk_resource_warmup", "warm_up").b(BusinessType.OTHER).z(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z, com.kwad.sdk.commercial.c.a aVar, com.kwai.adclient.kscommerciallogger.model.d dVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O(z ? "ad_sdk_reward_load" : "ad_sdk_fullscreen_load", "load_status").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z, String str, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O(str, "reward_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.bjQ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(d.FH().cR(str).i(1.0E-4d).O("union_web_cache_download_event", LocationConst.HDYawConst.KEY_HD_YAW_STATE).b(BusinessType.WEB_CACHE).z(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewLoadMsg webViewLoadMsg) {
        try {
            d(d.FH().cR(str).i(1.0d).O("union_webview_load_event", LocationConst.HDYawConst.KEY_HD_YAW_STATE).z(webViewLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        try {
            double d = webViewCommercialMsg.rate;
            if (d >= 0.0d) {
                aa.putValue(webViewCommercialMsg.msg, "ratio", d);
            }
            if (TextUtils.isEmpty(webViewCommercialMsg.primaryKey)) {
                webViewCommercialMsg.primaryKey = "web_log";
            }
            d(d.FH().cR(str).i(webViewCommercialMsg.rate).O(webViewCommercialMsg.eventId, webViewCommercialMsg.primaryKey).b(webViewCommercialMsg.biz).a(webViewCommercialMsg.subBiz).i(webViewCommercialMsg.msg).a(com.kwai.adclient.kscommerciallogger.model.d.bjZ));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static JSONObject a(JSONObject jSONObject, com.kwad.sdk.commercial.c.b bVar) {
        try {
            aa.putValue(jSONObject, "ratio", bVar.aAi);
            double d = bVar.aAi;
            if (d > 0.0d) {
                aa.putValue(jSONObject, "ratio_count", a(1.0d, d, 0));
            }
            aa.putValue(jSONObject, "debug_mode", com.kwad.framework.a.a.oy.booleanValue() ? 1 : 0);
            aa.putValue(jSONObject, "convert_ratio", bVar.aAw);
            double d2 = bVar.aAw;
            if (d2 > 0.0d) {
                aa.putValue(jSONObject, "convert_ratio_count", a(1.0d, d2, 0));
            }
            return jSONObject;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return jSONObject;
        }
    }

    private static double a(double d, double d2, int i) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d2)), 0, RoundingMode.HALF_UP).doubleValue();
    }
}
