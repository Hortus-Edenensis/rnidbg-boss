package com.opos.mobad.template.g;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class aj extends RelativeLayout {
    private static String b = "#66FFFFFF";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9697a;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private a.InterfaceC0778a l;

    public aj(Context context, int i) {
        super(context);
        this.f9697a = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID;
        if (i == 0 || i == 1) {
            a(i);
        } else {
            b(i);
        }
    }

    private void b(int i) {
        TextView textView = new TextView(getContext());
        this.c = textView;
        textView.setId(View.generateViewId());
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(16);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 0.66f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 1.0f;
        this.c.setTextSize(1, 10.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.c.setSingleLine(true);
        layoutParams3.addRule(15);
        relativeLayout.addView(this.c, layoutParams3);
        TextView textView2 = new TextView(getContext());
        this.d = textView2;
        textView2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA2, iA);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams4.addRule(1, this.c.getId());
        layoutParams4.addRule(15);
        relativeLayout.addView(this.d, layoutParams4);
        TextView textView3 = new TextView(getContext());
        this.e = textView3;
        textView3.setId(View.generateViewId());
        this.e.setTextSize(1, 10.0f);
        this.e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.e.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, this.d.getId());
        relativeLayout.addView(this.e, layoutParams5);
        linearLayout.addView(relativeLayout, layoutParams2);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        ViewGroup.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView4 = new TextView(getContext());
        this.f = textView4;
        textView4.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(iA2, iA);
        layoutParams7.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams7.addRule(15);
        relativeLayout2.addView(this.f, layoutParams7);
        TextView textView5 = new TextView(getContext());
        this.g = textView5;
        textView5.setId(View.generateViewId());
        TextView textView6 = this.g;
        Resources resources = getResources();
        int i2 = R.color.opos_mobad_privacy_per_intr_color;
        textView6.setTextColor(resources.getColor(i2));
        this.g.setTextSize(1, 10.0f);
        this.g.setText(R.string.mobad_privacy);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams8.addRule(15);
        layoutParams8.addRule(1, this.f.getId());
        relativeLayout2.addView(this.g, layoutParams8);
        TextView textView7 = new TextView(getContext());
        this.h = textView7;
        textView7.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(iA2, iA);
        layoutParams9.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams9.addRule(1, this.g.getId());
        layoutParams9.addRule(15);
        relativeLayout2.addView(this.h, layoutParams9);
        TextView textView8 = new TextView(getContext());
        this.i = textView8;
        textView8.setId(View.generateViewId());
        this.i.setTextColor(getResources().getColor(i2));
        this.i.setTextSize(1, 10.0f);
        this.i.setText(R.string.mobad_permissions);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams10.addRule(15);
        layoutParams10.addRule(1, this.h.getId());
        relativeLayout2.addView(this.i, layoutParams10);
        TextView textView9 = new TextView(getContext());
        this.j = textView9;
        textView9.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(iA2, iA);
        layoutParams11.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams11.addRule(1, this.i.getId());
        layoutParams11.addRule(15);
        relativeLayout2.addView(this.j, layoutParams11);
        TextView textView10 = new TextView(getContext());
        this.k = textView10;
        textView10.setId(View.generateViewId());
        this.k.setTextColor(getResources().getColor(i2));
        this.k.setTextSize(1, 10.0f);
        this.k.setText(R.string.mobad_introduce);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams12.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams12.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams12.addRule(15);
        layoutParams12.addRule(1, this.j.getId());
        relativeLayout2.addView(this.k, layoutParams12);
        linearLayout.addView(relativeLayout2, layoutParams6);
        TextView textView11 = this.c;
        Resources resources2 = getResources();
        int i3 = R.color.opos_mobad_version_company_color;
        textView11.setTextColor(resources2.getColor(i3));
        this.e.setTextColor(getResources().getColor(i3));
        this.d.setBackgroundColor(getResources().getColor(i3));
        this.f.setBackgroundColor(getResources().getColor(i3));
        this.h.setBackgroundColor(getResources().getColor(i3));
        this.j.setBackgroundColor(getResources().getColor(i3));
        addView(linearLayout, layoutParams);
        com.opos.mobad.template.cmn.p.a(this.k, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.aj.4
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (aj.this.l != null) {
                    aj.this.l.d(view, iArr);
                }
            }
        });
        com.opos.mobad.template.cmn.p.a(this.i, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.aj.5
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (aj.this.l != null) {
                    aj.this.l.c(view, iArr);
                }
            }
        });
        com.opos.mobad.template.cmn.p.a(this.g, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.aj.6
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (aj.this.l != null) {
                    aj.this.l.b(view, iArr);
                }
            }
        });
    }

    public static aj a(Context context, int i) {
        return new aj(context, i);
    }

    private String a(String str) {
        String str2;
        String str3;
        String[] strArrSplit = str.split("\\.");
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= strArrSplit.length) {
                break;
            }
            if (!strArrSplit[i].isEmpty()) {
                int length = strArrSplit[i].length() + i2;
                int i3 = 3;
                if (length > 3) {
                    if (i == 0) {
                        str2 = strArrSplit[i];
                    } else {
                        str2 = strArrSplit[i];
                        i3 = 3 - i2;
                    }
                    sb.append(str2.substring(0, i3));
                    sb.append("...");
                } else {
                    if (length == 3) {
                        if (i == 0) {
                            str3 = strArrSplit[i];
                        } else {
                            sb.append(strArrSplit[i]);
                            sb.append("...");
                            i2 = length;
                        }
                    } else if (i != strArrSplit.length - 1) {
                        sb.append(strArrSplit[i]);
                        str3 = ".";
                    } else {
                        str3 = strArrSplit[i];
                    }
                    sb.append(str3);
                    i2 = length;
                }
            }
            i++;
        }
        return sb.toString();
    }

    private void a(int i) {
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 0.66f);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        LinearLayout linearLayout3 = new LinearLayout(getContext());
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        TextView textView = new TextView(getContext());
        this.e = textView;
        textView.setId(View.generateViewId());
        this.e.setTextSize(1, 10.0f);
        this.e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.e.setSingleLine(true);
        if (i == 0) {
            TextView textView2 = new TextView(getContext());
            this.c = textView2;
            textView2.setId(View.generateViewId());
            this.c.setTextSize(1, 10.0f);
            this.c.setSingleLine(true);
            com.opos.cmn.an.f.a.b("BlockPrivacyView", "initNewPrivacyView TYPE_16_9");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
            layoutParams.addRule(12);
            layoutParams.addRule(15);
            linearLayout3.addView(this.c, layoutParams);
            TextView textView3 = new TextView(getContext());
            this.j = textView3;
            textView3.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA2, iA);
            layoutParams2.addRule(1, this.c.getId());
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            layoutParams2.addRule(15);
            this.j.setBackgroundColor(getResources().getColor(R.color.opos_mobad_version_company_color));
            linearLayout3.addView(this.j, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 81.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
            layoutParams3.addRule(15);
            layoutParams3.addRule(1, this.j.getId());
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            linearLayout3.addView(this.e, layoutParams3);
        }
        if (i == 1) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 120.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
            layoutParams4.addRule(15);
            layoutParams4.addRule(12);
            layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            linearLayout3.addView(this.e, layoutParams4);
        }
        TextView textView4 = new TextView(getContext());
        this.g = textView4;
        textView4.setId(View.generateViewId());
        TextView textView5 = this.g;
        Resources resources = getResources();
        int i2 = R.color.opos_mobad_version_company_color;
        textView5.setTextColor(resources.getColor(i2));
        this.g.setTextSize(1, 10.0f);
        this.g.setText(R.string.mobad_privacy);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        this.g.setSingleLine(true);
        layoutParams5.addRule(15);
        linearLayout2.addView(this.g, layoutParams5);
        TextView textView6 = new TextView(getContext());
        this.d = textView6;
        textView6.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(iA2, iA);
        layoutParams6.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams6.addRule(1, this.g.getId());
        layoutParams6.addRule(15);
        linearLayout2.addView(this.d, layoutParams6);
        TextView textView7 = new TextView(getContext());
        this.i = textView7;
        textView7.setId(View.generateViewId());
        this.i.setTextColor(getResources().getColor(i2));
        this.i.setTextSize(1, 10.0f);
        this.i.setText(R.string.mobad_permissions);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams7.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams7.addRule(15);
        layoutParams7.addRule(1, this.d.getId());
        linearLayout2.addView(this.i, layoutParams7);
        TextView textView8 = new TextView(getContext());
        this.f = textView8;
        textView8.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(iA2, iA);
        layoutParams8.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams8.addRule(1, this.i.getId());
        layoutParams8.addRule(15);
        linearLayout2.addView(this.f, layoutParams8);
        TextView textView9 = new TextView(getContext());
        this.k = textView9;
        textView9.setId(View.generateViewId());
        this.k.setTextColor(getResources().getColor(i2));
        this.k.setTextSize(1, 10.0f);
        this.k.setText(R.string.mobad_introduce);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams9.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams9.addRule(15);
        layoutParams9.addRule(1, this.f.getId());
        linearLayout2.addView(this.k, layoutParams9);
        TextView textView10 = new TextView(getContext());
        this.h = textView10;
        textView10.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(iA2, iA);
        layoutParams10.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams10.addRule(1, this.k.getId());
        layoutParams10.addRule(15);
        linearLayout2.addView(this.h, layoutParams10);
        if (i == 1) {
            TextView textView11 = new TextView(getContext());
            this.c = textView11;
            textView11.setId(View.generateViewId());
            this.c.setTextSize(1, 10.0f);
            this.c.setSingleLine(true);
            RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
            layoutParams11.addRule(1, this.h.getId());
            layoutParams11.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            layoutParams11.addRule(15);
            linearLayout2.addView(this.c, layoutParams11);
        }
        this.c.setTextColor(getResources().getColor(i2));
        this.e.setTextColor(getResources().getColor(i2));
        this.d.setBackgroundColor(getResources().getColor(i2));
        this.f.setBackgroundColor(getResources().getColor(i2));
        this.h.setBackgroundColor(getResources().getColor(i2));
        ViewGroup.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), this.f9697a), -2);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), this.f9697a), -2);
        if (i == 0) {
            this.f9697a = 107;
            layoutParams13.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        } else if (i == 1) {
            this.f9697a = 121;
        }
        linearLayout.addView(linearLayout2, layoutParams12);
        linearLayout.addView(linearLayout3, layoutParams13);
        addView(linearLayout);
        com.opos.mobad.template.cmn.p.a(this.k, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.aj.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (aj.this.l != null) {
                    aj.this.l.d(view, iArr);
                }
            }
        });
        com.opos.mobad.template.cmn.p.a(this.i, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.aj.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (aj.this.l != null) {
                    aj.this.l.c(view, iArr);
                }
            }
        });
        com.opos.mobad.template.cmn.p.a(this.g, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.aj.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (aj.this.l != null) {
                    aj.this.l.b(view, iArr);
                }
            }
        });
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("BlockPrivacyView", "setListener " + interfaceC0778a);
        this.l = interfaceC0778a;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.c.setText(ExifInterface.GPS_MEASUREMENT_INTERRUPTED + a(str));
            this.c.setMaxEms(3);
            this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.e.setText(str2);
        this.e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    }
}
