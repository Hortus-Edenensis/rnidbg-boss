package com.beizi.ad.internal.e;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class d extends AsyncTask<Void, Void, e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4413a = "HTTPGet";
    private boolean b;
    private boolean c;

    public d(boolean z, boolean z2) {
        this.b = z;
        this.c = z2;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e doInBackground(Void... voidArr) {
        URL url;
        e eVar = new e();
        HttpURLConnection httpURLConnectionA = null;
        try {
            try {
                try {
                    url = new URL(a());
                } catch (Exception unused) {
                    eVar.a(false);
                    eVar.a(g.TRANSPORT_ERROR);
                    if (0 != 0) {
                    }
                    return eVar;
                }
            } catch (MalformedURLException unused2) {
                eVar.a(false);
                eVar.a(g.URL_FORMAT_ERROR);
                if (0 != 0) {
                }
                return eVar;
            } catch (IOException unused3) {
                eVar.a(false);
                eVar.a(g.TRANSPORT_ERROR);
                if (0 != 0) {
                }
                return eVar;
            }
            if (url.getHost() == null) {
                eVar.a(false);
                return eVar;
            }
            httpURLConnectionA = a(url);
            a(httpURLConnectionA);
            httpURLConnectionA.connect();
            int responseCode = httpURLConnectionA.getResponseCode();
            com.beizi.ad.lance.a.m.a(f4413a, "HTTPGet code:" + responseCode);
            eVar.a(httpURLConnectionA.getHeaderFields());
            eVar.a(responseCode == 200 || responseCode == 302);
            if (responseCode == 302) {
                eVar.a(responseCode);
                eVar.b(httpURLConnectionA.getHeaderField(HttpHeaders.LOCATION));
            }
            if (this.c) {
                InputStream inputStream = httpURLConnectionA.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
                inputStream.close();
                if (this.b) {
                    eVar.a(byteArrayOutputStream);
                } else {
                    eVar.a(byteArrayOutputStream.toString("UTF-8"));
                }
            }
            httpURLConnectionA.disconnect();
            return eVar;
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnectionA.disconnect();
            }
            throw th;
        }
    }

    public abstract String a();

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract void onPostExecute(e eVar);

    @Override // android.os.AsyncTask
    @TargetApi(11)
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onCancelled(e eVar) {
        super.onCancelled(null);
    }

    private HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("GET");
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setRequestProperty("User-Agent", com.beizi.ad.internal.c.a().e);
    }
}
