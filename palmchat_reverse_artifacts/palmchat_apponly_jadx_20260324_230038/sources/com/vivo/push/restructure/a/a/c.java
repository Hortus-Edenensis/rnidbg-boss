package com.vivo.push.restructure.a.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.gdt.action.ActionUtils;
import com.vivo.push.util.aa;
import com.vivo.push.util.ag;
import com.vivo.push.util.t;
import com.vivo.push.util.z;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class c extends a<com.vivo.push.restructure.a.a> {
    private static final List<Integer> b = Arrays.asList(3);

    public c(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("CheckNode", aVar, iVar);
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        return a2(aVar);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static int a2(com.vivo.push.restructure.a.a aVar) {
        try {
        } catch (Exception e) {
            t.a("CheckNode", e);
        }
        if (!com.vivo.push.restructure.a.a().e().l().isAgreePrivacyStatement()) {
            t.d("CheckNode", " checkNeedReportByPrivacyStatement is false  ");
            return 2809;
        }
        Intent intentB = aVar.b();
        String strB = com.vivo.push.sdk.a.a().b();
        if (!TextUtils.isEmpty(strB) && strB.contains("CommandService")) {
            if (!(intentB != null && a(intentB) && a(intentB, aVar))) {
                t.a("CheckNode", " !checkIntentIsSecurity(intent)");
                return 2801;
            }
        }
        Context contextB = com.vivo.push.restructure.a.a().b();
        String packageName = contextB.getPackageName();
        String stringExtra = intentB.getStringExtra("command_type");
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
            int intExtra = intentB.getIntExtra(com.heytap.mcssdk.constant.b.y, -1);
            if (intExtra < 0) {
                intExtra = intentB.getIntExtra(ActionUtils.METHOD, -1);
            }
            if (b.contains(Integer.valueOf(intExtra)) && z.c(contextB, packageName) && !z.b(contextB)) {
                t.a("CheckNode", "METHOD_ON_MESSAGE is not support");
                return 2803;
            }
            String action = intentB.getAction();
            if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().e().a(contextB, action))) {
                t.d("CheckNode", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                intentB.setPackage(packageName);
                contextB.sendBroadcast(intentB);
                return 2802;
            }
            return 0;
        }
        t.a("CheckNode", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
        return 2801;
    }

    private static boolean a(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("security_avoid_pull");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    String strA = com.vivo.push.util.a.a(com.vivo.push.restructure.a.a().b()).a(stringExtra);
                    if ("com.vivo.pushservice".equals(strA)) {
                        return true;
                    }
                    t.a("CheckNode", "!decrypt.equals, so decrypt == ".concat(String.valueOf(strA)));
                    return false;
                } catch (Exception e) {
                    t.a("CheckNode", "checkIntentIsSecurity Exception: " + e.getMessage());
                    return false;
                }
            }
            t.a("CheckNode", "checkIntentIsSecurityTextUtils.isEmpty");
            return true;
        } catch (Exception unused) {
            t.a("CheckNode", "getStringExtra error");
            return true;
        }
    }

    private static boolean a(Intent intent, com.vivo.push.restructure.a.a aVar) {
        try {
            Context contextB = com.vivo.push.restructure.a.a().b();
            String strB = ag.b(contextB, "com.vivo.pushservice");
            t.d("CheckNode", " 配置的验签参数 = ".concat(String.valueOf(strB)));
            if (!TextUtils.equals(strB, "1")) {
                return true;
            }
            String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
            String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                if (com.vivo.push.f.b.a().a(contextB).a("com.vivo.pushservice".getBytes("UTF-8"), aa.a(stringExtra2), Base64.decode(stringExtra, 2))) {
                    t.d("CheckNode", " RSA验签通过  ");
                    return true;
                }
                StringBuilder sb = new StringBuilder(" 验签参数传入错误 securityContent = ");
                sb.append(stringExtra);
                sb.append(" publickKey= ");
                sb.append(stringExtra2);
                sb.append(" receivedMsg isempty? ");
                sb.append(aVar == null);
                sb.append(" receivedMsg isClickMsg? ");
                sb.append(aVar == null ? false : aVar.k());
                t.c("CheckNode", sb.toString());
                if (aVar != null && aVar.k() && (TextUtils.equals(stringExtra, "com.vivo.pushservice") || TextUtils.equals(stringExtra2, "com.vivo.pushservice"))) {
                    return true;
                }
                t.d("CheckNode", " RSA验签 不通过  ");
                return false;
            }
            t.a("CheckNode", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
            return false;
        } catch (Exception e) {
            t.a("CheckNode", "checkIntentIsSecurity Exception: " + e.getMessage());
            return true;
        }
    }
}
