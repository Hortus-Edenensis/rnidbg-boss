package com.baidu.vi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import java.nio.IntBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class EnvDrawText {
    private static final String DEVICE_VIVOX3L = "vivo X3L";
    private static final int FONT_STYLE_BOLD = 1;
    private static final int FONT_STYLE_ITALIC = 2;
    private static final int FONT_STYLE_NORMAL = 0;
    private static Bitmap defaultFontBmp;
    public static SparseArray<a> fontCache;
    private static Context mContext;
    private static String phonetype;

    private static synchronized int[] drawText(String str, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        Paint.FontMetrics fontMetrics;
        int i8;
        int i9;
        int iPow;
        int i10;
        int desiredWidth;
        int i11;
        int i12;
        int iCeil;
        int i13;
        int desiredWidth2;
        Canvas canvas = new Canvas();
        TextPaint textPaint = new TextPaint();
        if (TextUtils.isEmpty(phonetype)) {
            phonetype = Build.MODEL;
        }
        String str2 = phonetype;
        int i14 = (str2 == null || !str2.equals(DEVICE_VIVOX3L)) ? i2 : 0;
        textPaint.reset();
        textPaint.setSubpixelText(true);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(i);
        textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        textPaint.setTypeface(getTypeface(i14));
        if (i6 != 0) {
            textPaint.setStrokeWidth(i6);
            textPaint.setStrokeCap(Paint.Cap.ROUND);
            textPaint.setStrokeJoin(Paint.Join.ROUND);
            textPaint.setStyle(Paint.Style.STROKE);
        }
        int iIndexOf = str.indexOf(92, 0);
        Bitmap bitmap = null;
        if (iIndexOf == -1) {
            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
            desiredWidth = (int) (((double) Layout.getDesiredWidth(str, 0, str.length(), textPaint)) + 0.5d);
            iCeil = (int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent);
            iArr[0] = desiredWidth;
            iArr[1] = iCeil;
            if (iArr.length == 4) {
                int iPow2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth) / Math.log(2.0d)));
                iCeil = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(iCeil) / Math.log(2.0d)));
                desiredWidth = iPow2;
            }
            if (desiredWidth == 0 && iCeil == 0) {
                iCeil = 0;
                desiredWidth = 0;
            }
            if (iArr.length == 4) {
                iArr[2] = desiredWidth;
                iArr[3] = iCeil;
            }
            if (desiredWidth > 0 && iCeil > 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(desiredWidth, iCeil, Bitmap.Config.ARGB_8888);
                if (bitmapCreateBitmap == null) {
                    return new int[0];
                }
                canvas.setBitmap(bitmapCreateBitmap);
                bitmap = bitmapCreateBitmap;
            }
            if ((i5 & (-16777216)) == 0) {
                canvas.drawColor(16777215);
            } else {
                canvas.drawColor(i5);
            }
            if (i6 != 0) {
                textPaint.setStrokeWidth(i6);
                textPaint.setStrokeCap(Paint.Cap.ROUND);
                textPaint.setStrokeJoin(Paint.Join.ROUND);
                textPaint.setStyle(Paint.Style.STROKE);
                textPaint.setColor(i4);
                canvas.drawText(str, 0.0f, 0.0f - fontMetrics2.ascent, textPaint);
            }
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setColor(i3);
            canvas.drawText(str, 0.0f, 0.0f - fontMetrics2.ascent, textPaint);
        } else {
            int i15 = iIndexOf + 1;
            int desiredWidth3 = (int) (((double) Layout.getDesiredWidth(str.substring(0, iIndexOf), textPaint)) + 0.5d);
            int i16 = 2;
            while (true) {
                int iIndexOf2 = str.indexOf(92, i15);
                if (iIndexOf2 <= 0) {
                    break;
                }
                int desiredWidth4 = (int) (((double) Layout.getDesiredWidth(str.substring(i15, iIndexOf2), textPaint)) + 0.5d);
                if (desiredWidth4 > desiredWidth3) {
                    desiredWidth3 = desiredWidth4;
                }
                i15 = iIndexOf2 + 1;
                i16++;
            }
            if (i15 != str.length() && (desiredWidth2 = (int) (((double) Layout.getDesiredWidth(str.substring(i15, str.length()), textPaint)) + 0.5d)) > desiredWidth3) {
                desiredWidth3 = desiredWidth2;
            }
            Paint.FontMetrics fontMetrics3 = textPaint.getFontMetrics();
            int iCeil2 = (int) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent);
            int i17 = i16 * iCeil2;
            iArr[0] = desiredWidth3;
            iArr[1] = i17;
            if (iArr.length == 4) {
                fontMetrics = fontMetrics3;
                i8 = iCeil2;
                int iPow3 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth3) / Math.log(2.0d)));
                iPow = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i17) / Math.log(2.0d)));
                i9 = iPow3;
            } else {
                fontMetrics = fontMetrics3;
                i8 = iCeil2;
                i9 = desiredWidth3;
                iPow = i17;
            }
            if (i9 == 0 && iPow == 0) {
                i10 = 0;
                desiredWidth = 0;
            } else {
                i10 = iPow;
                desiredWidth = i9;
            }
            if (iArr.length == 4) {
                iArr[2] = desiredWidth;
                iArr[3] = i10;
            }
            if (desiredWidth > 0 && i10 > 0) {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(desiredWidth, i10, Bitmap.Config.ARGB_8888);
                if (bitmapCreateBitmap2 == null) {
                    return new int[0];
                }
                canvas.setBitmap(bitmapCreateBitmap2);
                bitmap = bitmapCreateBitmap2;
            }
            if ((i5 & (-16777216)) == 0) {
                canvas.drawColor(16777215);
            } else {
                canvas.drawColor(i5);
            }
            textPaint.setTextAlign(getTextAlignedType(i7));
            if (i7 == 1) {
                i11 = 0;
                i12 = 0;
            } else if (i7 == 2) {
                i11 = 0;
                i12 = iArr[0];
            } else {
                i11 = 0;
                i12 = iArr[0] / 2;
            }
            int i18 = 0;
            while (true) {
                int iIndexOf3 = str.indexOf(92, i11);
                if (iIndexOf3 <= 0) {
                    break;
                }
                String strSubstring = str.substring(i11, iIndexOf3);
                Layout.getDesiredWidth(strSubstring, textPaint);
                int i19 = iIndexOf3 + 1;
                if (i6 != 0) {
                    textPaint.setStrokeWidth(i6);
                    textPaint.setStrokeCap(Paint.Cap.ROUND);
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStyle(Paint.Style.STROKE);
                    textPaint.setColor(i4);
                    i13 = i10;
                    canvas.drawText(strSubstring, i12, (i18 * i8) - fontMetrics.ascent, textPaint);
                } else {
                    i13 = i10;
                }
                textPaint.setStyle(Paint.Style.FILL);
                textPaint.setColor(i3);
                canvas.drawText(strSubstring, i12, (i18 * i8) - fontMetrics.ascent, textPaint);
                i18++;
                i10 = i13;
                i11 = i19;
            }
            int i20 = i10;
            if (i11 != str.length()) {
                String strSubstring2 = str.substring(i11, str.length());
                Layout.getDesiredWidth(strSubstring2, textPaint);
                if (i6 != 0) {
                    textPaint.setStrokeWidth(i6);
                    textPaint.setStrokeCap(Paint.Cap.ROUND);
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStyle(Paint.Style.STROKE);
                    textPaint.setColor(i4);
                    canvas.drawText(strSubstring2, i12, (i18 * i8) - fontMetrics.ascent, textPaint);
                }
                textPaint.setStyle(Paint.Style.FILL);
                textPaint.setColor(i3);
                canvas.drawText(strSubstring2, i12, (i18 * i8) - fontMetrics.ascent, textPaint);
            }
            iCeil = i20;
        }
        Bitmap bitmap2 = bitmap;
        int[] iArr2 = new int[desiredWidth * iCeil];
        if (bitmap2 != null) {
            bitmap2.copyPixelsToBuffer(IntBuffer.wrap(iArr2));
        }
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            bitmap2.recycle();
        }
        return iArr2;
    }

    private static Bitmap drawTextAlpha(String str, int i, int i2, int i3) {
        int desiredWidth;
        Canvas canvas = new Canvas();
        TextPaint textPaint = new TextPaint();
        if (TextUtils.isEmpty(phonetype)) {
            phonetype = Build.MODEL;
        }
        String str2 = phonetype;
        int i4 = 0;
        int i5 = (str2 == null || !str2.equals(DEVICE_VIVOX3L)) ? i2 : 0;
        textPaint.reset();
        textPaint.setSubpixelText(false);
        textPaint.setAntiAlias(false);
        textPaint.setTextSize(i);
        textPaint.setTypeface(getTypeface(i5));
        float f = (i3 * 1.3f) + 0.5f;
        int i6 = 92;
        int iIndexOf = str.indexOf(92, 0);
        Bitmap bitmapCreateBitmap = null;
        if (iIndexOf == -1) {
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            int desiredWidth2 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + f);
            int iCeil = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
            if (desiredWidth2 > 0 && iCeil > 0) {
                bitmapCreateBitmap = Bitmap.createBitmap(desiredWidth2, iCeil, Bitmap.Config.ALPHA_8);
                if (bitmapCreateBitmap == null) {
                    return bitmapCreateBitmap;
                }
                bitmapCreateBitmap.eraseColor(0);
                canvas.setBitmap(bitmapCreateBitmap);
            }
            textPaint.setStyle(Paint.Style.FILL);
            canvas.drawText(str, f * 0.5f, 0.0f - fontMetrics.ascent, textPaint);
        } else {
            int i7 = iIndexOf + 1;
            int desiredWidth3 = (int) (((double) Layout.getDesiredWidth(str.substring(0, iIndexOf), textPaint)) + 0.5d);
            int i8 = 2;
            while (true) {
                int iIndexOf2 = str.indexOf(i6, i7);
                if (iIndexOf2 <= 0) {
                    break;
                }
                int desiredWidth4 = (int) (((double) Layout.getDesiredWidth(str.substring(i7, iIndexOf2), textPaint)) + 0.5d);
                if (desiredWidth4 > desiredWidth3) {
                    desiredWidth3 = desiredWidth4;
                }
                i7 = iIndexOf2 + 1;
                i8++;
                i6 = 92;
            }
            if (i7 != str.length() && (desiredWidth = (int) (((double) Layout.getDesiredWidth(str.substring(i7, str.length()), textPaint)) + 0.5d)) > desiredWidth3) {
                desiredWidth3 = desiredWidth;
            }
            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
            int i9 = desiredWidth3 + i3;
            int iCeil2 = i8 * ((int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent));
            if (i9 > 0 && iCeil2 > 0) {
                bitmapCreateBitmap = Bitmap.createBitmap(i9, iCeil2, Bitmap.Config.ALPHA_8);
                if (bitmapCreateBitmap == null) {
                    return bitmapCreateBitmap;
                }
                bitmapCreateBitmap.eraseColor(0);
                canvas.setBitmap(bitmapCreateBitmap);
            }
            textPaint.setTextAlign(getTextAlignedType(3));
            float f2 = i9 - (f * 0.5f);
            int i10 = 0;
            while (true) {
                int iIndexOf3 = str.indexOf(92, i4);
                if (iIndexOf3 <= 0) {
                    break;
                }
                String strSubstring = str.substring(i4, iIndexOf3);
                Layout.getDesiredWidth(strSubstring, textPaint);
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(strSubstring, f2, (i10 * r7) - fontMetrics2.ascent, textPaint);
                i10++;
                i4 = iIndexOf3 + 1;
            }
            if (i4 != str.length()) {
                String strSubstring2 = str.substring(i4, str.length());
                Layout.getDesiredWidth(strSubstring2, textPaint);
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(strSubstring2, f2, (i10 * r7) - fontMetrics2.ascent, textPaint);
            }
        }
        return bitmapCreateBitmap;
    }

    private static synchronized Bitmap drawTextExt(String str, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        Paint.FontMetrics fontMetrics;
        int i8;
        int i9;
        int i10;
        Paint.FontMetrics fontMetrics2;
        int desiredWidth;
        int i11;
        Canvas canvas = new Canvas();
        TextPaint textPaint = new TextPaint();
        if (TextUtils.isEmpty(phonetype)) {
            phonetype = Build.MODEL;
        }
        String str2 = phonetype;
        int i12 = (str2 == null || !str2.equals(DEVICE_VIVOX3L)) ? i2 : 0;
        textPaint.reset();
        textPaint.setSubpixelText(true);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(i);
        textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        textPaint.setTypeface(getTypeface(i12));
        if (i6 != 0) {
            textPaint.setStrokeWidth(i6);
            textPaint.setStrokeCap(Paint.Cap.ROUND);
            textPaint.setStrokeJoin(Paint.Join.ROUND);
            textPaint.setStyle(Paint.Style.STROKE);
        }
        int iIndexOf = str.indexOf(92, 0);
        Bitmap bitmap = null;
        if (iIndexOf == -1) {
            Paint.FontMetrics fontMetrics3 = textPaint.getFontMetrics();
            int desiredWidth2 = (int) (((double) Layout.getDesiredWidth(str, 0, str.length(), textPaint)) + 0.5d);
            int iCeil = (int) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent);
            iArr[0] = desiredWidth2;
            iArr[1] = iCeil;
            if (iArr.length == 4) {
                int iPow = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth2) / Math.log(2.0d)));
                iCeil = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(iCeil) / Math.log(2.0d)));
                desiredWidth2 = iPow;
            }
            if (desiredWidth2 == 0 && iCeil == 0) {
                iCeil = 0;
                i11 = 0;
            } else {
                i11 = desiredWidth2;
            }
            if (iArr.length == 4) {
                iArr[2] = i11;
                iArr[3] = iCeil;
            }
            if (i11 > 0 && iCeil > 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i11, iCeil, Bitmap.Config.ARGB_8888);
                if (bitmapCreateBitmap == null) {
                    return bitmapCreateBitmap;
                }
                canvas.setBitmap(bitmapCreateBitmap);
                bitmap = bitmapCreateBitmap;
            }
            if ((i5 & (-16777216)) == 0) {
                canvas.drawColor(16777215);
            } else {
                canvas.drawColor(i5);
            }
            if (i6 != 0) {
                textPaint.setStrokeWidth(i6);
                textPaint.setStrokeCap(Paint.Cap.ROUND);
                textPaint.setStrokeJoin(Paint.Join.ROUND);
                textPaint.setStyle(Paint.Style.STROKE);
                textPaint.setColor(i4);
                canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint);
            }
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setColor(i3);
            canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint);
        } else {
            int i13 = iIndexOf + 1;
            int desiredWidth3 = (int) (((double) Layout.getDesiredWidth(str.substring(0, iIndexOf), textPaint)) + 0.5d);
            int i14 = 2;
            while (true) {
                int iIndexOf2 = str.indexOf(92, i13);
                if (iIndexOf2 <= 0) {
                    break;
                }
                int desiredWidth4 = (int) (((double) Layout.getDesiredWidth(str.substring(i13, iIndexOf2), textPaint)) + 0.5d);
                if (desiredWidth4 > desiredWidth3) {
                    desiredWidth3 = desiredWidth4;
                }
                i13 = iIndexOf2 + 1;
                i14++;
            }
            if (i13 != str.length() && (desiredWidth = (int) (((double) Layout.getDesiredWidth(str.substring(i13, str.length()), textPaint)) + 0.5d)) > desiredWidth3) {
                desiredWidth3 = desiredWidth;
            }
            Paint.FontMetrics fontMetrics4 = textPaint.getFontMetrics();
            int iCeil2 = (int) Math.ceil(fontMetrics4.descent - fontMetrics4.ascent);
            int iPow2 = i14 * iCeil2;
            iArr[0] = desiredWidth3;
            iArr[1] = iPow2;
            if (iArr.length == 4) {
                fontMetrics = fontMetrics4;
                i8 = iCeil2;
                int iPow3 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth3) / Math.log(2.0d)));
                iPow2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(iPow2) / Math.log(2.0d)));
                desiredWidth3 = iPow3;
            } else {
                fontMetrics = fontMetrics4;
                i8 = iCeil2;
            }
            if (desiredWidth3 == 0 && iPow2 == 0) {
                desiredWidth3 = 0;
                iPow2 = 0;
            }
            if (iArr.length == 4) {
                iArr[2] = desiredWidth3;
                iArr[3] = iPow2;
            }
            if (desiredWidth3 > 0 && iPow2 > 0) {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(desiredWidth3, iPow2, Bitmap.Config.ARGB_8888);
                if (bitmapCreateBitmap2 == null) {
                    return bitmapCreateBitmap2;
                }
                canvas.setBitmap(bitmapCreateBitmap2);
                bitmap = bitmapCreateBitmap2;
            }
            if ((i5 & (-16777216)) == 0) {
                canvas.drawColor(16777215);
            } else {
                canvas.drawColor(i5);
            }
            textPaint.setTextAlign(getTextAlignedType(i7));
            if (i7 == 1) {
                i9 = 0;
                i10 = 0;
            } else if (i7 == 2) {
                i9 = 0;
                i10 = iArr[0];
            } else {
                i9 = 0;
                i10 = iArr[0] / 2;
            }
            int i15 = 0;
            while (true) {
                int iIndexOf3 = str.indexOf(92, i9);
                if (iIndexOf3 <= 0) {
                    break;
                }
                String strSubstring = str.substring(i9, iIndexOf3);
                Layout.getDesiredWidth(strSubstring, textPaint);
                int i16 = iIndexOf3 + 1;
                if (i6 != 0) {
                    textPaint.setStrokeWidth(i6);
                    textPaint.setStrokeCap(Paint.Cap.ROUND);
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStyle(Paint.Style.STROKE);
                    textPaint.setColor(i4);
                    fontMetrics2 = fontMetrics;
                    canvas.drawText(strSubstring, i10, (i15 * i8) - fontMetrics2.ascent, textPaint);
                } else {
                    fontMetrics2 = fontMetrics;
                }
                textPaint.setStyle(Paint.Style.FILL);
                textPaint.setColor(i3);
                canvas.drawText(strSubstring, i10, (i15 * i8) - fontMetrics2.ascent, textPaint);
                i15++;
                i9 = i16;
                fontMetrics = fontMetrics2;
            }
            Paint.FontMetrics fontMetrics5 = fontMetrics;
            if (i9 != str.length()) {
                String strSubstring2 = str.substring(i9, str.length());
                Layout.getDesiredWidth(strSubstring2, textPaint);
                if (i6 != 0) {
                    textPaint.setStrokeWidth(i6);
                    textPaint.setStrokeCap(Paint.Cap.ROUND);
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStyle(Paint.Style.STROKE);
                    textPaint.setColor(i4);
                    canvas.drawText(strSubstring2, i10, (i15 * i8) - fontMetrics5.ascent, textPaint);
                }
                textPaint.setStyle(Paint.Style.FILL);
                textPaint.setColor(i3);
                canvas.drawText(strSubstring2, i10, (i15 * i8) - fontMetrics5.ascent, textPaint);
            }
        }
        return bitmap;
    }

    private static Paint.Align getTextAlignedType(int i) {
        return 1 == i ? Paint.Align.LEFT : 2 == i ? Paint.Align.RIGHT : Paint.Align.CENTER;
    }

    private static Bitmap getTextBitmap() {
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(false);
        paint.setTextSize(12.0f);
        paint.setTypeface(Typeface.DEFAULT);
        float fMeasureText = paint.measureText("!");
        float fDescent = paint.descent() - paint.ascent();
        if (fMeasureText <= 0.0f) {
            fMeasureText = 3.0f;
        }
        if (fDescent <= 0.0f) {
            fDescent = 15.0f;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) Math.ceil(fMeasureText), (int) Math.ceil(fDescent), Bitmap.Config.ALPHA_8);
        bitmapCreateBitmap.eraseColor(0);
        Canvas canvas = new Canvas();
        canvas.setBitmap(bitmapCreateBitmap);
        canvas.drawText("!", 0.0f, 0.0f - paint.ascent(), paint);
        return bitmapCreateBitmap;
    }

    private static short[] getTextSize(String str, int i, int i2) {
        int length = str.length();
        if (length == 0) {
            return null;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setSubpixelText(true);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(i);
        textPaint.setTypeface(getTypeface(i2));
        short[] sArr = new short[length];
        for (int i3 = 0; i3 < length; i3++) {
            sArr[i3] = (short) (((double) Layout.getDesiredWidth(str, 0, r3, textPaint)) + 0.5d);
        }
        return sArr;
    }

    private static float[] getTextSizeExt(String str, int i, int i2) {
        if (str.length() == 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize(i);
        paint.setTypeface(getTypeface(i2));
        return new float[]{paint.measureText(str), paint.descent() - paint.ascent()};
    }

    private static short[] getTextSizeWithHalo(String str, int i, int i2, int i3) {
        int length = str.length();
        if (length == 0) {
            return null;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setSubpixelText(true);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(i);
        textPaint.setTypeface(getTypeface(i2));
        if (i3 != 0) {
            textPaint.setStrokeWidth(i3);
            textPaint.setStrokeCap(Paint.Cap.ROUND);
            textPaint.setStrokeJoin(Paint.Join.ROUND);
            textPaint.setStyle(Paint.Style.STROKE);
        }
        short[] sArr = new short[length];
        for (int i4 = 0; i4 < length; i4++) {
            sArr[i4] = (short) (((double) Layout.getDesiredWidth(str, 0, r2, textPaint)) + 0.5d);
        }
        return sArr;
    }

    private static Typeface getTypeface(int i) {
        Typeface typeface = Typeface.DEFAULT;
        return i != 1 ? i != 2 ? typeface : Typeface.create(typeface, 2) : Typeface.DEFAULT_BOLD;
    }

    private static synchronized boolean isSystemFontChanged() {
        if (defaultFontBmp == null) {
            defaultFontBmp = getTextBitmap();
            return false;
        }
        Bitmap textBitmap = getTextBitmap();
        if (!(!nativeIsBitmapSame(textBitmap, defaultFontBmp))) {
            textBitmap.recycle();
            return false;
        }
        defaultFontBmp.recycle();
        defaultFontBmp = Bitmap.createBitmap(textBitmap);
        textBitmap.recycle();
        return true;
    }

    private static native boolean nativeIsBitmapSame(Bitmap bitmap, Bitmap bitmap2);

    public static synchronized void registFontCache(int i, Typeface typeface) {
        if (i == 0 || typeface == null) {
            return;
        }
        if (fontCache == null) {
            fontCache = new SparseArray<>();
        }
        a aVar = fontCache.get(i);
        if (aVar == null) {
            a aVar2 = new a();
            aVar2.f4301a = typeface;
            aVar2.b++;
            fontCache.put(i, aVar2);
        } else {
            aVar.b++;
        }
    }

    public static synchronized void removeFontCache(int i) {
        a aVar = fontCache.get(i);
        if (aVar == null) {
            return;
        }
        int i2 = aVar.b - 1;
        aVar.b = i2;
        if (i2 == 0) {
            fontCache.remove(i);
        }
    }

    public static void setContext(Context context) {
        mContext = context;
    }
}
