package com.baidu.mapapi.map;

import com.baidu.mapapi.map.BackgroundDrawMapView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
interface IBackgroundDrawLayer {
    void onCreate();

    void onDestroy();

    void onDraw(BackgroundDrawMapView.CanvasProxy canvasProxy);

    void onSizeChanged(int i, int i2);

    void onUpdated();
}
