package defpackage;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\f\u0010\f\u001a\u00020\b*\u00020\u0000H\u0002¨\u0006\r"}, d2 = {"Landroid/app/Activity;", "act", "Landroid/os/Bundle;", "bundle", "", "c", "", "requestedOrientation", "", "d", t.l, "a", "e", "zx-compat_release"}, k = 2, mv = {1, 4, 0})
public final class m5 {
    public static final boolean a(Activity activity) {
        try {
            Field fld = Activity.class.getDeclaredField("mActivityInfo");
            Intrinsics.checkExpressionValueIsNotNull(fld, "fld");
            fld.setAccessible(true);
            Object obj = fld.get(activity);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.content.pm.ActivityInfo");
            }
            ((ActivityInfo) obj).screenOrientation = -1;
            fld.setAccessible(false);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final boolean b(Activity activity) {
        return Build.VERSION.SDK_INT == 26 && e(activity);
    }

    public static final void c(Activity activity, Bundle bundle) {
        if (b(activity)) {
            a(activity);
        }
    }

    public static final boolean d(Activity activity, int i) {
        return !b(activity);
    }

    public static final boolean e(Activity activity) {
        boolean z = false;
        try {
            Object obj = Class.forName("com.android.internal.R$styleable").getField("Window").get(null);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.IntArray");
            }
            TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes((int[]) obj);
            Method mth = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            Intrinsics.checkExpressionValueIsNotNull(mth, "mth");
            mth.setAccessible(true);
            Object objInvoke = mth.invoke(null, typedArrayObtainStyledAttributes);
            if (objInvoke == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolean zBooleanValue = ((Boolean) objInvoke).booleanValue();
            try {
                mth.setAccessible(false);
                return zBooleanValue;
            } catch (Exception unused) {
                z = zBooleanValue;
                return z;
            }
        } catch (Exception unused2) {
        }
    }
}
