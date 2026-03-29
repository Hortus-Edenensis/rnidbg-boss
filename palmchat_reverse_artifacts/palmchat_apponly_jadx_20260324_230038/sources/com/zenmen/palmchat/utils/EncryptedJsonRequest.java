package com.zenmen.palmchat.utils;

import android.text.TextUtils;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.LxRetryCacheHelper;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.HttpHeaderParser;
import com.efs.sdk.base.Constants;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.aw;
import defpackage.bx4;
import defpackage.nl0;
import defpackage.pw3;
import defpackage.vs0;
import defpackage.z92;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.util.GZipUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class EncryptedJsonRequest extends Request<JSONObject> {
    public static final String JSON_PARSE_ERROR = "json_parse_error";
    private static final String PROTOCOL_CHARSET = "utf-8";
    public static final String TAG = "EncryptedJsonRequest";
    public static final String TAG_LXSK = "EncryptedJsonRequest_LXSK";
    private boolean isBodyEncrypted;
    private JSONObject jsonRequest;
    private Map<String, String> mHeaders;
    private int mKeyType;
    private Response.Listener<JSONObject> mListener;
    private byte[] mRequestBody;
    private DefaultRetryPolicy mTokenDefaultRetryPolicy;
    private boolean needCheckUrlToken;
    public final Object tokenWaitObj;
    private boolean zipped;
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/octet-stream; charset=%s", "utf-8");
    public static boolean ENCRYPT_CHECK_ENABLE = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetworkResponse f15689a;

        public a(NetworkResponse networkResponse) {
            this.f15689a = networkResponse;
            put("action", LogUtil.VALUE_ACTION_PARSE_ENCRYPT_RESPONSE);
            put("status", "fail");
            put("detail", "response content is ignored, code=" + networkResponse.statusCode);
        }
    }

    public EncryptedJsonRequest(int i, String str, JSONObject jSONObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this(i, str, jSONObject, 2, false, listener, errorListener);
    }

    private boolean inWhiteList(String str) {
        if (str != null) {
            if (str.contains(z92.e) || str.contains(z92.c) || !str.startsWith(nl0.z)) {
                return true;
            }
            if (str.startsWith(nl0.z) && vs0.a().e("needGateWayBodyEncrypt", false)) {
                return true;
            }
        }
        return nl0.i(str);
    }

    public void addHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    public void encryptBodyWithSkey() {
        try {
            JSONObject jSONObject = this.jsonRequest;
            if (jSONObject != null) {
                byte[] bArrCompress = this.zipped ? GZipUtil.compress(jSONObject.toString().getBytes("utf-8")) : jSONObject.toString().getBytes("utf-8");
                if (EncryptUtils.skeyAvailable()) {
                    this.mKeyType = 2;
                    this.mRequestBody = EncryptUtils.cipherWithType(bArrCompress, 4, nl0.k());
                    this.isBodyEncrypted = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.android.volley.Request
    public byte[] getBody() throws AuthFailureError {
        return this.mRequestBody;
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        headers.putAll(this.mHeaders);
        return headers;
    }

    @Override // com.android.volley.Request
    public byte[] getPostBody() throws AuthFailureError {
        return getBody();
    }

    @Override // com.android.volley.Request
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    public RetryPolicy getTokenRetryPolicy() {
        return this.mTokenDefaultRetryPolicy;
    }

    public boolean isBodyEncrypted() {
        return this.isBodyEncrypted;
    }

    public boolean isNeedCheckUrlToken() {
        return this.needCheckUrlToken;
    }

    @Override // com.android.volley.Request
    public Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {
        Cache.Entry cacheHeaders;
        aw awVar;
        try {
            String charset = HttpHeaderParser.parseCharset(networkResponse.headers);
            byte[] bArrDecompress = networkResponse.data;
            String str = networkResponse.headers.get("Content-Encrypted-ZX");
            String str2 = networkResponse.headers.get("Content-Encoding-ZX");
            if (!TextUtils.isEmpty(str) && str.equals("1")) {
                int i = this.mKeyType;
                if (i == 1) {
                    bArrDecompress = EncryptUtils.cipherWithType(networkResponse.data, 3, nl0.k());
                } else if (i == 2) {
                    bArrDecompress = EncryptUtils.cipherWithType(networkResponse.data, 5, nl0.k());
                }
                if (bArrDecompress == null) {
                    Log.e(TAG, "decrypt data is null");
                }
            }
            if (!TextUtils.isEmpty(str2) && str2.equals(Constants.CP_GZIP)) {
                bArrDecompress = GZipUtil.decompress(bArrDecompress);
            }
            JSONObject jSONObject = new JSONObject(new String(bArrDecompress, charset));
            if (shouldCache() && (awVar = this.cacheConfig) != null && awVar.e(jSONObject)) {
                networkResponse.headers.remove("Content-Encrypted-ZX");
                networkResponse.headers.remove("Content-Encoding-ZX");
                cacheHeaders = HttpHeaderParser.parseCacheHeaders(networkResponse);
                if (cacheHeaders != null) {
                    LxRetryCacheHelper.fixEntryWithCacheConfig(cacheHeaders, this.cacheConfig);
                    cacheHeaders.data = bArrDecompress;
                }
            } else {
                cacheHeaders = null;
            }
            return Response.success(jSONObject, cacheHeaders);
        } catch (Throwable th) {
            LogUtil.i(TAG, 3, new a(networkResponse), th);
            return Response.error(new ParseError(th));
        }
    }

    public EncryptedJsonRequest(int i, String str, JSONObject jSONObject, boolean z, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this(i, str, jSONObject, 2, z, listener, errorListener);
    }

    @Override // com.android.volley.Request
    public void deliverResponse(JSONObject jSONObject) {
        if (EncryptUtils.skeyAvailable() && jSONObject != null && jSONObject.optInt("resultCode") == 401) {
            bx4.e(getUrl());
            LogUtil.e(TAG_LXSK, "sk error STASRT_REASON_AUTHENTICATION_VALIDATEFAIL " + getUrl());
            AppContext.getContext().initMessagingService(true, "STASRT_REASON_AUTHENTICATION_VALIDATEFAIL");
        }
        this.mListener.onResponse(jSONObject);
    }

    public EncryptedJsonRequest(int i, String str, JSONObject jSONObject, int i2, boolean z, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        byte[] bytes;
        super(i, str, errorListener);
        this.isBodyEncrypted = false;
        this.jsonRequest = null;
        this.zipped = false;
        this.needCheckUrlToken = true;
        this.mTokenDefaultRetryPolicy = new DefaultRetryPolicy(500, 3, 1.0f);
        this.tokenWaitObj = new Object();
        this.mHeaders = new HashMap();
        pw3.c(str, i, jSONObject);
        this.mKeyType = i2;
        this.mListener = listener;
        this.jsonRequest = jSONObject;
        this.zipped = z;
        try {
            if (jSONObject != null) {
                if (z) {
                    bytes = GZipUtil.compress(jSONObject.toString().getBytes("utf-8"));
                } else {
                    bytes = jSONObject.toString().getBytes("utf-8");
                }
                if (z) {
                    addHeader("Content-Encoding-ZX", Constants.CP_GZIP);
                }
                int i3 = this.mKeyType;
                if (i3 == 2) {
                    if (str != null && str.startsWith("https://") && !inWhiteList(str)) {
                        this.mRequestBody = bytes;
                        this.isBodyEncrypted = true;
                        return;
                    }
                    addHeader("Content-Encrypted-ZX", "1");
                    try {
                        if (EncryptUtils.skeyAvailable()) {
                            this.mRequestBody = EncryptUtils.cipherWithType(bytes, 4, nl0.k());
                            this.isBodyEncrypted = true;
                            return;
                        }
                        return;
                    } catch (UnsatisfiedLinkError e) {
                        e.printStackTrace();
                        return;
                    }
                }
                if (i3 == 1) {
                    addHeader("Content-Encrypted-ZX", "1");
                    EncryptUtils.createCKey();
                    String hexString = HexDumper.toHexString(EncryptUtils.getEncryptedCKey(nl0.k()));
                    this.mRequestBody = EncryptUtils.cipherWithHashKey(jSONObject, 2, nl0.k());
                    addHeader("Content-CKey", hexString);
                    addHeader("Content-CKey-Version", EncryptUtils.getCkVersion());
                    this.isBodyEncrypted = true;
                    this.needCheckUrlToken = false;
                    return;
                }
                if (i3 == 3) {
                    addHeader("Content-Encrypted-ZX", "1");
                    this.mRequestBody = EncryptUtils.cipherWithType(bytes, 1, nl0.k());
                    this.isBodyEncrypted = true;
                    addHeader("PK-VER-ZX", "1.0");
                    this.needCheckUrlToken = false;
                    return;
                }
                Log.e(TAG, "no key type given and do nothing for the content");
                return;
            }
            this.isBodyEncrypted = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public EncryptedJsonRequest(int i, String str, byte[] bArr, int i2, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this(i, str, bArr, (JSONObject) null, i2, listener, errorListener);
    }

    public EncryptedJsonRequest(int i, String str, byte[] bArr, JSONObject jSONObject, int i2, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.isBodyEncrypted = false;
        this.jsonRequest = null;
        this.zipped = false;
        this.needCheckUrlToken = true;
        this.mTokenDefaultRetryPolicy = new DefaultRetryPolicy(500, 3, 1.0f);
        this.tokenWaitObj = new Object();
        this.mHeaders = new HashMap();
        pw3.c(str, 1, jSONObject);
        this.mRequestBody = bArr;
        this.mKeyType = i2;
        this.mListener = listener;
        this.isBodyEncrypted = true;
        this.needCheckUrlToken = false;
        addHeader("Content-Encrypted-ZX", "1");
        if (this.mKeyType == 3) {
            addHeader("PK-VER-ZX", "1.0");
        }
    }
}
