package com.beizi.ad;

import android.content.Context;
import android.view.View;
import com.beizi.ad.internal.d.a;
import com.beizi.ad.lance.ApkBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface e {

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        CONTENT,
        APP_INSTALL
    }

    String a();

    void a(Context context, View view, String str, String str2, String str3, String str4, int i);

    void a(View view, String str, String str2, String str3, String str4, int i, com.beizi.ad.internal.c.b bVar);

    boolean a(View view, com.beizi.ad.internal.c.b bVar);

    boolean a(View view, com.beizi.ad.internal.c.c cVar);

    boolean a(View view, List<View> list, com.beizi.ad.internal.c.b bVar);

    String b();

    String c();

    String d();

    String e();

    boolean f();

    void g();

    ArrayList<String> h();

    ArrayList<String> i();

    a.C0114a j();

    a.C0114a k();

    String l();

    ApkBean m();
}
