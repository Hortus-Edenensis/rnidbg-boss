package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class zt0 implements mv1<zt0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22506a;
    public final long b;
    public final long c;
    public final boolean d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;

    @Nullable
    public final f76 i;

    @Nullable
    public final e65 j;

    @Nullable
    public final Uri k;

    @Nullable
    public final vn4 l;
    public final List<mg4> m;

    public zt0(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, @Nullable vn4 vn4Var, @Nullable f76 f76Var, @Nullable e65 e65Var, @Nullable Uri uri, List<mg4> list) {
        this.f22506a = j;
        this.b = j2;
        this.c = j3;
        this.d = z;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        this.h = j7;
        this.l = vn4Var;
        this.i = f76Var;
        this.k = uri;
        this.j = e65Var;
        this.m = list == null ? Collections.emptyList() : list;
    }

    public static ArrayList<c7> b(List<c7> list, LinkedList<StreamKey> linkedList) {
        StreamKey streamKeyPoll = linkedList.poll();
        int i = streamKeyPoll.periodIndex;
        ArrayList<c7> arrayList = new ArrayList<>();
        do {
            int i2 = streamKeyPoll.groupIndex;
            c7 c7Var = list.get(i2);
            List<ow4> list2 = c7Var.c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(streamKeyPoll.streamIndex));
                streamKeyPoll = linkedList.poll();
                if (streamKeyPoll.periodIndex != i) {
                    break;
                }
            } while (streamKeyPoll.groupIndex == i2);
            arrayList.add(new c7(c7Var.f1901a, c7Var.b, arrayList2, c7Var.d, c7Var.e, c7Var.f));
        } while (streamKeyPoll.periodIndex == i);
        linkedList.addFirst(streamKeyPoll);
        return arrayList;
    }

    @Override // defpackage.mv1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zt0 copy(List<StreamKey> list) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j = 0;
        int i = 0;
        while (true) {
            if (i >= d()) {
                break;
            }
            if (((StreamKey) linkedList.peek()).periodIndex != i) {
                long jE = e(i);
                if (jE != -9223372036854775807L) {
                    j += jE;
                }
            } else {
                mg4 mg4VarC = c(i);
                arrayList.add(new mg4(mg4VarC.f19213a, mg4VarC.b - j, b(mg4VarC.c, linkedList), mg4VarC.d));
            }
            i++;
        }
        long j2 = this.b;
        return new zt0(this.f22506a, j2 != -9223372036854775807L ? j2 - j : -9223372036854775807L, this.c, this.d, this.e, this.f, this.g, this.h, this.l, this.i, this.j, this.k, arrayList);
    }

    public final mg4 c(int i) {
        return this.m.get(i);
    }

    public final int d() {
        return this.m.size();
    }

    public final long e(int i) {
        long j;
        long j2;
        if (i == this.m.size() - 1) {
            j = this.b;
            if (j == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j2 = this.m.get(i).b;
        } else {
            j = this.m.get(i + 1).b;
            j2 = this.m.get(i).b;
        }
        return j - j2;
    }

    public final long f(int i) {
        return g86.H0(e(i));
    }
}
