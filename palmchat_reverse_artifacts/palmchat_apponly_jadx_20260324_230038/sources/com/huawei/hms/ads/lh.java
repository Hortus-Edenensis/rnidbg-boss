package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class lh {
    private static final String Code = "ShareUtil";
    private static final int I = 100;
    private static final int V = 2000;
    private static final int Z = 5;

    private lh() {
    }

    public static Bitmap Code(Context context, le leVar) {
        InputStream inputStreamOpenInputStream;
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(Uri.parse(V(context, leVar)));
            try {
                return BitmapFactory.decodeStream(inputStreamOpenInputStream);
            } catch (Throwable th) {
                th = th;
                try {
                    fh.I(Code, "decode url as bitmap failed, caused: %s", th.getClass().getSimpleName());
                    return null;
                } finally {
                    com.huawei.openalliance.ad.utils.bb.Code((Closeable) inputStreamOpenInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenInputStream = null;
        }
    }

    private static Bitmap I(Context context, le leVar) {
        Bitmap bitmapCode = Code(context, leVar);
        return bitmapCode == null ? BitmapFactory.decodeStream(context.getResources().openRawResource(leVar.B())) : bitmapCode;
    }

    public static String V(final Context context, le leVar) {
        if (context == null || leVar == null) {
            return "";
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", leVar.C());
            jSONObject.put("templateId", leVar.S());
            jSONObject.put("slotid", leVar.F());
            jSONObject.put("content", com.huawei.openalliance.ad.utils.ad.V(Code(leVar)));
        } catch (Throwable th) {
            fh.I(Code, "get image file provider uri failed, caused: %s", th.getClass().getSimpleName());
        }
        return (String) com.huawei.openalliance.ad.utils.be.Code(new Callable<String>() { // from class: com.huawei.hms.ads.lh.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
            public String call() {
                String str = (String) com.huawei.openalliance.ad.ipc.b.Code(context).Code(com.huawei.openalliance.ad.constant.s.L, jSONObject.toString(), String.class).getData();
                return str == null ? "" : str;
            }
        }, 2000L, null);
    }

    private static Bitmap Code(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == height) {
            return bitmap;
        }
        int iMin = Math.min(width, height);
        return Bitmap.createBitmap(bitmap, (width - iMin) / 2, (height - iMin) / 2, iMin, iMin);
    }

    private static SourceParam Code(le leVar) {
        ImageInfo imageInfoD = leVar.D();
        if (imageInfoD == null) {
            imageInfoD = new ImageInfo();
        }
        SourceParam sourceParam = new SourceParam();
        sourceParam.V(imageInfoD.S());
        sourceParam.V(imageInfoD.I());
        sourceParam.I(leVar.Code());
        return sourceParam;
    }

    public static String Code(String str, int i) {
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static boolean Code(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            fh.I(Code, "class not fount %s", str);
            return false;
        }
    }

    public static byte[] Code(Context context, le leVar, int i) {
        byte[] bArr = new byte[0];
        if (leVar == null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Bitmap bitmapI = I(context, leVar);
            if (bitmapI == null) {
                return bArr;
            }
            Bitmap bitmapCode = Code(bitmapI);
            int i2 = 100;
            bitmapCode.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            while (byteArrayOutputStream.toByteArray().length > i) {
                byteArrayOutputStream.reset();
                bitmapCode.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                i2 -= 5;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                fh.I(Code, "get bitmap arr failed, cause: %s", th.getClass().getSimpleName());
                return bArr;
            } finally {
                com.huawei.openalliance.ad.utils.bb.Code(byteArrayOutputStream);
            }
        }
    }
}
