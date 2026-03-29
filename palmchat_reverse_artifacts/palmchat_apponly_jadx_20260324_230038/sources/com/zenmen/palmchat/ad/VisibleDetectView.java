package com.zenmen.palmchat.ad;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class VisibleDetectView extends FrameLayout {
    private Runnable mCheckVisibleRunnable;
    private Boolean mIsFullyVisible;
    private d mListener;
    private Object mOnScrollListener;
    private Object mRecyclerView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VisibleDetectView.this.checkFullyVisible();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            VisibleDetectView.this.checkFullyVisible();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements f {
        public c() {
        }

        @Override // com.zenmen.palmchat.ad.VisibleDetectView.f
        public void a() {
            VisibleDetectView.this.checkFullyVisible();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void addOnScrollListener(f fVar);

        void removeOnScrollListener(f fVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a();
    }

    public VisibleDetectView(Context context) {
        super(context);
        this.mIsFullyVisible = null;
        this.mCheckVisibleRunnable = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFullyVisible() {
        boolean zIsFullyVisible = isFullyVisible();
        Boolean bool = this.mIsFullyVisible;
        if (bool == null || bool.booleanValue() != zIsFullyVisible) {
            Boolean boolValueOf = Boolean.valueOf(zIsFullyVisible);
            this.mIsFullyVisible = boolValueOf;
            d dVar = this.mListener;
            if (dVar != null) {
                dVar.a(boolValueOf.booleanValue());
            }
        }
    }

    private boolean isFullyVisible() {
        Rect rect = new Rect();
        return getGlobalVisibleRect(rect) && rect.width() >= getMeasuredWidth() && rect.height() >= getMeasuredHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = this;
        do {
            parent = parent.getParent();
            if (parent == null) {
                return;
            }
            if (parent instanceof RecyclerView) {
                this.mRecyclerView = (RecyclerView) parent;
                b bVar = new b();
                this.mOnScrollListener = bVar;
                ((RecyclerView) this.mRecyclerView).addOnScrollListener(bVar);
                return;
            }
        } while (!(parent instanceof e));
        this.mRecyclerView = (e) parent;
        c cVar = new c();
        this.mOnScrollListener = cVar;
        ((e) this.mRecyclerView).addOnScrollListener(cVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Object obj = this.mRecyclerView;
        if (obj instanceof RecyclerView) {
            ((RecyclerView) obj).removeOnScrollListener((RecyclerView.OnScrollListener) this.mOnScrollListener);
            this.mRecyclerView = null;
        } else if (obj instanceof e) {
            ((e) obj).removeOnScrollListener((f) this.mOnScrollListener);
            this.mRecyclerView = null;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        post(this.mCheckVisibleRunnable);
    }

    public void setFullyVisibleListener(d dVar) {
        this.mListener = dVar;
    }

    public VisibleDetectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsFullyVisible = null;
        this.mCheckVisibleRunnable = new a();
    }

    public VisibleDetectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsFullyVisible = null;
        this.mCheckVisibleRunnable = new a();
    }
}
