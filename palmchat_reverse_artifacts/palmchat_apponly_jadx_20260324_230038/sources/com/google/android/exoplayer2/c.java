package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import defpackage.ak;
import defpackage.g86;
import defpackage.sj;
import defpackage.tj;
import defpackage.vh;
import defpackage.y53;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f5844a;
    public final a b;

    @Nullable
    public b c;

    @Nullable
    public com.google.android.exoplayer2.audio.a d;
    public int f;
    public AudioFocusRequest h;
    public boolean i;
    public float g = 1.0f;
    public int e = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f5845a;

        public a(Handler handler) {
            this.f5845a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i) {
            c.this.h(i);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            this.f5845a.post(new Runnable() { // from class: uj
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21226a.b(i);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void executePlayerCommand(int i);

        void setVolumeMultiplier(float f);
    }

    public c(Context context, Handler handler, b bVar) {
        this.f5844a = (AudioManager) vh.e((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.c = bVar;
        this.b = new a(handler);
    }

    public static int e(@Nullable com.google.android.exoplayer2.audio.a aVar) {
        if (aVar == null) {
            return 0;
        }
        switch (aVar.c) {
            case 0:
                y53.i("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (aVar.f5830a == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                y53.i("AudioFocusManager", "Unidentified audio usage: " + aVar.c);
                return 0;
            case 16:
                return g86.f17680a >= 19 ? 4 : 2;
        }
    }

    public final void a() {
        this.f5844a.abandonAudioFocus(this.b);
    }

    public final void b() {
        if (this.e == 0) {
            return;
        }
        if (g86.f17680a >= 26) {
            c();
        } else {
            a();
        }
        n(0);
    }

    @RequiresApi(26)
    public final void c() {
        AudioFocusRequest audioFocusRequest = this.h;
        if (audioFocusRequest != null) {
            this.f5844a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    public final void f(int i) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.executePlayerCommand(i);
        }
    }

    public float g() {
        return this.g;
    }

    public final void h(int i) {
        if (i == -3 || i == -2) {
            if (i != -2 && !q()) {
                n(3);
                return;
            } else {
                f(0);
                n(2);
                return;
            }
        }
        if (i == -1) {
            f(-1);
            b();
        } else if (i == 1) {
            n(1);
            f(1);
        } else {
            y53.i("AudioFocusManager", "Unknown focus change type: " + i);
        }
    }

    public void i() {
        this.c = null;
        b();
    }

    public final int j() {
        if (this.e == 1) {
            return 1;
        }
        if ((g86.f17680a >= 26 ? l() : k()) == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    public final int k() {
        return this.f5844a.requestAudioFocus(this.b, g86.h0(((com.google.android.exoplayer2.audio.a) vh.e(this.d)).c), this.f);
    }

    @RequiresApi(26)
    public final int l() {
        AudioFocusRequest.Builder builderA;
        AudioFocusRequest audioFocusRequest = this.h;
        if (audioFocusRequest == null || this.i) {
            if (audioFocusRequest == null) {
                tj.a();
                builderA = ak.a(this.f);
            } else {
                tj.a();
                builderA = sj.a(this.h);
            }
            this.h = builderA.setAudioAttributes(((com.google.android.exoplayer2.audio.a) vh.e(this.d)).b().f5831a).setWillPauseWhenDucked(q()).setOnAudioFocusChangeListener(this.b).build();
            this.i = false;
        }
        return this.f5844a.requestAudioFocus(this.h);
    }

    public void m(@Nullable com.google.android.exoplayer2.audio.a aVar) {
        if (g86.c(this.d, aVar)) {
            return;
        }
        this.d = aVar;
        int iE = e(aVar);
        this.f = iE;
        boolean z = true;
        if (iE != 1 && iE != 0) {
            z = false;
        }
        vh.b(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public final void n(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.g == f) {
            return;
        }
        this.g = f;
        b bVar = this.c;
        if (bVar != null) {
            bVar.setVolumeMultiplier(f);
        }
    }

    public final boolean o(int i) {
        return i == 1 || this.f != 1;
    }

    public int p(boolean z, int i) {
        if (o(i)) {
            b();
            return z ? 1 : -1;
        }
        if (z) {
            return j();
        }
        return -1;
    }

    public final boolean q() {
        com.google.android.exoplayer2.audio.a aVar = this.d;
        return aVar != null && aVar.f5830a == 1;
    }
}
