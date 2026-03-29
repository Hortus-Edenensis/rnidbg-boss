package com.opos.mobad.template.f;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.ae;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class h extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.baseview.f f9515a;
    private int b;
    private a.InterfaceC0778a c;
    private ImageView d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private com.opos.mobad.template.cmn.w h;
    private TextView i;
    private com.opos.mobad.template.cmn.w j;
    private Animator k;

    public h(Context context, int i) {
        super(context);
        this.b = 1;
        this.f9515a = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.h.3
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z) {
                com.opos.cmn.an.f.a.a("ImageHalfBottomView", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (h.this.c != null) {
                    h.this.c.a(view, i2, z);
                }
            }
        };
        if (context == null) {
            return;
        }
        this.b = i;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, 66.0f));
        layoutParams.addRule(12);
        setLayoutParams(layoutParams);
        setPadding(com.opos.cmn.an.h.f.a.a(context, 12.0f), 0, com.opos.cmn.an.h.f.a.a(context, 12.0f), 0);
        setBackgroundColor(Color.parseColor("#8C000000"));
        b(context);
        a(context, a(context));
        c(context);
    }

    private RelativeLayout.LayoutParams a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.e = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(1, this.h.getId());
        layoutParams.setMarginStart(com.opos.cmn.an.h.f.a.a(context, 8.0f));
        layoutParams.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 8.0f));
        this.e.setLayoutParams(layoutParams);
        this.e.setGravity(16);
        TextView textView = new TextView(context);
        this.f = textView;
        textView.setGravity(3);
        this.f.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f.setTextColor(-1);
        TextPaint paint = this.f.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f.setLines(1);
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setTextSize(1, 14.0f);
        this.e.addView(this.f);
        TextView textView2 = new TextView(context);
        this.g = textView2;
        textView2.setGravity(3);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(context, 4.0f);
        this.g.setLayoutParams(layoutParams2);
        this.g.setLines(1);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setTextColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID));
        this.g.setTextSize(1, 10.0f);
        this.e.addView(this.g);
        addView(this.e);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Animator animator = this.k;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.k == null) {
            this.k = ae.a((RelativeLayout) this.j);
        }
        this.k.start();
    }

    private void a() {
        RelativeLayout.LayoutParams layoutParams;
        LinearLayout linearLayout = this.e;
        if (linearLayout == null || (layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams()) == null) {
            return;
        }
        layoutParams.setMarginStart(0);
        this.e.setLayoutParams(layoutParams);
    }

    private void b(Context context) {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(context);
        this.h = wVar;
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.h.setLayoutParams(layoutParams);
        layoutParams.addRule(15);
        ImageView imageView = new ImageView(context);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int iA = com.opos.cmn.an.h.f.a.a(context, 42.0f);
        this.d.setLayoutParams(new RelativeLayout.LayoutParams(iA, iA));
        this.h.addView(this.d);
        addView(this.h);
        this.h.a(com.opos.cmn.an.h.f.a.a(context, 8.0f));
    }

    private void c(Context context) {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(context);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.f.h.4
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (z) {
                    h.this.c();
                } else {
                    h.this.b();
                }
            }
        });
        addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void a(final Context context, RelativeLayout.LayoutParams layoutParams) {
        final com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        wVar.setLayoutParams(layoutParams2);
        wVar.setId(View.generateViewId());
        int color = Color.parseColor("#0066FF");
        wVar.setBackgroundColor(color);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        TextView textView = new TextView(context);
        this.i = textView;
        textView.setId(View.generateViewId());
        this.i.setLayoutParams(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 72.0f), com.opos.cmn.an.h.f.a.a(context, 28.0f)));
        this.i.setTextSize(1, 12.0f);
        this.i.setGravity(17);
        int iA = com.opos.cmn.an.h.f.a.a(context, 12.0f);
        this.i.setPadding(iA, 0, iA, 0);
        this.i.setSingleLine();
        this.i.setMaxEms(4);
        TextPaint paint = this.i.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.i.setTextColor(-1);
        wVar.addView(this.i);
        addView(wVar);
        this.i.post(new Runnable() { // from class: com.opos.mobad.template.f.h.1
            @Override // java.lang.Runnable
            public void run() {
                float height = h.this.i.getHeight() > 0 ? h.this.i.getHeight() / 2 : com.opos.cmn.an.h.f.a.a(context, 16.0f);
                h.this.j.a(com.opos.cmn.an.h.f.a.a(context, height));
                wVar.a(com.opos.cmn.an.h.f.a.a(context, height));
            }
        });
        layoutParams.addRule(0, wVar.getId());
        com.opos.mobad.template.cmn.q qVar = new com.opos.mobad.template.cmn.q(color) { // from class: com.opos.mobad.template.f.h.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (h.this.c != null) {
                    h.this.c.g(view, iArr);
                }
            }
        };
        wVar.setOnClickListener(qVar);
        wVar.setOnTouchListener(qVar);
        wVar.a(this.f9515a);
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(context);
        this.j = wVar2;
        wVar2.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(18, this.i.getId());
        layoutParams3.addRule(19, this.i.getId());
        layoutParams3.addRule(6, this.i.getId());
        layoutParams3.addRule(8, this.i.getId());
        wVar.addView(this.j, layoutParams3);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.c = interfaceC0778a;
    }

    public void a(com.opos.mobad.template.d.b bVar, Bitmap bitmap) {
        ImageView imageView = this.d;
        if (imageView != null) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                imageView.setVisibility(8);
                a();
            }
        }
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(bVar.b);
        }
        TextView textView2 = this.g;
        if (textView2 != null) {
            textView2.setText(bVar.f9413a);
        }
        TextView textView3 = this.i;
        if (textView3 != null) {
            textView3.setText(bVar.j);
        }
    }
}
