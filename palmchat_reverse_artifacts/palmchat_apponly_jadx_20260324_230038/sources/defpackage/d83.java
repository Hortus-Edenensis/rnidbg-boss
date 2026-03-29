package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class d83 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, g93<u73>> f16995a = new HashMap();
    public static final byte[] b = {80, 75, 3, 4};

    public static boolean A(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static Boolean B(BufferedSource bufferedSource) {
        try {
            BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (byte b2 : b) {
                if (bufferedSourcePeek.readByte() != b2) {
                    return Boolean.FALSE;
                }
            }
            bufferedSourcePeek.close();
            return Boolean.TRUE;
        } catch (Exception e) {
            m63.b("Failed to check zip file header", e);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    public static /* synthetic */ void C(String str, AtomicBoolean atomicBoolean, Throwable th) {
        f16995a.remove(str);
        atomicBoolean.set(true);
    }

    public static /* synthetic */ e93 D(u73 u73Var) throws Exception {
        return new e93(u73Var);
    }

    public static /* synthetic */ void E(String str, AtomicBoolean atomicBoolean, u73 u73Var) {
        f16995a.remove(str);
        atomicBoolean.set(true);
    }

    public static /* synthetic */ e93 H(WeakReference weakReference, Context context, int i, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return v(context, i, str);
    }

    public static /* synthetic */ e93 I(Context context, String str, String str2) throws Exception {
        e93<u73> e93VarC = m03.d(context).c(str, str2);
        if (str2 != null && e93VarC.b() != null) {
            v73.b().c(str2, e93VarC.b());
        }
        return e93VarC;
    }

    public static String J(Context context, @RawRes int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(A(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    public static g93<u73> h(@Nullable final String str, Callable<e93<u73>> callable) {
        final u73 u73VarA = str == null ? null : v73.b().a(str);
        if (u73VarA != null) {
            return new g93<>(new Callable() { // from class: y73
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return d83.D(u73VarA);
                }
            });
        }
        if (str != null) {
            Map<String, g93<u73>> map = f16995a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        g93<u73> g93Var = new g93<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            g93Var.d(new y83() { // from class: z73
                @Override // defpackage.y83
                public final void onResult(Object obj) {
                    d83.E(str, atomicBoolean, (u73) obj);
                }
            });
            g93Var.c(new y83() { // from class: a83
                @Override // defpackage.y83
                public final void onResult(Object obj) {
                    d83.C(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                f16995a.put(str, g93Var);
            }
        }
        return g93Var;
    }

    @Nullable
    public static x83 i(u73 u73Var, String str) {
        for (x83 x83Var : u73Var.j().values()) {
            if (x83Var.b().equals(str)) {
                return x83Var;
            }
        }
        return null;
    }

    public static g93<u73> j(Context context, String str) {
        return k(context, str, "asset_" + str);
    }

    public static g93<u73> k(Context context, final String str, @Nullable final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return h(str2, new Callable() { // from class: b83
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d83.m(applicationContext, str, str2);
            }
        });
    }

    @WorkerThread
    public static e93<u73> l(Context context, String str) {
        return m(context, str, "asset_" + str);
    }

    @WorkerThread
    public static e93<u73> m(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return o(context.getAssets().open(str), str2);
            }
            return y(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new e93<>((Throwable) e);
        }
    }

    public static g93<u73> n(final InputStream inputStream, @Nullable final String str) {
        return h(str, new Callable() { // from class: x73
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d83.o(inputStream, str);
            }
        });
    }

    @WorkerThread
    public static e93<u73> o(InputStream inputStream, @Nullable String str) {
        return p(inputStream, str, true);
    }

    @WorkerThread
    public static e93<u73> p(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return q(JsonReader.n(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                r86.c(inputStream);
            }
        }
    }

    @WorkerThread
    public static e93<u73> q(JsonReader jsonReader, @Nullable String str) {
        return r(jsonReader, str, true);
    }

    public static e93<u73> r(JsonReader jsonReader, @Nullable String str, boolean z) {
        try {
            try {
                u73 u73VarA = e83.a(jsonReader);
                if (str != null) {
                    v73.b().c(str, u73VarA);
                }
                e93<u73> e93Var = new e93<>(u73VarA);
                if (z) {
                    r86.c(jsonReader);
                }
                return e93Var;
            } catch (Exception e) {
                e93<u73> e93Var2 = new e93<>(e);
                if (z) {
                    r86.c(jsonReader);
                }
                return e93Var2;
            }
        } catch (Throwable th) {
            if (z) {
                r86.c(jsonReader);
            }
            throw th;
        }
    }

    public static g93<u73> s(Context context, @RawRes int i) {
        return t(context, i, J(context, i));
    }

    public static g93<u73> t(Context context, @RawRes final int i, @Nullable final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return h(str, new Callable() { // from class: c83
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d83.H(weakReference, applicationContext, i, str);
            }
        });
    }

    @WorkerThread
    public static e93<u73> u(Context context, @RawRes int i) {
        return v(context, i, J(context, i));
    }

    @WorkerThread
    public static e93<u73> v(Context context, @RawRes int i, @Nullable String str) {
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i)));
            return B(bufferedSourceBuffer).booleanValue() ? y(new ZipInputStream(bufferedSourceBuffer.inputStream()), str) : o(bufferedSourceBuffer.inputStream(), str);
        } catch (Resources.NotFoundException e) {
            return new e93<>((Throwable) e);
        }
    }

    public static g93<u73> w(Context context, String str) {
        return x(context, str, "url_" + str);
    }

    public static g93<u73> x(final Context context, final String str, @Nullable final String str2) {
        return h(str2, new Callable() { // from class: w73
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d83.I(context, str, str2);
            }
        });
    }

    @WorkerThread
    public static e93<u73> y(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return z(zipInputStream, str);
        } finally {
            r86.c(zipInputStream);
        }
    }

    @WorkerThread
    public static e93<u73> z(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            u73 u73VarB = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    u73VarB = r(JsonReader.n(Okio.buffer(Okio.source(zipInputStream))), null, false).b();
                } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                    map.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (u73VarB == null) {
                return new e93<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                x83 x83VarI = i(u73VarB, (String) entry.getKey());
                if (x83VarI != null) {
                    x83VarI.f(r86.l((Bitmap) entry.getValue(), x83VarI.e(), x83VarI.c()));
                }
            }
            for (Map.Entry<String, x83> entry2 : u73VarB.j().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new e93<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            if (str != null) {
                v73.b().c(str, u73VarB);
            }
            return new e93<>(u73VarB);
        } catch (IOException e) {
            return new e93<>((Throwable) e);
        }
    }
}
