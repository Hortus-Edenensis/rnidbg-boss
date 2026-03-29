package com.bytedance.sdk.openadsdk.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.nr.u.iz;
import com.bytedance.sdk.component.nr.u.jk;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.gi.pn;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.l.u.u;
import com.qiniu.android.collect.ReportItem;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements u {
    public static final AtomicInteger u = new AtomicInteger(0);
    private String iz;
    private List<com.bytedance.sdk.openadsdk.l.u.u> b = new ArrayList();
    private HashMap<String, HashMap<String, byte[]>> pn = new HashMap<>();
    public AtomicInteger nr = new AtomicInteger(0);
    final ExecutorService fx = x.u();

    private b(fx fxVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        if (fxVar != null) {
            if (fxVar.u()) {
                com.bytedance.sdk.openadsdk.l.u.nr nrVar = new com.bytedance.sdk.openadsdk.l.u.nr(this, str, str2, jSONObject, str3, str4);
                nrVar.nr();
                this.b.add(nrVar);
            }
            if (fxVar.nr()) {
                com.bytedance.sdk.openadsdk.l.u.fx fxVar2 = new com.bytedance.sdk.openadsdk.l.u.fx(this, str, str2, jSONObject, str3, str4);
                fxVar2.nr();
                this.b.add(fxVar2);
            }
            this.iz = str4;
            u.incrementAndGet();
            u((WebView) null, this.iz);
        }
    }

    public static boolean fx() {
        return true;
    }

    private String u(int i) {
        if (i == 100) {
            return "Continue";
        }
        if (i == 101) {
            return "Switching Protocols";
        }
        switch (i) {
            case 200:
                return "OK";
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative Information";
            case 204:
                return "No Content";
            case 205:
                return "Reset Content";
            case 206:
                return "Partial Content";
            default:
                switch (i) {
                    case 400:
                        return "Bad Request";
                    case 401:
                        return "Unauthorized";
                    case 402:
                        return "Payment Required";
                    case 403:
                        return "Forbidden";
                    case 404:
                        return "Not Found";
                    case 405:
                        return "Method Not Allowed";
                    case 406:
                        return "Not Acceptable";
                    case 407:
                        return "Proxy Authentication Required";
                    case 408:
                        return "Request Time-out";
                    case 409:
                        return "Conflict";
                    case 410:
                        return "Gone";
                    case 411:
                        return "Length Required";
                    case 412:
                        return "Precondition Failed";
                    case 413:
                        return "Request Entity Too Large";
                    case 414:
                        return "Request-URI Too Large";
                    case 415:
                        return "Unsupported Media Type";
                    case 416:
                        return "Requested range not satisfiable";
                    case 417:
                        return "Expectation Failed";
                    default:
                        switch (i) {
                            case 500:
                                return "Internal Server Error";
                            case 501:
                                return "Not Implemented";
                            case 502:
                                return "Bad Gateway";
                            case 503:
                                return "Service Unavailable";
                            case 504:
                                return "Gateway Time-out";
                            case 505:
                                return "HTTP Version not supported";
                            default:
                                return "";
                        }
                }
        }
    }

    public void b() {
        if (!this.b.isEmpty()) {
            Iterator<com.bytedance.sdk.openadsdk.l.u.u> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().fx();
            }
        }
        this.b.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.l.u
    public AtomicInteger nr() {
        return this.nr;
    }

    public WebResourceResponse nr(WebView webView, final nr nrVar, WebResourceResponse webResourceResponse) {
        String strNr;
        if (nrVar != null && (strNr = nrVar.nr()) != null && TextUtils.equals(strNr, "get")) {
            if (dw.nr().eh() == 1) {
                WebResourceResponse webResourceResponseU = u(dw.getContext(), this.iz, nrVar);
                if (webResourceResponseU != null) {
                    webResourceResponseU.getResponseHeaders().put("Access-Control-Allow-Origin", "*");
                    return webResourceResponseU;
                }
            } else {
                u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.l.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.u(dw.getContext(), b.this.iz, nrVar);
                    }
                });
            }
        }
        return webResourceResponse;
    }

    @Override // com.bytedance.sdk.openadsdk.l.u
    public HashMap<String, HashMap<String, byte[]>> u() {
        return this.pn;
    }

    public static fx u(bc bcVar, Context context) {
        boolean z = false;
        boolean z2 = bcVar.ge() == 1;
        boolean zU = com.bytedance.sdk.openadsdk.core.iz.nr.u(bcVar.pn() / 100.0f, false);
        boolean z3 = dw.nr().ay() == 1;
        boolean z4 = o.b(context) || !(dw.nr().mk() == 1);
        boolean zFx = fx();
        boolean z5 = z2 && z3 && z4 && zFx;
        if (zU && z3 && zFx) {
            z = true;
        }
        fx fxVar = new fx();
        fxVar.u(z5);
        fxVar.nr(z);
        return fxVar;
    }

    public static String nr(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context).getAbsolutePath() + File.separator + ".lp_cache";
    }

    public static b u(Context context, bc bcVar, String str) {
        JSONObject jSONObjectTq;
        fx fxVarU = u(bcVar, context);
        if ((!fxVarU.u() && !fxVarU.nr()) || (jSONObjectTq = bcVar.tq()) == null) {
            return null;
        }
        String strOptString = jSONObjectTq.optString("cid");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        String strOptString2 = jSONObjectTq.optString(ReportItem.RequestKeyRequestId);
        if (TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new b(fxVarU, strOptString, strOptString2, jSONObjectTq, bcVar.ap(), str);
    }

    public WebResourceResponse u(WebView webView, nr nrVar, WebResourceResponse webResourceResponse) {
        Iterator<com.bytedance.sdk.openadsdk.l.u.u> it = this.b.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().u(webView)) {
                z = true;
            }
        }
        return !z ? webResourceResponse : nr(webView, nrVar, webResourceResponse);
    }

    @Override // com.bytedance.sdk.openadsdk.l.u
    public void u(final Runnable runnable) {
        this.fx.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.l.b.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this.fx) {
                    try {
                        runnable.run();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public WebResourceResponse u(final Context context, final String str, final nr nrVar) {
        WebResourceResponse webResourceResponse;
        final Pair<WebResourceResponse, WebResourceResponse> pairU;
        final Pair<WebResourceResponse, jk> pairU2 = u(nrVar);
        if (pairU2 == null || (webResourceResponse = (WebResourceResponse) pairU2.first) == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.openadsdk.l.u.u> it = this.b.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().u((jk) pairU2.second)) {
                z = true;
            }
        }
        if (!z || (pairU = u(webResourceResponse)) == null) {
            return null;
        }
        for (final com.bytedance.sdk.openadsdk.l.u.u uVar : this.b) {
            uVar.u(nrVar, (WebResourceResponse) pairU.second, (jk) pairU2.second, new u.InterfaceC0310u() { // from class: com.bytedance.sdk.openadsdk.l.b.3
                @Override // com.bytedance.sdk.openadsdk.l.u.u.InterfaceC0310u
                public void u(boolean z2, final Map<String, Object> map) {
                    if (z2) {
                        b.this.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.l.b.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    AtomicBoolean atomicBoolean = uVar.pn;
                                    if (atomicBoolean == null || atomicBoolean.get()) {
                                        return;
                                    }
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    b.this.u(context, str, nrVar, (WebResourceResponse) pairU.second, (jk) pairU2.second, map, uVar);
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    }
                }
            });
        }
        return (WebResourceResponse) pairU.first;
    }

    public void u(Context context, String str, nr nrVar, WebResourceResponse webResourceResponse, jk jkVar, Map<String, Object> map, com.bytedance.sdk.openadsdk.l.u.u uVar) {
        if (uVar.u(jkVar)) {
            dw.nr().kw();
            if (dw.nr().kw() == 1) {
                uVar.u(context, str, nrVar, webResourceResponse, jkVar, map);
            } else {
                uVar.nr(context, str, nrVar, webResourceResponse, jkVar, map);
            }
        }
    }

    private Pair<WebResourceResponse, WebResourceResponse> u(WebResourceResponse webResourceResponse) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (com.bytedance.sdk.openadsdk.l.nr.nr.u(webResourceResponse.getData(), byteArrayOutputStream) != -1) {
                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                try {
                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                } catch (Exception unused) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                    byteArrayInputStream2 = null;
                }
            } else {
                byteArrayInputStream = null;
                byteArrayInputStream2 = null;
            }
        } catch (Exception unused3) {
            byteArrayInputStream = null;
        }
        if (!fx()) {
            return null;
        }
        String mimeType = webResourceResponse.getMimeType();
        String encoding = webResourceResponse.getEncoding();
        int statusCode = webResourceResponse.getStatusCode();
        String reasonPhrase = webResourceResponse.getReasonPhrase();
        Map<String, String> responseHeaders = webResourceResponse.getResponseHeaders();
        if (byteArrayInputStream == null) {
            byteArrayInputStream = new ByteArrayInputStream(new byte[0]);
        }
        WebResourceResponse webResourceResponse2 = new WebResourceResponse(mimeType, encoding, statusCode, reasonPhrase, responseHeaders, byteArrayInputStream);
        String mimeType2 = webResourceResponse.getMimeType();
        String encoding2 = webResourceResponse.getEncoding();
        int statusCode2 = webResourceResponse.getStatusCode();
        String reasonPhrase2 = webResourceResponse.getReasonPhrase();
        Map<String, String> responseHeaders2 = webResourceResponse.getResponseHeaders();
        if (byteArrayInputStream2 == null) {
            byteArrayInputStream2 = new ByteArrayInputStream(new byte[0]);
        }
        return new Pair<>(webResourceResponse2, new WebResourceResponse(mimeType2, encoding2, statusCode2, reasonPhrase2, responseHeaders2, byteArrayInputStream2));
    }

    private Pair<WebResourceResponse, jk> u(nr nrVar) {
        if (fx() && nrVar != null) {
            try {
                l lVarIz = pn.u().nr().iz();
                s.u uVar = new s.u();
                Map<String, String> mapFx = nrVar.fx();
                if (mapFx != null) {
                    for (String str : mapFx.keySet()) {
                        uVar.nr(str, mapFx.get(str));
                    }
                }
                uVar.u(nrVar.u().toString());
                my myVarNr = lVarIz.u(uVar.nr()).nr();
                int iFx = myVarNr.fx();
                if (iFx == 200) {
                    HashMap map = new HashMap();
                    iz izVarX = myVarNr.x();
                    if (izVarX != null) {
                        for (int i = 0; i < izVarX.u(); i++) {
                            map.put(izVarX.u(i), izVarX.nr(i));
                        }
                    }
                    InputStream inputStreamFx = myVarNr.iz().fx();
                    jk jkVarU = u(map);
                    return new Pair<>(new WebResourceResponse(jkVarU.u() + "/" + jkVarU.nr(), jkVarU.fx() == null ? null : jkVarU.fx().toString(), iFx, u(iFx), map, inputStreamFx), jkVarU);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private jk u(Map<String, String> map) {
        String str;
        if (map == null) {
            str = null;
        } else if (map.containsKey("Content-Type")) {
            str = map.get("Content-Type");
        } else if (map.containsKey("content-type")) {
            str = map.get("content-type");
        } else if (map.containsKey("CONTENT-TYPE")) {
            str = map.get("CONTENT-TYPE");
        }
        if (TextUtils.isEmpty(str)) {
            str = "text/html; charset=UTF-8";
        }
        return jk.u(str);
    }

    public static void u(Context context) {
        if (fx()) {
            try {
                File file = new File(nr(context));
                if (System.currentTimeMillis() - file.lastModified() <= 3000 || !file.exists()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.l.nr.u.nr(nr(context));
            } catch (Throwable unused) {
            }
        }
    }

    public void u(WebView webView, String str) {
        if (o.u(str)) {
            this.nr.incrementAndGet();
            this.nr.get();
            Iterator<com.bytedance.sdk.openadsdk.l.u.u> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().u(str);
            }
        }
    }
}
