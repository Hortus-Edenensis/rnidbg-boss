package com.baidu.mapauto.auth.constant;

import com.amap.api.services.core.AMapException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ErrorCode {
    public static final int CODE_CHECK_SIGN_ERROR = -1006;
    public static final int CODE_INNER_ERROR = -1001;
    public static final int CODE_NET_WORK_ERROR = -1003;
    public static final int CODE_NET_WORK_TIMEOUT = -1004;
    public static final int CODE_PARAMETER_ERROR = -1002;
    public static final int CODE_SERVER_ERROR = -1005;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNKNOWN_ERROR = -1000;

    public static String getCodeDesc(int i) {
        if (i == 0) {
            return "成功";
        }
        if (i == -1001) {
            return "内部错误";
        }
        if (i == -1002) {
            return "参数错误";
        }
        if (i == -1003) {
            return "网络错误";
        }
        if (i == -1004) {
            return "网络超时错误";
        }
        if (i == -1005) {
            return "服务错误";
        }
        if (i == -1006) {
            return "校验错误";
        }
        if (i == -1000) {
            return AMapException.AMAP_CLIENT_UNKNOWN_ERROR;
        }
        throw new UnsupportedOperationException();
    }
}
