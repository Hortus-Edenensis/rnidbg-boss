package com.opos.mobad.cmn.func;

import android.content.Context;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.p.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface a {

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0722a {
        void a();

        void a(int i, String str);
    }

    void a(Context context, String str, String str2, String str3, InterfaceC0722a interfaceC0722a, String str4);

    void a(Context context, String str, String str2, String str3, String str4);

    void a(com.opos.mobad.b bVar, String str, String str2, AdItemData adItemData, String str3, com.opos.mobad.p.a aVar);

    void a(com.opos.mobad.b bVar, String str, String str2, AdItemData adItemData, String str3, String str4, com.opos.mobad.p.a aVar, c cVar, long j);

    boolean a(Context context, String str, String str2);

    boolean a(Context context, String str, String str2, String str3);

    boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z);

    boolean b(Context context, String str, String str2);

    boolean b(Context context, String str, String str2, String str3);

    boolean c(Context context, String str, String str2);

    boolean d(Context context, String str, String str2);

    boolean e(Context context, String str, String str2);
}
