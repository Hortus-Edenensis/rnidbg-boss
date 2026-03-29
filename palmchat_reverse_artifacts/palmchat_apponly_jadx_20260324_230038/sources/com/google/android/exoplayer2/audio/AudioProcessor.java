package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import defpackage.g86;
import defpackage.m54;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface AudioProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f5817a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* JADX INFO: compiled from: SearchBox */
    public static final class UnhandledAudioFormatException extends Exception {
        public UnhandledAudioFormatException(a aVar) {
            this("Unhandled input format:", aVar);
        }

        public UnhandledAudioFormatException(String str, a aVar) {
            super(str + " " + aVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        public static final a e = new a(-1, -1, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5818a;
        public final int b;
        public final int c;
        public final int d;

        public a(int i, int i2, int i3) {
            this.f5818a = i;
            this.b = i2;
            this.c = i3;
            this.d = g86.z0(i3) ? g86.f0(i3, i2) : -1;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5818a == aVar.f5818a && this.b == aVar.b && this.c == aVar.c;
        }

        public int hashCode() {
            return m54.b(Integer.valueOf(this.f5818a), Integer.valueOf(this.b), Integer.valueOf(this.c));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f5818a + ", channelCount=" + this.b + ", encoding=" + this.c + ']';
        }
    }

    a a(a aVar) throws UnhandledAudioFormatException;

    void flush();

    ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer byteBuffer);

    void reset();
}
