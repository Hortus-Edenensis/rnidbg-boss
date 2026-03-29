package com.kwad.sdk.n;

import com.ksad.json.annotation.KsJson;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsJson
public class d extends com.kwad.sdk.core.response.a.a {
    public List<com.kwad.sdk.n.a.a> bbS;
    public List<String> bca;
    public List<a> bcb;
    public List<com.kwad.sdk.n.a.b> bcc;
    public long funcSwitch;
    public long byteCount = 1000;
    public double sampleRate = 1.0d;

    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String bcd;
        public String bce;
    }

    private boolean eZ(int i) {
        return (QM() || (this.funcSwitch & ((long) i)) == 0) ? false : true;
    }

    public final boolean QM() {
        return (this.funcSwitch & 1) == 0;
    }

    public final boolean QN() {
        return eZ(4);
    }

    public final boolean QO() {
        return eZ(16);
    }

    public final boolean QP() {
        return eZ(32);
    }
}
