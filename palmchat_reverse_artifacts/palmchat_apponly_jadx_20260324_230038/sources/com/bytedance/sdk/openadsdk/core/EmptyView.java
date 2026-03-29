package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.qq.gdt.action.ActionUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class EmptyView extends View implements rh.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f5195a;
    private View b;
    private u fx;
    private List<View> iz;
    private final AtomicBoolean jk;
    private boolean k;
    private bc l;
    private String mv;
    private final AtomicBoolean my;
    private int n;
    private volatile boolean nr;
    private int o;
    private List<View> pn;
    private boolean s;
    private int t;
    private volatile boolean u;
    private List<View> x;

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr implements u {
        private final u u;

        public nr(u uVar) {
            this.u = uVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
        public void nr() {
            if (this.u != null) {
                com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.nr.3
                    @Override // java.lang.Runnable
                    public void run() {
                        nr.this.u.nr();
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
        public void u(final boolean z) {
            if (this.u != null) {
                com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.nr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        nr.this.u.u(z);
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
        public void u() {
            if (this.u != null) {
                com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.nr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        nr.this.u.u();
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
        public void u(final View view, final Map<String, Object> map) {
            if (this.u != null) {
                com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.nr.4
                    @Override // java.lang.Runnable
                    public void run() {
                        nr.this.u.u(view, map);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void nr();

        void u();

        void u(View view, Map<String, Object> map);

        void u(boolean z);
    }

    public EmptyView(Context context, View view) {
        super(dw.getContext());
        this.nr = true;
        this.jk = new AtomicBoolean(true);
        this.t = 1000;
        this.s = false;
        this.k = false;
        this.my = new AtomicBoolean(false);
        this.o = 0;
        this.b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.f5195a = new com.bytedance.sdk.component.utils.rh(com.bytedance.sdk.openadsdk.gi.x.nr(), this);
        this.s = dw.nr().im();
        this.k = dw.nr().ms();
    }

    public static /* synthetic */ int fx(EmptyView emptyView) {
        int i = emptyView.o;
        emptyView.o = i + 1;
        return i;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.my.set(false);
        b();
        if (this.s) {
            u("checkWhenAddToWindow");
        }
        nr();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.my.set(false);
        pn();
        fx();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        u uVar = this.fx;
        if (uVar != null) {
            uVar.u(z);
        }
    }

    public void setAdType(int i) {
        this.n = i;
    }

    public void setCallback(u uVar) {
        this.fx = new nr(uVar);
    }

    public void setNeedCheckingShow(final boolean z) {
        this.my.set(false);
        this.f5195a.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.4
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.nr = z;
                if (!z && EmptyView.this.u) {
                    EmptyView.this.pn();
                } else {
                    if (!z || EmptyView.this.u) {
                        return;
                    }
                    EmptyView.this.b();
                }
            }
        });
    }

    public void setRefClickViews(List<View> list) {
        this.pn = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.iz = list;
    }

    public void setRefDirectDownloadViews(List<View> list) {
        this.x = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f5195a.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!EmptyView.this.nr || EmptyView.this.u) {
                    return;
                }
                EmptyView.this.u = true;
                EmptyView.fx(EmptyView.this);
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                EmptyView.this.f5195a.handleMessage(messageObtain);
            }
        });
    }

    private void fx() {
        u uVar;
        if (this.jk.getAndSet(true) || (uVar = this.fx) == null) {
            return;
        }
        uVar.nr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn() {
        this.f5195a.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.3
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.u = false;
                EmptyView.this.f5195a.removeMessages(1);
            }
        });
    }

    private void nr() {
        u uVar;
        if (!this.jk.getAndSet(false) || (uVar = this.fx) == null) {
            return;
        }
        uVar.u();
    }

    public void u() {
        u(this.pn, (com.bytedance.sdk.openadsdk.core.nr.b) null);
        u(this.iz, (com.bytedance.sdk.openadsdk.core.nr.b) null);
        u(this.x, (com.bytedance.sdk.openadsdk.core.nr.b) null);
    }

    public void u(List<View> list, com.bytedance.sdk.openadsdk.core.nr.b bVar) {
        if (com.bytedance.sdk.component.utils.mv.nr(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(bVar);
                    view.setOnTouchListener(bVar);
                }
            }
        }
    }

    public void u(final String str) {
        this.f5195a.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.equals(str, "checkWhenClicked")) {
                    if (!EmptyView.this.nr) {
                        EmptyView.this.u(8, (String) null);
                    }
                    if (!EmptyView.this.u) {
                        EmptyView.this.u(EmptyView.this.my.get() ? 10 : 9, (String) null);
                    }
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = str;
                EmptyView.this.f5195a.handleMessage(messageObtain);
            }
        });
    }

    public void u(bc bcVar, String str) {
        this.l = bcVar;
        this.mv = str;
    }

    public EmptyView(Context context, View view, int i) {
        this(context, view);
        this.t = i;
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        int iU;
        boolean z = false;
        boolean z2 = this.s || this.k;
        Object obj = message.obj;
        if ((obj instanceof String) && (TextUtils.equals("checkWhenAddToWindow", obj.toString()) || TextUtils.equals("checkWhenClicked", message.obj.toString()))) {
            z = true;
        }
        if (message.what != 1) {
            return;
        }
        if (this.u || (z2 && z)) {
            String message2 = null;
            if (!z2) {
                if (wq.nr(this.b, 20, this.n)) {
                    pn();
                    u uVar = this.fx;
                    if (uVar != null) {
                        uVar.u(this.b, null);
                        return;
                    }
                    return;
                }
                this.f5195a.sendEmptyMessageDelayed(1, this.t);
                return;
            }
            try {
                iU = wq.u(this.b, 20, this.n);
            } catch (Throwable th) {
                message2 = th.getMessage();
                iU = 7;
            }
            if (iU == 0) {
                pn();
                if (this.fx != null && !this.my.get()) {
                    this.my.set(true);
                    this.fx.u(this.b, u(z, message));
                }
            } else if (!z) {
                this.f5195a.sendEmptyMessageDelayed(1, this.t);
            }
            Object obj2 = message.obj;
            if ((obj2 instanceof String) && TextUtils.equals("checkWhenClicked", obj2.toString())) {
                u(iU, message2);
            }
        }
    }

    private Map<String, Object> u(boolean z, Message message) {
        if (!z) {
            return null;
        }
        HashMap map = new HashMap();
        if (TextUtils.equals("checkWhenAddToWindow", message.obj.toString())) {
            map.put("show_send_type", 2);
        } else if (TextUtils.equals("checkWhenClicked", message.obj.toString())) {
            map.put("show_send_type", 1);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, String str) {
        HashMap map = new HashMap();
        if (i == 0) {
            map.put(ActionUtils.IS_SUCCESS, Boolean.TRUE);
        } else {
            map.put(ActionUtils.IS_SUCCESS, Boolean.FALSE);
            if (i != 7) {
                str = wq.u(i);
            }
            map.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(i));
            map.put("error_message", str);
        }
        map.put("checking_cnt", Integer.valueOf(this.o));
        com.bytedance.sdk.openadsdk.core.s.b.u(this.l, this.mv, map);
    }
}
