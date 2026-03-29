package a.a.b.a.b;

import a.a.a.a.a.a.h;
import a.a.a.a.a.a.i;
import a.a.b.a.a.a;
import a.a.b.a.d.e;
import android.util.Log;
import defpackage.pn;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f1073a = null;
    public static volatile long b = -1;
    public static volatile String c = "";
    public static long d = -1;
    public static final a e = new a();
    public final String f;
    public String g;
    public JSONObject h;
    public final String i;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
    }

    /* JADX INFO: renamed from: a.a.b.a.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class RunnableC0003b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f1074a;
        public final /* synthetic */ String b;

        public RunnableC0003b(JSONObject jSONObject, String str) {
            this.f1074a = jSONObject;
            this.b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0192  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0197  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() throws Throwable {
            InputStream inputStream;
            OutputStream outputStream;
            JSONObject body = this.f1074a;
            String tag = this.b;
            Intrinsics.checkNotNullParameter("https://analytics.oceanengine.com/sdk/app/", "url");
            Intrinsics.checkNotNullParameter(body, "body");
            Intrinsics.checkNotNullParameter(tag, "tag");
            StringBuilder sb = new StringBuilder();
            sb.append("start request cost: ");
            long jCurrentTimeMillis = System.currentTimeMillis();
            pn pnVar = pn.d;
            sb.append(jCurrentTimeMillis - pnVar.b());
            sb.append("ms");
            String msg = sb.toString();
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (pnVar.a().getEnableLog()) {
                Log.d(tag, msg);
            }
            HttpURLConnection httpURLConnection = null;
            try {
                URLConnection uRLConnectionOpenConnection = new URL("https://analytics.oceanengine.com/sdk/app/").openConnection();
                if (uRLConnectionOpenConnection == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) uRLConnectionOpenConnection;
                try {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setConnectTimeout(5000);
                    httpURLConnection2.setReadTimeout(5000);
                    httpURLConnection2.setRequestProperty("enable-encrypt", "1");
                    httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.connect();
                    outputStream = httpURLConnection2.getOutputStream();
                    try {
                        String string = e.f1083a.a(body, tag).toString();
                        Intrinsics.checkNotNullExpressionValue(string, "EncryptUtils.doInClient(body, tag).toString()");
                        Charset charset = Charsets.UTF_8;
                        if (string == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        byte[] bytes = string.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                        outputStream.write(bytes);
                        outputStream.close();
                        InputStream inputStream2 = httpURLConnection2.getInputStream();
                        Intrinsics.checkNotNullExpressionValue(inputStream2, "inputStream");
                        new JSONObject(new String(ByteStreamsKt.readBytes(inputStream2), charset));
                        inputStream2.close();
                        String msg2 = "post: response: " + httpURLConnection2.getResponseCode() + "\t" + httpURLConnection2.getHeaderField("X-Tt-Logid");
                        Intrinsics.checkNotNullParameter(tag, "tag");
                        Intrinsics.checkNotNullParameter(msg2, "msg");
                        if (pnVar.a().getEnableLog()) {
                            Log.d(tag, msg2);
                        }
                        httpURLConnection2.disconnect();
                        outputStream.close();
                        inputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        httpURLConnection = httpURLConnection2;
                        inputStream = null;
                        try {
                            e.printStackTrace();
                            String msg3 = "request error" + e.getMessage();
                            Intrinsics.checkNotNullParameter(tag, "tag");
                            Intrinsics.checkNotNullParameter(msg3, "msg");
                            if (pn.d.a().getEnableLog()) {
                                Log.d(tag, msg3);
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("err_code", "-1");
                            jSONObject.put("err_msg", e.getMessage());
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        inputStream = null;
                        if (httpURLConnection != null) {
                        }
                        if (outputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    outputStream = null;
                    httpURLConnection = httpURLConnection2;
                    inputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                    httpURLConnection = httpURLConnection2;
                    inputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                outputStream = null;
            }
        }
    }

    public b(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.i = label;
        this.f = "Convert:EventReport";
    }

    public final void a(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        String tag2 = this.f;
        Intrinsics.checkNotNullParameter(tag2, "tag");
        Intrinsics.checkNotNullParameter("post", "msg");
        if (pn.d.a().getEnableLog()) {
            Log.d(tag2, "post");
        }
        JSONObject jSONObject = f1073a;
        if (jSONObject != null) {
            try {
                jSONObject.put("oaid", c);
            } catch (JSONException e2) {
                String tag3 = this.f;
                String msg = "update params failed" + e2.getMessage();
                Intrinsics.checkNotNullParameter(tag3, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (pn.d.a().getEnableLog()) {
                    Log.d(tag3, msg);
                }
            }
        }
        if (!Intrinsics.areEqual(this.g, "3")) {
            try {
                i iVarA = h.c.a();
                if (Intrinsics.areEqual(iVarA.b, "01128") && jSONObject != null) {
                    jSONObject.put("u_t", new JSONObject(iVarA.a().toString()));
                }
            } catch (Exception e3) {
                String tag4 = this.f;
                String msg2 = "update uaid params failed" + e3.getMessage();
                Intrinsics.checkNotNullParameter(tag4, "tag");
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (pn.d.a().getEnableLog()) {
                    Log.d(tag4, msg2);
                }
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("event_name", this.i);
            jSONObject2.put("local_time", String.valueOf(System.currentTimeMillis()));
            pn pnVar = pn.d;
            jSONObject2.put("sdk_init_time", String.valueOf(pnVar.b()));
            jSONObject2.put("oaid_callback_time", String.valueOf(b));
            jSONObject2.put("inode_callback_time", String.valueOf(d));
            a.C0002a c0002a = a.a.b.a.a.a.f1070a;
            jSONObject2.put("config_callback_time", String.valueOf(a.a.b.a.a.a.e));
            jSONObject2.put("event_version", this.g);
            JSONObject jSONObject3 = this.h;
            jSONObject2.put("params", jSONObject3 != null ? jSONObject3.toString() : null);
            String tag5 = this.f;
            Intrinsics.checkNotNullParameter(tag5, "tag");
            Intrinsics.checkNotNullParameter("new Thread", "msg");
            if (pnVar.a().getEnableLog()) {
                Log.d(tag5, "new Thread");
            }
            new Thread(new RunnableC0003b(jSONObject2, tag)).start();
        } catch (Exception e4) {
            e4.printStackTrace();
            String msg3 = "create request params failed, eventName: " + this.i + " error:" + e4.getMessage();
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg3, "msg");
            if (pn.d.a().getEnableLog()) {
                Log.d(tag, msg3);
            }
        }
    }
}
