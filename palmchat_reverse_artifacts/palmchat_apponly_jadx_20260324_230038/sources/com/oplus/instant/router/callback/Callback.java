package com.oplus.instant.router.callback;

import android.database.Cursor;
import defpackage.ac7;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class Callback {

    /* JADX INFO: compiled from: SearchBox */
    public static class Response {
        public static final int DENIED = -8;
        public static final int FAIL = -4;
        public static final int SUCCESS = 1;
        public static final int UPDATE_CANCEL = -11;
        public static final String UPDATE_CANCEL_MESSAGE = "platform need update but user canceled";
        public static final int UPDATE_ERROR = -10;
        public static final String UPDATE_ERROR_MESSAGE = "platform need update but error occurred";
        public static final int UPDATE_SUCCESS = 10;
        public static final String UPDATE_SUCCESS_MESSAGE = "platform update success, please call request again";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7565a;
        public String b;

        public int getCode() {
            return this.f7565a;
        }

        public String getMsg() {
            return this.b;
        }

        public void setCode(int i) {
            this.f7565a = i;
        }

        public void setMsg(String str) {
            this.b = str;
        }

        public String toString() {
            return this.f7565a + "#" + this.b;
        }
    }

    public abstract void onResponse(Response response);

    public void onResponse(Map<String, Object> map, Cursor cursor) {
        String str;
        Object obj;
        Map<String, Object> mapA = ac7.a(cursor);
        Response response = new Response();
        if (mapA == null || (obj = mapA.get("code")) == null) {
            response.f7565a = -1;
            str = "fail to get response";
        } else {
            response.f7565a = Long.valueOf(((Long) obj).longValue()).intValue();
            str = (String) mapA.get("msg");
        }
        response.b = str;
        onResponse(response);
    }
}
