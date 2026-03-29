package org.apache.commons.codec.binary;

import com.baidu.mapapi.http.HttpClient;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Base64 implements BinaryEncoder, BinaryDecoder {
    static final int BASELENGTH = 255;
    static final int CHUNK_SIZE = 76;
    static final int EIGHTBIT = 8;
    static final int FOURBYTE = 4;
    static final int LOOKUPLENGTH = 64;
    static final byte PAD = 61;
    static final int SIGN = -128;
    static final int SIXTEENBIT = 16;
    static final int TWENTYFOURBITGROUP = 24;
    static final byte[] CHUNK_SEPARATOR = HttpClient.NEWLINE.getBytes();
    private static byte[] base64Alphabet = new byte[255];
    private static byte[] lookUpBase64Alphabet = new byte[64];

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 255; i4++) {
            base64Alphabet[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            base64Alphabet[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            base64Alphabet[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            base64Alphabet[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = base64Alphabet;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i8 = 0; i8 <= 25; i8++) {
            lookUpBase64Alphabet[i8] = (byte) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            lookUpBase64Alphabet[i] = (byte) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            lookUpBase64Alphabet[i2] = (byte) (i3 + 48);
            i2++;
            i3++;
        }
        byte[] bArr2 = lookUpBase64Alphabet;
        bArr2[62] = 43;
        bArr2[63] = 47;
    }

    public static byte[] decodeBase64(byte[] bArr) {
        byte[] bArrDiscardNonBase64 = discardNonBase64(bArr);
        if (bArrDiscardNonBase64.length == 0) {
            return new byte[0];
        }
        int length = bArrDiscardNonBase64.length / 4;
        int length2 = bArrDiscardNonBase64.length;
        while (bArrDiscardNonBase64[length2 - 1] == 61) {
            length2--;
            if (length2 == 0) {
                return new byte[0];
            }
        }
        byte[] bArr2 = new byte[length2 - length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 4;
            byte b = bArrDiscardNonBase64[i3 + 2];
            byte b2 = bArrDiscardNonBase64[i3 + 3];
            byte[] bArr3 = base64Alphabet;
            byte b3 = bArr3[bArrDiscardNonBase64[i3]];
            byte b4 = bArr3[bArrDiscardNonBase64[i3 + 1]];
            if (b != 61 && b2 != 61) {
                byte b5 = bArr3[b];
                byte b6 = bArr3[b2];
                bArr2[i] = (byte) ((b3 << 2) | (b4 >> 4));
                bArr2[i + 1] = (byte) (((b4 & 15) << 4) | ((b5 >> 2) & 15));
                bArr2[i + 2] = (byte) ((b5 << 6) | b6);
            } else if (b == 61) {
                bArr2[i] = (byte) ((b4 >> 4) | (b3 << 2));
            } else if (b2 == 61) {
                byte b7 = bArr3[b];
                bArr2[i] = (byte) ((b3 << 2) | (b4 >> 4));
                bArr2[i + 1] = (byte) (((b4 & 15) << 4) | ((b7 >> 2) & 15));
            }
            i += 3;
        }
        return bArr2;
    }

    public static byte[] discardNonBase64(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (isBase64(bArr[i2])) {
                bArr2[i] = bArr[i2];
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    public static byte[] discardWhitespace(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (byte b : bArr) {
            if (b != 9 && b != 10 && b != 13 && b != 32) {
                bArr2[i] = b;
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static boolean isArrayByteBase64(byte[] bArr) {
        byte[] bArrDiscardWhitespace = discardWhitespace(bArr);
        if (bArrDiscardWhitespace.length == 0) {
            return true;
        }
        for (byte b : bArrDiscardWhitespace) {
            if (!isBase64(b)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBase64(byte b) {
        return b == 61 || base64Alphabet[b] != -1;
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        int iCeil;
        int length = bArr.length * 8;
        int i = length % 24;
        int i2 = length / 24;
        int length2 = i != 0 ? (i2 + 1) * 4 : i2 * 4;
        if (z) {
            byte[] bArr2 = CHUNK_SEPARATOR;
            iCeil = bArr2.length == 0 ? 0 : (int) Math.ceil(length2 / 76.0f);
            length2 += bArr2.length * iCeil;
        } else {
            iCeil = 0;
        }
        byte[] bArr3 = new byte[length2];
        int i3 = 0;
        int length3 = 0;
        int i4 = 0;
        int length4 = 76;
        while (i3 < i2) {
            int i5 = i3 * 3;
            byte b = bArr[i5];
            byte b2 = bArr[i5 + 1];
            byte b3 = bArr[i5 + 2];
            byte b4 = (byte) (b2 & 15);
            byte b5 = (byte) (b & 3);
            int i6 = b & ByteCompanionObject.MIN_VALUE;
            int i7 = b >> 2;
            if (i6 != 0) {
                i7 ^= 192;
            }
            byte b6 = (byte) i7;
            int i8 = b2 & ByteCompanionObject.MIN_VALUE;
            int i9 = b2 >> 4;
            if (i8 != 0) {
                i9 ^= 240;
            }
            byte b7 = (byte) i9;
            int i10 = b3 >> 6;
            if ((b3 & ByteCompanionObject.MIN_VALUE) != 0) {
                i10 ^= MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
            }
            byte[] bArr4 = lookUpBase64Alphabet;
            bArr3[length3] = bArr4[b6];
            bArr3[length3 + 1] = bArr4[(b5 << 4) | b7];
            bArr3[length3 + 2] = bArr4[(b4 << 2) | ((byte) i10)];
            bArr3[length3 + 3] = bArr4[b3 & Utf8.REPLACEMENT_BYTE];
            length3 += 4;
            if (z && length3 == length4) {
                byte[] bArr5 = CHUNK_SEPARATOR;
                System.arraycopy(bArr5, 0, bArr3, length3, bArr5.length);
                i4++;
                length4 = (bArr5.length * i4) + ((i4 + 1) * 76);
                length3 += bArr5.length;
            }
            i3++;
        }
        int i11 = i3 * 3;
        if (i == 8) {
            byte b8 = bArr[i11];
            byte b9 = (byte) (b8 & 3);
            int i12 = b8 & ByteCompanionObject.MIN_VALUE;
            int i13 = b8 >> 2;
            if (i12 != 0) {
                i13 ^= 192;
            }
            byte[] bArr6 = lookUpBase64Alphabet;
            bArr3[length3] = bArr6[(byte) i13];
            bArr3[length3 + 1] = bArr6[b9 << 4];
            bArr3[length3 + 2] = 61;
            bArr3[length3 + 3] = 61;
        } else if (i == 16) {
            byte b10 = bArr[i11];
            byte b11 = bArr[i11 + 1];
            byte b12 = (byte) (b11 & 15);
            byte b13 = (byte) (b10 & 3);
            int i14 = b10 & ByteCompanionObject.MIN_VALUE;
            int i15 = b10 >> 2;
            if (i14 != 0) {
                i15 ^= 192;
            }
            byte b14 = (byte) i15;
            int i16 = b11 & ByteCompanionObject.MIN_VALUE;
            int i17 = b11 >> 4;
            if (i16 != 0) {
                i17 ^= 240;
            }
            byte[] bArr7 = lookUpBase64Alphabet;
            bArr3[length3] = bArr7[b14];
            bArr3[length3 + 1] = bArr7[((byte) i17) | (b13 << 4)];
            bArr3[length3 + 2] = bArr7[b12 << 2];
            bArr3[length3 + 3] = 61;
        }
        if (z && i4 < iCeil) {
            byte[] bArr8 = CHUNK_SEPARATOR;
            System.arraycopy(bArr8, 0, bArr3, length2 - bArr8.length, bArr8.length);
        }
        return bArr3;
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        return decodeBase64(bArr);
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return encodeBase64(bArr, false);
    }
}
