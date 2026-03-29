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
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(api = 21)
public class fx {

    /* JADX INFO: renamed from: com.bytedance.pangle.n.fx$fx, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0195fx {
        public byte[] fx;
        public final nr nr;
        public final X509Certificate[] u;

        public C0195fx(X509Certificate[] x509CertificateArr, nr nrVar) {
            this.u = x509CertificateArr;
            this.nr = nrVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        public final List<Integer> nr;
        public final List<X509Certificate> u;

        public nr(List<X509Certificate> list, List<Integer> list2) {
            this.u = list;
            this.nr = list2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends Exception {
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

    public static C0195fx u(RandomAccessFile randomAccessFile, String str) throws s, IOException {
        mv mvVar = iz.u.get(str).get(-262969152);
        if (mvVar != null) {
            return u(randomAccessFile, mvVar, true);
        }
        throw new s("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
    }

    private static C0195fx u(RandomAccessFile randomAccessFile, mv mvVar, boolean z) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferU = iz.u(mvVar.u);
                int i = 0;
                C0195fx c0195fxU = null;
                while (byteBufferU.hasRemaining()) {
                    try {
                        c0195fxU = u(iz.u(byteBufferU), arrayMap, certificateFactory);
                        i++;
                    } catch (u unused) {
                    } catch (IOException e) {
                        e = e;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (SecurityException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (BufferUnderflowException e3) {
                        e = e3;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0 || c0195fxU == null) {
                    throw new SecurityException("No signers found");
                }
                if (i == 1) {
                    if (!arrayMap.isEmpty()) {
                        if (z) {
                            iz.u(arrayMap, randomAccessFile, mvVar);
                        }
                        if (arrayMap.containsKey(3)) {
                            c0195fxU.fx = iz.u((byte[]) arrayMap.get(3), randomAccessFile.length(), mvVar);
                        }
                        return c0195fxU;
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    private static C0195fx u(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException, SecurityException, u {
        ByteBuffer byteBufferU = iz.u(byteBuffer);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        ByteBuffer byteBufferU2 = iz.u(byteBuffer);
        byte[] bArrNr = iz.nr(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrNr2 = null;
        byte[] bArrNr3 = null;
        int i3 = -1;
        int i4 = 0;
        while (byteBufferU2.hasRemaining()) {
            i4++;
            try {
                ByteBuffer byteBufferU3 = iz.u(byteBufferU2);
                if (byteBufferU3.remaining() >= 8) {
                    int i5 = byteBufferU3.getInt();
                    arrayList.add(Integer.valueOf(i5));
                    if (u(i5) && (i3 == -1 || iz.u(i5, i3) > 0)) {
                        bArrNr3 = iz.nr(byteBufferU3);
                        i3 = i5;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i4)), e);
            }
        }
        if (i3 == -1) {
            if (i4 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strFx = iz.fx(i3);
        Pair<String, ? extends AlgorithmParameterSpec> pairB = iz.b(i3);
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
                int i6 = 0;
                while (byteBufferU4.hasRemaining()) {
                    i6++;
                    try {
                        ByteBuffer byteBufferU5 = iz.u(byteBufferU4);
                        if (byteBufferU5.remaining() >= 8) {
                            int i7 = byteBufferU5.getInt();
                            arrayList2.add(Integer.valueOf(i7));
                            if (i7 == i3) {
                                bArrNr2 = iz.nr(byteBufferU5);
                            }
                        } else {
                            throw new IOException("Record too short");
                        }
                    } catch (IOException | BufferUnderflowException e2) {
                        throw new IOException("Failed to parse digest record #".concat(String.valueOf(i6)), e2);
                    }
                }
                if (arrayList.equals(arrayList2)) {
                    int iU = iz.u(i3);
                    byte[] bArrPut = map.put(Integer.valueOf(iU), bArrNr2);
                    if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrNr2)) {
                        throw new SecurityException(iz.nr(iU) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    ByteBuffer byteBufferU6 = iz.u(byteBufferU);
                    ArrayList arrayList3 = new ArrayList();
                    int i8 = 0;
                    while (byteBufferU6.hasRemaining()) {
                        i8++;
                        byte[] bArrNr4 = iz.nr(byteBufferU6);
                        try {
                            arrayList3.add(new my((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrNr4)), bArrNr4));
                        } catch (CertificateException e3) {
                            throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i8)), e3);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (Arrays.equals(bArrNr, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                            if (byteBufferU.getInt() == i) {
                                if (byteBufferU.getInt() == i2) {
                                    return u(iz.u(byteBufferU), arrayList3, certificateFactory);
                                }
                                throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                            }
                            throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
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

    private static C0195fx u(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws IOException {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        nr nrVarU = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferU = iz.u(byteBuffer);
            if (byteBufferU.remaining() >= 4) {
                if (byteBufferU.getInt() == 1000370060) {
                    if (nrVarU == null) {
                        nrVarU = u(byteBufferU, certificateFactory);
                        try {
                            if (nrVarU.u.size() > 0) {
                                if (!Arrays.equals(nrVarU.u.get(r1.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                    throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                                }
                            } else {
                                continue;
                            }
                        } catch (CertificateEncodingException e) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                        }
                    } else {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferU.remaining());
            }
        }
        return new C0195fx(x509CertificateArr, nrVarU);
    }

    private static nr u(ByteBuffer byteBuffer, CertificateFactory certificateFactory) throws IOException, SecurityException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i2 = -1;
            my myVar = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                ByteBuffer byteBufferU = iz.u(byteBuffer);
                ByteBuffer byteBufferU2 = iz.u(byteBufferU);
                int i3 = byteBufferU.getInt();
                int i4 = byteBufferU.getInt();
                byte[] bArrNr = iz.nr(byteBufferU);
                if (myVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> pairB = iz.b(i2);
                    PublicKey publicKey = myVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) pairB.first);
                    signature.initVerify(publicKey);
                    Object obj = pairB.second;
                    if (obj != null) {
                        signature.setParameter((AlgorithmParameterSpec) obj);
                    }
                    signature.update(byteBufferU2);
                    if (!signature.verify(bArrNr)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + ((String) pairB.first) + " when verifying Proof-of-rotation record");
                    }
                }
                byteBufferU2.rewind();
                byte[] bArrNr2 = iz.nr(byteBufferU2);
                int i5 = byteBufferU2.getInt();
                if (myVar != null && i2 != i5) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i + " when verifying Proof-of-rotation record");
                }
                myVar = new my((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrNr2)), bArrNr2);
                if (!hashSet.contains(myVar)) {
                    hashSet.add(myVar);
                    arrayList.add(myVar);
                    arrayList2.add(Integer.valueOf(i3));
                    i2 = i4;
                } else {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i + ".  All signing certificates should be unique");
                }
            }
            return new nr(arrayList, arrayList2);
        } catch (IOException e) {
            e = e;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e2) {
            e = e2;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e4) {
            e = e4;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e6) {
            e = e6;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e7) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e7);
        }
    }
}
