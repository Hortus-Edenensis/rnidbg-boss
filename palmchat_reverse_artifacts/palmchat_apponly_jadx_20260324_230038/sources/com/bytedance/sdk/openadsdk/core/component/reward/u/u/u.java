package com.bytedance.sdk.openadsdk.core.component.reward.u.u;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.pn.b.pn;
import com.bytedance.sdk.openadsdk.core.y.q;
import com.bytedance.sdk.openadsdk.gi.fx;
import com.cdo.oaps.ad.OapsKey;
import com.qiniu.android.collect.ReportItem;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile u u;
    private long b;
    private final nr fx;
    private final Context nr;

    private u(Context context) {
        this.nr = context == null ? dw.getContext() : context.getApplicationContext();
        this.fx = new nr();
    }

    public static u u() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u(dw.getContext());
                }
            }
        }
        return u;
    }

    public void nr() {
        File[] fileArrListFiles;
        pn.u(7).u();
        pn.u(8).u();
        File fileFx = (("mounted".equals(fx.u()) || !Environment.isExternalStorageRemovable()) && com.bytedance.sdk.openadsdk.api.plugin.nr.fx(this.nr) != null) ? com.bytedance.sdk.openadsdk.api.plugin.nr.fx(this.nr) : com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.nr);
        if (fileFx == null || !fileFx.exists() || !fileFx.isDirectory() || (fileArrListFiles = fileFx.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.u.u.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null) {
                    return file.getName().contains("reward_video_cache");
                }
                return false;
            }
        })) == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                n.fx(file);
            } catch (Throwable unused) {
            }
        }
    }

    public String u(boolean z, String str) {
        long jFx = dw.nr().fx(str);
        if (jFx > 0 && System.currentTimeMillis() - this.b < jFx) {
            return "1";
        }
        int i = z ? 7 : 8;
        bc bcVarNr = nr(z, str);
        if (bcVarNr == null) {
            return "0";
        }
        if (bcVarNr.bc() + bcVarNr.gi() < System.currentTimeMillis()) {
            pn.u(i).u(str);
            return "1";
        }
        JSONObject jSONObjectU = u(bcVarNr);
        if (jSONObjectU == null) {
            return "0";
        }
        this.b = System.currentTimeMillis();
        return jSONObjectU.toString();
    }

    public void nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u(nrVar, str);
    }

    public synchronized bc nr(boolean z, String str) {
        bc bcVarU = com.bytedance.sdk.openadsdk.core.component.reward.u.pn.u(z, false, false).u(str, 0L);
        if (bcVarU == null) {
            return null;
        }
        if (q.fx(bcVarU)) {
            if (TextUtils.isEmpty(str) || !str.endsWith("again")) {
                return bcVarU;
            }
            return null;
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVarU)) {
            return bcVarU;
        }
        if (zx.k(bcVarU) == null) {
            return null;
        }
        return bcVarU;
    }

    private JSONObject u(bc bcVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportItem.RequestKeyRequestId, bcVar.wq());
            jSONObject.put("aid", Long.valueOf(bcVar.en()));
            jSONObject.put("cid", Long.valueOf(bcVar.lk()));
            jSONObject.put(OapsKey.KEY_PRICE, bcVar.y());
            jSONObject.put("material_key", bcVar.m());
            jSONObject.put("s_send_ts", bcVar.bc());
            jSONObject.put("cache_time", bcVar.gi());
            jSONObject.put("ext", bcVar.d());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str) {
        this.fx.u(str, nrVar);
    }

    public com.bytedance.sdk.openadsdk.my.fx.fx.nr u(String str) {
        return this.fx.u(str);
    }
}
