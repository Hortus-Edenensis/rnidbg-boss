package com.igexin.sdk.router.boatman;

import com.igexin.sdk.router.boatman.receive.Site;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface IShips {
    boolean isRegistered(Site site);

    void register(Site site);

    void unRegister(Site site);
}
