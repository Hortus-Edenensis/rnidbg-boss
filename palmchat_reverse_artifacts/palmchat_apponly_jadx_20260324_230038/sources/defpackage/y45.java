package defpackage;

import defpackage.v45;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface y45 extends v45 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends v45.b implements y45 {
        public a() {
            super(-9223372036854775807L);
        }

        @Override // defpackage.y45
        public long getDataEndPosition() {
            return -1L;
        }

        @Override // defpackage.y45
        public long getTimeUs(long j) {
            return 0L;
        }
    }

    long getDataEndPosition();

    long getTimeUs(long j);
}
