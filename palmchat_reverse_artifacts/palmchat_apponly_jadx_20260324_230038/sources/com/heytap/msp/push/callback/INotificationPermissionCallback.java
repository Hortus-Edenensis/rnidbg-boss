package com.heytap.msp.push.callback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface INotificationPermissionCallback {
    public static final int CODE_FREQUENT = 2004;
    public static final int CODE_HAD_PERMISSION = 2002;
    public static final int CODE_NOT_TOP = 2001;
    public static final int CODE_PARAMS_FAIL = 2000;
    public static final int CODE_SHOWING = 2003;
    public static final int CODE_UNSUPPORT = 2005;

    void onFail(int i, String str);

    void onSuccess();
}
