package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class y extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f9881a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private String j;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private a.InterfaceC0778a r;

    public y(Context context, int i, boolean z) {
        super(context);
        this.j = "#8CFFFFFF";
        this.l = "#4DFFFFFF";
        this.m = "#D9FFFFFF";
        this.n = "#2F80ED";
        this.o = "#3B000000";
        this.p = "#99FFFFFF";
        this.q = "#007BFF";
        a(i, z);
    }

    public static y b(Context context) {
        return new y(context, 2, false);
    }

    public static y c(Context context) {
        return new y(context, 0, false);
    }

    public static y a(Context context) {
        return new y(context, 1, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0326  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, boolean z) {
        int iA;
        int iA2;
        TextView textView;
        String str;
        int iA3;
        TextView textView2;
        String str2;
        TextView textView3;
        String str3;
        Context context;
        float f;
        TextView textView4;
        String str4;
        setGravity(1);
        TextView textView5 = new TextView(getContext());
        this.f9881a = textView5;
        textView5.setId(View.generateViewId());
        int iA4 = com.opos.cmn.an.h.f.a.a(getContext(), 1.4f);
        int iA5 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        if (i == 1) {
            textView = this.f9881a;
            str = this.j;
        } else {
            if (i == 0) {
                this.f9881a.setTextColor(Color.parseColor(this.m));
                this.f9881a.setShadowLayer(1.0f, 0.0f, iA4, Color.parseColor(this.o));
                iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
                iA = com.opos.cmn.an.h.f.a.a(getContext(), 1.5f);
            } else if (i == 2) {
                textView = this.f9881a;
                str = this.p;
            } else {
                iA = 0;
                iA2 = 0;
            }
            int iA6 = com.opos.cmn.an.h.f.a.a(getContext(), !z ? 150.0f : 70.0f);
            TextView textView6 = new TextView(getContext());
            this.i = textView6;
            textView6.setId(View.generateViewId());
            this.i.setTextSize(1, 10.0f);
            this.i.setText(R.string.mobad_introduce);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView7 = this.i;
            if (i != 2) {
                textView7.setTextColor(Color.parseColor(this.q));
                iA3 = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
            } else {
                textView7.setTextColor(Color.parseColor(this.n));
                iA3 = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
            }
            layoutParams.rightMargin = iA3;
            layoutParams.leftMargin = iA5;
            layoutParams.addRule(15);
            layoutParams.addRule(11);
            addView(this.i, layoutParams);
            TextView textView8 = new TextView(getContext());
            this.h = textView8;
            textView8.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA2);
            layoutParams2.leftMargin = iA5;
            layoutParams2.addRule(0, this.i.getId());
            if (i != 0) {
                layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            } else {
                layoutParams2.addRule(15);
            }
            addView(this.h, layoutParams2);
            TextView textView9 = new TextView(getContext());
            this.g = textView9;
            textView9.setId(View.generateViewId());
            this.g.setTextSize(1, 10.0f);
            this.g.setText(R.string.mobad_permissions);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            if (i != 2) {
                textView2 = this.g;
                str2 = this.q;
            } else {
                textView2 = this.g;
                str2 = this.n;
            }
            textView2.setTextColor(Color.parseColor(str2));
            layoutParams3.leftMargin = iA5;
            layoutParams3.addRule(15);
            layoutParams3.addRule(0, this.h.getId());
            addView(this.g, layoutParams3);
            TextView textView10 = new TextView(getContext());
            this.f = textView10;
            textView10.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA, iA2);
            layoutParams4.leftMargin = iA5;
            layoutParams4.addRule(0, this.g.getId());
            if (i != 0) {
                layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            } else {
                layoutParams4.addRule(15);
            }
            addView(this.f, layoutParams4);
            TextView textView11 = new TextView(getContext());
            this.e = textView11;
            textView11.setId(View.generateViewId());
            if (i != 2) {
                textView3 = this.e;
                str3 = this.q;
            } else {
                textView3 = this.e;
                str3 = this.n;
            }
            textView3.setTextColor(Color.parseColor(str3));
            this.e.setTextSize(1, 10.0f);
            this.e.setText(R.string.mobad_privacy);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.leftMargin = iA5;
            layoutParams5.addRule(15);
            layoutParams5.addRule(0, this.f.getId());
            addView(this.e, layoutParams5);
            TextView textView12 = new TextView(getContext());
            this.d = textView12;
            textView12.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(iA, iA2);
            layoutParams6.leftMargin = iA5;
            layoutParams6.addRule(0, this.e.getId());
            if (i != 0) {
                layoutParams6.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            } else {
                layoutParams6.addRule(15);
            }
            addView(this.d, layoutParams6);
            TextView textView13 = new TextView(getContext());
            this.c = textView13;
            textView13.setId(View.generateViewId());
            this.c.setTextSize(1, 10.0f);
            this.c.setMaxWidth(iA6);
            this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.c.setSingleLine(true);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.leftMargin = iA5;
            layoutParams7.addRule(15);
            layoutParams7.addRule(0, this.d.getId());
            addView(this.c, layoutParams7);
            TextView textView14 = new TextView(getContext());
            this.b = textView14;
            textView14.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(iA, iA2);
            layoutParams8.leftMargin = iA5;
            layoutParams8.addRule(0, this.c.getId());
            if (i != 0) {
                layoutParams8.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            } else {
                layoutParams8.addRule(15);
            }
            addView(this.b, layoutParams8);
            this.f9881a.setTextSize(1, 10.0f);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
            if (i != 2) {
                context = getContext();
                f = 16.0f;
            } else {
                context = getContext();
                f = 22.0f;
            }
            layoutParams9.leftMargin = com.opos.cmn.an.h.f.a.a(context, f);
            layoutParams9.addRule(0, this.b.getId());
            this.f9881a.setSingleLine(true);
            layoutParams9.addRule(15);
            addView(this.f9881a, layoutParams9);
            if (i != 1) {
                this.c.setTextColor(Color.parseColor(this.j));
                this.b.setBackgroundColor(Color.parseColor(this.l));
                this.d.setBackgroundColor(Color.parseColor(this.l));
                this.f.setBackgroundColor(Color.parseColor(this.l));
                textView4 = this.h;
                str4 = this.l;
            } else {
                if (i == 0) {
                    this.c.setTextColor(Color.parseColor(this.m));
                    float f2 = iA4;
                    this.c.setShadowLayer(1.0f, 0.0f, f2, Color.parseColor(this.o));
                    this.e.setShadowLayer(1.0f, 0.0f, f2, Color.parseColor(this.o));
                    this.g.setShadowLayer(1.0f, 0.0f, f2, Color.parseColor(this.o));
                    this.i.setShadowLayer(1.0f, 0.0f, f2, Color.parseColor(this.o));
                    com.opos.mobad.template.cmn.ab.a(this.b, Color.parseColor(this.j), 1, Color.parseColor(this.o), 1, 0, iA4);
                    com.opos.mobad.template.cmn.ab.a(this.d, Color.parseColor(this.j), 1, Color.parseColor(this.o), 1, 0, iA4);
                    com.opos.mobad.template.cmn.ab.a(this.f, Color.parseColor(this.j), 1, Color.parseColor(this.o), 1, 0, iA4);
                    com.opos.mobad.template.cmn.ab.a(this.h, Color.parseColor(this.j), 1, Color.parseColor(this.o), 1, 0, iA4);
                } else if (i == 2) {
                    this.c.setTextColor(Color.parseColor(this.p));
                    this.b.setBackgroundColor(Color.parseColor(this.p));
                    this.d.setBackgroundColor(Color.parseColor(this.p));
                    this.f.setBackgroundColor(Color.parseColor(this.p));
                    textView4 = this.h;
                    str4 = this.p;
                }
                com.opos.mobad.template.cmn.p.a(this.i, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.1
                    @Override // com.opos.mobad.template.cmn.p
                    public void b(View view, int[] iArr) {
                        if (y.this.r != null) {
                            y.this.r.d(view, iArr);
                        }
                    }
                });
                com.opos.mobad.template.cmn.p.a(this.g, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.2
                    @Override // com.opos.mobad.template.cmn.p
                    public void b(View view, int[] iArr) {
                        if (y.this.r != null) {
                            y.this.r.c(view, iArr);
                        }
                    }
                });
                com.opos.mobad.template.cmn.p.a(this.e, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.3
                    @Override // com.opos.mobad.template.cmn.p
                    public void b(View view, int[] iArr) {
                        if (y.this.r != null) {
                            y.this.r.b(view, iArr);
                        }
                    }
                });
            }
            textView4.setBackgroundColor(Color.parseColor(str4));
            com.opos.mobad.template.cmn.p.a(this.i, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.1
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (y.this.r != null) {
                        y.this.r.d(view, iArr);
                    }
                }
            });
            com.opos.mobad.template.cmn.p.a(this.g, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.2
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (y.this.r != null) {
                        y.this.r.c(view, iArr);
                    }
                }
            });
            com.opos.mobad.template.cmn.p.a(this.e, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.3
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (y.this.r != null) {
                        y.this.r.b(view, iArr);
                    }
                }
            });
        }
        textView.setTextColor(Color.parseColor(str));
        iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
        iA = com.opos.cmn.an.h.f.a.a(getContext(), 0.67f);
        int iA62 = com.opos.cmn.an.h.f.a.a(getContext(), !z ? 150.0f : 70.0f);
        TextView textView62 = new TextView(getContext());
        this.i = textView62;
        textView62.setId(View.generateViewId());
        this.i.setTextSize(1, 10.0f);
        this.i.setText(R.string.mobad_introduce);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        TextView textView72 = this.i;
        if (i != 2) {
        }
        layoutParams10.rightMargin = iA3;
        layoutParams10.leftMargin = iA5;
        layoutParams10.addRule(15);
        layoutParams10.addRule(11);
        addView(this.i, layoutParams10);
        TextView textView82 = new TextView(getContext());
        this.h = textView82;
        textView82.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams22.leftMargin = iA5;
        layoutParams22.addRule(0, this.i.getId());
        if (i != 0) {
        }
        addView(this.h, layoutParams22);
        TextView textView92 = new TextView(getContext());
        this.g = textView92;
        textView92.setId(View.generateViewId());
        this.g.setTextSize(1, 10.0f);
        this.g.setText(R.string.mobad_permissions);
        RelativeLayout.LayoutParams layoutParams32 = new RelativeLayout.LayoutParams(-2, -2);
        if (i != 2) {
        }
        textView2.setTextColor(Color.parseColor(str2));
        layoutParams32.leftMargin = iA5;
        layoutParams32.addRule(15);
        layoutParams32.addRule(0, this.h.getId());
        addView(this.g, layoutParams32);
        TextView textView102 = new TextView(getContext());
        this.f = textView102;
        textView102.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams42 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams42.leftMargin = iA5;
        layoutParams42.addRule(0, this.g.getId());
        if (i != 0) {
        }
        addView(this.f, layoutParams42);
        TextView textView112 = new TextView(getContext());
        this.e = textView112;
        textView112.setId(View.generateViewId());
        if (i != 2) {
        }
        textView3.setTextColor(Color.parseColor(str3));
        this.e.setTextSize(1, 10.0f);
        this.e.setText(R.string.mobad_privacy);
        RelativeLayout.LayoutParams layoutParams52 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams52.leftMargin = iA5;
        layoutParams52.addRule(15);
        layoutParams52.addRule(0, this.f.getId());
        addView(this.e, layoutParams52);
        TextView textView122 = new TextView(getContext());
        this.d = textView122;
        textView122.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams62 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams62.leftMargin = iA5;
        layoutParams62.addRule(0, this.e.getId());
        if (i != 0) {
        }
        addView(this.d, layoutParams62);
        TextView textView132 = new TextView(getContext());
        this.c = textView132;
        textView132.setId(View.generateViewId());
        this.c.setTextSize(1, 10.0f);
        this.c.setMaxWidth(iA62);
        this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.c.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams72 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams72.leftMargin = iA5;
        layoutParams72.addRule(15);
        layoutParams72.addRule(0, this.d.getId());
        addView(this.c, layoutParams72);
        TextView textView142 = new TextView(getContext());
        this.b = textView142;
        textView142.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams82 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams82.leftMargin = iA5;
        layoutParams82.addRule(0, this.c.getId());
        if (i != 0) {
        }
        addView(this.b, layoutParams82);
        this.f9881a.setTextSize(1, 10.0f);
        RelativeLayout.LayoutParams layoutParams92 = new RelativeLayout.LayoutParams(-2, -2);
        if (i != 2) {
        }
        layoutParams92.leftMargin = com.opos.cmn.an.h.f.a.a(context, f);
        layoutParams92.addRule(0, this.b.getId());
        this.f9881a.setSingleLine(true);
        layoutParams92.addRule(15);
        addView(this.f9881a, layoutParams92);
        if (i != 1) {
        }
        textView4.setBackgroundColor(Color.parseColor(str4));
        com.opos.mobad.template.cmn.p.a(this.i, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (y.this.r != null) {
                    y.this.r.d(view, iArr);
                }
            }
        });
        com.opos.mobad.template.cmn.p.a(this.g, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (y.this.r != null) {
                    y.this.r.c(view, iArr);
                }
            }
        });
        com.opos.mobad.template.cmn.p.a(this.e, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (y.this.r != null) {
                    y.this.r.b(view, iArr);
                }
            }
        });
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("BlockPrivacyView", "setListener " + interfaceC0778a);
        this.r = interfaceC0778a;
    }

    public void a(String str, String str2) {
        TextView textView;
        TextView textView2;
        if (!TextUtils.isEmpty(str) && (textView2 = this.f9881a) != null) {
            textView2.setText(str);
        }
        if (TextUtils.isEmpty(str2) || (textView = this.c) == null) {
            return;
        }
        textView.setText(str2);
    }
}
