package com.zenmen.palmchat.fileupload.blockupload;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.fileupload.blockupload.CancellationHandler;
import com.zenmen.palmchat.fileupload.dao.BlockVo;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b13;
import defpackage.hx3;
import defpackage.it0;
import defpackage.k86;
import defpackage.nl0;
import defpackage.te1;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b {
    public static final String i = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MultipartEntityBuilder f13953a;
    public String b;
    public int c;
    public int d;
    public String e;
    public BlockVo f;
    public String g;
    public int h = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "start_upload_chunk");
            put("uploadUrl", b.this.b);
            put("mid", b.this.e);
            put("blockInfo", b.this.f.toString());
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.fileupload.blockupload.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1047b extends HashMap<String, Object> {
        public C1047b() {
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "finish_upload_chunk");
            put("uploadUrl", b.this.b);
            put("mid", b.this.e);
            put("blockInfo", b.this.f.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13956a;

        public c(String str) {
            this.f13956a = str;
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "finish_upload_chunk");
            put("detail", str);
            put("uploadUrl", b.this.b);
            put("mid", b.this.e);
            put("blockInfo", b.this.f.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "start_upload_task");
            put("uploadUrl", b.this.b);
            put("currentRetryCount", Integer.valueOf(b.this.h));
            put("mid", b.this.e);
            put("blockInfo", b.this.f.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13958a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public e(int i, String str, String str2) {
            this.f13958a = i;
            this.b = str;
            this.c = str2;
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "finish_upload_task");
            put("responseCode", Integer.valueOf(i));
            put("responseMessage", str);
            put("uploadUrl", str2);
            put("mid", b.this.e);
            put("blockInfo", b.this.f.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Exception f13959a;
        public final /* synthetic */ String b;

        public f(Exception exc, String str) {
            this.f13959a = exc;
            this.b = str;
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "finish_upload_task");
            put("error", exc.toString());
            put("uploadUrl", str);
            put("mid", b.this.e);
            put("blockInfo", b.this.f.toString());
        }
    }

    public b(MultipartEntityBuilder multipartEntityBuilder, BlockVo blockVo, String str, int i2, int i3, String str2, String str3) {
        this.f13953a = multipartEntityBuilder;
        this.c = i2;
        this.d = i3;
        this.e = str2;
        this.f = blockVo;
        this.g = str3;
        try {
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            if (!TextUtils.isEmpty(str3)) {
                builderBuildUpon.appendQueryParameter("upToken", str3);
            }
            this.b = k86.Z(builderBuildUpon.build().toString());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    public static int f() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) ? (activeNetworkInfo != null || hx3.g() <= 2) ? 1024 : 10240 : x.e;
    }

    public final String e(String str, Map<String, String> map) throws CancellationHandler.CancellationException {
        byte[] bArrCipherWithType;
        String str2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection(Proxy.NO_PROXY);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(90000);
            httpURLConnection.setReadTimeout(90000);
            HttpEntity httpEntityBuild = this.f13953a.build();
            httpURLConnection.setRequestProperty("Content-Type", httpEntityBuild.getContentType().getValue());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    httpURLConnection.addRequestProperty(str3, map.get(str3));
                }
            }
            b13.a(httpURLConnection);
            if (httpURLConnection instanceof HttpsURLConnection) {
                HttpsHelper.getmInstance();
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(HttpsHelper.DO_NOT_VERIFY);
            }
            httpURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            httpEntityBuild.writeTo(dataOutputStream);
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            LogUtil.i(i, 3, new e(responseCode, httpURLConnection.getResponseMessage(), str), (Throwable) null);
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = inputStream.read(bArr, 0, 1024);
                    if (i2 <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
                inputStream.close();
                byteArrayOutputStream.close();
                String str4 = new String(byteArrayOutputStream.toByteArray());
                String headerField = httpURLConnection.getHeaderField("Content-Encrypted-ZX");
                if (!TextUtils.isEmpty(headerField) && headerField.equals("1") && EncryptUtils.skeyAvailable() && (bArrCipherWithType = EncryptUtils.cipherWithType(byteArrayOutputStream.toByteArray(), 5, nl0.k())) != null) {
                    str4 = new String(bArrCipherWithType);
                }
                str2 = str4;
            }
            httpURLConnection.disconnect();
        } catch (CancellationHandler.CancellationException e2) {
            throw e2;
        } catch (Exception e3) {
            LogUtil.i(i, 3, new f(e3, str), e3);
        }
        return str2;
    }

    public final String g() throws CancellationHandler.CancellationException {
        LogUtil.i(i, 3, new d(), (Throwable) null);
        if (this.f13953a == null || this.b == null) {
            return null;
        }
        return i();
    }

    public String h() {
        LogUtil.i(i, 3, new a(), (Throwable) null);
        String strG = null;
        for (int i2 = 0; i2 < this.d; i2++) {
            try {
                strG = g();
                if (!TextUtils.isEmpty(strG)) {
                    break;
                }
                this.h++;
            } catch (Exception e2) {
                LogUtil.i(i, 3, new C1047b(), e2);
            }
        }
        LogUtil.i(i, 3, new c(strG), (Throwable) null);
        return strG;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
    
        r0 = e(r0, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0077, code lost:
    
        defpackage.it0.k().s("all ip failed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String i() throws CancellationHandler.CancellationException {
        String str = this.b;
        Iterator<te1> it = it0.k().g().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            te1 next = it.next();
            if (next.a(str)) {
                int i2 = 0;
                while (true) {
                    if (i2 >= 2) {
                        break;
                    }
                    DNSNode[] dNSNodeArrI = it0.k().i(next.f20971a);
                    if (dNSNodeArrI != null) {
                        for (DNSNode dNSNode : dNSNodeArrI) {
                            String strQ = it0.q(str, next, dNSNode);
                            HashMap map = new HashMap();
                            map.put("Host", next.f20971a);
                            String strE = e(strQ, map);
                            if (!TextUtils.isEmpty(strE)) {
                                return strE;
                            }
                        }
                    } else {
                        if (!it0.k().n() || i2 != 0) {
                            break;
                        }
                        it0.k().t("dns cache is empty when doing HTTP request");
                        i2++;
                    }
                }
            }
        }
    }
}
