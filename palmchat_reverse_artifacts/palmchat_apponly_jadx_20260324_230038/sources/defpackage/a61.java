package defpackage;

import com.baidu.platform.comapi.map.MapController;
import com.heytap.mcssdk.constant.b;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0017J\u001c\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u000e\u001a\u00060\u0003j\u0002`\rH\u0016J\u001c\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u000e\u001a\u00060\u0003j\u0002`\rH\u0017J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"La61;", "Lio1;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", b.y, "", "execute", "", "parallelism", "Llq0;", "limitedParallelism", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "dispatchYield", "close", "", "toString", "c", "Llq0;", MapController.DEFAULT_LAYER_TAG, "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class a61 extends io1 implements Executor {
    public static final a61 b = new a61();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final lq0 default = n46.f19437a.limitedParallelism(hr5.d("kotlinx.coroutines.io.parallelism", RangesKt___RangesKt.coerceAtLeast(64, fr5.a()), 0, 0, 12, null));

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // defpackage.lq0
    public void dispatch(CoroutineContext context, Runnable block) {
        default.dispatch(context, block);
    }

    @Override // defpackage.lq0
    public void dispatchYield(CoroutineContext context, Runnable block) {
        default.dispatchYield(context, block);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        dispatch(EmptyCoroutineContext.INSTANCE, command);
    }

    @Override // defpackage.lq0
    public lq0 limitedParallelism(int parallelism) {
        return n46.f19437a.limitedParallelism(parallelism);
    }

    @Override // defpackage.lq0
    public String toString() {
        return "Dispatchers.IO";
    }
}
