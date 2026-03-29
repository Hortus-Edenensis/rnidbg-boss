package com.opos.mobad.template.h;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.j;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class v extends com.opos.mobad.template.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f10068a;
    private Context b;
    private com.opos.mobad.d.a c;
    private ImageView g;
    private com.opos.mobad.template.d.b h;
    private boolean i;
    private com.opos.mobad.template.k.c j;
    private s k;
    private com.opos.mobad.template.cmn.n l;
    private TextView m;
    private ProgressBar n;
    private TextView o;
    private j.b p;

    public v(Context context, int i, boolean z, com.opos.mobad.d.a aVar) {
        super(i);
        this.p = new j.b() { // from class: com.opos.mobad.template.h.v.3
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return v.this.n() == 8;
            }
        };
        this.b = context.getApplicationContext();
        this.c = aVar;
        this.i = z;
        i();
    }

    private int b(com.opos.mobad.template.d.b bVar) {
        String str = bVar.J.containsKey("EXT_PARAM_KEY_GAME_LOADING") ? bVar.J.get("EXT_PARAM_KEY_GAME_LOADING") : "";
        if (!TextUtils.isEmpty(str)) {
            try {
                return (int) Math.min(100.0d, Math.max(0.0d, Double.parseDouble(str)));
            } catch (NumberFormatException unused) {
                com.opos.cmn.an.f.a.d("RewardLoadingPage", " NumberFormatException EXT_PARAM_KEY_GAME_LOADING not number");
            }
        }
        return 0;
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.f10068a = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 29) {
            this.f10068a.setForceDarkAllowed(false);
        }
        p();
    }

    private void p() {
        ImageView imageView = new ImageView(this.b);
        this.g = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f10068a.addView(this.g, new RelativeLayout.LayoutParams(-1, -1));
        View view = new View(this.b);
        view.setBackgroundColor(Color.parseColor("#66000000"));
        this.f10068a.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        q();
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.i) {
            layoutParams.addRule(14);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 280.0f);
        } else {
            layoutParams.addRule(13);
        }
        this.f10068a.addView(linearLayout, layoutParams);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.b, com.opos.cmn.an.h.f.a.a(r5, 16.0f));
        this.l = nVar;
        nVar.setId(View.generateViewId());
        this.l.setScaleType(ImageView.ScaleType.FIT_XY);
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 80.0f);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iA, iA);
        this.l.setLayoutParams(layoutParams2);
        linearLayout.addView(this.l, layoutParams2);
        TextView textView = new TextView(this.b);
        this.m = textView;
        textView.setTextColor(-1);
        this.m.setTextSize(1, 18.0f);
        this.m.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.m.setSingleLine(true);
        com.opos.mobad.template.h.a(this.m);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 8.0f);
        linearLayout.addView(this.m, layoutParams3);
        a(linearLayout);
        TextView textView2 = new TextView(this.b);
        this.o = textView2;
        textView2.setTextColor(Color.argb(138, 255, 255, 255));
        this.o.setTextSize(1, 16.0f);
        this.o.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.o.setSingleLine(true);
        com.opos.mobad.template.h.a(this.o);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 14.0f);
        linearLayout.addView(this.o, layoutParams4);
    }

    private void q() {
        int iA;
        int iA2;
        this.j = com.opos.mobad.template.k.c.a(this.b, 3, 0, this.c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 24.0f));
        layoutParams.addRule(9);
        if (this.i) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 51.0f);
            iA = com.opos.cmn.an.h.f.a.a(this.b, 16.0f);
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 18.0f);
            iA = com.opos.cmn.an.h.f.a.a(this.b, 24.0f);
        }
        layoutParams.leftMargin = iA;
        this.k = s.a(this.b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        if (this.i) {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 49.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(this.b, 16.0f);
        } else {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 16.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(this.b, 24.0f);
        }
        layoutParams2.rightMargin = iA2;
        if (!this.i) {
            this.f10068a.addView(this.j, layoutParams);
            this.f10068a.addView(this.k, layoutParams2);
            return;
        }
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.b);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 94.0f));
        layoutParams3.addRule(10);
        cVar.setLayoutParams(layoutParams3);
        cVar.addView(this.j, layoutParams);
        cVar.addView(this.k, layoutParams2);
        this.f10068a.addView(cVar);
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        return false;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        return false;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        RelativeLayout relativeLayout = this.f10068a;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    public static v a(Context context, com.opos.mobad.d.a aVar, int i) {
        if (context == null) {
            return null;
        }
        return new v(context, i, false, aVar);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.f10068a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.v.2
            @Override // java.lang.Runnable
            public void run() {
                if (v.this.n() == 8) {
                    return;
                }
                if (v.this.l != null) {
                    v.this.l.setImageBitmap(bitmap);
                }
                if (v.this.g != null) {
                    v.this.g.setImageBitmap(com.opos.mobad.template.cmn.f.a(v.this.b, bitmap, 100, 1.0f, 60.0f));
                }
            }
        });
    }

    public static v b(Context context, com.opos.mobad.d.a aVar, int i) {
        if (context == null) {
            return null;
        }
        return new v(context, i, true, aVar);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.d.a aVar = this.c;
        if (aVar == null) {
            return;
        }
        com.opos.mobad.template.d.e eVar = bVar.k;
        com.opos.mobad.template.cmn.j.a(eVar.f9414a, eVar.b, aVar, new j.a() { // from class: com.opos.mobad.template.h.v.1
            @Override // com.opos.mobad.template.cmn.j.a
            public void a(int i, Bitmap bitmap) {
                if (i == 1) {
                    v.this.a(bitmap);
                }
                v.this.b(i);
            }

            @Override // com.opos.mobad.template.cmn.j.a
            public void a(Bitmap bitmap) {
                if (v.this.n() == 8) {
                    return;
                }
                v.this.a(bitmap);
            }
        }, this.p);
    }

    private void a(LinearLayout linearLayout) {
        ProgressBar progressBar = new ProgressBar(this.b);
        this.n = progressBar;
        progressBar.setId(View.generateViewId());
        com.opos.mobad.template.cmn.af.a(this.n, "mOnlyIndeterminate", new Boolean(false));
        this.n.setIndeterminate(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 216.0f), com.opos.cmn.an.h.f.a.a(this.b, 6.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 32.0f);
        linearLayout.addView(this.n, layoutParams);
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 6.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.argb(87, 255, 255, 255));
        float f = iA;
        gradientDrawable.setCornerRadius(f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(f);
        ScaleDrawable scaleDrawable = new ScaleDrawable(gradientDrawable2, GravityCompat.START, 1.0f, 0.0f);
        scaleDrawable.setLevel(1);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, scaleDrawable});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        this.n.setProgressDrawable(layerDrawable);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        a.InterfaceC0778a interfaceC0778a2 = this.e;
        if (interfaceC0778a2 != null) {
            com.opos.mobad.template.k.c cVar = this.j;
            if (cVar != null) {
                cVar.a(interfaceC0778a2);
            }
            s sVar = this.k;
            if (sVar != null) {
                sVar.a(this.e);
            }
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.k.c cVar = this.j;
        if (cVar != null) {
            cVar.a(bVar.p, (String) null, bVar.e, bVar.g, bVar.i);
        }
        c(bVar);
        if (this.m != null && !TextUtils.isEmpty(bVar.b)) {
            this.m.setText(bVar.b);
        }
        ProgressBar progressBar = this.n;
        if (progressBar != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                progressBar.setProgress(b(bVar), true);
            } else {
                progressBar.setProgress(b(bVar));
            }
        }
        if (bVar.J.containsKey("EXT_PARAM_KEY_GAME_DES")) {
            String str = bVar.J.get("EXT_PARAM_KEY_GAME_DES");
            if (this.o == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.o.setText(str);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("RewardLoadingPage", "data is null");
            a(1);
            return;
        }
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            com.opos.cmn.an.f.a.d("", "adShowData is null");
            a(1);
            return;
        }
        com.opos.mobad.template.d.e eVar = bVarA.k;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            com.opos.cmn.an.f.a.b("RewardLoadingPage", "icon is null");
            a(1);
        } else {
            com.opos.cmn.an.f.a.b("RewardLoadingPage", "render");
            a(bVarA);
            this.h = bVarA;
        }
    }
}
