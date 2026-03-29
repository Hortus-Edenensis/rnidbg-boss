package defpackage;

import com.zenmen.palmchat.messaging.smack.XMPPException;
import com.zenmen.palmchat.utils.HexDumper;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.AuthResponseProto;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import im.youni.iccs.iprotobuf.domain.PingProto;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class yo6 extends jb4 {
    public static final String g = "yo6";
    public xo6 e;
    public DataInputStream f;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22244a;
        public final /* synthetic */ byte b;

        public a(int i, byte b) {
            this.f22244a = i;
            this.b = b;
            put("action", "msg_receive_parse");
            put("status", "start");
            put("packetLen", Integer.valueOf(i));
            put("packeType", HexDumper.toHexString(new byte[]{b}));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageProto.Message f22245a;

        public b(MessageProto.Message message) {
            this.f22245a = message;
            put("action", "msg_process_packet");
            put("status", "decodeProtoBuffer");
            put("mid", message.getMid());
            put("type", Integer.valueOf(message.getType()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("action", "receive message error");
        }
    }

    public yo6(xo6 xo6Var) {
        super(xo6Var);
        this.e = xo6Var;
        this.f = new DataInputStream(xo6Var.t);
        a();
    }

    public static void h(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
    }

    @Override // defpackage.jb4
    public void a() {
        super.a();
    }

    @Override // defpackage.jb4
    public void d(Thread thread) {
        byte[] bArrQ;
        MessageProto.Message from;
        do {
            try {
                int i = this.f.readInt();
                byte b2 = this.f.readByte();
                this.f.readByte();
                String str = g;
                LogUtil.i(str, 3, new a(i, b2), (Throwable) null);
                int i2 = i - 6;
                byte[] bArr = new byte[i2];
                j(bArr, 0, i2);
                if (b2 == 0) {
                    PingProto.Ping from2 = PingProto.Ping.parseFrom(bArr);
                    if (from2 != null) {
                        mi4 mi4Var = this.e.s;
                        if (mi4Var != null) {
                            mi4Var.g(from2.getMid());
                        }
                        mi4.j = System.currentTimeMillis();
                    }
                } else if (b2 == 2) {
                    AuthResponseProto.AuthResponse from3 = AuthResponseProto.AuthResponse.parseFrom(bArr);
                    if (from3 != null) {
                        e(from3, from3.getMid());
                    }
                } else if (b2 == 17 && om1.f().o() && (bArrQ = om1.f().q(bArr, false)) != null && (from = MessageProto.Message.parseFrom(bArrQ)) != null) {
                    LogUtil.i(str, 3, new b(from), (Throwable) null);
                    e(from, from.getMid());
                    if (from.getType() != 5) {
                        kb4.c(this.e, from.getMid(), from.getTo(), from.getFrom());
                    }
                }
                if (this.d) {
                    return;
                }
            } catch (Throwable th) {
                LogUtil.i(g, 1, new c(), th);
                if (this.d) {
                    return;
                }
                b(new Exception("Throwable on parsePackets" + th.toString()));
                return;
            }
        } while (thread == this.f18372a);
    }

    @Override // defpackage.jb4
    public void g() throws XMPPException {
        this.f18372a.start();
    }

    public final int i(byte[] bArr, int i, int i2) throws IOException {
        h(bArr.length, i, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            try {
                int i4 = this.f.read();
                if (i4 == -1) {
                    if (i3 == 0) {
                        return -1;
                    }
                    return i3;
                }
                bArr[i + i3] = (byte) i4;
            } catch (IOException e) {
                e.printStackTrace();
                if (i3 != 0) {
                    return i3;
                }
                throw e;
            }
        }
        return i2;
    }

    public final void j(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return;
        }
        if (this.f == null) {
            throw new NullPointerException("in == null");
        }
        if (bArr == null) {
            throw new NullPointerException("dst == null");
        }
        h(bArr.length, i, i2);
        while (i2 > 0) {
            int i3 = i(bArr, i, i2);
            if (i3 < 0) {
                throw new EOFException();
            }
            i += i3;
            i2 -= i3;
        }
    }
}
