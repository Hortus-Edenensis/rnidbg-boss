package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public int aIU = -1;
    public Exception aIV;
    public String aIW;
    public int code;

    public final boolean Jr() {
        return this.code == 200;
    }

    @NonNull
    public final String toString() {
        return "BaseResponse{code=" + this.code + ", rawCode=" + this.aIU + ", rawException=" + this.aIV + ", body='" + this.aIW + "'}";
    }
}
