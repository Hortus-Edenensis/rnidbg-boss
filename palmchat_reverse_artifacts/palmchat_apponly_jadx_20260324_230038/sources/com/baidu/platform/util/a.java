package com.baidu.platform.util;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a implements ParamBuilder<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Map<String, String> f4270a;

    public a a(String str, String str2) {
        if (this.f4270a == null) {
            this.f4270a = new LinkedHashMap();
        }
        this.f4270a.put(str, str2);
        return this;
    }

    public String a() {
        Map<String, String> map = this.f4270a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = new String();
        int i = 0;
        for (String str2 : this.f4270a.keySet()) {
            String strEncodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.f4270a.get(str2));
            str = i == 0 ? str + str2 + ContainerUtils.KEY_VALUE_DELIMITER + strEncodeUrlParamsValue : str + ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + strEncodeUrlParamsValue;
            i++;
        }
        return str;
    }
}
