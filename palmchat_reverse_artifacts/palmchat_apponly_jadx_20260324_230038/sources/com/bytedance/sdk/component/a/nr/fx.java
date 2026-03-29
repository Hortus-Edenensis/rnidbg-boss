package com.bytedance.sdk.component.a.nr;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.nr.u.iz;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.o;
import com.bytedance.sdk.component.nr.u.s;
import com.bytedance.sdk.component.nr.u.u;
import com.bytedance.sdk.component.nr.u.x;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5079a;
    private Map<String, String> jk;
    private com.bytedance.sdk.component.nr.u.u n;
    public static final com.bytedance.sdk.component.nr.u.u u = new u.C0227u().u().nr();
    public static final com.bytedance.sdk.component.nr.u.u nr = new u.C0227u().nr();

    public fx(l lVar) {
        super(lVar);
        this.n = u;
        this.f5079a = false;
        this.jk = new HashMap();
    }

    public void u(String str, String str2) {
        if (str == null) {
            return;
        }
        this.jk.put(str, str2);
    }

    public void u(final com.bytedance.sdk.component.a.u.u uVar) {
        try {
            s.u uVar2 = new s.u();
            if (this.f5079a) {
                uVar2.u(this.iz);
            } else {
                x.u uVar3 = new x.u();
                Uri uri = Uri.parse(this.iz);
                uVar3.u(uri.getScheme());
                uVar3.nr(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    uVar3.fx(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.jk.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.jk.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        uVar3.u(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                uVar2.u(uVar3.nr());
            }
            u(uVar2);
            uVar2.u(this.n);
            uVar2.u((Object) nr());
            this.fx.u(uVar2.u().nr()).u(new com.bytedance.sdk.component.nr.u.fx() { // from class: com.bytedance.sdk.component.a.nr.fx.1
                @Override // com.bytedance.sdk.component.nr.u.fx
                public void onFailure(com.bytedance.sdk.component.nr.u.nr nrVar, IOException iOException) {
                    com.bytedance.sdk.component.a.u.u uVar4 = uVar;
                    if (uVar4 != null) {
                        uVar4.u(fx.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.nr.u.fx
                public void onResponse(com.bytedance.sdk.component.nr.u.nr nrVar, my myVar) throws IOException {
                    if (uVar != null) {
                        HashMap map = new HashMap();
                        if (myVar != null) {
                            iz izVarX = myVar.x();
                            if (izVarX != null) {
                                for (int i = 0; i < izVarX.u(); i++) {
                                    map.put(izVarX.u(i), izVarX.nr(i));
                                }
                            }
                            o oVarIz = myVar.iz();
                            uVar.u(fx.this, new com.bytedance.sdk.component.a.nr(myVar.b(), myVar.fx(), myVar.pn(), map, oVarIz == null ? "" : oVarIz.nr(), myVar.nr(), myVar.u()));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (uVar != null) {
                uVar.u(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.a.nr.b
    public com.bytedance.sdk.component.a.nr u() {
        try {
            s.u uVar = new s.u();
            String strNr = "";
            if (this.f5079a) {
                uVar.u(this.iz);
            } else {
                x.u uVar2 = new x.u();
                Uri uri = Uri.parse(this.iz);
                uVar2.u(uri.getScheme());
                uVar2.nr(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    uVar2.fx(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.jk.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.jk.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        uVar2.u(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                uVar.u(uVar2.nr());
            }
            u(uVar);
            uVar.u(this.n);
            uVar.u((Object) nr());
            my myVarNr = this.fx.u(uVar.u().nr()).nr();
            if (myVarNr == null) {
                return null;
            }
            HashMap map = new HashMap();
            iz izVarX = myVarNr.x();
            if (izVarX != null) {
                for (int i = 0; i < izVarX.u(); i++) {
                    map.put(izVarX.u(i), izVarX.nr(i));
                }
            }
            o oVarIz = myVarNr.iz();
            if (oVarIz != null) {
                strNr = oVarIz.nr();
            }
            return new com.bytedance.sdk.component.a.nr(myVarNr.b(), myVarNr.fx(), myVarNr.pn(), map, strNr, myVarNr.nr(), myVarNr.u());
        } catch (Throwable unused) {
            return null;
        }
    }
}
