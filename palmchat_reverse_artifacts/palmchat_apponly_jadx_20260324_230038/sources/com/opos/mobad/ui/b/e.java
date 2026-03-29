package com.opos.mobad.ui.b;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.cmn.module.ui.b.e.a;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends RelativeLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LinearLayout f10242a;
        private TextView b;
        private Context c;
        private b d;
        private d e;

        public a(Context context) {
            super(context);
            this.c = com.opos.mobad.service.a.a(context.getApplicationContext());
            b();
        }

        private void b() {
            setBackgroundColor(-1);
            LinearLayout linearLayout = new LinearLayout(this.c);
            this.f10242a = linearLayout;
            linearLayout.setId(View.generateViewId());
            this.f10242a.setOrientation(0);
            TextView textView = new TextView(this.c);
            this.b = new TextView(this.c);
            textView.setBackground(com.opos.cmn.an.e.a.a.c(this.c, "opos_module_biz_ui_cmn_privacy_web_close_bn.png"));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.ui.b.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.d != null) {
                        a.this.d.a();
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 16.58f), com.opos.cmn.an.h.f.a.a(this.c, 12.73f));
            layoutParams.gravity = 16;
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.c, 23.71f);
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.c, 18.71f);
            this.f10242a.addView(textView, layoutParams);
            this.b.setGravity(8388627);
            this.b.setTextSize(1, 16.0f);
            this.b.setTextColor(-16777216);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            this.f10242a.addView(this.b, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.c, 50.0f));
            layoutParams3.addRule(10);
            addView(this.f10242a, layoutParams3);
        }

        public void a() {
            removeAllViews();
            d dVar = this.e;
            if (dVar != null) {
                dVar.c();
            }
        }

        private void a(int i, b bVar) {
            d dVar = this.e;
            if (dVar != null) {
                if (i == dVar.a()) {
                    com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "Same type use last view");
                    return;
                } else {
                    com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "differ type use new one");
                    removeView(this.e.b());
                    this.e.c();
                }
            }
            d dVarA = c.a(getContext(), i, bVar);
            this.e = dVarA;
            View viewB = dVarA.b();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, this.f10242a.getId());
            addView(viewB, layoutParams);
        }

        public void a(b bVar) {
            this.d = bVar;
        }

        public void a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "show url = " + str);
            a(0, this.d);
            this.e.a(str);
            this.b.setText(str2);
        }

        public void a(Map<String, String> map, String str) {
            if (map == null) {
                return;
            }
            com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "show Map");
            a(1, this.d);
            this.e.a(map);
            this.b.setText(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();
    }

    public static Dialog a(Activity activity, String str, String str2, b bVar) {
        return a(activity, str, str2, (Map<String, String>) null, bVar);
    }

    public static Dialog a(Activity activity, String str, String str2, Map<String, String> map, final b bVar) {
        final com.opos.cmn.module.ui.b.g.a aVar = new com.opos.cmn.module.ui.b.g.a(activity, R.style.Theme.NoTitleBar, new a.C0676a().a(R.style.Theme.NoTitleBar).a(false).b(false).a());
        final a aVar2 = new a(activity.getApplicationContext());
        aVar2.a(new b() { // from class: com.opos.mobad.ui.b.e.1
            @Override // com.opos.mobad.ui.b.e.b
            public void a() {
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a();
                }
                aVar2.a();
                aVar.dismiss();
            }
        });
        if (TextUtils.isEmpty(str2)) {
            aVar2.a(map, str);
        } else {
            aVar2.a(str2, str);
        }
        aVar.setContentView(aVar2);
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        aVar.getWindow().setLayout(-1, -1);
        aVar.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.opos.mobad.ui.b.e.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 0) {
                    return false;
                }
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a();
                }
                dialogInterface.dismiss();
                return true;
            }
        });
        aVar.show();
        return aVar;
    }

    public static a a(Context context, String str, String str2, Map<String, String> map, final b bVar) {
        final a aVar = new a(context);
        aVar.a(new b() { // from class: com.opos.mobad.ui.b.e.3
            @Override // com.opos.mobad.ui.b.e.b
            public void a() {
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a();
                }
                aVar.a();
            }
        });
        if (TextUtils.isEmpty(str2)) {
            aVar.a(map, str);
        } else {
            aVar.a(str2, str);
        }
        aVar.setBackgroundColor(-1);
        return aVar;
    }
}
