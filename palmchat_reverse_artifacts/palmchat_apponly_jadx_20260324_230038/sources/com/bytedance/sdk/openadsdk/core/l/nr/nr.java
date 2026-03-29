package com.bytedance.sdk.openadsdk.core.l.nr;

import android.os.Looper;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.openadsdk.core.bg;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends a {
    private long b;
    private long fx;
    private String iz;
    private com.bytedance.sdk.openadsdk.core.l.nr.u nr;
    private String pn;
    private String u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private String b;
        private long fx;
        private com.bytedance.sdk.openadsdk.core.l.nr.u iz;
        private long nr;
        private String pn;
        private String u;

        public u fx(String str) {
            this.pn = str;
            return this;
        }

        public u nr(long j) {
            this.fx = j;
            return this;
        }

        public u u(String str) {
            this.u = str;
            return this;
        }

        public u nr(String str) {
            this.b = str;
            return this;
        }

        public u u(com.bytedance.sdk.openadsdk.core.l.nr.u uVar) {
            this.iz = uVar;
            return this;
        }

        public u u(long j) {
            this.nr = j;
            return this;
        }

        public void u() {
            nr nrVar = new nr("tt_csj_download_thread");
            nrVar.iz = this.pn;
            nrVar.pn = this.b;
            nrVar.b = this.fx;
            nrVar.fx = this.nr;
            nrVar.u = this.u;
            nrVar.nr = this.iz;
            nr.nr(nrVar);
        }
    }

    public nr(String str) {
        super(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.nr == null) {
        }
        String str = this.u;
        str.hashCode();
        switch (str) {
            case "onIdle":
                this.nr.u();
                break;
            case "onInstalled":
                this.nr.u(this.pn, this.iz);
                break;
            case "onDownloadActive":
                this.nr.u(this.fx, this.b, this.pn, this.iz);
                break;
            case "onDownloadFailed":
                this.nr.fx(this.fx, this.b, this.pn, this.iz);
                break;
            case "onDownloadPaused":
                this.nr.nr(this.fx, this.b, this.pn, this.iz);
                break;
            case "onDownloadFinished":
                this.nr.u(this.fx, this.pn, this.iz);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            bg.iz().post(runnable);
        } else {
            runnable.run();
        }
    }
}
