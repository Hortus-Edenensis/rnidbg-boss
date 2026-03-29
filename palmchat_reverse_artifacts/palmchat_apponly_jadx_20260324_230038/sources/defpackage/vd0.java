package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class vd0 extends b84 {

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static int f(CharSequence charSequence, int i, int i2) {
        a aVar;
        a aVarG;
        a aVarG2;
        a aVarG3 = g(charSequence, i);
        a aVar2 = a.UNCODABLE;
        if (aVarG3 != aVar2 && aVarG3 != (aVar = a.ONE_DIGIT)) {
            if (i2 == 99) {
                return i2;
            }
            if (i2 == 100) {
                a aVar3 = a.FNC_1;
                if (aVarG3 == aVar3 || (aVarG = g(charSequence, i + 2)) == aVar2 || aVarG == aVar) {
                    return i2;
                }
                if (aVarG == aVar3) {
                    return g(charSequence, i + 3) == a.TWO_DIGITS ? 99 : 100;
                }
                int i3 = i + 4;
                while (true) {
                    aVarG2 = g(charSequence, i3);
                    if (aVarG2 != a.TWO_DIGITS) {
                        break;
                    }
                    i3 += 2;
                }
                return aVarG2 == a.ONE_DIGIT ? 100 : 99;
            }
            if (aVarG3 == a.FNC_1) {
                aVarG3 = g(charSequence, i + 1);
            }
            if (aVarG3 == a.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }

    public static a g(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return a.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i);
        if (cCharAt == 241) {
            return a.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return a.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return a.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i2);
        return (cCharAt2 < '0' || cCharAt2 > '9') ? a.ONE_DIGIT : a.TWO_DIGITS;
    }

    @Override // defpackage.b84, defpackage.qo6
    public ht a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // defpackage.b84
    public boolean[] c(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int iB = 0;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt > '~') {
                switch (cCharAt) {
                    case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE /* 241 */:
                    case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                    case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE /* 243 */:
                    case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE /* 244 */:
                        break;
                    default:
                        throw new IllegalArgumentException("Bad character in input: " + cCharAt);
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i2 < length) {
            int iF = f(str, i2, i4);
            int iCharAt = 100;
            if (iF == i4) {
                switch (str.charAt(i2)) {
                    case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE /* 241 */:
                        iCharAt = 102;
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                        iCharAt = 97;
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE /* 243 */:
                        iCharAt = 96;
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE /* 244 */:
                        break;
                    default:
                        if (i4 == 100) {
                            iCharAt = str.charAt(i2) - ' ';
                        } else {
                            iCharAt = Integer.parseInt(str.substring(i2, i2 + 2));
                            i2++;
                        }
                        break;
                }
                i2++;
            } else {
                iCharAt = i4 == 0 ? iF == 100 ? 104 : 105 : iF;
                i4 = iF;
            }
            arrayList.add(ud0.f21192a[iCharAt]);
            i3 += iCharAt * i5;
            if (i2 != 0) {
                i5++;
            }
        }
        int[][] iArr = ud0.f21192a;
        arrayList.add(iArr[i3 % 103]);
        arrayList.add(iArr[106]);
        int i6 = 0;
        for (int[] iArr2 : arrayList) {
            for (int i7 : iArr2) {
                i6 += i7;
            }
        }
        boolean[] zArr = new boolean[i6];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            iB += b84.b(zArr, iB, (int[]) it.next(), true);
        }
        return zArr;
    }
}
