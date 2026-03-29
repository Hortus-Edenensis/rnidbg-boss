package defpackage;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Liz5;", "", "a", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public final class iz5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: iz5$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\f"}, d2 = {"Liz5$a;", "", "", "Ljava/lang/StackTraceElement;", "c", "()[Ljava/lang/StackTraceElement;", "", "Lkotlin/text/Regex;", "excludes", "a", "<init>", "()V", "zx-jvm"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StackTraceElement b(Companion companion, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = jz5.a();
            }
            return companion.a(list);
        }

        public final StackTraceElement a(List<Regex> excludes) {
            StackTraceElement[] stackTraceElementArrC = c();
            int length = stackTraceElementArrC.length;
            int i = 0;
            while (true) {
                Object obj = null;
                if (i >= length) {
                    return null;
                }
                StackTraceElement stackTraceElement = stackTraceElementArrC[i];
                Iterator<T> it = excludes.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    String className = stackTraceElement.getClassName();
                    Intrinsics.checkExpressionValueIsNotNull(className, "elem.className");
                    if (Regex.find$default((Regex) next, className, 0, 2, null) != null) {
                        obj = next;
                        break;
                    }
                }
                if (obj == null) {
                    return stackTraceElement;
                }
                i++;
            }
        }

        public final StackTraceElement[] c() {
            Thread threadCurrentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(threadCurrentThread, "Thread.currentThread()");
            StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
            Intrinsics.checkExpressionValueIsNotNull(stackTrace, "Thread.currentThread().stackTrace");
            return stackTrace;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
