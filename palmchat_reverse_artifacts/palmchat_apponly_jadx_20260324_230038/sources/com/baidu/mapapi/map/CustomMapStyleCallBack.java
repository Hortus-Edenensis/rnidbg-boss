package com.baidu.mapapi.map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface CustomMapStyleCallBack {
    boolean onCustomMapStyleLoadFailed(int i, String str, String str2);

    boolean onCustomMapStyleLoadSuccess(boolean z, String str);

    boolean onPreLoadLastCustomMapStyle(String str);
}
