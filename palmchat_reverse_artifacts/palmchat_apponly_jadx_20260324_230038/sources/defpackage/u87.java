package defpackage;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class u87 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p47 f21160a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u87(p47 p47Var, Looper looper) {
        super(looper);
        this.f21160a = p47Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        StringBuilder sb;
        ServiceConnection serviceConnection;
        super.handleMessage(message);
        String string = message.getData().getString("IdType");
        int i = message.what;
        if (i == 1) {
            be7.a("2017");
            p47 p47Var = this.f21160a;
            if (p47Var.i || p47Var.f19938a != null) {
                try {
                    String strB = this.f21160a.b(string);
                    p47 p47Var2 = this.f21160a;
                    p47Var2.c(p47Var2.h, string, strB);
                    synchronized (this.f21160a.d) {
                        this.f21160a.d.notify();
                    }
                } catch (RemoteException e) {
                    e = e;
                    str = "1005";
                    be7.b(str, e);
                } catch (Exception e2) {
                    e = e2;
                    str = "1054";
                    be7.b(str, e);
                }
            } else {
                sb = new StringBuilder();
                sb.append(this.f21160a.b);
                sb.append(" 1009");
                Log.e("IDHelper", sb.toString());
            }
        } else {
            if (i == 2) {
                p47 p47Var3 = this.f21160a;
                synchronized (p47Var3) {
                    try {
                        if (p47Var3.f19938a != null) {
                            be7.a("2019");
                            Context context = p47Var3.h;
                            if (context != null && (serviceConnection = p47Var3.e) != null) {
                                context.unbindService(serviceConnection);
                            }
                            p47Var3.f19938a = null;
                        }
                    } catch (Exception e3) {
                        be7.b("1010", e3);
                    }
                }
                return;
            }
            if (i != 3) {
                return;
            }
            be7.a("2017");
            if (this.f21160a.f19938a == null) {
                sb = new StringBuilder();
                sb.append(this.f21160a.b);
                sb.append(" 1009");
                Log.e("IDHelper", sb.toString());
            } else {
                try {
                    this.f21160a.b(string);
                    synchronized (this.f21160a.d) {
                        this.f21160a.d.notify();
                    }
                } catch (RemoteException e4) {
                    e = e4;
                    str = "1055";
                    be7.b(str, e);
                } catch (Exception e5) {
                    e = e5;
                    str = "1056";
                    be7.b(str, e);
                }
            }
        }
        be7.a("2018");
    }
}
