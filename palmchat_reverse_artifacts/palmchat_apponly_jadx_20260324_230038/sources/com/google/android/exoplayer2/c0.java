package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.c0;
import defpackage.g86;
import defpackage.vh;
import defpackage.y53;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5846a;
    public final Handler b;
    public final b c;
    public final AudioManager d;

    @Nullable
    public c e;
    public int f;
    public int g;
    public boolean h;

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onStreamTypeChanged(int i);

        void onStreamVolumeChanged(int i, boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = c0.this.b;
            final c0 c0Var = c0.this;
            handler.post(new Runnable() { // from class: el5
                @Override // java.lang.Runnable
                public final void run() {
                    c0.b(c0Var);
                }
            });
        }
    }

    public c0(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f5846a = applicationContext;
        this.b = handler;
        this.c = bVar;
        AudioManager audioManager = (AudioManager) vh.i((AudioManager) applicationContext.getSystemService("audio"));
        this.d = audioManager;
        this.f = 3;
        this.g = f(audioManager, 3);
        this.h = e(audioManager, this.f);
        c cVar = new c();
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter(com.huawei.openalliance.ad.constant.x.cm));
            this.e = cVar;
        } catch (RuntimeException e) {
            y53.j("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    public static /* synthetic */ void b(c0 c0Var) {
        c0Var.i();
    }

    public static boolean e(AudioManager audioManager, int i) {
        return g86.f17680a >= 23 ? audioManager.isStreamMute(i) : f(audioManager, i) == 0;
    }

    public static int f(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            y53.j("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i, e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    public int c() {
        return this.d.getStreamMaxVolume(this.f);
    }

    public int d() {
        if (g86.f17680a >= 28) {
            return this.d.getStreamMinVolume(this.f);
        }
        return 0;
    }

    public void g() {
        c cVar = this.e;
        if (cVar != null) {
            try {
                this.f5846a.unregisterReceiver(cVar);
            } catch (RuntimeException e) {
                y53.j("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            this.e = null;
        }
    }

    public void h(int i) {
        if (this.f == i) {
            return;
        }
        this.f = i;
        i();
        this.c.onStreamTypeChanged(i);
    }

    public final void i() {
        int iF = f(this.d, this.f);
        boolean zE = e(this.d, this.f);
        if (this.g == iF && this.h == zE) {
            return;
        }
        this.g = iF;
        this.h = zE;
        this.c.onStreamVolumeChanged(iF, zE);
    }
}
