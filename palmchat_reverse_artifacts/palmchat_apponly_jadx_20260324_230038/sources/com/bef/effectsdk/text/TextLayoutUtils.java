package com.bef.effectsdk.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.bef.effectsdk.text.data.BitmapType;
import com.bef.effectsdk.text.data.CharLayout;
import com.bef.effectsdk.text.data.TextBitmapResult;
import com.bef.effectsdk.text.data.TextLayoutParam;
import defpackage.lk1;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@lk1
public class TextLayoutUtils {
    private static final int FONT_SIZE_INCREMENT = 2;
    private static final int FONT_SIZE_INIT = 10;
    private static final int MAX_BITMAP_HEIGHT = 2048;
    private static final int MAX_BITMAP_WIDTH = 2048;

    /* JADX INFO: renamed from: com.bef.effectsdk.text.TextLayoutUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE;
        static final /* synthetic */ int[] $SwitchMap$com$bef$effectsdk$text$data$BitmapType;

        static {
            int[] iArr = new int[COLOR_TYPE.values().length];
            $SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE = iArr;
            try {
                iArr[COLOR_TYPE.COLOR_TYPE_ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE[COLOR_TYPE.COLOR_TYPE_RGBA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[BitmapType.values().length];
            $SwitchMap$com$bef$effectsdk$text$data$BitmapType = iArr2;
            try {
                iArr2[BitmapType.TEXT_BITMAP_SHAKE_ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bef$effectsdk$text$data$BitmapType[BitmapType.TEXT_BITMAP_NEON_ALPHA.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum COLOR_TYPE {
        COLOR_TYPE_RGBA,
        COLOR_TYPE_ALPHA
    }

    @lk1
    public static TextBitmapResult generateBitmapAtlasAlphaUTF32(int[] iArr, TextLayoutParam textLayoutParam) {
        if (iArr == null || iArr.length < 1) {
            return null;
        }
        return generateBitmapAtlasUTF8(new String(iArr, 0, iArr.length), textLayoutParam, COLOR_TYPE.COLOR_TYPE_ALPHA);
    }

    @lk1
    public static TextBitmapResult generateBitmapAtlasAlphaUTF8(String str, TextLayoutParam textLayoutParam) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return generateBitmapAtlasUTF8(str, textLayoutParam, COLOR_TYPE.COLOR_TYPE_ALPHA);
    }

    @lk1
    public static TextBitmapResult generateBitmapAtlasRGBAUTF32(int[] iArr, TextLayoutParam textLayoutParam) {
        if (iArr == null || iArr.length < 1) {
            return null;
        }
        return generateBitmapAtlasUTF8(new String(iArr, 0, iArr.length), textLayoutParam, COLOR_TYPE.COLOR_TYPE_RGBA);
    }

    @lk1
    public static TextBitmapResult generateBitmapAtlasRGBAUTF8(String str, TextLayoutParam textLayoutParam) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return generateBitmapAtlasUTF8(str, textLayoutParam, COLOR_TYPE.COLOR_TYPE_RGBA);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b3, code lost:
    
        r26 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TextBitmapResult generateBitmapAtlasUTF8(String str, TextLayoutParam textLayoutParam, COLOR_TYPE color_type) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        ArrayList arrayList;
        TextPaint textPaint;
        ArrayList<Rect> arrayList2;
        int i5;
        Bitmap bitmapCreateBitmap;
        ArrayList arrayList3;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        ArrayList arrayList4;
        int i13;
        ArrayList arrayList5;
        String str2 = str;
        if (str.isEmpty()) {
            return null;
        }
        Typeface fromSystem = Typeface.DEFAULT;
        String str3 = textLayoutParam.familyName;
        if (str3 != null && !str3.isEmpty()) {
            String str4 = textLayoutParam.fontPath;
            fromSystem = (str4 == null || str4.isEmpty()) ? FontCache.getFromSystem(textLayoutParam.familyName, textLayoutParam.fontStyle) : FontCache.getFromFile(textLayoutParam.fontPath, textLayoutParam.familyName);
        }
        int i14 = textLayoutParam.textColor;
        int i15 = textLayoutParam.backColor;
        int i16 = textLayoutParam.shadowColor;
        if (AnonymousClass1.$SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE[color_type.ordinal()] != 1) {
            i = ((i14 & 255) << 24) + ((i14 >> 8) & 16777215);
            i2 = ((i15 & 255) << 24) + ((i15 >> 8) & 16777215);
            i3 = ((i16 & 255) << 24) + ((i16 >> 8) & 16777215);
        } else {
            i = (i14 & 255) << 24;
            i2 = (i15 & 255) << 24;
            i3 = (i16 & 255) << 24;
        }
        Paint.Style style = Paint.Style.FILL;
        int i17 = textLayoutParam.paintStyle;
        if (i17 == 0) {
            f = 0.0f;
        } else if (i17 == 1) {
            style = Paint.Style.STROKE;
            f = textLayoutParam.strokeWidth;
        } else if (i17 == 2) {
            style = Paint.Style.FILL_AND_STROKE;
            f = textLayoutParam.strokeWidth;
        }
        TextPaint textPaint2 = new TextPaint(1);
        if (fromSystem != null) {
            textPaint2.setTypeface(fromSystem);
        }
        textPaint2.setColor(i);
        textPaint2.setStyle(style);
        textPaint2.setStrokeWidth(f);
        textPaint2.setTextSize(textLayoutParam.fontSize);
        textPaint2.setShadowLayer(textLayoutParam.shadowRadius, textLayoutParam.shadowDx, textLayoutParam.shadowDy, i3);
        int i18 = textLayoutParam.lineWidth;
        if (i18 > 2048 || i18 == 0) {
            i18 = 2048;
        }
        TextBitmapResult textBitmapResult = new TextBitmapResult();
        textBitmapResult.channel = 4;
        textBitmapResult.lineCount = 0;
        textBitmapResult.type = 1;
        ArrayList arrayList6 = new ArrayList();
        HashMap map = new HashMap();
        ArrayList arrayList7 = new ArrayList();
        float fAbs = Math.abs(textLayoutParam.shadowDx) + (textLayoutParam.shadowRadius / 2.0f);
        float fAbs2 = Math.abs(textLayoutParam.shadowDy);
        float f3 = textLayoutParam.shadowRadius;
        float f4 = fAbs2 + (f3 / 2.0f);
        float f5 = textLayoutParam.letterSpacing;
        if (f5 <= 0.0f) {
            f5 = 0.0f;
        }
        int i19 = (int) f5;
        float f6 = textLayoutParam.lineSpacingAdd;
        if (f6 <= 0.0f) {
            f6 = 0.0f;
        }
        int i20 = (int) f6;
        int iMax = ((int) Math.max((-textLayoutParam.shadowDx) + (f3 / 2.0f), 0.0f)) + i19 + 1;
        int iMax2 = ((int) (Math.max((-textLayoutParam.shadowDy) + (textLayoutParam.shadowRadius / 2.0f), 0.0f) + textLayoutParam.fontSize)) + i20 + 1;
        int i21 = i2;
        int i22 = 0;
        int i23 = 0;
        while (true) {
            if (i23 >= str.length()) {
                i4 = i18;
                arrayList = arrayList6;
                textPaint = textPaint2;
                arrayList2 = arrayList7;
                break;
            }
            CharLayout charLayout = new CharLayout();
            ArrayList arrayList8 = arrayList6;
            charLayout.charCode = 0;
            charLayout.isEmoji = false;
            int i24 = i22 + 1;
            charLayout.charId = i22;
            short s = 1;
            while (true) {
                arrayList3 = arrayList7;
                int i25 = s + i23;
                i6 = i20;
                int i26 = i25 + 1;
                if (str.length() <= i26) {
                    f2 = f4;
                    break;
                }
                String strSubstring = str2.substring(i25 - 1, i25);
                String strSubstring2 = str2.substring(i25, i26);
                f2 = f4;
                if (strSubstring.compareTo("\ud800") >= 0 && strSubstring.compareTo("\udbff") <= 0 && strSubstring2.compareTo("\udc00") >= 0 && strSubstring2.compareTo("\udfff") <= 0) {
                    charLayout.isEmoji = true;
                    s = (short) (s + 1);
                    if (str.length() < i23 + 3) {
                        break;
                    }
                }
                int i27 = i23 + s;
                int i28 = i27 + 1;
                i7 = iMax2;
                String strSubstring3 = str2.substring(i27, i28);
                String strSubstring4 = str2.substring(i28, i27 + 2);
                if (strSubstring3.compareTo("\u200d") != 0 || strSubstring4.compareTo("\ud800") < 0 || strSubstring4.compareTo("\udbff") > 0) {
                    break;
                }
                s = (short) (s + 2);
                arrayList7 = arrayList3;
                i20 = i6;
                iMax2 = i7;
                f4 = f2;
            }
            if (!charLayout.isEmoji) {
                byte[] bytes = str2.substring(i23, i23 + s).getBytes();
                charLayout.charCode = 0;
                for (int i29 = 0; i29 < bytes.length; i29++) {
                    charLayout.charCode += (bytes[i29] & UByte.MAX_VALUE) << (((bytes.length - i29) - 1) * 8);
                }
            }
            CharLayout charLayout2 = (CharLayout) map.get(Integer.valueOf(charLayout.charCode));
            if (charLayout2 == null || charLayout.isEmoji) {
                Rect rect = new Rect();
                int i30 = i23 + s;
                textPaint2.getTextBounds(str2, i23, i30, rect);
                rect.left = (int) (rect.left + Math.min(textLayoutParam.shadowDx - (textLayoutParam.shadowRadius / 2.0f), 0.0f));
                rect.right = (int) (rect.right + Math.max(textLayoutParam.shadowDx + (textLayoutParam.shadowRadius / 2.0f), 0.0f));
                rect.bottom = (int) (rect.bottom + Math.max(textLayoutParam.shadowDy + (textLayoutParam.shadowRadius / 2.0f), 0.0f));
                rect.top = (int) (rect.top + Math.min(textLayoutParam.shadowDy - (textLayoutParam.shadowRadius / 2.0f), 0.0f));
                float fMeasureText = textPaint2.measureText(str2, i23, i30);
                charLayout.advance = fMeasureText;
                float f7 = i19;
                int i31 = iMax;
                if (iMax + fMeasureText + fAbs + f7 + 1.0f >= i18) {
                    int iMax3 = ((int) Math.max((-textLayoutParam.shadowDx) + (textLayoutParam.shadowRadius / 2.0f), 0.0f)) + i19 + 1;
                    i8 = i19;
                    i9 = i6;
                    textPaint = textPaint2;
                    int i32 = (int) (i7 + textLayoutParam.fontSize + f2 + i9 + 1.0f);
                    if (i32 >= 4194304 / i18) {
                        i4 = i18;
                        iMax2 = i32;
                        arrayList = arrayList8;
                        arrayList2 = arrayList3;
                        break;
                    }
                    i10 = i32;
                    i11 = iMax3;
                } else {
                    i8 = i19;
                    i9 = i6;
                    i10 = i7;
                    textPaint = textPaint2;
                    i11 = i31;
                }
                arrayList3.add(new Rect(i23, i30, i11, i10));
                charLayout.baseline = i10;
                float f8 = i11;
                charLayout.origin = f8;
                i12 = i9;
                charLayout.pos_left = rect.left;
                arrayList4 = arrayList3;
                charLayout.pos_top = rect.top;
                i13 = i18;
                charLayout.pos_right = rect.right;
                charLayout.pos_bottom = rect.bottom;
                charLayout.left = r10 + i11;
                charLayout.top = r0 + i10;
                charLayout.right = r7 + i11;
                charLayout.bottom = r2 + i10;
                map.put(Integer.valueOf(charLayout.charCode), charLayout);
                iMax = (int) (f8 + fMeasureText + fAbs + f7 + 1.0f);
                iMax2 = i10;
                arrayList5 = arrayList8;
            } else {
                charLayout.pos_left = charLayout2.pos_left;
                charLayout.pos_top = charLayout2.pos_top;
                charLayout.pos_right = charLayout2.pos_right;
                charLayout.pos_bottom = charLayout2.pos_bottom;
                charLayout.left = charLayout2.left;
                charLayout.top = charLayout2.top;
                charLayout.right = charLayout2.right;
                charLayout.bottom = charLayout2.bottom;
                charLayout.baseline = charLayout2.baseline;
                charLayout.origin = charLayout2.origin;
                charLayout.advance = charLayout2.advance;
                i13 = i18;
                i8 = i19;
                arrayList5 = arrayList8;
                iMax2 = i7;
                arrayList4 = arrayList3;
                i12 = i6;
                textPaint = textPaint2;
            }
            arrayList5.add(charLayout);
            i23 += s;
            arrayList6 = arrayList5;
            i22 = i24;
            i20 = i12;
            textPaint2 = textPaint;
            arrayList7 = arrayList4;
            f4 = f2;
            i18 = i13;
            i19 = i8;
            str2 = str;
        }
        textBitmapResult.charLayouts = (CharLayout[]) arrayList.toArray(new CharLayout[0]);
        int i33 = iMax2 + ((int) textLayoutParam.fontSize);
        if (AnonymousClass1.$SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE[color_type.ordinal()] != 1) {
            i5 = i4;
            bitmapCreateBitmap = Bitmap.createBitmap(i5, i33, Bitmap.Config.ARGB_8888);
            textBitmapResult.channel = 4;
        } else {
            i5 = i4;
            bitmapCreateBitmap = Bitmap.createBitmap(i5, i33, Bitmap.Config.ALPHA_8);
            textBitmapResult.channel = 1;
        }
        if (bitmapCreateBitmap == null) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i21);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawRect(new Rect(0, 0, i5, i33), paint);
        for (Rect rect2 : arrayList2) {
            canvas.drawText(str.substring(rect2.left, rect2.top), rect2.right, rect2.bottom, textPaint);
        }
        textBitmapResult.bitmap = bitmapCreateBitmap;
        int i34 = 0;
        while (true) {
            CharLayout[] charLayoutArr = textBitmapResult.charLayouts;
            if (i34 >= charLayoutArr.length) {
                canvas.setBitmap(null);
                return textBitmapResult;
            }
            CharLayout charLayout3 = charLayoutArr[i34];
            float f9 = i33;
            charLayout3.bottom /= f9;
            charLayout3.top /= f9;
            float f10 = i5;
            charLayout3.left /= f10;
            charLayout3.right /= f10;
            i34++;
        }
    }

    @lk1
    public static TextBitmapResult generateBitmapNeonAlphaUTF32(int[] iArr, TextLayoutParam textLayoutParam) {
        if (iArr == null || iArr.length < 1) {
            return null;
        }
        return generateBitmapNeonAlphaUTF8(new String(iArr, 0, iArr.length), textLayoutParam);
    }

    @lk1
    public static TextBitmapResult generateBitmapNeonAlphaUTF8(String str, TextLayoutParam textLayoutParam) {
        int i = AnonymousClass1.$SwitchMap$com$bef$effectsdk$text$data$BitmapType[BitmapType.valueOf(textLayoutParam.bitmapType).ordinal()];
        if (i == 1) {
            return generateTextAutoSizedShakeBitmap(str, textLayoutParam);
        }
        if (i != 2) {
            return null;
        }
        return generateTextAutoSizedNeonBitmap(str, textLayoutParam);
    }

    @lk1
    public static TextBitmapResult generateBitmapNormalAlphaUTF32(int[] iArr, TextLayoutParam textLayoutParam) {
        if (iArr == null || iArr.length < 1) {
            return null;
        }
        return generateBitmapNormalUTF8(new String(iArr, 0, iArr.length), textLayoutParam, COLOR_TYPE.COLOR_TYPE_ALPHA);
    }

    @lk1
    public static TextBitmapResult generateBitmapNormalAlphaUTF8(String str, TextLayoutParam textLayoutParam) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return generateBitmapNormalUTF8(str, textLayoutParam, COLOR_TYPE.COLOR_TYPE_ALPHA);
    }

    @lk1
    public static TextBitmapResult generateBitmapNormalRGBAUTF32(int[] iArr, TextLayoutParam textLayoutParam) {
        if (iArr == null || iArr.length < 1) {
            return null;
        }
        return generateBitmapNormalUTF8(new String(iArr, 0, iArr.length), textLayoutParam, COLOR_TYPE.COLOR_TYPE_RGBA);
    }

    @lk1
    public static TextBitmapResult generateBitmapNormalRGBAUTF8(String str, TextLayoutParam textLayoutParam) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return generateBitmapNormalUTF8(str, textLayoutParam, COLOR_TYPE.COLOR_TYPE_RGBA);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0199 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TextBitmapResult generateBitmapNormalUTF8(String str, TextLayoutParam textLayoutParam, COLOR_TYPE color_type) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        boolean z;
        int i5;
        TextUtils.TruncateAt truncateAt;
        int i6;
        Layout staticLayout;
        int i7;
        int i8;
        int iMin;
        int i9;
        int i10;
        Bitmap bitmapCreateBitmap;
        TextUtils.TruncateAt truncateAt2;
        if (str.isEmpty()) {
            return null;
        }
        Typeface fromSystem = Typeface.DEFAULT;
        String str2 = textLayoutParam.familyName;
        if (str2 != null && !str2.isEmpty()) {
            String str3 = textLayoutParam.fontPath;
            fromSystem = (str3 == null || str3.isEmpty()) ? FontCache.getFromSystem(textLayoutParam.familyName, textLayoutParam.fontStyle) : FontCache.getFromFile(textLayoutParam.fontPath, textLayoutParam.familyName);
        }
        int i11 = textLayoutParam.textColor;
        int i12 = textLayoutParam.backColor;
        int i13 = textLayoutParam.shadowColor;
        if (AnonymousClass1.$SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE[color_type.ordinal()] != 1) {
            i = ((i11 & 255) << 24) + ((i11 >> 8) & 16777215);
            i2 = ((i12 & 255) << 24) + ((i12 >> 8) & 16777215);
            i3 = ((i13 & 255) << 24) + ((i13 >> 8) & 16777215);
        } else {
            i = (i11 & 255) << 24;
            i2 = (i12 & 255) << 24;
            i3 = (i13 & 255) << 24;
        }
        int i14 = i2;
        Paint.Style style = Paint.Style.FILL;
        int i15 = textLayoutParam.paintStyle;
        float f2 = 0.0f;
        if (i15 == 0) {
            f = 0.0f;
        } else if (i15 == 1) {
            style = Paint.Style.STROKE;
            f = textLayoutParam.strokeWidth;
        } else if (i15 == 2) {
            style = Paint.Style.FILL_AND_STROKE;
            f = textLayoutParam.strokeWidth;
        }
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        int i16 = textLayoutParam.textAlign;
        if (i16 != 0) {
            if (i16 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i16 == 2) {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
        }
        int i17 = textLayoutParam.maxLine;
        int i18 = textLayoutParam.lineWidth;
        if (i18 == 0) {
            i17 = 1;
            i18 = 2048;
            i4 = 2048;
            z = false;
        } else {
            i4 = i18;
            z = true;
        }
        if (i17 == 1) {
            int i19 = textLayoutParam.lineBreakMode;
            if (i19 == 0 || i19 == 1) {
                truncateAt2 = TextUtils.TruncateAt.MARQUEE;
            } else if (i19 == 2) {
                truncateAt2 = TextUtils.TruncateAt.START;
            } else if (i19 == 3) {
                truncateAt2 = TextUtils.TruncateAt.MIDDLE;
            } else if (i19 != 4) {
                i5 = 2048;
                truncateAt = null;
                z = false;
            } else {
                truncateAt2 = TextUtils.TruncateAt.END;
            }
            truncateAt = truncateAt2;
            i5 = 2048;
            z = false;
        } else {
            i5 = 2048;
            truncateAt = null;
        }
        if (i4 > i5) {
            i4 = 2048;
        }
        if (i18 > i5) {
            i18 = 2048;
        }
        if (i17 == 0) {
            i17 = Integer.MAX_VALUE;
        }
        TextPaint textPaint = new TextPaint(1);
        if (fromSystem != null) {
            textPaint.setTypeface(fromSystem);
        }
        textPaint.setColor(i);
        textPaint.setStyle(style);
        textPaint.setStrokeWidth(f);
        textPaint.setTextSize(textLayoutParam.fontSize);
        textPaint.setShadowLayer(textLayoutParam.shadowRadius, textLayoutParam.shadowDx, textLayoutParam.shadowDy, i3);
        int i20 = Build.VERSION.SDK_INT;
        textPaint.setLetterSpacing(textLayoutParam.letterSpacing);
        BoringLayout.Metrics metricsIsBoring = BoringLayout.isBoring(str, textPaint);
        if (i17 != 1 || metricsIsBoring == null || truncateAt == TextUtils.TruncateAt.MARQUEE) {
            i6 = i17;
            int i21 = i18;
            if (i20 < 23) {
                i7 = i21;
                i8 = 0;
                staticLayout = new StaticLayout(str, 0, str.length(), textPaint, i21, alignment, textLayoutParam.lineSpacingMult, textLayoutParam.lineSpacingAdd, true, truncateAt, i4);
                iMin = Math.min(staticLayout.getLineCount(), i6);
                if (iMin != 0) {
                    return null;
                }
                if (z) {
                    i4 = i7;
                }
                int iMax = i4;
                int iMax2 = 0;
                int i22 = 0;
                int i23 = 0;
                while (true) {
                    if (i23 >= iMin) {
                        i9 = 2048;
                        break;
                    }
                    i9 = 2048;
                    if (Math.max(staticLayout.getLineBottom(i23), iMax2) > 2048) {
                        break;
                    }
                    iMax = Math.max((int) (staticLayout.getLineRight(i23) - staticLayout.getLineLeft(i23)), iMax);
                    iMax2 = Math.max(staticLayout.getLineBottom(i23), iMax2);
                    i22++;
                    i23++;
                }
                if (iMax > i9) {
                    iMax = 2048;
                }
                if (staticLayout.getLineBottom(i8) == 0) {
                    return null;
                }
                if (i22 == 0) {
                    i10 = 1;
                    iMax2 = 2048;
                } else {
                    i10 = i22;
                }
                if (i10 == staticLayout.getLineCount()) {
                    Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                    float fAbs = textLayoutParam.lineSpacingAdd + (textLayoutParam.lineSpacingMult * (fontMetrics.descent + Math.abs(fontMetrics.ascent) + fontMetrics.leading));
                    int i24 = i10 - 1;
                    float lineBottom = fAbs - (staticLayout.getLineBottom(i24) - staticLayout.getLineTop(i24));
                    if (lineBottom > 0.0f) {
                        f2 = lineBottom + 0.5f;
                        iMax2 = (int) (iMax2 + f2);
                    }
                }
                TextBitmapResult textBitmapResult = new TextBitmapResult();
                textBitmapResult.channel = 4;
                textBitmapResult.lineCount = i10;
                textBitmapResult.type = 1;
                textBitmapResult.charLayouts = new CharLayout[i10];
                for (int i25 = 0; i25 < i10; i25++) {
                    textBitmapResult.charLayouts[i25] = new CharLayout();
                    float f3 = iMax2;
                    textBitmapResult.charLayouts[i25].baseline = staticLayout.getLineBaseline(i25) / f3;
                    CharLayout charLayout = textBitmapResult.charLayouts[i25];
                    float f4 = iMax;
                    float lineLeft = staticLayout.getLineLeft(i25) / f4;
                    charLayout.left = lineLeft;
                    charLayout.pos_left = lineLeft;
                    CharLayout charLayout2 = textBitmapResult.charLayouts[i25];
                    float lineTop = staticLayout.getLineTop(i25) / f3;
                    charLayout2.top = lineTop;
                    charLayout2.pos_top = lineTop;
                    CharLayout charLayout3 = textBitmapResult.charLayouts[i25];
                    float lineRight = staticLayout.getLineRight(i25) / f4;
                    charLayout3.right = lineRight;
                    charLayout3.pos_right = lineRight;
                    if (i25 == i10 - 1) {
                        CharLayout charLayout4 = textBitmapResult.charLayouts[i25];
                        float lineBottom2 = (staticLayout.getLineBottom(i25) + f2) / f3;
                        charLayout4.bottom = lineBottom2;
                        charLayout4.pos_bottom = lineBottom2;
                    } else {
                        CharLayout charLayout5 = textBitmapResult.charLayouts[i25];
                        float lineBottom3 = staticLayout.getLineBottom(i25) / f3;
                        charLayout5.bottom = lineBottom3;
                        charLayout5.pos_bottom = lineBottom3;
                    }
                    textBitmapResult.charLayouts[i25].charCode = -2;
                }
                if (AnonymousClass1.$SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE[color_type.ordinal()] != 1) {
                    bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
                    textBitmapResult.channel = 4;
                } else {
                    bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ALPHA_8);
                    textBitmapResult.channel = 1;
                }
                bitmapCreateBitmap.setPremultiplied(true);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint();
                paint.setColor(i14);
                canvas.drawRect(new Rect(i8, i8, iMax, iMax2), paint);
                staticLayout.draw(canvas);
                textBitmapResult.bitmap = bitmapCreateBitmap;
                canvas.setBitmap(null);
                return textBitmapResult;
            }
            i7 = i21;
            staticLayout = StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, i21).setAlignment(alignment).setLineSpacing(textLayoutParam.lineSpacingAdd, textLayoutParam.lineSpacingMult).setIncludePad(true).setEllipsize(truncateAt).setEllipsizedWidth(i4).build();
        } else {
            i6 = i17;
            staticLayout = new BoringLayout(str, textPaint, i18, alignment, textLayoutParam.lineSpacingMult, textLayoutParam.lineSpacingAdd, metricsIsBoring, true, truncateAt, i4);
            i7 = i18;
        }
        i8 = 0;
        iMin = Math.min(staticLayout.getLineCount(), i6);
        if (iMin != 0) {
        }
    }

    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v5 */
    @lk1
    public static TextBitmapResult generateTextAutoSizedNeonBitmap(String str, TextLayoutParam textLayoutParam) {
        StaticLayout staticLayout;
        Paint.FontMetrics fontMetrics;
        float f;
        int[] iArr;
        Canvas canvas;
        float f2;
        float f3;
        float f4;
        String[] strArrSplitLyric = splitLyric(str);
        if (TextUtils.isEmpty(str) || textLayoutParam == null) {
            return null;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setAntiAlias(true);
        if (!TextUtils.isEmpty(textLayoutParam.familyName) && !TextUtils.isEmpty(textLayoutParam.fontPath)) {
            textPaint.setTypeface(FontCache.getFromFile(textLayoutParam.fontPath, textLayoutParam.familyName));
        }
        ?? r13 = 0;
        boolean z = textPaint.getFontMetrics().top < textPaint.getFontMetrics().ascent;
        TextBitmapResult textBitmapResult = new TextBitmapResult();
        textBitmapResult.channel = 1;
        textBitmapResult.lineCount = strArrSplitLyric.length;
        textBitmapResult.type = 0;
        textBitmapResult.charLayouts = new CharLayout[strArrSplitLyric.length];
        int[] iArr2 = new int[strArrSplitLyric.length];
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < strArrSplitLyric.length; i++) {
            String str2 = strArrSplitLyric[i];
            int i2 = 10;
            textPaint.setTextSize(10);
            for (float fMeasureText = textPaint.measureText(str2, 0, str2.length()); fMeasureText <= textLayoutParam.lineWidth; fMeasureText = textPaint.measureText(str2, 0, str2.length())) {
                i2 += 2;
                textPaint.setTextSize(i2);
            }
            int i3 = i2 - 2;
            iArr2[i] = i3;
            textPaint.setTextSize(i3);
            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
            if (z) {
                f3 = fontMetrics2.bottom;
                f4 = fontMetrics2.top;
            } else {
                f3 = fontMetrics2.descent;
                f4 = fontMetrics2.ascent;
            }
            f6 += f3 - f4;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(textLayoutParam.lineWidth, (int) f6, Bitmap.Config.ALPHA_8);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
        textBitmapResult.bitmap = bitmapCreateBitmap;
        int i4 = 0;
        float f7 = 0.0f;
        while (i4 < strArrSplitLyric.length) {
            String str3 = strArrSplitLyric[i4];
            textPaint.setTextSize(iArr2[i4]);
            Paint.FontMetrics fontMetrics3 = textPaint.getFontMetrics();
            if (Build.VERSION.SDK_INT >= 23) {
                staticLayout = StaticLayout.Builder.obtain(str3, r13, str3.length(), textPaint, canvas2.getWidth()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f5, 1.0f).setIncludePad(r13).build();
                fontMetrics = fontMetrics3;
                canvas = canvas2;
                f = f6;
                iArr = iArr2;
            } else {
                fontMetrics = fontMetrics3;
                f = f6;
                iArr = iArr2;
                staticLayout = new StaticLayout(str3, 0, str3.length(), textPaint, canvas2.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                canvas = canvas2;
            }
            staticLayout.draw(canvas);
            CharLayout charLayout = new CharLayout();
            if (z) {
                float f8 = fontMetrics.bottom;
                float f9 = fontMetrics.top;
                f2 = f8 - f9;
                charLayout.baseline = (f7 - f9) / f;
            } else {
                float f10 = fontMetrics.descent;
                float f11 = fontMetrics.ascent;
                f2 = f10 - f11;
                charLayout.baseline = (f7 - f11) / f;
            }
            charLayout.top = f7 / f;
            f7 += f2;
            charLayout.bottom = f7 / f;
            charLayout.left = 0.0f;
            charLayout.right = 1.0f;
            textBitmapResult.charLayouts[i4] = charLayout;
            canvas.translate(0.0f, f2);
            i4++;
            canvas2 = canvas;
            f6 = f;
            iArr2 = iArr;
            f5 = 0.0f;
            r13 = 0;
        }
        return textBitmapResult;
    }

    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    @lk1
    public static TextBitmapResult generateTextAutoSizedShakeBitmap(String str, TextLayoutParam textLayoutParam) {
        String[] strArr;
        StaticLayout staticLayout;
        float f;
        int i;
        int i2;
        float f2;
        ArrayList arrayList;
        TextPaint textPaint;
        Paint.FontMetrics fontMetrics;
        String[] strArrLyricShakeSplit = lyricShakeSplit(str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setAntiAlias(true);
        if (!TextUtils.isEmpty(textLayoutParam.familyName) && !TextUtils.isEmpty(textLayoutParam.fontPath)) {
            textPaint2.setTypeface(FontCache.getFromFile(textLayoutParam.fontPath, textLayoutParam.familyName));
        }
        textPaint2.setTextSize(textLayoutParam.fontSize);
        ?? r14 = 0;
        boolean z = textPaint2.getFontMetrics().top < textPaint2.getFontMetrics().ascent;
        Paint.FontMetrics fontMetrics2 = textPaint2.getFontMetrics();
        ArrayList arrayList2 = new ArrayList();
        float f3 = textLayoutParam.lineWidth;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int lineCount = 0;
        int i3 = 0;
        while (i3 < strArrLyricShakeSplit.length) {
            String str2 = strArrLyricShakeSplit[i3];
            if (Build.VERSION.SDK_INT >= 23) {
                staticLayout = StaticLayout.Builder.obtain(str2, r14, str2.length(), textPaint2, (int) f3).setAlignment(Layout.Alignment.ALIGN_OPPOSITE).setLineSpacing(f4, 1.0f).setIncludePad(r14).build();
                f = f5;
                i = lineCount;
                i2 = i3;
                f2 = f3;
                arrayList = arrayList2;
                textPaint = textPaint2;
                fontMetrics = fontMetrics2;
            } else {
                f = f5;
                i = lineCount;
                TextPaint textPaint3 = textPaint2;
                i2 = i3;
                f2 = f3;
                arrayList = arrayList2;
                textPaint = textPaint2;
                fontMetrics = fontMetrics2;
                staticLayout = new StaticLayout(str2, 0, str2.length(), textPaint3, (int) f3, Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0.0f, false);
            }
            lineCount = i + staticLayout.getLineCount();
            ArrayList arrayList3 = arrayList;
            arrayList3.add(staticLayout);
            float height = staticLayout.getHeight() + f;
            i3 = i2 + 1;
            arrayList2 = arrayList3;
            fontMetrics2 = fontMetrics;
            f3 = f2;
            textPaint2 = textPaint;
            f4 = 0.0f;
            r14 = 0;
            f5 = height;
        }
        float f6 = f5;
        int i4 = lineCount;
        float f7 = f3;
        ArrayList arrayList4 = arrayList2;
        Paint.FontMetrics fontMetrics3 = fontMetrics2;
        TextBitmapResult textBitmapResult = new TextBitmapResult();
        textBitmapResult.channel = 1;
        textBitmapResult.lineCount = i4;
        textBitmapResult.type = 0;
        textBitmapResult.charLayouts = new CharLayout[i4];
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(textLayoutParam.lineWidth, (int) f6, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        textBitmapResult.bitmap = bitmapCreateBitmap;
        int i5 = 0;
        float f8 = 0.0f;
        int i6 = 0;
        while (i5 < strArrLyricShakeSplit.length) {
            float height2 = ((StaticLayout) arrayList4.get(i5)).getHeight();
            float lineCount2 = height2 / ((StaticLayout) arrayList4.get(i5)).getLineCount();
            int i7 = 0;
            while (i7 < ((StaticLayout) arrayList4.get(i5)).getLineCount()) {
                CharLayout charLayout = new CharLayout();
                float lineWidth = ((StaticLayout) arrayList4.get(i5)).getLineWidth(i7);
                if (z) {
                    strArr = strArrLyricShakeSplit;
                    charLayout.baseline = (f8 - fontMetrics3.top) / f6;
                } else {
                    strArr = strArrLyricShakeSplit;
                    charLayout.baseline = (f8 - fontMetrics3.ascent) / f6;
                }
                charLayout.top = f8 / f6;
                f8 += lineCount2;
                float f9 = lineCount2;
                charLayout.bottom = (f8 - (Math.abs(fontMetrics3.bottom - fontMetrics3.descent) / 2.0f)) / f6;
                if (textLayoutParam.textAlign == 0) {
                    charLayout.left = 0.0f;
                    charLayout.right = (f7 - lineWidth) / f7;
                } else {
                    charLayout.left = (f7 - lineWidth) / f7;
                    charLayout.right = 1.0f;
                }
                textBitmapResult.charLayouts[i6] = charLayout;
                i6++;
                i7++;
                strArrLyricShakeSplit = strArr;
                lineCount2 = f9;
            }
            ((StaticLayout) arrayList4.get(i5)).draw(canvas);
            canvas.translate(0.0f, height2 * ((StaticLayout) arrayList4.get(i5)).getLineCount());
            i5++;
            strArrLyricShakeSplit = strArrLyricShakeSplit;
        }
        return textBitmapResult;
    }

    @lk1
    public static String[] lyricShakeSplit(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] strArrSplit = str.replace("\n", " ").replace(",", "").replace("\r", " ").split(" ");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < strArrSplit.length) {
            if (!strArrSplit[i].isEmpty()) {
                int length = sb.toString().length();
                if (length == 0) {
                    if (strArrSplit[i].length() < 10) {
                        sb.append(strArrSplit[i]);
                    } else if (strArrSplit[i].length() == 10) {
                        arrayList.add(strArrSplit[i]);
                    } else {
                        arrayList.add(strArrSplit[i].substring(0, 10));
                        boolean z = (strArrSplit[i].length() - 10) % 9 == 0;
                        int length2 = z ? (strArrSplit[i].length() - 10) / 9 : ((strArrSplit[i].length() - 10) / 9) + 1;
                        for (int i2 = 0; i2 < length2; i2++) {
                            if (i2 != 0) {
                                int i3 = ((i2 - 1) * 9) + 19;
                                if (i2 < length2 - 1) {
                                    sb.append("-");
                                    sb.append(strArrSplit[i].substring(i3, (i2 * 9) + 19));
                                    String string = sb.toString();
                                    arrayList.add(string);
                                    sb.delete(0, string.length());
                                } else if (z) {
                                    sb.append("-");
                                    sb.append(strArrSplit[i].substring(i3, (i2 * 9) + 19));
                                    String string2 = sb.toString();
                                    arrayList.add(string2);
                                    sb.delete(0, string2.length());
                                } else {
                                    int length3 = strArrSplit[i].length();
                                    sb.append("-");
                                    sb.append(strArrSplit[i].substring(i3, length3));
                                }
                            } else if (z) {
                                sb.append("-");
                                sb.append(strArrSplit[i].substring(10, 19));
                                String string3 = sb.toString();
                                arrayList.add(string3);
                                sb.delete(0, string3.length());
                            } else if (length2 == 1) {
                                int length4 = strArrSplit[i].length();
                                sb.append("-");
                                sb.append(strArrSplit[i].substring(10, length4));
                            } else {
                                sb.append("-");
                                sb.append(strArrSplit[i].substring(10, 19));
                                String string4 = sb.toString();
                                arrayList.add(string4);
                                sb.delete(0, string4.length());
                            }
                        }
                    }
                } else if (sb.toString().length() + strArrSplit[i].length() + 1 <= 10) {
                    sb.append(" ");
                    sb.append(strArrSplit[i]);
                } else {
                    arrayList.add(sb.toString());
                    sb.delete(0, length);
                    i--;
                }
            }
            i++;
        }
        if (sb.toString().length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @lk1
    public static String[] splitLyric(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] strArrSplit = str.replace("\n", " ").replace("\r", " ").split(" ");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            StringBuilder sb = new StringBuilder();
            int i3 = (i2 % 5) % 3 == 0 ? 6 : 10;
            int length = 0;
            while (i < strArrSplit.length && (strArrSplit[i].length() + length + 1 <= i3 || length <= 3)) {
                length += strArrSplit[i].length() + 1;
                int i4 = i + 1;
                sb.append(strArrSplit[i]);
                sb.append(" ");
                if (i4 == strArrSplit.length - 1 && strArrSplit[i4].length() < 3) {
                    sb.append(strArrSplit[i4]);
                }
                i = i4;
            }
            i2++;
            arrayList.add(sb.substring(0, sb.length() - 1));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
