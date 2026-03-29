package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.AttrRes;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ed1 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f17277a;
        public final /* synthetic */ MaterialDialog.d b;

        public a(MaterialDialog materialDialog, MaterialDialog.d dVar) {
            this.f17277a = materialDialog;
            this.b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17277a.k().requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.b.w().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.f17277a.k(), 1);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f17278a;
        public final /* synthetic */ MaterialDialog.d b;

        public b(MaterialDialog materialDialog, MaterialDialog.d dVar) {
            this.f17278a = materialDialog;
            this.b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17278a.k().requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.b.w().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f17278a.k().getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17279a;

        static {
            int[] iArr = new int[GravityEnum.values().length];
            f17279a = iArr;
            try {
                iArr[GravityEnum.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17279a[GravityEnum.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static int a(int i, float f) {
        return Color.argb(Math.round(Color.alpha(i) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public static int b(GravityEnum gravityEnum) {
        int i = c.f17279a[gravityEnum.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    public static void c(DialogInterface dialogInterface, MaterialDialog.d dVar) {
        MaterialDialog materialDialog = (MaterialDialog) dialogInterface;
        if (materialDialog.k() == null) {
            return;
        }
        materialDialog.k().post(new b(materialDialog, dVar));
    }

    public static boolean d(int i) {
        return 1.0d - ((((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d)) / 255.0d) >= 0.5d;
    }

    public static boolean e(Context context, @AttrRes int i) {
        return f(context, i, false);
    }

    public static boolean f(Context context, @AttrRes int i, boolean z) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return typedArrayObtainStyledAttributes.getBoolean(0, z);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int g(Context context, @AttrRes int i) {
        return h(context, i, 0);
    }

    public static int h(Context context, @AttrRes int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            try {
                i2 = typedArrayObtainStyledAttributes.getColor(0, i2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return i2;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int i(Context context, @AttrRes int i) {
        return j(context, i, -1);
    }

    public static int j(Context context, @AttrRes int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i2);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static Drawable k(Context context, @AttrRes int i) {
        return l(context, i, null);
    }

    public static Drawable l(Context context, @AttrRes int i, Drawable drawable) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(0);
            if (drawable2 != null || drawable == null) {
                drawable = drawable2;
            }
            return drawable;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static GravityEnum m(Context context, @AttrRes int i, GravityEnum gravityEnum) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            int i2 = typedArrayObtainStyledAttributes.getInt(0, b(gravityEnum));
            return i2 != 1 ? i2 != 2 ? GravityEnum.START : GravityEnum.END : GravityEnum.CENTER;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static String n(Context context, @AttrRes int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return (String) typedValue.string;
    }

    public static void o(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void p(DialogInterface dialogInterface, MaterialDialog.d dVar) {
        MaterialDialog materialDialog = (MaterialDialog) dialogInterface;
        if (materialDialog.k() == null) {
            return;
        }
        materialDialog.k().post(new a(materialDialog, dVar));
    }
}
