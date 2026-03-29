package a.a.b.a.d;

import android.util.Base64;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f1083a = new e();

    public final JSONObject a(JSONObject originData, String tag) throws BadPaddingException, JSONException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(originData, "originData");
        Intrinsics.checkNotNullParameter(tag, "tag");
        String string = originData.toString();
        Intrinsics.checkNotNullExpressionValue(string, "originData.toString()");
        Charset charset = Charsets.UTF_8;
        if (string == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = string.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String strValueOf = String.valueOf(System.currentTimeMillis());
        KeyGenerator keyGenerator = KeyGenerator.getInstance(EncryptUtils.AES_ENCRYPT_ALGORITHM);
        SecureRandom secureRandom = new SecureRandom();
        if (strValueOf == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes2 = strValueOf.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
        secureRandom.setSeed(bytes2);
        keyGenerator.init(128, secureRandom);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        Intrinsics.checkNotNullExpressionValue(secretKeyGenerateKey, "keyGenerator.generateKey()");
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKeyGenerateKey, new GCMParameterSpec(128, bArr));
        byte[] cipherData = cipher.doFinal(bytes);
        Intrinsics.checkNotNullExpressionValue(cipherData, "cipherData");
        String strEncodeToString = Base64.encodeToString(ArraysKt___ArraysJvmKt.plus(bArr, cipherData), 2);
        byte[] encoded = secretKeyGenerateKey.getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "aesKey.encoded");
        Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher2.init(1, KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDmKZL1TFWMfxggbo4qfXM5WsD0B3pUTjLCca/k/ESWqujQ2xTpESjUabHMEdEPnwmDtkXvIHJ14irPGulaXv6prpyPpt61dJqRYHvSmXr2x+HETNAIi0AHi+c/tE8LAKyHX2y4Zjv7iw48HidKv5+omug77Z/yTJqzhDvkkBteHQIDAQAB", 2))));
        byte[] bArrDoFinal = cipher2.doFinal(encoded);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(content)");
        String strEncodeToString2 = Base64.encodeToString(bArrDoFinal, 2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", strEncodeToString2);
        jSONObject.put("data", strEncodeToString);
        return jSONObject;
    }
}
