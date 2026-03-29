package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class e {
    private com.kwad.sdk.crash.b.b aTM;
    private c aTN;
    private long aTO;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final e aTP = new e(0);
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static e Nj() {
        return a.aTP;
    }

    public final String[] Nk() {
        return this.aTM.Nw();
    }

    public final String[] Nl() {
        return this.aTM.Nl();
    }

    public final String Nm() {
        return this.aTN.aTk.aUq;
    }

    public final int Nn() {
        return this.aTN.aTk.aUu;
    }

    public final c No() {
        return this.aTN;
    }

    public final h Np() {
        return this.aTN.aTm;
    }

    public final long Nq() {
        return SystemClock.elapsedRealtime() - this.aTO;
    }

    public final void a(@NonNull c cVar) {
        this.aTN = cVar;
        this.aTO = SystemClock.elapsedRealtime();
        this.aTM.a(cVar.aTn, cVar.aTo);
    }

    public final void b(int i, ExceptionMessage exceptionMessage) {
        f fVarNg = this.aTN.Ng();
        if (fVarNg != null) {
            fVarNg.a(i, exceptionMessage);
        }
    }

    public final String getAppId() {
        return this.aTN.aTl.mAppId;
    }

    public final Context getContext() {
        return this.aTN.context;
    }

    public final String getSdkVersion() {
        return this.aTN.aTk.mSdkVersion;
    }

    public final boolean isDebug() {
        return this.aTN.isDebugMode();
    }

    private e() {
        this.aTM = new com.kwad.sdk.crash.b.b();
        this.aTN = new c.a().Ni();
    }
}
