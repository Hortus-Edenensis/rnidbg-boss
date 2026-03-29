package com.kwad.framework.filedownloader.message;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class e {
    private volatile g asS;
    private volatile b asT;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        private static final e asU = new e();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    public static e Ax() {
        return a.asU;
    }

    public final void a(b bVar) {
        this.asT = bVar;
        if (bVar == null) {
            this.asS = null;
        } else {
            this.asS = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwad.framework.filedownloader.message.b) {
            if (this.asT != null) {
                this.asT.r(messageSnapshot);
            }
        } else if (this.asS != null) {
            this.asS.u(messageSnapshot);
        }
    }
}
