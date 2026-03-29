package com.zenmen.square.fragment.online;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.widget.LightingAnimationView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OnLineMineLightLayout extends FrameLayout {
    private OnLineItemData itemData;
    private LightingAnimationView mineLightAnimView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OnLineMineLightLayout.this.mineLightAnimView.getWidth() <= 0 || OnLineMineLightLayout.this.mineLightAnimView.getHeight() <= 0) {
                OnLineMineLightLayout.this.postDelay();
                return;
            }
            if (OnLineMineLightLayout.this.itemData != null) {
                OnLineMineLightLayout.this.itemData.hasMineAnim = true;
            }
            OnLineMineLightLayout.this.mineLightAnimView.startLightingAnimation(0);
        }
    }

    public OnLineMineLightLayout(@NonNull Context context) {
        super(context);
        this.itemData = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postDelay() {
        this.mineLightAnimView.postDelayed(new a(), 100L);
    }

    public void setMineLightAnimView(LightingAnimationView lightingAnimationView, OnLineItemData onLineItemData) {
        this.mineLightAnimView = lightingAnimationView;
        this.itemData = onLineItemData;
        if (onLineItemData.hasMineAnim) {
            return;
        }
        postDelay();
    }

    public OnLineMineLightLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.itemData = null;
    }

    public OnLineMineLightLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.itemData = null;
    }
}
