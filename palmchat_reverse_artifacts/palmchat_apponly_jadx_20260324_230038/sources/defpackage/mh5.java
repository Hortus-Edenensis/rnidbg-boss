package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class mh5<E> extends dl0<E> {
    public static final Integer g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    public final int f;

    public mh5(int i) {
        super(i);
        this.f = Math.min(i / 4, g.intValue());
    }
}
