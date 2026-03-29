package com.unicom.online.account.kernel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.huawei.hms.framework.common.ContainerUtils;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.crypto.Cipher;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class p {
    public q b;
    private ExecutorService c = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScheduledExecutorService f11163a = Executors.newScheduledThreadPool(1);

    public static String a(Context context) {
        String str;
        String strA;
        String strA2;
        String string = "";
        try {
            String strC = ac.c();
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            String string2 = sb.toString();
            String strA3 = u.a();
            String packageName = context.getPackageName();
            String strG = ad.g();
            String strA4 = ad.a();
            String strSubstring = strA4.substring(0, 16);
            String strSubstring2 = strA4.substring(16, 32);
            if (u.f11171a) {
                str = "3.1";
                strA = h.a(k.a(strG.getBytes("Utf-8"), strSubstring.getBytes(), strSubstring2.getBytes()));
                strA2 = h.a(k.a(strA4.getBytes(), i.a("045C5DD4890819CEB16B0A66ED62B2FFA29B08F3CBF344A52A3A100ECB271BBEF3A9BC3743E753CA16EF238A1E55B72E95659A70425064D506B48F8EE3442786F7")));
            } else {
                str = "2.1";
                strA = ad.a(strG, strSubstring, strSubstring2);
                PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(h.b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVc1ecjpc5k7TkabF935iQONDZ0/E5XWPVv9FEsI59XTRW0+BCMK1MODRSWMvHFrPMh9ZilnRr7qXuAKCBEynQEghmpIVvMYhFu48FAI9bKfkI5lKuQK+tc4X0+zTbNrpedNoKXK4C7dDjTETBH6prwWE9j5WsAf0gbjUbIs3FxwIDAQAB")));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, publicKeyGeneratePublic);
                strA2 = h.a(cipher.doFinal(strA4.getBytes()));
            }
            String strA5 = u.d.equalsIgnoreCase("sm3") ? ad.a(context, context.getPackageName()) : ad.a(context, context.getPackageName(), u.d);
            String strB = ac.b();
            if (!TextUtils.isEmpty(strB)) {
                strB = "0";
            }
            String str2 = strA5 + "\n" + strC + "\n" + str + "\n" + BodyData.TYPE_JSON + "\n" + strB + "\n" + packageName + "\n" + strA + "\n" + strA3 + "\n" + strA2 + "\n" + string2;
            String strReplaceAll = str2.replaceAll("\n", "");
            String strC2 = u.f11171a ? ad.c(strReplaceAll) : ad.a(strReplaceAll);
            ab.a("unSignDebugInfo=".concat(str2));
            String strA6 = h.a(strA);
            String strA7 = h.a(strA2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("androidMd5", strA5);
            jSONObject.put("apiKey", strC);
            jSONObject.put("apiVersion", str);
            jSONObject.put("format", BodyData.TYPE_JSON);
            jSONObject.put("operator", strB);
            jSONObject.put("packName", packageName);
            jSONObject.put("privateIp", strA6);
            jSONObject.put("sdkVersion", strA3);
            jSONObject.put("secretKey", strA7);
            jSONObject.put("timeStamp", string2);
            jSONObject.put("sign", strC2);
            string = jSONObject.toString();
            ab.b("getPreCheckParam_CU_Oath: param ok  \n");
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return string;
        }
    }

    public final void a(final Context context, final int i, final Object obj, final r rVar) {
        synchronized (this) {
            try {
                this.c.submit(new Runnable() { // from class: com.unicom.online.account.kernel.p.4
                    /* JADX WARN: Removed duplicated region for block: B:21:0x008b A[Catch: Exception -> 0x009c, TryCatch #0 {Exception -> 0x009c, blocks: (B:2:0x0000, B:10:0x0014, B:13:0x0040, B:19:0x0085, B:21:0x008b, B:23:0x0096, B:18:0x0082, B:12:0x0021, B:11:0x001f, B:15:0x0074), top: B:28:0x0000, inners: #1 }] */
                    /* JADX WARN: Removed duplicated region for block: B:23:0x0096 A[Catch: Exception -> 0x009c, TRY_LEAVE, TryCatch #0 {Exception -> 0x009c, blocks: (B:2:0x0000, B:10:0x0014, B:13:0x0040, B:19:0x0085, B:21:0x008b, B:23:0x0096, B:18:0x0082, B:12:0x0021, B:11:0x001f, B:15:0x0074), top: B:28:0x0000, inners: #1 }] */
                    /* JADX WARN: Removed duplicated region for block: B:29:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void run() {
                        String strA;
                        try {
                            String str = "";
                            u.f11171a = false;
                            int i2 = i;
                            if (i2 != 2 && i2 != 3) {
                                if (i2 != 4 && i2 != 5) {
                                    rVar.a(410009, "410009no this type");
                                }
                                s sVar = new s();
                                Context context2 = context;
                                HashMap<String, String> map = new HashMap<>();
                                map.put("user-agent", "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1");
                                map.put(EventParams.KEY_PARAM_NETTYPE, "2");
                                map.put("os", "android");
                                map.put(HttpHeaders.ACCEPT, "*/*");
                                strA = sVar.a(context2, str, map, obj);
                                if (ac.h() == 1) {
                                    try {
                                        x.a().b();
                                        ab.b("\n  WIFI + 流量 \n call releaseNetwork() \n");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (TextUtils.isEmpty(strA)) {
                                    rVar.a(1, strA);
                                    return;
                                } else {
                                    rVar.a(410022, "网络请求响应为空");
                                    return;
                                }
                            }
                            u.f11171a = true;
                            str = ac.a() + z.a(p.a(context), ContainerUtils.FIELD_DELIMITER);
                            s sVar2 = new s();
                            Context context22 = context;
                            HashMap<String, String> map2 = new HashMap<>();
                            map2.put("user-agent", "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1");
                            map2.put(EventParams.KEY_PARAM_NETTYPE, "2");
                            map2.put("os", "android");
                            map2.put(HttpHeaders.ACCEPT, "*/*");
                            strA = sVar2.a(context22, str, map2, obj);
                            if (ac.h() == 1) {
                            }
                            if (TextUtils.isEmpty(strA)) {
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                rVar.a(410009, "410009" + e.getMessage());
            }
        }
    }

    public static /* synthetic */ void a(p pVar) {
        try {
            ScheduledExecutorService scheduledExecutorService = pVar.f11163a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                pVar.f11163a = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
