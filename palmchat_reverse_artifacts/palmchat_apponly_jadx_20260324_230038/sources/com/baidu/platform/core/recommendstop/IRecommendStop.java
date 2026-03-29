package com.baidu.platform.core.recommendstop;

import com.baidu.mapapi.search.recommendstop.OnGetRecommendStopResultListener;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface IRecommendStop {
    void destroy();

    boolean requestRecommendStop(RecommendStopSearchOption recommendStopSearchOption);

    void setOnGetRecommendStopResultListener(OnGetRecommendStopResultListener onGetRecommendStopResultListener);
}
