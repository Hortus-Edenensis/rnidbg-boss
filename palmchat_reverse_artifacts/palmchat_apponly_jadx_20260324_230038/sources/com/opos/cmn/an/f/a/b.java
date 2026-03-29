package com.opos.cmn.an.f.a;

import android.content.Context;
import com.opos.cmn.an.f.c.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7744a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final String f;
    public final Context g;
    public final InterfaceC0644b h;
    public final c i;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f7745a;
        private InterfaceC0644b g;
        private c h;
        private int b = 2;
        private int c = 2;
        private int d = 7;
        private String e = "";
        private String f = "cmn_log";
        private int i = 2;

        public a a(int i) {
            this.b = i;
            return this;
        }

        public a a(String str) {
            this.f = str;
            return this;
        }

        public a b(int i) {
            this.c = i;
            return this;
        }

        public a c(int i) {
            if (i > 0) {
                this.d = i;
            }
            return this;
        }

        public b a(Context context) {
            if (context == null) {
                throw new NullPointerException("context is null.");
            }
            this.f7745a = context.getApplicationContext();
            a();
            return new b(this);
        }

        public a b(String str) {
            if (!com.opos.cmn.an.d.b.a(str)) {
                this.e = str;
            }
            return this;
        }

        private void a() {
            if (com.opos.cmn.an.d.b.a(this.e)) {
                this.e = this.f7745a.getPackageName();
            }
            if (this.g == null) {
                this.g = new InterfaceC0644b() { // from class: com.opos.cmn.an.f.a.b.a.1
                    @Override // com.opos.cmn.an.f.a.b.InterfaceC0644b
                    public String a() {
                        return f.b(a.this.f7745a);
                    }
                };
            }
            if (this.h == null) {
                this.h = new c() { // from class: com.opos.cmn.an.f.a.b.a.2
                    @Override // com.opos.cmn.an.f.a.b.c
                    public String a() {
                        return com.opos.cmn.an.f.c.b.a(a.this.f7745a);
                    }
                };
            }
        }
    }

    /* JADX INFO: renamed from: com.opos.cmn.an.f.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0644b {
        String a();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        String a();
    }

    private b(a aVar) {
        this.f7744a = aVar.f;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f7745a;
        this.h = aVar.g;
        this.i = aVar.h;
        this.e = aVar.i;
    }

    public String toString() {
        return "LogInitParams{, context=" + this.g + ", baseTag=" + this.f7744a + ", fileLogLevel=" + this.b + ", consoleLogLevel=" + this.c + ", fileExpireDays=" + this.d + ", pkgName=" + this.f + ", imeiProvider=" + this.h + ", openIdProvider=" + this.i + ", logImplType=" + this.e + '}';
    }
}
