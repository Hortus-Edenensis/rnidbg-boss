package a.a.a.a.a.a;

import a.a.a.a.a.a.k.b;
import android.content.Context;
import android.net.Network;
import android.util.Base64;
import android.util.Log;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a.a.a.a.a.a.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e config) {
        super(config);
        Intrinsics.checkNotNullParameter(config, "config");
    }

    @Override // a.a.a.a.a.a.a
    public String a() {
        return "2";
    }

    @Override // a.a.a.a.a.a.a
    public i a(Context context, Network network) throws InterruptedException {
        String strSubstring;
        String string;
        String strA;
        String strA2;
        Intrinsics.checkNotNullParameter(context, "context");
        byte[] bArr = a.a.a.a.a.a.k.a.f1061a;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM);
            keyPairGenerator.initialize(1024, new SecureRandom());
            strSubstring = Base64.encodeToString(keyPairGenerator.generateKeyPair().getPrivate().getEncoded(), 0).substring(0, 16);
        } catch (NoSuchAlgorithmException unused) {
            strSubstring = "";
        }
        StringBuilder sb = new StringBuilder("https://id6.me/gw/preuniq.do");
        sb.append(Constants.STRING_VALUE_UNSET);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", "9386206798");
            jSONObject.put("clientType", "Android-30100");
            jSONObject.put("format", BodyData.TYPE_JSON);
            jSONObject.put("version", "v1.5");
            byte[] bytes = strSubstring.getBytes();
            byte[] bArr2 = a.a.a.a.a.a.k.a.f1061a;
            try {
                RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5se07mkN71qsSJHjZ2Z0+Z+4LlLvf2sz7Md38VAa3EmAOvI7vZp3hbAxicL724ylcmisTPtZQhT/9C+25AELqy9PN9JmzKpwoVTUoJvxG4BoyT49+gGVl6s6zo1byNoHUzTfkmRfmC9MC53HvG8GwKP5xtcdptFjAIcgIR7oAWQIDAQAB", 0)));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
                cipher.init(1, rSAPublicKey);
                strA = a.a.a.a.a.a.k.a.a(cipher.doFinal(bytes));
            } catch (Exception unused2) {
                strA = null;
            }
            jSONObject.put("paramKey", strA);
            String strA3 = a.a.a.a.a.a.k.a.a(true, ("timeStamp=" + System.currentTimeMillis()).getBytes(), strSubstring);
            jSONObject.put("paramStr", strA3);
            String[] strArr = {"9386206798", "Android-30100", BodyData.TYPE_JSON, strA, strA3, "v1.5"};
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb2.append(strArr[i]);
            }
            String string2 = sb2.toString();
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec("tgIBkg304BUpjGHLSq1wYYb0Xs77pMIm".getBytes(StandardCharsets.UTF_8), "HmacSHA1");
                Mac mac = Mac.getInstance("HmacSHA1");
                mac.init(secretKeySpec);
                strA2 = a.a.a.a.a.a.k.a.a(mac.doFinal(string2.getBytes(StandardCharsets.UTF_8)));
            } catch (InvalidKeyException | NoSuchAlgorithmException e) {
                e.printStackTrace();
                strA2 = null;
            }
            jSONObject.put("sign", strA2);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string3 = jSONObject.getString(next);
                sb.append(next);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(string3);
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.deleteCharAt(sb.length() - 1);
            string = sb.toString();
        } catch (Exception e2) {
            Log.d("RequestBodyUtils", e2.getMessage());
            string = null;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        a.a.a.a.a.a.k.b.a(network, string, null, new a(strSubstring, context, countDownLatch));
        countDownLatch.await(5000L, TimeUnit.MICROSECONDS);
        return this.b;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements b.a {
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ CountDownLatch d;

        public a(String str, Context context, CountDownLatch countDownLatch) {
            this.b = str;
            this.c = context;
            this.d = countDownLatch;
        }

        @Override // a.a.a.a.a.a.k.b.a
        public void a() {
            c.this.b.b = "51128";
            this.d.countDown();
        }

        @Override // a.a.a.a.a.a.k.b.a
        public void a(String response) {
            String strValueOf;
            Intrinsics.checkNotNullParameter(response, "response");
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject(response);
                strValueOf = String.valueOf(jSONObject.getInt("result"));
                if (Intrinsics.areEqual("0", strValueOf)) {
                    String string = jSONObject.getString("data");
                    byte[] bArr = a.a.a.a.a.a.k.a.f1061a;
                    if (string.length() % 2 != 0) {
                        string = "0" + string;
                    }
                    int length = string.length() / 2;
                    byte[] bArr2 = new byte[length];
                    for (int i = 0; i < length; i++) {
                        int i2 = i * 2;
                        bArr2[i] = (byte) Integer.parseInt(string.substring(i2, i2 + 2), 16);
                    }
                    String string2 = new JSONObject(a.a.a.a.a.a.k.a.a(false, bArr2, this.b)).getString("accessCode");
                    Intrinsics.checkNotNullExpressionValue(string2, "data.getString(\"accessCode\")");
                    str = string2;
                    strValueOf = "01128";
                }
            } catch (Exception unused) {
                strValueOf = "51128";
            }
            i iVar = c.this.b;
            iVar.f1060a = str;
            iVar.b = strValueOf;
            iVar.d = "2";
            iVar.c = "2";
            iVar.e = 0;
            iVar.g = System.currentTimeMillis();
            this.d.countDown();
        }
    }
}
