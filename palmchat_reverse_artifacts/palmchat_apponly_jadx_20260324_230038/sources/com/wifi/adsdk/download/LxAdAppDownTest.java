package com.wifi.adsdk.download;

import com.huawei.hms.ads.dynamicloader.b;
import com.wifi.ad.core.callback.LxAdDownListener;
import com.wifi.adsdk.utils.LxAdLog;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdAppDownTest {
    private static boolean deleteDown = false;
    private static LxAdDownListener downAllListener = null;
    private static String filePath = null;
    private static int finalNum = 0;
    private static boolean resumeDown = true;

    public static /* synthetic */ int access$008() {
        int i = finalNum;
        finalNum = i + 1;
        return i;
    }

    public static void deleteDownApp(String str) {
        deleteDown = true;
    }

    public static void resumeDlAd(String str, String str2) {
        resumeDown = true;
        timeTest(str2);
    }

    public static void startDownL(String str, String str2, String str3, LxAdDownListener lxAdDownListener) {
        LxAdLog.d("LXadsplash LxAdAppDownTest startDownL  pkgName " + str3);
        downAllListener = lxAdDownListener;
        if (lxAdDownListener != null) {
            filePath = str2 + "/" + str3 + b.b;
            lxAdDownListener.onStart(str3);
            timeTest(str3);
        }
    }

    public static void stopDlAd(String str) {
        LxAdLog.d("LXadsplash stopDlAd finalNum " + finalNum + " pkgName " + str);
        resumeDown = false;
        LxAdDownListener lxAdDownListener = downAllListener;
        if (lxAdDownListener != null) {
            lxAdDownListener.onStop(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void timeTest(final String str) {
        new Timer().schedule(new TimerTask() { // from class: com.wifi.adsdk.download.LxAdAppDownTest.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (LxAdAppDownTest.finalNum <= 100 && LxAdAppDownTest.resumeDown && !LxAdAppDownTest.deleteDown) {
                    LxAdAppDownTest.timeTest(str);
                    LxAdAppDownTest.access$008();
                    if (LxAdAppDownTest.finalNum == 100) {
                        if (LxAdAppDownTest.downAllListener != null) {
                            LxAdAppDownTest.downAllListener.onFinish(str);
                        }
                    } else if (LxAdAppDownTest.downAllListener != null) {
                        LxAdAppDownTest.downAllListener.onProgress(LxAdAppDownTest.finalNum, str);
                    }
                }
                LxAdLog.d("LXadsplash startDownL finalNum " + LxAdAppDownTest.finalNum);
            }
        }, 1000L);
    }
}
