package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11266a;
    private String b;

    public m(com.vivo.push.restructure.a.a aVar, String str) {
        if (aVar != null) {
            this.f11266a = aVar.a();
        }
        this.b = str;
    }

    public final com.vivo.push.b.h a() {
        if (!TextUtils.isEmpty(this.f11266a) && !TextUtils.isEmpty(this.b)) {
            return new com.vivo.push.b.h(this.f11266a, this.b);
        }
        t.a("convertOffLineMsg() error, mMessageID = " + this.f11266a + ", mNodeArrayInfo = " + this.b);
        return null;
    }
}
