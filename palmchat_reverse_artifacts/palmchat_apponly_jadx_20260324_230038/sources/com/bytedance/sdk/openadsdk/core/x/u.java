package com.bytedance.sdk.openadsdk.core.x;

import android.content.Context;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.utils.bq;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile boolean u = false;

    public static void fx(String str, String str2) {
        if (u) {
            fx.fx(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr() {
        x.nr(new a("fetch_lg_command") { // from class: com.bytedance.sdk.openadsdk.core.x.u.2
            @Override // java.lang.Runnable
            public void run() {
                fx.nr();
            }
        });
    }

    public static void nr(String str, String str2) {
        if (u) {
            fx.nr(str, str2);
        }
    }

    private static void u(Context context, nr nrVar) {
        if (nrVar != null && LogAdapter.u == null && bq.u(dw.getContext()) && nrVar.b()) {
            String path = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context).getPath();
            String string = com.bytedance.sdk.openadsdk.api.plugin.nr.u(context).toString();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("buffer_dir_path", path + "/aa");
                jSONObject.putOpt("log_dir_path", string + "/aa");
                Boolean bool = Boolean.TRUE;
                jSONObject.putOpt("compress", bool);
                jSONObject.putOpt("encrypt", bool);
                jSONObject.putOpt("level", Integer.valueOf(nrVar.u()));
                jSONObject.putOpt("log_file_exp_days", Integer.valueOf(nrVar.nr()));
                jSONObject.putOpt("max_dir_size", Integer.valueOf(nrVar.fx() * 1024 * 1024));
                jSONObject.putOpt("per_size", 2097152);
                jSONObject.putOpt("offload_main_write", bool);
                if (!fx.u(context, jSONObject)) {
                    k.nr("ACL", "init failed");
                    return;
                }
                k.u(new pn());
                fx.u(context, "3892", jk.o());
                fx.u("mon.zijieapi.com");
                u = true;
                fx.fx();
            } catch (JSONException e) {
                k.nr("ACL", "init failed:" + e.getMessage());
            }
        }
    }

    public static void u(nr nrVar) {
        if (!u) {
            u(dw.getContext(), nrVar);
        } else if (nrVar != null && nrVar.b()) {
            fx.u(nrVar.u());
            com.bytedance.sdk.component.utils.jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.x.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.nr();
                }
            }, 5000L);
        } else {
            fx.u();
        }
    }

    public static void u(String str, String str2) {
        if (u) {
            fx.u(str, str2);
        }
    }

    public static void u(String str, String str2, Throwable th) {
        if (u) {
            fx.u(str, str2, th);
        }
    }

    public static void u(String str, Throwable th) {
        if (u) {
            fx.u(str, th);
        }
    }
}
