package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.su;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.res.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends AlertDialog implements rh.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5248a;
    private TextView b;
    private Context fx;
    private TextView iz;
    private boolean jk;
    private final u n;
    protected final rh nr;
    private TextView pn;
    public com.bytedance.sdk.openadsdk.core.nr.nr u;
    private final String x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void nr(Dialog dialog);

        void u(Dialog dialog);
    }

    public nr(Context context, bc bcVar, u uVar) {
        super(context);
        this.nr = new rh(Looper.getMainLooper(), this);
        this.jk = false;
        this.fx = context;
        if (context == null) {
            this.fx = dw.getContext();
        }
        this.x = su.iz(bcVar);
        this.n = uVar;
        if (su.pn(bcVar) != 3) {
            this.f5248a = su.n(bcVar);
        } else {
            this.jk = true;
            this.f5248a = 5L;
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(pn.xg(this.fx));
        setCanceledOnTouchOutside(false);
        u();
        this.nr.sendEmptyMessageDelayed(101, 1000L);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            this.nr.removeMessages(101);
        } else {
            this.nr.removeMessages(101);
            this.nr.sendEmptyMessageDelayed(101, 1000L);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        y.u(this.b, this.x);
    }

    private void u() {
        this.b = (TextView) findViewById(2114387826);
        this.pn = (TextView) findViewById(2114387638);
        this.iz = (TextView) findViewById(2114387833);
        if (this.n == null) {
            return;
        }
        y.u((View) this.pn, (View.OnClickListener) this.u, "goLiveListener");
        y.u(this.iz, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.nr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                nr.this.n.u(nr.this);
            }
        }, "cancelTv");
    }

    public void u(com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        this.u = nrVar;
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        u uVar;
        if (message.what == 101) {
            long j = this.f5248a - 1;
            this.f5248a = j;
            if (j <= 0) {
                if (this.jk && (uVar = this.n) != null) {
                    uVar.nr(this);
                }
                u uVar2 = this.n;
                if (uVar2 != null) {
                    uVar2.u(this);
                    return;
                }
                return;
            }
            if (this.jk) {
                y.u(this.iz, q.u(this.fx, "tt_reward_live_dialog_cancel_text"));
            } else {
                y.u(this.iz, String.format(q.u(this.fx, "tt_reward_live_dialog_cancel_count_down_text"), String.valueOf(j)));
            }
            this.nr.sendEmptyMessageDelayed(101, 1000L);
        }
    }
}
