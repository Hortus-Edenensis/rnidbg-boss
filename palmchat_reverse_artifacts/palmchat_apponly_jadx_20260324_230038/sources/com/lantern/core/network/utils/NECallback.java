package com.lantern.core.network.utils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface NECallback {
    public static final int CANCEL = 2;
    public static final int ERROR = 0;
    public static final int ERROR_ACTIVITY_NOT_FOUND = 1000;
    public static final int ERROR_ACTIVITY_SECURITY = 1001;
    public static final int ERROR_FILESYSTEM = 20;
    public static final int ERROR_JSONDATA = 30;
    public static final int ERROR_NETWORK = 10;
    public static final int ERROR_NETWORK_NO_MOBILE_DATA = 12;
    public static final int ERROR_NETWORK_NO_WIFI = 11;
    public static final int ERROR_NETWORK_TIME_OUT = 13;
    public static final int ERROR_TOKEN = 40;
    public static final int PROCESS = 3;
    public static final int SUCCESS = 1;

    void run(int i, String str, Object obj);
}
