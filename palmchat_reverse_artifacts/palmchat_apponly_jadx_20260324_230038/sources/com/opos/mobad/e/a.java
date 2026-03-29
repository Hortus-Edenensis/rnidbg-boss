package com.opos.mobad.e;

import android.content.Context;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a extends com.opos.mobad.a {
    @Override // com.opos.mobad.a
    public int a() {
        return com.opos.mobad.c.b.c().d() == 0 ? 0 : 1;
    }

    @Override // com.opos.mobad.a
    public int a(int i) {
        return com.opos.mobad.c.b.c().a(i) == 0 ? 0 : 1;
    }

    @Override // com.opos.mobad.a
    public FutureTask<Integer> a(Context context, String str) {
        return com.opos.mobad.c.b.c().a(context, str);
    }

    @Override // com.opos.mobad.a
    public FutureTask<Integer> a(Context context, String str, int i) {
        return com.opos.mobad.c.b.c().a(context, str, i);
    }

    @Override // com.opos.mobad.a
    public void a(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        com.opos.mobad.c.b.c().a(str, i, str2, str3, str4, str5, str6);
    }
}
