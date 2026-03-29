package defpackage;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class z45 {
    public static final jh5 d = jh5.d(':');
    public static final jh5 e = jh5.d('*');

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f22347a = new ArrayList();
    public int b = 0;
    public int c;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22348a;
        public final long b;
        public final int c;

        public a(int i, long j, int i2) {
            this.f22348a = i;
            this.b = j;
            this.c = i2;
        }
    }

    public static int b(String str) throws ParserException {
        str.hashCode();
        switch (str) {
            case "SlowMotion_Data":
                return 2192;
            case "Super_SlowMotion_Edit_Data":
                return 2819;
            case "Super_SlowMotion_Data":
                return 2816;
            case "Super_SlowMotion_Deflickering_On":
                return 2820;
            case "Super_SlowMotion_BGM":
                return 2817;
            default:
                throw ParserException.createForMalformedContainer("Invalid SEF name", null);
        }
    }

    public static SlowMotionData f(gc4 gc4Var, int i) throws ParserException {
        ArrayList arrayList = new ArrayList();
        List<String> listF = e.f(gc4Var.E(i));
        for (int i2 = 0; i2 < listF.size(); i2++) {
            List<String> listF2 = d.f(listF.get(i2));
            if (listF2.size() != 3) {
                throw ParserException.createForMalformedContainer(null, null);
            }
            try {
                arrayList.add(new SlowMotionData.Segment(Long.parseLong(listF2.get(0)), Long.parseLong(listF2.get(1)), 1 << (Integer.parseInt(listF2.get(2)) - 1)));
            } catch (NumberFormatException e2) {
                throw ParserException.createForMalformedContainer(null, e2);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public final void a(ps1 ps1Var, vk4 vk4Var) throws IOException {
        gc4 gc4Var = new gc4(8);
        ps1Var.readFully(gc4Var.e(), 0, 8);
        this.c = gc4Var.u() + 8;
        if (gc4Var.q() != 1397048916) {
            vk4Var.f21468a = 0L;
        } else {
            vk4Var.f21468a = ps1Var.getPosition() - ((long) (this.c - 12));
            this.b = 2;
        }
    }

    public int c(ps1 ps1Var, vk4 vk4Var, List<Metadata.Entry> list) throws IOException {
        int i = this.b;
        long j = 0;
        if (i == 0) {
            long length = ps1Var.getLength();
            if (length != -1 && length >= 8) {
                j = length - 8;
            }
            vk4Var.f21468a = j;
            this.b = 1;
        } else if (i == 1) {
            a(ps1Var, vk4Var);
        } else if (i == 2) {
            d(ps1Var, vk4Var);
        } else {
            if (i != 3) {
                throw new IllegalStateException();
            }
            e(ps1Var, list);
            vk4Var.f21468a = 0L;
        }
        return 1;
    }

    public final void d(ps1 ps1Var, vk4 vk4Var) throws IOException {
        long length = ps1Var.getLength();
        int i = (this.c - 12) - 8;
        gc4 gc4Var = new gc4(i);
        ps1Var.readFully(gc4Var.e(), 0, i);
        for (int i2 = 0; i2 < i / 12; i2++) {
            gc4Var.V(2);
            short sW = gc4Var.w();
            if (sW == 2192 || sW == 2816 || sW == 2817 || sW == 2819 || sW == 2820) {
                this.f22347a.add(new a(sW, (length - ((long) this.c)) - ((long) gc4Var.u()), gc4Var.u()));
            } else {
                gc4Var.V(8);
            }
        }
        if (this.f22347a.isEmpty()) {
            vk4Var.f21468a = 0L;
        } else {
            this.b = 3;
            vk4Var.f21468a = this.f22347a.get(0).b;
        }
    }

    public final void e(ps1 ps1Var, List<Metadata.Entry> list) throws IOException {
        long position = ps1Var.getPosition();
        int length = (int) ((ps1Var.getLength() - ps1Var.getPosition()) - ((long) this.c));
        gc4 gc4Var = new gc4(length);
        ps1Var.readFully(gc4Var.e(), 0, length);
        for (int i = 0; i < this.f22347a.size(); i++) {
            a aVar = this.f22347a.get(i);
            gc4Var.U((int) (aVar.b - position));
            gc4Var.V(4);
            int iU = gc4Var.u();
            int iB = b(gc4Var.E(iU));
            int i2 = aVar.c - (iU + 8);
            if (iB == 2192) {
                list.add(f(gc4Var, i2));
            } else if (iB != 2816 && iB != 2817 && iB != 2819 && iB != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    public void g() {
        this.f22347a.clear();
        this.b = 0;
    }
}
