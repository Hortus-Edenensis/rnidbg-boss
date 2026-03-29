package com.efs.sdk.base.core.config.remote;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements IConfigRefreshAction {

    /* JADX INFO: renamed from: com.efs.sdk.base.core.config.remote.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0325a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f5571a = new a();
    }

    public static a a() {
        return C0325a.f5571a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b2, code lost:
    
        com.efs.sdk.base.core.util.Log.i("efs.config", "config request succ, config is:\n ".concat(java.lang.String.valueOf(r2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00bf, code lost:
    
        return r2;
     */
    @Override // com.efs.sdk.base.IConfigRefreshAction
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String refresh() {
        String str = "";
        if (!NetworkUtil.isConnected(ControllerCenter.getGlobalEnvStruct().mAppContext)) {
            Log.i("efs.config", "Config refresh fail, network is disconnected.");
            return "";
        }
        String strA = b.a().a(true);
        com.efs.sdk.base.core.a.c cVarA = com.efs.sdk.base.core.a.c.a();
        int i = 0;
        while (true) {
            if (i >= 3) {
                break;
            }
            com.efs.sdk.base.core.a.a aVarA = com.efs.sdk.base.core.a.a.a();
            String strB = cVarA.b();
            if (aVarA.f5540a) {
                Log.i("efs.px.api", "get config from server, wpkHeader is ".concat(String.valueOf(strB)));
            }
            String str2 = strA + "/apm_cc";
            if (aVarA.f5540a) {
                Log.i("efs.px.api", "get config from server, url is ".concat(String.valueOf(str2)));
            }
            HashMap map = new HashMap(1);
            map.put("wpk-header", strB);
            com.efs.sdk.base.core.util.a.c cVarA2 = new com.efs.sdk.base.core.util.a.d(str2).a(map).a(com.efs.sdk.base.core.a.b.a()).a();
            cVarA2.f5595a.e = "get";
            HttpResponse httpResponseA = cVarA2.a();
            if (httpResponseA.succ) {
                str = httpResponseA.data;
                break;
            }
            if (TextUtils.isEmpty(httpResponseA.getBizCode()) || !"1000".equals(httpResponseA.getBizCode())) {
                break;
            }
            i++;
        }
        return "";
    }
}
