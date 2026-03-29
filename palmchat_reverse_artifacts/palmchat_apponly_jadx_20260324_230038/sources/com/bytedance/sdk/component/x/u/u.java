package com.bytedance.sdk.component.x.u;

import android.util.Base64;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.component.b.nr.u {
    @Override // com.bytedance.sdk.component.b.nr.u
    public String decrypt(String str) {
        return new String(Base64.decode(str.toString().getBytes(Charset.forName("UTF-8")), 0), Charset.forName("UTF-8"));
    }

    @Override // com.bytedance.sdk.component.b.nr.u
    public String encrypt(String str) {
        return Base64.encodeToString(str.toString().getBytes(Charset.forName("UTF-8")), 0);
    }

    @Override // com.bytedance.sdk.component.b.nr.u
    public int type() {
        return 32;
    }
}
