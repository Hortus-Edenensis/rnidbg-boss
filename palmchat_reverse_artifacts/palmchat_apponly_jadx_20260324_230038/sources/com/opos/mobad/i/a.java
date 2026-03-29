package com.opos.mobad.i;

import com.opos.cmn.func.a.a.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.cmn.func.a.a.d f8924a;
    public final String b;
    public final int c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;

    /* JADX INFO: renamed from: com.opos.mobad.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0747a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.opos.cmn.func.a.a.d f8925a;
        private String b;
        private String d;
        private String f;
        private String g;
        private int c = -1;
        private int e = 0;

        public C0747a b(String str) {
            this.b = str;
            return this;
        }

        public C0747a a(int i) {
            this.c = i;
            return this;
        }

        public C0747a c(String str) {
            this.d = str;
            return this;
        }

        private boolean b(int i) {
            return i == 0 || 1 == i || 2 == i;
        }

        public C0747a a(com.opos.cmn.func.a.a.d dVar) {
            this.f8925a = dVar;
            return this;
        }

        public C0747a a(String str) {
            this.f8925a = new d.a().a("GET").b(str).a();
            return this;
        }

        public a a() throws Exception {
            if (this.f8925a == null) {
                throw new NullPointerException("netRequest is null.");
            }
            if (!b(this.c)) {
                throw new Exception("saveType not support!saveType must be SAVE_TYPE_OF_SDCARD or SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE");
            }
            if (this.c == 0 && com.opos.cmn.an.d.b.a(this.d)) {
                throw new NullPointerException("when saveType is SAVE_TYPE_OF_SDCARD.savePath can't be null.");
            }
            int i = this.c;
            if ((1 == i || 2 == i) && com.opos.cmn.an.d.b.a(this.g)) {
                throw new NullPointerException("when saveType is SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE.fileName can't be null.");
            }
            return new a(this);
        }
    }

    public a(C0747a c0747a) {
        this.f8924a = c0747a.f8925a;
        this.b = c0747a.b;
        this.c = c0747a.c;
        this.d = c0747a.d;
        this.e = c0747a.e;
        this.f = c0747a.f;
        this.g = c0747a.g;
    }

    public String toString() {
        return "DownloadRequest{netRequest=" + this.f8924a + ", md5='" + this.b + "', saveType=" + this.c + ", savePath='" + this.d + "', mode=" + this.e + ", dir='" + this.f + "', fileName='" + this.g + "'}";
    }
}
