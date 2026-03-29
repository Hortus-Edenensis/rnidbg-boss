package com.zenmen.palmchat.test;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.media.player.MediaPlayerNotificationInfo;
import com.zenmen.media.player.MediaPlayerProxy;
import com.zenmen.media.player.OnLogListener;
import com.zenmen.media.player.OnStateChangeListener;
import com.zenmen.media.player.PlayStatus;
import com.zenmen.media.player.ZMMediaPlayer;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AdPlayActivity extends Activity implements SurfaceHolder.Callback {
    public Surface b;
    public SurfaceView c;
    public SurfaceHolder d;
    public SeekBar e;
    public Button f;
    public Button g;
    public Handler h;
    public Message i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaPlayerProxy f15436a = null;
    public int j = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
    public int k = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public OnLogListener o = new d();
    public OnStateChangeListener p = new e();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaPlayerProxy mediaPlayerProxy = AdPlayActivity.this.f15436a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaPlayerProxy mediaPlayerProxy = AdPlayActivity.this.f15436a;
            if (mediaPlayerProxy != null) {
                if (mediaPlayerProxy.getPlayStatus() == PlayStatus.STATUS_PLAYING) {
                    AdPlayActivity.this.f15436a.pause(false);
                    AdPlayActivity.this.g.setText("Play");
                } else if (AdPlayActivity.this.f15436a.getPlayStatus() == PlayStatus.STATUS_PAUSED) {
                    AdPlayActivity.this.f15436a.resume(false);
                    AdPlayActivity.this.g.setText("Pause");
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                AdPlayActivity adPlayActivity = AdPlayActivity.this;
                if (adPlayActivity.f15436a != null && adPlayActivity.e != null) {
                    Log.e("@@@AdPlayer", "current position = " + AdPlayActivity.this.f15436a.getPosition());
                    AdPlayActivity.this.e.setProgress(AdPlayActivity.this.f15436a.getPosition());
                }
                AdPlayActivity.this.i = obtainMessage(1);
                AdPlayActivity.this.h.sendEmptyMessageDelayed(1, 1000L);
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements OnLogListener {
        public d() {
        }

        @Override // com.zenmen.media.player.OnLogListener
        public void onLogEvent(int i, Object obj, Object obj2) {
            Log.e("@@@AdPlayer", "TestLog " + String.valueOf(obj) + "  " + String.valueOf(obj2));
        }
    }

    public final int j(int i) {
        SeekBar seekBar = (SeekBar) findViewById(R.id.activity_play_seek_bar);
        this.e = seekBar;
        seekBar.setVisibility(0);
        this.e.setMax(i);
        this.e.setOnSeekBarChangeListener(new f());
        return 0;
    }

    public final void k() {
        Intent intent = new Intent();
        intent.setAction("com.android.music.musicservicecommand");
        intent.putExtra(com.heytap.mcssdk.constant.b.y, "pause");
        sendBroadcast(intent);
    }

    public int l(int i, int i2) {
        if (this.n == 3) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (i != 0 && i2 != 0) {
            layoutParams.width = i;
            layoutParams.height = i2;
            this.c.setLayoutParams(layoutParams);
        }
        return 0;
    }

    public final void m() {
        Intent intent = new Intent();
        intent.setAction("com.android.music.musicservicecommand");
        intent.putExtra(com.heytap.mcssdk.constant.b.y, "play");
        sendBroadcast(intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        setContentView(R.layout.activity_scan_video);
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.id_surface_view);
        this.c = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.d = holder;
        holder.addCallback(this);
        Button button = (Button) findViewById(R.id.id_btn_mute);
        this.f = button;
        button.setOnClickListener(new a());
        Button button2 = (Button) findViewById(R.id.id_btn_pause);
        this.g = button2;
        button2.setOnClickListener(new b());
        ApplicationInfo applicationInfo = getApplicationInfo();
        Log.i("@@@AdPlayer", "native library dir = " + applicationInfo.nativeLibraryDir);
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy(applicationInfo.nativeLibraryDir);
        this.f15436a = mediaPlayerProxy;
        mediaPlayerProxy.setOnStateChangeListener(this.p);
        this.f15436a.setOnLogListener(this.o);
        this.h = new c(Looper.getMainLooper());
        Message messageObtain = Message.obtain();
        this.i = messageObtain;
        messageObtain.what = 1;
        this.h.sendMessage(messageObtain);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        MediaPlayerProxy mediaPlayerProxy = this.f15436a;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.stop();
            this.f15436a.release();
            this.f15436a = null;
        }
        Handler handler = this.h;
        if (handler != null) {
            handler.removeMessages(1);
        }
        m();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        MediaPlayerProxy mediaPlayerProxy = this.f15436a;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.stop();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.l = i2;
        this.m = i3;
        k();
        l(this.j, this.k);
        Surface surface = surfaceHolder.getSurface();
        this.b = surface;
        this.f15436a.setSurface(surface);
        try {
            this.f15436a.play("http://t3.wkanx.com/w001/M00/01/61/Cgrg4V5XLuiABw0eACE6aVf5GHc747.mp4");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Surface surface = surfaceHolder.getSurface();
        this.b = surface;
        this.f15436a.setSurface(surface);
        try {
            this.f15436a.play("http://t3.wkanx.com/w001/M00/01/61/Cgrg4V5XLuiABw0eACE6aVf5GHc747.mp4");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.v("@@@AdPlayer", "surfaceDestroyed tName:" + Thread.currentThread().getName() + "  tid:");
        MediaPlayerProxy mediaPlayerProxy = this.f15436a;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.stop();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements SeekBar.OnSeekBarChangeListener {
        public f() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            AdPlayActivity.this.f15436a.setPosition(seekBar.getProgress(), 0);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements OnStateChangeListener {
        public e() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onCompleted() {
            AdPlayActivity.this.f15436a.pause(false);
            AdPlayActivity.this.f15436a.setPosition(0, 0);
            AdPlayActivity.this.f15436a.resume(false);
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onError(int i, int i2, MediaPlayerNotificationInfo mediaPlayerNotificationInfo) {
            switch (i) {
                case ZMMediaPlayer.ErrorID.TTKErrDisconnected /* -36 */:
                    Log.e("@@@AdPlayer", "TTKErrDisconnected");
                    break;
                case ZMMediaPlayer.ErrorID.TTKErrCouldNotDisconnect /* -35 */:
                    Log.e("@@@AdPlayer", "TTKErrCouldNotDisconnect");
                    break;
                case ZMMediaPlayer.ErrorID.TTKErrCouldNotConnect /* -34 */:
                    Log.e("@@@AdPlayer", "TTKErrCouldNotConnect");
                    break;
                case ZMMediaPlayer.ErrorID.TTKErrTimedOut /* -33 */:
                    Log.e("@@@AdPlayer", "Timeout error");
                    break;
            }
            AdPlayActivity.this.f15436a.stop();
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onPrepared(int i, int i2) {
            AdPlayActivity adPlayActivity = AdPlayActivity.this;
            adPlayActivity.j = adPlayActivity.f15436a.GetVideoWidth(-1);
            AdPlayActivity adPlayActivity2 = AdPlayActivity.this;
            adPlayActivity2.k = adPlayActivity2.f15436a.GetVideoHeight(-1);
            Log.e("@@@AdPlayer", "W:" + AdPlayActivity.this.j + ", H:" + AdPlayActivity.this.k);
            AdPlayActivity adPlayActivity3 = AdPlayActivity.this;
            adPlayActivity3.l(adPlayActivity3.j, AdPlayActivity.this.k);
            Log.e("@@@AdPlayer", "Dutaion:" + AdPlayActivity.this.f15436a.duration());
            AdPlayActivity adPlayActivity4 = AdPlayActivity.this;
            adPlayActivity4.j(adPlayActivity4.f15436a.duration());
            AdPlayActivity.this.f15436a.start();
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
    }
}
