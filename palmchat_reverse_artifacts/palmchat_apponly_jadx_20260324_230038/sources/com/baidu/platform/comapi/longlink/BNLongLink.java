package com.baidu.platform.comapi.longlink;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BNLongLink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static BNLongLinkInitCallBack f4145a;

    public static void initLongLink() {
        BNLongLinkInitCallBack bNLongLinkInitCallBack = f4145a;
        if (bNLongLinkInitCallBack != null) {
            bNLongLinkInitCallBack.onLongLinkInit();
        }
    }

    public static void registerLongLinkInitCallBack(BNLongLinkInitCallBack bNLongLinkInitCallBack) {
        f4145a = bNLongLinkInitCallBack;
    }

    public static void unRegisterLongLinkInitCallBack(BNLongLinkInitCallBack bNLongLinkInitCallBack) {
        f4145a = bNLongLinkInitCallBack;
    }
}
