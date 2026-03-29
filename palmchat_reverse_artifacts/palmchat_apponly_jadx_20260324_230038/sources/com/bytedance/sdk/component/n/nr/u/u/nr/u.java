package com.bytedance.sdk.component.n.nr.u.u.nr;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends x {
    public u(Context context, com.bytedance.sdk.component.n.nr.b.nr.u uVar, com.bytedance.sdk.component.n.u.pn pnVar) {
        super(context, uVar, pnVar);
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.x
    public byte fx() {
        return (byte) 3;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.x
    public byte nr() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.x, com.bytedance.sdk.component.n.nr.u.u.nr.nr
    public String u() {
        return ((x) this).nr.nr().pn();
    }

    public static String fx(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    public static String nr(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.x, com.bytedance.sdk.component.n.nr.u.u
    public boolean u(com.bytedance.sdk.component.n.u.nr nrVar) {
        return com.bytedance.sdk.component.n.nr.fx.u.pn(nrVar);
    }
}
