package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.mobad.template.cmn.j;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class o extends com.opos.mobad.template.j.a {
    private com.opos.mobad.template.cmn.baseview.f A;
    private j.b B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.p f10030a;
    private TextView b;
    private TextView c;
    private com.opos.mobad.template.a.c g;
    private RelativeLayout h;
    private LinearLayout i;
    private com.opos.mobad.d.a j;
    private boolean k;
    private TextView l;
    private com.opos.mobad.template.cmn.w m;
    private Context n;
    private RelativeLayout o;
    private RelativeLayout p;
    private RelativeLayout q;
    private com.opos.mobad.template.d.d r;
    private boolean s;
    private boolean t;
    private com.opos.mobad.template.cmn.y u;
    private com.opos.mobad.template.cmn.cardslideview.a v;
    private s w;
    private com.opos.mobad.template.k.c x;
    private com.opos.mobad.template.cmn.p y;
    private com.opos.mobad.template.cmn.q z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements com.opos.mobad.template.cmn.cardslideview.b<com.opos.mobad.template.d.e> {
        public a() {
        }

        @Override // com.opos.mobad.template.cmn.cardslideview.b
        public View a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
            com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(o.this.n, com.opos.cmn.an.h.f.a.a(o.this.n, 12.0f));
            nVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
            nVar.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            return nVar;
        }

        @Override // com.opos.mobad.template.cmn.cardslideview.b
        public void a(@NonNull com.opos.mobad.template.cmn.cardslideview.c cVar, com.opos.mobad.template.d.e eVar, int i) {
            o.this.a(eVar, (ImageView) cVar.itemView);
        }
    }

    public o(Context context, boolean z, com.opos.mobad.d.a aVar, int i) {
        super(i);
        this.k = false;
        this.f10030a = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.o.5
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                o.this.b(view, iArr);
            }
        };
        this.y = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.o.6
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                o.this.a(view, iArr);
            }
        };
        this.z = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.h.o.7
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                o.this.c(view, iArr);
            }
        };
        this.A = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.o.8
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z2) {
                com.opos.cmn.an.f.a.a("RewardCycleEndPage", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                o.this.a(view, i2, z2);
            }
        };
        this.B = new j.b() { // from class: com.opos.mobad.template.h.o.9
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return o.this.n() == 8;
            }
        };
        this.j = aVar;
        this.n = context;
        this.t = z;
        p();
    }

    public static o b(Context context, com.opos.mobad.d.a aVar, int i) {
        return new o(context, false, aVar, i);
    }

    private void p() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout = new RelativeLayout(this.n);
        this.o = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.o.setBackgroundColor(ColorUtils.setAlphaComponent(-16777216, 204));
        RelativeLayout relativeLayout2 = new RelativeLayout(this.n);
        this.p = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.o.addView(this.p, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout relativeLayout3 = new RelativeLayout(this.n);
        this.q = relativeLayout3;
        relativeLayout3.setId(View.generateViewId());
        if (this.t) {
            layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.n, 444.0f));
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 94.0f);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.n, 366.0f), com.opos.cmn.an.h.f.a.b(this.n) - com.opos.cmn.an.h.f.a.a(this.n, 16.0f));
        }
        this.p.addView(this.q, layoutParams);
        com.opos.mobad.template.cmn.p.a(this.o, this.f10030a);
        r();
        s();
        u();
        com.opos.mobad.template.cmn.m.a(this.n, this.p, this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.q.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.n, 274.0f), -2);
        layoutParams.addRule(13);
        this.p.updateViewLayout(this.h, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams2.addRule(14);
        this.h.updateViewLayout(this.u, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams3.removeRule(1);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 8.0f);
        layoutParams3.leftMargin = 0;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.u.getId());
        this.i.setGravity(1);
        this.h.updateViewLayout(this.i, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams4.topMargin = 0;
        layoutParams4.gravity = 1;
        this.i.updateViewLayout(this.b, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams5.gravity = 1;
        this.i.updateViewLayout(this.c, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams6.gravity = 1;
        layoutParams6.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 8.0f);
        this.i.updateViewLayout(this.g, layoutParams6);
        if (this.m.getParent() != null) {
            ((ViewGroup) this.m.getParent()).removeView(this.m);
        }
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.n, this.t ? 296.0f : 280.0f), com.opos.cmn.an.h.f.a.a(this.n, 44.0f));
        layoutParams7.addRule(3, this.i.getId());
        layoutParams7.addRule(14);
        layoutParams7.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 24.0f);
        this.h.addView(this.m, layoutParams7);
    }

    private void r() {
        int iA;
        int iA2;
        this.x = com.opos.mobad.template.k.c.a(this.n, 3, 0, this.j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.n, 28.0f));
        layoutParams.addRule(9);
        if (this.t) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 49.0f);
            iA = com.opos.cmn.an.h.f.a.a(this.n, 16.0f);
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 16.0f);
            iA = com.opos.cmn.an.h.f.a.a(this.n, 24.0f);
        }
        layoutParams.leftMargin = iA;
        this.w = s.a(this.n);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        if (this.t) {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 49.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(this.n, 16.0f);
        } else {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 16.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(this.n, 24.0f);
        }
        layoutParams2.rightMargin = iA2;
        if (!this.t) {
            this.p.addView(this.x, layoutParams);
            this.p.addView(this.w, layoutParams2);
            return;
        }
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.n);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.n, 94.0f));
        layoutParams3.addRule(10);
        cVar.setLayoutParams(layoutParams3);
        cVar.setBackgroundColor(-16777216);
        cVar.addView(this.x, layoutParams);
        cVar.addView(this.w, layoutParams2);
        this.p.addView(cVar);
    }

    private void s() {
        RelativeLayout relativeLayout = new RelativeLayout(this.n);
        this.h = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.n, 280.0f), -2);
        if (this.t) {
            layoutParams.addRule(3, this.q.getId());
            layoutParams.addRule(14);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 47.0f);
        } else {
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.n, 32.0f);
            layoutParams.addRule(1, this.q.getId());
            layoutParams.addRule(15);
        }
        this.p.addView(this.h, layoutParams);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.n, 14.0f);
        this.u = nVar;
        nVar.setId(View.generateViewId());
        this.u.setScaleType(ImageView.ScaleType.FIT_XY);
        this.u.setLayoutParams(new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(this.n, 60.0f), com.opos.cmn.an.h.f.a.a(this.n, 60.0f)));
        this.h.addView(this.u);
        LinearLayout linearLayout = new LinearLayout(this.n);
        this.i = linearLayout;
        linearLayout.setOrientation(1);
        this.i.setGravity(3);
        this.i.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.n, 62.0f));
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.n, 8.0f);
        layoutParams2.addRule(1, this.u.getId());
        this.h.addView(this.i, layoutParams2);
        t();
    }

    private void t() {
        TextView textView = new TextView(this.n);
        this.b = textView;
        textView.setTextColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF));
        this.b.setTextSize(1, 16.0f);
        this.b.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.b.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 1.0f);
        this.b.setVisibility(8);
        this.i.addView(this.b, layoutParams);
        TextView textView2 = new TextView(this.n);
        this.c = textView2;
        textView2.setTextColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID));
        this.c.setTextSize(1, 14.0f);
        this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.c.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 2.0f);
        this.c.setVisibility(8);
        this.i.addView(this.c, layoutParams2);
        this.g = new com.opos.mobad.template.a.c(this.n);
        new ViewGroup.LayoutParams(-1, -2);
        this.g.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 4.0f);
        this.i.addView(this.g, layoutParams3);
    }

    private void u() {
        RelativeLayout relativeLayout;
        this.m = new com.opos.mobad.template.cmn.w(this.n);
        TextView textView = new TextView(this.n);
        this.l = textView;
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.l.setTextColor(-1);
        this.l.setTextSize(1, 16.0f);
        TextPaint paint = this.l.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.m.a(90.0f);
        this.m.addView(this.l, layoutParams);
        this.m.setBackgroundColor(-14385921);
        com.opos.mobad.template.cmn.p.a(this.m, this.z);
        this.m.a(this.A);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.n, this.t ? 296.0f : 280.0f), com.opos.cmn.an.h.f.a.a(this.n, 44.0f));
        if (this.t) {
            layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.n, 41.0f);
            layoutParams2.addRule(14);
            layoutParams2.addRule(12);
            relativeLayout = this.p;
        } else {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 24.0f);
            layoutParams2.addRule(3, this.u.getId());
            layoutParams2.addRule(14);
            relativeLayout = this.h;
        }
        relativeLayout.addView(this.m, layoutParams2);
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        com.opos.mobad.template.cmn.cardslideview.a aVar = this.v;
        if (aVar == null) {
            return false;
        }
        aVar.a();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        com.opos.mobad.template.cmn.cardslideview.a aVar = this.v;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        com.opos.mobad.template.cmn.cardslideview.a aVar = this.v;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.opos.mobad.template.a
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public RelativeLayout c() {
        return this.o;
    }

    public static o a(Context context, com.opos.mobad.d.a aVar, int i) {
        return new o(context, true, aVar, i);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void b() {
    }

    private void b(com.opos.mobad.template.d.d dVar) {
        com.opos.mobad.template.d.e eVar;
        if (this.j == null || dVar == null || (eVar = dVar.O) == null || TextUtils.isEmpty(eVar.f9414a)) {
            a((Bitmap) null);
        } else {
            com.opos.mobad.template.d.e eVar2 = dVar.O;
            com.opos.mobad.template.cmn.j.a(eVar2.f9414a, eVar2.b, this.j, new j.a() { // from class: com.opos.mobad.template.h.o.2
                @Override // com.opos.mobad.template.cmn.j.a
                public void a(int i, Bitmap bitmap) {
                    if (i == 1) {
                        o.this.a(bitmap);
                    }
                    o.this.b(i);
                }

                @Override // com.opos.mobad.template.cmn.j.a
                public void a(Bitmap bitmap) {
                    if (o.this.n() == 8) {
                        return;
                    }
                    o.this.a(bitmap);
                }
            }, this.B);
        }
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.o.4
            @Override // java.lang.Runnable
            public void run() {
                if (o.this.n() == 8 || o.this.u == null) {
                    return;
                }
                o.this.u.setImageBitmap(bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.opos.mobad.template.d.d dVar) {
        int i;
        if (bitmap.getHeight() <= bitmap.getWidth()) {
            i = this.t ? 1 : 3;
        } else {
            if (this.t) {
                a(dVar, 0);
                this.q.setVisibility(0);
            }
            i = 2;
        }
        a(dVar, i);
        this.q.setVisibility(0);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.a.c cVar;
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b) || (cVar = this.g) == null) {
            return;
        }
        cVar.setVisibility(0);
        this.g.a(aVar.f9412a, aVar.b);
        this.g.a(this.e);
    }

    private void a(final com.opos.mobad.template.d.d dVar) {
        List<com.opos.mobad.template.d.e> list = dVar.d;
        boolean z = (list == null || list.size() <= 0 || TextUtils.isEmpty(dVar.d.get(0).f9414a)) ? false : true;
        this.s = z;
        if (z) {
            com.opos.mobad.template.cmn.j.a(dVar.d.get(0).f9414a, dVar.d.get(0).b, this.j, new j.a() { // from class: com.opos.mobad.template.h.o.1
                @Override // com.opos.mobad.template.cmn.j.a
                public void a(int i, Bitmap bitmap) {
                    if (i != 1 || bitmap == null) {
                        o.this.q();
                    } else {
                        o.this.a(bitmap, dVar);
                    }
                    o.this.b(i);
                }

                @Override // com.opos.mobad.template.cmn.j.a
                public void a(Bitmap bitmap) {
                    if (o.this.n() == 8) {
                        return;
                    }
                    o.this.a(bitmap, dVar);
                }
            }, this.B);
        } else {
            q();
        }
    }

    private void a(com.opos.mobad.template.d.d dVar, int i) {
        com.opos.mobad.template.cmn.cardslideview.a aVar = new com.opos.mobad.template.cmn.cardslideview.a(this.n, i);
        this.v = aVar;
        this.q.addView(aVar);
        this.v.a(new com.opos.mobad.template.cmn.cardslideview.d());
        this.v.a(this.f10030a);
        this.v.a(dVar.d, new a(), true);
        this.v.a(this.e, dVar.D, dVar.E, dVar.S);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.template.d.e eVar, final ImageView imageView) {
        String str = eVar.f9414a;
        if (str == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("RewardCycleEndPage", "url is null");
        } else {
            com.opos.mobad.template.cmn.j.a(eVar.f9414a, eVar.b, this.j, new j.a() { // from class: com.opos.mobad.template.h.o.3
                @Override // com.opos.mobad.template.cmn.j.a
                public void a(int i, Bitmap bitmap) {
                    if (i == 1) {
                        imageView.setImageBitmap(bitmap);
                    }
                    o.this.b(i);
                }

                @Override // com.opos.mobad.template.cmn.j.a
                public void a(Bitmap bitmap) {
                    if (o.this.n() == 8) {
                        return;
                    }
                    imageView.setImageBitmap(bitmap);
                }
            }, this.B);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        com.opos.mobad.template.cmn.cardslideview.a aVar;
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("RewardCycleEndPage", "data is null");
            a(1);
            return;
        }
        com.opos.mobad.template.d.d dVarC = fVar.c();
        if (dVarC == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a(1);
            return;
        }
        if (this.r == null) {
            a(dVarC);
            this.p.setVisibility(0);
        }
        a(dVarC.S, dVarC.Q, dVarC.R);
        a((com.opos.mobad.template.d.b) dVarC);
        b(dVarC);
        com.opos.mobad.template.k.c cVar = this.x;
        if (cVar != null) {
            cVar.a(this.e);
            this.x.a(dVarC.p, dVarC.q, dVarC.e, dVarC.g, dVarC.i);
        }
        if (this.p.getVisibility() == 0 && (aVar = this.v) != null) {
            aVar.a(this.e, dVarC.D, dVarC.E, dVarC.S);
        }
        this.w.a(this.e);
        this.r = dVarC;
    }

    private void a(String str, String str2, String str3) {
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.b.setVisibility(0);
            this.b.setText(str2);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.c.setVisibility(0);
        this.c.setText(str3);
    }
}
