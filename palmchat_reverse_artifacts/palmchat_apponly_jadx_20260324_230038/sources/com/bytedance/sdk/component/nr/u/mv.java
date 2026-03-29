package com.bytedance.sdk.component.nr.u;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public enum mv {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String pn;

    mv(String str) {
        this.pn = str;
    }

    public static mv u(String str) throws IOException {
        mv mvVar = HTTP_1_0;
        if (str.equals(mvVar.pn)) {
            return mvVar;
        }
        mv mvVar2 = HTTP_1_1;
        if (str.equals(mvVar2.pn)) {
            return mvVar2;
        }
        mv mvVar3 = HTTP_2;
        if (str.equals(mvVar3.pn)) {
            return mvVar3;
        }
        mv mvVar4 = SPDY_3;
        if (str.equals(mvVar4.pn)) {
            return mvVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.pn;
    }
}
