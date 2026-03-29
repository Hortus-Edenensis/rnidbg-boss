package defpackage;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.efs.sdk.base.Constants;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.protocol.HTTP;
import org.jivesoftware.smack.util.GZipUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class rs3 extends Request<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MultipartEntityBuilder f20560a;
    public HttpEntity b;
    public String c;
    public final Response.Listener<String> d;
    public final File e;
    public final Map<String, String> f;
    public byte[] g;
    public String h;
    public int i;
    public boolean j;
    public Response.ErrorListener k;
    public Response.Listener<String> l;
    public Map<String, String> m;

    public rs3(String str, Response.ErrorListener errorListener, Response.Listener<String> listener, File file, String str2, Map<String, String> map) {
        super(1, str, errorListener);
        this.f20560a = MultipartEntityBuilder.create();
        this.m = new HashMap();
        this.d = listener;
        this.e = file;
        this.f = map;
        this.f20560a.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        this.k = errorListener;
        this.l = listener;
        this.c = str2;
        c();
    }

    public void addHeader(String str, String str2) {
        this.m.put(str, str2);
    }

    public void b(String str, byte[] bArr) {
        this.f20560a.addPart(str, new ByteArrayBody(bArr, str));
    }

    public final void c() {
        File file = this.e;
        if (file != null && file.exists()) {
            this.f20560a.addPart(this.c, new FileBody(this.e));
        }
        try {
            for (Map.Entry<String, String> entry : this.f.entrySet()) {
                this.f20560a.addTextBody(entry.getKey(), entry.getValue(), ContentType.create(HTTP.PLAIN_TEXT_TYPE, Consts.UTF_8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.android.volley.Request
    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HttpEntity httpEntityBuild = this.f20560a.build();
            this.b = httpEntityBuild;
            httpEntityBuild.writeTo(byteArrayOutputStream);
        } catch (IOException unused) {
            VolleyLog.e("IOException writing to ByteArrayOutputStream", new Object[0]);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return this.b.getContentType().getValue();
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        headers.putAll(this.m);
        return headers;
    }

    @Override // com.android.volley.Request
    public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            byte[] bArrDecompress = networkResponse.data;
            String charset = HttpHeaderParser.parseCharset(networkResponse.headers);
            String str = networkResponse.headers.get("Content-Encrypted-ZX");
            String str2 = networkResponse.headers.get("Content-Encoding-ZX");
            if (!TextUtils.isEmpty(str) && str.equals("1")) {
                if (this.i == 1) {
                    bArrDecompress = EncryptUtils.cipherWithType(bArrDecompress, 3, nl0.k());
                } else if (EncryptUtils.skeyAvailable()) {
                    bArrDecompress = EncryptUtils.cipherWithType(bArrDecompress, 5, nl0.k());
                }
            }
            if (!TextUtils.isEmpty(str2) && str2.equals(Constants.CP_GZIP)) {
                bArrDecompress = GZipUtil.decompress(bArrDecompress);
            }
            return Response.success(new String(bArrDecompress, charset), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Exception unused) {
            return Response.error(new ParseError(networkResponse));
        }
    }

    @Override // com.android.volley.Request
    public void deliverResponse(String str) {
        if (this.j && AppContext.getSecretKey() != null && str != null) {
            try {
                if (new JSONObject(str).optInt("resultCode") == 401) {
                    AppContext.getContext().initMessagingService(true, "STASRT_REASON_AUTHENTICATION_VALIDATEFAIL");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.d.onResponse(str);
    }

    public rs3(String str, Response.ErrorListener errorListener, Response.Listener<String> listener, File file, String str2, Map<String, String> map, boolean z) {
        this(str, errorListener, listener, file, str2, map);
        this.j = z;
    }

    public rs3(String str, Response.ErrorListener errorListener, Response.Listener<String> listener, File file, String str2, Map<String, String> map, byte[] bArr, String str3, int i) {
        this(str, errorListener, listener, file, str2, map);
        this.g = bArr;
        this.i = i;
        this.h = str3;
    }
}
