package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.dw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends AlertDialog {
    private String nr;
    private Context u;

    public u(Context context, String str) {
        super(context, q.x(context, "tt_custom_dialog"));
        this.u = context == null ? dw.getContext() : context;
        this.nr = str;
    }

    private void u() {
        ((TextView) findViewById(2114387699)).setText(this.nr);
        findViewById(2114387755).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                u.this.dismiss();
            }
        });
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.pn.y(getContext()));
        u();
    }
}
