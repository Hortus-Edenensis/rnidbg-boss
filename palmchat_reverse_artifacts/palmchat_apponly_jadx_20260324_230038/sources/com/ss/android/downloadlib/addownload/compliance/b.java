package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.fx;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.downloader.network.a;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b extends com.ss.android.socialbase.downloader.jk.n<Long, Bitmap> {
    private final Map<Long, SoftReference<u>> u;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        private static b u = new b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int nr(int i, int i2, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        if (i3 > i || options.outHeight > i2) {
            return Math.min(Math.round(i3 / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    private b() {
        super(8, 8);
        this.u = new HashMap();
    }

    public static b u() {
        return nr.u;
    }

    public void u(long j, @NonNull u uVar) {
        if (get(Long.valueOf(j)) != null) {
            uVar.u(get(Long.valueOf(j)));
        } else {
            this.u.put(Long.valueOf(j), new SoftReference<>(uVar));
        }
    }

    public void u(final long j, final long j2, final String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<u> softReferenceRemove = this.u.remove(Long.valueOf(j));
            if (softReferenceRemove == null || softReferenceRemove.get() == null) {
                return;
            }
            softReferenceRemove.get().u(get(Long.valueOf(j)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            x.u(12, j2);
        } else {
            com.ss.android.downloadlib.x.fx.u((fx.u<Object, R>) new fx.u<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.b.2
                @Override // com.ss.android.downloadlib.x.fx.u
                public Object u(Object obj) throws Throwable {
                    Throwable th;
                    BufferedInputStream bufferedInputStream;
                    a aVarU;
                    try {
                        try {
                            aVarU = com.ss.android.socialbase.downloader.downloader.fx.u(true, 0, str, null);
                        } catch (Throwable th2) {
                            th = th2;
                            com.ss.android.socialbase.downloader.jk.iz.u(null);
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        bufferedInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        com.ss.android.socialbase.downloader.jk.iz.u(null);
                        throw th;
                    }
                    if (aVarU == null) {
                        com.ss.android.socialbase.downloader.jk.iz.u(null);
                        return null;
                    }
                    bufferedInputStream = new BufferedInputStream(aVarU.u());
                    try {
                        bufferedInputStream.mark(bufferedInputStream.available());
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(bufferedInputStream, null, options);
                        int i = options.outWidth;
                        int i2 = options.outHeight;
                        int iU = mv.u(l.getContext(), 60.0f);
                        options.inSampleSize = b.nr(iU, iU, options);
                        options.inJustDecodeBounds = false;
                        bufferedInputStream.reset();
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                            jSONObject.putOpt("bm_original_w", Integer.valueOf(i));
                            jSONObject.putOpt("bm_original_h", Integer.valueOf(i2));
                            jSONObject.putOpt("bm_bytes", Integer.valueOf(bitmapDecodeStream == null ? -1 : bitmapDecodeStream.getByteCount()));
                        } catch (Exception unused) {
                        }
                        com.ss.android.downloadlib.b.u.u().u("ttd_pref_monitor", jSONObject, j2);
                        b.this.put(Long.valueOf(j), bitmapDecodeStream);
                        com.ss.android.socialbase.downloader.jk.iz.u(bufferedInputStream);
                    } catch (Exception e2) {
                        e = e2;
                        com.ss.android.downloadlib.pn.fx.u().u(e, "BitmapCache loadBitmap");
                        com.ss.android.socialbase.downloader.jk.iz.u(bufferedInputStream);
                    }
                    return null;
                    com.ss.android.downloadlib.pn.fx.u().u(e, "BitmapCache loadBitmap");
                    com.ss.android.socialbase.downloader.jk.iz.u(bufferedInputStream);
                    return null;
                }
            }, (Object) null).u(new fx.u<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.b.1
                @Override // com.ss.android.downloadlib.x.fx.u
                public Object u(Object obj) {
                    SoftReference softReference = (SoftReference) b.this.u.remove(Long.valueOf(j));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((u) softReference.get()).u(b.this.get(Long.valueOf(j)));
                    return null;
                }
            }).u();
        }
    }
}
