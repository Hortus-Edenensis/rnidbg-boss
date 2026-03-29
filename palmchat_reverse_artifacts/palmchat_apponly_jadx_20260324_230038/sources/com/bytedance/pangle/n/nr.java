package com.bytedance.pangle.n;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(api = 21)
public class nr {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public final byte[] nr;
        public final X509Certificate[][] u;

        public u(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.u = x509CertificateArr;
            this.nr = bArr;
        }
    }

    private static boolean u(int i) {
        if (i == 513 || i == 514 || i == 769 || i == 1057 || i == 1059 || i == 1061) {
            return true;
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return true;
            default:
                return false;
        }
    }

    public static X509Certificate[][] u(RandomAccessFile randomAccessFile, String str) throws s, SecurityException, IOException {
        mv mvVar = iz.u.get(str).get(1896449818);
        if (mvVar != null) {
            return u(randomAccessFile, mvVar, true).u;
        }
        throw new s("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
    }

    private static u u(RandomAccessFile randomAccessFile, mv mvVar, boolean z) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferU = iz.u(mvVar.u);
                int i = 0;
                while (byteBufferU.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(u(iz.u(byteBufferU), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i > 0) {
                    if (!arrayMap.isEmpty()) {
                        if (z) {
                            iz.u(arrayMap, randomAccessFile, mvVar);
                        }
                        return new u((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]), arrayMap.containsKey(3) ? iz.u((byte[]) arrayMap.get(3), randomAccessFile.length(), mvVar) : null);
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    private static X509Certificate[] u(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException, SecurityException {
        ByteBuffer byteBufferU = iz.u(byteBuffer);
        ByteBuffer byteBufferU2 = iz.u(byteBuffer);
        byte[] bArrNr = iz.nr(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrNr2 = null;
        byte[] bArrNr3 = null;
        int i = -1;
        int i2 = 0;
        while (byteBufferU2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer byteBufferU3 = iz.u(byteBufferU2);
                if (byteBufferU3.remaining() >= 8) {
                    int i3 = byteBufferU3.getInt();
                    arrayList.add(Integer.valueOf(i3));
                    if (u(i3) && (i == -1 || iz.u(i3, i) > 0)) {
                        bArrNr3 = iz.nr(byteBufferU3);
                        i = i3;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i2)), e);
            }
        }
        if (i == -1) {
            if (i2 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strFx = iz.fx(i);
        Pair<String, ? extends AlgorithmParameterSpec> pairB = iz.b(i);
        String str = (String) pairB.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairB.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(strFx).generatePublic(new X509EncodedKeySpec(bArrNr));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferU);
            if (signature.verify(bArrNr3)) {
                byteBufferU.clear();
                ByteBuffer byteBufferU4 = iz.u(byteBufferU);
                ArrayList arrayList2 = new ArrayList();
                int i4 = 0;
                while (byteBufferU4.hasRemaining()) {
                    i4++;
                    try {
                        ByteBuffer byteBufferU5 = iz.u(byteBufferU4);
                        if (byteBufferU5.remaining() >= 8) {
                            int i5 = byteBufferU5.getInt();
                            arrayList2.add(Integer.valueOf(i5));
                            if (i5 == i) {
                                bArrNr2 = iz.nr(byteBufferU5);
                            }
                        } else {
                            throw new IOException("Record too short");
                        }
                    } catch (IOException | BufferUnderflowException e2) {
                        throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e2);
                    }
                }
                if (arrayList.equals(arrayList2)) {
                    int iU = iz.u(i);
                    byte[] bArrPut = map.put(Integer.valueOf(iU), bArrNr2);
                    if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrNr2)) {
                        throw new SecurityException(iz.nr(iU) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    ByteBuffer byteBufferU6 = iz.u(byteBufferU);
                    ArrayList arrayList3 = new ArrayList();
                    int i6 = 0;
                    while (byteBufferU6.hasRemaining()) {
                        i6++;
                        byte[] bArrNr4 = iz.nr(byteBufferU6);
                        try {
                            arrayList3.add(new my((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrNr4)), bArrNr4));
                        } catch (CertificateException e3) {
                            throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i6)), e3);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (Arrays.equals(bArrNr, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                            u(iz.u(byteBufferU));
                            return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                        }
                        throw new SecurityException("Public key mismatch between certificate and signature record");
                    }
                    throw new SecurityException("No certificates listed");
                }
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            throw new SecurityException(str + " signature did not verify");
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }

    private static void u(ByteBuffer byteBuffer) throws IOException, SecurityException {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferU = iz.u(byteBuffer);
            if (byteBufferU.remaining() >= 4) {
                if (byteBufferU.getInt() == -1091571699) {
                    if (byteBufferU.remaining() >= 4) {
                        if (byteBufferU.getInt() == 3) {
                            throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                        }
                    } else {
                        throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + byteBufferU.remaining());
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferU.remaining());
            }
        }
    }
}
