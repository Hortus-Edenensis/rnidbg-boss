package com.bytedance.sdk.openadsdk.core.qq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.openadsdk.core.dw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n implements com.bytedance.sdk.component.n.u.iz {
    public static final n u = new n();
    private volatile SQLiteDatabase nr;

    @Override // com.bytedance.sdk.component.n.u.iz
    public String b() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.component.n.u.iz
    public String fx() {
        return null;
    }

    @Override // com.bytedance.sdk.component.n.u.iz
    public String iz() {
        return null;
    }

    @Override // com.bytedance.sdk.component.n.u.iz
    public String nr() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.n.u.iz
    public String pn() {
        return "logstatsbatch";
    }

    @Override // com.bytedance.sdk.component.n.u.iz
    public String u() {
        return "loghighpriority";
    }

    @Override // com.bytedance.sdk.component.n.u.iz
    public SQLiteDatabase u(Context context) {
        if (this.nr == null) {
            synchronized (n.class) {
                if (this.nr == null) {
                    com.bytedance.sdk.openadsdk.core.jk.b bVarU = com.bytedance.sdk.openadsdk.core.jk.fx.u(dw.getContext()).u();
                    bVarU.u();
                    this.nr = bVarU.nr();
                }
            }
        }
        return this.nr;
    }
}
