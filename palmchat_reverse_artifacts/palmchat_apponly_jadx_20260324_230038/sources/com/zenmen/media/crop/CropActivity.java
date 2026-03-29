package com.zenmen.media.crop;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
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
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.media.crop.MCropView;
import com.zenmen.media.player.MediaPlayerNotificationInfo;
import com.zenmen.media.player.MediaPlayerProxy;
import com.zenmen.media.player.OnLogListener;
import com.zenmen.media.player.OnStateChangeListener;
import com.zenmen.media.transcode.CodecFormatCheckListener;
import com.zenmen.media.transcode.ITranscodeNotify;
import com.zenmen.media.transcode.MediaTranscode;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.AndroidVideoEditSwitchConfig;
import com.zenmen.palmchat.chat.d;
import com.zenmen.palmchat.chat.f;
import com.zenmen.palmchat.chat.h;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b05;
import defpackage.ed6;
import defpackage.f16;
import defpackage.on0;
import defpackage.pu1;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.wv;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public class CropActivity extends FrameworkBaseActivity implements SurfaceHolder.Callback {
    private static final String TAG = "CropActivity";
    private static String publishDuration;
    private View mCancelBtn;
    private MCropView mCropView;
    private View mEditBtn;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceView mSurfaceView;
    private MediaTranscode mTransWrapper;
    private Transformer mTransformer;
    private VideoInfo mVideoInfo;
    MediaPlayerProxy mPlayProxy = null;
    private int mRangeStart = 0;
    private int mRangeEnd = wv.a() * 1000;
    private int mRealWidth = 0;
    private int mRealHeight = 0;
    private int mSurfaceWidth = 0;
    private int mSurfaceHeight = 0;
    private boolean logTipsShow = true;
    private Boolean mediaAccountOk = null;
    private boolean queryMediaAccount = true;
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private long lastMaxDuration = 0;
    private long cropStartTime = 0;
    private OnLogListener mNotifyLogListener = new OnLogListener() { // from class: com.zenmen.media.crop.CropActivity.5
        @Override // com.zenmen.media.player.OnLogListener
        public void onLogEvent(int i, Object obj, Object obj2) {
            Log.d(CropActivity.TAG, "TestLog " + String.valueOf(obj) + "  " + String.valueOf(obj2));
        }
    };
    private OnStateChangeListener mStateListener = new OnStateChangeListener() { // from class: com.zenmen.media.crop.CropActivity.6
        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onCompleted() {
            MediaPlayerProxy mediaPlayerProxy = CropActivity.this.mPlayProxy;
            if (mediaPlayerProxy != null) {
                mediaPlayerProxy.pause(false);
                CropActivity.this.mPlayProxy.setPosition(0, 0);
                CropActivity.this.mPlayProxy.resume(false);
            }
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onError(int i, int i2, MediaPlayerNotificationInfo mediaPlayerNotificationInfo) {
            MediaPlayerProxy mediaPlayerProxy = CropActivity.this.mPlayProxy;
            if (mediaPlayerProxy != null) {
                mediaPlayerProxy.stop();
            }
            if (i != -58) {
                return;
            }
            Log.e(CropActivity.TAG, "OnError: File not supported, please handle it in UI side.");
            sy5.e(CropActivity.this, R.string.video_des_play_error_not_support, 1).g();
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onPrepared(int i, int i2) {
            CropActivity cropActivity = CropActivity.this;
            MediaPlayerProxy mediaPlayerProxy = cropActivity.mPlayProxy;
            if (mediaPlayerProxy != null) {
                mediaPlayerProxy.setPlayRange(cropActivity.mRangeStart, CropActivity.this.mRangeEnd);
                CropActivity.this.mPlayProxy.start();
            }
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferFinished() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferingDone() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferingStarted() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onPaused() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onSeekCompleted() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onStarted() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onVideoFirstFrame() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onVideoFormatchanged(int i, int i2) {
        }
    };

    /* JADX INFO: renamed from: com.zenmen.media.crop.CropActivity$7, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass7 implements Transformer.Listener {
        final /* synthetic */ String val$dest;

        public AnonymousClass7(String str) {
            this.val$dest = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCompleted$0(String str) {
            CropActivity.this.hideBaseProgressBar();
            Intent intent = new Intent();
            MediaItem mediaItem = new MediaItem();
            mediaItem.mimeType = 1;
            mediaItem.localPath = str;
            if (AndroidVideoEditSwitchConfig.shouldUseNewSDK()) {
                mediaItem.localThumbPath = f.q(str);
            } else {
                mediaItem.localThumbPath = d.k(str);
            }
            mediaItem.thumbnailPath = mediaItem.localThumbPath;
            mediaItem.width = CropActivity.this.mVideoWidth;
            mediaItem.height = CropActivity.this.mVideoHeight;
            intent.putExtra("EXTRA_CROP_ITEM", mediaItem);
            CropActivity.this.setResult(-1, intent);
            CropActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$1() {
            CropActivity.this.hideBaseProgressBar();
            sy5.e(CropActivity.this, R.string.video_crop_fail, 1).g();
        }

        @Override // androidx.media3.transformer.Transformer.Listener
        public void onCompleted(Composition composition, ExportResult exportResult) {
            CropActivity cropActivity = CropActivity.this;
            final String str = this.val$dest;
            cropActivity.runOnUiThread(new Runnable() { // from class: com.zenmen.media.crop.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11947a.lambda$onCompleted$0(str);
                }
            });
        }

        @Override // androidx.media3.transformer.Transformer.Listener
        public void onError(Composition composition, ExportResult exportResult, ExportException exportException) {
            b05.a("CropActivity新版本SDK转换失败，错误: " + exportException.getMessage() + ", 输出文件: " + this.val$dest);
            CropActivity.this.runOnUiThread(new Runnable() { // from class: com.zenmen.media.crop.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11948a.lambda$onError$1();
                }
            });
        }

        @Override // androidx.media3.transformer.Transformer.Listener
        public /* synthetic */ void onFallbackApplied(Composition composition, TransformationRequest transformationRequest, TransformationRequest transformationRequest2) {
            f16.c(this, composition, transformationRequest, transformationRequest2);
        }
    }

    /* JADX INFO: renamed from: com.zenmen.media.crop.CropActivity$8, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass8 implements CodecFormatCheckListener {
        final /* synthetic */ String val$dest;

        /* JADX INFO: renamed from: com.zenmen.media.crop.CropActivity$8$1, reason: invalid class name */
        /* JADX INFO: compiled from: SearchBox */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ boolean val$support;

            public AnonymousClass1(boolean z) {
                this.val$support = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!this.val$support) {
                    CropActivity.this.hideBaseProgressBar();
                    sy5.e(CropActivity.this, R.string.video_crop_fail, 1).g();
                    return;
                }
                int i = CropActivity.this.mRangeEnd - CropActivity.this.mRangeStart;
                int i2 = i > 120000 ? 750 : 1600;
                ed6.b bVar = new ed6.b();
                ed6.c(i, bVar);
                if (CropActivity.this.mTransWrapper == null) {
                    return;
                }
                CropActivity.this.mTransWrapper.setVideoPropo(bVar.f17284a, bVar.b, i2);
                CropActivity.this.mTransWrapper.setDstUrl(AnonymousClass8.this.val$dest, 0);
                CropActivity.this.mTransWrapper.setTransItf(new ITranscodeNotify() { // from class: com.zenmen.media.crop.CropActivity.8.1.1
                    @Override // com.zenmen.media.transcode.ITranscodeNotify
                    public void onTranscodeFailure(int i3) {
                        b05.a("CropActivity老版本SDK转码失败，错误码: " + i3 + ", 输出文件: " + AnonymousClass8.this.val$dest);
                        if (CropActivity.this.mTransWrapper != null) {
                            CropActivity.this.mTransWrapper.release();
                            CropActivity.this.mTransWrapper = null;
                        }
                        CropActivity.this.runOnUiThread(new Runnable() { // from class: com.zenmen.media.crop.CropActivity.8.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                CropActivity.this.hideBaseProgressBar();
                                sy5.e(CropActivity.this, R.string.video_crop_fail, 1).g();
                            }
                        });
                    }

                    @Override // com.zenmen.media.transcode.ITranscodeNotify
                    public void onTranscodeFinish(long j) {
                        CropActivity.this.runOnUiThread(new Runnable() { // from class: com.zenmen.media.crop.CropActivity.8.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CropActivity.this.hideBaseProgressBar();
                                Intent intent = new Intent();
                                MediaItem mediaItem = new MediaItem();
                                mediaItem.mimeType = 1;
                                String str = AnonymousClass8.this.val$dest;
                                mediaItem.localPath = str;
                                String strE = h.e(str);
                                mediaItem.localThumbPath = strE;
                                mediaItem.thumbnailPath = strE;
                                mediaItem.width = CropActivity.this.mTransWrapper.getVideoWidth();
                                mediaItem.height = CropActivity.this.mTransWrapper.getVideoHeight();
                                intent.putExtra("EXTRA_CROP_ITEM", mediaItem);
                                CropActivity.this.setResult(-1, intent);
                                CropActivity.this.finish();
                            }
                        });
                    }

                    @Override // com.zenmen.media.transcode.ITranscodeNotify
                    public void onTranscodePercent(int i3) {
                        LogUtil.i("Crop", "onTranscodePercent" + i3);
                    }
                });
                b05.a("CropActivity老版本SDK开始转码，输入: " + CropActivity.this.mVideoInfo.getVideoPath() + " -> 输出: " + AnonymousClass8.this.val$dest);
                CropActivity.this.mTransWrapper.start(false);
                CropActivity cropActivity = CropActivity.this;
                cropActivity.showBaseProgressBar(cropActivity.getString(R.string.video_crop_des), false, false);
            }
        }

        public AnonymousClass8(String str) {
            this.val$dest = str;
        }

        @Override // com.zenmen.media.transcode.CodecFormatCheckListener
        public void onCodecFormatSupport(boolean z) {
            CropActivity.this.runOnUiThread(new AnonymousClass1(z));
        }
    }

    private long getMaxDuration() {
        return ((long) wv.a()) * 1000;
    }

    private int getRangeSeconds() {
        return Math.abs(this.mRangeEnd - this.mRangeStart) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoUploadContact() {
        startActivity(on0.a("upload_contact_from_crop"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCrop() {
        pu1.t();
        File file = new File(pu1.l);
        if (!file.exists()) {
            file.mkdir();
        }
        String str = pu1.l + File.separator + UUID.randomUUID().toString().replace("-", "") + ".mp4";
        MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.stop();
        }
        if (AndroidVideoEditSwitchConfig.shouldUseNewSDK()) {
            processCropWithNewSDK(str);
        } else {
            processCropWithLegacySDK(str);
        }
    }

    private void processCropWithLegacySDK(String str) {
        if (this.mTransWrapper == null) {
            this.mTransWrapper = new MediaTranscode(true);
        }
        this.mTransWrapper.setTimeRange(this.mRangeStart, this.mRangeEnd);
        this.mTransWrapper.setSrcUrl(this.mVideoInfo.getVideoPath(), new AnonymousClass8(str), 0);
    }

    private void processCropWithNewSDK(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.mVideoInfo.getVideoPath());
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
            String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            mediaMetadataRetriever.release();
            if (strExtractMetadata != null && strExtractMetadata2 != null) {
                this.mVideoWidth = Integer.parseInt(strExtractMetadata);
                this.mVideoHeight = Integer.parseInt(strExtractMetadata2);
            }
            int i = this.mRangeEnd - this.mRangeStart;
            int i2 = i > 120000 ? 750 : 1600;
            ed6.b bVar = new ed6.b();
            ed6.c(i, bVar);
            AnonymousClass7 anonymousClass7 = new AnonymousClass7(str);
            EditedMediaItem editedMediaItemBuild = new EditedMediaItem.Builder(new MediaItem.Builder().setUri(this.mVideoInfo.getVideoPath()).setClippingConfiguration(new MediaItem.ClippingConfiguration.Builder().setStartPositionMs(this.mRangeStart).setEndPositionMs(this.mRangeEnd).build()).build()).setEffects(new Effects(Arrays.asList(new AudioProcessor[0]), Arrays.asList(Presentation.createForWidthAndHeight(bVar.f17284a, bVar.b, 0)))).build();
            this.mTransformer = new Transformer.Builder(AppContext.getContext()).addListener(anonymousClass7).setVideoMimeType("video/avc").setEncoderFactory(new DefaultEncoderFactory.Builder(AppContext.getContext()).setRequestedVideoEncoderSettings(new VideoEncoderSettings.Builder().setBitrate(i2 * 1000).build()).build()).build();
            b05.a("CropActivity新版本SDK开始转换，输入: " + this.mVideoInfo.getVideoPath() + " -> 输出: " + str);
            this.mTransformer.start(editedMediaItemBuild, str);
            showBaseProgressBar(getString(R.string.video_crop_des), false, false);
        } catch (Exception e) {
            b05.a("processCropWithNewSDK error: " + e.getMessage());
            hideBaseProgressBar();
            sy5.e(this, R.string.video_crop_fail, 1).g();
        }
    }

    private void processIntent() {
        com.zenmen.palmchat.framework.mediapick.MediaItem mediaItem = (com.zenmen.palmchat.framework.mediapick.MediaItem) getIntent().getParcelableExtra("extra_media_item");
        if (mediaItem != null) {
            VideoInfo videoInfo = new VideoInfo();
            this.mVideoInfo = videoInfo;
            videoInfo.setDuration(String.valueOf(mediaItem.playLength));
            this.mVideoInfo.setVideoPath(mediaItem.localPath);
            this.mVideoInfo.setFileID(mediaItem.fileID);
        }
    }

    private void showUploadContactDialog() {
        new sd3(this).j(R.string.upload_contact_tips).O(R.string.upload_contact_ok).K(R.string.upload_contact_cancel).M(getResources().getColor(R.color.material_dialog_positive_color)).f(new MaterialDialog.e() { // from class: com.zenmen.media.crop.CropActivity.4
            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                super.onNegative(materialDialog);
                LogUtil.onImmediateClickEvent("m512", null, null);
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                LogUtil.onImmediateClickEvent("m511", null, null);
                CropActivity.this.gotoUploadContact();
            }
        }).Q();
    }

    private void updateViews() {
        this.mCropView.updateMaxDuration(getMaxDuration());
        updateTips();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(16777216, 16777216);
        setContentView(R.layout.activity_crop);
        processIntent();
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.mVideoInfo.getVideoPath());
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
            String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
            mediaMetadataRetriever.release();
            if (strExtractMetadata3.equals("90") || strExtractMetadata3.equals("270")) {
                this.mRealWidth = Integer.valueOf(strExtractMetadata2).intValue();
                this.mRealHeight = Integer.valueOf(strExtractMetadata).intValue();
            } else {
                this.mRealWidth = Integer.valueOf(strExtractMetadata).intValue();
                this.mRealHeight = Integer.valueOf(strExtractMetadata2).intValue();
            }
        } catch (Exception unused) {
        }
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.activity_crop_surface_view);
        this.mSurfaceView = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.mSurfaceHolder = holder;
        holder.addCallback(this);
        ApplicationInfo applicationInfo = getApplicationInfo();
        Log.i(TAG, "native library dir = " + applicationInfo.nativeLibraryDir);
        String str = applicationInfo.nativeLibraryDir;
        MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.release();
            this.mPlayProxy = null;
        }
        MediaPlayerProxy mediaPlayerProxy2 = new MediaPlayerProxy(str);
        this.mPlayProxy = mediaPlayerProxy2;
        mediaPlayerProxy2.setOnStateChangeListener(this.mStateListener);
        this.mPlayProxy.setOnLogListener(this.mNotifyLogListener);
        View viewFindViewById = findViewById(R.id.activity_crop_btn_sure);
        this.mEditBtn = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zenmen.media.crop.CropActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CropActivity.this.processCrop();
                LogUtil.onClickEvent("M312", null, null);
            }
        });
        View viewFindViewById2 = findViewById(R.id.activity_crop_btn_cancel);
        this.mCancelBtn = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.zenmen.media.crop.CropActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CropActivity.this.finish();
            }
        });
        MCropView mCropView = (MCropView) findViewById(R.id.activity_crop_crop_view);
        this.mCropView = mCropView;
        mCropView.setVideoInfo(this.mVideoInfo, getMaxDuration());
        this.mCropView.setOnSeekListener(new MCropView.OnSeekListener() { // from class: com.zenmen.media.crop.CropActivity.3
            @Override // com.zenmen.media.crop.MCropView.OnSeekListener
            public void onSeek(int i, int i2) {
                if (i < 0) {
                    i = 0;
                }
                CropActivity.this.mRangeStart = i;
                CropActivity.this.mRangeEnd = i2;
                Log.e(CropActivity.TAG, "mRangeStart = " + CropActivity.this.mRangeStart + " mRangeEnd " + CropActivity.this.mRangeEnd);
                MediaPlayerProxy mediaPlayerProxy3 = CropActivity.this.mPlayProxy;
                if (mediaPlayerProxy3 != null) {
                    mediaPlayerProxy3.setPlayRange(i, i2);
                    CropActivity.this.mPlayProxy.start();
                }
                CropActivity.this.updateTips();
            }
        });
        updateViews();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Transformer transformer = this.mTransformer;
        if (transformer != null) {
            try {
                transformer.cancel();
            } catch (Exception e) {
                b05.a("Cancel transformer error: " + e.getMessage());
            }
            this.mTransformer = null;
        }
        MediaTranscode mediaTranscode = this.mTransWrapper;
        if (mediaTranscode != null) {
            mediaTranscode.release();
        }
        MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.stop();
            this.mPlayProxy.release();
            this.mPlayProxy = null;
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        updateViews();
    }

    public int relayoutSurfaceView(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.mSurfaceView.getLayoutParams();
        if (i != 0 && i2 != 0) {
            int iRound = this.mSurfaceWidth;
            int iRound2 = this.mSurfaceHeight;
            if (iRound * i2 > i * iRound2) {
                iRound = Math.round(r5 / i2);
            } else {
                iRound2 = Math.round(r4 / i);
            }
            if (Math.abs(layoutParams.width - iRound) < 2 && Math.abs(layoutParams.height - iRound2) < 2) {
                return -1;
            }
            if (Math.abs(this.mSurfaceWidth - iRound) < 2 && Math.abs(this.mSurfaceHeight - iRound2) < 2) {
                return -1;
            }
            layoutParams.width = iRound;
            layoutParams.height = iRound2;
            this.mSurfaceView.setLayoutParams(layoutParams);
        }
        return 0;
    }

    public void saveAsImage(Bitmap bitmap, String str) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                } catch (FileNotFoundException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
            bitmap.recycle();
            bufferedOutputStream.close();
        } catch (FileNotFoundException e3) {
            e = e3;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            Log.d(TAG, "Saved frame as '" + str);
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        Log.d(TAG, "Saved frame as '" + str);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mSurfaceWidth = i2;
        this.mSurfaceHeight = i3;
        relayoutSurfaceView(this.mRealWidth, this.mRealHeight);
        Surface surface = surfaceHolder.getSurface();
        this.mSurface = surface;
        this.mPlayProxy.setSurface(surface);
        try {
            this.mPlayProxy.play(this.mVideoInfo.getVideoPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Surface surface = surfaceHolder.getSurface();
        this.mSurface = surface;
        this.mPlayProxy.setSurface(surface);
        try {
            this.mPlayProxy.play(this.mVideoInfo.getVideoPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.v(TAG, "surfaceDestroyed tName:" + Thread.currentThread().getName() + "  tid:");
        MediaPlayerProxy mediaPlayerProxy = this.mPlayProxy;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTips() {
    }
}
