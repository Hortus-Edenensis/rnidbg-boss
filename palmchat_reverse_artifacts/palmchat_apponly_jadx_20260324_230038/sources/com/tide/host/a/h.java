package com.tide.host.a;

import android.content.Context;
import com.tide.protocol.host.IDexLoaderManager;
import com.tide.protocol.util.TdFileUtils;
import dalvik.system.DexClassLoader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class h implements IDexLoaderManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10789a;
    public final String b;
    public final String c;
    public volatile DexClassLoader d = a();

    public h(Context context, String str, String str2) {
        this.f10789a = context;
        this.b = str;
        this.c = str2;
    }

    public final DexClassLoader a() {
        return new DexClassLoader(this.b, TdFileUtils.getDexOutputDir(this.f10789a, this.c), null, this.f10789a.getClassLoader());
    }

    @Override // com.tide.protocol.host.IDexLoaderManager
    public final DexClassLoader getDexClassLoader() {
        if (this.d == null) {
            synchronized (h.class) {
                if (this.d == null) {
                    this.d = a();
                }
            }
        }
        return this.d;
    }
}
