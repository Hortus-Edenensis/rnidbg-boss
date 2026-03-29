package com.baidu.platform.core.sug;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface ISuggestionSearch {
    void destroy();

    boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption);

    void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener);
}
