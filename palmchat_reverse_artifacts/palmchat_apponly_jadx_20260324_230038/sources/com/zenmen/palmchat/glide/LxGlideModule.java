package com.zenmen.palmchat.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.zenmen.palmchat.glide.a;
import com.zenmen.palmchat.glide.b;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ea3;
import defpackage.lh3;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@GlideModule
public class LxGlideModule extends AppGlideModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f14111a = "LxGlideModule";

    public final int a(Context context) {
        int memoryCacheSize = new MemorySizeCalculator.Builder(context).setMemoryCacheScreens(4.0f).build().getMemoryCacheSize();
        LogUtil.d(f14111a, "MemoryCacheSize:" + memoryCacheSize);
        return memoryCacheSize;
    }

    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
        glideBuilder.setMemoryCache(new LruResourceCache(a(context)));
        glideBuilder.setDiskCache(new ea3(context, AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_CACHE_SIZE));
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() {
        return false;
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
        if (lh3.a().e()) {
            registry.replace(GlideUrl.class, InputStream.class, new a.C1058a(lh3.a().b()));
        } else {
            registry.replace(GlideUrl.class, InputStream.class, new b.a());
        }
    }
}
