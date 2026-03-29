package com.zenmen.palmchat.framework.network;

import androidx.annotation.Keep;
import defpackage.az2;
import defpackage.go2;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class LXBaseNetBean<T> {
    public T data;
    public String errorMsg;
    public JSONObject originData;
    public String requestId;
    public int resultCode = -1008611;

    public static LXBaseNetBean create(go2 go2Var, JSONObject jSONObject) {
        Type[] actualTypeArguments;
        Type genericSuperclass = go2Var.getClass().getGenericSuperclass();
        LXBaseNetBean lXBaseNetBeanCreateBean = (!(genericSuperclass instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) == null || actualTypeArguments.length <= 0 || jSONObject == null) ? null : (LXBaseNetBean) az2.b(jSONObject.toString(), actualTypeArguments[0]);
        if (lXBaseNetBeanCreateBean == null) {
            lXBaseNetBeanCreateBean = createBean(jSONObject);
        }
        lXBaseNetBeanCreateBean.originData = jSONObject;
        return lXBaseNetBeanCreateBean;
    }

    private static LXBaseNetBean createBean(JSONObject jSONObject) {
        LXBaseNetBean lXBaseNetBean;
        if (jSONObject != null) {
            try {
                lXBaseNetBean = (LXBaseNetBean) az2.a(jSONObject.toString(), LXBaseNetBean.class);
            } catch (Exception e) {
                e.printStackTrace();
                lXBaseNetBean = null;
            }
        } else {
            lXBaseNetBean = null;
        }
        return lXBaseNetBean == null ? new LXBaseNetBean() : lXBaseNetBean;
    }

    public boolean isNetError() {
        return this.resultCode == -1008611;
    }

    public boolean isSuccess() {
        return this.resultCode == 0;
    }
}
