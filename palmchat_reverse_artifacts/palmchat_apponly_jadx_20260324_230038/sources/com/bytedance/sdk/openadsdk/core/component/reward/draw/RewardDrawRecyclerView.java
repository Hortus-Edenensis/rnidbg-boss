package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class RewardDrawRecyclerView extends RecyclerView {
    public RewardDrawRecyclerView(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        k.nr("lfz", motionEvent.toString());
        return false;
    }
}
