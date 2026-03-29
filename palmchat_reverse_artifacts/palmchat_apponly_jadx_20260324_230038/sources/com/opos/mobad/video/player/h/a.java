package com.opos.mobad.video.player.h;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC0819a f10365a;
    private boolean b;
    private volatile boolean c;

    /* JADX INFO: renamed from: com.opos.mobad.video.player.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0819a {
        void a();

        void a(boolean z);

        void b();
    }

    public a(Context context) {
        super(context);
        this.b = false;
        this.c = false;
    }

    public void a() {
        if (this.f10365a != null) {
            this.f10365a = null;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
        InterfaceC0819a interfaceC0819a = this.f10365a;
        if (interfaceC0819a != null) {
            interfaceC0819a.b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
        InterfaceC0819a interfaceC0819a = this.f10365a;
        if (interfaceC0819a != null) {
            interfaceC0819a.a();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a(i == 0);
    }

    public void a(InterfaceC0819a interfaceC0819a) {
        this.f10365a = interfaceC0819a;
        if (!this.b || interfaceC0819a == null) {
            return;
        }
        interfaceC0819a.b();
    }

    public void a(boolean z) {
        if (this.c == (!z)) {
            this.c = z;
            InterfaceC0819a interfaceC0819a = this.f10365a;
            if (interfaceC0819a != null) {
                interfaceC0819a.a(z);
            }
        }
    }
}
