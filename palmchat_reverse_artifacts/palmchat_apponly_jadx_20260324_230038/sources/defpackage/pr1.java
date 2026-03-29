package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class pr1 implements en5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qr0 f20084a = new qr0();
    public final in5 b = new in5();
    public final Deque<jn5> c = new ArrayDeque();
    public int d;
    public boolean e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends jn5 {
        public a() {
        }

        @Override // defpackage.mw0
        public void l() {
            pr1.this.e(this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements dn5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f20085a;
        public final ImmutableList<pr0> b;

        public b(long j, ImmutableList<pr0> immutableList) {
            this.f20085a = j;
            this.b = immutableList;
        }

        @Override // defpackage.dn5
        public List<pr0> getCues(long j) {
            return j >= this.f20085a ? this.b : ImmutableList.of();
        }

        @Override // defpackage.dn5
        public long getEventTime(int i) {
            vh.a(i == 0);
            return this.f20085a;
        }

        @Override // defpackage.dn5
        public int getEventTimeCount() {
            return 1;
        }

        @Override // defpackage.dn5
        public int getNextEventTimeIndex(long j) {
            return this.f20085a > j ? 0 : -1;
        }
    }

    public pr1() {
        for (int i = 0; i < 2; i++) {
            this.c.addFirst(new a());
        }
        this.d = 0;
    }

    @Override // defpackage.kw0
    @Nullable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public in5 dequeueInputBuffer() throws SubtitleDecoderException {
        vh.g(!this.e);
        if (this.d != 0) {
            return null;
        }
        this.d = 1;
        return this.b;
    }

    @Override // defpackage.kw0
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public jn5 dequeueOutputBuffer() throws SubtitleDecoderException {
        vh.g(!this.e);
        if (this.d != 2 || this.c.isEmpty()) {
            return null;
        }
        jn5 jn5VarRemoveFirst = this.c.removeFirst();
        if (this.b.g()) {
            jn5VarRemoveFirst.a(4);
        } else {
            in5 in5Var = this.b;
            jn5VarRemoveFirst.m(this.b.e, new b(in5Var.e, this.f20084a.a(((ByteBuffer) vh.e(in5Var.c)).array())), 0L);
        }
        this.b.b();
        this.d = 0;
        return jn5VarRemoveFirst;
    }

    @Override // defpackage.kw0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(in5 in5Var) throws SubtitleDecoderException {
        vh.g(!this.e);
        vh.g(this.d == 1);
        vh.a(this.b == in5Var);
        this.d = 2;
    }

    public final void e(jn5 jn5Var) {
        vh.g(this.c.size() < 2);
        vh.a(!this.c.contains(jn5Var));
        jn5Var.b();
        this.c.addFirst(jn5Var);
    }

    @Override // defpackage.kw0
    public void flush() {
        vh.g(!this.e);
        this.b.b();
        this.d = 0;
    }

    @Override // defpackage.kw0
    public void release() {
        this.e = true;
    }

    @Override // defpackage.en5
    public void setPositionUs(long j) {
    }
}
