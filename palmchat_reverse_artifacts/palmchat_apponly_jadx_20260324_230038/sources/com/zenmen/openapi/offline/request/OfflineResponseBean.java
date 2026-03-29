package com.zenmen.openapi.offline.request;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class OfflineResponseBean extends BaseBean {
    List<FetchPkgInfo> pkgInfos;

    public List<FetchPkgInfo> getPkgInfos() {
        return this.pkgInfos;
    }

    public void setPkgInfos(List<FetchPkgInfo> list) {
        this.pkgInfos = list;
    }
}
