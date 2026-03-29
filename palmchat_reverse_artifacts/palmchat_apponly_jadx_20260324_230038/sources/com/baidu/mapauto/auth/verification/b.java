package com.baidu.mapauto.auth.verification;

import android.text.TextUtils;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.util.LogUtil;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.kuaishou.weapon.p0.t;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends com.baidu.mapauto.auth.base.a<com.baidu.mapauto.auth.proxy.a> {
    public b(int i, AuthCore.AuthParam authParam, com.baidu.mapauto.auth.proxy.a aVar) {
        super(i, authParam, aVar);
    }

    @Override // com.baidu.mapauto.auth.base.c
    public final /* bridge */ /* synthetic */ boolean a(int i, AuthCore.AuthParam authParam, Object obj) {
        return a(authParam, (com.baidu.mapauto.auth.proxy.a) obj);
    }

    public final boolean a(AuthCore.AuthParam authParam, com.baidu.mapauto.auth.proxy.a aVar) {
        Object objOpt;
        LogUtil.getInstance().i(t.l, "开始检验 sign");
        JSONObject jSONObject = aVar.f3925a;
        boolean zVerify = false;
        if (jSONObject == null) {
            LogUtil.getInstance().e(t.l, "校验签名失败: 验签结果为空");
            return false;
        }
        Iterator<String> itKeys = jSONObject.keys();
        TreeSet<String> treeSet = new TreeSet();
        while (itKeys.hasNext()) {
            treeSet.add(itKeys.next());
        }
        StringBuilder sb = new StringBuilder();
        for (String str : treeSet) {
            if (!("pub_key".equals(str) || "sign".equals(str)) && (objOpt = jSONObject.opt(str)) != null) {
                if (objOpt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) objOpt;
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        String strOptString = jSONArray.optString(i);
                        if (!TextUtils.isEmpty(strOptString)) {
                            sb.append(strOptString);
                        }
                    }
                } else {
                    sb.append(objOpt);
                }
            }
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            LogUtil.getInstance().e(t.l, "校验签名失败: sign 原数据为空");
            return false;
        }
        try {
            JSONObject jSONObject2 = aVar.f3925a;
            PublicKey publicKeyFromPemString = RSAUtil.getPublicKeyFromPemString(jSONObject2 == null ? null : jSONObject2.optString("pub_key"), false);
            JSONObject jSONObject3 = aVar.f3925a;
            zVerify = RSAUtil.verify(string, publicKeyFromPemString, jSONObject3 == null ? null : jSONObject3.optString("sign"));
        } catch (Exception e) {
            LogUtil.getInstance().e(t.l, e.toString());
        }
        LogUtil logUtil = LogUtil.getInstance();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("校验签名结束: source: ");
        sb2.append(string);
        sb2.append(", pubKey: ");
        JSONObject jSONObject4 = aVar.f3925a;
        sb2.append(jSONObject4 == null ? null : jSONObject4.optString("pub_key"));
        sb2.append(", sign: ");
        JSONObject jSONObject5 = aVar.f3925a;
        sb2.append(jSONObject5 != null ? jSONObject5.optString("sign") : null);
        sb2.append(" => 校验结果: ");
        sb2.append(zVerify);
        logUtil.i(t.l, sb2.toString());
        return zVerify;
    }
}
