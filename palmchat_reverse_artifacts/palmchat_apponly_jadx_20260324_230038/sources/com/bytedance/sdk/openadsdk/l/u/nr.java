package com.bytedance.sdk.openadsdk.l.u;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.nr.u.jk;
import com.bytedance.sdk.component.nr.u.k;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.gi.pn;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.l.u.u;
import com.kwad.sdk.api.model.AdnName;
import com.qiniu.android.collect.ReportItem;
import j$.util.Objects;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends u {
    private static final ConcurrentLinkedDeque<String> n = new ConcurrentLinkedDeque<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5419a;
    private final String jk;
    private String t;

    public nr(com.bytedance.sdk.openadsdk.l.u uVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(uVar, str, str2, jSONObject, str3, str4);
        this.jk = "index_censorship.json";
    }

    private boolean nr(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.bytedance.sdk.openadsdk.l.nr.nr.u(str, str2);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void fx() {
        if (n.contains(this.nr)) {
            this.u.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.l.u.nr.3
                @Override // java.lang.Runnable
                public void run() {
                    nr.this.u(null, com.bytedance.sdk.openadsdk.l.b.nr(dw.getContext()), dw.getContext(), -1L, -1L);
                }
            });
        } else if (this.b.compareAndSet(false, true)) {
            this.u.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.l.u.nr.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        nr.this.pn.set(true);
                        nr.this.pn();
                        nr.this.b.set(false);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0192 A[Catch: Exception -> 0x01ab, LOOP:0: B:80:0x0192->B:82:0x019a, LOOP_START, TryCatch #1 {Exception -> 0x01ab, blocks: (B:78:0x018e, B:80:0x0192, B:82:0x019a, B:83:0x019e, B:85:0x01a6), top: B:90:0x018e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void pn() {
        long j;
        ConcurrentLinkedDeque<String> concurrentLinkedDeque;
        byte[] bytes;
        File file;
        this.f5419a = System.currentTimeMillis();
        Context context = dw.getContext();
        String strU = u(context);
        if (b()) {
            return;
        }
        if (dw.nr().mk() == 1 && !o.b(context)) {
            u(null, com.bytedance.sdk.openadsdk.l.b.nr(context), context, -1L, -1L);
            return;
        }
        if (com.bytedance.sdk.openadsdk.l.b.fx()) {
            Runtime runtime = Runtime.getRuntime();
            long jFreeMemory = runtime.freeMemory() + (runtime.maxMemory() - runtime.totalMemory());
            File file2 = null;
            try {
                bytes = this.iz.toString().getBytes(StandardCharsets.UTF_8);
                if (dw.nr().kw() != 1 && !com.bytedance.sdk.openadsdk.l.nr.u.u(new ByteArrayInputStream(bytes), strU, "index_censorship.json", -2147483648L)) {
                    throw new b(false);
                }
                String strNr = com.bytedance.sdk.openadsdk.l.b.nr(context);
                File file3 = new File(strNr);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                String str = strNr + File.separator + this.nr + "-compress.zip";
                dw.nr().kw();
                file = new File(str);
            } catch (b e) {
                e = e;
            } catch (IOException unused) {
            }
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                String absolutePath = file.getAbsolutePath();
                if (dw.nr().kw() == 1) {
                    HashMap<String, byte[]> map = new HashMap<>();
                    map.put("index_censorship.json", bytes);
                    this.u.u().put("index_censorship.json", map);
                    if (TextUtils.isEmpty(strU) || !com.bytedance.sdk.openadsdk.l.nr.nr.u(this.u.u(), absolutePath)) {
                        throw new b(false);
                    }
                } else if (!nr(strU, absolutePath)) {
                    throw new b(false);
                }
                byte[] bArrU = com.bytedance.sdk.openadsdk.l.nr.u.u(absolutePath);
                long length = (int) new File(absolutePath).length();
                try {
                    long jNb = ((long) dw.nr().nb()) * 1048576;
                    dw.nr().nb();
                    if (length > jNb) {
                        throw new b(false);
                    }
                    if (length > jFreeMemory - 1048576) {
                        throw new b(false);
                    }
                    byte[] bArrU2 = u(bArrU, (int) length);
                    if (bArrU2 != null && bArrU2.length <= jNb) {
                        if (u(bArrU2, dw.nr().gc(), file) != 200) {
                            throw new b(false, bArrU2.length);
                        }
                        throw new b(true, bArrU2.length);
                    }
                    throw new b(false, true, bArrU2 == null ? 0L : bArrU2.length);
                } catch (b e2) {
                    e = e2;
                    j = length;
                    file2 = file;
                    try {
                        if (e.u) {
                            while (true) {
                                concurrentLinkedDeque = n;
                                if (concurrentLinkedDeque.size() <= 0) {
                                    break;
                                } else {
                                    concurrentLinkedDeque.pollLast();
                                }
                            }
                            if (!TextUtils.isEmpty(this.nr)) {
                                concurrentLinkedDeque.push(this.nr);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                    u(file2, strU, context, j, jFreeMemory);
                } catch (IOException unused3) {
                    j = length;
                    file2 = file;
                    u(file2, strU, context, j, jFreeMemory);
                }
            } catch (b e3) {
                e = e3;
                file2 = file;
                j = 0;
                if (e.u) {
                }
                u(file2, strU, context, j, jFreeMemory);
            } catch (IOException unused4) {
                file2 = file;
                j = 0;
                u(file2, strU, context, j, jFreeMemory);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void u(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void nr(Context context, String str, com.bytedance.sdk.openadsdk.l.nr nrVar, WebResourceResponse webResourceResponse, jk jkVar, Map<String, Object> map) {
        try {
            if (com.bytedance.sdk.openadsdk.l.b.fx()) {
                String strU = u(context);
                String string = nrVar.u().toString();
                String strNr = jkVar.nr();
                if (TextUtils.equals(strNr.toLowerCase(), "javascript")) {
                    strNr = "js";
                }
                File file = new File(strU);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str2 = x.nr(string) + "." + strNr;
                File file2 = new File(strU, str2);
                if (file2.exists()) {
                    file2.delete();
                    file2.createNewFile();
                }
                file2.getAbsolutePath();
                dw.nr().lf();
                if (com.bytedance.sdk.openadsdk.l.nr.u.u(webResourceResponse.getData(), strU, str2, dw.nr().lf())) {
                    u(this.iz, str, jkVar, str2, string, nrVar.fx(), map);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void u(final String str, final String str2) {
        s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.l.u.nr.1
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("cid", str);
                    jSONObject.put(ReportItem.RequestKeyRequestId, str2);
                } catch (Exception unused) {
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("web_upload_start").nr(jSONObject.toString());
            }
        }, "web_upload_start");
    }

    public void u(final String str, final String str2, final long j, final String str3, final long j2, final long j3) {
        s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.l.u.nr.2
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("cid", str);
                    jSONObject.put(ReportItem.RequestKeyRequestId, str2);
                    jSONObject.put("duration", System.currentTimeMillis() - j);
                    jSONObject.put("weburl", str3);
                    jSONObject.put("size", j2);
                    jSONObject.put("avail_mem", j3);
                } catch (Exception unused) {
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("web_upload_finish").nr(jSONObject.toString());
            }
        }, "web_upload_finish");
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public boolean u(WebView webView) {
        if (webView == null || n.contains(this.nr)) {
            return true;
        }
        AtomicBoolean atomicBoolean = this.pn;
        return (atomicBoolean != null && atomicBoolean.get()) || this.u.nr().get() > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void u(Context context, String str, com.bytedance.sdk.openadsdk.l.nr nrVar, WebResourceResponse webResourceResponse, jk jkVar, Map<String, Object> map) {
        int i;
        if (com.bytedance.sdk.openadsdk.l.b.fx()) {
            String string = nrVar.u().toString();
            String strNr = jkVar.nr();
            if (TextUtils.equals(strNr.toLowerCase(), "javascript")) {
                strNr = "js";
            }
            String str2 = x.nr(string) + "." + strNr;
            if (TextUtils.isEmpty(strNr)) {
                return;
            }
            HashMap<String, byte[]> map2 = this.u.u().get(strNr);
            if (map2 == null) {
                map2 = new HashMap<>();
                this.u.u().put(strNr, map2);
            }
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[1024];
            InputStream data = webResourceResponse.getData();
            while (true) {
                try {
                    i = 0;
                    if (data.read(bArr) == -1) {
                        break;
                    }
                    while (i < 1024) {
                        arrayList.add(Byte.valueOf(bArr[i]));
                        i++;
                    }
                } catch (Exception unused) {
                    if (data != null) {
                        try {
                            data.close();
                            return;
                        } catch (IOException unused2) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    if (data != null) {
                        try {
                            data.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
            byte[] bArr2 = new byte[arrayList.size()];
            while (i < arrayList.size()) {
                bArr2[i] = ((Byte) arrayList.get(i)).byteValue();
                i++;
            }
            if (arrayList.size() <= ((long) dw.nr().lf()) * 1048576) {
                map2.put(str2, bArr2);
                u(this.iz, str, jkVar, str2, string, nrVar.fx(), map);
            }
            try {
                data.close();
            } catch (IOException unused4) {
            }
        }
    }

    private int nr(byte[] bArr, int i, File file) {
        if (i <= 0) {
            return -1;
        }
        return u(bArr, i - 1, file);
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void u(JSONObject jSONObject, String str, jk jkVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("name", str2);
            jSONObject2.putOpt("url", str3);
            if (map != null) {
                jSONObject2.putOpt("request_headers", new JSONObject(map));
            }
            if (jkVar != null) {
                String lowerCase = jkVar.toString().toLowerCase();
                if (lowerCase.contains("image")) {
                    u(jSONObject2, jSONObject, "sub_pic");
                    return;
                }
                if (!lowerCase.contains("js") && !lowerCase.contains("javascript")) {
                    if (lowerCase.contains("css")) {
                        u(jSONObject2, jSONObject, "css");
                        return;
                    } else {
                        if (lowerCase.contains("html")) {
                            u(jSONObject2, jSONObject, "html");
                            return;
                        }
                        return;
                    }
                }
                u(jSONObject2, jSONObject, "js");
                return;
            }
            u(jSONObject2, jSONObject, AdnName.OTHER);
        } catch (JSONException unused) {
        }
    }

    private void u(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(str);
            if (jSONArrayOptJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.iz.putOpt(str, jSONArray);
            } else {
                jSONArrayOptJSONArray.put(jSONObject);
                this.iz.putOpt(str, jSONArrayOptJSONArray);
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void u() {
        try {
            this.iz.putOpt("html", new JSONArray());
            this.iz.putOpt("js", new JSONArray());
            this.iz.putOpt("css", new JSONArray());
            this.iz.putOpt("sub_pic", new JSONArray());
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public boolean u(jk jkVar) {
        try {
            Set<String> setV = dw.nr().v();
            String str = jkVar.u().trim().toLowerCase() + "/" + jkVar.nr().trim().toLowerCase();
            Objects.toString(setV);
            return setV.contains(str);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void u(com.bytedance.sdk.openadsdk.l.nr nrVar, WebResourceResponse webResourceResponse, jk jkVar, u.InterfaceC0310u interfaceC0310u) {
        interfaceC0310u.u(true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(File file, String str, Context context, long j, long j2) {
        try {
            com.bytedance.sdk.openadsdk.l.nr.u.nr(str);
            if (file != null && file.exists()) {
                file.delete();
            }
            AtomicInteger atomicInteger = com.bytedance.sdk.openadsdk.l.b.u;
            int i = atomicInteger.get();
            if (i > 0) {
                atomicInteger.decrementAndGet();
            }
            if (i == 0) {
                com.bytedance.sdk.openadsdk.l.nr.u.nr(com.bytedance.sdk.openadsdk.l.b.nr(context));
            }
            u(this.nr, this.fx, this.f5419a, this.x, j, j2);
        } catch (Exception unused) {
        }
    }

    private byte[] u(byte[] bArr, int i) {
        return com.bytedance.sdk.openadsdk.gi.nr.u(bArr, i);
    }

    private String u(Context context) {
        String str = this.t;
        if (str != null) {
            return str;
        }
        try {
            String str2 = com.bytedance.sdk.openadsdk.l.b.nr(context) + File.separator + this.nr;
            this.t = str2;
            return str2;
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            String str3 = File.separator;
            sb.append(str3);
            sb.append(".lp_cache");
            sb.append(str3);
            sb.append(this.nr);
            return sb.toString();
        }
    }

    private int u(byte[] bArr, int i, File file) {
        try {
            l lVarIz = pn.u().nr().iz();
            k kVarU = k.u(jk.u("multipart/form-data"), bArr, "file", file.getName());
            String strP = dw.nr().p();
            String str = "?aid=" + n.o().c() + "&device_platform=android&device_type=android&source_type=union";
            my myVarNr = lVarIz.u(new s.u().u(strP + str).u(kVarU).nr()).nr();
            if (myVarNr.fx() == 200) {
                JSONObject jSONObject = new JSONObject(myVarNr.iz().nr());
                int iOptInt = jSONObject.optInt("code");
                String strOptString = jSONObject.optString("msg");
                if (iOptInt == 0 && TextUtils.equals("success", strOptString)) {
                    return 200;
                }
                return nr(bArr, i, file);
            }
            return nr(bArr, i, file);
        } catch (Throwable th) {
            th.getMessage();
            return nr(bArr, i, file);
        }
    }
}
