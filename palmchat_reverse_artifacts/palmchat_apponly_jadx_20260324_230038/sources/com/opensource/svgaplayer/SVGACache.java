package com.opensource.svgaplayer;

import android.content.Context;
import com.amap.api.col.p0002sl.hb;
import com.cdo.oaps.ad.OapsWrapper;
import com.kuaishou.weapon.p0.t;
import defpackage.h63;
import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\tR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\u00020\t8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/opensource/svgaplayer/SVGACache;", "", "Landroid/content/Context;", "context", "", t.f7496a, "Lcom/opensource/svgaplayer/SVGACache$Type;", "type", "l", "", OapsWrapper.KEY_PATH, "f", "(Ljava/lang/String;)V", "", hb.j, "i", "cacheKey", "h", "str", "c", "Ljava/net/URL;", "url", "d", "Ljava/io/File;", t.l, "e", "audio", "a", "Lcom/opensource/svgaplayer/SVGACache$Type;", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "cacheDir", "<init>", "()V", "Type", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class SVGACache {
    public static final SVGACache c = new SVGACache();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static Type type = Type.DEFAULT;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static String cacheDir = "/";

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/opensource/svgaplayer/SVGACache$Type;", "", "(Ljava/lang/String;I)V", "DEFAULT", "FILE", "com.opensource.svgaplayer"}, k = 1, mv = {1, 1, 15})
    public enum Type {
        DEFAULT,
        FILE
    }

    public final File a(String audio) {
        return new File(g() + audio + ".mp3");
    }

    public final File b(String cacheKey) {
        return new File(g() + cacheKey + '/');
    }

    public final String c(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkExpressionValueIsNotNull(charsetForName, "Charset.forName(charsetName)");
        byte[] bytes = str.getBytes(charsetForName);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        String string = "";
        for (byte b : messageDigest.digest()) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
            sb.append(str2);
            string = sb.toString();
        }
        return string;
    }

    public final String d(URL url) {
        String string = url.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "url.toString()");
        return c(string);
    }

    public final File e(String cacheKey) {
        return new File(g() + cacheKey + ".svga");
    }

    public final void f(String path) {
        File[] fileArrListFiles;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file = null;
            }
            if (file == null || (fileArrListFiles = file.listFiles()) == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.exists()) {
                    Intrinsics.checkExpressionValueIsNotNull(file2, "file");
                    if (file2.isDirectory()) {
                        SVGACache sVGACache = c;
                        String absolutePath = file2.getAbsolutePath();
                        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
                        sVGACache.f(absolutePath);
                    }
                    file2.delete();
                }
            }
        } catch (Exception e) {
            h63.f17877a.c("SVGACache", "Clear svga cache path: " + path + " fail", e);
        }
    }

    public final String g() {
        if (!Intrinsics.areEqual(cacheDir, "/")) {
            File file = new File(cacheDir);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return cacheDir;
    }

    public final boolean h(String cacheKey) {
        return (i() ? b(cacheKey) : e(cacheKey)).exists();
    }

    public final boolean i() {
        return type == Type.DEFAULT;
    }

    public final boolean j() {
        return (Intrinsics.areEqual("/", g()) ^ true) && new File(g()).exists();
    }

    public final void k(Context context) {
        l(context, Type.DEFAULT);
    }

    public final void l(Context context, Type type2) {
        if (j() || context == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        File cacheDir2 = context.getCacheDir();
        Intrinsics.checkExpressionValueIsNotNull(cacheDir2, "context.cacheDir");
        sb.append(cacheDir2.getAbsolutePath());
        sb.append("/svga/");
        cacheDir = sb.toString();
        File file = new File(g());
        if (!(!file.exists())) {
            file = null;
        }
        if (file != null) {
            file.mkdirs();
        }
        type = type2;
    }
}
