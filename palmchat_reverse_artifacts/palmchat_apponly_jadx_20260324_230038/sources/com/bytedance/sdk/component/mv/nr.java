package com.bytedance.sdk.component.mv;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface nr {

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        Pair<Boolean, Boolean> u(View view, MotionEvent motionEvent);
    }

    void setTag(int i, Object obj);

    void setTouchEventListener(u uVar);
}
