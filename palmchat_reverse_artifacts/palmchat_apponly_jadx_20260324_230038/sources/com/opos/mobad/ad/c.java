package com.opos.mobad.ad;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.ad.e.n;
import com.opos.mobad.ad.e.o;
import com.opos.mobad.ad.e.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface c {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f8521a;
        public final String b;

        public a(boolean z, String str) {
            this.f8521a = z;
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b implements c {
        @Override // com.opos.mobad.ad.c
        public String a(String str, int i) {
            return null;
        }
    }

    com.opos.mobad.ad.a.b a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.a aVar, com.opos.mobad.ad.a.c cVar);

    a a(Context context);

    com.opos.mobad.ad.d.a a(Activity activity, String str, String str2, com.opos.mobad.ad.d.e eVar, com.opos.mobad.ad.d.b bVar);

    com.opos.mobad.ad.d.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.d.d dVar);

    com.opos.mobad.ad.e.c a(Context context, String str, String str2, com.opos.mobad.ad.e.f fVar);

    com.opos.mobad.ad.e.g a(Context context, String str, String str2, int i, int i2, com.opos.mobad.ad.e.j jVar, com.opos.mobad.ad.privacy.a aVar);

    n a(Context context, s sVar, String str, String str2, o oVar);

    com.opos.mobad.ad.f.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.f.b bVar);

    com.opos.mobad.ad.g.a a(Context context, String str, String str2, com.opos.mobad.ad.g.f fVar, com.opos.mobad.ad.g.c cVar);

    com.opos.mobad.ad.g.b a(Activity activity, String str, String str2, com.opos.mobad.ad.g.f fVar, com.opos.mobad.ad.g.c cVar);

    String a(String str, int i);

    void a(Context context, String str, String str2, String str3, boolean z, h hVar);

    void b();
}
