package defpackage;

import android.text.TextUtils;
import cdadata.cdazmg.cdazmb;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class n67 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cdazmb f19449a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ x47 f;
        public final /* synthetic */ int g;

        public a(cdazmb cdazmbVar, String str, Map map, String str2, Map map2, x47 x47Var, int i) {
            this.f19449a = cdazmbVar;
            this.b = str;
            this.c = map;
            this.d = str2;
            this.e = map2;
            this.f = x47Var;
            this.g = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:83:0x00ed A[EXC_TOP_SPLITTER, PHI: r0 r6
          0x00ed: PHI (r0v4 m67) = (r0v7 m67), (r0v8 m67) binds: [B:54:0x00eb, B:47:0x00e0] A[DONT_GENERATE, DONT_INLINE]
          0x00ed: PHI (r6v3 java.io.BufferedWriter) = (r6v5 java.io.BufferedWriter), (r6v6 java.io.BufferedWriter) binds: [B:54:0x00eb, B:47:0x00e0] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
            m67 m67VarA;
            k67 k67Var = new k67();
            cdazmb cdazmbVar = this.f19449a;
            if (cdazmbVar != null) {
                k67Var.f18587a = cdazmbVar;
            }
            String str = this.b;
            n67 n67Var = n67.this;
            Map map = this.c;
            String string = this.d;
            n67Var.getClass();
            BufferedWriter bufferedWriter = null;
            if (map != null) {
                StringBuilder sb = new StringBuilder();
                try {
                    boolean z = true;
                    for (Map.Entry entry : map.entrySet()) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(ContainerUtils.FIELD_DELIMITER);
                        }
                        sb.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                    }
                    string = sb.toString();
                } catch (UnsupportedEncodingException unused) {
                    string = null;
                }
            } else if (TextUtils.isEmpty(string)) {
                string = null;
            }
            n67 n67Var2 = n67.this;
            Map map2 = this.c;
            String str2 = this.d;
            n67Var2.getClass();
            String str3 = (map2 == null && !TextUtils.isEmpty(str2)) ? "application/json;charset=utf-8" : null;
            Map<String, String> map3 = this.e;
            try {
                try {
                    g57.b("HttpRequest", String.format("url:%s\nparams:%s\nmethod:POST", str, string));
                    HttpURLConnection httpURLConnectionC = k67Var.c(str, "POST");
                    httpURLConnectionC.setDoOutput(true);
                    httpURLConnectionC.setUseCaches(false);
                    if (!TextUtils.isEmpty(str3)) {
                        httpURLConnectionC.setRequestProperty("Content-Type", str3);
                    }
                    if (map3 != null) {
                        k67Var.d(httpURLConnectionC, map3);
                    }
                    httpURLConnectionC.connect();
                    if (!TextUtils.isEmpty(string)) {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(httpURLConnectionC.getOutputStream(), "UTF-8"));
                        try {
                            bufferedWriter2.write(string);
                            bufferedWriter2.flush();
                            bufferedWriter = bufferedWriter2;
                        } catch (Exception e) {
                            e = e;
                            bufferedWriter = bufferedWriter2;
                            m67VarA = k67Var.a(e);
                            if (bufferedWriter != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e2) {
                                    g57.a(e2);
                                }
                            }
                            throw th;
                        }
                    }
                    m67VarA = k67Var.b(httpURLConnectionC);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e4) {
                    g57.a(e4);
                }
            }
            int i = m67VarA.c;
            if (i == 200 || i == 204) {
                x47 x47Var = this.f;
                if (x47Var != null) {
                    x47Var.onSuccess(m67VarA);
                    return;
                }
                return;
            }
            int i2 = this.g;
            if (i2 != 0) {
                n67.this.a(this.b, this.f19449a, this.c, this.d, this.e, i2, this.f);
                return;
            }
            x47 x47Var2 = this.f;
            if (x47Var2 != null) {
                x47Var2.onError(m67VarA);
            }
        }
    }

    public n67(String str, cdazmb cdazmbVar, String str2, Map<String, String> map, int i, x47 x47Var) {
        a(str, cdazmbVar, null, str2, map, i, x47Var);
    }

    public final void a(String str, cdazmb cdazmbVar, Map<String, String> map, String str2, Map<String, String> map2, int i, x47 x47Var) {
        v57.a(new a(cdazmbVar, str, map, str2, map2, x47Var, i - 1));
    }
}
