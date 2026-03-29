package defpackage;

import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.baidu.mapapi.map.WeightedLatLng;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface xu4 {
    xu4 closeHeaderOrFooter();

    xu4 finishLoadMore();

    xu4 finishLoadMore(boolean z);

    xu4 finishLoadMoreWithNoMoreData();

    xu4 finishRefresh();

    xu4 finishRefresh(boolean z);

    @NonNull
    ViewGroup getLayout();

    @NonNull
    RefreshState getState();

    xu4 setEnableAutoLoadMore(boolean z);

    xu4 setEnableLoadMore(boolean z);

    xu4 setEnableNestedScroll(boolean z);

    xu4 setHeaderMaxDragRate(@FloatRange(from = WeightedLatLng.DEFAULT_INTENSITY, to = 10.0d) float f);
}
