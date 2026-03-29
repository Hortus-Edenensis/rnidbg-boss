package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class f61 implements v83 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final HttpURLConnection f17464a;

    public f61(@NonNull HttpURLConnection httpURLConnection) {
        this.f17464a = httpURLConnection;
    }

    public final String a(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f17464a.disconnect();
    }

    @Override // defpackage.v83
    public boolean isSuccessful() {
        try {
            return this.f17464a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // defpackage.v83
    @Nullable
    public String v() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.f17464a.getURL() + ". Failed with " + this.f17464a.getResponseCode() + "\n" + a(this.f17464a);
        } catch (IOException e) {
            m63.d("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // defpackage.v83
    @Nullable
    public String w() {
        return this.f17464a.getContentType();
    }

    @Override // defpackage.v83
    @NonNull
    public InputStream z() throws IOException {
        return this.f17464a.getInputStream();
    }
}
