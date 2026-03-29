package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.util.MapTaskManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BmObject implements AutoCloseable {
    private static final boolean DEBUG = false;
    private boolean isRelease;
    private String mName;
    protected final int mObjType;
    private String mTag;
    protected final long nativeInstance;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f4112a;

        public a(long j) {
            this.f4112a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            BmFinalizerObject.a(this.f4112a);
        }
    }

    private BmObject() {
        this.mName = "";
        this.mTag = "";
        this.isRelease = false;
        this.mObjType = 0;
        this.nativeInstance = 0L;
    }

    private synchronized void dispose() {
        long j = this.nativeInstance;
        if (j != 0 && !this.isRelease) {
            this.isRelease = true;
            MapTaskManager.getSingleThreadPool().submit(new a(j));
        }
    }

    private static native void nativeFinalizer(long j);

    private static native boolean nativeSetLayerTag(long j, String str);

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        try {
            dispose();
        } catch (Throwable unused) {
        }
    }

    public String getName() {
        return this.mName;
    }

    public long getNativeInstance() {
        return this.nativeInstance;
    }

    public int getObjType() {
        return this.mObjType;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean setLayerTag(String str) {
        return nativeSetLayerTag(this.nativeInstance, str);
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public BmObject(int i, long j) {
        this.mName = "";
        this.mTag = "";
        this.isRelease = false;
        this.mObjType = i;
        this.nativeInstance = j;
    }

    private void printDebugFinalize() {
    }

    private void printDebugNew() {
    }
}
