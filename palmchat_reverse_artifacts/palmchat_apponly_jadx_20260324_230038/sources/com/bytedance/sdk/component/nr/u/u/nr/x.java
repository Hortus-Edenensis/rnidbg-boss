package com.bytedance.sdk.component.nr.u.u.nr;

import com.bytedance.sdk.component.nr.u.jk;
import com.bytedance.sdk.component.nr.u.o;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends o {
    InputStream nr;
    HttpURLConnection u;

    public x(HttpURLConnection httpURLConnection) throws IOException {
        this.u = httpURLConnection;
        this.nr = new pn(httpURLConnection.getInputStream(), httpURLConnection);
    }

    @Override // com.bytedance.sdk.component.nr.u.o
    public byte[] b() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (true) {
                try {
                    int i = this.nr.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, i);
                } catch (Exception unused) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return new byte[0];
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (Throwable unused4) {
            }
            return byteArray;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.o, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.nr.close();
            this.u.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.o
    public InputStream fx() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.nr.u.o
    public String nr() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.nr));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    String string = stringBuffer.toString();
                    close();
                    return string;
                }
                stringBuffer.append(line + "\n");
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.o
    public jk pn() {
        if (this.u.getContentType() != null) {
            return jk.u(this.u.getContentType());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.nr.u.o
    public long u() {
        try {
            return this.u.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }
}
