package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f10580a;
    public String b;
    public String fx;
    public boolean iz;
    public int jk;
    public InterfaceC0840nr n;
    public String nr;
    public String pn;
    public Context u;
    public Drawable x;

    /* JADX INFO: renamed from: com.ss.android.download.api.model.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0840nr {
        void fx(DialogInterface dialogInterface);

        void nr(DialogInterface dialogInterface);

        void u(DialogInterface dialogInterface);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f10581a;
        private String b;
        private Context fx;
        private String iz;
        private InterfaceC0840nr jk;
        private boolean n;
        public int nr;
        private String pn;
        public View u;
        private String x;

        public u(Context context) {
            this.fx = context;
        }

        public u b(String str) {
            this.x = str;
            return this;
        }

        public u fx(String str) {
            this.iz = str;
            return this;
        }

        public u nr(String str) {
            this.pn = str;
            return this;
        }

        public u u(String str) {
            this.b = str;
            return this;
        }

        public u u(boolean z) {
            this.n = z;
            return this;
        }

        public u u(Drawable drawable) {
            this.f10581a = drawable;
            return this;
        }

        public u u(InterfaceC0840nr interfaceC0840nr) {
            this.jk = interfaceC0840nr;
            return this;
        }

        public u u(int i) {
            this.nr = i;
            return this;
        }

        public nr u() {
            return new nr(this);
        }
    }

    private nr(u uVar) {
        this.iz = true;
        this.u = uVar.fx;
        this.nr = uVar.b;
        this.fx = uVar.pn;
        this.b = uVar.iz;
        this.pn = uVar.x;
        this.iz = uVar.n;
        this.x = uVar.f10581a;
        this.n = uVar.jk;
        this.f10580a = uVar.u;
        this.jk = uVar.nr;
    }
}
