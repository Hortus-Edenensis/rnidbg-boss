package com.zenmen.palmchat.ad.model;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BaseRespBean<T> implements Serializable {
    private int code;
    private Object customData;
    private T data;
    private String message;
    private int realResponseCode;
    private Object tag;
    private String x_request_id;

    public int getCode() {
        return this.code;
    }

    public Object getCustomData() {
        return this.customData;
    }

    public T getData() {
        return this.data;
    }

    public String getMessage() {
        return TextUtils.isEmpty(this.message) ? "" : this.message;
    }

    public int getRealResponseCode() {
        return this.realResponseCode;
    }

    public Object getTag() {
        return this.tag;
    }

    public String getX_request_id() {
        return this.x_request_id;
    }

    public boolean hasCallback() {
        Object obj = this.tag;
        return obj != null && (obj instanceof Runnable);
    }

    public boolean hasData() {
        return this.data != null;
    }

    public boolean hasIntTag() {
        Object obj = this.tag;
        return obj != null && (obj instanceof Integer);
    }

    public boolean hasStringTag() {
        Object obj = this.tag;
        return obj != null && (obj instanceof String);
    }

    public boolean hasTag() {
        return this.tag != null;
    }

    public void runCallback() {
        if (hasCallback()) {
            ((Runnable) this.tag).run();
        }
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setCustomData(Object obj) {
        this.customData = obj;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRealResponseCode(int i) {
        this.realResponseCode = i;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void setX_request_id(String str) {
        this.x_request_id = str;
    }

    public boolean hasIntTag(int i) {
        Object obj = this.tag;
        return obj != null && (obj instanceof Integer) && i == ((Integer) obj).intValue();
    }
}
