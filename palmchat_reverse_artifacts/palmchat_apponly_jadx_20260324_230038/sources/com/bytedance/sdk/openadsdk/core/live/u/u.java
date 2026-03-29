package com.bytedance.sdk.openadsdk.core.live.u;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.c;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u implements b {
    protected JSONObject fx;
    protected volatile String nr;
    protected volatile Function<SparseArray<Object>, Object> u = null;

    public void a_(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public long fx() {
        return -1L;
    }

    public long nr(bc bcVar) {
        if (bcVar == null) {
            return 0L;
        }
        String strUu = bcVar.uu();
        if (TextUtils.isEmpty(strUu)) {
            strUu = u(bcVar.kv());
        }
        try {
            return Long.parseLong(strUu);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public void u() {
    }

    public abstract boolean x_();

    public boolean a_(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        return u(bcVar.uu(), bcVar.gq());
    }

    public int fx(bc bcVar) {
        my myVarKv;
        if (1 != com.bytedance.sdk.openadsdk.core.live.nr.u().pn()) {
            return 2;
        }
        if (!com.bytedance.sdk.openadsdk.core.live.pn.u.u(bcVar)) {
            return 3;
        }
        if (bcVar != null && jp.nr(dw.getContext()) && (myVarKv = bcVar.kv()) != null) {
            String strNr = myVarKv.nr();
            if (!TextUtils.isEmpty(strNr)) {
                Uri uri = Uri.parse(strNr);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                return jp.nr(dw.getContext(), intent, true) ? 0 : 4;
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public void u(String str, bc bcVar, long j) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public void u(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        this.u = function;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public boolean u(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Long.parseLong(str) <= 0) {
                return false;
            }
            switch (i) {
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public String u(my myVar) {
        Map<String, String> mapU;
        if (myVar == null) {
            return null;
        }
        String strNr = myVar.nr();
        if (TextUtils.isEmpty(strNr)) {
            return null;
        }
        if ((strNr.startsWith("snssdk2329") || strNr.startsWith("snssdk1128")) && (mapU = com.bytedance.sdk.openadsdk.core.y.bc.u(strNr)) != null) {
            return mapU.get("room_id");
        }
        return null;
    }

    public String u(bc bcVar, String str, Map map) {
        if (map == null) {
            return str;
        }
        try {
            String str2 = (String) map.get("dpa_tag");
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            String strPn = c.pn(bcVar, str2);
            if (TextUtils.isEmpty(strPn)) {
                return str;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(strPn);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.putOpt(next, jSONObject2.opt(next));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            s.u().u("getEcomLiveParams", e);
            return str;
        }
    }

    public void u(bc bcVar, String str, int i, int i2, int i3) {
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, str, i, i2, i3, x_());
    }

    public boolean u(bc bcVar, int i) {
        return bcVar.gq() == 7 || i == 103;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public void b(bc bcVar) {
    }
}
