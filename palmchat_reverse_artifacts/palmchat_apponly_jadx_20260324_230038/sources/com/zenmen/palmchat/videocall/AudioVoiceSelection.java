package com.zenmen.palmchat.videocall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.baidu.location.LocationConst;
import com.igexin.assist.util.AssistUtils;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.videocall.VideoCallActivity;
import defpackage.bc1;
import defpackage.vk3;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AudioVoiceSelection {
    public static final String v = "AudioVoiceSelection";
    public static volatile AudioVoiceSelection w;
    public VideoCallActivity.CallingStatus s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15814a = false;
    public Context b = null;
    public boolean c = false;
    public AudioManager d = null;
    public Vibrator e = null;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public ImageView j = null;
    public MediaPlayer k = null;
    public boolean l = false;
    public boolean m = false;
    public Timer n = null;
    public h o = h.UNKNOWN;
    public int p = 0;
    public BroadcastReceiver q = null;
    public BroadcastReceiver r = null;
    public AudioManager.OnAudioFocusChangeListener t = new d();
    public g u = null;

    /* JADX INFO: compiled from: SearchBox */
    public enum AudioProfile {
        Normal,
        Bluetooth_offline,
        Audio_only,
        AUTO
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                AudioVoiceSelection.this.f();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            AudioVoiceSelection.this.e(intent);
            "android.intent.action.HEADSET_PLUG".equals(action);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends TimerTask {
        public c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AudioVoiceSelection.this.I();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements AudioManager.OnAudioFocusChangeListener {
        public d() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == 1 || i == 3 || i == 2 || i == -1 || i != -3 || AudioVoiceSelection.this.d == null) {
                return;
            }
            AudioVoiceSelection.this.d.adjustStreamVolume(3, -1, 4);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15819a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[i.values().length];
            c = iArr;
            try {
                iArr[i.RECEIVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[i.BLUETOOTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[i.HEADSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[i.SPEAKER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[AudioProfile.values().length];
            b = iArr2;
            try {
                iArr2[AudioProfile.Audio_only.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[AudioProfile.Bluetooth_offline.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[AudioProfile.Normal.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[AudioProfile.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[f.values().length];
            f15819a = iArr3;
            try {
                iArr3[f.ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15819a[f.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f15819a[f.DISABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum f {
        ON,
        OFF,
        DISABLE
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends AsyncTask<AudioManager, Integer, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f15820a;

        public g(AudioManager audioManager) {
            this.f15820a = Integer.valueOf(audioManager.getRingerMode());
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(AudioManager... audioManagerArr) {
            while (!isCancelled()) {
                Integer numValueOf = Integer.valueOf(audioManagerArr[0].getRingerMode());
                int iIntValue = numValueOf.intValue();
                if (iIntValue == 0) {
                    publishProgress(numValueOf);
                } else if (iIntValue == 1) {
                    publishProgress(numValueOf);
                } else if (iIntValue == 2) {
                    publishProgress(numValueOf);
                }
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Log.i(AudioVoiceSelection.v, "Exit the polling RingMode loop.");
            return null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            Integer num = this.f15820a;
            Integer num2 = numArr[0];
            if (num != num2) {
                this.f15820a = num2;
                AudioVoiceSelection audioVoiceSelection = AudioVoiceSelection.this;
                audioVoiceSelection.A(audioVoiceSelection.o);
                Log.i(AudioVoiceSelection.v, "Ring mode change to :" + numArr[0]);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum h {
        UNKNOWN,
        BLUETOOTH,
        SPEAKER,
        HEADSET,
        RECEIVER
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum i {
        BLUETOOTH,
        SPEAKER,
        HEADSET,
        RECEIVER
    }

    public static AudioVoiceSelection m() {
        if (w == null) {
            synchronized (AudioVoiceSelection.class) {
                if (w == null) {
                    w = new AudioVoiceSelection();
                }
            }
        }
        return w;
    }

    public final void A(h hVar) {
        AudioManager audioManager;
        if (this.c || !this.i || this.k == null || (audioManager = this.d) == null) {
            return;
        }
        int streamVolume = audioManager.getStreamVolume(2);
        int ringerMode = this.d.getRingerMode();
        try {
            if (hVar != h.SPEAKER) {
                this.k.setVolume(1.0f, 1.0f);
            } else if (ringerMode != 2 || streamVolume <= 0) {
                this.k.setVolume(0.0f, 0.0f);
            } else {
                this.k.setVolume(1.0f, 1.0f);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void B(VideoCallActivity.CallingStatus callingStatus) {
        this.s = callingStatus;
    }

    public void C(ImageView imageView) {
        this.j = imageView;
    }

    public void D(int i2) {
        switch (i2) {
            case 24:
            case 25:
            case 26:
                f();
                break;
        }
    }

    public final void E(int i2) {
        Timer timer = this.n;
        if (timer != null) {
            timer.cancel();
            this.n = null;
        }
        if (i2 <= 0 || this.k == null) {
            return;
        }
        Timer timer2 = new Timer();
        this.n = timer2;
        timer2.schedule(new c(), i2);
    }

    public final boolean F() {
        Vibrator vibrator = this.e;
        return (vibrator == null || this.d == null || this.c || !vibrator.hasVibrator() || this.d.getRingerMode() != 1) ? false : true;
    }

    public final void G() {
        if (this.c) {
            return;
        }
        g();
        if (this.d != null) {
            g gVar = new g(this.d);
            this.u = gVar;
            gVar.execute(this.d);
        }
    }

    public void H(int i2) {
        AssetFileDescriptor assetFileDescriptorOpenFd;
        E(i2);
        MediaPlayer mediaPlayer = this.k;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            if (this.k == null) {
                this.k = new MediaPlayer();
            }
            String str = Build.BRAND;
            if (!TextUtils.isEmpty(str) && str.toLowerCase().equals(AssistUtils.BRAND_MZ)) {
                this.k.setAudioStreamType(3);
            } else if (!TextUtils.isEmpty(str) && str.toLowerCase().equals("oneplus")) {
                this.k.setAudioStreamType(1);
            } else if (!TextUtils.isEmpty(str) && str.toLowerCase().equals("huawei")) {
                this.k.setAudioStreamType(0);
            } else if (!TextUtils.isEmpty(str) && str.toLowerCase().equals("xiaomi")) {
                this.k.setAudioStreamType(3);
            } else if (!TextUtils.isEmpty(str) && str.toLowerCase().equals("redmi")) {
                this.k.setAudioStreamType(0);
            } else if (!TextUtils.isEmpty(str) && str.toLowerCase().equals("vivo")) {
                this.k.setAudioStreamType(0);
            } else if (TextUtils.isEmpty(str) || !str.toLowerCase().equals("oppo")) {
                if (TextUtils.isEmpty(str) || !str.toLowerCase().equals("realme")) {
                    this.k.setAudioStreamType(0);
                } else {
                    this.k.setAudioStreamType(0);
                }
            } else if (Build.VERSION.SDK_INT <= 26) {
                this.k.setAudioStreamType(3);
            } else {
                this.k.setAudioStreamType(0);
            }
            this.k.setLooping(true);
            try {
                assetFileDescriptorOpenFd = this.b.getAssets().openFd("sound/voip_ringtone.mp3");
            } catch (IOException e2) {
                e = e2;
                assetFileDescriptorOpenFd = null;
            }
            try {
                this.k.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                this.k.prepare();
                this.k.start();
                if (F()) {
                    long[] jArr = {1000, 1000};
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.e.vibrate(VibrationEffect.createWaveform(jArr, 0), new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
                    } else {
                        this.e.vibrate(jArr, 0);
                    }
                    this.l = true;
                    if (!this.c) {
                        A(this.o);
                    }
                }
                if (this.c) {
                    z(this.o);
                }
                this.i = true;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                this.k.stop();
                this.k.release();
                this.k = null;
                if (assetFileDescriptorOpenFd != null) {
                    try {
                        assetFileDescriptorOpenFd.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                g();
                this.i = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0040 A[PHI: r0
      0x0040: PHI (r0v6 android.os.Vibrator) = (r0v2 android.os.Vibrator), (r0v9 android.os.Vibrator) binds: [B:27:0x003e, B:14:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void I() {
        Vibrator vibrator;
        AudioManager audioManager;
        MediaPlayer mediaPlayer = this.k;
        if (mediaPlayer != null) {
            try {
                try {
                    if (mediaPlayer.isPlaying()) {
                        this.k.stop();
                        this.k.release();
                        this.k = null;
                        try {
                            Thread.sleep(50L);
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    if (this.l) {
                        Vibrator vibrator2 = this.e;
                        if (vibrator2 != null) {
                            vibrator2.cancel();
                        }
                        this.l = false;
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                if (this.l) {
                    vibrator = this.e;
                    if (vibrator != null) {
                    }
                }
                if (this.c) {
                    audioManager.setStreamVolume(3, this.p, 0);
                }
            }
            if (this.l) {
                vibrator = this.e;
                if (vibrator != null) {
                    vibrator.cancel();
                }
                this.l = false;
            }
            if (this.c && (audioManager = this.d) != null) {
                audioManager.setStreamVolume(3, this.p, 0);
            }
        }
        g();
        this.i = false;
    }

    public void J(AudioProfile audioProfile) {
        synchronized (this) {
            int i2 = e.b[audioProfile.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3 || i2 == 4) {
                        if (s()) {
                            l(i.BLUETOOTH);
                        } else if (t()) {
                            l(i.HEADSET);
                        } else {
                            l(i.SPEAKER);
                        }
                    }
                } else if (t()) {
                    l(i.HEADSET);
                } else {
                    l(i.SPEAKER);
                }
            } else if (s()) {
                l(i.BLUETOOTH);
            } else if (t()) {
                l(i.HEADSET);
            } else {
                l(i.RECEIVER);
            }
        }
    }

    public final void K(f fVar) {
        if (this.j == null) {
            return;
        }
        int i2 = e.f15819a[fVar.ordinal()];
        if (i2 == 1) {
            this.j.setImageResource(R.drawable.video_call_handfree_on);
            this.j.setEnabled(true);
            Log.i(v, "switchHandfreeIcon: ON");
        } else if (i2 == 2) {
            this.j.setImageResource(R.drawable.video_call_handfree_off);
            this.j.setEnabled(true);
            Log.i(v, "switchHandfreeIcon: OFF");
        } else {
            if (i2 != 3) {
                return;
            }
            this.j.setImageResource(R.drawable.video_call_handfree_disable);
            this.j.setEnabled(false);
            Log.i(v, "switchHandfreeIcon: DISABLE");
        }
    }

    public void L(boolean z) {
        if (z) {
            if (s()) {
                l(i.BLUETOOTH);
            } else {
                l(i.SPEAKER);
            }
        } else if (t()) {
            l(i.HEADSET);
        } else {
            l(i.RECEIVER);
        }
        this.h = z;
    }

    public void M() {
        synchronized (this) {
            if (this.b == null) {
                return;
            }
            Log.i(v, "uninitSelection");
            I();
            BroadcastReceiver broadcastReceiver = this.r;
            if (broadcastReceiver != null) {
                this.b.unregisterReceiver(broadcastReceiver);
            }
            this.r = null;
            BroadcastReceiver broadcastReceiver2 = this.q;
            if (broadcastReceiver2 != null) {
                this.b.unregisterReceiver(broadcastReceiver2);
            }
            this.q = null;
            y();
            g();
            this.i = false;
            this.c = false;
            this.m = false;
            this.e = null;
            this.d = null;
            this.j = null;
            this.f15814a = false;
        }
    }

    public void e(Intent intent) {
        AudioManager audioManager;
        String action = intent.getAction();
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
            String str = v;
            Log.i(str, "BroadcasetReceiver 1" + intExtra);
            if (intExtra == 2) {
                this.f = true;
                l(i.BLUETOOTH);
                Log.i(str, "BroadcastReceiver.BluetoothAdapter.STATE_CONNECTED");
                return;
            } else {
                if (intExtra == 0) {
                    this.f = false;
                    J(AudioProfile.Bluetooth_offline);
                    Log.i(str, "BroadcastReceiver.BluetoothAdapter.STATE_DISCONNECTED");
                    return;
                }
                return;
            }
        }
        if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(action)) {
            int intExtra2 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            Log.i(v, "BroadcasetReceiver 2" + intExtra2);
            if (intExtra2 != 0) {
                if (intExtra2 == 1 || intExtra2 == 2) {
                    this.f = true;
                    l(i.BLUETOOTH);
                    return;
                }
                return;
            }
            try {
                if (vk3.a() || (audioManager = this.d) == null) {
                    return;
                }
                if (audioManager.isBluetoothA2dpOn() && this.d.isBluetoothScoOn()) {
                    return;
                }
                this.f = false;
                J(AudioProfile.Bluetooth_offline);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action)) {
            int intExtra3 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
            String str2 = v;
            Log.i(str2, "BroadcastReceiver 3" + intExtra3);
            if (intExtra3 == 2) {
                this.f = true;
                l(i.BLUETOOTH);
                Log.i(str2, "BroadcastReceiver.BluetoothAdapter.STATE_CONNECTED ");
                return;
            } else {
                if (intExtra3 == 0) {
                    this.f = false;
                    J(AudioProfile.Bluetooth_offline);
                    Log.i(str2, "BroadcastReceiver.BluetoothAdapter.STATE_DISCONNECTED");
                    return;
                }
                return;
            }
        }
        if (!"android.intent.action.HEADSET_PLUG".equals(action)) {
            Log.i(v, "BroadcasetReceiver 5:" + action);
            return;
        }
        Log.i(v, "BroadcasetReceiver 4");
        if (intent.getIntExtra(LocationConst.HDYawConst.KEY_HD_YAW_STATE, 0) == 0) {
            this.m = false;
            this.g = false;
            J(AudioProfile.AUTO);
        } else if (intent.getIntExtra(LocationConst.HDYawConst.KEY_HD_YAW_STATE, 0) == 1) {
            this.g = true;
            if (!this.m) {
                l(i.HEADSET);
                return;
            }
            if (this.f) {
                l(i.BLUETOOTH);
            }
            this.m = false;
        }
    }

    public final void f() {
        if (this.c) {
            return;
        }
        I();
    }

    public final void g() {
        g gVar = this.u;
        if (gVar != null) {
            if (!gVar.isCancelled()) {
                this.u.cancel(false);
            }
            this.u = null;
        }
    }

    public void h() {
        Log.i(v, "BroadcastReceiver changeToBluetooth");
        try {
            if (!this.i) {
                this.d.setMode(3);
            }
            if (!this.i) {
                if (!this.d.isBluetoothScoOn()) {
                    this.d.startBluetoothSco();
                    this.d.setBluetoothScoOn(true);
                }
                this.d.setSpeakerphoneOn(false);
            }
            h hVar = h.BLUETOOTH;
            A(hVar);
            this.o = hVar;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void i() {
        Log.i(v, "BroadcastReceiver changeToHeadset");
        try {
            if (!this.i) {
                this.d.setMode(3);
            }
            if (!this.i) {
                if (this.d.isBluetoothScoOn()) {
                    this.d.stopBluetoothSco();
                    this.d.setBluetoothScoOn(false);
                }
                this.d.setSpeakerphoneOn(false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        h hVar = h.HEADSET;
        A(hVar);
        this.o = hVar;
    }

    public void j() {
        Log.i(v, "BroadcastReceiver changeToReceiver");
        try {
            if (this.i) {
                this.d.setSpeakerphoneOn(false);
            } else {
                this.d.stopBluetoothSco();
                this.d.setBluetoothScoOn(false);
                this.d.setSpeakerphoneOn(false);
            }
            if (!this.i) {
                this.d.setMode(3);
            }
            if (this.i && (bc1.b().equals("OPPO A37f") || bc1.b().equals("OPPO A33f"))) {
                this.d.setMode(3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.o = h.RECEIVER;
    }

    public void k() {
        Log.i(v, "BroadcastReceiver changeToSpeaker");
        try {
            if (this.i && !Build.BRAND.toLowerCase().equals("redmi")) {
                this.d.setMode(0);
            } else {
                this.d.setMode(3);
            }
            if (this.i) {
                this.d.setSpeakerphoneOn(true);
            } else {
                this.d.stopBluetoothSco();
                this.d.setBluetoothScoOn(false);
                this.d.setSpeakerphoneOn(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        h hVar = h.SPEAKER;
        A(hVar);
        this.o = hVar;
        Log.i(v, "after BroadcastReceiver changeToSpeaker");
    }

    public void l(i iVar) {
        int i2 = e.c[iVar.ordinal()];
        if (i2 == 1) {
            Log.i(v, "changeVoiceRouter: RECEIVER");
            j();
            K(f.OFF);
            this.h = false;
            return;
        }
        if (i2 == 2) {
            Log.i(v, "changeVoiceRouter: BLUETOOTH");
            h();
            K(f.DISABLE);
            this.h = false;
            return;
        }
        if (i2 == 3) {
            Log.i(v, "changeVoiceRouter: HEADSET");
            i();
            K(f.DISABLE);
            this.h = false;
            return;
        }
        if (i2 != 4) {
            return;
        }
        Log.i(v, "changeVoiceRouter: SPEAKER");
        k();
        this.h = true;
        K(f.ON);
    }

    public void n() {
        this.q = new b();
    }

    public void o() {
        this.r = new a();
    }

    public void p(Context context, boolean z) {
        synchronized (this) {
            if (this.f15814a) {
                return;
            }
            if (context == null) {
                return;
            }
            o();
            n();
            this.b = context;
            this.c = z;
            this.d = (AudioManager) context.getSystemService("audio");
            this.e = (Vibrator) this.b.getSystemService("vibrator");
            this.b.registerReceiver(this.r, new IntentFilter("android.intent.action.SCREEN_OFF"));
            IntentFilter intentFilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            this.b.registerReceiver(this.q, intentFilter);
            AudioManager audioManager = this.d;
            boolean z2 = false;
            if (audioManager != null) {
                this.g = audioManager.isWiredHeadsetOn();
                this.f = this.d.isBluetoothA2dpOn() || this.d.isBluetoothScoOn();
            }
            if (this.f && this.g) {
                z2 = true;
            }
            this.m = z2;
            this.i = true;
            G();
            this.f15814a = true;
            Log.i(v, "initSelection");
        }
    }

    public boolean q() {
        return this.h;
    }

    public boolean r() {
        AudioManager audioManager = this.d;
        if (audioManager == null) {
            return false;
        }
        try {
            if (audioManager.getRingerMode() != 0) {
                if (this.d.getRingerMode() != 1) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean s() {
        AudioManager audioManager = this.d;
        if (audioManager == null) {
            return false;
        }
        boolean zIsBluetoothA2dpOn = audioManager.isBluetoothA2dpOn();
        boolean zIsBluetoothScoOn = this.d.isBluetoothScoOn();
        vk3.a();
        return this.f || zIsBluetoothA2dpOn || zIsBluetoothScoOn;
    }

    public boolean t() {
        return this.g;
    }

    public void u() {
        boolean z = this.f || this.g;
        if (RTCParameters.m()) {
            vk3.d(this.b, "sound/close.wav", z, null);
        } else {
            vk3.d(this.b, "sound/close.mp3", z, null);
        }
    }

    public void v() {
        vk3.d(this.b, "sound/call_interrupt.mp3", this.f || this.g, null);
    }

    public void w(boolean z) {
        try {
            Vibrator vibrator = this.e;
            if (vibrator != null) {
                long[] jArr = {1000, 1000};
                int i2 = 0;
                if (Build.VERSION.SDK_INT >= 26) {
                    AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setContentType(4).setUsage(4).build();
                    Vibrator vibrator2 = this.e;
                    if (!z) {
                        i2 = -1;
                    }
                    vibrator2.vibrate(VibrationEffect.createWaveform(jArr, i2), audioAttributesBuild);
                } else {
                    if (!z) {
                        i2 = -1;
                    }
                    vibrator.vibrate(jArr, i2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean x() {
        AudioManager audioManager = this.d;
        return audioManager != null && audioManager.requestAudioFocus(this.t, 3, 2) == 1;
    }

    public void y() {
        AudioManager audioManager = this.d;
        if (audioManager != null) {
            audioManager.setBluetoothScoOn(false);
            this.d.stopBluetoothSco();
            this.d.setMode(0);
            this.d.setBluetoothScoOn(false);
            try {
                Thread.sleep(50L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.d.stopBluetoothSco();
            this.d.abandonAudioFocus(this.t);
        }
    }

    public final void z(h hVar) {
        AudioManager audioManager;
        if (!this.c || !this.i || this.k == null || (audioManager = this.d) == null) {
            return;
        }
        int streamVolume = audioManager.getStreamVolume(0);
        int streamVolume2 = this.d.getStreamVolume(3);
        this.p = streamVolume2;
        int streamMaxVolume = this.d.getStreamMaxVolume(3) / 2;
        if (hVar != h.SPEAKER || streamVolume2 > 0 || streamVolume <= 0) {
            return;
        }
        this.d.setStreamVolume(3, streamMaxVolume, 0);
    }
}
