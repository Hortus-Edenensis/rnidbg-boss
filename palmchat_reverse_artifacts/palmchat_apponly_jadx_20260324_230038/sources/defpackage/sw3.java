package defpackage;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.network.FileExtension;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class sw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final qw3 f20861a;

    @NonNull
    public final b93 b;

    public sw3(@NonNull qw3 qw3Var, @NonNull b93 b93Var) {
        this.f20861a = qw3Var;
        this.b = b93Var;
    }

    @Nullable
    @WorkerThread
    public final u73 a(@NonNull String str, @Nullable String str2) {
        Pair<FileExtension, InputStream> pairA;
        if (str2 == null || (pairA = this.f20861a.a(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) pairA.first;
        InputStream inputStream = (InputStream) pairA.second;
        e93<u73> e93VarY = fileExtension == FileExtension.ZIP ? d83.y(new ZipInputStream(inputStream), str) : d83.o(inputStream, str);
        if (e93VarY.b() != null) {
            return e93VarY.b();
        }
        return null;
    }

    @NonNull
    @WorkerThread
    public final e93<u73> b(@NonNull String str, @Nullable String str2) {
        m63.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                v83 v83VarA = this.b.a(str);
                if (!v83VarA.isSuccessful()) {
                    e93<u73> e93Var = new e93<>(new IllegalArgumentException(v83VarA.v()));
                    try {
                        v83VarA.close();
                    } catch (IOException e) {
                        m63.d("LottieFetchResult close failed ", e);
                    }
                    return e93Var;
                }
                e93<u73> e93VarD = d(str, v83VarA.z(), v83VarA.w(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(e93VarD.b() != null);
                m63.a(sb.toString());
                try {
                    v83VarA.close();
                } catch (IOException e2) {
                    m63.d("LottieFetchResult close failed ", e2);
                }
                return e93VarD;
            } catch (Exception e3) {
                e93<u73> e93Var2 = new e93<>(e3);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e4) {
                        m63.d("LottieFetchResult close failed ", e4);
                    }
                }
                return e93Var2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e5) {
                    m63.d("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    @NonNull
    @WorkerThread
    public e93<u73> c(@NonNull String str, @Nullable String str2) {
        u73 u73VarA = a(str, str2);
        if (u73VarA != null) {
            return new e93<>(u73VarA);
        }
        m63.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(str, str2);
    }

    @NonNull
    public final e93<u73> d(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        FileExtension fileExtension;
        e93<u73> e93VarF;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            m63.a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            e93VarF = f(str, inputStream, str3);
        } else {
            m63.a("Received json response.");
            fileExtension = FileExtension.JSON;
            e93VarF = e(str, inputStream, str3);
        }
        if (str3 != null && e93VarF.b() != null) {
            this.f20861a.e(str, fileExtension);
        }
        return e93VarF;
    }

    @NonNull
    public final e93<u73> e(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        return str2 == null ? d83.o(inputStream, null) : d83.o(new FileInputStream(this.f20861a.f(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }

    @NonNull
    public final e93<u73> f(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        return str2 == null ? d83.y(new ZipInputStream(inputStream), null) : d83.y(new ZipInputStream(new FileInputStream(this.f20861a.f(str, inputStream, FileExtension.ZIP))), str);
    }
}
