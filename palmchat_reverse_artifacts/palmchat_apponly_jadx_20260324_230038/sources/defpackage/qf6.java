package defpackage;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.greendao.model.Feed;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class qf6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20243a = true;
    public ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                qf6.this.g(recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (qf6.this.f20243a) {
                qf6.this.g(recyclerView);
                qf6.this.f20243a = false;
            }
        }
    }

    public final int[] c(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        int i2 = iArr2[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i > i4) {
                i = i4;
            }
        }
        for (int i5 = 1; i5 < iArr2.length; i5++) {
            int i6 = iArr2[i5];
            if (i2 < i6) {
                i2 = i6;
            }
        }
        return new int[]{i, i2};
    }

    public final int[] d(GridLayoutManager gridLayoutManager) {
        return new int[]{gridLayoutManager.findFirstVisibleItemPosition(), gridLayoutManager.findLastVisibleItemPosition()};
    }

    public final int[] e(LinearLayoutManager linearLayoutManager) {
        return new int[]{linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()};
    }

    public final int[] f(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        int[] iArr2 = new int[staggeredGridLayoutManager.getSpanCount()];
        staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
        staggeredGridLayoutManager.findLastVisibleItemPositions(iArr2);
        return c(iArr, iArr2);
    }

    public void g(RecyclerView recyclerView) {
        if (recyclerView != null && recyclerView.getVisibility() == 0 && recyclerView.isShown() && recyclerView.getGlobalVisibleRect(new Rect())) {
            try {
                int[] iArrF = new int[2];
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    iArrF = e((LinearLayoutManager) layoutManager);
                } else if (layoutManager instanceof GridLayoutManager) {
                    iArrF = d((GridLayoutManager) layoutManager);
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    iArrF = f((StaggeredGridLayoutManager) layoutManager);
                }
                if (iArrF != null && iArrF.length >= 2) {
                    Log.i("ViewShowCountUtils", "屏幕内可见条目的起始位置：" + iArrF[0] + "---" + iArrF[1]);
                    for (int i = iArrF[0]; i <= iArrF[1]; i++) {
                        h(layoutManager.findViewByPosition(i));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void h(View view) {
        Feed feed;
        if (view != null && view.getVisibility() == 0 && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect) && rect.height() >= view.getMeasuredHeight() / 2 && (feed = (Feed) view.getTag(R$id.recycler_view_tag)) != null && feed.getFeedId() != null) {
                String strValueOf = String.valueOf(feed.getFeedId());
                if (this.b.containsKey(strValueOf)) {
                    ConcurrentHashMap<String, Integer> concurrentHashMap = this.b;
                    concurrentHashMap.put(strValueOf, Integer.valueOf(concurrentHashMap.get(strValueOf).intValue() + 1));
                } else {
                    h05.i(feed);
                    this.b.put(strValueOf, 1);
                }
                Log.i("ViewShowCountUtils", strValueOf + "----出现次数：" + this.b.get(strValueOf));
            }
        }
    }

    public void i(RecyclerView recyclerView) {
        this.b.clear();
        if (recyclerView == null || recyclerView.getVisibility() != 0) {
            return;
        }
        recyclerView.addOnScrollListener(new a());
    }
}
