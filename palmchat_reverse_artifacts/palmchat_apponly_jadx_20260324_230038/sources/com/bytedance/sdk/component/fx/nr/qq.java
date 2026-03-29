package com.bytedance.sdk.component.fx.nr;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public enum qq {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String pn;

    qq(String str) {
        this.pn = str;
    }

    public static qq u(String str) throws IOException {
        qq qqVar = HTTP_1_0;
        if (str.equals(qqVar.pn)) {
            return qqVar;
        }
        qq qqVar2 = HTTP_1_1;
        if (str.equals(qqVar2.pn)) {
            return qqVar2;
        }
        qq qqVar3 = HTTP_2;
        if (str.equals(qqVar3.pn)) {
            return qqVar3;
        }
        qq qqVar4 = SPDY_3;
        if (str.equals(qqVar4.pn)) {
            return qqVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.pn;
    }
}
