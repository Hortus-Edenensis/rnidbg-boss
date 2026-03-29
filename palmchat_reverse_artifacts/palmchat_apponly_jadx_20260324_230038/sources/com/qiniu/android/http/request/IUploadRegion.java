package com.qiniu.android.http.request;

import com.qiniu.android.common.ZoneInfo;
import com.qiniu.android.http.ResponseInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IUploadRegion {
    IUploadServer getNextServer(UploadRequestState uploadRequestState, ResponseInfo responseInfo, IUploadServer iUploadServer);

    ZoneInfo getZoneInfo();

    boolean isEqual(IUploadRegion iUploadRegion);

    boolean isValid();

    void setupRegionData(ZoneInfo zoneInfo);

    void updateIpListFormHost(String str);
}
