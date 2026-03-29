package com.huawei.openalliance.ad.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bumptech.glide.Registry;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.dw;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.constant.ce;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ac {
    private static final String Code = "ImageUtil";
    private static final byte[] V = new byte[0];
    private static final Map<String, Set<aq>> I = new HashMap();

    private static Set<aq> B(String str) {
        return I.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(String str) {
        synchronized (V) {
            Set<aq> setB = B(str);
            if (setB != null) {
                Iterator<aq> it = setB.iterator();
                while (it.hasNext()) {
                    it.next().Code();
                }
            }
            Z(str);
        }
    }

    private static int Code(InputStream inputStream) {
        try {
            String strCode = u.Code(inputStream);
            if (com.huawei.openalliance.ad.constant.x.au.equals(strCode)) {
                return 4;
            }
            return strCode != null ? 2 : 100;
        } catch (Resources.NotFoundException unused) {
            fh.Z(Code, "resId is not found");
            return 100;
        }
    }

    private static Pair<Drawable, String> I(BitmapFactory.Options options, String str, Context context) {
        String str2;
        BitmapDrawable bitmapDrawable = null;
        try {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), Integer.parseInt(str.substring(ce.RES.toString().length())), options);
            if (bitmapDecodeResource == null) {
                fh.V(Code, "Image decode fail");
                at.Code(context).V((Integer) 0);
            }
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), bitmapDecodeResource);
            str2 = null;
            bitmapDrawable = bitmapDrawable2;
        } catch (Resources.NotFoundException e) {
            fh.I(Code, "loadImage " + e.getClass().getSimpleName());
            str2 = "loadResImg Resources.NotFoundException";
        } catch (NumberFormatException e2) {
            fh.I(Code, "loadImage " + e2.getClass().getSimpleName());
            str2 = "loadResImg NumberFormatException";
        }
        return new Pair<>(bitmapDrawable, str2);
    }

    private static Drawable S(String str) {
        return ab.Code().Code(ay.Code(str));
    }

    public static Bitmap V(Drawable drawable) {
        Bitmap bitmapCode;
        if (drawable == null || (bitmapCode = Code(drawable)) == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(bitmapCode, 0, 0, bitmapCode.getWidth(), bitmapCode.getHeight(), matrix, false);
    }

    private static void Z(String str) {
        synchronized (V) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            I.remove(str);
        }
    }

    public static Bitmap Code(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            fh.V(Code, Registry.BUCKET_BITMAP_DRAWABLE);
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight <= 0) {
            intrinsicHeight = 1;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth > 0 ? intrinsicWidth : 1, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Code(drawable, bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(String str) {
        boolean zContainsKey;
        synchronized (V) {
            zContainsKey = I.containsKey(str);
        }
        return zContainsKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5 */
    private static Pair<Drawable, String> V(BitmapFactory.Options options, String str, Context context) throws Throwable {
        InputStream inputStreamOpen;
        String str2;
        String strSubstring = str.substring(ce.ASSET.toString().length());
        ?? r1 = 0;
        BitmapDrawable bitmapDrawable = null;
        try {
            try {
                inputStreamOpen = context.getAssets().open(strSubstring);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen, null, options);
                    if (bitmapDecodeStream == null) {
                        fh.V(Code, "Image decode fail");
                        at.Code(context).V((Integer) 0);
                    }
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), bitmapDecodeStream);
                    bb.Code((Closeable) inputStreamOpen);
                    str2 = null;
                    bitmapDrawable = bitmapDrawable2;
                } catch (IOException e) {
                    e = e;
                    str2 = "loadAssetImg " + e.getClass().getSimpleName();
                    fh.I(Code, "lAI " + e.getClass().getSimpleName());
                    bb.Code((Closeable) inputStreamOpen);
                }
            } catch (Throwable th) {
                th = th;
                r1 = strSubstring;
                bb.Code((Closeable) r1);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStreamOpen = null;
        } catch (Throwable th2) {
            th = th2;
            bb.Code((Closeable) r1);
            throw th;
        }
        return new Pair<>(bitmapDrawable, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private static Pair<Drawable, String> Code(Context context, String str) {
        ?? bitmapDrawable;
        Object obj;
        BitmapFactory.Options options = new BitmapFactory.Options();
        ?? r3 = 0;
        String str2 = null;
        ?? r32 = 0;
        try {
            options.inJustDecodeBounds = false;
            try {
            } catch (OutOfMemoryError unused) {
                r32 = str;
                fh.I(Code, "OOM read image");
                bitmapDrawable = r32;
                str2 = "OOM read image";
            } catch (Throwable th) {
                th = th;
                r3 = str;
                String str3 = "loadImageFromDisk " + th.getClass().getSimpleName();
                fh.I(Code, "loadImageFromDisk " + th.getClass().getSimpleName());
                ?? r5 = r3;
                str2 = str3;
                bitmapDrawable = r5;
            }
        } catch (OutOfMemoryError unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (str.startsWith(ce.RES.toString())) {
            Pair<Drawable, String> pairI = I(options, str, context);
            Drawable drawable = (Drawable) pairI.first;
            obj = pairI.second;
            str = drawable;
        } else if (str.startsWith(ce.ASSET.toString())) {
            Pair<Drawable, String> pairV = V(options, str, context);
            Drawable drawable2 = (Drawable) pairV.first;
            obj = pairV.second;
            str = drawable2;
        } else {
            if (!str.startsWith(ce.CONTENT.toString())) {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
                if (bitmapDecodeFile == null) {
                    fh.V(Code, "Image decode fail");
                    at.Code(context).V((Integer) 0);
                }
                bitmapDrawable = new BitmapDrawable(context.getResources(), bitmapDecodeFile);
                return new Pair<>(bitmapDrawable, str2);
            }
            Pair<Drawable, String> pairCode = Code(options, (String) str, context);
            Drawable drawable3 = (Drawable) pairCode.first;
            obj = pairCode.second;
            str = drawable3;
        }
        str2 = (String) obj;
        bitmapDrawable = str;
        return new Pair<>(bitmapDrawable, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, int i, SourceParam sourceParam, String str) {
        if (sourceParam == null || sourceParam.F() == null) {
            return;
        }
        db.Code(context, i, str, sourceParam.F());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.Closeable] */
    private static Pair<Drawable, String> Code(BitmapFactory.Options options, String str, Context context) throws Throwable {
        ?? r9;
        InputStream inputStreamOpenInputStream;
        InputStream inputStreamOpenInputStream2;
        String str2;
        String str3;
        Uri uri;
        ContentResolver contentResolver;
        InputStream inputStream = null;
        try {
            try {
                uri = Uri.parse(str);
                contentResolver = context.getContentResolver();
                inputStreamOpenInputStream2 = contentResolver.openInputStream(uri);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
            inputStreamOpenInputStream = null;
            inputStreamOpenInputStream2 = null;
        } catch (Exception e2) {
            e = e2;
            inputStreamOpenInputStream = null;
            inputStreamOpenInputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            r9 = 0;
            bb.Code((Closeable) inputStream);
            bb.Code((Closeable) r9);
            throw th;
        }
        try {
            if (Code(inputStreamOpenInputStream2) == 4) {
                Pair<Drawable, String> pair = new Pair<>(new dw(context, str), null);
                bb.Code((Closeable) inputStreamOpenInputStream2);
                bb.Code((Closeable) null);
                return pair;
            }
            inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                if (bitmapDecodeStream == null) {
                    fh.V(Code, "Image decode fail");
                    at.Code(context).V((Integer) 0);
                }
                Pair<Drawable, String> pair2 = new Pair<>(new BitmapDrawable(context.getResources(), bitmapDecodeStream), null);
                bb.Code((Closeable) inputStreamOpenInputStream2);
                bb.Code((Closeable) inputStreamOpenInputStream);
                return pair2;
            } catch (FileNotFoundException e3) {
                e = e3;
                str2 = "loadFromProvider FileNotFoundException";
                str3 = "lfP " + e.getClass().getSimpleName();
                fh.I(Code, str3);
                bb.Code((Closeable) inputStreamOpenInputStream2);
                bb.Code((Closeable) inputStreamOpenInputStream);
                return new Pair<>(null, str2);
            } catch (Exception e4) {
                e = e4;
                str2 = "loadFromProvider " + e.getClass().getSimpleName();
                str3 = "lfP " + e.getClass().getSimpleName();
                fh.I(Code, str3);
                bb.Code((Closeable) inputStreamOpenInputStream2);
                bb.Code((Closeable) inputStreamOpenInputStream);
                return new Pair<>(null, str2);
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            inputStreamOpenInputStream = null;
        } catch (Exception e6) {
            e = e6;
            inputStreamOpenInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
            inputStream = inputStreamOpenInputStream2;
            r9 = str;
            bb.Code((Closeable) inputStream);
            bb.Code((Closeable) r9);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(final Context context, final SourceParam sourceParam, String str, String str2) {
        if (!bc.B(sourceParam.B())) {
            C(sourceParam.B());
            V(context, 2, sourceParam, "fromNet url is not http | " + sourceParam.D());
            return;
        }
        fh.V(Code, "loadImageFromNet");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", str);
            jSONObject.put("slotid", str2);
            jSONObject.put("content", ad.V(sourceParam));
            com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.L, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.ac.2
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str3, CallResult<String> callResult) {
                    Context applicationContext;
                    SourceParam sourceParam2;
                    String str4;
                    int i;
                    String data = callResult.getData();
                    fh.V(ac.Code, "get drawable from net, errorCode: %s filePath: %s", Integer.valueOf(callResult.getCode()), bl.Code(data));
                    if (data == null) {
                        ac.C(sourceParam.B());
                        applicationContext = context.getApplicationContext();
                        sourceParam2 = sourceParam;
                        str4 = "filepath is null";
                        i = 3;
                    } else {
                        if (ac.V(context.getApplicationContext(), sourceParam.B(), data, sourceParam)) {
                            return;
                        }
                        ac.C(sourceParam.B());
                        applicationContext = context.getApplicationContext();
                        sourceParam2 = sourceParam;
                        str4 = "image not download";
                        i = 4;
                    }
                    ac.V(applicationContext, i, sourceParam2, str4);
                }
            }, String.class);
        } catch (JSONException unused) {
            fh.I(Code, "loadImageInfo jsonex");
        }
    }

    public static void Code(Context context, SourceParam sourceParam, aq aqVar) {
        Code(context.getApplicationContext(), sourceParam, null, null, aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(String str, aq aqVar) {
        if (aqVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (V) {
            Map<String, Set<aq>> map = I;
            Set<aq> hashSet = map.get(str);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                map.put(str, hashSet);
            }
            hashSet.add(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean V(Context context, String str, String str2, SourceParam sourceParam) {
        Integer numC = at.Code(context).c();
        if (numC != null) {
            sourceParam.V(numC.intValue());
        }
        Drawable drawableS = S(str);
        if (drawableS != null) {
            fh.V(Code, "get drawable from cache");
            Code(str, drawableS);
            return true;
        }
        if (bc.B(str2)) {
            return false;
        }
        Pair<Drawable, String> pairCode = Code(context, str2);
        Drawable drawable = (Drawable) pairCode.first;
        sourceParam.Z((String) pairCode.second);
        if (drawable == null) {
            return false;
        }
        fh.V(Code, "get drawable from disk");
        ab.Code().Code(ay.Code(str), drawable);
        Code(str, drawable);
        return true;
    }

    public static void Code(Context context, final SourceParam sourceParam, final String str, final String str2, final aq aqVar) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        final Context context2 = context;
        if (sourceParam == null || sourceParam.B() == null) {
            aqVar.Code();
            V(context2, 1, sourceParam, "url is null");
            return;
        }
        fh.V(Code, "load: " + bl.Code(sourceParam.B()));
        i.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ac.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ac.V) {
                    String strB = sourceParam.B();
                    if (ac.I(strB)) {
                        ac.V(strB, aqVar);
                        return;
                    }
                    ac.V(strB, aqVar);
                    if (ac.V(context2, sourceParam.B(), sourceParam.B(), sourceParam)) {
                        return;
                    }
                    i.V(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ac.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            ac.V(context2, sourceParam, str, str2);
                        }
                    });
                }
            }
        });
    }

    private static void Code(Drawable drawable, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
    }

    private static void Code(String str, Drawable drawable) {
        synchronized (V) {
            Set<aq> setB = B(str);
            if (setB != null) {
                Iterator<aq> it = setB.iterator();
                while (it.hasNext()) {
                    it.next().Code(str, drawable);
                }
            }
            Z(str);
        }
    }
}
