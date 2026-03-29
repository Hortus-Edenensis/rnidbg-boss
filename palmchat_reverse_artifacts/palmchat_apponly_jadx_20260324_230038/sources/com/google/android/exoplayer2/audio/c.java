package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.common.collect.ImmutableList;
import defpackage.vh;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<AudioProcessor> f5837a;
    public final List<AudioProcessor> b = new ArrayList();
    public ByteBuffer[] c = new ByteBuffer[0];
    public AudioProcessor.a d;
    public AudioProcessor.a e;
    public boolean f;

    public c(ImmutableList<AudioProcessor> immutableList) {
        this.f5837a = immutableList;
        AudioProcessor.a aVar = AudioProcessor.a.e;
        this.d = aVar;
        this.e = aVar;
        this.f = false;
    }

    public AudioProcessor.a a(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.equals(AudioProcessor.a.e)) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        for (int i = 0; i < this.f5837a.size(); i++) {
            AudioProcessor audioProcessor = this.f5837a.get(i);
            AudioProcessor.a aVarA = audioProcessor.a(aVar);
            if (audioProcessor.isActive()) {
                vh.g(!aVarA.equals(AudioProcessor.a.e));
                aVar = aVarA;
            }
        }
        this.e = aVar;
        return aVar;
    }

    public void b() {
        this.b.clear();
        this.d = this.e;
        this.f = false;
        for (int i = 0; i < this.f5837a.size(); i++) {
            AudioProcessor audioProcessor = this.f5837a.get(i);
            audioProcessor.flush();
            if (audioProcessor.isActive()) {
                this.b.add(audioProcessor);
            }
        }
        this.c = new ByteBuffer[this.b.size()];
        for (int i2 = 0; i2 <= c(); i2++) {
            this.c[i2] = this.b.get(i2).getOutput();
        }
    }

    public final int c() {
        return this.c.length - 1;
    }

    public ByteBuffer d() {
        if (!f()) {
            return AudioProcessor.f5817a;
        }
        ByteBuffer byteBuffer = this.c[c()];
        if (!byteBuffer.hasRemaining()) {
            g(AudioProcessor.f5817a);
        }
        return byteBuffer;
    }

    public boolean e() {
        return this.f && this.b.get(c()).isEnded() && !this.c[c()].hasRemaining();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f5837a.size() != cVar.f5837a.size()) {
            return false;
        }
        for (int i = 0; i < this.f5837a.size(); i++) {
            if (this.f5837a.get(i) != cVar.f5837a.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        return !this.b.isEmpty();
    }

    public final void g(ByteBuffer byteBuffer) {
        boolean z;
        for (boolean z2 = true; z2; z2 = z) {
            z = false;
            int i = 0;
            while (i <= c()) {
                if (!this.c[i].hasRemaining()) {
                    AudioProcessor audioProcessor = this.b.get(i);
                    if (!audioProcessor.isEnded()) {
                        ByteBuffer byteBuffer2 = i > 0 ? this.c[i - 1] : byteBuffer.hasRemaining() ? byteBuffer : AudioProcessor.f5817a;
                        long jRemaining = byteBuffer2.remaining();
                        audioProcessor.queueInput(byteBuffer2);
                        this.c[i] = audioProcessor.getOutput();
                        z |= jRemaining - ((long) byteBuffer2.remaining()) > 0 || this.c[i].hasRemaining();
                    } else if (!this.c[i].hasRemaining() && i < c()) {
                        this.b.get(i + 1).queueEndOfStream();
                    }
                }
                i++;
            }
        }
    }

    public void h() {
        if (!f() || this.f) {
            return;
        }
        this.f = true;
        this.b.get(0).queueEndOfStream();
    }

    public int hashCode() {
        return this.f5837a.hashCode();
    }

    public void i(ByteBuffer byteBuffer) {
        if (!f() || this.f) {
            return;
        }
        g(byteBuffer);
    }

    public void j() {
        for (int i = 0; i < this.f5837a.size(); i++) {
            AudioProcessor audioProcessor = this.f5837a.get(i);
            audioProcessor.flush();
            audioProcessor.reset();
        }
        this.c = new ByteBuffer[0];
        AudioProcessor.a aVar = AudioProcessor.a.e;
        this.d = aVar;
        this.e = aVar;
        this.f = false;
    }
}
