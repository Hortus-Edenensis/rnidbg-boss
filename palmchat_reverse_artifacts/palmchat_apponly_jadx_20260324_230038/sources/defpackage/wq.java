package defpackage;

import rx.internal.util.atomic.LinkedQueueNode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class wq<E> extends yq<E> {
    public static final long b = s46.a(wq.class, "consumerNode");
    protected LinkedQueueNode<E> consumerNode;

    public final LinkedQueueNode<E> c() {
        return (LinkedQueueNode) s46.f20665a.getObjectVolatile(this, b);
    }

    public final void d(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }
}
