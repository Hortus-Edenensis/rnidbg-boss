package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@SuppressLint({"ViewConstructor"})
public final class a extends KSFrameLayout implements ca.a {
    private InterfaceC0573a alS;
    private boolean alT;
    private boolean alU;
    private int alV;
    private boolean alW;
    private long alX;
    private boolean alY;
    private final float alZ;
    private final int ama;
    private final View bP;
    private final ca bQ;

    /* JADX INFO: renamed from: com.kwad.components.core.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0573a {
        void aa();

        void ab();

        void ax();

        void c(View view);

        void onWindowFocusChanged(boolean z);
    }

    public a(Context context, View view) {
        super(context, view);
        this.bQ = new ca(this);
        this.alV = 5;
        this.bP = view;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float fHw = com.kwad.sdk.core.config.e.Hw();
        this.alZ = fHw;
        setVisiblePercent(fHw);
        float fHy = com.kwad.sdk.core.config.e.Hy();
        this.ama = (int) ((fHy < 0.0f ? 1.0f : fHy) * 1000.0f);
    }

    private void xs() {
        InterfaceC0573a interfaceC0573a;
        if (this.ama == 0 && (interfaceC0573a = this.alS) != null) {
            interfaceC0573a.c(this.bP);
            return;
        }
        Message messageObtainMessage = this.bQ.obtainMessage();
        messageObtainMessage.what = 2;
        this.bQ.sendMessageDelayed(messageObtainMessage, this.ama);
    }

    private void xt() {
        this.bQ.removeCallbacksAndMessages(null);
        this.alU = false;
    }

    private void xu() {
        if (this.alU) {
            return;
        }
        this.alU = true;
        this.bQ.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.k
    public final void G(View view) {
        InterfaceC0573a interfaceC0573a;
        InterfaceC0573a interfaceC0573a2;
        super.G(view);
        if (this.ama == 0 && (interfaceC0573a2 = this.alS) != null) {
            interfaceC0573a2.c(view);
            return;
        }
        if (!this.alW) {
            this.alW = true;
            this.alX = System.currentTimeMillis();
            xt();
            xs();
            return;
        }
        if (System.currentTimeMillis() - this.alX <= this.ama || (interfaceC0573a = this.alS) == null) {
            return;
        }
        interfaceC0573a.c(view);
        xt();
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (this.alT) {
            return;
        }
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!bz.a(this.bP, (int) (this.alZ * 100.0f), false)) {
                this.alV = 5;
                this.bQ.sendEmptyMessage(1);
                return;
            } else {
                InterfaceC0573a interfaceC0573a = this.alS;
                if (interfaceC0573a != null) {
                    interfaceC0573a.c(this.bP);
                    return;
                }
                return;
            }
        }
        if (!bz.a(this.bP, (int) (this.alZ * 100.0f), false)) {
            InterfaceC0573a interfaceC0573a2 = this.alS;
            if (interfaceC0573a2 != null && !this.alY) {
                interfaceC0573a2.ax();
            }
            this.alY = true;
            ca caVar = this.bQ;
            int i2 = this.alV;
            this.alV = i2 - 1;
            caVar.sendEmptyMessageDelayed(1, i2 <= 0 ? 500L : 100L);
            return;
        }
        xt();
        if (this.alW) {
            InterfaceC0573a interfaceC0573a3 = this.alS;
            if (interfaceC0573a3 != null) {
                interfaceC0573a3.c(this.bP);
            }
        } else {
            this.alW = true;
            this.alX = System.currentTimeMillis();
            xs();
        }
        this.alY = false;
        ca caVar2 = this.bQ;
        int i3 = this.alV;
        this.alV = i3 - 1;
        caVar2.sendEmptyMessageDelayed(1, i3 <= 0 ? 500L : 100L);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        this.alV = 5;
        this.alT = false;
        this.alW = false;
        xu();
        InterfaceC0573a interfaceC0573a = this.alS;
        if (interfaceC0573a != null) {
            interfaceC0573a.aa();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        xt();
        this.alV = 0;
        this.alX = 0L;
        this.alT = true;
        InterfaceC0573a interfaceC0573a = this.alS;
        if (interfaceC0573a != null) {
            interfaceC0573a.ab();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.c.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0573a interfaceC0573a = this.alS;
        if (interfaceC0573a != null) {
            interfaceC0573a.onWindowFocusChanged(z);
        }
    }

    public final void setViewCallback(InterfaceC0573a interfaceC0573a) {
        this.alS = interfaceC0573a;
    }

    public final void xv() {
        xu();
    }
}
