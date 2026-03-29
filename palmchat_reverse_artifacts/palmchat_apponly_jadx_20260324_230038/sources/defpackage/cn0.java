package defpackage;

import com.zenmen.palmchat.contacts.ContactRequestsVO;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cn0 {
    public static cn0 c;
    public static final long[] d = {0, 0, 0, 0};
    public static final long[] e = {100, 200, 300, 200};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2489a = 0;
    public List<ContactRequestsVO> b = new ArrayList();

    public static cn0 b() {
        if (c == null) {
            synchronized (cn0.class) {
                if (c == null) {
                    c = new cn0();
                }
            }
        }
        return c;
    }

    public void a() {
    }

    public void c() {
    }
}
