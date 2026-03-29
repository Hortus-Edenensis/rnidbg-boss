package defpackage;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ea3 extends DiskLruCacheFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DiskCache f17245a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f17246a;

        public a(Context context) {
            this.f17246a = context;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            File fileD = pu1.d(this.f17246a);
            LogUtil.d("LxGlideModule", fileD.getAbsolutePath());
            return fileD;
        }
    }

    public ea3(Context context, int i) {
        super(new a(context), i);
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory, com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        DiskCache diskCacheBuild = super.build();
        f17245a = diskCacheBuild;
        return diskCacheBuild;
    }
}
