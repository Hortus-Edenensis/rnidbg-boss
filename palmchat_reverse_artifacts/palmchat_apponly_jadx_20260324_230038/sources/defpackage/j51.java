package defpackage;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class j51 implements ys1 {
    public static final int[] o = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};
    public static final a p = new a(new a.InterfaceC1221a() { // from class: f51
        @Override // j51.a.InterfaceC1221a
        public final Constructor getConstructor() {
            return j51.d();
        }
    });
    public static final a q = new a(new a.InterfaceC1221a() { // from class: h51
        @Override // j51.a.InterfaceC1221a
        public final Constructor getConstructor() {
            return j51.e();
        }
    });
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int l;

    @Nullable
    public ImmutableList<m> m;
    public int k = 1;
    public int n = 112800;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC1221a f18330a;
        public final AtomicBoolean b = new AtomicBoolean(false);

        @Nullable
        @GuardedBy("extensionLoaded")
        public Constructor<? extends os1> c;

        /* JADX INFO: renamed from: j51$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public interface InterfaceC1221a {
            @Nullable
            Constructor<? extends os1> getConstructor() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException;
        }

        public a(InterfaceC1221a interfaceC1221a) {
            this.f18330a = interfaceC1221a;
        }

        @Nullable
        public os1 a(Object... objArr) {
            Constructor<? extends os1> constructorB = b();
            if (constructorB == null) {
                return null;
            }
            try {
                return constructorB.newInstance(objArr);
            } catch (Exception e) {
                throw new IllegalStateException("Unexpected error creating extractor", e);
            }
        }

        @Nullable
        public final Constructor<? extends os1> b() {
            synchronized (this.b) {
                if (this.b.get()) {
                    return this.c;
                }
                try {
                    return this.f18330a.getConstructor();
                } catch (ClassNotFoundException unused) {
                    this.b.set(true);
                    return this.c;
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
        }
    }

    @Nullable
    public static Constructor<? extends os1> d() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
            return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(os1.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    public static Constructor<? extends os1> e() throws NoSuchMethodException, ClassNotFoundException {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(os1.class).getConstructor(new Class[0]);
    }

    public final void c(int i, List<os1> list) {
        switch (i) {
            case 0:
                list.add(new f2());
                break;
            case 1:
                list.add(new l2());
                break;
            case 2:
                list.add(new c8((this.c ? 2 : 0) | this.d | (this.b ? 1 : 0)));
                break;
            case 3:
                list.add(new aa((this.c ? 2 : 0) | this.e | (this.b ? 1 : 0)));
                break;
            case 4:
                os1 os1VarA = p.a(Integer.valueOf(this.f));
                if (os1VarA == null) {
                    list.add(new kx1(this.f));
                } else {
                    list.add(os1VarA);
                }
                break;
            case 5:
                list.add(new o02());
                break;
            case 6:
                list.add(new he3(this.g));
                break;
            case 7:
                list.add(new or3((this.c ? 2 : 0) | this.j | (this.b ? 1 : 0)));
                break;
            case 8:
                list.add(new b32(this.i));
                list.add(new wr3(this.h));
                break;
            case 9:
                list.add(new g64());
                break;
            case 10:
                list.add(new wo4());
                break;
            case 11:
                if (this.m == null) {
                    this.m = ImmutableList.of();
                }
                list.add(new i26(this.k, new jy5(0L), new ka1(this.l, this.m), this.n));
                break;
            case 12:
                list.add(new oi6());
                break;
            case 14:
                list.add(new ry2());
                break;
            case 15:
                os1 os1VarA2 = q.a(new Object[0]);
                if (os1VarA2 != null) {
                    list.add(os1VarA2);
                }
                break;
            case 16:
                list.add(new gn());
                break;
        }
    }

    @Override // defpackage.ys1
    public synchronized os1[] createExtractors() {
        return createExtractors(Uri.EMPTY, new HashMap());
    }

    @Override // defpackage.ys1
    public synchronized os1[] createExtractors(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        int[] iArr = o;
        arrayList = new ArrayList(iArr.length);
        int iB = ku1.b(map);
        if (iB != -1) {
            c(iB, arrayList);
        }
        int iC = ku1.c(uri);
        if (iC != -1 && iC != iB) {
            c(iC, arrayList);
        }
        for (int i : iArr) {
            if (i != iB && i != iC) {
                c(i, arrayList);
            }
        }
        return (os1[]) arrayList.toArray(new os1[arrayList.size()]);
    }
}
