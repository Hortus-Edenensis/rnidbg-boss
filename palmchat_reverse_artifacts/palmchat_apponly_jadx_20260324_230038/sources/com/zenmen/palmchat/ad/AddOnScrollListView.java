package com.zenmen.palmchat.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;
import com.zenmen.palmchat.ad.VisibleDetectView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AddOnScrollListView extends ListView implements VisibleDetectView.e {
    private AbsListView.OnScrollListener mOnScrollListener;
    private List<VisibleDetectView.f> mOnScrollListeners;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AddOnScrollListView.this.mOnScrollListener != null) {
                AddOnScrollListView.this.mOnScrollListener.onScroll(absListView, i, i2, i3);
            }
            Iterator it = AddOnScrollListView.this.mOnScrollListeners.iterator();
            while (it.hasNext()) {
                ((VisibleDetectView.f) it.next()).a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (AddOnScrollListView.this.mOnScrollListener != null) {
                AddOnScrollListView.this.mOnScrollListener.onScrollStateChanged(absListView, i);
            }
        }
    }

    public AddOnScrollListView(Context context) {
        super(context);
        this.mOnScrollListeners = new LinkedList();
        init(context);
    }

    private void init(Context context) {
        super.setOnScrollListener(new a());
    }

    @Override // com.zenmen.palmchat.ad.VisibleDetectView.e
    public void addOnScrollListener(VisibleDetectView.f fVar) {
        this.mOnScrollListeners.add(fVar);
    }

    @Override // com.zenmen.palmchat.ad.VisibleDetectView.e
    public void removeOnScrollListener(VisibleDetectView.f fVar) {
        this.mOnScrollListeners.remove(fVar);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public AddOnScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnScrollListeners = new LinkedList();
        init(context);
    }

    public AddOnScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnScrollListeners = new LinkedList();
        init(context);
    }
}
