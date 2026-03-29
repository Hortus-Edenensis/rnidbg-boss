package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5842a;
    public final a b;
    public boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public final class a extends BroadcastReceiver implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0350b f5843a;
        public final Handler b;

        public a(Handler handler, InterfaceC0350b interfaceC0350b) {
            this.b = handler;
            this.f5843a = interfaceC0350b;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.b.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.c) {
                this.f5843a.onAudioBecomingNoisy();
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0350b {
        void onAudioBecomingNoisy();
    }

    public b(Context context, Handler handler, InterfaceC0350b interfaceC0350b) {
        this.f5842a = context.getApplicationContext();
        this.b = new a(handler, interfaceC0350b);
    }

    public void b(boolean z) {
        if (z && !this.c) {
            this.f5842a.registerReceiver(this.b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.c = true;
        } else {
            if (z || !this.c) {
                return;
            }
            this.f5842a.unregisterReceiver(this.b);
            this.c = false;
        }
    }
}
