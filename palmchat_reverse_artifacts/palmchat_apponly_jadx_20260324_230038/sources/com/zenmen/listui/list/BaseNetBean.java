package com.zenmen.listui.list;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.R$string;
import defpackage.az2;
import defpackage.lw3;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
@Keep
public class BaseNetBean<T> {
    public static int NET_ERR_CODE = -338484;
    public static int NET_ERR_NATIVE = -293848;
    public static int NET_ERR_NATIVE_TOO_FAST = -293847;
    public T data;
    public String errorMsg;
    public String requestId;
    public int resultCode = NET_ERR_CODE;
    public int extCode = 0;
    public String extMsg = "";

    public static BaseNetBean createBean(JSONObject jSONObject) {
        BaseNetBean baseNetBean;
        if (jSONObject != null) {
            try {
                baseNetBean = (BaseNetBean) az2.a(jSONObject.toString(), BaseNetBean.class);
            } catch (Exception e) {
                e.printStackTrace();
                baseNetBean = null;
            }
        } else {
            baseNetBean = null;
        }
        return baseNetBean == null ? new BaseNetBean() : baseNetBean;
    }

    public static BaseNetBean createDefault(JSONObject jSONObject, Type type) {
        BaseNetBean baseNetBean;
        if (jSONObject != null) {
            try {
                baseNetBean = (BaseNetBean) az2.b(jSONObject.toString(), type);
            } catch (Exception e) {
                e.printStackTrace();
                baseNetBean = null;
            }
        } else {
            baseNetBean = null;
        }
        return baseNetBean == null ? new BaseNetBean() : baseNetBean;
    }

    public String getErrMsg() {
        if (lw3.b(this.resultCode)) {
            return "";
        }
        int i = this.resultCode;
        return i == NET_ERR_NATIVE_TOO_FAST ? "操作太快啦！休息一下再试试" : (i == NET_ERR_CODE || TextUtils.isEmpty(this.errorMsg)) ? c.b().getString(R$string.toast_net_err) : this.errorMsg;
    }

    public boolean isNativeErr() {
        return NET_ERR_NATIVE == this.resultCode;
    }

    public boolean isNetErr() {
        return NET_ERR_CODE == this.resultCode;
    }

    public boolean isSuccess() {
        return this.resultCode == 0;
    }
}
