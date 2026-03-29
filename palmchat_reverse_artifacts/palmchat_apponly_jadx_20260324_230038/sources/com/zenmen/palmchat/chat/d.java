package com.zenmen.palmchat.chat;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.media.transcode.CodecFormatCheckListener;
import com.zenmen.media.transcode.ITranscodeNotify;
import com.zenmen.media.transcode.MediaTranscode;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.fileupload.dao.FileUploadCheckDao;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b05;
import defpackage.bn2;
import defpackage.ir5;
import defpackage.mu1;
import defpackage.pu1;
import defpackage.rb3;
import defpackage.sd3;
import defpackage.vw5;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class d {
    public static d e;
    public static long f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f12749a = vw5.c(1, "LegacyVideoProcessor");
    public AtomicBoolean b = new AtomicBoolean(false);
    public AtomicBoolean c = new AtomicBoolean(false);
    public Object d = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements CodecFormatCheckListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaTranscode f12750a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ g c;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0977a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f12751a;

            public RunnableC0977a(boolean z) {
                this.f12751a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f12751a) {
                    a.this.c.a(0);
                } else {
                    a.this.c.a(-4);
                }
            }
        }

        public a(MediaTranscode mediaTranscode, Activity activity, g gVar) {
            this.f12750a = mediaTranscode;
            this.b = activity;
            this.c = gVar;
        }

        @Override // com.zenmen.media.transcode.CodecFormatCheckListener
        public void onCodecFormatSupport(boolean z) {
            this.f12750a.release();
            Activity activity = this.b;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            this.b.runOnUiThread(new RunnableC0977a(z));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements CodecFormatCheckListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaTranscode f12752a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ g c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f12753a;

            public a(boolean z) {
                this.f12753a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f12753a) {
                    b.this.c.a(0);
                } else {
                    b.this.c.a(-4);
                }
            }
        }

        public b(MediaTranscode mediaTranscode, Activity activity, g gVar) {
            this.f12752a = mediaTranscode;
            this.b = activity;
            this.c = gVar;
        }

        @Override // com.zenmen.media.transcode.CodecFormatCheckListener
        public void onCodecFormatSupport(boolean z) {
            this.f12752a.release();
            Activity activity = this.b;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            this.b.runOnUiThread(new a(z));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bn2.d f12754a;
        public final /* synthetic */ e b;
        public final /* synthetic */ boolean c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements bn2.d {
            public a() {
            }

            @Override // bn2.d
            public void a(int i) {
                bn2.d dVar = c.this.f12754a;
                if (dVar != null) {
                    dVar.a(i);
                }
            }

            @Override // bn2.d
            public void b(boolean z, int i, String str) {
                boolean z2 = z && !d.this.c.get();
                bn2.d dVar = c.this.f12754a;
                if (dVar != null) {
                    dVar.b(z2, i, str);
                }
                d.this.b.set(false);
            }
        }

        public c(bn2.d dVar, e eVar, boolean z) {
            this.f12754a = dVar;
            this.b = eVar;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.f = System.currentTimeMillis();
            d.this.c.set(false);
            d.this.b.set(true);
            a aVar = new a();
            MediaTranscode mediaTranscodeF = d.f(this.b, aVar, this.c);
            if (mediaTranscodeF != null) {
                long jB = ir5.b();
                while (d.this.b.get()) {
                    LogUtil.i("LegacyVideoProcessor", "compress wait " + this.b.f12758a + d.this.b.get());
                    try {
                        d.this.p(100L);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (ir5.b() - jB >= 900000 && !d.this.c.get()) {
                        LogUtil.i("LegacyVideoProcessor", "compress timeout " + this.b.f12758a + d.this.b.get());
                        d.this.c.set(true);
                        mediaTranscodeF.release();
                        aVar.b(false, 3, this.b.f12758a);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.chat.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0978d implements CodecFormatCheckListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaTranscode f12756a;
        public final /* synthetic */ String b;
        public final /* synthetic */ bn2.d c;
        public final /* synthetic */ String d;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.d$d$a */
        /* JADX INFO: compiled from: SearchBox */
        public class a implements ITranscodeNotify {
            public a() {
            }

            @Override // com.zenmen.media.transcode.ITranscodeNotify
            public void onTranscodeFailure(int i) {
                b05.a("老版本SDK转码失败，错误码: " + i + ", 输出文件: " + C0978d.this.b);
                C0978d.this.f12756a.release();
                C0978d c0978d = C0978d.this;
                c0978d.c.b(false, i, c0978d.b);
            }

            @Override // com.zenmen.media.transcode.ITranscodeNotify
            public void onTranscodeFinish(long j) {
                C0978d.this.f12756a.release();
                C0978d c0978d = C0978d.this;
                c0978d.c.b(true, 0, c0978d.b);
            }

            @Override // com.zenmen.media.transcode.ITranscodeNotify
            public void onTranscodePercent(int i) {
                LogUtil.i("LegacyVideoProcessor", "onTranscodePercent " + i);
                C0978d.this.c.a(i);
            }
        }

        public C0978d(MediaTranscode mediaTranscode, String str, bn2.d dVar, String str2) {
            this.f12756a = mediaTranscode;
            this.b = str;
            this.c = dVar;
            this.d = str2;
        }

        @Override // com.zenmen.media.transcode.CodecFormatCheckListener
        public void onCodecFormatSupport(boolean z) {
            if (!z) {
                LogUtil.i("LegacyVideoProcessor", "onTranscodeError not support" + this.b);
                this.f12756a.release();
                this.c.b(false, 1, this.b);
                return;
            }
            this.f12756a.setDstUrl(this.b, 0);
            this.f12756a.setTransItf(new a());
            b05.a("老版本SDK开始转码，输入: " + this.d + " -> 输出: " + this.b);
            this.f12756a.start(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12758a;
        public boolean b;
        public String c;
        public String d;

        public e(String str, boolean z, String str2, String str3) {
            this.f12758a = str;
            this.b = z;
            this.c = str2;
            this.d = str3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12759a;
        public boolean b;
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        void a(int i);
    }

    public static MediaTranscode f(e eVar, bn2.d dVar, boolean z) {
        String absolutePath;
        int i;
        int i2;
        int i3;
        String str = eVar.f12758a;
        if (str == null) {
            return null;
        }
        try {
            f fVarN = n(eVar);
            if (!fVarN.b) {
                dVar.b(true, fVarN.f12759a ? 100 : 0, str);
                return null;
            }
            if (z) {
                LogUtil.onClickEvent("V34", null, null);
            }
            pu1.t();
            File file = new File(pu1.l);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.canWrite()) {
                absolutePath = pu1.l + File.separator + UUID.randomUUID().toString().replace("-", "") + ".mp4";
            } else {
                File fileL = pu1.l(AppContext.getContext());
                if (!fileL.exists()) {
                    fileL.mkdirs();
                }
                absolutePath = new File(fileL, UUID.randomUUID().toString().replace("-", "") + ".mp4").getAbsolutePath();
            }
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                mediaMetadataRetriever.release();
                MediaTranscode mediaTranscode = new MediaTranscode(true);
                if (Long.valueOf(strExtractMetadata).longValue() > 120000) {
                    i = 600;
                    i2 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION;
                    i3 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
                } else {
                    i = 1600;
                    i2 = MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING;
                    i3 = 960;
                }
                mediaTranscode.setVideoPropo(i2, i3, i);
                mediaTranscode.setTimeRange(0L, Long.valueOf(strExtractMetadata).longValue());
                mediaTranscode.setSrcUrl(str, new C0978d(mediaTranscode, absolutePath, dVar, str), 0);
                return mediaTranscode;
            } catch (Exception e2) {
                e2.printStackTrace();
                dVar.b(false, 2, absolutePath);
                LogUtil.i("LegacyVideoProcessor", "Exception  " + e2);
                return null;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            dVar.b(false, 2, str);
            return null;
        }
    }

    public static void h(Activity activity, MediaItem mediaItem, long j, long j2, g gVar) {
        String str;
        if (mediaItem == null || mediaItem.mimeType != 1 || (str = mediaItem.localPath) == null) {
            gVar.a(0);
            return;
        }
        long j3 = mediaItem.playLength;
        int i = j3 < j ? -3 : j3 >= j2 ? -2 : !pu1.b(str) ? -5 : MediaTranscode.isSupportedMediaFile(mediaItem.localPath) == -1 ? -4 : 0;
        if (i != 0) {
            gVar.a(i);
        } else {
            MediaTranscode mediaTranscode = new MediaTranscode(false);
            mediaTranscode.setSrcUrl(mediaItem.localPath, new b(mediaTranscode, activity, gVar), 0);
        }
    }

    public static void i(Activity activity, MediaItem mediaItem, g gVar) {
        String str;
        if (mediaItem == null || mediaItem.mimeType != 1 || (str = mediaItem.localPath) == null) {
            gVar.a(0);
            return;
        }
        int i = -4;
        if (l(str)) {
            long j = mediaItem.playLength;
            if (j < 1000) {
                i = -3;
            } else if (j >= 301000) {
                i = -2;
            } else if (mediaItem.fileSize > 209715200) {
                i = -1;
            } else if (pu1.b(mediaItem.localPath)) {
                int iIsSupportedMediaFile = MediaTranscode.isSupportedMediaFile(mediaItem.localPath);
                if (iIsSupportedMediaFile != -1) {
                    i = iIsSupportedMediaFile == -2 ? -6 : 0;
                }
            } else {
                i = -5;
            }
        }
        if (i != 0) {
            gVar.a(i);
        } else {
            MediaTranscode mediaTranscode = new MediaTranscode(false);
            mediaTranscode.setSrcUrl(mediaItem.localPath, new a(mediaTranscode, activity, gVar), 0);
        }
    }

    public static d j() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    public static String k(String str) {
        Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        File file = new File((pu1.l + File.separator) + System.currentTimeMillis() + ".thumbnail");
        if (file.exists()) {
            file.delete();
        }
        if (bitmapCreateVideoThumbnail == null) {
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmapCreateVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file.getAbsolutePath();
        } catch (IOException unused) {
            return null;
        }
    }

    public static boolean l(String str) {
        if (str != null) {
            return str.toLowerCase().endsWith(".mp4") || str.toLowerCase().endsWith(".3gp");
        }
        return false;
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
    
        if (r0.type == 2) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f n(e eVar) throws Exception {
        boolean z;
        f fVar = new f();
        String str = eVar.f12758a;
        boolean z2 = false;
        if (str.startsWith(pu1.l) || str.startsWith(pu1.j)) {
            z = false;
        } else {
            z = true;
            if (eVar.b) {
                File file = new File(str);
                FileUploadCheckDao.CheckVO checkVOCheckSync = new FileUploadCheckDao(rb3.b(file), 2, file.length(), eVar.c, 0, false, mu1.a(), eVar.d, false).checkSync();
                if (checkVOCheckSync == null) {
                    throw new Exception("check failed");
                }
            }
            z2 = true;
            z = false;
        }
        fVar.b = z2;
        fVar.f12759a = z;
        return fVar;
    }

    public static void o(Activity activity, int i) {
        sd3 sd3Var = new sd3(activity);
        int i2 = R.string.video_filter_large;
        if (i != -1) {
            if (i == -2) {
                i2 = R.string.video_filter_long;
            } else if (i == -3) {
                i2 = R.string.video_filter_short;
            } else if (i == -4) {
                i2 = R.string.video_filter_unsupport;
            } else if (i == -5) {
                i2 = R.string.video_filter_not_exit;
            } else if (i == -6) {
                i2 = R.string.video_filter_size_too_large;
            }
        }
        sd3Var.j(i2).O(R.string.alert_dialog_ok).e().show();
    }

    public void g(e eVar, bn2.d dVar, boolean z) {
        this.f12749a.submit(new c(dVar, eVar, z));
    }

    public final void p(long j) {
        synchronized (this.d) {
            try {
                this.d.wait(j);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }
}
