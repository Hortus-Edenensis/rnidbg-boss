package com.zenmen.palmchat.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CustomScrollView extends NestedScrollView {
    private static final int SCROLL_STATE_IDLE = 1;
    private static final int SCROLL_STATE_SCROLL = 2;
    int currentState;
    boolean isOnScrollToBottom;
    boolean isOnScrollToTop;
    boolean isOnTopPull;
    private e mOnScrollChanged;
    float y1;
    float y2;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CustomScrollView customScrollView = CustomScrollView.this;
            if (customScrollView.currentState == 1) {
                customScrollView.topPull();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CustomScrollView.this.isOnTopPull = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CustomScrollView.this.isOnScrollToTop = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CustomScrollView.this.isOnScrollToBottom = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a();

        void b();

        void c();
    }

    public CustomScrollView(@NonNull Context context) {
        super(context);
        this.currentState = 1;
        this.y1 = 0.0f;
        this.y2 = 0.0f;
        this.isOnTopPull = false;
        this.isOnScrollToTop = false;
        this.isOnScrollToBottom = false;
    }

    private void scrollToBottom() {
        if (this.isOnScrollToBottom) {
            return;
        }
        this.isOnScrollToBottom = true;
        postDelayed(new d(), 100L);
        e eVar = this.mOnScrollChanged;
        if (eVar != null) {
            eVar.a();
        }
    }

    private void scrollToTop() {
        if (this.isOnScrollToTop) {
            return;
        }
        this.isOnScrollToTop = true;
        postDelayed(new c(), 100L);
        e eVar = this.mOnScrollChanged;
        if (eVar != null) {
            eVar.b();
        }
    }

    private void setScrollState(int i) {
        this.currentState = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void topPull() {
        if (this.isOnTopPull) {
            return;
        }
        this.isOnTopPull = true;
        postDelayed(new b(), 100L);
        e eVar = this.mOnScrollChanged;
        if (eVar != null) {
            eVar.c();
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.currentState != 2) {
            setScrollState(2);
        }
        if (i2 == 0 || getScrollY() == 0) {
            topPull();
            return;
        }
        int i5 = i2 - i4;
        if (i5 < 0 && Math.abs(i5) > 10 && getScrollY() > 20) {
            scrollToBottom();
        } else {
            if (i5 <= 0 || Math.abs(i5) <= 10 || getScrollY() <= 20) {
                return;
            }
            scrollToTop();
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.y1 = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY();
            this.y2 = y;
            if (y - this.y1 > 50.0f && getScrollY() == 0 && this.currentState == 1) {
                postDelayed(new a(), 10L);
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.y1 = 0.0f;
            this.y2 = 0.0f;
            setScrollState(1);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnScrollListener(e eVar) {
        this.mOnScrollChanged = eVar;
    }

    public CustomScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentState = 1;
        this.y1 = 0.0f;
        this.y2 = 0.0f;
        this.isOnTopPull = false;
        this.isOnScrollToTop = false;
        this.isOnScrollToBottom = false;
    }

    public CustomScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentState = 1;
        this.y1 = 0.0f;
        this.y2 = 0.0f;
        this.isOnTopPull = false;
        this.isOnScrollToTop = false;
        this.isOnScrollToBottom = false;
    }
}
