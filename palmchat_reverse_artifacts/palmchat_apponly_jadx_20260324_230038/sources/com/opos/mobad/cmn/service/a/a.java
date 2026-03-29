package com.opos.mobad.cmn.service.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.downloader.g;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f8726a;
    private static final byte[] b = new byte[0];
    private Context c;
    private final int d = 100;
    private Map<Integer, C0730a> e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.opos.mobad.cmn.service.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0730a implements g {
        private c b;

        public C0730a(c cVar) {
            this.b = cVar;
        }

        @Override // com.opos.mobad.downloader.g
        public void a(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.downloader.g
        public void b(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.b(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.downloader.g
        public void c(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.c(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.downloader.g
        public void d(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.d(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.downloader.g
        public void e(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.e(i, i2, str, str2);
                a.this.e.remove(Integer.valueOf(this.b.hashCode()));
            }
        }

        @Override // com.opos.mobad.downloader.g
        public void f(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.f(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.downloader.g
        public void a(int i, int i2, String str, String str2, String str3) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(i, i2, str, str2, str3);
            }
        }
    }

    private a(Context context) {
        this.c = context.getApplicationContext();
    }

    public static a a(Context context) {
        a aVar = f8726a;
        if (aVar == null) {
            synchronized (b) {
                aVar = f8726a;
                if (aVar == null) {
                    aVar = new a(context);
                    f8726a = aVar;
                }
            }
        }
        return aVar;
    }

    public void b(String str) {
        com.opos.mobad.downloader.d.a(this.c).b(str);
    }

    public void c(String str) {
        com.opos.mobad.downloader.d.a(this.c).c(str);
    }

    public b a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (com.opos.cmn.an.e.b.a.a(com.opos.cmn.d.a.a(this.c, str))) {
            return new b(105, 100);
        }
        int[] iArrA = com.opos.mobad.downloader.d.a(this.c).a(str, str2);
        return new b(iArrA[0], iArrA[1]);
    }

    public void a() {
        com.opos.mobad.downloader.d.a(this.c).a();
    }

    public void a(int i, boolean z) {
        com.opos.mobad.downloader.d.a(this.c).a(i, z, new d());
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        com.opos.mobad.downloader.d.a(this.c).a(this.e.remove(Integer.valueOf(cVar.hashCode())));
    }

    public void a(String str) {
        com.opos.mobad.downloader.d.a(this.c).a(str);
    }

    public void a(String str, String str2, String str3, String str4, c cVar) {
        C0730a c0730a;
        if (cVar != null) {
            c0730a = new C0730a(cVar);
            this.e.put(Integer.valueOf(cVar.hashCode()), c0730a);
        } else {
            c0730a = null;
        }
        com.opos.mobad.downloader.d.a(this.c).a(str, str2, str3, str4, c0730a);
    }
}
