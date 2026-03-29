package com.opos.mobad.template.k;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.p;
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ImageView f10193a;
    RelativeLayout.LayoutParams b;
    TextView c;
    RelativeLayout.LayoutParams d;
    RelativeLayout e;
    RelativeLayout.LayoutParams f;
    TextView g;
    RelativeLayout.LayoutParams h;
    TextView i;
    RelativeLayout.LayoutParams j;
    p l;
    private com.opos.mobad.d.a m;
    private a.InterfaceC0778a n;
    private int o;
    private int p;

    public c(Context context, int i, int i2, com.opos.mobad.d.a aVar) {
        super(context);
        this.o = 0;
        this.p = 0;
        this.l = new p() { // from class: com.opos.mobad.template.k.c.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("LogoBar", "onFeedBackClick");
                if (c.this.n != null) {
                    c.this.n.a(view, iArr);
                }
            }
        };
        this.m = aVar;
        this.o = i;
        this.p = i2;
        b();
    }

    public static final View a(final com.opos.mobad.template.d.b bVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.opos.mobad.d.a aVar, a.InterfaceC0778a interfaceC0778a) {
        if (viewGroup == null) {
            return null;
        }
        final Context context = viewGroup.getContext();
        final w wVar = new w(context);
        wVar.setVisibility(4);
        wVar.setGravity(17);
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        if (bVar != null && bVar.e) {
            com.opos.mobad.template.d.e eVar = bVar.g;
            if (eVar == null || com.opos.cmn.an.d.b.a(eVar.f9414a)) {
                TextView textView = new TextView(context);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(context, 14.0f));
                textView.setLayoutParams(layoutParams2);
                textView.setMaxEms(6);
                textView.setTextSize(1, 10.0f);
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                textView.setGravity(17);
                textView.setText(!TextUtils.isEmpty(bVar.i) ? bVar.i : "广告");
                wVar.setPadding(com.opos.cmn.an.h.f.a.a(context, 3.0f), 0, com.opos.cmn.an.h.f.a.a(context, 3.0f), 0);
                wVar.addView(textView, layoutParams2);
                wVar.a(com.opos.cmn.an.h.f.a.a(context, 4.0f));
                wVar.setBackgroundColor(Color.parseColor("#8A42464C"));
                wVar.setVisibility(0);
            } else {
                com.opos.mobad.template.d.e eVar2 = bVar.g;
                h.a(interfaceC0778a, eVar2.f9414a, aVar, eVar2.b, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.k.c.3
                    @Override // com.opos.mobad.template.b
                    public void a(Bitmap bitmap) {
                        BitmapDrawable bitmapDrawableA = bitmap != null ? h.a(context, bitmap) : null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("getLogoDrawable=");
                        sb.append(bitmapDrawableA != null ? bitmapDrawableA : com.igexin.push.core.b.m);
                        com.opos.cmn.an.f.a.b("LogoBar", sb.toString());
                        if (bitmapDrawableA != null) {
                            ImageView imageView = new ImageView(context);
                            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 38.0f), com.opos.cmn.an.h.f.a.a(context, 14.0f));
                            imageView.setBackground(bitmapDrawableA);
                            wVar.addView(imageView, layoutParams3);
                        } else {
                            TextView textView2 = new TextView(context);
                            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(context, 14.0f));
                            textView2.setLayoutParams(layoutParams4);
                            textView2.setMaxEms(6);
                            textView2.setTextSize(1, 10.0f);
                            textView2.setTextColor(Color.parseColor("#FFFFFF"));
                            textView2.setGravity(17);
                            textView2.setText(!TextUtils.isEmpty(bVar.i) ? bVar.i : "广告");
                            wVar.setPadding(com.opos.cmn.an.h.f.a.a(context, 3.0f), 0, com.opos.cmn.an.h.f.a.a(context, 3.0f), 0);
                            wVar.addView(textView2, layoutParams4);
                        }
                        wVar.a(com.opos.cmn.an.h.f.a.a(context, 4.0f));
                        wVar.setBackgroundColor(Color.parseColor("#8A42464C"));
                        wVar.setVisibility(0);
                    }
                });
            }
        }
        viewGroup.addView(wVar, layoutParams);
        return wVar;
    }

    private void b() {
        TextView textView;
        int color;
        Context context;
        int i;
        setVisibility(4);
        setGravity(17);
        ImageView imageView = new ImageView(getContext());
        this.f10193a = imageView;
        imageView.setId(View.generateViewId());
        if (this.o == 3) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 44.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
            this.b = layoutParams;
            layoutParams.addRule(15);
        } else {
            this.b = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 38.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        }
        TextView textView2 = new TextView(getContext());
        this.c = textView2;
        textView2.setId(View.generateViewId());
        if (this.o == 3) {
            this.d = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
            this.c.setTextSize(1, 12.0f);
            this.d.addRule(15);
        } else {
            this.d = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
            this.c.setTextSize(1, 10.0f);
        }
        this.c.setLayoutParams(this.d);
        this.c.setMaxEms(6);
        h.a(this.c);
        int i2 = this.o;
        if (i2 == 0 || i2 == 3) {
            textView = this.c;
            color = Color.parseColor("#FFFFFF");
        } else if (i2 == 2) {
            textView = this.c;
            color = Color.parseColor("#66000000");
        } else {
            textView = this.c;
            color = getContext().getResources().getColor(R.color.opos_mobad_logo_text_color);
        }
        textView.setTextColor(color);
        this.c.setGravity(17);
        this.c.setText("广告");
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.e = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.e.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 14.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        this.f = layoutParams2;
        layoutParams2.addRule(15);
        ImageView imageView2 = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 14.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams3.addRule(13);
        if (this.p == 1) {
            context = getContext();
            i = R.drawable.opos_mobad_feedback_close;
        } else {
            context = getContext();
            i = R.drawable.opos_mobad_feedback_down;
        }
        Drawable drawable = ContextCompat.getDrawable(context, i);
        int i3 = this.o;
        DrawableCompat.setTint(drawable, (i3 == 0 || i3 == 3) ? Color.parseColor("#FFFFFF") : i3 == 2 ? Color.parseColor("#66000000") : ContextCompat.getColor(getContext(), R.color.opos_mobad_logo_text_color));
        imageView2.setImageDrawable(drawable);
        this.e.addView(imageView2, layoutParams3);
        if (this.o == 3) {
            TextView textView3 = new TextView(getContext());
            this.g = textView3;
            textView3.setId(View.generateViewId());
            this.g.setBackgroundColor(1308622847);
            this.g.setOnClickListener(null);
            this.g.setOnTouchListener(null);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
            this.h = layoutParams4;
            layoutParams4.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 8.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 8.0f), 0);
            this.h.addRule(15);
            TextView textView4 = new TextView(getContext());
            this.i = textView4;
            textView4.setTextSize(1, 14.0f);
            this.i.setTextColor(Color.parseColor("#FFFFFF"));
            this.i.setGravity(17);
            this.i.setSingleLine();
            this.i.setEllipsize(TextUtils.TruncateAt.END);
            this.i.setMinWidth(com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
            this.i.setOnClickListener(null);
            this.i.setOnTouchListener(null);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
            this.j = layoutParams5;
            layoutParams5.addRule(15);
            this.j.addRule(1, this.g.getId());
        }
    }

    public static c a(Context context, int i, int i2, com.opos.mobad.d.a aVar) {
        return new c(context, i, i2, aVar);
    }

    public void a(int i) {
        TextView textView = this.c;
        if (textView == null || i < 0) {
            return;
        }
        textView.setMaxEms(i);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("LogoBar", "setListener " + interfaceC0778a);
        this.n = interfaceC0778a;
    }

    private void a(com.opos.mobad.template.d.e eVar, final String str, final boolean z) {
        h.a(this.n, eVar.f9414a, this.m, eVar.b, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.k.c.1
            @Override // com.opos.mobad.template.b
            public void a(Bitmap bitmap) {
                RelativeLayout.LayoutParams layoutParams;
                View view;
                BitmapDrawable bitmapDrawableA = bitmap != null ? h.a(c.this.getContext(), bitmap) : null;
                StringBuilder sb = new StringBuilder();
                sb.append("getLogoDrawable=");
                sb.append(bitmapDrawableA != null ? bitmapDrawableA : com.igexin.push.core.b.m);
                com.opos.cmn.an.f.a.b("LogoBar", sb.toString());
                if (bitmapDrawableA == null) {
                    c.this.a(str, z);
                    return;
                }
                c.this.f10193a.setBackground(bitmapDrawableA);
                c cVar = c.this;
                cVar.addView(cVar.f10193a, cVar.b);
                c cVar2 = c.this;
                cVar2.f.addRule(1, cVar2.f10193a.getId());
                c cVar3 = c.this;
                cVar3.f.leftMargin = -com.opos.cmn.an.h.f.a.a(cVar3.getContext(), 3.0f);
                if (c.this.o != 3) {
                    c cVar4 = c.this;
                    cVar4.setPadding(0, 0, com.opos.cmn.an.h.f.a.a(cVar4.getContext(), 1.0f), 0);
                    c.this.a(com.opos.cmn.an.h.f.a.a(r6.getContext(), 4.0f));
                    return;
                }
                c cVar5 = c.this;
                cVar5.setPadding(com.opos.cmn.an.h.f.a.a(cVar5.getContext(), 12.0f), 0, com.opos.cmn.an.h.f.a.a(c.this.getContext(), 12.0f), 0);
                c.this.a(com.opos.cmn.an.h.f.a.a(r6.getContext(), 14.0f));
                if (z) {
                    c cVar6 = c.this;
                    layoutParams = cVar6.h;
                    view = cVar6.e;
                } else {
                    c cVar7 = c.this;
                    layoutParams = cVar7.h;
                    view = cVar7.f10193a;
                }
                layoutParams.addRule(1, view.getId());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.c.setText(str);
        }
        this.f.addRule(1, this.c.getId());
        if (this.o == 3) {
            a(com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
            setPadding(com.opos.cmn.an.h.f.a.a(getContext(), 12.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 12.0f), 0);
            this.h.addRule(1, (z ? this.e : this.c).getId());
        } else {
            if (z) {
                setPadding(com.opos.cmn.an.h.f.a.a(getContext(), 3.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), 0);
            } else {
                setPadding(com.opos.cmn.an.h.f.a.a(getContext(), 3.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 3.0f), 0);
            }
            a(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f));
        }
        addView(this.c, this.d);
    }

    private void a(boolean z) {
        p pVar;
        if (z) {
            this.e.setVisibility(0);
            setOnClickListener(this.l);
            pVar = this.l;
        } else {
            this.e.setVisibility(8);
            pVar = null;
            setOnClickListener(null);
        }
        setOnTouchListener(pVar);
    }

    public void a(boolean z, Drawable drawable) {
        if (getVisibility() != 0) {
            this.f10193a.setBackground(drawable);
            addView(this.f10193a, this.b);
            this.f.addRule(1, this.f10193a.getId());
            this.f.leftMargin = -com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
            if (this.o == 3) {
                setPadding(com.opos.cmn.an.h.f.a.a(getContext(), 12.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 12.0f), 0);
                a(com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
                this.h.addRule(1, (z ? this.e : this.f10193a).getId());
            } else {
                setPadding(0, 0, com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), 0);
                a(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f));
            }
            addView(this.e, this.f);
        }
        a(z);
        if (getVisibility() != 0) {
            setVisibility(0);
        }
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.template.d.e eVar, String str2) {
        if (z2 && getVisibility() != 0) {
            if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
                a(str2, z);
            } else {
                a(eVar, str2, z);
            }
            if (this.o == 3) {
                setBackgroundColor(Color.parseColor("#8A42464C"));
            }
            addView(this.e, this.f);
        }
        a(z);
        if (this.i != null) {
            if (TextUtils.isEmpty(str)) {
                this.i.setVisibility(8);
                this.g.setVisibility(8);
            } else {
                this.i.setText(str);
                if (indexOfChild(this.g) < 0) {
                    addView(this.g, this.h);
                    addView(this.i, this.j);
                    this.i.setVisibility(0);
                    this.g.setVisibility(0);
                } else {
                    updateViewLayout(this.g, this.h);
                    updateViewLayout(this.i, this.j);
                }
            }
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
    }

    public void a(boolean z, boolean z2, com.opos.mobad.template.d.e eVar, com.opos.mobad.template.d.e eVar2, String str) {
        GradientDrawable gradientDrawable;
        int iA;
        int color;
        if (z2 && getVisibility() != 0) {
            if (this.o != 2 && h.f(getContext())) {
                eVar = eVar2;
            }
            if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
                a(str, z);
            } else {
                a(eVar, str, z);
            }
            int i = this.o;
            if (i == 2) {
                gradientDrawable = new GradientDrawable();
                iA = com.opos.cmn.an.h.f.a.a(getContext(), 1.0f);
                color = Color.parseColor("#66000000");
            } else {
                if (i == 1) {
                    gradientDrawable = new GradientDrawable();
                    iA = com.opos.cmn.an.h.f.a.a(getContext(), 1.0f);
                    color = getContext().getResources().getColor(R.color.opos_mobad_logo_text_color);
                }
                addView(this.e, this.f);
            }
            gradientDrawable.setStroke(iA, color);
            gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f));
            setBackground(gradientDrawable);
            addView(this.e, this.f);
        }
        a(z);
        if (getVisibility() != 0) {
            setVisibility(0);
        }
    }

    public void a(boolean z, boolean z2, com.opos.mobad.template.d.e eVar, String str) {
        if (z2 && getVisibility() != 0) {
            if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
                a(str, z);
            } else {
                a(eVar, str, z);
            }
            if (this.o == 0) {
                setBackgroundColor(Color.parseColor("#8A42464C"));
            }
            addView(this.e, this.f);
        }
        a(z);
        if (getVisibility() != 0) {
            setVisibility(0);
        }
    }
}
