package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.b.q;
import com.bytedance.component.sdk.annotation.RawRes;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class x {
    private static final Map<String, mv<iz>> u = new HashMap();
    private static final Set<Object> nr = new HashSet();
    private static final byte[] fx = {80, 75, 3, 4};

    @WorkerThread
    public static l<iz> fx(Context context, String str) {
        return fx(context, str, "asset_" + str);
    }

    public static mv<iz> nr(Context context, String str) {
        return nr(context, str, "asset_" + str);
    }

    @WorkerThread
    public static l<iz> fx(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return nr(context.getAssets().open(str), str2);
            }
            return u(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new l<>((Throwable) e);
        }
    }

    public static mv<iz> nr(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return u(str2, new Callable<l<iz>>() { // from class: com.bytedance.adsdk.lottie.x.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public l<iz> call() throws Exception {
                return x.fx(applicationContext, str, str2);
            }
        });
    }

    public static void u(int i) {
        com.bytedance.adsdk.lottie.model.pn.u().u(i);
    }

    public static mv<iz> u(Context context, String str) {
        return u(context, str, "url_" + str);
    }

    @WorkerThread
    public static l<iz> nr(Context context, @RawRes int i) {
        return nr(context, i, fx(context, i));
    }

    public static mv<iz> u(final Context context, final String str, final String str2) {
        return u(str2, new Callable<l<iz>>() { // from class: com.bytedance.adsdk.lottie.x.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public l<iz> call() throws Exception {
                l<iz> lVarU = pn.u(context).u(context, str, str2);
                if (str2 != null && lVarU.u() != null) {
                    com.bytedance.adsdk.lottie.model.pn.u().u(str2, lVarU.u());
                }
                return lVarU;
            }
        });
    }

    @WorkerThread
    public static l<iz> nr(Context context, @RawRes int i, String str) {
        try {
            return nr(context.getResources().openRawResource(i), fx(context, i));
        } catch (Resources.NotFoundException e) {
            return new l<>((Throwable) e);
        }
    }

    public static mv<iz> u(Context context, @RawRes int i) {
        return u(context, i, fx(context, i));
    }

    private static String fx(Context context, @RawRes int i) {
        StringBuilder sb = new StringBuilder("rawRes");
        sb.append(u(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    public static mv<iz> u(Context context, @RawRes final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return u(str, new Callable<l<iz>>() { // from class: com.bytedance.adsdk.lottie.x.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public l<iz> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return x.nr(context2, i, str);
            }
        });
    }

    @WorkerThread
    public static l<iz> nr(InputStream inputStream, String str) {
        return u(inputStream, str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0112 A[Catch: IOException -> 0x02b9, TryCatch #0 {IOException -> 0x02b9, blocks: (B:3:0x000a, B:6:0x0014, B:8:0x0020, B:62:0x014e, B:9:0x0025, B:11:0x0031, B:12:0x0036, B:14:0x0042, B:15:0x0059, B:18:0x0065, B:20:0x006d, B:22:0x0075, B:25:0x007f, B:27:0x0087, B:30:0x0090, B:31:0x0095, B:33:0x009b, B:34:0x00a4, B:54:0x0108, B:56:0x0112, B:57:0x012c, B:53:0x00ea, B:58:0x0130, B:60:0x0136, B:61:0x013f, B:35:0x00c2, B:42:0x00d9, B:51:0x00e8, B:50:0x00e5), top: B:116:0x000a, inners: #2 }] */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static l<iz> nr(Context context, ZipInputStream zipInputStream, String str) {
        FileOutputStream fileOutputStream;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            iz izVarU = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    izVarU = u(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).u();
                } else if (!name.endsWith(".png") && !name.endsWith(".webp") && !name.endsWith(".jpg") && !name.endsWith(".jpeg")) {
                    if (!name.endsWith(".ttf") && !name.endsWith(".otf")) {
                        zipInputStream.closeEntry();
                    } else if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] strArrSplit = name.split("/");
                        String str2 = strArrSplit[strArrSplit.length - 1];
                        String str3 = str2.split("\\.")[0];
                        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context), str2);
                        new FileOutputStream(file);
                        try {
                            fileOutputStream = new FileOutputStream(file);
                        } catch (Throwable th) {
                            com.bytedance.adsdk.lottie.pn.pn.u("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th);
                            Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                            if (!file.delete()) {
                            }
                            map2.put(str3, typefaceCreateFromFile);
                            nextEntry = zipInputStream.getNextEntry();
                        }
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i = zipInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                            }
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            Typeface typefaceCreateFromFile2 = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                com.bytedance.adsdk.lottie.pn.pn.nr("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                            }
                            map2.put(str3, typefaceCreateFromFile2);
                        } finally {
                        }
                    }
                } else if (name.contains("../")) {
                    zipInputStream.closeEntry();
                    nextEntry = zipInputStream.getNextEntry();
                } else {
                    String[] strArrSplit2 = name.split("/");
                    map.put(strArrSplit2[strArrSplit2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (izVarU == null) {
                return new l<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                a aVarU = u(izVarU, (String) entry.getKey());
                if (aVarU != null) {
                    aVarU.u(com.bytedance.adsdk.lottie.pn.a.u((Bitmap) entry.getValue(), aVarU.u(), aVarU.nr()));
                }
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                boolean z = false;
                for (com.bytedance.adsdk.lottie.model.fx fxVar : izVarU.my().values()) {
                    if (fxVar.u().equals(entry2.getKey())) {
                        fxVar.u((Typeface) entry2.getValue());
                        z = true;
                    }
                }
                if (!z) {
                    com.bytedance.adsdk.lottie.pn.pn.nr("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (map.isEmpty()) {
                Iterator<Map.Entry<String, a>> it = izVarU.o().entrySet().iterator();
                while (it.hasNext()) {
                    a value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String strMv = value.mv();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (strMv.startsWith("data:") && strMv.indexOf("base64,") > 0) {
                        try {
                            byte[] bArrDecode = Base64.decode(strMv.substring(strMv.indexOf(44) + 1), 0);
                            value.u(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
                        } catch (IllegalArgumentException e) {
                            com.bytedance.adsdk.lottie.pn.pn.u("data URL did not have correct base64 format.", e);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, a> entry3 : izVarU.o().entrySet()) {
                if (entry3.getValue().k() == null) {
                    return new l<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().mv()));
                }
            }
            if (str != null) {
                com.bytedance.adsdk.lottie.model.pn.u().u(str, izVarU);
            }
            return new l<>(izVarU);
        } catch (IOException e2) {
            return new l<>((Throwable) e2);
        }
    }

    private static boolean u(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static mv<iz> u(final InputStream inputStream, final String str) {
        return u(str, new Callable<l<iz>>() { // from class: com.bytedance.adsdk.lottie.x.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public l<iz> call() throws Exception {
                return x.nr(inputStream, str);
            }
        });
    }

    @WorkerThread
    private static l<iz> u(InputStream inputStream, String str, boolean z) {
        try {
            return u(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.bytedance.adsdk.lottie.pn.a.u(inputStream);
            }
        }
    }

    @WorkerThread
    public static l<iz> u(JsonReader jsonReader, String str) {
        return u(jsonReader, str, true);
    }

    private static l<iz> u(JsonReader jsonReader, String str, boolean z) {
        try {
            try {
                iz izVarU = q.u(jsonReader);
                com.bytedance.adsdk.lottie.model.pn.u().u(str, izVarU);
                l<iz> lVar = new l<>(izVarU);
                if (z) {
                    u(jsonReader);
                }
                return lVar;
            } catch (Exception e) {
                l<iz> lVar2 = new l<>(e);
                if (z) {
                    u(jsonReader);
                }
                return lVar2;
            }
        } catch (Throwable th) {
            if (z) {
                u(jsonReader);
            }
            throw th;
        }
    }

    public static void u(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    @WorkerThread
    public static l<iz> u(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return nr(context, zipInputStream, str);
        } finally {
            com.bytedance.adsdk.lottie.pn.a.u(zipInputStream);
        }
    }

    private static a u(iz izVar, String str) {
        for (a aVar : izVar.o().values()) {
            if (aVar.mv().equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private static mv<iz> u(final String str, Callable<l<iz>> callable) {
        final iz izVarU = str == null ? null : com.bytedance.adsdk.lottie.model.pn.u().u(str);
        if (izVarU != null) {
            return new mv<>(new Callable<l<iz>>() { // from class: com.bytedance.adsdk.lottie.x.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public l<iz> call() throws Exception {
                    return new l<>(izVarU);
                }
            });
        }
        if (str != null) {
            Map<String, mv<iz>> map = u;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        mv<iz> mvVar = new mv<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            mvVar.u(new jk<iz>() { // from class: com.bytedance.adsdk.lottie.x.2
                @Override // com.bytedance.adsdk.lottie.jk
                public void u(iz izVar) {
                    x.u.remove(str);
                    atomicBoolean.set(true);
                    if (x.u.size() == 0) {
                        x.nr(true);
                    }
                }
            });
            mvVar.fx(new jk<Throwable>() { // from class: com.bytedance.adsdk.lottie.x.3
                @Override // com.bytedance.adsdk.lottie.jk
                public void u(Throwable th) {
                    x.u.remove(str);
                    atomicBoolean.set(true);
                    if (x.u.size() == 0) {
                        x.nr(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, mv<iz>> map2 = u;
                map2.put(str, mvVar);
                if (map2.size() == 1) {
                    nr(false);
                }
            }
        }
        return mvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(boolean z) {
        ArrayList arrayList = new ArrayList(nr);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
    }
}
