package com.bytedance.realx.base;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface RefCounted {
    void release();

    void retain();
}
