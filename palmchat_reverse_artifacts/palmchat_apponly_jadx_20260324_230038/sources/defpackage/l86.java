package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class l86 {

    /* JADX INFO: compiled from: SearchBox */
    public enum a implements s42<Object, Boolean> {
        INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // defpackage.s42
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }

    public static <T> s42<? super T, Boolean> a() {
        return a.INSTANCE;
    }
}
