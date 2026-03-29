package com.bytedance.sdk.component.n.nr.u.u.nr;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends iz {
    public b(Context context, com.bytedance.sdk.component.n.nr.b.nr.u uVar, com.bytedance.sdk.component.n.u.pn pnVar) {
        super(context, uVar, pnVar);
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.iz
    public byte fx() {
        return (byte) 0;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.iz
    public byte nr() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.iz, com.bytedance.sdk.component.n.nr.u.u.nr.nr
    public String u() {
        com.bytedance.sdk.component.n.u.iz izVarNr = ((iz) this).nr.nr();
        if (izVarNr != null) {
            return izVarNr.u();
        }
        return null;
    }

    public static String fx(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    public static String nr(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.iz, com.bytedance.sdk.component.n.nr.u.u
    public boolean u(com.bytedance.sdk.component.n.u.nr nrVar) {
        return com.bytedance.sdk.component.n.nr.fx.u.u(nrVar);
    }
}
