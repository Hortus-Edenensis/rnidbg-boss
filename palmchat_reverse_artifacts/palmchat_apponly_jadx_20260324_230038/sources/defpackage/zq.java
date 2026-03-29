package defpackage;

import rx.internal.util.atomic.LinkedQueueNode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zq<E> extends xq<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f22479a = s46.a(zq.class, "producerNode");
    protected LinkedQueueNode<E> producerNode;

    public final LinkedQueueNode<E> a() {
        return (LinkedQueueNode) s46.f20665a.getObjectVolatile(this, f22479a);
    }

    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }
}
