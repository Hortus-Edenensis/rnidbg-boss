package defpackage;

import com.huawei.hms.ads.ContentClassification;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.JvmField;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fB\t\b\u0016¢\u0006\u0004\b\u000b\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Let5;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "a", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "submissionTime", "Ljt5;", t.l, "Ljt5;", "taskContext", "<init>", "(JLjt5;)V", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class et5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long submissionTime;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @JvmField
    public jt5 taskContext;

    public et5(long j, jt5 jt5Var) {
        this.submissionTime = j;
        this.taskContext = jt5Var;
    }

    public et5() {
        this(0L, st5.f);
    }
}
