package com.lantern.auth.util.report;

import com.lantern.auth.app.FunDC;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AuthReport {
    public static final int EVENT_CODE_CELL_REQ_FAIL = 2;
    public static final int EVENT_CODE_CELL_REQ_SUC = 1;
    public static final int EVENT_CODE_ONEKEY_CALL_CELL_FAIL = 20;
    public static final int EVENT_CODE_ONEKEY_CALL_CELL_START = 18;
    public static final int EVENT_CODE_ONEKEY_CALL_CELL_SUC = 19;
    public static final int EVENT_CODE_ONEKEY_CALL_NORMAL_FAIL = 17;
    public static final int EVENT_CODE_ONEKEY_CALL_NORMAL_SUC = 16;
    public static final int EVENT_CODE_ONEKEY_CONFIRM_FAIL = 22;
    public static final int EVENT_CODE_ONEKEY_CONFIRM_INVALID = 11;
    public static final int EVENT_CODE_ONEKEY_CONFIRM_OPERATOR_DETAIL = 23;
    public static final int EVENT_CODE_ONEKEY_CONFIRM_OPERATOR_FAIL = 14;
    public static final int EVENT_CODE_ONEKEY_CONFIRM_OPERATOR_SUC = 13;
    public static final int EVENT_CODE_ONEKEY_CONFIRM_OPERATOR_TIMEOUT = 15;
    public static final int EVENT_CODE_ONEKEY_CONFIRM_START = 9;
    public static final int EVENT_CODE_ONEKEY_CONFIRM_SUC = 21;
    public static final int EVENT_CODE_ONEKEY_CONFIRM_TASK_START = 10;
    public static final int EVENT_CODE_ONEKEY_CONFIRM_VALID = 12;
    public static final int EVENT_CODE_ONEKEY_INTERNAL_ERR = 24;
    public static final int EVENT_CODE_ONEKEY_OPERATOR_START = 2;
    public static final int EVENT_CODE_ONEKEY_PRE_FAIL = 8;
    public static final int EVENT_CODE_ONEKEY_PRE_OPERATOR_DETAIL = 6;
    public static final int EVENT_CODE_ONEKEY_PRE_OPERATOR_FAIL = 4;
    public static final int EVENT_CODE_ONEKEY_PRE_OPERATOR_SUC = 3;
    public static final int EVENT_CODE_ONEKEY_PRE_OPERATOR_TIMEOUT = 5;
    public static final int EVENT_CODE_ONEKEY_PRE_START = 1;
    public static final int EVENT_CODE_ONEKEY_PRE_SUC = 7;
    public static final int EVENT_CODE_ONEKEY_RETRY = 25;
    public static final String EVENT_NAME_CELL_REQ = "cell_req";
    public static final String EVENT_NAME_ONEKEY_LOGIN = "onekey";

    public static void doCellEvent(int i) {
        FunDC.onEvent("cell_req_" + i);
    }

    public static void doOnekeyEvent(OneKeyReportInfo oneKeyReportInfo, int i) {
        if (oneKeyReportInfo.isRetry && (i == 3 || i == 4 || i == 7 || i == 8)) {
            return;
        }
        FunDC.onEvent("onekey_" + i, oneKeyReportInfo.toMap());
    }

    public static void doOnekeyEvent(OneKeyReportInfo oneKeyReportInfo, int i, String str) {
        Map<String, String> map = oneKeyReportInfo.toMap();
        map.put("detail", str);
        FunDC.onEvent("onekey_" + i, map);
    }
}
