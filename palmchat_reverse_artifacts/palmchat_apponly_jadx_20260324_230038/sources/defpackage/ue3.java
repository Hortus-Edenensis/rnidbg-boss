package defpackage;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface ue3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ue3 f21199a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ue3 {
        @Override // defpackage.ue3
        public long getChunkEndTimeUs() {
            throw new NoSuchElementException();
        }

        @Override // defpackage.ue3
        public long getChunkStartTimeUs() {
            throw new NoSuchElementException();
        }

        @Override // defpackage.ue3
        public boolean next() {
            return false;
        }
    }

    long getChunkEndTimeUs();

    long getChunkStartTimeUs();

    boolean next();
}
