package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.x;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import com.zenmen.palmchat.utils.log.LogUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.mime.MIME;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class eb6 {
    public static final String c = "eb6";
    public static volatile eb6 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f17260a = vw5.d(c);
    public ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str, String str2);

        void b(String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f17261a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public a g;
        public ConcurrentHashMap<String, Boolean> h;
        public String i;
        public String j;
        public int k;
        public String l;
        public long m;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "msg_file_download");
                put("status", "start");
                put("type", String.valueOf(4));
                put("mid", b.this.l);
                put("md5", b.this.f);
            }
        }

        /* JADX INFO: renamed from: eb6$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1188b extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f17263a;

            public C1188b(boolean z) {
                this.f17263a = z;
                put("action", "msg_file_download");
                put("status", z ? "success" : "fail");
                put("type", String.valueOf(4));
                put("mid", b.this.l);
                put("md5", b.this.f);
                put("fileSize", Long.valueOf(b.this.m));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f17264a;

            public c(String str) {
                this.f17264a = str;
                put("action", "video_download");
                put("status", "fail");
                put("detail", "url=" + str);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class d extends Exception {
            public d() {
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class e extends Exception {
            public e(String str) {
                super(str);
            }
        }

        public b(Context context, String str, String str2, String str3, String str4, String str5, a aVar, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
            this.f17261a = context;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.f = str5;
            this.g = aVar;
            this.h = concurrentHashMap;
            this.i = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
        
            e(r14, null, r15);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
        
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
        
            r5 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
        
            defpackage.it0.k().s("all ip failed");
            com.zenmen.palmchat.utils.log.LogUtil.i(defpackage.eb6.c, 3, new eb6.b.c(r13, r14), r5);
            r1 = r1 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x008a, code lost:
        
            r14 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x008b, code lost:
        
            throw r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x008c, code lost:
        
            r14 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x008d, code lost:
        
            throw r14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean d(String str, boolean z) throws Throwable {
            int i;
            boolean z2;
            int i2 = 0;
            while (i2 < 3) {
                z2 = true;
                try {
                    Iterator<te1> it = it0.k().g().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        te1 next = it.next();
                        if (next.a(str)) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= 2) {
                                    break;
                                }
                                DNSNode[] dNSNodeArrI = it0.k().i(next.f20971a);
                                if (dNSNodeArrI != null) {
                                    for (DNSNode dNSNode : dNSNodeArrI) {
                                        String strQ = it0.q(str, next, dNSNode);
                                        HashMap map = new HashMap();
                                        map.put("Host", next.f20971a);
                                        try {
                                            e(strQ, map, z);
                                            return true;
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                } else {
                                    if (!it0.k().n() || i3 != 0) {
                                        break;
                                    }
                                    it0.k().t("dns cache is empty when doing HTTP request");
                                    i3++;
                                }
                            }
                        }
                    }
                } catch (d e3) {
                    e3.printStackTrace();
                    LogUtil.i(eb6.c, "isCancelled mid=" + this.b);
                    i = 0;
                } catch (e e4) {
                    e4.printStackTrace();
                    i = Integer.parseInt(e4.getMessage());
                }
            }
            i = 0;
            z2 = false;
            if (!z2 && z) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("attach_status", Integer.valueOf(i > 0 ? 5 : 4));
                if (i == 2) {
                    contentValues.put("data2", "http://res_error?code=403");
                }
                this.f17261a.getContentResolver().update(DBUriManager.c(ho3.class, this.i), contentValues, "packet_id=?", new String[]{this.b});
                i(-1);
                h(false);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01d9  */
        /* JADX WARN: Type inference failed for: r2v0, types: [fb6] */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(String str, Map<String, String> map, boolean z) throws Throwable {
            HttpURLConnection httpURLConnectionA;
            FileOutputStream fileOutputStream;
            a aVar;
            ?? r2 = 0;
            r2 = 0;
            HttpURLConnection httpURLConnection = null;
            if (g()) {
                throw new d();
            }
            try {
                httpURLConnectionA = zf1.a(str, map, 10000, 60000);
                for (int i = 0; httpURLConnectionA.getResponseCode() / 100 == 3 && i < 3; i++) {
                    try {
                        String headerField = httpURLConnectionA.getHeaderField(HttpHeaders.LOCATION);
                        httpURLConnectionA.disconnect();
                        httpURLConnectionA = zf1.a(headerField, null, 10000, 60000);
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        pu1.u(r2);
                        if (httpURLConnectionA != null) {
                        }
                        throw th;
                    }
                }
                if (httpURLConnectionA.getResponseCode() == 200) {
                    String headerField2 = httpURLConnectionA.getHeaderField("Media-ZX-Block-Type");
                    if (!TextUtils.isEmpty(headerField2) && (headerField2.equals("1") || headerField2.equals("2"))) {
                        throw new e(headerField2);
                    }
                }
                pu1.t();
                File file = new File(pu1.l);
                if (!file.exists()) {
                    file.mkdir();
                }
                String str2 = pu1.l + File.separator + f(httpURLConnectionA.getHeaderField(MIME.CONTENT_DISPOSITION));
                if (!z) {
                    this.e = str2;
                }
                int contentLength = httpURLConnectionA.getContentLength();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnectionA.getInputStream(), 4096);
                String str3 = str2 + ".tmp";
                fileOutputStream = new FileOutputStream(str3);
                try {
                    byte[] bArr = new byte[1024];
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i2 = 0;
                    boolean z2 = true;
                    do {
                        int i3 = bufferedInputStream.read(bArr);
                        if (i3 != -1) {
                            fileOutputStream.write(bArr, 0, i3);
                            i2 += i3;
                            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                            if (z && (z2 || jCurrentTimeMillis2 >= 500 || i2 == contentLength)) {
                                if (!z2) {
                                    jCurrentTimeMillis = System.currentTimeMillis();
                                }
                                if (i((int) ((i2 / contentLength) * 100.0f))) {
                                    i2 = 0;
                                } else {
                                    z2 = false;
                                }
                            }
                        }
                        fileOutputStream.flush();
                        File file2 = new File(str3);
                        if (file2.exists()) {
                            file2.renameTo(new File(str2));
                        }
                        if (z) {
                            if (i2 == contentLength) {
                                this.m = contentLength;
                                String str4 = str2 + ".thumbnail";
                                if (!TextUtils.isEmpty(this.e) && !this.e.equals(str4)) {
                                    new File(this.e).renameTo(new File(str4));
                                }
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("data1", str2);
                                contentValues.put("data2", str4);
                                contentValues.put("attach_status", (Integer) 2);
                                this.f17261a.getContentResolver().update(DBUriManager.c(ho3.class, this.i), contentValues, "packet_id=?", new String[]{this.b});
                                h(true);
                            } else {
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put("attach_status", (Integer) 4);
                                this.f17261a.getContentResolver().update(DBUriManager.c(ho3.class, this.i), contentValues2, "packet_id=?", new String[]{this.b});
                            }
                        }
                        bufferedInputStream.close();
                        pu1.u(fileOutputStream);
                        httpURLConnectionA.disconnect();
                        if (!z || (aVar = this.g) == null) {
                            return;
                        }
                        aVar.a(this.b, str2);
                        return;
                    } while (!g());
                    throw new d();
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = httpURLConnectionA;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnectionA = httpURLConnection;
                        r2 = fileOutputStream;
                        pu1.u(r2);
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r2 = fileOutputStream;
                    pu1.u(r2);
                    if (httpURLConnectionA != null) {
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnectionA = null;
            }
        }

        public final String f(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split(x.aQ)) == null) {
                return null;
            }
            for (String str2 : strArrSplit) {
                String strTrim = str2.trim();
                if (strTrim.toLowerCase().startsWith("filename=")) {
                    StringBuilder sb = new StringBuilder(strTrim.substring(9));
                    if (sb.charAt(0) == '\"') {
                        sb.deleteCharAt(0);
                    }
                    if (sb.charAt(sb.length() - 1) == '\"') {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return null;
        }

        public final boolean g() {
            return (this.h.get(this.b) == null || this.h.get(this.b).booleanValue()) ? false : true;
        }

        public final void h(boolean z) {
            if (this.j == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("video", this.f);
                String str = "1";
                jSONObject.put("envir", m40.b(this.j) == 1 ? "2" : this.k == 0 ? "1" : "3");
                if (!z) {
                    str = "2";
                }
                LogUtil.onEvent("74", null, str, jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        public final boolean i(int i) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("msg_sending_progress", Integer.valueOf(i));
            contentValues.put("attach_status", (Integer) 1);
            String[] strArr = {this.b};
            Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.c(ho3.class, this.i), new String[]{"msg_type", "contact_relate"}, "packet_id=?", strArr, null);
            if (cursorQuery.moveToFirst()) {
                int i2 = cursorQuery.getInt(0);
                boolean z = !TextUtils.isEmpty(this.j);
                String string = cursorQuery.getString(1);
                this.j = string;
                if (!z && !TextUtils.isEmpty(string)) {
                    Cursor cursorQuery2 = AppContext.getContext().getContentResolver().query(dx5.f17178a, new String[]{"thread_biz_type"}, "contact_relate=?", new String[]{m40.b(this.j) == 0 ? this.j : m40.d(this.j)}, null);
                    if (cursorQuery2.moveToFirst()) {
                        this.k = cursorQuery2.getInt(0);
                    }
                    cursorQuery2.close();
                }
                if (i2 == 10001) {
                    cursorQuery.close();
                    h(false);
                    return true;
                }
            }
            cursorQuery.close();
            if (i >= 0) {
                AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, this.i), contentValues, "packet_id=?", strArr);
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a aVar = this.g;
            if (aVar != null) {
                aVar.b(this.b);
            }
            this.l = UUID.randomUUID().toString();
            String str = eb6.c;
            LogUtil.LogType logType = LogUtil.LogType.LOG_TYPE_QA_NORMAL;
            LogUtil.i(str, logType, 3, new a(), (Throwable) null);
            d(this.d, false);
            boolean zD = d(this.c, true);
            this.h.remove(this.b);
            LogUtil.i(str, logType, 3, new C1188b(zD), (Throwable) null);
        }
    }

    public static eb6 e() {
        if (d == null) {
            synchronized (eb6.class) {
                if (d == null) {
                    d = new eb6();
                }
            }
        }
        return d;
    }

    public void a(String str) {
        if (str != null && this.b.containsKey(str) && this.b.get(str).booleanValue()) {
            this.b.put(str, Boolean.FALSE);
        }
    }

    public void b(Context context, String str, String str2, String str3, String str4, String str5) {
        c(context, str, str2, str3, str4, str5, null);
    }

    public void c(Context context, String str, String str2, String str3, String str4, String str5, a aVar) {
        if (this.b.containsKey(str2)) {
            return;
        }
        this.b.put(str2, Boolean.TRUE);
        ContentValues contentValues = new ContentValues();
        contentValues.put("msg_sending_progress", (Integer) 0);
        contentValues.put("attach_status", (Integer) 1);
        context.getContentResolver().update(DBUriManager.c(ho3.class, str), contentValues, "packet_id=?", new String[]{str2});
        this.f17260a.submit(new b(context, str, str2, str3, str4, str5, aVar, this.b));
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public String f(String str) {
        String[] strArrSplit;
        try {
            String query = new URL(str).getQuery();
            if (TextUtils.isEmpty(query) || (strArrSplit = query.split(ContainerUtils.FIELD_DELIMITER)) == null) {
                return null;
            }
            for (String str2 : strArrSplit) {
                if (str2.startsWith("mid=")) {
                    return str2.substring(4);
                }
            }
            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
