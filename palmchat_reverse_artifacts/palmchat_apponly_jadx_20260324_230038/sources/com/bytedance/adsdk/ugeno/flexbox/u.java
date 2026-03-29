package com.bytedance.adsdk.ugeno.flexbox;

import android.view.View;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
interface u {
    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<fx> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int nr(int i, int i2, int i3);

    View nr(int i);

    void setFlexLines(List<fx> list);

    int u(int i, int i2, int i3);

    int u(View view);

    int u(View view, int i, int i2);

    View u(int i);

    void u(View view, int i, int i2, fx fxVar);

    void u(fx fxVar);

    boolean u();
}
