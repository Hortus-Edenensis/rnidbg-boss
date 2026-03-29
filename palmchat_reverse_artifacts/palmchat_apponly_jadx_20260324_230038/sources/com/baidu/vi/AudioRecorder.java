package com.baidu.vi;

import android.annotation.SuppressLint;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AudioRecorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private static Handler f4290a = new a();
    private volatile AudioRecord b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private int g;
    private int h;
    private volatile boolean i = false;
    private Object j = new Object();
    private Thread k = new b(AudioRecorder.class.getSimpleName() + "-Record");

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AudioRecorder audioRecorder = ((c) message.obj).f4292a;
            int i = message.what;
            if (i != 1) {
                if (i == 2 && audioRecorder.i) {
                    audioRecorder.onReadError();
                    return;
                }
                return;
            }
            if (audioRecorder.i) {
                c cVar = (c) message.obj;
                audioRecorder.onReadData(cVar.b, cVar.c);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Thread {
        public b(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            AudioRecorder.this.b.startRecording();
            int i = 0;
            while (AudioRecorder.this.i) {
                byte[] bArr = new byte[AudioRecorder.this.g];
                if (AudioRecorder.this.b != null) {
                    i = AudioRecorder.this.b.read(bArr, 0, AudioRecorder.this.g);
                }
                if (i == -3 || i == -2 || i == -1 || i == 0) {
                    AudioRecorder.this.a();
                } else {
                    AudioRecorder.this.a(bArr, i);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        AudioRecorder f4292a;
        byte[] b;
        int c;

        public c(AudioRecorder audioRecorder, byte[] bArr, int i) {
            this.f4292a = audioRecorder;
            this.b = bArr;
            this.c = i;
        }
    }

    public AudioRecorder(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f = true;
        if (i3 == 8) {
            this.e = 3;
        } else {
            this.e = 2;
        }
        if (i4 == 2) {
            this.d = 3;
        } else {
            this.d = 2;
        }
        this.f = i7 == 1;
        this.c = i2;
        this.h = i5;
        this.g = i6;
    }

    public native void onReadData(byte[] bArr, int i);

    public native void onReadError();

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f) {
            c cVar = new c(this, null, 0);
            Handler handler = f4290a;
            handler.sendMessage(handler.obtainMessage(2, cVar));
        } else if (this.i) {
            onReadError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, int i) {
        if (this.f) {
            c cVar = new c(this, bArr, i);
            Handler handler = f4290a;
            handler.sendMessage(handler.obtainMessage(1, cVar));
        } else if (this.i) {
            onReadData(bArr, i);
        }
    }
}
