package com.opos.mobad.ad.e;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface h extends com.opos.mobad.ad.j {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onClick(View view);

        void onClose();
    }

    String a();

    void a(Context context, FrameLayout frameLayout, k kVar);

    void a(Context context, FrameLayout frameLayout, t tVar, List<View> list, List<View> list2);

    void a(Context context, List<View> list, a aVar, List<View> list2, a aVar2);

    void a(Context context, List<View> list, a aVar, List<View> list2, a aVar2, List<View> list3, a aVar3);

    void a(i iVar);

    boolean a(String str);

    String b();

    List<e> c();

    List<e> d();

    int g();

    int h();

    e i();

    boolean j();

    String k();

    String l();

    void m();

    b n();

    String o();

    int p();

    List<e> q();
}
