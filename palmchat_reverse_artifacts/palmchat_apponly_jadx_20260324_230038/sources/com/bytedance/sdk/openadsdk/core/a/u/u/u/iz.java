package com.bytedance.sdk.openadsdk.core.a.u.u.u;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements com.bytedance.sdk.openadsdk.core.a.u.u.u {
    private String b;
    private Context fx;
    private int iz;
    private Map<String, Object> n;
    private bc nr;
    private String pn;
    private com.bytedance.sdk.openadsdk.core.a.u.u.u u;
    private View x;

    public iz(bc bcVar, Context context, String str, String str2) {
        this.nr = bcVar;
        this.fx = context;
        this.b = str;
        this.pn = str2;
        nr();
    }

    public static boolean u(int i) {
        switch (i) {
            case 101:
            case 102:
            case 103:
            case 104:
                return true;
            default:
                return false;
        }
    }

    public void nr(Map<String, Object> map) {
        this.n = map;
    }

    private void nr() {
        bc bcVar = this.nr;
        if (bcVar != null) {
            this.iz = bcVar.gq();
        } else {
            this.iz = -1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u
    public boolean u(Map<String, Object> map) {
        boolean zU = u();
        nr();
        if (zU) {
            return true;
        }
        HashMap map2 = new HashMap(2);
        map2.put("event_tag", this.b);
        if (!TextUtils.isEmpty(this.pn)) {
            map2.put("dpa_tag", this.pn);
        }
        if ((com.bytedance.sdk.openadsdk.core.live.nr.u().u(this.fx, this.nr, map2) & 255) == 0) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.a.u.u.u uVar = this.u;
        return uVar != null && uVar.u(map);
    }

    public void nr(int i) {
        this.iz = i;
    }

    private boolean u() {
        if (this.iz < 2) {
            return false;
        }
        HashMap map = new HashMap(2);
        if (u(this.iz)) {
            map.put("live_saas_param_interaction_type", Integer.valueOf(this.iz));
        }
        map.put("event_tag", this.b);
        String str = this.pn;
        if (str != null) {
            map.put("dpa_tag", str);
        }
        if (this.n == null) {
            this.n = new HashMap();
        }
        com.bytedance.sdk.openadsdk.core.live.nr.u().u(this.x, this.nr.vg(), map, this.n);
        int iU = com.bytedance.sdk.openadsdk.core.live.nr.u().u(this.fx, this.nr, map);
        int i = iU & 255;
        int i2 = (iU & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (i2 > 0) {
            this.n.put("click_saas_action", Integer.valueOf(i2));
        }
        return i == 0;
    }

    public void u(View view) {
        this.x = view;
    }
}
