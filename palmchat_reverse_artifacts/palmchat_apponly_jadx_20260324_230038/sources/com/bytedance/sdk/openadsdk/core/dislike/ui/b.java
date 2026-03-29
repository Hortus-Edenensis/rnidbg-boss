package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.dislike.ui.pn;
import com.bytedance.sdk.openadsdk.my.fx.nr.iz;
import com.bytedance.sdk.openadsdk.widget.TTDislikeLayout;
import com.bytedance.sdk.openadsdk.widget.TTDislikeScrollListView;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends Dialog {
    private boolean b;
    private final com.bytedance.sdk.openadsdk.core.dislike.fx.nr fx;
    private u iz;
    private TTDislikeLayout nr;
    private TextView pn;
    private com.bytedance.sdk.openadsdk.core.dislike.nr.fx u;
    private final boolean x;

    public b(Context context, com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar, u uVar) {
        super(context);
        this.b = false;
        getWindow().addFlags(1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.fx = nrVar;
        this.x = nrVar != null ? nrVar.nr() : false;
        this.iz = uVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.bytedance.sdk.openadsdk.core.dislike.nr.fx fxVar = this.u;
        if (fxVar == null || this.b) {
            return;
        }
        fxVar.fx();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        setContentView(com.bytedance.sdk.openadsdk.res.b.u(getContext(), this.x), u());
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        nr();
        fx();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.b = false;
            com.bytedance.sdk.openadsdk.core.dislike.nr.fx fxVar = this.u;
            if (fxVar != null) {
                fxVar.nr();
            }
        } catch (Exception unused) {
        }
    }

    private void fx() {
        TTDislikeLayout tTDislikeLayout = (TTDislikeLayout) findViewById(2047279103);
        this.nr = tTDislikeLayout;
        u(tTDislikeLayout);
    }

    private void nr() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setDimAmount(0.34f);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.dislike.nr.fx fxVar) {
        this.u = fxVar;
    }

    public ViewGroup.LayoutParams u() {
        return new ViewGroup.LayoutParams(com.bytedance.sdk.openadsdk.core.dislike.u.u.nr().u(getContext(), 345.0f), -2);
    }

    public void u(com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar) {
        TTDislikeLayout tTDislikeLayout;
        if (nrVar == null || (tTDislikeLayout = this.nr) == null) {
            return;
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) tTDislikeLayout.findViewById(2047279097);
        pn pnVar = (pn) tTDislikeScrollListView.getAdapter();
        if (pnVar != null) {
            tTDislikeScrollListView.setDislikeController(new com.bytedance.sdk.openadsdk.core.dislike.u.nr(nrVar));
            pnVar.u(nrVar.u());
        }
    }

    private void u(View view) {
        if (view == null) {
            return;
        }
        if (!this.x) {
            TextView textView = (TextView) view.findViewById(2047279095);
            this.pn = textView;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.u != null) {
                        b.this.u.u();
                    }
                    b.this.dismiss();
                }
            });
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) view.findViewById(2047279097);
        tTDislikeScrollListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                try {
                    iz izVar = b.this.fx.u().get(i);
                    if (b.this.x && "99:1".equals(izVar.u())) {
                        return;
                    }
                    if (b.this.u != null) {
                        b.this.u.u(i, izVar);
                        b.this.b = true;
                    }
                    b.this.dismiss();
                } catch (Throwable unused) {
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar = this.fx;
        pn pnVar = new pn(getContext(), nrVar == null ? new ArrayList<>(0) : nrVar.u(), this.x, this.iz);
        pnVar.u(new pn.u() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.b.3
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.pn.u
            public void u(int i, iz izVar) {
                if (b.this.u != null) {
                    b.this.u.u(i, izVar);
                    b.this.b = true;
                }
                b.this.dismiss();
                com.bytedance.sdk.openadsdk.core.dislike.u.u.u().u(b.this.fx, izVar);
            }
        });
        tTDislikeScrollListView.setAdapter((ListAdapter) pnVar);
        com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar2 = this.fx;
        if (nrVar2 != null) {
            tTDislikeScrollListView.setDislikeController(new com.bytedance.sdk.openadsdk.core.dislike.u.nr(nrVar2));
        }
    }

    public void u(String str) {
        TextView textView = this.pn;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
