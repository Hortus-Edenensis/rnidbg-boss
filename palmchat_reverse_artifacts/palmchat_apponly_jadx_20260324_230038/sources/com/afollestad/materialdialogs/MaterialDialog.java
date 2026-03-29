package com.afollestad.materialdialogs;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.res.ResourcesCompat;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import defpackage.ed1;
import defpackage.ew5;
import defpackage.ic1;
import defpackage.sb3;
import defpackage.y26;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class MaterialDialog extends ic1 implements View.OnClickListener, AdapterView.OnItemClickListener {
    public final MDRootLayout c;
    public final d d;
    public ListView e;
    public ImageView f;
    public TextView g;
    public View h;
    public FrameLayout i;
    public ProgressBar j;
    public TextView k;
    public TextView l;
    public TextView m;
    public EditText n;
    public TextView o;
    public MDButton p;
    public MDButton q;
    public MDButton r;
    public ListType s;
    public List<Integer> t;

    /* JADX INFO: compiled from: SearchBox */
    public static class DialogException extends WindowManager.BadTokenException {
        public DialogException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum ListType {
        REGULAR,
        SINGLE,
        MULTI;

        public static int getLayoutForType(ListType listType) {
            int i = c.b[listType.ordinal()];
            if (i == 1) {
                return R$layout.md_listitem;
            }
            if (i == 2) {
                return R$layout.md_listitem_singlechoice;
            }
            if (i == 3) {
                return R$layout.md_listitem_multichoice;
            }
            throw new IllegalArgumentException("Not a valid list type");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class NotImplementedException extends Error {
        public NotImplementedException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: com.afollestad.materialdialogs.MaterialDialog$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0047a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f2499a;

            public RunnableC0047a(int i) {
                this.f2499a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                MaterialDialog.this.e.requestFocus();
                MaterialDialog.this.e.setSelection(this.f2499a);
            }
        }

        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int iIntValue;
            MaterialDialog.this.e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            MaterialDialog materialDialog = MaterialDialog.this;
            ListType listType = materialDialog.s;
            ListType listType2 = ListType.SINGLE;
            if (listType == listType2 || listType == ListType.MULTI) {
                if (listType == listType2) {
                    iIntValue = materialDialog.d.D;
                    if (iIntValue < 0) {
                        return;
                    }
                } else {
                    Integer[] numArr = materialDialog.d.E;
                    if (numArr == null || numArr.length == 0) {
                        return;
                    }
                    List listAsList = Arrays.asList(numArr);
                    Collections.sort(listAsList);
                    iIntValue = ((Integer) listAsList.get(0)).intValue();
                }
                if (MaterialDialog.this.e.getLastVisiblePosition() < iIntValue) {
                    int lastVisiblePosition = iIntValue - ((MaterialDialog.this.e.getLastVisiblePosition() - MaterialDialog.this.e.getFirstVisiblePosition()) / 2);
                    MaterialDialog.this.e.post(new RunnableC0047a(lastVisiblePosition >= 0 ? lastVisiblePosition : 0));
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2501a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ListType.values().length];
            b = iArr;
            try {
                iArr[ListType.REGULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ListType.SINGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[ListType.MULTI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[DialogAction.values().length];
            f2501a = iArr2;
            try {
                iArr2[DialogAction.NEUTRAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2501a[DialogAction.NEGATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2501a[DialogAction.POSITIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {
        public Theme A;
        public boolean B;
        public float C;
        public int D;
        public Integer[] E;
        public boolean F;
        public Typeface G;
        public Typeface H;
        public Drawable I;
        public boolean J;
        public int K;
        public ListAdapter L;
        public DialogInterface.OnDismissListener M;
        public DialogInterface.OnCancelListener N;
        public DialogInterface.OnKeyListener O;
        public DialogInterface.OnShowListener P;
        public boolean Q;
        public boolean R;
        public int S;
        public int T;
        public int U;
        public boolean V;
        public boolean W;
        public int X;
        public int Y;
        public CharSequence Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f2502a;
        public CharSequence a0;
        public CharSequence b;
        public f b0;
        public GravityEnum c;
        public boolean c0;
        public GravityEnum d;
        public int d0;
        public GravityEnum e;
        public boolean e0;
        public GravityEnum f;
        public int f0;
        public GravityEnum g;
        public int g0;
        public int h;
        public float h0;
        public int i;
        public boolean i0;
        public CharSequence j;
        public boolean j0;
        public CharSequence[] k;
        public boolean k0;
        public CharSequence l;
        public boolean l0;
        public CharSequence m;

        @DrawableRes
        public int m0;
        public CharSequence n;

        @DrawableRes
        public int n0;
        public View o;

        @DrawableRes
        public int o0;
        public int p;

        @DrawableRes
        public int p0;
        public int q;

        @DrawableRes
        public int q0;
        public int r;
        public int s;
        public e t;
        public g u;
        public i v;
        public h w;
        public g x;
        public boolean y;
        public boolean z;

        public d(@NonNull Context context) {
            GravityEnum gravityEnum = GravityEnum.START;
            this.c = gravityEnum;
            this.d = gravityEnum;
            this.e = GravityEnum.END;
            this.f = gravityEnum;
            this.g = gravityEnum;
            this.h = -1;
            this.i = -1;
            this.y = false;
            this.z = false;
            Theme theme = Theme.LIGHT;
            this.A = theme;
            this.B = true;
            this.C = 1.2f;
            this.D = -1;
            this.E = null;
            this.F = true;
            this.K = -1;
            this.X = -2;
            this.Y = 0;
            this.d0 = -1;
            this.f0 = -1;
            this.g0 = 0;
            this.h0 = 0.5f;
            this.i0 = false;
            this.j0 = false;
            this.k0 = false;
            this.l0 = false;
            this.f2502a = context;
            int iH = ed1.h(context, R$attr.colorAccent, context.getResources().getColor(R$color.md_material_blue_600));
            this.p = iH;
            int iH2 = ed1.h(context, R.attr.colorAccent, iH);
            this.p = iH2;
            this.q = iH2;
            this.r = iH2;
            this.s = iH2;
            this.A = ed1.d(ed1.g(context, R.attr.textColorPrimary)) ? theme : Theme.DARK;
            i();
            this.c = ed1.m(context, R$attr.md_title_gravity, this.c);
            this.d = ed1.m(context, R$attr.md_content_gravity, this.d);
            this.e = ed1.m(context, R$attr.md_btnstacked_gravity, this.e);
            this.f = ed1.m(context, R$attr.md_items_gravity, this.f);
            this.g = ed1.m(context, R$attr.md_buttons_gravity, this.g);
            Y(ed1.n(context, R$attr.md_medium_font), ed1.n(context, R$attr.md_regular_font));
            if (this.H == null) {
                try {
                    this.H = Typeface.create("sans-serif-medium", 0);
                } catch (Throwable unused) {
                }
            }
            if (this.G == null) {
                try {
                    this.G = Typeface.create("sans-serif", 0);
                } catch (Throwable unused2) {
                }
            }
            if (this.H == null) {
                this.H = this.G;
            }
        }

        public d A(@NonNull Drawable drawable) {
            this.I = drawable;
            return this;
        }

        public d B(CharSequence charSequence, CharSequence charSequence2, @NonNull f fVar) {
            return C(charSequence, charSequence2, true, fVar);
        }

        public d C(CharSequence charSequence, CharSequence charSequence2, boolean z, @NonNull f fVar) {
            if (this.o != null) {
                throw new IllegalStateException("You cannot set content() when you're using a custom view.");
            }
            this.b0 = fVar;
            this.a0 = charSequence;
            this.Z = charSequence2;
            this.c0 = z;
            return this;
        }

        public d D(int i) {
            this.U = i;
            this.k0 = true;
            return this;
        }

        public d E(@ColorRes int i) {
            return D(this.f2502a.getResources().getColor(i));
        }

        public d F(@NonNull CharSequence[] charSequenceArr) {
            if (this.o != null) {
                throw new IllegalStateException("You cannot set items() when you're using a custom view.");
            }
            this.k = charSequenceArr;
            return this;
        }

        public d G(Integer[] numArr, @NonNull h hVar) {
            this.E = numArr;
            this.u = null;
            this.v = null;
            this.w = hVar;
            return this;
        }

        public d H(int i, @NonNull i iVar) {
            this.D = i;
            this.u = null;
            this.v = iVar;
            this.w = null;
            return this;
        }

        public d I(int i) {
            this.r = i;
            return this;
        }

        public d J(@ColorRes int i) {
            return I(this.f2502a.getResources().getColor(i));
        }

        public d K(@StringRes int i) {
            return L(this.f2502a.getText(i));
        }

        public d L(@NonNull CharSequence charSequence) {
            this.n = charSequence;
            return this;
        }

        public d M(int i) {
            this.q = i;
            return this;
        }

        public d N(@ColorRes int i) {
            return M(this.f2502a.getResources().getColor(i));
        }

        public d O(@StringRes int i) {
            P(this.f2502a.getText(i));
            return this;
        }

        public d P(@NonNull CharSequence charSequence) {
            this.l = charSequence;
            return this;
        }

        public MaterialDialog Q() {
            MaterialDialog materialDialogE = e();
            materialDialogE.show();
            return materialDialogE;
        }

        public d R(@NonNull DialogInterface.OnShowListener onShowListener) {
            this.P = onShowListener;
            return this;
        }

        public d S(@NonNull Theme theme) {
            this.A = theme;
            return this;
        }

        public d T(@StringRes int i) {
            U(this.f2502a.getText(i));
            m(R$color.color_999999);
            return this;
        }

        public d U(@NonNull CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }

        public d V(int i) {
            this.h = i;
            this.i0 = true;
            return this;
        }

        public d W(@ColorRes int i) {
            V(this.f2502a.getResources().getColor(i));
            return this;
        }

        public d X(@NonNull GravityEnum gravityEnum) {
            this.c = gravityEnum;
            return this;
        }

        public d Y(String str, String str2) {
            if (str != null) {
                Typeface typefaceA = y26.a(this.f2502a, str);
                this.H = typefaceA;
                if (typefaceA == null) {
                    throw new IllegalArgumentException("No font asset found for " + str);
                }
            }
            if (str2 != null) {
                Typeface typefaceA2 = y26.a(this.f2502a, str2);
                this.G = typefaceA2;
                if (typefaceA2 == null) {
                    throw new IllegalArgumentException("No font asset found for " + str2);
                }
            }
            return this;
        }

        public d Z(int i) {
            this.p = i;
            return this;
        }

        public d a(@NonNull ListAdapter listAdapter, g gVar) {
            if (this.o != null) {
                throw new IllegalStateException("You cannot set adapter() when you're using a custom view.");
            }
            this.L = listAdapter;
            this.x = gVar;
            return this;
        }

        public d a0(@ColorRes int i) {
            return Z(this.f2502a.getResources().getColor(i));
        }

        public d b(boolean z) {
            this.F = z;
            return this;
        }

        public d c(int i) {
            this.T = i;
            return this;
        }

        public d d(@ColorRes int i) {
            return c(this.f2502a.getResources().getColor(i));
        }

        public MaterialDialog e() {
            return new MaterialDialog(this);
        }

        public d f(@NonNull e eVar) {
            this.t = eVar;
            return this;
        }

        public d g(@NonNull DialogInterface.OnCancelListener onCancelListener) {
            this.N = onCancelListener;
            return this;
        }

        public d h(boolean z) {
            this.B = z;
            return this;
        }

        public final void i() {
            if (ew5.b(false) == null) {
                return;
            }
            ew5 ew5VarA = ew5.a();
            if (ew5VarA.f17381a) {
                this.A = Theme.DARK;
            }
            int i = ew5VarA.b;
            if (i != 0) {
                this.h = i;
            }
            int i2 = ew5VarA.c;
            if (i2 != 0) {
                this.i = i2;
            }
            int i3 = ew5VarA.d;
            if (i3 != 0) {
                this.q = i3;
            }
            int i4 = ew5VarA.e;
            if (i4 != 0) {
                this.s = i4;
            }
            int i5 = ew5VarA.f;
            if (i5 != 0) {
                this.r = i5;
            }
            int i6 = ew5VarA.h;
            if (i6 != 0) {
                this.U = i6;
            }
            Drawable drawable = ew5VarA.i;
            if (drawable != null) {
                this.I = drawable;
            }
            int i7 = ew5VarA.j;
            if (i7 != 0) {
                this.T = i7;
            }
            int i8 = ew5VarA.k;
            if (i8 != 0) {
                this.S = i8;
            }
            int i9 = ew5VarA.m;
            if (i9 != 0) {
                this.n0 = i9;
            }
            int i10 = ew5VarA.l;
            if (i10 != 0) {
                this.m0 = i10;
            }
            int i11 = ew5VarA.n;
            if (i11 != 0) {
                this.o0 = i11;
            }
            int i12 = ew5VarA.o;
            if (i12 != 0) {
                this.p0 = i12;
            }
            int i13 = ew5VarA.p;
            if (i13 != 0) {
                this.q0 = i13;
            }
            int i14 = ew5VarA.g;
            if (i14 != 0) {
                this.p = i14;
            }
            this.c = ew5VarA.q;
            this.d = ew5VarA.r;
            this.e = ew5VarA.s;
            this.f = ew5VarA.t;
            this.g = ew5VarA.u;
        }

        public d j(@StringRes int i) {
            k(this.f2502a.getText(i));
            return this;
        }

        public d k(@NonNull CharSequence charSequence) {
            if (this.o != null) {
                throw new IllegalStateException("You cannot set content() when you're using a custom view.");
            }
            this.j = charSequence;
            return this;
        }

        public d l(int i) {
            this.i = i;
            this.j0 = true;
            return this;
        }

        public d m(@ColorRes int i) {
            l(this.f2502a.getResources().getColor(i));
            return this;
        }

        public d n(@NonNull GravityEnum gravityEnum) {
            this.d = gravityEnum;
            return this;
        }

        public d o(@LayoutRes int i, boolean z) {
            return p(LayoutInflater.from(this.f2502a).inflate(i, (ViewGroup) null), z);
        }

        public d p(@NonNull View view, boolean z) {
            if (this.j != null) {
                throw new IllegalStateException("You cannot use customView() when you have content set.");
            }
            if (this.k != null) {
                throw new IllegalStateException("You cannot use customView() when you have items set.");
            }
            if (this.b0 != null) {
                throw new IllegalStateException("You cannot use customView() with an input dialog");
            }
            if (this.X > -2 || this.V) {
                throw new IllegalStateException("You cannot use customView() with a progress dialog");
            }
            this.o = view;
            this.R = z;
            N(R$color.color_00C85A);
            J(R$color.color_CCCCCC);
            return this;
        }

        public d q(float f) {
            this.h0 = f;
            return this;
        }

        public d r(@NonNull DialogInterface.OnDismissListener onDismissListener) {
            this.M = onDismissListener;
            return this;
        }

        public d s(int i) {
            this.S = i;
            return this;
        }

        public d t(@ColorRes int i) {
            return s(this.f2502a.getResources().getColor(i));
        }

        public d u() {
            d dVarI = l(Color.parseColor("#999999")).I(Color.parseColor("#CCCCCC"));
            GravityEnum gravityEnum = GravityEnum.CENTER;
            return dVarI.X(gravityEnum).n(gravityEnum);
        }

        public d v(boolean z) {
            this.l0 = z;
            return this;
        }

        public final Context w() {
            return this.f2502a;
        }

        public final int x() {
            return this.U;
        }

        public final GravityEnum y() {
            return this.f;
        }

        public final Typeface z() {
            return this.G;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(MaterialDialog materialDialog, CharSequence charSequence);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        void a(MaterialDialog materialDialog, View view, int i, CharSequence charSequence);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
        boolean a(MaterialDialog materialDialog, Integer[] numArr, CharSequence[] charSequenceArr);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface i {
        boolean a(MaterialDialog materialDialog, View view, int i, CharSequence charSequence);
    }

    @SuppressLint({"InflateParams"})
    public MaterialDialog(d dVar) {
        super(dVar.f2502a, com.afollestad.materialdialogs.a.c(dVar));
        this.d = dVar;
        this.c = (MDRootLayout) LayoutInflater.from(dVar.f2502a).inflate(com.afollestad.materialdialogs.a.b(dVar), (ViewGroup) null);
        com.afollestad.materialdialogs.a.d(this);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = dVar.h0;
        boolean z = dVar.l0;
        if (z) {
            attributes.width = -1;
        }
        if (z) {
            getWindow().setBackgroundDrawableResource(R.color.transparent);
        } else {
            getWindow().setBackgroundDrawableResource(R$drawable.md_wid_bg);
        }
    }

    @Override // defpackage.ic1
    public /* bridge */ /* synthetic */ void c(boolean z) {
        super.c(z);
    }

    public final void e() {
        ListView listView = this.e;
        if (listView == null) {
            return;
        }
        listView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public final View f(@NonNull DialogAction dialogAction) {
        int i2 = c.f2501a[dialogAction.ordinal()];
        return i2 != 1 ? i2 != 2 ? this.c.findViewById(R$id.buttonDefaultPositive) : this.c.findViewById(R$id.buttonDefaultNegative) : this.c.findViewById(R$id.buttonDefaultNeutral);
    }

    public final d g() {
        return this.d;
    }

    public Drawable h(DialogAction dialogAction, boolean z) {
        if (z) {
            d dVar = this.d;
            if (dVar.n0 != 0) {
                return ResourcesCompat.getDrawable(dVar.f2502a.getResources(), this.d.n0, null);
            }
            Context context = dVar.f2502a;
            int i2 = R$attr.md_btn_stacked_selector;
            Drawable drawableK = ed1.k(context, i2);
            return drawableK != null ? drawableK : ed1.k(getContext(), i2);
        }
        int i3 = c.f2501a[dialogAction.ordinal()];
        if (i3 == 1) {
            d dVar2 = this.d;
            if (dVar2.p0 != 0) {
                return ResourcesCompat.getDrawable(dVar2.f2502a.getResources(), this.d.p0, null);
            }
            Context context2 = dVar2.f2502a;
            int i4 = R$attr.md_btn_neutral_selector;
            Drawable drawableK2 = ed1.k(context2, i4);
            return drawableK2 != null ? drawableK2 : ed1.k(getContext(), i4);
        }
        if (i3 != 2) {
            d dVar3 = this.d;
            if (dVar3.o0 != 0) {
                return ResourcesCompat.getDrawable(dVar3.f2502a.getResources(), this.d.o0, null);
            }
            Context context3 = dVar3.f2502a;
            int i5 = R$attr.md_btn_positive_selector;
            Drawable drawableK3 = ed1.k(context3, i5);
            return drawableK3 != null ? drawableK3 : ed1.k(getContext(), i5);
        }
        d dVar4 = this.d;
        if (dVar4.q0 != 0) {
            return ResourcesCompat.getDrawable(dVar4.f2502a.getResources(), this.d.q0, null);
        }
        Context context4 = dVar4.f2502a;
        int i6 = R$attr.md_btn_negative_selector;
        Drawable drawableK4 = ed1.k(context4, i6);
        return drawableK4 != null ? drawableK4 : ed1.k(getContext(), i6);
    }

    @Nullable
    public final TextView i() {
        return this.m;
    }

    @Nullable
    public final View j() {
        return this.d.o;
    }

    @Nullable
    public final EditText k() {
        return this.n;
    }

    public final Drawable l() {
        d dVar = this.d;
        if (dVar.m0 != 0) {
            return ResourcesCompat.getDrawable(dVar.f2502a.getResources(), this.d.m0, null);
        }
        Context context = dVar.f2502a;
        int i2 = R$attr.md_list_selector;
        Drawable drawableK = ed1.k(context, i2);
        return drawableK != null ? drawableK : ed1.k(getContext(), i2);
    }

    @Nullable
    public final ListView m() {
        return this.e;
    }

    public void n(int i2) {
        TextView textView = this.o;
        if (textView != null) {
            textView.setText(i2 + "/" + this.d.f0);
            d dVar = this.d;
            boolean z = i2 > dVar.f0;
            int i3 = z ? dVar.g0 : dVar.i;
            int i4 = z ? dVar.g0 : dVar.p;
            this.o.setTextColor(i3);
            sb3.c(this.n, i4);
            f(DialogAction.POSITIVE).setEnabled(!z);
        }
    }

    public final void o() {
        ListView listView = this.e;
        if (listView == null) {
            return;
        }
        d dVar = this.d;
        CharSequence[] charSequenceArr = dVar.k;
        if ((charSequenceArr == null || charSequenceArr.length == 0) && dVar.L == null) {
            return;
        }
        listView.setAdapter(dVar.L);
        if (this.s == null && this.d.x == null) {
            return;
        }
        this.e.setOnItemClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        int i2 = c.f2501a[((DialogAction) view.getTag()).ordinal()];
        if (i2 == 1) {
            e eVar = this.d.t;
            if (eVar != null) {
                eVar.onNeutral(this);
            }
            if (this.d.F) {
                dismiss();
                return;
            }
            return;
        }
        if (i2 == 2) {
            e eVar2 = this.d.t;
            if (eVar2 != null) {
                eVar2.onNegative(this);
            }
            if (this.d.F) {
                dismiss();
                return;
            }
            return;
        }
        if (i2 != 3) {
            return;
        }
        e eVar3 = this.d.t;
        if (eVar3 != null) {
            eVar3.onPositive(this);
        }
        if (this.d.v != null) {
            r(view);
        }
        if (this.d.w != null) {
            q();
        }
        d dVar = this.d;
        f fVar = dVar.b0;
        if (fVar != null && (editText = this.n) != null && !dVar.e0) {
            fVar.a(this, editText.getText());
        }
        if (this.d.F) {
            dismiss();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        boolean zR;
        d dVar;
        d dVar2 = this.d;
        if (dVar2.x != null) {
            CharSequence text = view instanceof TextView ? ((TextView) view).getText() : null;
            if (TextUtils.isEmpty(text) && (dVar = this.d) != null) {
                CharSequence[] charSequenceArr = dVar.k;
                if (charSequenceArr.length > i2) {
                    text = charSequenceArr[i2];
                }
            }
            this.d.x.a(this, view, i2, text);
            return;
        }
        ListType listType = this.s;
        if (listType == null || listType == ListType.REGULAR) {
            if (dVar2.F) {
                dismiss();
            }
            d dVar3 = this.d;
            dVar3.u.a(this, view, i2, dVar3.k[i2]);
            return;
        }
        if (listType == ListType.MULTI) {
            boolean z = !this.t.contains(Integer.valueOf(i2));
            CheckBox checkBox = (CheckBox) view.findViewById(R$id.control);
            if (!z) {
                this.t.remove(Integer.valueOf(i2));
                checkBox.setChecked(false);
                if (this.d.y) {
                    q();
                    return;
                }
                return;
            }
            this.t.add(Integer.valueOf(i2));
            if (!this.d.y) {
                checkBox.setChecked(true);
                return;
            } else if (q()) {
                checkBox.setChecked(true);
                return;
            } else {
                this.t.remove(Integer.valueOf(i2));
                return;
            }
        }
        if (listType == ListType.SINGLE) {
            com.afollestad.materialdialogs.b bVar = (com.afollestad.materialdialogs.b) dVar2.L;
            RadioButton radioButton = (RadioButton) view.findViewById(R$id.control);
            d dVar4 = this.d;
            if (dVar4.F && dVar4.l == null) {
                dismiss();
                this.d.D = i2;
                r(view);
                zR = false;
            } else if (dVar4.z) {
                int i3 = dVar4.D;
                dVar4.D = i2;
                zR = r(view);
                this.d.D = i3;
            } else {
                zR = true;
            }
            if (zR) {
                d dVar5 = this.d;
                if (dVar5.D != i2) {
                    dVar5.D = i2;
                    if (bVar.c == null) {
                        bVar.d = true;
                        bVar.notifyDataSetChanged();
                    }
                    RadioButton radioButton2 = bVar.c;
                    if (radioButton2 != null) {
                        radioButton2.setChecked(false);
                    }
                    radioButton.setChecked(true);
                    bVar.c = radioButton;
                }
            }
        }
    }

    @Override // defpackage.ic1, android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        if (this.n != null) {
            ed1.p(this, this.d);
            if (this.n.getText().length() > 0) {
                EditText editText = this.n;
                editText.setSelection(editText.getText().length());
            }
        }
        com.afollestad.materialdialogs.a.e(this);
        super.onShow(dialogInterface);
    }

    @Override // defpackage.ic1, android.app.Dialog
    public void onStop() {
        super.onStop();
        if (this.n != null) {
            ed1.c(this, this.d);
        }
    }

    public final boolean p() {
        return !isShowing();
    }

    public final boolean q() {
        Collections.sort(this.t);
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.t.iterator();
        while (it.hasNext()) {
            arrayList.add(this.d.k[it.next().intValue()]);
        }
        h hVar = this.d.w;
        List<Integer> list = this.t;
        return hVar.a(this, (Integer[]) list.toArray(new Integer[list.size()]), (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]));
    }

    public final boolean r(View view) {
        d dVar = this.d;
        int i2 = dVar.D;
        return dVar.v.a(this, view, i2, i2 >= 0 ? dVar.k[i2] : null);
    }

    public final void s(CharSequence charSequence) {
        this.m.setText(charSequence);
        this.m.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    @Override // android.app.Dialog
    public final void setTitle(@NonNull CharSequence charSequence) {
        this.g.setText(charSequence);
    }

    @Override // android.app.Dialog
    public void show() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Dialogs can only be shown from the UI thread.");
        }
        try {
            super.show();
        } catch (WindowManager.BadTokenException e2) {
            e2.printStackTrace();
        }
    }

    public void t() {
        EditText editText = this.n;
        if (editText == null) {
            return;
        }
        editText.addTextChangedListener(new b());
    }

    public final void u(CharSequence[] charSequenceArr) {
        d dVar = this.d;
        ListAdapter listAdapter = dVar.L;
        if (listAdapter == null) {
            throw new IllegalStateException("This MaterialDialog instance does not yet have an adapter set to it. You cannot use setItems().");
        }
        if (!(listAdapter instanceof com.afollestad.materialdialogs.b)) {
            throw new IllegalStateException("When using a custom adapter, setItems() cannot be used. Set items through the adapter instead.");
        }
        dVar.L = new com.afollestad.materialdialogs.b(this, ListType.getLayoutForType(this.s), R$id.title, charSequenceArr);
        d dVar2 = this.d;
        dVar2.k = charSequenceArr;
        this.e.setAdapter(dVar2.L);
    }

    public final void v(TextView textView, Typeface typeface) {
        if (typeface == null) {
            return;
        }
        textView.setPaintFlags(textView.getPaintFlags() | 128);
        textView.setTypeface(typeface);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            MaterialDialog materialDialog = MaterialDialog.this;
            d dVar = materialDialog.d;
            if (dVar.e0) {
                dVar.b0.a(materialDialog, charSequence);
            }
            int length = charSequence.toString().length();
            MaterialDialog materialDialog2 = MaterialDialog.this;
            if (!materialDialog2.d.c0) {
                materialDialog2.f(DialogAction.POSITIVE).setEnabled(length > 0);
            }
            MaterialDialog.this.n(length);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class e {
        public final Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public final boolean equals(Object obj) {
            return super.equals(obj);
        }

        public final void finalize() throws Throwable {
            super.finalize();
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public final String toString() {
            return super.toString();
        }

        public void onNegative(MaterialDialog materialDialog) {
        }

        public void onNeutral(MaterialDialog materialDialog) {
        }

        public void onPositive(MaterialDialog materialDialog) {
        }
    }
}
