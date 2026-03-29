package com.baidu.platform.comjni;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class NativeComponent extends JNIBaseApi implements AutoCloseable {
    protected volatile long mNativePointer;

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        dispose();
    }

    public abstract long create();

    public abstract int dispose();
}
