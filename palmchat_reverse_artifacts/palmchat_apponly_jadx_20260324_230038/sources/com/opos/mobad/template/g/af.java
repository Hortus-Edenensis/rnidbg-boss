package com.opos.mobad.template.g;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.g.ab;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class af extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f9669a;
    private int b;
    private int c;
    private final int d;
    private a.InterfaceC0778a e;
    private ab.a f;

    public af(Context context, int i) {
        super(context);
        this.b = 0;
        this.d = i;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int i = this.b;
        int i2 = i != 0 ? i == 1 ? 0 : -1 : 1;
        if (i2 == -1) {
            return;
        }
        ab.a aVar = this.f;
        if (aVar != null) {
            aVar.a(i2);
        }
        b(i2);
    }

    public static af a(Context context) {
        return new af(context, 0);
    }

    private void b(int i) {
        Resources resources;
        int i2;
        TextView textView = this.f9669a;
        if (textView == null || this.b == i) {
            return;
        }
        this.b = i;
        if (i == 0) {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_off;
        } else if (i == 2) {
            textView.setVisibility(8);
            return;
        } else {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_on;
        }
        textView.setBackground(resources.getDrawable(i2));
    }

    public static af a(Context context, int i) {
        return new af(context, i);
    }

    private void a() {
        this.f9669a = new TextView(getContext());
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.af.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (af.this.e != null) {
                    af.this.b();
                    af.this.e.a(view, iArr, af.this.b == 1);
                }
            }
        };
        this.f9669a.setOnClickListener(pVar);
        this.f9669a.setOnTouchListener(pVar);
        this.f9669a.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_block_sound_off));
        this.c = this.d == 15 ? 20 : 16;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), this.c), com.opos.cmn.an.h.f.a.a(getContext(), this.c));
        if (this.d != 15) {
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        }
        addView(this.f9669a, layoutParams);
    }

    public void a(int i) {
        b(i);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.e = interfaceC0778a;
    }

    public void a(ab.a aVar) {
        this.f = aVar;
    }
}
