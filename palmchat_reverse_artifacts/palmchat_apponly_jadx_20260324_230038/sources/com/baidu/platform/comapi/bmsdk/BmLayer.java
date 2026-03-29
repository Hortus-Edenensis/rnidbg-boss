package com.baidu.platform.comapi.bmsdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmLayer extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<BmDrawItem> f4111a;
    private c b;
    private long c;
    private final Object d;

    public BmLayer() {
        super(1, nativeCreate());
        this.f4111a = new ArrayList<>();
        this.b = null;
        this.c = 0L;
        this.d = new Object();
    }

    private static native boolean nativeAddDrawItem(long j, long j2);

    private static native boolean nativeAddDrawItemAbove(long j, long j2, long j3);

    private static native boolean nativeAddDrawItemBelow(long j, long j2, long j3);

    private static native boolean nativeAddDrawItemByZIndex(long j, long j2, int i);

    private static native boolean nativeClearDrawItems(long j);

    private static native boolean nativeCommitUpdate(long j);

    private static native long nativeCreate();

    private static native Bundle nativeGetDrawItemRect(long j, int i, int i2, int i3, int i4);

    private static native long nativeGetLayerId(long j);

    private static native boolean nativeHandleClick(long j, int i, int i2, int i3, long[] jArr);

    private static native boolean nativeRemoveDrawItem(long j, long j2);

    private static native boolean nativeSDKHandleClick(long j, int i, int i2, int i3, long[] jArr, Bundle bundle);

    private static native boolean nativeSetClickable(long j, boolean z);

    private static native boolean nativeSetCollideByArea(long j, boolean z);

    private static native boolean nativeSetCollisionBaseMap(long j, boolean z);

    private static native boolean nativeSetShowLevel(long j, int i, int i2);

    private static native boolean nativeSetVisibility(long j, int i);

    private static native boolean nativeUpdateDrawItemZIndex(long j, long j2, int i);

    public boolean a(BmDrawItem bmDrawItem, int i) {
        synchronized (this.d) {
            this.f4111a.add(bmDrawItem);
        }
        return nativeAddDrawItemByZIndex(this.nativeInstance, bmDrawItem.getNativeInstance(), i);
    }

    public boolean b() {
        return nativeCommitUpdate(this.nativeInstance);
    }

    public long c() {
        if (this.c == 0) {
            this.c = nativeGetLayerId(this.nativeInstance);
        }
        return this.c;
    }

    public BmLayer(boolean z) {
        super(1, nativeCreate());
        this.f4111a = new ArrayList<>();
        this.b = null;
        this.c = 0L;
        this.d = new Object();
        nativeSetCollisionBaseMap(this.nativeInstance, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042 A[Catch: all -> 0x0055, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:8:0x0014, B:10:0x0026, B:15:0x0042, B:16:0x0047, B:11:0x003a), top: B:22:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, BmDrawItem bmDrawItem) {
        long nativeInstance;
        synchronized (this.d) {
            if (TextUtils.isEmpty(str)) {
                nativeInstance = 0;
                if (nativeInstance == 0) {
                }
            } else {
                int size = this.f4111a.size();
                for (int i = 0; i < size; i++) {
                    if (str.equals(this.f4111a.get(i).getName())) {
                        nativeInstance = this.f4111a.get(i).getNativeInstance();
                        this.f4111a.add(i + 1, bmDrawItem);
                        break;
                    }
                }
                nativeInstance = 0;
                if (nativeInstance == 0) {
                    this.f4111a.add(bmDrawItem);
                }
            }
        }
        return nativeAddDrawItemAbove(this.nativeInstance, nativeInstance, bmDrawItem.getNativeInstance());
    }

    public boolean a(BmDrawItem bmDrawItem) {
        synchronized (this.d) {
            this.f4111a.remove(bmDrawItem);
        }
        return nativeRemoveDrawItem(this.nativeInstance, bmDrawItem.getNativeInstance());
    }

    public boolean a() {
        synchronized (this.d) {
            this.f4111a.clear();
        }
        return nativeClearDrawItems(this.nativeInstance);
    }

    public BmDrawItem a(String str) {
        synchronized (this.d) {
            for (BmDrawItem bmDrawItem : this.f4111a) {
                if (!str.isEmpty() && bmDrawItem.getName().equals(str)) {
                    return bmDrawItem;
                }
            }
            return null;
        }
    }

    public boolean a(BmDrawItem bmDrawItem, short s) {
        return nativeUpdateDrawItemZIndex(this.nativeInstance, bmDrawItem.getNativeInstance(), s);
    }

    public BmDrawItem a(int i, int i2, int i3) {
        long[] jArr = {0, 0, -1};
        if (!nativeSDKHandleClick(this.nativeInstance, i, i2, i3, jArr, new Bundle()) || this.b == null) {
            return null;
        }
        long j = jArr[0];
        if (j == 0) {
            return null;
        }
        synchronized (this.d) {
            for (int i4 = 0; i4 < this.f4111a.size(); i4++) {
                BmDrawItem bmDrawItem = this.f4111a.get(i4);
                if (bmDrawItem.nativeInstance == j) {
                    return bmDrawItem;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0066 A[Catch: all -> 0x00a9, TryCatch #0 {, blocks: (B:10:0x0028, B:12:0x0030, B:14:0x003e, B:16:0x0045, B:18:0x0049, B:23:0x005e, B:25:0x0066, B:26:0x0070, B:28:0x0078, B:32:0x008a, B:33:0x0090, B:35:0x0098, B:36:0x009e, B:19:0x0051, B:21:0x0055, B:37:0x00a4, B:38:0x00a7), top: B:44:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078 A[Catch: all -> 0x00a9, TryCatch #0 {, blocks: (B:10:0x0028, B:12:0x0030, B:14:0x003e, B:16:0x0045, B:18:0x0049, B:23:0x005e, B:25:0x0066, B:26:0x0070, B:28:0x0078, B:32:0x008a, B:33:0x0090, B:35:0x0098, B:36:0x009e, B:19:0x0051, B:21:0x0055, B:37:0x00a4, B:38:0x00a7), top: B:44:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(int i, int i2, int i3, boolean z, boolean z2) {
        BmBaseUI bmBaseUIB;
        long[] jArr = {0, 0, -1};
        Bundle bundle = new Bundle();
        boolean zNativeSDKHandleClick = nativeSDKHandleClick(this.nativeInstance, i, i2, i3, jArr, bundle);
        if (zNativeSDKHandleClick && this.b != null) {
            int i4 = 0;
            long j = jArr[0];
            if (j != 0) {
                synchronized (this.d) {
                    while (true) {
                        if (i4 >= this.f4111a.size()) {
                            break;
                        }
                        BmDrawItem bmDrawItem = this.f4111a.get(i4);
                        if (bmDrawItem.nativeInstance == j) {
                            long j2 = jArr[1];
                            if (j2 != 0) {
                                if (bmDrawItem instanceof BmBaseMarker) {
                                    bmBaseUIB = ((BmBaseMarker) bmDrawItem).b(j2);
                                } else if (bmDrawItem instanceof Bm3DModel) {
                                    bmBaseUIB = ((Bm3DModel) bmDrawItem).b(j2);
                                }
                                if (bundle.containsKey("hole_index")) {
                                    bmDrawItem.a(bundle.getInt("hole_index"));
                                }
                                if (bundle.containsKey("multipoint_index")) {
                                    ((BmMultiPoint) bmDrawItem).e(bundle.getInt("multipoint_index"));
                                }
                                if (z) {
                                    if (bmBaseUIB != null) {
                                        this.b.a(bmDrawItem, bmBaseUIB);
                                    } else {
                                        this.b.a(bmDrawItem);
                                    }
                                } else if (z2) {
                                    if (bmBaseUIB != null) {
                                        this.b.a(bmDrawItem, bmBaseUIB);
                                    } else {
                                        this.b.a(bmDrawItem);
                                    }
                                }
                            }
                            bmBaseUIB = null;
                            if (bundle.containsKey("hole_index")) {
                            }
                            if (bundle.containsKey("multipoint_index")) {
                            }
                            if (z) {
                            }
                        } else {
                            i4++;
                        }
                    }
                }
            }
        }
        return zNativeSDKHandleClick;
    }

    public void a(c cVar) {
        this.b = cVar;
    }
}
