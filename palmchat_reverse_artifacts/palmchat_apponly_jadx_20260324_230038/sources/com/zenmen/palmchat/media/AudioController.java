package com.zenmen.palmchat.media;

import android.content.ContentValues;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.ttvecamera.TECameraUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.be1;
import defpackage.fn2;
import defpackage.ho3;
import defpackage.im;
import defpackage.ir5;
import defpackage.kk;
import defpackage.nv;
import defpackage.ow5;
import defpackage.pu1;
import defpackage.rl0;
import defpackage.sy5;
import defpackage.vk3;
import defpackage.vp3;
import defpackage.xn3;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AudioController implements SensorEventListener {
    public static int[] P = new int[3];
    public static final String Q = "AudioController";
    public static volatile AudioController R;
    public PowerManager A;
    public PowerManager.WakeLock B;
    public Sensor C;
    public q G;
    public MessageVo M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public be1 f14623a;
    public be1 b;
    public be1 c;
    public be1 d;
    public ByteBuffer h;
    public int i;
    public int j;
    public long o;
    public long p;
    public fn2 r;
    public MessageVo u;
    public AudioManager y;
    public SensorManager z;
    public ArrayList<ByteBuffer> e = new ArrayList<>();
    public ArrayList<o> f = new ArrayList<>();
    public ArrayList<o> g = new ArrayList<>();
    public boolean k = false;
    public AudioRecord l = null;
    public AudioObject m = null;
    public File n = null;
    public boolean q = false;
    public MediaPlayer s = null;
    public AudioTrack t = null;
    public boolean v = false;
    public final Object w = new Object();
    public final Object x = new Object();
    public final nv E = new nv(ow5.f19890a);
    public boolean F = false;
    public boolean H = false;
    public int I = 0;
    public boolean J = false;
    public Runnable K = new g();
    public HashMap<String, Integer> L = new HashMap<>();
    public boolean N = false;
    public AudioManager.OnAudioFocusChangeListener O = new e();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar;
            if (AudioController.this.q) {
                AudioController.this.U();
                return;
            }
            boolean z = false;
            while (true) {
                synchronized (AudioController.this.w) {
                    if (AudioController.this.g.isEmpty()) {
                        oVar = null;
                    } else {
                        oVar = (o) AudioController.this.g.get(0);
                        AudioController.this.g.remove(0);
                    }
                    if (!AudioController.this.f.isEmpty()) {
                        z = true;
                    }
                }
                if (oVar == null) {
                    break;
                }
                AudioController audioController = AudioController.this;
                audioController.readOpusFile(oVar.f14640a, audioController.j, AudioController.P);
                int[] iArr = AudioController.P;
                oVar.c = iArr[0];
                oVar.e = iArr[1];
                int i = iArr[2];
                oVar.d = i;
                if (i == 1) {
                    AudioController.this.q = true;
                }
                if (oVar.c == 0) {
                    synchronized (AudioController.this.w) {
                        AudioController.this.g.add(oVar);
                    }
                    break;
                } else {
                    oVar.f14640a.rewind();
                    oVar.f14640a.get(oVar.b);
                    synchronized (AudioController.this.w) {
                        AudioController.this.f.add(oVar);
                    }
                    z = true;
                }
            }
            if (z) {
                AudioController.this.U();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AudioController.this.v = false;
                if (AudioController.this.z == null || AudioController.this.C == null) {
                    return;
                }
                SensorManager sensorManager = AudioController.this.z;
                AudioController audioController = AudioController.this;
                sensorManager.unregisterListener(audioController, audioController.C);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AudioController.this.z == null || AudioController.this.C == null) {
                    return;
                }
                SensorManager sensorManager = AudioController.this.z;
                AudioController audioController = AudioController.this;
                sensorManager.registerListener(audioController, audioController.C, 3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("action", "send_message");
            put("status", "sendAudio");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements AudioManager.OnAudioFocusChangeListener {
        public e() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Log.d(AudioController.Q, "onAudioFocusChange :" + i);
            if (i == -3 || i == -2 || i == -1) {
                AudioController.this.D0();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14629a;

        public f(String str) {
            this.f14629a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AudioController.this.l != null) {
                return;
            }
            AudioController.this.m = new AudioObject();
            AudioController.this.m.setMimeType("audio/ogg");
            AudioController.this.m.setDate(ir5.b());
            AudioController.this.m.setTarget(this.f14629a);
            pu1.t();
            File file = new File(pu1.g);
            if (!file.exists() && !file.mkdir()) {
                LogUtil.e(AudioController.Q, "mkdir error");
            }
            AudioController audioController = AudioController.this;
            audioController.n = audioController.f0();
            AudioController.this.m.setPath(AudioController.this.n.getAbsolutePath());
            try {
                AudioController audioController2 = AudioController.this;
                if (audioController2.startRecord(audioController2.n.getAbsolutePath()) == 0) {
                    return;
                }
                AudioController.this.l = new AudioRecord(1, 16000, 16, 2, AudioController.this.i * 10);
                AudioController.this.o = System.currentTimeMillis();
                AudioController.this.p = 0L;
                AudioController.this.h.rewind();
                AudioController.this.u0();
                AudioController.this.l.startRecording();
                AudioController.this.c.a(AudioController.this.K);
            } catch (Exception e) {
                e.printStackTrace();
                AudioController.this.m = null;
                AudioController.this.stopRecord();
                AudioController.this.J = false;
                AudioController.this.n.delete();
                AudioController.this.n = null;
                try {
                    AudioController.this.l.release();
                    AudioController.this.l = null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                AudioController.this.E.i(new kk());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ByteBuffer f14631a;
            public final /* synthetic */ boolean b;

            /* JADX INFO: renamed from: com.zenmen.palmchat.media.AudioController$g$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class RunnableC1074a implements Runnable {
                public RunnableC1074a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AudioController.this.e.add(a.this.f14631a);
                }
            }

            public a(ByteBuffer byteBuffer, boolean z) {
                this.f14631a = byteBuffer;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                int iLimit;
                while (this.f14631a.hasRemaining()) {
                    if (this.f14631a.remaining() > AudioController.this.h.remaining()) {
                        iLimit = this.f14631a.limit();
                        this.f14631a.limit(AudioController.this.h.remaining() + this.f14631a.position());
                    } else {
                        iLimit = -1;
                    }
                    AudioController.this.h.put(this.f14631a);
                    if (AudioController.this.h.position() == AudioController.this.h.limit() || this.b) {
                        AudioController audioController = AudioController.this;
                        if (audioController.writeFrame(audioController.h, !this.b ? AudioController.this.h.limit() : this.f14631a.position()) != 0) {
                            AudioController.this.h.rewind();
                            AudioController.this.p += (long) ((AudioController.this.h.limit() / 2) / 16);
                        }
                    }
                    if (iLimit != -1) {
                        this.f14631a.limit(iLimit);
                    }
                }
                AudioController.this.c.a(new RunnableC1074a());
            }
        }

        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer byteBufferAllocateDirect;
            if (AudioController.this.l != null) {
                if (AudioController.this.e.isEmpty()) {
                    byteBufferAllocateDirect = ByteBuffer.allocateDirect(AudioController.this.i);
                } else {
                    byteBufferAllocateDirect = (ByteBuffer) AudioController.this.e.get(0);
                    AudioController.this.e.remove(0);
                }
                byteBufferAllocateDirect.rewind();
                int i = AudioController.this.l.read(byteBufferAllocateDirect, byteBufferAllocateDirect.capacity());
                if (i <= 0) {
                    AudioController.this.e.add(byteBufferAllocateDirect);
                    AudioController.this.J0(false, 0);
                    AudioController.this.E.i(new kk());
                } else {
                    byteBufferAllocateDirect.limit(i);
                    boolean z = i != byteBufferAllocateDirect.capacity();
                    if (i != 0) {
                        AudioController.this.E.i(AudioController.this.s0(AudioController.k0(byteBufferAllocateDirect.get(0), byteBufferAllocateDirect.get(1))));
                        AudioController.this.d.a(new a(byteBufferAllocateDirect, z));
                    }
                    AudioController.this.c.a(AudioController.this.K);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14633a;
        public final /* synthetic */ int b;

        public h(boolean z, r rVar, int i) {
            this.f14633a = z;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            AudioController.this.stopRecord();
            if (this.f14633a) {
                AudioController audioController = AudioController.this;
                audioController.t0(audioController.m, this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14634a;
        public final /* synthetic */ int b;

        public i(boolean z, int i, r rVar) {
            this.f14634a = z;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AudioController.this.m != null) {
                AudioController.this.m.setDuration((int) AudioController.this.g0());
            }
            if (AudioController.this.l == null) {
                return;
            }
            try {
                AudioController.this.l.stop();
            } catch (Exception e) {
                e.printStackTrace();
                if (AudioController.this.n != null) {
                    AudioController.this.n.delete();
                }
            }
            AudioController.this.K0(this.f14634a, this.b, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Boolean[] f14635a;
        public final /* synthetic */ File b;
        public final /* synthetic */ Semaphore c;

        public j(Boolean[] boolArr, File file, Semaphore semaphore) {
            this.f14635a = boolArr;
            this.b = file;
            this.c = semaphore;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14635a[0] = Boolean.valueOf(AudioController.this.openOpusFile(this.b.getAbsolutePath()) != 0);
            this.c.release();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements MediaPlayer.OnCompletionListener {
        public l() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            AudioController.this.E0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f14638a;

        public m(MessageVo messageVo) {
            this.f14638a = messageVo;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int iI0 = AudioController.this.i0(this.f14638a.mid);
                int iMin = Math.min((!TextUtils.isEmpty(this.f14638a.data1) ? AudioController.a0(Long.valueOf(this.f14638a.data1).longValue()) : 1) + 90, 99);
                if (iI0 >= iMin) {
                    iI0 = iMin;
                }
                float f = (iI0 < 0 || iI0 > 100) ? 0.0f : iI0 / 100.0f;
                AudioController.this.I = (int) (r1.getTotalPcmDuration() * f);
                AudioController.this.seekOpusFile(f);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (AudioController.this.w) {
                AudioController.this.g.addAll(AudioController.this.f);
                AudioController.this.f.clear();
            }
            AudioController.this.q = false;
            AudioController.this.U();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iWrite;
            o oVar;
            synchronized (AudioController.this.x) {
                if (AudioController.this.l0()) {
                    synchronized (AudioController.this.w) {
                        iWrite = 0;
                        if (AudioController.this.f.isEmpty()) {
                            oVar = null;
                        } else {
                            oVar = (o) AudioController.this.f.get(0);
                            AudioController.this.f.remove(0);
                        }
                    }
                    if (oVar != null) {
                        try {
                            iWrite = AudioController.this.t.write(oVar.b, 0, oVar.c);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (iWrite > 0) {
                            if ((oVar.d == 1 ? oVar.c : -1) != -1 && AudioController.this.t != null) {
                                try {
                                    AudioController.this.t.setNotificationMarkerPosition(1);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (oVar.d != 1) {
                            AudioController.this.U();
                        }
                    }
                    if (oVar == null || oVar.d != 1) {
                        AudioController.this.T();
                    }
                    if (oVar != null) {
                        synchronized (AudioController.this.w) {
                            AudioController.this.g.add(oVar);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ByteBuffer f14640a;
        public byte[] b;
        public int c;
        public int d;
        public long e;

        public o(int i) {
            this.f14640a = ByteBuffer.allocateDirect(i);
            this.b = new byte[i];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class p {
        public static int d = 1;
        public static int e = 2;
        public static int f = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14641a;
        public int b = 0;
        public int c = 0;
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface q {
        void a();

        void b(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface r {
    }

    public AudioController() {
        this.j = 0;
        try {
            int minBufferSize = AudioRecord.getMinBufferSize(16000, 16, 2);
            this.i = minBufferSize;
            if (minBufferSize <= 0) {
                this.i = 1280;
            }
            int minBufferSize2 = AudioTrack.getMinBufferSize(48000, 4, 2);
            this.j = minBufferSize2;
            if (minBufferSize2 <= 0) {
                this.j = 3840;
            }
            for (int i2 = 0; i2 < 5; i2++) {
                this.e.add(ByteBuffer.allocateDirect(4096));
            }
            for (int i3 = 0; i3 < 3; i3++) {
                this.g.add(new o(this.j));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.h = ByteBuffer.allocateDirect(TECameraUtils.CAPTURE_NORMAL);
        be1 be1Var = new be1("recordQueue");
        this.c = be1Var;
        be1Var.setPriority(10);
        be1 be1Var2 = new be1("fileEncodingQueue");
        this.d = be1Var2;
        be1Var2.setPriority(10);
        this.b = new be1("playerQueue");
        this.f14623a = new be1("fileDecodingQueue");
        try {
            this.y = (AudioManager) AppContext.getContext().getSystemService("audio");
            SensorManager sensorManager = (SensorManager) AppContext.getContext().getSystemService("sensor");
            this.z = sensorManager;
            this.C = sensorManager.getDefaultSensor(8);
            PowerManager powerManager = (PowerManager) AppContext.getContext().getSystemService("power");
            this.A = powerManager;
            this.B = powerManager.newWakeLock(32, Q);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static boolean N0() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.AUDIONEWUI);
        if (dynamicConfig != null) {
            return dynamicConfig.isEnable();
        }
        return false;
    }

    public static String X() {
        return xn3.a() + ".ogg";
    }

    public static String Y() {
        String strA = xn3.a();
        int iAbs = Math.abs(strA.hashCode() % 20000);
        StringBuilder sb = new StringBuilder();
        sb.append(pu1.g);
        String str = File.separator;
        sb.append(str);
        sb.append(iAbs);
        File file = new File(sb.toString());
        if (!file.exists() && !file.mkdir()) {
            LogUtil.e(Q, "mkdir error");
        }
        return iAbs + str + strA + ".ogg";
    }

    public static int a0(long j2) {
        return Math.min(Math.max(Math.round(Float.valueOf(j2).floatValue() / 1000.0f), 1), 60);
    }

    public static AudioController b0() {
        AudioController audioController = R;
        if (audioController == null) {
            synchronized (AudioController.class) {
                audioController = R;
                if (audioController == null) {
                    audioController = new AudioController();
                    R = audioController;
                }
            }
        }
        return audioController;
    }

    private native void closeOpusFile();

    /* JADX INFO: Access modifiers changed from: private */
    public native long getTotalPcmDuration();

    private native int isOpusFile(String str);

    public static float k0(byte b2, byte b3) {
        return ByteBuffer.wrap(new byte[]{0, 0, b2, b3}).order(ByteOrder.BIG_ENDIAN).getInt() / 65535.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int openOpusFile(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void readOpusFile(ByteBuffer byteBuffer, int i2, int[] iArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int seekOpusFile(float f2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int startRecord(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void stopRecord();

    public static void v0(DBUriManager.MsgSaveType msgSaveType, int i2) {
        String[] strArr = {String.valueOf(1)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("only_update_msg", Boolean.TRUE);
        contentValues.put("attachment_read", (Integer) 0);
        AppContext.getContext().getContentResolver().update(DBUriManager.d(ho3.class, msgSaveType), contentValues, "_id >=" + i2 + " AND attachment_read=?", strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int writeFrame(ByteBuffer byteBuffer, int i2);

    public final void A0(boolean z) {
        if (this.N) {
            try {
                if (z) {
                    PowerManager.WakeLock wakeLock = this.B;
                    if (wakeLock != null && !this.F) {
                        wakeLock.acquire();
                        this.F = true;
                    }
                } else {
                    PowerManager.WakeLock wakeLock2 = this.B;
                    if (wakeLock2 != null && this.F) {
                        wakeLock2.release();
                        this.F = false;
                    }
                }
            } catch (Exception e2) {
                LogUtil.e(Q, e2.toString());
            }
        }
    }

    public void B0() {
        this.N = true;
        this.b.a(new c());
    }

    public void C0(String str, fn2 fn2Var) {
        D0();
        try {
            ((Vibrator) AppContext.getContext().getSystemService("vibrator")).vibrate(50L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.J = true;
        this.r = fn2Var;
        this.c.a(new f(str));
    }

    public void D0() {
        V();
        if (this.u != null) {
            b0().L0(this.u, 0);
            this.u = null;
        }
        this.k = false;
        this.G = null;
    }

    public void E0() {
        V();
        if (this.u != null) {
            b0().L0(this.u, 0);
            this.u = null;
        }
        this.k = false;
        q qVar = this.G;
        if (qVar != null) {
            qVar.a();
        }
        W();
        vk3.c(AppContext.getContext(), "sound/play_completed.mp3", this.v || this.H, null);
    }

    public void F0(MessageVo messageVo) {
        this.M = this.u;
        V();
        this.u = null;
        this.k = false;
        this.G = null;
        MessageVo messageVo2 = this.M;
        if (messageVo2 == null) {
            W();
        } else if (messageVo.mid.equals(messageVo2.mid)) {
            W();
        } else {
            x0(this.M.mid, 0);
        }
    }

    public void G0() {
        this.N = false;
        this.b.b(new b(), 100L);
    }

    public void H0(boolean z, int i2) {
        I0(z, i2, null);
    }

    public void I0(boolean z, int i2, r rVar) {
        this.J = false;
        this.c.a(new i(z, i2, rVar));
    }

    public final void J0(boolean z, int i2) {
        K0(z, i2, null);
    }

    public final void K0(boolean z, int i2, r rVar) {
        this.d.a(new h(z, rVar, i2));
        try {
            AudioRecord audioRecord = this.l;
            if (audioRecord != null) {
                audioRecord.release();
                this.l = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        S();
        this.n = null;
    }

    public void L0(MessageVo messageVo, int i2) {
        String[] strArr = {messageVo.mid};
        ContentValues contentValues = new ContentValues();
        contentValues.put("only_update_msg", Boolean.TRUE);
        contentValues.put("attachment_read", Integer.valueOf(i2));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", strArr);
    }

    public void M0() {
        if (this.M != null) {
            b0().L0(this.M, 0);
            this.M = null;
        }
    }

    public final void S() {
        this.y.abandonAudioFocus(this.O);
    }

    public final void T() {
        this.f14623a.a(new a());
    }

    public final void U() {
        this.b.a(new n());
    }

    public final void V() {
        this.I = 0;
        MediaPlayer mediaPlayer = this.s;
        if (mediaPlayer == null && this.t == null) {
            return;
        }
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                this.s.release();
                this.s = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else if (this.t != null) {
            synchronized (this.x) {
                try {
                    this.t.pause();
                    this.t.flush();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                try {
                    this.t.release();
                    this.t = null;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
        S();
    }

    public void W() {
        this.L.clear();
    }

    public nv Z() {
        return this.E;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v19, types: [int] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [int] */
    /* JADX WARN: Type inference failed for: r7v7, types: [android.media.MediaPlayer] */
    /* JADX WARN: Type inference failed for: r7v8 */
    public int c0(String str) {
        ?? currentPosition;
        MessageVo messageVo = this.u;
        int i2 = -1;
        if (messageVo != null && messageVo.mid.equals(str)) {
            try {
                currentPosition = this.s;
                try {
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                currentPosition = -1;
            }
            if (currentPosition == 0 || !currentPosition.isPlaying()) {
                AudioTrack audioTrack = this.t;
                if (audioTrack == null || audioTrack.getPlayState() != 3) {
                    currentPosition = -1;
                    LogUtil.i("AudioController", "position=" + currentPosition + " result=" + i2);
                } else {
                    int playbackHeadPosition = this.t.getPlaybackHeadPosition() + this.I;
                    long totalPcmDuration = getTotalPcmDuration();
                    currentPosition = playbackHeadPosition;
                    if (playbackHeadPosition >= 0) {
                        currentPosition = playbackHeadPosition;
                        if (totalPcmDuration > 0) {
                            i2 = (int) (((playbackHeadPosition * 1.0f) / totalPcmDuration) * 100.0f);
                            currentPosition = playbackHeadPosition;
                        }
                    }
                    LogUtil.i("AudioController", "position=" + currentPosition + " result=" + i2);
                }
            } else {
                currentPosition = this.s.getCurrentPosition();
                if (currentPosition >= 0) {
                    String str2 = this.u.data1;
                    currentPosition = currentPosition;
                    if (!TextUtils.isEmpty(str2)) {
                        long jLongValue = Long.valueOf(str2).longValue();
                        currentPosition = currentPosition;
                        if (jLongValue > 0) {
                            i2 = (int) ((currentPosition * 100) / jLongValue);
                            currentPosition = currentPosition;
                        }
                    }
                }
                LogUtil.i("AudioController", "position=" + currentPosition + " result=" + i2);
            }
        }
        return i2;
    }

    public MessageVo d0() {
        return this.u;
    }

    public File e0() {
        return this.n;
    }

    public final File f0() {
        File file = new File(pu1.g + File.separator + Math.abs(xn3.a().hashCode() % 20000));
        if (!file.exists() && !file.mkdir()) {
            LogUtil.e(Q, "mkdir error");
        }
        return new File(file, X());
    }

    public long g0() {
        AudioRecord audioRecord = this.l;
        if (audioRecord == null || audioRecord.getRecordingState() != 3) {
            return 0L;
        }
        return System.currentTimeMillis() - this.o;
    }

    public long h0(boolean z) {
        if (this.l == null || !z) {
            return 0L;
        }
        return System.currentTimeMillis() - this.o;
    }

    public int i0(String str) {
        return j0(str, 0);
    }

    public int j0(String str, int i2) {
        Integer num = this.L.get(str);
        return num != null ? num.intValue() : i2;
    }

    public boolean l0() {
        AudioTrack audioTrack = this.t;
        return audioTrack != null && audioTrack.getPlayState() == 3;
    }

    public final boolean m0(SensorEvent sensorEvent) {
        return n0() ? sensorEvent.values[0] == 0.0f : sensorEvent.values[0] < this.C.getMaximumRange();
    }

    public final boolean n0() {
        return Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") && Build.MODEL.equalsIgnoreCase("MI-4c");
    }

    public boolean o0(String str) {
        MessageVo messageVo = this.u;
        if (messageVo != null && messageVo.mid.equals(str)) {
            MediaPlayer mediaPlayer = this.s;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                return true;
            }
            AudioTrack audioTrack = this.t;
            if (audioTrack != null && audioTrack.getPlayState() == 3) {
                return true;
            }
        }
        return false;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean zM0 = m0(sensorEvent);
        if ((this.t == null && this.s == null) || this.k || this.v == zM0 || this.y.isWiredHeadsetOn() || vk3.a()) {
            this.v = zM0;
            if (zM0) {
                return;
            }
            A0(zM0);
            return;
        }
        this.v = zM0;
        if (!this.H) {
            q0(this.u, this.G);
            q qVar = this.G;
            if (qVar != null) {
                qVar.b(this.v);
            }
        }
        A0(this.v);
    }

    public boolean p0() {
        W();
        if (!this.F) {
            z = this.u != null;
            D0();
        }
        return z;
    }

    public boolean q0(MessageVo messageVo, q qVar) {
        MessageVo messageVo2;
        if (this.J || messageVo == null) {
            return false;
        }
        if (l0()) {
            x0(messageVo.mid, (int) (((long) ((this.t.getPlaybackHeadPosition() + this.I) * 100)) / getTotalPcmDuration()));
        }
        File file = new File(messageVo.data2);
        if (this.r != null && AudioDownloader.isAudioMd5Wrong(file, messageVo.data4, true)) {
            sy5.e(AppContext.getContext(), R.string.audio_file_broken, 0).g();
            L0(messageVo, 0);
            file.delete();
            try {
                this.r.l(messageVo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
            return false;
        }
        this.G = qVar;
        if (!messageVo.isRead) {
            b0().z0(messageVo);
        }
        b0().L0(messageVo, 1);
        if ((this.t != null || this.s != null) && (messageVo2 = this.u) != null && !messageVo2.mid.equals(messageVo.mid)) {
            if (this.k) {
                w0(messageVo);
            }
            return true;
        }
        V();
        if (isOpusFile(file.getAbsolutePath()) == 1) {
            synchronized (this.x) {
                try {
                    try {
                        Semaphore semaphore = new Semaphore(0);
                        Boolean[] boolArr = new Boolean[1];
                        this.f14623a.a(new j(boolArr, file, semaphore));
                        semaphore.acquire();
                        if (!boolArr[0].booleanValue()) {
                            return false;
                        }
                        boolean zB = vk3.b();
                        if (this.v || this.H) {
                            this.y.setSpeakerphoneOn(false);
                        } else {
                            this.y.setSpeakerphoneOn(true);
                        }
                        AudioTrack audioTrack = new AudioTrack((this.v || this.H || zB) ? 0 : 3, 48000, 4, 2, this.j, 1);
                        this.t = audioTrack;
                        audioTrack.setStereoVolume(1.0f, 1.0f);
                        this.t.setPlaybackPositionUpdateListener(new k());
                        u0();
                        this.t.play();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        AudioTrack audioTrack2 = this.t;
                        if (audioTrack2 != null) {
                            audioTrack2.release();
                            this.t = null;
                            this.k = false;
                            this.u = null;
                        }
                        return false;
                    }
                } finally {
                }
            }
        } else {
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.s = mediaPlayer;
                mediaPlayer.setAudioStreamType(this.v ? 0 : 3);
                this.s.setDataSource(file.getAbsolutePath());
                this.s.setOnCompletionListener(new l());
                this.s.prepare();
                u0();
                this.s.start();
            } catch (Exception e4) {
                e4.printStackTrace();
                MediaPlayer mediaPlayer2 = this.s;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.release();
                    this.s = null;
                    this.k = false;
                    this.u = null;
                }
                return false;
            }
        }
        this.k = false;
        this.u = messageVo;
        MediaPlayer mediaPlayer3 = this.s;
        if (mediaPlayer3 != null) {
            try {
                mediaPlayer3.seekTo(0);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        } else if (this.t != null) {
            this.f14623a.a(new m(messageVo));
        }
        return true;
    }

    public boolean r0(MessageVo messageVo, q qVar, fn2 fn2Var) {
        this.r = fn2Var;
        return q0(messageVo, qVar);
    }

    public im s0(float f2) {
        return new im(f2);
    }

    public final void t0(AudioObject audioObject, int i2) {
        String strA = xn3.a();
        if (audioObject == null || TextUtils.isEmpty(audioObject.getTarget()) || audioObject.getDuration() < 1000) {
            return;
        }
        try {
            audioObject.setMessageId(strA);
            this.r.r(MessageVo.buildAudioMessage(audioObject, 0).setThreadBizType(AppContext.getContext(), i2));
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(Q, 3, new d(), e2);
        }
    }

    public final void u0() {
        if (vp3.g()) {
            return;
        }
        this.y.requestAudioFocus(this.O, 0, 2);
    }

    public boolean w0(MessageVo messageVo) {
        MessageVo messageVo2;
        if ((this.t != null || this.s != null) && messageVo != null && (messageVo2 = this.u) != null && (messageVo2 == null || messageVo2.mid.equals(messageVo.mid))) {
            try {
                MediaPlayer mediaPlayer = this.s;
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                } else {
                    AudioTrack audioTrack = this.t;
                    if (audioTrack != null) {
                        audioTrack.play();
                        U();
                    }
                }
                this.k = false;
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public void x0(String str, int i2) {
        this.L.clear();
        this.L.put(str, Integer.valueOf(i2));
    }

    public void y0(boolean z) {
        MessageVo messageVo;
        this.H = z;
        if ((this.t == null && this.s == null) || this.k || this.y.isWiredHeadsetOn() || vk3.a() || (messageVo = this.u) == null) {
            return;
        }
        q0(messageVo, this.G);
    }

    public void z0(MessageVo messageVo) {
        String[] strArr = {messageVo.mid};
        ContentValues contentValues = new ContentValues();
        contentValues.put("read", (Integer) 1);
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", strArr);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements AudioTrack.OnPlaybackPositionUpdateListener {
        public k() {
        }

        @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
        public void onMarkerReached(AudioTrack audioTrack) {
            AudioController.this.E0();
        }

        @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
        public void onPeriodicNotification(AudioTrack audioTrack) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }
}
