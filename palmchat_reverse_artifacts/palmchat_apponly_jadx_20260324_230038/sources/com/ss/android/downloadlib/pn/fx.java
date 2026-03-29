package com.ss.android.downloadlib.pn;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.appdownloader.iz.iz;
import com.tencent.matrix.trace.config.SharePluginInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx implements com.ss.android.download.api.nr.u {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static fx u = new fx();
    }

    public static fx u() {
        return u.u;
    }

    public void nr(String str) {
        nr(true, str);
    }

    public void nr(boolean z, String str) {
        if (nr()) {
            return;
        }
        if (z) {
            nr(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        mv.u(jSONObject, "msg", str);
        mv.u(jSONObject, SharePluginInfo.ISSUE_TRACE_STACK, u(new Throwable()));
        l.n();
    }

    @Override // com.ss.android.download.api.nr.u
    public void u(Throwable th, String str) {
        u(true, th, str);
    }

    public void u(boolean z, Throwable th, String str) {
        if (nr()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z) {
            nr(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        mv.u(jSONObject, "msg", str);
        mv.u(jSONObject, SharePluginInfo.ISSUE_TRACE_STACK, Log.getStackTraceString(th));
        l.n();
    }

    private void nr(Throwable th) {
        if (iz.nr(l.getContext())) {
            throw new com.ss.android.downloadlib.pn.u(th);
        }
    }

    private boolean nr() {
        return l.a().optInt("enable_monitor", 1) != 1;
    }

    public void u(String str) {
        u(true, str);
    }

    public void u(boolean z, String str) {
        if (nr()) {
            return;
        }
        if (z) {
            nr(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        mv.u(jSONObject, "msg", str);
        mv.u(jSONObject, SharePluginInfo.ISSUE_TRACE_STACK, u(new Throwable()));
        l.n();
    }

    public static String u(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }
}
