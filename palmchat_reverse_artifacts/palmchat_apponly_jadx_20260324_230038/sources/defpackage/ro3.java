package defpackage;

import com.google.android.exoplayer2.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface ro3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ro3 f20517a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ro3 {
        @Override // defpackage.ro3
        public boolean a(m mVar) {
            String str = mVar.l;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // defpackage.ro3
        public qo3 b(m mVar) {
            String str = mVar.l;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new yg();
                    case "application/x-icy":
                        return new zp2();
                    case "application/id3":
                        return new dq2();
                    case "application/x-emsg":
                        return new on1();
                    case "application/x-scte35":
                        return new gh5();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(m mVar);

    qo3 b(m mVar);
}
