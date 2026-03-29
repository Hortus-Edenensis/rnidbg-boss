package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.core.dislike.u.nr;
import com.bytedance.sdk.openadsdk.my.fx.nr.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTDislikeScrollListView extends ListView {
    private AdapterView.OnItemClickListener fx;
    private AdapterView.OnItemClickListener nr;
    private nr u;

    public TTDislikeScrollListView(Context context) {
        super(context);
        this.fx = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.widget.TTDislikeScrollListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TTDislikeScrollListView.this.getAdapter() == null || TTDislikeScrollListView.this.getAdapter().getItem(i) == null || !(TTDislikeScrollListView.this.getAdapter().getItem(i) instanceof iz)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                iz izVar = (iz) TTDislikeScrollListView.this.getAdapter().getItem(i);
                if (izVar.x()) {
                    return;
                }
                if (TTDislikeScrollListView.this.nr != null) {
                    TTDislikeScrollListView.this.nr.onItemClick(adapterView, view, i, j);
                }
                if (TTDislikeScrollListView.this.u != null) {
                    TTDislikeScrollListView.this.u.u(izVar);
                }
            }
        };
        u();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void setDislikeController(nr nrVar) {
        this.u = nrVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.nr = onItemClickListener;
    }

    private void u() {
        super.setOnItemClickListener(this.fx);
    }
}
