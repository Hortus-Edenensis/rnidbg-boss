package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.signature.EmptySignature;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ea3;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class sd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile SafeKeyGenerator f20717a;

    public static Bitmap a(String str) {
        File fileB = b(str);
        if (fileB != null && fileB.exists()) {
            try {
                return BitmapFactory.decodeFile(fileB.getAbsolutePath());
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static File b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ju0 ju0Var = new ju0(new GlideUrl(str), EmptySignature.obtain());
        DiskCache diskCache = ea3.f17245a;
        if (diskCache != null) {
            File file = diskCache.get(ju0Var);
            if (file != null) {
                LogUtil.d("logglide", "cache file = " + file.getAbsolutePath());
            }
            return file;
        }
        if (f20717a == null) {
            f20717a = new SafeKeyGenerator();
        }
        try {
            DiskLruCache.Value value = DiskLruCache.open(new ea3.a(c.b()).getCacheDirectory(), 1, 1, 2147483647L).get(f20717a.getSafeKey(ju0Var));
            if (value != null) {
                return value.getFile(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
