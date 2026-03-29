package com.wifi.adsdk.event;

import com.wifi.adsdk.entity.LxEventReplace;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AdEventManager {
    private static AdEventManager mManager;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    private AdEventManager() {
    }

    public static AdEventManager getInstance() {
        if (mManager == null) {
            synchronized (AdEventManager.class) {
                if (mManager == null) {
                    mManager = new AdEventManager();
                }
            }
        }
        return mManager;
    }

    public void onAdEvent(List<String> list, LxEventReplace lxEventReplace) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.executorService.execute(new AdEventHttpGetTask(list, lxEventReplace));
    }
}
