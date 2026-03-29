package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.Point;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface NaviMapViewListener {
    void onAction(int i, Object obj);

    boolean onItemClick(String str, int i, int i2);

    void onMapAnimationFinish();

    void onMapRenderModeChange(int i);

    Point onTapInterception(Point point);

    void resizeScreen(int i, int i2);
}
