package com.baidu.apis.cluster;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface BaiduClusterRender {

    /* JADX INFO: compiled from: SearchBox */
    public interface LoadCallback {
        void onBitmapCallback(BaiduCluster baiduCluster);
    }

    boolean drawAsync();

    Bitmap getDrawAble(BaiduCluster baiduCluster);

    String getKey(BaiduCluster baiduCluster);

    void loadBitmapAsync(BaiduCluster baiduCluster, LoadCallback loadCallback);
}
