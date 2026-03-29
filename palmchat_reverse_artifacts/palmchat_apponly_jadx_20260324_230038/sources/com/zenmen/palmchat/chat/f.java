package com.zenmen.palmchat.chat;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.OptIn;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.effect.Presentation;
import androidx.media3.transformer.Composition;
import androidx.media3.transformer.DefaultEncoderFactory;
import androidx.media3.transformer.EditedMediaItem;
import androidx.media3.transformer.Effects;
import androidx.media3.transformer.ExportException;
import androidx.media3.transformer.ExportResult;
import androidx.media3.transformer.TransformationRequest;
import androidx.media3.transformer.Transformer;
import androidx.media3.transformer.VideoEncoderSettings;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.f;
import com.zenmen.palmchat.fileupload.dao.FileUploadCheckDao;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b05;
import defpackage.bn2;
import defpackage.f16;
import defpackage.ir5;
import defpackage.mu1;
import defpackage.pu1;
import defpackage.q05;
import defpackage.rb3;
import defpackage.sd3;
import defpackage.vw5;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class f {
    public static f g;
    public Transformer e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f12767a = vw5.c(1, "MediaVideoProcessor");
    public AtomicBoolean b = new AtomicBoolean(false);
    public AtomicBoolean c = new AtomicBoolean(false);
    public Object d = new Object();
    public long f = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f12768a;
        public final /* synthetic */ h b;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0980a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f12769a;

            public RunnableC0980a(boolean z) {
                this.f12769a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f12769a) {
                    a.this.b.a(0);
                } else {
                    a.this.b.a(-4);
                }
            }
        }

        public a(Activity activity, h hVar) {
            this.f12768a = activity;
            this.b = hVar;
        }

        @Override // com.zenmen.palmchat.chat.f.e
        public void onCodecFormatSupport(boolean z) {
            Activity activity = this.f12768a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            this.f12768a.runOnUiThread(new RunnableC0980a(z));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f12770a;
        public final /* synthetic */ h b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f12771a;

            public a(boolean z) {
                this.f12771a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f12771a) {
                    b.this.b.a(0);
                } else {
                    b.this.b.a(-4);
                }
            }
        }

        public b(Activity activity, h hVar) {
            this.f12770a = activity;
            this.b = hVar;
        }

        @Override // com.zenmen.palmchat.chat.f.e
        public void onCodecFormatSupport(boolean z) {
            Activity activity = this.f12770a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            this.f12770a.runOnUiThread(new a(z));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bn2.d f12772a;
        public final /* synthetic */ C0981f b;
        public final /* synthetic */ boolean c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements bn2.d {
            public a() {
            }

            @Override // bn2.d
            public void a(int i) {
                bn2.d dVar = c.this.f12772a;
                if (dVar != null) {
                    dVar.a(i);
                }
            }

            @Override // bn2.d
            public void b(boolean z, int i, String str) {
                boolean z2 = z && !f.this.c.get();
                bn2.d dVar = c.this.f12772a;
                if (dVar != null) {
                    dVar.b(z2, i, str);
                }
                f.this.b.set(false);
            }
        }

        public c(bn2.d dVar, C0981f c0981f, boolean z) {
            this.f12772a = dVar;
            this.b = c0981f;
            this.c = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (f.this.e != null) {
                f.this.e.cancel();
            }
        }

        @Override // java.lang.Runnable
        @OptIn(markerClass = {UnstableApi.class})
        public void run() {
            f.this.c.set(false);
            f.this.b.set(true);
            a aVar = new a();
            f.this.m(this.b, aVar, this.c);
            long jB = ir5.b();
            while (f.this.b.get()) {
                b05.a("compress wait " + this.b.f12775a + f.this.b.get());
                try {
                    f.this.A(100L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (ir5.b() - jB >= 900000 && !f.this.c.get()) {
                    b05.a("compress timeout " + this.b.f12775a + f.this.b.get());
                    f.this.c.set(true);
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: dn3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f17086a.b();
                        }
                    });
                    aVar.b(false, 3, this.b.f12775a);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Transformer.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bn2.d f12774a;
        public final /* synthetic */ String b;

        public d(bn2.d dVar, String str) {
            this.f12774a = dVar;
            this.b = str;
        }

        @Override // androidx.media3.transformer.Transformer.Listener
        public void onCompleted(Composition composition, ExportResult exportResult) {
            f.this.e = null;
            Handler handler = new Handler(Looper.getMainLooper());
            final bn2.d dVar = this.f12774a;
            final String str = this.b;
            handler.post(new Runnable() { // from class: en3
                @Override // java.lang.Runnable
                public final void run() {
                    dVar.b(true, 0, str);
                }
            });
        }

        @Override // androidx.media3.transformer.Transformer.Listener
        public void onError(Composition composition, ExportResult exportResult, ExportException exportException) {
            b05.a("新版本SDK转换失败，错误: " + exportException.getMessage() + ", 输出文件: " + this.b);
            f.this.e = null;
            Handler handler = new Handler(Looper.getMainLooper());
            final bn2.d dVar = this.f12774a;
            final String str = this.b;
            handler.post(new Runnable() { // from class: fn3
                @Override // java.lang.Runnable
                public final void run() {
                    dVar.b(false, 2, str);
                }
            });
        }

        @Override // androidx.media3.transformer.Transformer.Listener
        public /* synthetic */ void onFallbackApplied(Composition composition, TransformationRequest transformationRequest, TransformationRequest transformationRequest2) {
            f16.c(this, composition, transformationRequest, transformationRequest2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void onCodecFormatSupport(boolean z);
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.chat.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0981f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12775a;
        public boolean b;
        public String c;
        public String d;

        public C0981f(String str, boolean z, String str2, String str3) {
            this.f12775a = str;
            this.b = z;
            this.c = str2;
            this.d = str3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12776a;
        public boolean b;
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
        void a(int i);
    }

    public static void k(final Activity activity, final String str, final e eVar) {
        vw5.c(1, "CodecCheck").submit(new Runnable() { // from class: zm3
            @Override // java.lang.Runnable
            public final void run() {
                f.w(str, activity, eVar);
            }
        });
    }

    public static void n(Activity activity, MediaItem mediaItem, long j, long j2, h hVar) {
        String str;
        int i = 0;
        if (mediaItem == null || mediaItem.mimeType != 1 || (str = mediaItem.localPath) == null) {
            hVar.a(0);
            return;
        }
        long j3 = mediaItem.playLength;
        if (j3 < j) {
            i = -3;
        } else if (j3 >= j2) {
            i = -2;
        } else if (!pu1.b(str)) {
            i = -5;
        } else if (!s(mediaItem.localPath)) {
            i = -4;
        }
        if (i == 0) {
            k(activity, mediaItem.localPath, new b(activity, hVar));
        } else {
            hVar.a(i);
        }
    }

    public static void o(Activity activity, MediaItem mediaItem, h hVar) {
        String str;
        int i = 0;
        if (mediaItem == null || mediaItem.mimeType != 1 || (str = mediaItem.localPath) == null) {
            hVar.a(0);
            return;
        }
        if (r(str)) {
            long j = mediaItem.playLength;
            if (j < 1000) {
                i = -3;
            } else if (j >= 301000) {
                i = -2;
            } else if (mediaItem.fileSize > 209715200) {
                i = -1;
            } else if (!pu1.b(mediaItem.localPath)) {
                i = -5;
            }
        } else {
            i = -4;
        }
        if (i == 0) {
            k(activity, mediaItem.localPath, new a(activity, hVar));
        } else {
            hVar.a(i);
        }
    }

    public static f p() {
        if (g == null) {
            synchronized (f.class) {
                if (g == null) {
                    g = new f();
                }
            }
        }
        return g;
    }

    public static String q(String str) {
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

    public static boolean r(String str) {
        if (str != null) {
            return str.toLowerCase().endsWith(".mp4") || str.toLowerCase().endsWith(".3gp");
        }
        return false;
    }

    public static boolean s(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(12);
            String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            return (strExtractMetadata == null || strExtractMetadata2 == null) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean t(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static /* synthetic */ void w(String str, Activity activity, final e eVar) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(12);
            String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            final boolean z = (strExtractMetadata == null || strExtractMetadata2 == null || !strExtractMetadata.startsWith("video/")) ? false : true;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: an3
                @Override // java.lang.Runnable
                public final void run() {
                    eVar.onCodecFormatSupport(z);
                }
            });
        } catch (Exception e2) {
            b05.a("checkCodecFormatSupport error: " + e2.getMessage());
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: bn3
                @Override // java.lang.Runnable
                public final void run() {
                    eVar.onCodecFormatSupport(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(bn2.d dVar, String str, VideoEncoderSettings videoEncoderSettings, String str2, EditedMediaItem editedMediaItem) {
        this.e = new Transformer.Builder(AppContext.getContext()).setVideoMimeType("video/avc").addListener(new d(dVar, str)).setEncoderFactory(new DefaultEncoderFactory.Builder(AppContext.getContext()).setRequestedVideoEncoderSettings(videoEncoderSettings).build()).build();
        b05.a("新版本SDK开始转换，输入: " + str2 + " -> 输出: " + str);
        this.e.start(editedMediaItem, str);
        this.f = System.currentTimeMillis();
    }

    public static g y(C0981f c0981f) throws Exception {
        boolean z;
        b05.a("needCompressVideo 开始检查: " + c0981f.f12775a);
        g gVar = new g();
        String str = c0981f.f12775a;
        boolean z2 = false;
        if (str.startsWith(pu1.l) || str.startsWith(pu1.j)) {
            b05.a("文件已在压缩目录中，无需压缩: " + str);
        } else {
            b05.a("文件不在压缩目录中，需要进一步检查");
            z = true;
            if (c0981f.b) {
                b05.a("需要预检查消息发送，开始计算文件MD5");
                File file = new File(str);
                long length = file.length();
                b05.a("文件大小: " + q05.b(length));
                String strB = rb3.b(file);
                b05.a("文件MD5: " + strB);
                FileUploadCheckDao fileUploadCheckDao = new FileUploadCheckDao(strB, 2, length, c0981f.c, 0, false, mu1.a(), c0981f.d, false);
                b05.a("开始同步检查文件是否已存在于服务器");
                FileUploadCheckDao.CheckVO checkVOCheckSync = fileUploadCheckDao.checkSync();
                if (checkVOCheckSync == null) {
                    b05.a("服务器检查失败，checkVO为null");
                    throw new Exception("check failed");
                }
                if (checkVOCheckSync.type == 2) {
                    b05.a("文件已存在于服务器，无需压缩");
                    gVar.b = z2;
                    gVar.f12776a = z;
                    b05.a("needCompressVideo 检查完成 - needCompress: " + z2 + ", checkExist: " + z);
                    return gVar;
                }
                b05.a("文件不存在于服务器，需要压缩。checkVO.type: " + checkVOCheckSync.type);
            } else {
                b05.a("不需要预检查消息发送，直接压缩");
            }
            z2 = true;
        }
        z = false;
        gVar.b = z2;
        gVar.f12776a = z;
        b05.a("needCompressVideo 检查完成 - needCompress: " + z2 + ", checkExist: " + z);
        return gVar;
    }

    public static void z(Activity activity, int i) {
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

    public final void A(long j) {
        synchronized (this.d) {
            try {
                this.d.wait(j);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void l(C0981f c0981f, bn2.d dVar, boolean z) {
        this.f12767a.submit(new c(dVar, c0981f, z));
    }

    @OptIn(markerClass = {UnstableApi.class})
    public final void m(C0981f c0981f, final bn2.d dVar, boolean z) {
        String absolutePath;
        boolean z2;
        int i;
        int i2;
        int i3;
        b05.a("后台线程开始预处理视频压缩任务");
        final String str = c0981f.f12775a;
        if (str != null) {
            try {
                g gVarY = y(c0981f);
                if (!gVarY.b) {
                    dVar.b(true, gVarY.f12776a ? 100 : 0, str);
                    return;
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
                final String str2 = absolutePath;
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str);
                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                    String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
                    String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                    String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(24);
                    mediaMetadataRetriever.release();
                    if (strExtractMetadata2 == null) {
                        strExtractMetadata2 = "0";
                    }
                    int i4 = Integer.parseInt(strExtractMetadata2);
                    if (strExtractMetadata3 == null) {
                        strExtractMetadata3 = "0";
                    }
                    int i5 = Integer.parseInt(strExtractMetadata3);
                    if (strExtractMetadata4 == null) {
                        strExtractMetadata4 = "0";
                    }
                    int i6 = Integer.parseInt(strExtractMetadata4);
                    if (i6 == 90 || i6 == 270) {
                        z2 = i5 > i4;
                        i = i4;
                        i2 = i5;
                    } else {
                        z2 = i4 > i5;
                        i2 = i4;
                        i = i5;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("原视频宽: ");
                    sb.append(i4);
                    sb.append(", 高: ");
                    sb.append(i5);
                    sb.append(", 旋转: ");
                    sb.append(i6);
                    sb.append("度, 实际显示: ");
                    sb.append(i2);
                    sb.append("x");
                    sb.append(i);
                    sb.append(", 判断为: ");
                    sb.append(z2 ? "横屏" : "竖屏");
                    b05.a(sb.toString());
                    long jLongValue = Long.valueOf(strExtractMetadata).longValue();
                    int i7 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
                    int i8 = 960;
                    if (z2) {
                        if (jLongValue > 120000) {
                            i3 = 600;
                            i8 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION;
                        } else {
                            i3 = 1600;
                            i7 = 960;
                            i8 = MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING;
                        }
                    } else if (jLongValue > 120000) {
                        i3 = 600;
                        i7 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION;
                        i8 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
                    } else {
                        i3 = 1600;
                        i7 = MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING;
                    }
                    float f = i2;
                    float f2 = i;
                    float fMin = Math.min(1.0f, Math.min(i7 / f, i8 / f2));
                    int iRound = Math.round(f * fMin);
                    int iRound2 = Math.round(f2 * fMin);
                    if (iRound % 2 != 0) {
                        iRound = iRound >= i7 ? iRound - 1 : Math.min(iRound + 1, i7);
                    }
                    if (iRound2 % 2 != 0) {
                        iRound2 = iRound2 >= i8 ? iRound2 - 1 : Math.min(iRound2 + 1, i8);
                    }
                    if (iRound > i7) {
                        iRound = i7;
                    }
                    if (iRound2 > i8) {
                        iRound2 = i8;
                    }
                    if (b05.f1619a) {
                        b05.a("原视频宽高比: " + (f / f2) + ", 目标最大分辨率: " + i7 + "x" + i8 + ", 缩放比: " + fMin + ", 最终分辨率: " + iRound + "x" + iRound2 + ", 码率: " + i3 + "kbps");
                    }
                    final EditedMediaItem editedMediaItemBuild = new EditedMediaItem.Builder(androidx.media3.common.MediaItem.fromUri(str)).setEffects(new Effects(Arrays.asList(new AudioProcessor[0]), Arrays.asList(Presentation.createForWidthAndHeight(iRound, iRound2, 1)))).build();
                    final VideoEncoderSettings videoEncoderSettingsBuild = new VideoEncoderSettings.Builder().setBitrate(i3 * 1000).build();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2491a.x(dVar, str2, videoEncoderSettingsBuild, str, editedMediaItemBuild);
                        }
                    });
                } catch (Exception e2) {
                    e2.printStackTrace();
                    dVar.b(false, 2, str2);
                    b05.a("Exception  " + e2);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                dVar.b(false, 2, str);
            }
        }
    }
}
