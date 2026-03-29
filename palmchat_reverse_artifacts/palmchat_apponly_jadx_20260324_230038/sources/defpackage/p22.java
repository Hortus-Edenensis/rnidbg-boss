package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.kuaishou.weapon.p0.t;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b¨\u0006\u000f"}, d2 = {"Lp22;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", t.l, "", "a", "", "Ljava/lang/String;", "modelListStr", "<init>", "()V", "framework_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFragmentStateFixer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FragmentStateFixer.kt\ncom/zenmen/palmchat/kotlin/common/FragmentStateFixer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,39:1\n1855#2,2:40\n*S KotlinDebug\n*F\n+ 1 FragmentStateFixer.kt\ncom/zenmen/palmchat/kotlin/common/FragmentStateFixer\n*L\n17#1:40,2\n*E\n"})
public final class p22 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p22 f19923a = new p22();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final String modelListStr = "all";

    public final boolean a(Context context) {
        if (Build.VERSION.SDK_INT != 29) {
            return false;
        }
        String str = modelListStr;
        if (Intrinsics.areEqual(str, "all")) {
            return true;
        }
        return StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null).contains(Build.MODEL);
    }

    public final void b(Context context, Bundle bundle) {
        Set<String> setKeySet;
        Intrinsics.checkNotNullParameter(context, "context");
        if (bundle != null) {
            try {
                if (a(context)) {
                    bundle.setClassLoader(context.getClass().getClassLoader());
                    Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                    if (bundle2 == null || (setKeySet = bundle2.keySet()) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet()");
                    Iterator<T> it = setKeySet.iterator();
                    while (it.hasNext()) {
                        Object obj = bundle2.get((String) it.next());
                        Bundle bundle3 = obj instanceof Bundle ? (Bundle) obj : null;
                        if (bundle3 != null) {
                            bundle3.setClassLoader(context.getClass().getClassLoader());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
