package com.google.android.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import defpackage.g86;
import defpackage.mj;
import defpackage.vh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5833a;
    public final f b;
    public final Handler c;

    @Nullable
    public final c d;

    @Nullable
    public final BroadcastReceiver e;

    @Nullable
    public final d f;

    @Nullable
    public mj g;
    public boolean h;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.audio.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(23)
    public static final class C0349b {
        @DoNotInline
        public static void a(Context context, AudioDeviceCallback audioDeviceCallback, Handler handler) {
            ((AudioManager) vh.e((AudioManager) context.getSystemService("audio"))).registerAudioDeviceCallback(audioDeviceCallback, handler);
        }

        @DoNotInline
        public static void b(Context context, AudioDeviceCallback audioDeviceCallback) {
            ((AudioManager) vh.e((AudioManager) context.getSystemService("audio"))).unregisterAudioDeviceCallback(audioDeviceCallback);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(23)
    public final class c extends AudioDeviceCallback {
        public c() {
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            b bVar = b.this;
            bVar.c(mj.c(bVar.f5833a));
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            b bVar = b.this;
            bVar.c(mj.c(bVar.f5833a));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class d extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f5835a;
        public final Uri b;

        public d(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.f5835a = contentResolver;
            this.b = uri;
        }

        public void a() {
            this.f5835a.registerContentObserver(this.b, false, this);
        }

        public void b() {
            this.f5835a.unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            b bVar = b.this;
            bVar.c(mj.c(bVar.f5833a));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            b.this.c(mj.d(context, intent));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(mj mjVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context context, f fVar) {
        Context applicationContext = context.getApplicationContext();
        this.f5833a = applicationContext;
        this.b = (f) vh.e(fVar);
        Handler handlerY = g86.y();
        this.c = handlerY;
        int i = g86.f17680a;
        Object[] objArr = 0;
        this.d = i >= 23 ? new c() : null;
        this.e = i >= 21 ? new e() : null;
        Uri uriG = mj.g();
        this.f = uriG != null ? new d(handlerY, applicationContext.getContentResolver(), uriG) : null;
    }

    public final void c(mj mjVar) {
        if (!this.h || mjVar.equals(this.g)) {
            return;
        }
        this.g = mjVar;
        this.b.a(mjVar);
    }

    public mj d() {
        c cVar;
        if (this.h) {
            return (mj) vh.e(this.g);
        }
        this.h = true;
        d dVar = this.f;
        if (dVar != null) {
            dVar.a();
        }
        if (g86.f17680a >= 23 && (cVar = this.d) != null) {
            C0349b.a(this.f5833a, cVar, this.c);
        }
        mj mjVarD = mj.d(this.f5833a, this.e != null ? this.f5833a.registerReceiver(this.e, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.c) : null);
        this.g = mjVarD;
        return mjVarD;
    }

    public void e() {
        c cVar;
        if (this.h) {
            this.g = null;
            if (g86.f17680a >= 23 && (cVar = this.d) != null) {
                C0349b.b(this.f5833a, cVar);
            }
            BroadcastReceiver broadcastReceiver = this.e;
            if (broadcastReceiver != null) {
                this.f5833a.unregisterReceiver(broadcastReceiver);
            }
            d dVar = this.f;
            if (dVar != null) {
                dVar.b();
            }
            this.h = false;
        }
    }
}
