package com.zenmen.media.roomchat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.baidu.location.LocationConst;
import com.igexin.assist.util.AssistUtils;
import com.zenmen.palmchat.R;
import defpackage.wk3;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AudioVoiceSelection {
    public static final String t = "AudioVoiceSelection";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f11950a = null;
    public boolean b = false;
    public AudioManager c = null;
    public Vibrator d = null;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public ImageView i = null;
    public MediaPlayer j = null;
    public boolean k = false;
    public boolean l = false;
    public g m = g.UNKNOWN;
    public AssetFileDescriptor n = null;
    public VoiceRouterType o = VoiceRouterType.SPEAKER;
    public final BroadcastReceiver p = new a();
    public BroadcastReceiver q = new b();
    public AudioManager.OnAudioFocusChangeListener r = new c();
    public f s = null;

    /* JADX INFO: compiled from: SearchBox */
    public enum AudioProfile {
        Normal,
        Bluetooth_offline,
        Audio_only,
        AUTO
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum VoiceRouterType {
        BLUETOOTH,
        SPEAKER,
        HEADSET,
        RECEIVER
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
    public class c implements AudioManager.OnAudioFocusChangeListener {
        public c() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == 1 || i == 3 || i == 2 || i == -1 || i != -3) {
                return;
            }
            AudioVoiceSelection.this.c.adjustStreamVolume(3, -1, 4);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11954a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[VoiceRouterType.values().length];
            c = iArr;
            try {
                iArr[VoiceRouterType.RECEIVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[VoiceRouterType.BLUETOOTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[VoiceRouterType.HEADSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[VoiceRouterType.SPEAKER.ordinal()] = 4;
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
            int[] iArr3 = new int[e.values().length];
            f11954a = iArr3;
            try {
                iArr3[e.ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11954a[e.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11954a[e.DISABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum e {
        ON,
        OFF,
        DISABLE
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends AsyncTask<AudioManager, Integer, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f11955a;

        public f(AudioManager audioManager) {
            this.f11955a = Integer.valueOf(audioManager.getRingerMode());
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
            Log.i(AudioVoiceSelection.t, "Exit the polling RingMode loop.");
            return null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            Integer num = this.f11955a;
            Integer num2 = numArr[0];
            if (num != num2) {
                this.f11955a = num2;
                AudioVoiceSelection audioVoiceSelection = AudioVoiceSelection.this;
                audioVoiceSelection.w(audioVoiceSelection.m);
                Log.i(AudioVoiceSelection.t, "Ring mode change to :" + numArr[0]);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum g {
        UNKNOWN,
        BLUETOOTH,
        SPEAKER,
        HEADSET,
        RECEIVER
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e A[Catch: Exception -> 0x0057, PHI: r0
      0x002e: PHI (r0v5 android.content.res.AssetFileDescriptor) = (r0v2 android.content.res.AssetFileDescriptor), (r0v8 android.content.res.AssetFileDescriptor) binds: [B:30:0x0054, B:15:0x002c] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {Exception -> 0x0057, blocks: (B:14:0x002a, B:16:0x002e, B:29:0x0052, B:4:0x0005, B:6:0x000b), top: B:39:0x0003, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A() {
        AssetFileDescriptor assetFileDescriptor;
        MediaPlayer mediaPlayer = this.j;
        try {
            if (mediaPlayer != null) {
                try {
                    try {
                        if (mediaPlayer.isPlaying()) {
                            this.j.stop();
                            this.j.release();
                            this.j = null;
                            try {
                                Thread.sleep(50L);
                            } catch (Exception unused) {
                            }
                        }
                        assetFileDescriptor = this.n;
                    } finally {
                        if (this.k) {
                            this.d.cancel();
                            this.k = false;
                        }
                        try {
                            AssetFileDescriptor assetFileDescriptor2 = this.n;
                            if (assetFileDescriptor2 != null) {
                                assetFileDescriptor2.close();
                            }
                        } catch (Exception unused2) {
                        }
                    }
                } catch (Exception unused3) {
                    if (this.k) {
                        this.d.cancel();
                        this.k = false;
                    }
                    assetFileDescriptor = this.n;
                    if (assetFileDescriptor != null) {
                    }
                }
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
            }
        } catch (Exception unused4) {
        }
        g();
        this.h = false;
    }

    public void B(AudioProfile audioProfile) {
        try {
            synchronized (this) {
                int i = d.b[audioProfile.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3 || i == 4) {
                            if (o()) {
                                l(VoiceRouterType.BLUETOOTH);
                            } else if (p()) {
                                l(VoiceRouterType.HEADSET);
                            } else {
                                l(this.o);
                            }
                        }
                    } else if (p()) {
                        l(VoiceRouterType.HEADSET);
                    } else {
                        l(this.o);
                    }
                } else if (o()) {
                    l(VoiceRouterType.BLUETOOTH);
                } else if (p()) {
                    l(VoiceRouterType.HEADSET);
                } else {
                    l(VoiceRouterType.RECEIVER);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void C(e eVar) {
        if (this.i == null) {
            return;
        }
        int i = d.f11954a[eVar.ordinal()];
        if (i == 1) {
            this.i.setImageResource(R.drawable.manychats_video_call_handfree_on);
            this.i.setEnabled(true);
            Log.i(t, "switchHandfreeIcon: ON");
        } else if (i == 2) {
            this.i.setImageResource(R.drawable.manychats_video_call_handfree_off);
            this.i.setEnabled(true);
            Log.i(t, "switchHandfreeIcon: OFF");
        } else {
            if (i != 3) {
                return;
            }
            this.i.setImageResource(R.drawable.manychats_video_call_handfree_disable);
            this.i.setEnabled(false);
            Log.i(t, "switchHandfreeIcon: DISABLE");
        }
    }

    public void D(boolean z) {
        this.c.setMode(3);
        if (z) {
            if (o()) {
                l(VoiceRouterType.BLUETOOTH);
            } else {
                l(VoiceRouterType.SPEAKER);
            }
        } else if (p()) {
            l(VoiceRouterType.HEADSET);
        } else {
            l(VoiceRouterType.RECEIVER);
        }
        this.g = z;
    }

    public void E() {
        if (this.f11950a == null) {
            return;
        }
        Log.i(t, "uninitSelection: ");
        this.f11950a.unregisterReceiver(this.p);
        this.f11950a.unregisterReceiver(this.q);
        v();
        g();
        this.h = false;
        this.b = false;
        this.l = false;
        this.d = null;
        this.c = null;
    }

    public void e(Intent intent) {
        String action = intent.getAction();
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
            String str = t;
            Log.i(str, "BroadcasetReceiver 1" + intExtra);
            if (intExtra == 2) {
                this.e = true;
                l(VoiceRouterType.BLUETOOTH);
                Log.i(str, "BroadcastReceiver.BluetoothAdapter.STATE_CONNECTED");
                return;
            } else {
                if (intExtra == 0) {
                    this.e = false;
                    B(AudioProfile.Bluetooth_offline);
                    Log.i(str, "BroadcastReceiver.BluetoothAdapter.STATE_DISCONNECTED");
                    return;
                }
                return;
            }
        }
        if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(action)) {
            int intExtra2 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            Log.i(t, "BroadcasetReceiver 2" + intExtra2);
            if (intExtra2 != 0) {
                if (intExtra2 == 1 || intExtra2 == 2) {
                    this.e = true;
                    l(VoiceRouterType.BLUETOOTH);
                    return;
                }
                return;
            }
            try {
                if (wk3.a()) {
                    return;
                }
                if (this.c.isBluetoothA2dpOn() && this.c.isBluetoothScoOn()) {
                    return;
                }
                this.e = false;
                B(AudioProfile.Bluetooth_offline);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action)) {
            int intExtra3 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
            String str2 = t;
            Log.i(str2, "BroadcastReceiver 3" + intExtra3);
            if (intExtra3 == 2) {
                this.e = true;
                l(VoiceRouterType.BLUETOOTH);
                Log.i(str2, "BroadcastReceiver.BluetoothAdapter.STATE_CONNECTED ");
                return;
            } else {
                if (intExtra3 == 0) {
                    this.e = false;
                    B(AudioProfile.Bluetooth_offline);
                    Log.i(str2, "BroadcastReceiver.BluetoothAdapter.STATE_DISCONNECTED");
                    return;
                }
                return;
            }
        }
        if (!"android.intent.action.HEADSET_PLUG".equals(action)) {
            Log.i(t, "BroadcasetReceiver 5:" + action);
            return;
        }
        Log.i(t, "BroadcasetReceiver 4");
        if (intent.getIntExtra(LocationConst.HDYawConst.KEY_HD_YAW_STATE, 0) == 0) {
            this.l = false;
            this.f = false;
            B(AudioProfile.AUTO);
        } else if (intent.getIntExtra(LocationConst.HDYawConst.KEY_HD_YAW_STATE, 0) == 1) {
            this.f = true;
            if (!this.l) {
                l(VoiceRouterType.HEADSET);
                return;
            }
            if (this.e) {
                l(VoiceRouterType.BLUETOOTH);
            }
            this.l = false;
        }
    }

    public final void f() {
        if (this.b) {
            return;
        }
        A();
    }

    public final void g() {
        f fVar = this.s;
        if (fVar != null) {
            if (!fVar.isCancelled()) {
                this.s.cancel(false);
            }
            this.s = null;
        }
    }

    public void h() {
        Log.i(t, "BroadcastReceiver changeToBluetooth");
        try {
            if (!this.h) {
                this.c.setMode(3);
            }
            if (!this.h) {
                if (!this.c.isBluetoothScoOn()) {
                    this.c.startBluetoothSco();
                    this.c.setBluetoothScoOn(true);
                }
                this.c.setSpeakerphoneOn(false);
            }
            g gVar = g.BLUETOOTH;
            w(gVar);
            this.m = gVar;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void i() {
        Log.i(t, "BroadcastReceiver changeToHeadset");
        try {
            if (!this.h) {
                this.c.setMode(3);
            }
            if (!this.h && this.c.isBluetoothScoOn()) {
                this.c.stopBluetoothSco();
                this.c.setBluetoothScoOn(false);
            }
            this.c.setSpeakerphoneOn(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        g gVar = g.HEADSET;
        w(gVar);
        this.m = gVar;
    }

    public void j() {
        Log.i(t, "BroadcastReceiver changeToReceiver");
        try {
            if (this.h) {
                this.c.setSpeakerphoneOn(false);
            } else {
                this.c.stopBluetoothSco();
                this.c.setBluetoothScoOn(false);
                this.c.setSpeakerphoneOn(false);
            }
            if (!this.h) {
                this.c.setMode(3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.m = g.RECEIVER;
    }

    public void k() {
        Log.i(t, "BroadcastReceiver changeToSpeaker");
        try {
            if (!this.h) {
                this.c.setMode(3);
            } else if (Build.BRAND.toLowerCase().equals("redmi")) {
                this.c.setMode(0);
            } else {
                this.c.setMode(0);
            }
            if (this.h) {
                this.c.setSpeakerphoneOn(true);
            } else {
                this.c.stopBluetoothSco();
                this.c.setBluetoothScoOn(false);
                this.c.setSpeakerphoneOn(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        g gVar = g.SPEAKER;
        w(gVar);
        this.m = gVar;
        Log.i(t, "after BroadcastReceiver changeToSpeaker");
    }

    public void l(VoiceRouterType voiceRouterType) {
        int i = d.c[voiceRouterType.ordinal()];
        if (i == 1) {
            Log.i(t, "changeVoiceRouter: RECEIVER");
            j();
            C(e.OFF);
            this.g = false;
            return;
        }
        if (i == 2) {
            Log.i(t, "changeVoiceRouter: BLUETOOTH");
            h();
            C(e.DISABLE);
            this.g = false;
            return;
        }
        if (i == 3) {
            Log.i(t, "changeVoiceRouter: HEADSET");
            i();
            C(e.DISABLE);
            this.g = false;
            return;
        }
        if (i != 4) {
            return;
        }
        Log.i(t, "changeVoiceRouter: SPEAKER");
        k();
        this.g = true;
        C(e.ON);
    }

    public void m(Context context, boolean z, ImageView imageView) {
        if (context == null) {
            return;
        }
        this.f11950a = context;
        this.b = z;
        this.c = (AudioManager) context.getSystemService("audio");
        this.d = (Vibrator) this.f11950a.getSystemService("vibrator");
        this.i = imageView;
        this.f11950a.registerReceiver(this.p, new IntentFilter("android.intent.action.SCREEN_OFF"));
        IntentFilter intentFilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.f11950a.registerReceiver(this.q, intentFilter);
        this.f = this.c.isWiredHeadsetOn();
        boolean z2 = false;
        boolean z3 = this.c.isBluetoothA2dpOn() || this.c.isBluetoothScoOn();
        this.e = z3;
        if (z3 && this.f) {
            z2 = true;
        }
        this.l = z2;
        this.h = true;
        z();
    }

    public boolean n() {
        return this.g;
    }

    public boolean o() {
        boolean zIsBluetoothA2dpOn = this.c.isBluetoothA2dpOn();
        boolean zIsBluetoothScoOn = this.c.isBluetoothScoOn();
        wk3.a();
        return this.e || zIsBluetoothA2dpOn || zIsBluetoothScoOn;
    }

    public boolean p() {
        return this.f;
    }

    public void q() {
        boolean z = this.e || this.f;
        if (RTCParameters.m()) {
            wk3.b(this.f11950a, "sound/close.wav", z, null);
        } else {
            wk3.b(this.f11950a, "sound/close.mp3", z, null);
        }
    }

    public void r() {
        boolean z = this.e || this.f;
        if (RTCParameters.m()) {
            wk3.b(this.f11950a, "sound/close.wav", z, null);
        } else {
            wk3.b(this.f11950a, "sound/close.mp3", z, null);
        }
    }

    public void s() {
        wk3.b(this.f11950a, "sound/call_interrupt.mp3", this.e || this.f, null);
    }

    public void t() {
        String str = RTCParameters.m() ? "sound/spring_ding_dong.mp3" : "sound/voip_ringtone.mp3";
        if (this.j == null) {
            this.j = new MediaPlayer();
        }
        String str2 = Build.BRAND;
        if (!TextUtils.isEmpty(str2) && str2.toLowerCase().equals(AssistUtils.BRAND_MZ)) {
            this.j.setAudioStreamType(3);
        } else if (!TextUtils.isEmpty(str2) && str2.toLowerCase().equals("oneplus")) {
            this.j.setAudioStreamType(1);
        } else if (!TextUtils.isEmpty(str2) && str2.toLowerCase().equals("huawei")) {
            this.j.setAudioStreamType(0);
        } else if (!TextUtils.isEmpty(str2) && str2.toLowerCase().equals("xiaomi")) {
            this.j.setAudioStreamType(3);
        } else if (!TextUtils.isEmpty(str2) && str2.toLowerCase().equals("redmi")) {
            this.j.setAudioStreamType(0);
        } else if (!TextUtils.isEmpty(str2) && str2.toLowerCase().equals("vivo")) {
            this.j.setAudioStreamType(0);
        } else if (TextUtils.isEmpty(str2) || !str2.toLowerCase().equals("oppo")) {
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().equals("realme")) {
                this.j.setAudioStreamType(3);
            } else {
                this.j.setAudioStreamType(0);
            }
        } else if (Build.VERSION.SDK_INT <= 26) {
            this.j.setAudioStreamType(3);
        } else {
            this.j.setAudioStreamType(0);
        }
        this.j.setLooping(true);
        this.n = null;
        try {
            AssetFileDescriptor assetFileDescriptorOpenFd = this.f11950a.getAssets().openFd(str);
            this.n = assetFileDescriptorOpenFd;
            this.j.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), this.n.getStartOffset(), this.n.getLength());
            this.j.prepare();
            this.j.start();
            if (y()) {
                this.d.vibrate(new long[]{1000, 1000}, 0);
                this.k = true;
                if (!this.b) {
                    w(this.m);
                }
            }
            this.h = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            this.j.stop();
            this.j.release();
            this.j = null;
            AssetFileDescriptor assetFileDescriptor = this.n;
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            g();
            this.h = false;
        }
    }

    public boolean u() {
        return this.c.requestAudioFocus(this.r, 3, 2) == 1;
    }

    public void v() {
        AudioManager audioManager = this.c;
        if (audioManager != null) {
            audioManager.setBluetoothScoOn(false);
            this.c.stopBluetoothSco();
            this.c.setMode(0);
            this.c.setBluetoothScoOn(false);
            try {
                Thread.sleep(50L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.c.stopBluetoothSco();
            this.c.abandonAudioFocus(this.r);
        }
    }

    public final void w(g gVar) {
        if (this.b || !this.h || this.j == null) {
            return;
        }
        int streamVolume = this.c.getStreamVolume(2);
        int ringerMode = this.c.getRingerMode();
        if (gVar != g.SPEAKER) {
            this.j.setVolume(1.0f, 1.0f);
        } else if (ringerMode != 2 || streamVolume <= 0) {
            this.j.setVolume(0.0f, 0.0f);
        } else {
            this.j.setVolume(1.0f, 1.0f);
        }
    }

    public void x(VoiceRouterType voiceRouterType) {
        this.o = voiceRouterType;
        if (voiceRouterType == VoiceRouterType.RECEIVER) {
            this.c.setMode(3);
        }
    }

    public final boolean y() {
        return !this.b && this.d.hasVibrator() && this.c.getRingerMode() == 1;
    }

    public final void z() {
        if (this.b) {
            return;
        }
        g();
        f fVar = new f(this.c);
        this.s = fVar;
        fVar.execute(this.c);
    }
}
