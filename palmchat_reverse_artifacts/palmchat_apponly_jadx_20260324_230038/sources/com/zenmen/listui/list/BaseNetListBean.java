package com.zenmen.listui.list;

import androidx.annotation.Keep;
import com.zenmen.listui.list.BaseBean;
import defpackage.az2;
import java.lang.reflect.Type;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
@Keep
public class BaseNetListBean<T extends BaseBean> extends BaseNetBean<List<T>> {
    public static <T extends BaseBean> BaseNetListBean<T> createDefaultBean(JSONObject jSONObject, Type type) {
        BaseNetListBean<T> baseNetListBean;
        if (jSONObject != null) {
            try {
                baseNetListBean = (BaseNetListBean) az2.b(jSONObject.toString(), type);
            } catch (Exception e) {
                e.printStackTrace();
                baseNetListBean = null;
            }
        } else {
            baseNetListBean = null;
        }
        return baseNetListBean == null ? new BaseNetListBean<>() : baseNetListBean;
    }
}
