package defpackage;

import android.content.Context;
import com.zenmen.palmchat.giftkit.a;
import defpackage.nb3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class vb2 implements a.b {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements nb3.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1055a f21399a;

        public a(a.InterfaceC1055a interfaceC1055a) {
            this.f21399a = interfaceC1055a;
        }

        @Override // nb3.c
        public void a(int i, String str, Object obj) {
            this.f21399a.a(i == 0);
        }
    }

    @Override // com.zenmen.palmchat.giftkit.a.b
    public void a(Context context, String str, long j, a.InterfaceC1055a interfaceC1055a) {
        nb3.k(context, str, j, new a(interfaceC1055a));
    }

    @Override // com.zenmen.palmchat.giftkit.a.b
    public boolean b() {
        return p05.c();
    }

    @Override // com.zenmen.palmchat.giftkit.a.b
    public boolean c() {
        return c46.b();
    }
}
