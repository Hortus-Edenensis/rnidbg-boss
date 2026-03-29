package com.opos.cmn.biz.web.a.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7893a;
    public final String b;

    /* JADX INFO: renamed from: com.opos.cmn.biz.web.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0660a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7894a;
        private String b;

        public C0660a a(String str) {
            this.f7894a = str;
            return this;
        }

        public C0660a b(String str) {
            this.b = str;
            return this;
        }

        public a a() throws Exception {
            if (TextUtils.isEmpty(this.f7894a)) {
                throw new Exception("url is null.");
            }
            return new a(this);
        }
    }

    private a(C0660a c0660a) {
        this.f7893a = c0660a.f7894a;
        this.b = c0660a.b;
    }

    public String toString() {
        return "CacheResourceRequest{url=" + this.f7893a + ", md5=" + this.b + '}';
    }
}
