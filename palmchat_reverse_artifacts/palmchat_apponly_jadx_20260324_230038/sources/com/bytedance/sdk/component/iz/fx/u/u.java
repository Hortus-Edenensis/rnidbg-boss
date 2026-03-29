package com.bytedance.sdk.component.iz.fx.u;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.component.iz.nr, Cloneable {
    private static volatile com.bytedance.sdk.component.iz.nr x;
    private boolean b;
    private int fx;
    private File iz;
    private int nr;
    private boolean pn;
    private long u;

    public u(int i, long j, File file) {
        this(i, 0, j, i != 0, j != 0, file);
    }

    private static long nr() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static void u(Context context, com.bytedance.sdk.component.iz.nr nrVar) {
        if (nrVar != null) {
            x = nrVar;
        } else {
            x = u(new File(com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context), "image"));
        }
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public File getCacheDir() {
        return this.iz;
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public long getFileCacheSize() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public int getMemoryCacheSize() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public int getRawMemoryCacheSize() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public boolean isDiskCache() {
        return this.pn;
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public boolean isMemoryCache() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public boolean isQueryAll() {
        return true;
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public boolean isRawMemoryCache() {
        return this.fx > 0;
    }

    public u(int i, int i2, long j, boolean z, boolean z2, File file) {
        this.u = j;
        this.nr = i;
        this.fx = i2;
        this.b = z;
        this.pn = z2;
        this.iz = file;
    }

    public static com.bytedance.sdk.component.iz.nr u(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (x == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, BmLocated.ALIGN_RIGHT_BOTTOM);
            jMin = Math.min(nr() / 16, 31457280L);
        } else {
            iMin = Math.min(x.getMemoryCacheSize() / 2, BmLocated.ALIGN_RIGHT_BOTTOM);
            jMin = Math.min(x.getFileCacheSize() / 2, 31457280L);
        }
        return new u(Math.max(iMin, 5242880), Math.max(jMin, 10485760L), file);
    }

    public static com.bytedance.sdk.component.iz.nr u() {
        return x;
    }
}
