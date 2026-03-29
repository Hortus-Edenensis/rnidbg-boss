package com.amazing.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.Log;
import android.util.Xml;
import defpackage.lk1;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@lk1
public class TextMeshUtils {
    @lk1
    private static Bitmap callIStaticGenerateBitmapForEmoji(byte[] bArr, int i) {
        String str = new String(bArr);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(i);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.LEFT);
        Rect rect = new Rect();
        textPaint.getTextBounds(str, 0, str.length(), rect);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawText(str, -rect.left, -rect.top, textPaint);
        canvas.save();
        canvas.restore();
        return bitmapCreateBitmap;
    }

    @lk1
    private static Bitmap callIStaticGenerateBitmapFromTextMesh(byte[] bArr, String str, int i, int i2, int i3, float f, int i4, float f2, int i5, float f3, float f4, float f5, int i6, int i7, int i8, int i9) {
        Bitmap bitmap;
        Canvas canvas;
        String str2 = new String(bArr);
        Rect rect = new Rect(0, 0, i8, i9);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(i2);
        float f6 = i;
        textPaint.setTextSize(f6);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        if (i7 == 0) {
            textPaint.setTextAlign(Paint.Align.LEFT);
        } else if (i7 == 1) {
            textPaint.setTextAlign(Paint.Align.CENTER);
        } else {
            textPaint.setTextAlign(Paint.Align.RIGHT);
        }
        if ((i4 & 16) == 16) {
            textPaint.setUnderlineText(true);
        }
        if ((i4 & 32) == 32) {
            textPaint.setStrikeThruText(true);
        }
        if ((i4 & 4) == 4) {
            textPaint.setTextSkewX((-f) / 90.0f);
        }
        if ((i4 & 8) == 8) {
            textPaint.setFakeBoldText(true);
        }
        if ((i4 & 2) == 2) {
            textPaint.setShadowLayer(f3, f4, f5, i6);
        }
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f7 = fontMetrics.top;
        float f8 = fontMetrics.bottom;
        String[] strArrSplit = str2.split("\n");
        int length = strArrSplit.length;
        if ((i4 & 1) == 1) {
            TextPaint textPaint2 = new TextPaint();
            textPaint2.setColor(i5);
            textPaint2.setTextSize(textPaint.getTextSize());
            textPaint2.setAntiAlias(textPaint.isAntiAlias());
            textPaint2.setStyle(Paint.Style.STROKE);
            textPaint2.setStrokeWidth((5.0f * f2) / f6);
            textPaint2.setTextAlign(textPaint.getTextAlign());
            textPaint2.setTextSkewX(textPaint.getTextSkewX());
            textPaint.setFakeBoldText(false);
            textPaint2.setFakeBoldText(true);
            float f9 = i3 / f6;
            float f10 = (-fontMetrics.ascent) + fontMetrics.descent;
            float f11 = f10 * 0.1f;
            bitmap = bitmapCreateBitmap;
            int i10 = 0;
            while (i10 < length) {
                TextPaint textPaint3 = textPaint;
                float f12 = f7;
                float f13 = f8;
                float f14 = f6;
                Canvas canvas3 = canvas2;
                String[] strArr = strArrSplit;
                int iCenterY = (int) (((double) ((int) ((rect.centerY() - (f7 / 2.0f)) - (f8 / 2.0f)))) - (((((double) (length - 1)) * 0.5d) - ((double) i10)) * ((double) (f11 + f10))));
                textPaint2.setLetterSpacing(f9);
                if (i7 == 0) {
                    canvas = canvas3;
                    canvas.drawText(strArr[i10], rect.left, iCenterY, textPaint2);
                } else {
                    canvas = canvas3;
                    if (i7 == 1) {
                        canvas.drawText(strArr[i10], rect.centerX(), iCenterY, textPaint2);
                    } else {
                        canvas.drawText(strArr[i10], rect.right, iCenterY, textPaint2);
                    }
                }
                i10++;
                f8 = f13;
                strArrSplit = strArr;
                textPaint = textPaint3;
                canvas2 = canvas;
                f7 = f12;
                f6 = f14;
            }
        } else {
            bitmap = bitmapCreateBitmap;
        }
        String[] strArr2 = strArrSplit;
        TextPaint textPaint4 = textPaint;
        float f15 = f6;
        float f16 = f7;
        float f17 = f8;
        Canvas canvas4 = canvas2;
        float f18 = i3 / f15;
        float f19 = (-fontMetrics.ascent) + fontMetrics.descent;
        float f20 = 0.1f * f19;
        int i11 = 0;
        while (i11 < length) {
            int iCenterY2 = (int) (((double) ((int) ((rect.centerY() - (f16 / 2.0f)) - (f17 / 2.0f)))) - (((((double) (length - 1)) * 0.5d) - ((double) i11)) * ((double) (f20 + f19))));
            TextPaint textPaint5 = textPaint4;
            textPaint5.setLetterSpacing(f18);
            if (i7 == 0) {
                canvas4.drawText(strArr2[i11], rect.left, iCenterY2, textPaint5);
            } else if (i7 == 1) {
                canvas4.drawText(strArr2[i11], rect.centerX(), iCenterY2, textPaint5);
            } else {
                canvas4.drawText(strArr2[i11], rect.right, iCenterY2, textPaint5);
            }
            i11++;
            textPaint4 = textPaint5;
        }
        canvas4.save();
        canvas4.restore();
        return bitmap;
    }

    @lk1
    private static Bitmap generateImage(String str, float f, byte[] bArr, int i, boolean z, float f2, int i2, boolean z2, float f3, float f4, int i3, float f5) {
        float f6;
        float f7;
        String str2 = new String(bArr);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setColor(i);
        Rect rect = new Rect();
        float[] fArr = new float[str2.length()];
        textPaint.getTextWidths(str2, fArr);
        textPaint.getTextBounds(str2, 0, str2.length(), rect);
        Log.i("AE_TEXT_TAG", "paint1 left:" + rect.left + " right:" + rect.right + " bottom:" + rect.bottom + " top:" + rect.top + " advance:" + fArr[0]);
        float f8 = 0.0f;
        float f9 = !z ? 0.0f : f2;
        if (z2) {
            f8 = f3;
            f6 = f4;
            f7 = f5;
        } else {
            f6 = 0.0f;
            f7 = 0.0f;
        }
        float fMax = Math.max(Math.abs(f8), Math.abs(f6)) + f9;
        TextPaint textPaint2 = new TextPaint();
        if (z || z2) {
            textPaint2.setTextSize(f);
            textPaint2.setAntiAlias(true);
            textPaint2.setStyle(Paint.Style.STROKE);
            textPaint2.setTextAlign(Paint.Align.LEFT);
            textPaint2.setStrokeWidth(f9 * 2.0f * f);
            textPaint2.setColor(i2);
            if (z2) {
                textPaint2.setShadowLayer(f7 * f, f8 * f, f6 * f, i3);
            }
        }
        float f10 = 2.0f * fMax * f;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (rect.width() + f10), (int) (rect.height() + f10), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        if (z || z2) {
            float f11 = fMax * f;
            canvas.drawText(str2, (-rect.left) + f11, (-rect.top) + f11, textPaint2);
        }
        float f12 = fMax * f;
        canvas.drawText(str2, (-rect.left) + f12, (-rect.top) + f12, textPaint);
        canvas.save();
        canvas.restore();
        return bitmapCreateBitmap;
    }

    @lk1
    private static float[] generateImageSize(String str, float f, byte[] bArr, int i, boolean z, float f2, int i2, boolean z2, float f3, float f4, int i3, float f5) {
        String str2 = new String(bArr);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setColor(i);
        Rect rect = new Rect();
        float[] fArr = new float[str2.length()];
        textPaint.getTextWidths(str2, fArr);
        textPaint.getTextBounds(str2, 0, str2.length(), rect);
        if (!z) {
            f2 = 0.0f;
        }
        if (!z2) {
            f3 = 0.0f;
            f4 = 0.0f;
        }
        return new float[]{rect.left, rect.right, -rect.bottom, -rect.top, fArr[0], (f2 + Math.max(Math.abs(f3), Math.abs(f4))) * f, textPaint.ascent(), textPaint.descent()};
    }

    @lk1
    private static String[] getAndroidSystemFontPaths() throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            fileInputStream = new FileInputStream(new File("/system/etc/fonts.xml"));
            try {
                xmlPullParserNewPullParser.setInput(fileInputStream, "utf-8");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                String text = null;
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                    if (eventType != 2) {
                        if (eventType != 3) {
                            if (eventType == 4) {
                                text = xmlPullParserNewPullParser.getText();
                            }
                        } else if ("family".equals(xmlPullParserNewPullParser.getName())) {
                            int i = 0;
                            while (true) {
                                if (i >= arrayList2.size()) {
                                    i = -1;
                                    break;
                                }
                                if (((String) arrayList2.get(i)).contains("Regular")) {
                                    break;
                                }
                                i++;
                            }
                            String str = new String("/system/fonts/");
                            if (i >= 0) {
                                arrayList.add(str.concat((String) arrayList2.get(i)));
                            } else {
                                arrayList.add(str.concat((String) arrayList2.get(0)));
                            }
                        } else if ("font".equals(xmlPullParserNewPullParser.getName())) {
                            arrayList2.add(text);
                        } else if ("familyset".equals(xmlPullParserNewPullParser.getName())) {
                            text = "ending";
                        }
                    } else if ("family".equals(xmlPullParserNewPullParser.getName())) {
                        arrayList2.clear();
                    }
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return strArr;
            } catch (Exception unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            fileInputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    @lk1
    private static float getDeviceDpi() {
        return Resources.getSystem().getDisplayMetrics().densityDpi;
    }
}
