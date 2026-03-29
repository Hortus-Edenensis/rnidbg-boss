package defpackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ReaderException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class aq6 {
    public static final Collection<BarcodeFormat> e = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR, BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED);
    public static final Collection<BarcodeFormat> f = EnumSet.of(BarcodeFormat.QR_CODE);
    public static final Collection<BarcodeFormat> g = EnumSet.of(BarcodeFormat.DATA_MATRIX);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ls3 f1557a;
    public s93 b;
    public Map<DecodeHintType, Object> c;
    public int[] d;

    public aq6(boolean z) {
        this.c = new EnumMap(DecodeHintType.class);
        if (z) {
            this.f1557a = new ls3();
            EnumSet enumSetNoneOf = EnumSet.noneOf(BarcodeFormat.class);
            enumSetNoneOf.addAll(f);
            this.c.put(DecodeHintType.POSSIBLE_FORMATS, enumSetNoneOf);
            this.c.put(DecodeHintType.CHARACTER_SET, "ISO-8859-1");
            this.c.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            this.f1557a.d(this.c);
            return;
        }
        this.f1557a = new ls3();
        EnumSet enumSetNoneOf2 = EnumSet.noneOf(BarcodeFormat.class);
        enumSetNoneOf2.addAll(f);
        enumSetNoneOf2.addAll(e);
        enumSetNoneOf2.addAll(g);
        this.c.put(DecodeHintType.POSSIBLE_FORMATS, enumSetNoneOf2);
        this.c.put(DecodeHintType.CHARACTER_SET, "ISO-8859-1");
        this.f1557a.d(this.c);
    }

    public static final boolean f(String str) {
        for (char c : str.toCharArray()) {
            if ((c < 0 || c >= 65533) && (c <= 65533 || c >= 65535)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean g(String str) {
        return str.contains("ï¿½");
    }

    public String a(Bitmap bitmap) {
        String strC;
        long jB = ir5.b();
        int i = 0;
        while (true) {
            if (i >= 3) {
                strC = null;
                break;
            }
            strC = c(bitmap, i);
            if (strC != null) {
                break;
            }
            i++;
        }
        LogUtil.i("ZXDecoder", "result =" + strC + " time=" + ir5.e(jB));
        return strC;
    }

    public String b(byte[] bArr, int i, int i2, Rect rect) {
        qx4 qx4VarC;
        String str;
        String str2 = "";
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        int[] iArr = new int[rect.width() * rect.height()];
        this.d = iArr;
        bitmapCreateBitmap.getPixels(iArr, 0, rect.width(), rect.left, rect.top, rect.width(), rect.height());
        this.b = new wq4(rect.width(), rect.height(), this.d);
        try {
            qx4VarC = this.f1557a.c(new xs(new bk2(this.b)));
            bitmapCreateBitmap.recycle();
            this.f1557a.reset();
        } catch (ReaderException unused) {
            bitmapCreateBitmap.recycle();
            this.f1557a.reset();
            qx4VarC = null;
        } catch (Throwable th) {
            bitmapCreateBitmap.recycle();
            this.f1557a.reset();
            throw th;
        }
        if (qx4VarC != null) {
            if (qx4VarC.c() == null) {
                String strG = qx4VarC.g();
                boolean zF = false;
                try {
                    str = new String(strG.getBytes("ISO-8859-1"), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    str = "";
                }
                try {
                    zF = f(str);
                    if (g(strG)) {
                        zF = true;
                    }
                    if (!zF) {
                        str2 = new String(strG.getBytes("ISO-8859-1"), "GB2312");
                    }
                } catch (UnsupportedEncodingException e3) {
                    e = e3;
                    e.printStackTrace();
                }
                return zF ? str : str2;
            }
            try {
                return new String(qx4VarC.g().getBytes(qx4VarC.c()), "UTF-8");
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public final String c(Bitmap bitmap, int i) {
        qx4 qx4VarC;
        String str;
        String str2 = "";
        Bitmap bitmapH = h(bitmap, i);
        int[] iArr = new int[bitmapH.getWidth() * bitmapH.getHeight()];
        this.d = iArr;
        bitmapH.getPixels(iArr, 0, bitmapH.getWidth(), 0, 0, bitmapH.getWidth(), bitmapH.getHeight());
        this.b = new wq4(bitmapH.getWidth(), bitmapH.getHeight(), this.d);
        try {
            try {
                qx4VarC = this.f1557a.c(new xs(new bk2(this.b)));
                if (bitmap != bitmapH) {
                    bitmapH.recycle();
                    LogUtil.i("ZXDecoder", "image recycle");
                }
                this.f1557a.reset();
            } catch (ReaderException e2) {
                e2.printStackTrace();
                if (bitmap != bitmapH) {
                    bitmapH.recycle();
                    LogUtil.i("ZXDecoder", "image recycle");
                }
                this.f1557a.reset();
                qx4VarC = null;
            }
            if (qx4VarC != null) {
                if (qx4VarC.c() == null) {
                    String strG = qx4VarC.g();
                    boolean zF = false;
                    try {
                        str = new String(strG.getBytes("ISO-8859-1"), "UTF-8");
                    } catch (UnsupportedEncodingException e3) {
                        e = e3;
                        str = "";
                    }
                    try {
                        zF = f(str);
                        if (g(strG)) {
                            zF = true;
                        }
                        if (!zF) {
                            str2 = new String(strG.getBytes("ISO-8859-1"), "GB2312");
                        }
                    } catch (UnsupportedEncodingException e4) {
                        e = e4;
                        e.printStackTrace();
                    }
                    return zF ? str : str2;
                }
                try {
                    return new String(qx4VarC.g().getBytes(qx4VarC.c()), "UTF-8");
                } catch (UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th) {
            if (bitmap != bitmapH) {
                bitmapH.recycle();
                LogUtil.i("ZXDecoder", "image recycle");
            }
            this.f1557a.reset();
            throw th;
        }
    }

    public s93 d() {
        return this.b;
    }

    public int[] e() {
        return this.d;
    }

    public final Bitmap h(Bitmap bitmap, int i) {
        LogUtil.i("ZXDecoder", "reSizeBitmap" + bitmap.getWidth() + " " + bitmap.getHeight() + "retryCount = " + i);
        if (i != 0) {
            int i2 = 2 << (i - 1);
            try {
                bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / i2, bitmap.getHeight() / i2, false);
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
            }
        }
        LogUtil.i("ZXDecoder", "reSizeBitmap resize=" + bitmap.getWidth() + " " + bitmap.getHeight());
        return bitmap;
    }

    public aq6() {
        this(false);
    }
}
