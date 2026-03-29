package com.android.volley.toolbox;

import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.baidu.mapapi.http.HttpClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zenmen.palmchat.ad.model.FormText;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class PostFormRequest extends Request<JSONObject> {
    private static final String TAG = "PostFormRequest";
    private String BOUNDARY;
    private String MULTIPART_FORM_DATA;
    private Gson mGson;
    private List<FormText> mListItem;
    private Response.Listener<JSONObject> mListener;

    public PostFormRequest(String str, List<FormText> list, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(1, str, errorListener);
        this.BOUNDARY = "---------8888888888888";
        this.MULTIPART_FORM_DATA = "multipart/form-data";
        this.mListener = listener;
        this.mGson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        this.mListItem = list;
    }

    @Override // com.android.volley.Request
    public byte[] getBody() throws AuthFailureError {
        List<FormText> list = this.mListItem;
        if (list == null || list.size() == 0) {
            return super.getBody();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int size = this.mListItem.size();
        for (int i = 0; i < size; i++) {
            FormText formText = this.mListItem.get(i);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(HttpClient.ENDFLAG + this.BOUNDARY);
            stringBuffer.append(HttpClient.NEWLINE);
            stringBuffer.append("Content-Disposition: form-data;");
            stringBuffer.append("name=\"");
            stringBuffer.append(formText.getName());
            stringBuffer.append("\"");
            stringBuffer.append(HttpClient.NEWLINE);
            stringBuffer.append(HttpClient.NEWLINE);
            stringBuffer.append(formText.getValue());
            stringBuffer.append(HttpClient.NEWLINE);
            try {
                byteArrayOutputStream.write(stringBuffer.toString().getBytes("utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            byteArrayOutputStream.write((HttpClient.ENDFLAG + this.BOUNDARY + "--\r\n").toString().getBytes("utf-8"));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        Log.v(TAG, "=====formText====\n" + byteArrayOutputStream.toString());
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return this.MULTIPART_FORM_DATA + "; boundary=" + this.BOUNDARY;
    }

    @Override // com.android.volley.Request
    public Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(new JSONObject(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers))), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException e2) {
            return Response.error(new ParseError(e2));
        }
    }

    @Override // com.android.volley.Request
    public void deliverResponse(JSONObject jSONObject) {
        this.mListener.onResponse(jSONObject);
    }
}
