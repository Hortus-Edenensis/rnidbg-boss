package com.bytedance.embedapplog;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class z {
    protected final dw b;
    protected final gi fx;
    protected final Context nr;
    protected final List<Future<h>> u = new ArrayList();

    public z(Context context, dw dwVar, gi giVar) {
        this.b = dwVar;
        this.fx = giVar;
        this.nr = context;
    }

    public abstract List<String> u();

    public boolean u(JSONObject jSONObject) {
        return false;
    }

    public void u(bq bqVar, Long l) {
        this.u.add(ja.u(new c(bqVar, l)));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062 A[Catch: Exception -> 0x007a, TryCatch #0 {Exception -> 0x007a, blocks: (B:6:0x001a, B:9:0x0029, B:28:0x0072, B:24:0x0054, B:25:0x0062, B:14:0x0039, B:17:0x0043), top: B:33:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0008 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(Map<String, JSONObject> map, long j) {
        byte b;
        bq qVar;
        bq bqVar;
        for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
            String key = entry.getKey();
            try {
                if (u().contains(entry.getKey())) {
                    int iHashCode = key.hashCode();
                    if (iHashCode != 3073450) {
                        b = (iHashCode == 3073698 && key.equals("d_i0")) ? (byte) 1 : (byte) -1;
                        if (b != 0) {
                            qVar = new q(this.nr, entry.getValue());
                        } else if (b != 1) {
                            bqVar = null;
                            if (bqVar != null) {
                                u(bqVar, Long.valueOf(j));
                            }
                        } else {
                            qVar = new qq(this.nr, entry.getValue());
                        }
                        bqVar = qVar;
                        if (bqVar != null) {
                        }
                    } else {
                        if (key.equals("d_a0")) {
                            b = 0;
                        }
                        if (b != 0) {
                        }
                        bqVar = qVar;
                        if (bqVar != null) {
                        }
                    }
                }
            } catch (Exception e) {
                bg.b("__kite", "error " + e.getMessage());
            }
        }
    }
}
