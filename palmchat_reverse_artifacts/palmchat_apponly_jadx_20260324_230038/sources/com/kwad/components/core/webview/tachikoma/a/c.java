package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.sdk.components.m;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class c implements m {
    public abstract void b(a.C0563a c0563a);

    @Override // com.kwad.sdk.components.m
    public final Object call(@Nullable Object... objArr) {
        String str = " ";
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof String) {
                        str = (String) obj;
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                return null;
            }
        }
        a.C0563a c0563a = new a.C0563a();
        c0563a.parseJson(new JSONObject(str));
        b(c0563a);
        return null;
    }
}
