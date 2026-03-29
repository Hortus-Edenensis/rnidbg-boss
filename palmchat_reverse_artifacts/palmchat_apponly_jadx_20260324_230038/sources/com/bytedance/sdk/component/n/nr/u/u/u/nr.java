package com.bytedance.sdk.component.n.nr.u.u.u;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.n.u.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements iz {
    public static final nr u = new nr();
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
            synchronized (this) {
                if (this.nr == null) {
                    this.nr = new u(context, this).getWritableDatabase();
                }
            }
        }
        return this.nr;
    }
}
