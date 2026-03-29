package com.baidu.mapauto.auth.verification;

import android.text.TextUtils;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.util.LogUtil;
import com.baidu.mapauto.auth.util.RSAUtil;
import java.security.PrivateKey;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends com.baidu.mapauto.auth.base.a<com.baidu.mapauto.auth.proxy.c> {
    public c(int i, AuthCore.AuthParam authParam, com.baidu.mapauto.auth.proxy.c cVar) {
        super(i, authParam, cVar);
    }

    @Override // com.baidu.mapauto.auth.base.c
    public final boolean a(int i, AuthCore.AuthParam authParam, Object obj) {
        LogUtil logUtil;
        String str;
        com.baidu.mapauto.auth.proxy.c cVar = (com.baidu.mapauto.auth.proxy.c) obj;
        LogUtil.getInstance().i("c", "开始检验设备");
        String strE = authParam.e();
        JSONObject jSONObject = cVar.f3926a;
        if (!TextUtils.equals(strE, jSONObject == null ? null : jSONObject.optString("service"))) {
            LogUtil.getInstance().e("c", "校验签名失败: 服务名不一致");
            return false;
        }
        String strC = authParam.c();
        JSONObject jSONObject2 = cVar.f3926a;
        if (!TextUtils.equals(strC, jSONObject2 == null ? null : jSONObject2.optString("channel"))) {
            LogUtil.getInstance().e("c", "校验签名失败: 渠道不一致");
            return false;
        }
        if (i == 0) {
            Object obj2 = authParam.get("private_key");
            String str2 = obj2 instanceof String ? (String) obj2 : null;
            if (TextUtils.isEmpty(str2)) {
                LogUtil.getInstance().e("c", "校验签名失败: 本地私钥为空");
                return false;
            }
            PrivateKey privateKeyFrom16 = RSAUtil.getPrivateKeyFrom16(str2);
            JSONObject jSONObject3 = cVar.f3926a;
            byte[] bArrDecryptHexStringBySec = RSAUtil.decryptHexStringBySec(jSONObject3 != null ? jSONObject3.optString("ak") : null, privateKeyFrom16);
            if (bArrDecryptHexStringBySec == null) {
                logUtil = LogUtil.getInstance();
                str = "校验签名失败: 解析 ak 失败";
            } else if (!new String(bArrDecryptHexStringBySec).equals(authParam.b())) {
                logUtil = LogUtil.getInstance();
                str = "校验签名失败: ak 不一致";
            }
            logUtil.e("c", str);
            return false;
        }
        LogUtil.getInstance().i("c", "设备校验通过");
        return true;
    }
}
