package com.opos.mobad.mediaplayer.a;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.TextureView;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static Bitmap a(Object obj, String str) {
        long jCurrentTimeMillis;
        Bitmap bitmapB;
        Bitmap bitmapCreateBitmap = null;
        if (obj == null) {
            return null;
        }
        try {
            jCurrentTimeMillis = System.currentTimeMillis();
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("VideoFrameUtils", "getFirstOrCurrentFrame fail");
        }
        if (!(obj instanceof TextureView)) {
            if (obj instanceof SurfaceView) {
                SurfaceView surfaceView = (SurfaceView) obj;
                if (Build.VERSION.SDK_INT >= 25) {
                    bitmapCreateBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
                    PixelCopy.request(surfaceView, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.opos.mobad.mediaplayer.a.b.1
                        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                        public void onPixelCopyFinished(int i) {
                        }
                    }, surfaceView.getHandler());
                } else {
                    bitmapB = b(str);
                }
            }
            com.opos.cmn.an.f.a.b("VideoFrameUtils", "getFirstOrCurrentFrame end:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return bitmapCreateBitmap;
        }
        bitmapB = ((TextureView) obj).getBitmap();
        bitmapCreateBitmap = bitmapB;
        com.opos.cmn.an.f.a.b("VideoFrameUtils", "getFirstOrCurrentFrame end:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return bitmapCreateBitmap;
    }

    private static Bitmap b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://127.0.0.1")) {
            return a(str);
        }
        if (str.startsWith("file")) {
            str = Uri.parse(str).getPath();
        }
        return c(str);
    }

    private static Bitmap c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (new File(str).exists()) {
            return a(str, false);
        }
        com.opos.cmn.an.f.a.b("VideoFrameUtils", "local video is null");
        return null;
    }

    public static Bitmap a(String str) {
        return a(str, true);
    }

    public static Bitmap a(String str, boolean z) {
        Bitmap frameAtTime = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.opos.cmn.an.f.a.b("VideoFrameUtils", "video path = " + str);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (z) {
                mediaMetadataRetriever.setDataSource(str, new HashMap());
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoFrameUtils", e.getStackTrace(), e);
        }
        com.opos.cmn.an.f.a.b("VideoFrameUtils", "time = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return frameAtTime;
    }
}
