package defpackage;

import com.cdadata.sdk.api.ZMDataSDKManager;
import com.cdadata.sdk.api.protobuf.event.CDASecurityInfoOuterClass;
import com.kuaishou.weapon.p0.t;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class y57 extends s57 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RSAPublicKey f22127a;

    @Override // defpackage.s57
    public byte[] a(byte[] bArr) throws Exception {
        byte[] bytes = t.k.getBytes();
        byte[] bArrO = e67.o(bArr);
        String strQ = e67.q(16);
        String strQ2 = e67.q(16);
        byte[] bArrT = e67.t(strQ, strQ2, bArrO);
        CDASecurityInfoOuterClass.CDASecurityInfo.Builder builderNewBuilder = CDASecurityInfoOuterClass.CDASecurityInfo.newBuilder();
        builderNewBuilder.setKey(strQ);
        builderNewBuilder.setIv(strQ2);
        byte[] bArrB = b(builderNewBuilder.build().toByteArray());
        byte[] bArrK = e67.k(bArrB.length);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bytes);
        arrayList.add(bArrK);
        arrayList.add(bArrB);
        arrayList.add(bArrT);
        return e67.m(arrayList);
    }

    public final byte[] b(byte[] bArr) throws Exception {
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(i57.b(ZMDataSDKManager.getInstance().zmConfigOptions.publicKey.getBytes("UTF-8"))));
            f22127a = rSAPublicKey;
            if (rSAPublicKey == null) {
                throw new Exception("加密公钥为空, 请设置");
            }
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, f22127a);
                return cipher.doFinal(bArr);
            } catch (InvalidKeyException unused) {
                throw new Exception("加密公钥非法,请检查");
            } catch (NoSuchAlgorithmException unused2) {
                throw new Exception("无此加密算法");
            } catch (BadPaddingException unused3) {
                throw new Exception("明文数据已损坏");
            } catch (IllegalBlockSizeException unused4) {
                throw new Exception("明文长度非法");
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
                return null;
            }
        } catch (NullPointerException unused5) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused6) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused7) {
            throw new Exception("公钥非法");
        }
    }
}
