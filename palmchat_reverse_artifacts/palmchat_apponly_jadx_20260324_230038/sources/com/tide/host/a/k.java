package com.tide.host.a;

import android.text.TextUtils;
import com.tide.protocol.config.TideWholeConfig;
import com.tide.protocol.model.JsonFactory;
import com.tide.protocol.util.TdLogUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class k extends r {
    public final JsonFactory g;
    public final String h;

    public k(String str, String str2, TideWholeConfig tideWholeConfig, w wVar) {
        super(str2, tideWholeConfig, new z());
        this.g = wVar;
        this.c.put("Content-Type", "application/json");
        this.h = str;
    }

    public static boolean a(k kVar, int i) {
        kVar.getClass();
        return i == 408 || i == 429 || i == 500 || i == 502 || i == 503 || i == 504;
    }

    public final void a(final s sVar) {
        if (sVar == null) {
            TdLogUtils.error("EncryptedPostRequest", "callback is null");
            return;
        }
        if (this.f10798a >= 3) {
            sVar.a(-1, "Failed to execute request after 3 attempts.");
            return;
        }
        if (TextUtils.isEmpty(this.h)) {
            sVar.a(-1, "Failed to execute request cause no plugin found");
            return;
        }
        String json = this.d.toJson(this.h);
        TdLogUtils.log("EncryptedPostRequest", "execute url " + this.b + " body " + json);
        final String str = "{\"data\":\"" + a.b(json) + "\"}";
        r.f.submit(new Runnable() { // from class: tf7
            @Override // java.lang.Runnable
            public final void run() {
                this.f20978a.a(str, sVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, s sVar) {
        t.a(this.b, str, this.c, new j(this, sVar));
    }
}
