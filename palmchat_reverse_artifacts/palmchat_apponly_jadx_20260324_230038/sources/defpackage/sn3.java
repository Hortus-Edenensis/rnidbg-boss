package defpackage;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public class sn3 implements rc4, nd2 {
    public final String d;
    public final MergePaths f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f20790a = new Path();
    public final Path b = new Path();
    public final Path c = new Path();
    public final List<rc4> e = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20791a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f20791a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20791a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20791a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20791a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20791a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public sn3(MergePaths mergePaths) {
        this.d = mergePaths.c();
        this.f = mergePaths;
    }

    @Override // defpackage.nd2
    public void b(ListIterator<ko0> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            ko0 ko0VarPrevious = listIterator.previous();
            if (ko0VarPrevious instanceof rc4) {
                this.e.add((rc4) ko0VarPrevious);
                listIterator.remove();
            }
        }
    }

    public final void c() {
        for (int i = 0; i < this.e.size(); i++) {
            this.c.addPath(this.e.get(i).getPath());
        }
    }

    @TargetApi(19)
    public final void e(Path.Op op) {
        this.b.reset();
        this.f20790a.reset();
        for (int size = this.e.size() - 1; size >= 1; size--) {
            rc4 rc4Var = this.e.get(size);
            if (rc4Var instanceof mo0) {
                mo0 mo0Var = (mo0) rc4Var;
                List<rc4> listJ = mo0Var.j();
                for (int size2 = listJ.size() - 1; size2 >= 0; size2--) {
                    Path path = listJ.get(size2).getPath();
                    path.transform(mo0Var.k());
                    this.b.addPath(path);
                }
            } else {
                this.b.addPath(rc4Var.getPath());
            }
        }
        rc4 rc4Var2 = this.e.get(0);
        if (rc4Var2 instanceof mo0) {
            mo0 mo0Var2 = (mo0) rc4Var2;
            List<rc4> listJ2 = mo0Var2.j();
            for (int i = 0; i < listJ2.size(); i++) {
                Path path2 = listJ2.get(i).getPath();
                path2.transform(mo0Var2.k());
                this.f20790a.addPath(path2);
            }
        } else {
            this.f20790a.set(rc4Var2.getPath());
        }
        this.c.op(this.f20790a, this.b, op);
    }

    @Override // defpackage.ko0
    public void f(List<ko0> list, List<ko0> list2) {
        for (int i = 0; i < this.e.size(); i++) {
            this.e.get(i).f(list, list2);
        }
    }

    @Override // defpackage.rc4
    public Path getPath() {
        this.c.reset();
        if (this.f.d()) {
            return this.c;
        }
        int i = a.f20791a[this.f.b().ordinal()];
        if (i == 1) {
            c();
        } else if (i == 2) {
            e(Path.Op.UNION);
        } else if (i == 3) {
            e(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            e(Path.Op.INTERSECT);
        } else if (i == 5) {
            e(Path.Op.XOR);
        }
        return this.c;
    }
}
