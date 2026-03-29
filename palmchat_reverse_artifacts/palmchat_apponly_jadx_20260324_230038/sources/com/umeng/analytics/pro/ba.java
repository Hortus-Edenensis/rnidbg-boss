package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.analytics.pro.az;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ba implements az.a {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ba f10866a = new ba();

        private a() {
        }
    }

    public static ba a() {
        return a.f10866a;
    }

    @Override // com.umeng.analytics.pro.az.a
    public void a(Object obj, int i) {
        JSONObject jSONObjectA;
        if (i != 101) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[CkHandler]: unknown event type!");
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "[CkHandler]:recv CkDispatch.CHECK event!");
        Context appContext = UMGlobalContext.getAppContext();
        if (!UMConfigure.getInitStatus() || appContext == null || UMConfigure.needSendZcfgEnv(appContext) || com.umeng.commonsdk.utils.c.a() || FieldManager.allow(com.umeng.commonsdk.utils.d.aw) || SdkVersion.SDK_TYPE == 1 || !(obj instanceof bb)) {
            return;
        }
        try {
            JSONObject jSONObjectG = ((bb) obj).g();
            if (!jSONObjectG.has("eID") || (jSONObjectA = bc.a(appContext)) == null) {
                return;
            }
            bc.a(jSONObjectA, jSONObjectG);
            av.a(new aq(aq.c, jSONObjectA, "appkey"), 0L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
        }
    }
}
