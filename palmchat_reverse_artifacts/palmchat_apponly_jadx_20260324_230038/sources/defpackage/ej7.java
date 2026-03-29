package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ej7 implements Handler.Callback {
    public static Printer j;
    public static ej7 k;
    public static final Printer l = new a();
    public long c;
    public long d;
    public boolean i;
    public int b = 0;
    public final SparseArray<List<Runnable>> e = new SparseArray<>();
    public final List<Printer> f = new LinkedList();
    public final List<Printer> g = new LinkedList();
    public boolean h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f17308a = new Handler(im7.b().getLooper(), this);

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Printer {
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                ej7.f().i(str);
            } else if (str.startsWith("<<<<< Finished")) {
                ej7.f().d(str);
            }
            if (ej7.j == null || ej7.j == ej7.l) {
                return;
            }
            ej7.j.println(str);
        }
    }

    public ej7() {
        c();
    }

    public static ej7 f() {
        if (k == null) {
            synchronized (ej7.class) {
                if (k == null) {
                    k = new ej7();
                }
            }
        }
        return k;
    }

    public static void j(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<? extends Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        } catch (Exception e) {
            mf7.d(e);
        }
    }

    public void c() {
        if (this.h) {
            return;
        }
        this.h = true;
        Printer printerE = e();
        j = printerE;
        Printer printer = l;
        if (printerE == printer) {
            j = null;
        }
        Looper.getMainLooper().setMessageLogging(printer);
    }

    public void d(String str) {
        this.d = SystemClock.uptimeMillis();
        try {
            this.f17308a.removeMessages(2);
            k(this.g, str);
            this.f17308a.sendEmptyMessage(1);
        } catch (Exception e) {
            mf7.a(e);
        }
    }

    public final Printer e() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e) {
            mf7.a(e);
            return null;
        }
    }

    public void g(long j2, Runnable runnable) {
        h(j2, runnable, 1, 0L);
    }

    public void h(long j2, Runnable runnable, int i, long j3) {
        if (j2 < 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (int) j2;
            List<Runnable> linkedList = this.e.get(i3);
            if (linkedList == null) {
                synchronized (this.e) {
                    linkedList = this.e.get(i3);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                        this.e.put(i3, linkedList);
                    }
                }
            }
            linkedList.add(runnable);
            j2 += j3;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f17308a.hasMessages(0)) {
            return true;
        }
        int i = message.what;
        if (i == 0) {
            this.b = 0;
            if (this.e.size() != 0 && this.e.keyAt(0) == 0) {
                j(this.e.valueAt(0));
                this.b++;
            }
        } else {
            if (i == 1) {
                this.f17308a.removeMessages(2);
                if (this.e.size() != 0) {
                    SparseArray<List<Runnable>> sparseArray = this.e;
                    if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                        j(this.e.get(Integer.MAX_VALUE));
                    }
                }
                return true;
            }
            if (i == 2) {
                j(this.e.valueAt(this.b));
                this.b++;
            }
        }
        if (this.b >= this.e.size()) {
            return true;
        }
        long jKeyAt = this.e.keyAt(this.b);
        if (jKeyAt != 2147483647L) {
            this.f17308a.sendEmptyMessageAtTime(2, this.c + jKeyAt);
        }
        return true;
    }

    public void i(String str) {
        if (!this.i) {
            ye7.a(32L);
            this.i = true;
        }
        this.c = SystemClock.uptimeMillis();
        try {
            k(this.f, str);
            this.f17308a.sendEmptyMessage(0);
        } catch (Exception e) {
            mf7.d(e);
        }
    }

    public final synchronized void k(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    Iterator<? extends Printer> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().println(str);
                    }
                } catch (Exception e) {
                    mf7.d(e);
                }
            }
        }
    }
}
