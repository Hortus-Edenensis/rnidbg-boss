package defpackage;

import com.baidu.mapapi.http.HttpClient;
import com.efs.sdk.base.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class qe7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20241a;
    public HttpURLConnection b;
    public String c;
    public boolean d;
    public ub7 e;
    public fg7 f;

    public qe7(String str, String str2, Map<String, String> map, boolean z) throws ProtocolException {
        this.c = str2;
        this.d = z;
        String str3 = "AAA" + System.currentTimeMillis() + "AAA";
        this.f20241a = str3;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.b = httpURLConnection;
        hv6.a(httpURLConnection);
        this.b.setUseCaches(false);
        this.b.setDoOutput(true);
        this.b.setDoInput(true);
        this.b.setRequestMethod("POST");
        this.b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str3);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.b.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (!z) {
            this.e = new ub7(this.b.getOutputStream());
        } else {
            this.b.setRequestProperty("Content-Encoding", Constants.CP_GZIP);
            this.f = new fg7(this.b.getOutputStream());
        }
    }

    public String a() throws IOException {
        ArrayList arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f20241a + HttpClient.ENDFLAG + HttpClient.NEWLINE).getBytes();
        if (this.d) {
            this.f.write(bytes);
            this.f.d();
            this.f.c();
        } else {
            this.e.write(bytes);
            this.e.flush();
            this.e.c();
        }
        int responseCode = this.b.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.b.getInputStream()));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            arrayList.add(line);
        }
        bufferedReader.close();
        this.b.disconnect();
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        return sb.toString();
    }

    public void b(String str, File file, Map<String, String> map) {
        String name = file.getName();
        StringBuilder sb = new StringBuilder();
        sb.append(HttpClient.ENDFLAG);
        sb.append(this.f20241a);
        sb.append(HttpClient.NEWLINE);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"; filename=\"");
        sb.append(name);
        sb.append("\"");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("; ");
            sb.append(entry.getKey());
            sb.append("=\"");
            sb.append(entry.getValue());
            sb.append("\"");
        }
        sb.append(HttpClient.NEWLINE);
        sb.append("Content-Transfer-Encoding: binary");
        sb.append(HttpClient.NEWLINE);
        sb.append(HttpClient.NEWLINE);
        if (this.d) {
            this.f.write(sb.toString().getBytes());
        } else {
            this.e.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                break;
            } else {
                (this.d ? this.f : this.e).write(bArr, 0, i);
            }
        }
        fileInputStream.close();
        if (this.d) {
            this.f.write(HttpClient.NEWLINE.getBytes());
        } else {
            this.e.write(HttpClient.NEWLINE.getBytes());
            this.e.flush();
        }
    }

    public void c(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(HttpClient.ENDFLAG);
        sb.append(this.f20241a);
        sb.append(HttpClient.NEWLINE);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"");
        sb.append(HttpClient.NEWLINE);
        sb.append("Content-Type: text/plain; charset=");
        sb.append(this.c);
        sb.append(HttpClient.NEWLINE);
        sb.append(HttpClient.NEWLINE);
        try {
            if (this.d) {
                this.f.write(sb.toString().getBytes());
            } else {
                this.e.write(sb.toString().getBytes());
            }
        } catch (IOException unused) {
        }
        byte[] bytes = str2.getBytes();
        if (z) {
            bytes = md7.a(bytes);
        }
        try {
            if (this.d) {
                this.f.write(bytes);
                this.f.write(HttpClient.NEWLINE.getBytes());
            } else {
                this.e.write(bytes);
                this.e.write(HttpClient.NEWLINE.getBytes());
            }
        } catch (IOException unused2) {
        }
    }

    public void e(String str, Map<String, String> map, File... fileArr) throws Throwable {
        StringBuilder sb = new StringBuilder();
        sb.append(HttpClient.ENDFLAG);
        sb.append(this.f20241a);
        sb.append(HttpClient.NEWLINE);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"; filename=\"");
        sb.append(str);
        sb.append("\"");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("; ");
                sb.append(entry.getKey());
                sb.append("=\"");
                sb.append(entry.getValue());
                sb.append("\"");
            }
        }
        sb.append(HttpClient.NEWLINE);
        sb.append("Content-Transfer-Encoding: binary");
        sb.append(HttpClient.NEWLINE);
        sb.append(HttpClient.NEWLINE);
        if (this.d) {
            this.f.write(sb.toString().getBytes());
        } else {
            this.e.write(sb.toString().getBytes());
        }
        re7.n(this.d ? this.f : this.e, fileArr);
        if (this.d) {
            this.f.write(HttpClient.NEWLINE.getBytes());
        } else {
            this.e.write(HttpClient.NEWLINE.getBytes());
            this.e.flush();
        }
    }

    public void f(String str, File... fileArr) {
        e(str, null, fileArr);
    }

    public qe7(String str, String str2, boolean z) {
        this(str, str2, null, z);
    }
}
