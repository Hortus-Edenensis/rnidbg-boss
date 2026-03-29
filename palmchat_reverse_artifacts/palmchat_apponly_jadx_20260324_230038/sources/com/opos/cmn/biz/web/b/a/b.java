package com.opos.cmn.biz.web.b.a;

import com.opos.cmn.biz.web.b.a.a.c;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.cmn.biz.web.b.a.a.b f7899a;
    public final Map<String, Object> b;
    public final boolean c;
    public final com.opos.cmn.biz.web.b.a.a.a d;
    public final c e;
    public final Map<String, Object> f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.opos.cmn.biz.web.b.a.a.b f7900a;
        private Map<String, Object> b;
        private boolean c = true;
        private com.opos.cmn.biz.web.b.a.a.a d;
        private c e;
        private Map<String, Object> f;

        public a b(Map<String, Object> map) {
            this.f = map;
            return this;
        }

        public a a(com.opos.cmn.biz.web.b.a.a.a aVar) {
            this.d = aVar;
            return this;
        }

        public a a(com.opos.cmn.biz.web.b.a.a.b bVar) {
            this.f7900a = bVar;
            return this;
        }

        public a a(c cVar) {
            this.e = cVar;
            return this;
        }

        public a a(Map<String, Object> map) {
            this.b = map;
            return this;
        }

        public a a(boolean z) {
            this.c = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    private b(a aVar) {
        this.f7899a = aVar.f7900a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    public String toString() {
        return "WebViewInitParams{iWebActionListener=" + this.f7899a + ", jsInterfaceMap=" + this.b + ", isShowTitle=" + this.c + ", iReceivedSslErrorHandler=" + this.d + ", iWebToDeepLinkListener=" + this.e + ", extraParams=" + this.f + '}';
    }
}
