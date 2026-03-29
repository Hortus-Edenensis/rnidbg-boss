package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BmDrawableResource extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f4121a = new Object();
    private static List<WeakReference<BmDrawableResource>> b = new ArrayList();
    private a c;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    private BmDrawableResource() {
        super(55, 0L);
        this.c = null;
    }

    private static native boolean nativeSetListener(long j, boolean z);

    public BmDrawableResource(int i, long j) {
        super(i, j);
        this.c = null;
    }
}
