package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.ui.a;
import com.huawei.hms.ads.jsb.constant.Constant;
import defpackage.cj2;
import defpackage.f10;
import defpackage.g86;
import defpackage.on5;
import defpackage.oz;
import defpackage.pr0;
import defpackage.vh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
final class WebViewSubtitleOutput extends FrameLayout implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CanvasSubtitleOutput f5999a;
    public final WebView b;
    public List<pr0> c;
    public oz d;
    public float e;
    public int f;
    public float g;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends WebView {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6001a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f6001a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6001a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6001a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WebViewSubtitleOutput(Context context) {
        this(context, null);
    }

    public static int b(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public static String c(@Nullable Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = b.f6001a[alignment.ordinal()];
        return i != 1 ? i != 2 ? "center" : "end" : "start";
    }

    public static String d(oz ozVar) {
        int i = ozVar.d;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unset" : g86.C("-0.05em -0.05em 0.15em %s", cj2.b(ozVar.e)) : g86.C("0.06em 0.08em 0.15em %s", cj2.b(ozVar.e)) : g86.C("0.1em 0.12em 0.15em %s", cj2.b(ozVar.e)) : g86.C("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", cj2.b(ozVar.e));
    }

    public static String f(int i) {
        return i != 1 ? i != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    public static String h(pr0 pr0Var) {
        float f = pr0Var.q;
        if (f == 0.0f) {
            return "";
        }
        int i = pr0Var.p;
        return g86.C("%s(%.2fdeg)", (i == 2 || i == 1) ? "skewY" : "skewX", Float.valueOf(f));
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<pr0> list, oz ozVar, float f, int i, float f2) {
        this.d = ozVar;
        this.e = f;
        this.f = i;
        this.g = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            pr0 pr0Var = list.get(i2);
            if (pr0Var.d != null) {
                arrayList.add(pr0Var);
            } else {
                arrayList2.add(pr0Var);
            }
        }
        if (!this.c.isEmpty() || !arrayList2.isEmpty()) {
            this.c = arrayList2;
            i();
        }
        this.f5999a.a(arrayList, ozVar, f, i, f2);
        invalidate();
    }

    public final String e(int i, float f) {
        float fH = on5.h(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fH == -3.4028235E38f ? "unset" : g86.C("%.2fpx", Float.valueOf(fH / getContext().getResources().getDisplayMetrics().density));
    }

    public void g() {
        this.b.destroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i() {
        String strC;
        int iB;
        boolean z;
        float f;
        String strC2;
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        Iterator it;
        Layout.Alignment alignment;
        WebViewSubtitleOutput webViewSubtitleOutput = this;
        StringBuilder sb = new StringBuilder();
        char c = 0;
        int i5 = 1;
        float f2 = 1.2f;
        sb.append(g86.C("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", cj2.b(webViewSubtitleOutput.d.f19903a), webViewSubtitleOutput.e(webViewSubtitleOutput.f, webViewSubtitleOutput.e), Float.valueOf(1.2f), d(webViewSubtitleOutput.d)));
        HashMap map = new HashMap();
        map.put(cj2.a("default_bg"), g86.C("background-color:%s;", cj2.b(webViewSubtitleOutput.d.b)));
        int i6 = 0;
        while (i6 < webViewSubtitleOutput.c.size()) {
            pr0 pr0Var = webViewSubtitleOutput.c.get(i6);
            float f3 = pr0Var.h;
            float f4 = f3 != -3.4028235E38f ? f3 * 100.0f : 50.0f;
            int iB2 = b(pr0Var.i);
            float f5 = pr0Var.e;
            if (f5 == -3.4028235E38f) {
                Object[] objArr = new Object[i5];
                objArr[c] = Float.valueOf((1.0f - webViewSubtitleOutput.g) * 100.0f);
                strC = g86.C("%.2f%%", objArr);
                iB = -100;
            } else if (pr0Var.f != i5) {
                Object[] objArr2 = new Object[i5];
                objArr2[c] = Float.valueOf(f5 * 100.0f);
                strC = g86.C("%.2f%%", objArr2);
                iB = pr0Var.p == i5 ? -b(pr0Var.g) : b(pr0Var.g);
            } else if (f5 >= 0.0f) {
                Object[] objArr3 = new Object[i5];
                objArr3[c] = Float.valueOf(f5 * f2);
                strC = g86.C("%.2fem", objArr3);
                iB = 0;
            } else {
                Object[] objArr4 = new Object[i5];
                objArr4[c] = Float.valueOf(((-f5) - 1.0f) * f2);
                strC = g86.C("%.2fem", objArr4);
                iB = 0;
                z = true;
                f = pr0Var.j;
                if (f == -3.4028235E38f) {
                    Object[] objArr5 = new Object[i5];
                    objArr5[0] = Float.valueOf(f * 100.0f);
                    strC2 = g86.C("%.2f%%", objArr5);
                } else {
                    strC2 = "fit-content";
                }
                String strC3 = c(pr0Var.b);
                String strF = f(pr0Var.p);
                String strE = webViewSubtitleOutput.e(pr0Var.n, pr0Var.o);
                String strB = cj2.b(!pr0Var.l ? pr0Var.m : webViewSubtitleOutput.d.c);
                i = iB;
                i2 = pr0Var.p;
                String str2 = "right";
                String str3 = "left";
                String str4 = Constant.MAP_KEY_TOP;
                if (i2 != 1) {
                    if (z) {
                    }
                    str3 = Constant.MAP_KEY_TOP;
                    i3 = 2;
                    str4 = str2;
                } else if (i2 != 2) {
                    if (z) {
                        str4 = "bottom";
                    }
                    i3 = 2;
                } else {
                    if (!z) {
                        str2 = "left";
                    }
                    str3 = Constant.MAP_KEY_TOP;
                    i3 = 2;
                    str4 = str2;
                }
                if (i2 != i3 || i2 == 1) {
                    str = "height";
                    i4 = i;
                    i = iB2;
                } else {
                    str = "width";
                    i4 = iB2;
                }
                a.b bVarA = com.google.android.exoplayer2.ui.a.a(pr0Var.f20082a, getContext().getResources().getDisplayMetrics().density);
                it = map.keySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = it;
                    String str5 = (String) it.next();
                    a.b bVar = bVarA;
                    String str6 = (String) map.put(str5, (String) map.get(str5));
                    vh.g(str6 == null || str6.equals(map.get(str5)));
                    it = it2;
                    bVarA = bVar;
                }
                a.b bVar2 = bVarA;
                sb.append(g86.C("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i6), str3, Float.valueOf(f4), str4, strC, str, strC2, strC3, strF, strE, strB, Integer.valueOf(i4), Integer.valueOf(i), h(pr0Var)));
                sb.append(g86.C("<span class='%s'>", "default_bg"));
                alignment = pr0Var.c;
                if (alignment == null) {
                    sb.append(g86.C("<span style='display:inline-block; text-align:%s;'>", c(alignment)));
                    sb.append(bVar2.f6003a);
                    sb.append("</span>");
                } else {
                    sb.append(bVar2.f6003a);
                }
                sb.append("</span>");
                sb.append("</div>");
                i6++;
                f2 = 1.2f;
                c = 0;
                webViewSubtitleOutput = this;
                i5 = 1;
            }
            z = false;
            f = pr0Var.j;
            if (f == -3.4028235E38f) {
            }
            String strC32 = c(pr0Var.b);
            String strF2 = f(pr0Var.p);
            String strE2 = webViewSubtitleOutput.e(pr0Var.n, pr0Var.o);
            String strB2 = cj2.b(!pr0Var.l ? pr0Var.m : webViewSubtitleOutput.d.c);
            i = iB;
            i2 = pr0Var.p;
            String str22 = "right";
            String str32 = "left";
            String str42 = Constant.MAP_KEY_TOP;
            if (i2 != 1) {
            }
            if (i2 != i3) {
                str = "height";
                i4 = i;
                i = iB2;
            }
            a.b bVarA2 = com.google.android.exoplayer2.ui.a.a(pr0Var.f20082a, getContext().getResources().getDisplayMetrics().density);
            it = map.keySet().iterator();
            while (it.hasNext()) {
            }
            a.b bVar22 = bVarA2;
            sb.append(g86.C("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i6), str32, Float.valueOf(f4), str42, strC, str, strC2, strC32, strF2, strE2, strB2, Integer.valueOf(i4), Integer.valueOf(i), h(pr0Var)));
            sb.append(g86.C("<span class='%s'>", "default_bg"));
            alignment = pr0Var.c;
            if (alignment == null) {
            }
            sb.append("</span>");
            sb.append("</div>");
            i6++;
            f2 = 1.2f;
            c = 0;
            webViewSubtitleOutput = this;
            i5 = 1;
        }
        sb.append("</div></body></html>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<html><head><style>");
        for (String str7 : map.keySet()) {
            sb2.append(str7);
            sb2.append("{");
            sb2.append((String) map.get(str7));
            sb2.append("}");
        }
        sb2.append("</style></head>");
        sb.insert(0, sb2.toString());
        this.b.loadData(Base64.encodeToString(sb.toString().getBytes(f10.c), 1), "text/html", "base64");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z || this.c.isEmpty()) {
            return;
        }
        i();
    }

    public WebViewSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = Collections.emptyList();
        this.d = oz.g;
        this.e = 0.0533f;
        this.f = 0;
        this.g = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, attributeSet);
        this.f5999a = canvasSubtitleOutput;
        a aVar = new a(context, attributeSet);
        this.b = aVar;
        aVar.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(aVar);
    }
}
