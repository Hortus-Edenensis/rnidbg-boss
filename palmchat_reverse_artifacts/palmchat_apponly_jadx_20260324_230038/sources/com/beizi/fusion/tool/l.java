package com.beizi.fusion.tool;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.beizi.ad.internal.view.a.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f4737a;
    private a b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str);
    }

    public void a(Context context, ViewGroup viewGroup, String str) {
        try {
            a(context, str);
            TextView textView = this.f4737a;
            if (textView != null) {
                viewGroup.addView(textView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(Context context, String str) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            this.f4737a = textView;
            textView.setText("投诉");
            this.f4737a.setTextColor(Color.parseColor("#FFFFFF"));
            am.a(this.f4737a, "#99000000", 0, "", 30);
            if ("1".equals(str)) {
                this.f4737a.setTextSize(2, 13.0f);
                this.f4737a.setPadding(ap.a(context, 12.0f), ap.a(context, 1.0f), ap.a(context, 12.0f), ap.a(context, 1.0f));
                layoutParams.leftMargin = 18;
                layoutParams.topMargin = 18;
            } else if ("2".equals(str)) {
                this.f4737a.setTextSize(2, 13.0f);
                this.f4737a.setPadding(ap.a(context, 12.0f), ap.a(context, 1.0f), ap.a(context, 12.0f), ap.a(context, 1.0f));
                layoutParams.leftMargin = ap.a(context, 16.0f);
                layoutParams.topMargin = ap.a(context, 16.0f);
            } else if ("3".equals(str)) {
                this.f4737a.setTextSize(2, 10.0f);
                this.f4737a.setPadding(ap.a(context, 11.0f), ap.a(context, 1.0f), ap.a(context, 11.0f), ap.a(context, 1.0f));
                layoutParams.leftMargin = 16;
                layoutParams.topMargin = 16;
            }
            this.f4737a.setLayoutParams(layoutParams);
            a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        try {
            this.f4737a.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.tool.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        Context context = l.this.f4737a.getContext();
                        View rootView = l.this.f4737a.getRootView();
                        if (rootView != null) {
                            context = rootView.getContext();
                        }
                        a.C0120a c0120a = new a.C0120a(context);
                        c0120a.a(new a.b() { // from class: com.beizi.fusion.tool.l.1.1
                            @Override // com.beizi.ad.internal.view.a.a.b
                            public void a() {
                            }

                            @Override // com.beizi.ad.internal.view.a.a.b
                            public void a(String str) {
                                if (l.this.b != null) {
                                    l.this.b.a(str);
                                }
                            }
                        });
                        c0120a.a().show();
                    } catch (Exception e) {
                        aa.c("BeiZis", "e ：" + e);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(a aVar) {
        this.b = aVar;
    }
}
