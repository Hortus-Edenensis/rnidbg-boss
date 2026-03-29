package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.LxRetryCacheHelper;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class JsonObjectRequest extends JsonRequest<JSONObject> {
    private Map<String, String> mHeaders;

    public JsonObjectRequest(int i, String str, JSONObject jSONObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), listener, errorListener);
        this.mHeaders = new HashMap();
    }

    public void addHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        headers.putAll(this.mHeaders);
        return headers;
    }

    @Override // com.android.volley.toolbox.JsonRequest, com.android.volley.Request
    public Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            String str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            Cache.Entry cacheHeaders = HttpHeaderParser.parseCacheHeaders(networkResponse);
            LxRetryCacheHelper.fixEntryWithCacheConfig(cacheHeaders, this.cacheConfig);
            return Response.success(new JSONObject(str), cacheHeaders);
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException e2) {
            return Response.error(new ParseError(e2));
        }
    }

    public JsonObjectRequest(String str, JSONObject jSONObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, listener, errorListener);
    }
}
