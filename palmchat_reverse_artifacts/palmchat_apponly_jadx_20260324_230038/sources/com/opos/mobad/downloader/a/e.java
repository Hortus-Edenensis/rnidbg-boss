package com.opos.mobad.downloader.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8769a;
    public final boolean b;
    public final String c;
    public final String d;
    public final int e;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8770a;
        public boolean b;
        public String c;
        public String d;
        public int e;

        public a a(int i) {
            this.f8770a = i;
            return this;
        }

        public a b(int i) {
            this.e = i;
            return this;
        }

        public String toString() {
            return "Builder{iconId=" + this.f8770a + ", autoCancel=" + this.b + ", notificationChannelId=" + this.c + ", notificationChannelName='" + this.d + "', notificationChannelImportance=" + this.e + '}';
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public a a(boolean z) {
            this.b = z;
            return this;
        }

        public e a() {
            return new e(this);
        }
    }

    public e(a aVar) {
        this.f8769a = aVar.f8770a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
    }
}
