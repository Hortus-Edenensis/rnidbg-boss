package com.kwad.sdk.core.adlog.a;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public JSONObject aBT;
    public com.kwad.sdk.core.adlog.c.a aBU;
    public long aBV;
    public int aBW;
    public String aBX;
    public int retryCount;
    public String url;

    public static a Go() {
        return new a();
    }

    public final a as(long j) {
        this.aBV = j;
        return this;
    }

    public final a c(com.kwad.sdk.core.adlog.c.a aVar) {
        this.aBU = aVar;
        return this;
    }

    public final a dA(String str) {
        this.aBX = str;
        return this;
    }

    public final a dc(int i) {
        this.aBW = i;
        return this;
    }

    public final a dz(String str) {
        this.url = str;
        return this;
    }

    public final a j(JSONObject jSONObject) {
        this.aBT = jSONObject;
        return this;
    }

    @NonNull
    public final String toString() {
        return "AdLogCache {actionType=" + this.aBU.aAV + ", retryCount=" + this.retryCount + ", retryErrorCode=" + this.aBW + ", retryErrorMsg=" + this.aBX + '}';
    }
}
