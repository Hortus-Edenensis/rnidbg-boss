package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.sdk.impl.helper.JException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Random;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class jm0 {
    public static void a(Context context) {
        lg5.h(context, zz2.V(true).a0(null), zz2.V(false).a0(null));
    }

    public static void b(Context context) {
        lg5.h(context, zz2.S().a0(null), zz2.e0().a0(null), zz2.O(false).a0(null), zz2.O(true).a0(null), zz2.P().a0(null), zz2.U().a0(null), zz2.d0().a0(null), zz2.W(true).a0(null), zz2.W(false).a0(null), zz2.V(true).a0(null), zz2.V(false).a0(null));
        lg5.h(context, zz2.K().a0(null), zz2.I().a0(null), zz2.H().a0(null));
    }

    public static String c(Context context) {
        String strK = zd1.e().k();
        k63.a("ConnectingHelper", "regVersion:" + strK);
        vb1 vb1VarA = vb1.a(context);
        return k(vb1VarA.c, " ") + "$$" + k(vb1VarA.d, " ") + "$$" + k(vb1VarA.e, " ") + "$$" + k(vb1VarA.f, " ") + "$$" + k(fv2.f(context), " ") + "$$" + strK + "$$" + vb1VarA.h + "$$" + vb1VarA.i;
    }

    public static String d(Context context) {
        String str = JCoreManager.isInternal() ? tv2.n : null;
        return !TextUtils.isEmpty(str) ? str : ad.h(context);
    }

    public static String e(Context context) {
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        String strOptString5;
        try {
            String strB = tb1.b(context);
            int i = tb1.f20948a;
            String str = vb1.a(context).p;
            String str2 = vb1.a(context).j;
            Object objA = qv2.a(context, "get_all_ids", null);
            if (objA == null || !(objA instanceof JSONObject)) {
                strOptString = "";
                strOptString2 = strOptString;
                strOptString3 = strOptString2;
                strOptString4 = strOptString3;
                strOptString5 = strOptString4;
            } else {
                k63.a("ConnectingHelper", "parse ids:" + objA.toString());
                strOptString2 = ((JSONObject) objA).optString("udid", "");
                strOptString3 = ((JSONObject) objA).optString("joad", "");
                strOptString4 = ((JSONObject) objA).optString("jvad", "");
                strOptString5 = ((JSONObject) objA).optString("jaad", "");
                strOptString = ((JSONObject) objA).optString("jgad", "");
            }
            return i + "$$" + k(strB, " ") + "$$" + k(str, " ") + "$$" + k(str2, " ") + "$$" + k("", " ") + "$$" + k(" ", " ") + "$$" + k(strOptString2, " ") + "$$" + k(strOptString3, " ") + "$$" + k(strOptString4, " ") + "$$" + k(strOptString5, " ") + "$$" + k(strOptString, " ");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String f(Context context) {
        return k(i36.d(context), " ") + "$$" + k(vb1.a(context).o, " ") + "$$" + context.getPackageName() + "$$" + fv2.e(context);
    }

    public static byte[] g(DatagramSocket datagramSocket, DatagramPacket datagramPacket) throws IOException {
        datagramSocket.setSoTimeout(6000);
        datagramSocket.send(datagramPacket);
        DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1024], 1024);
        k63.b("ConnectingHelper", "udp Receiving...");
        datagramSocket.receive(datagramPacket2);
        int length = datagramPacket2.getLength();
        byte[] bArr = new byte[length];
        System.arraycopy(datagramPacket2.getData(), 0, bArr, 0, length);
        return bArr;
    }

    public static void h(Context context, int i) {
        i(context, i, true);
    }

    public static void i(Context context, int i, boolean z) {
        if (z) {
            String strA = vk5.a(i);
            k63.e("ConnectingHelper", "Register Failed with server error - code:" + i);
            if (!TextUtils.isEmpty(strA)) {
                k63.n("ConnectingHelper", "Local error description: " + strA);
            }
            zd1.e().b(context, 0, i, strA);
        }
        String strE = fv2.e(context);
        if (i != 11) {
            if (i == 1012) {
                b(context);
            }
            if (i == 10001) {
                ad.C(context, " 未在manifest中配置AppKey", -1);
                return;
            }
            switch (i) {
                case 1005:
                    ad.C(context, "包名: " + context.getPackageName() + " 与 AppKey:" + strE + "不匹配", -1);
                    break;
                case 1006:
                    ad.C(context, "包名: " + context.getPackageName() + " 不存在", -1);
                    break;
                case 1007:
                    k63.g("ConnectingHelper", "IMEI is duplicated reported by server. Give up now. ");
                    break;
                case 1008:
                    ad.C(context, " AppKey:" + strE + " 是无效的AppKey,请确认与JIGUANG web端的AppKey一致", -1);
                    break;
                case 1009:
                    ad.C(context, " AppKey:" + strE + " 非android AppKey", -1);
                    break;
                default:
                    k63.g("ConnectingHelper", "Unhandled server response error code - " + i);
                    break;
            }
        }
    }

    public static int j(Context context, ur urVar) {
        Object obj;
        Object obj2;
        long jN = fv2.n(context);
        String strQ = nl5.q(fv2.j(context));
        String str = strQ == null ? "" : strQ;
        String strE = fv2.e(context);
        zd1 zd1VarE = zd1.e();
        String strF = zd1VarE.f();
        byte bI = zd1VarE.i(context);
        k63.h("ConnectingHelper", "Login with - juid:" + jN + ", appKey:" + strE + ", sdkVersion:" + strF + ", pluginPlatformType:" + ((int) bI));
        short sG = zd1VarE.g();
        int iB = cu5.b(context);
        String strB = tb1.b(context);
        String strB2 = nl5.b(String.format(Locale.ENGLISH, d(context), new Object[0]));
        String upperCase = strB2 == null ? "" : strB2.toUpperCase();
        String strC = fv2.c(context);
        boolean z = bw2.f1842a;
        k63.a("ConnectingHelper", "login - juid:" + jN + ", flag:" + ((int) sG) + " netType:" + iB + " deviceId:" + strB + " countryCode:" + upperCase + " accountId:" + strC + ",sdkver:" + strF + ", userType :" + (z ? 1 : 0));
        byte[] bArrH = cw2.h(l(context), jN, str, strE, strF, (long) sG, bI, iB, strB, "", upperCase, strC, z ? 1 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append("pluginPlatformType:0b");
        sb.append(Integer.toBinaryString(bI & UByte.MAX_VALUE));
        k63.g("ConnectingHelper", sb.toString());
        byte[] bArrC = cw2.c(context, bArrH);
        if (bArrC == null || bArrC.length < 1 || urVar.h(bArrC) != 0) {
            return -1;
        }
        try {
            Pair<pw2, ByteBuffer> pairB = hv2.b(context, urVar.g(20000).array(), "");
            if (pairB == null || (obj = pairB.first) == null || (obj2 = pairB.second) == null || ((pw2) obj).c != 1) {
                k63.n("ConnectingHelper", "Login failed - can't parse a Login Response");
                return -1;
            }
            c73 c73Var = new c73((pw2) obj, (ByteBuffer) obj2);
            k63.a("ConnectingHelper", c73Var.toString());
            int i = c73Var.c;
            lg5.h(context, zz2.F().a0(Integer.valueOf(c73Var.h)));
            if (i == 0) {
                tv2.l = c73Var.d;
                long j = ((long) c73Var.g) * 1000;
                bw2.q(context, j);
                bw2.k(context, c73Var.h);
                k63.h("ConnectingHelper", "Login succeed - sid:" + tv2.l + ", serverTime;" + j);
            } else {
                k63.n("ConnectingHelper", "Login failed with server error - code:" + vk5.a(i));
            }
            return i;
        } catch (JException e) {
            k63.n("ConnectingHelper", "Login failed - recv msg failed wit error:" + e);
            return -1;
        }
    }

    public static String k(String str, String str2) {
        return !nl5.i(str) ? str : str2;
    }

    public static synchronized long l(Context context) {
        long j;
        long jLongValue = ((Long) lg5.c(context, zz2.x())).longValue();
        if (jLongValue == -1) {
            jLongValue = Math.abs(new Random().nextInt(10000));
        }
        j = (jLongValue + (jLongValue % 2 == 0 ? 1L : 2L)) % ((long) 10000);
        lg5.h(context, zz2.x().a0(Long.valueOf(j)));
        return j;
    }

    public static synchronized byte[] m(String str, int i, byte[] bArr, boolean z, int i2) {
        ia4 ia4Var;
        if (TextUtils.isEmpty(str) || str.length() != 2 || bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("flag or body length error");
        }
        ia4Var = new ia4(300);
        ia4Var.h(0);
        ia4Var.e(str.getBytes());
        ia4Var.j(i);
        ia4Var.h(i2);
        ia4Var.e(bArr);
        ia4Var.i(ia4Var.b(), 0);
        ia4Var.m((byte) ((z ? (byte) 1 : (byte) 0) | 16), 4);
        return ia4Var.d();
    }

    public static byte[] n(String str, String str2) throws Exception {
        boolean z;
        byte[] bArrD;
        byte[] bArrO = nl5.o(str2);
        try {
            bArrD = z86.d(bArrO);
        } catch (IOException unused) {
        }
        if (bArrD.length < bArrO.length) {
            bArrO = bArrD;
            z = true;
        } else {
            z = false;
        }
        int length = bArrO.length;
        int i = n45.i();
        String strH = n45.h(i);
        return m(str, i, n45.a(bArrO, strH, strH.substring(0, 16), true), z, length);
    }

    public static int o(Context context, ur urVar) {
        Object obj;
        Object obj2;
        String strF = f(context);
        String str = vb1.a(context).b;
        String strC = c(context);
        String strE = e(context);
        long j = zd1.e().j();
        String strC2 = fv2.c(context);
        k63.a("ConnectingHelper", "Register with: key:" + strF + ", apkVersion:" + str + ", clientInfo:" + strC + ", extKey:" + strE + ",reg business:" + j + " accountId:" + strC2);
        byte[] bArrC = cw2.c(context, cw2.j(l(context), strF, str, strC, strE, j, strC2));
        if (bArrC == null) {
            k63.n("ConnectingHelper", "Register failed - encrytor reg info failed");
            return -1;
        }
        if (urVar.h(bArrC) != 0) {
            k63.n("ConnectingHelper", "Register failed - send reg info failed");
            return -1;
        }
        try {
            Pair<pw2, ByteBuffer> pairB = hv2.b(context, urVar.g(20000).array(), "");
            if (pairB == null || (obj = pairB.first) == null || (obj2 = pairB.second) == null || ((pw2) obj).c != 0) {
                k63.n("ConnectingHelper", "Register failed - can't parse a Register Response");
                return -1;
            }
            cv4 cv4Var = new cv4((pw2) obj, (ByteBuffer) obj2);
            k63.a("ConnectingHelper", "register response:" + cv4Var);
            int i = cv4Var.c;
            lg5.h(context, zz2.s().a0(Integer.valueOf(i)));
            if (i == 0) {
                long j2 = cv4Var.d;
                String str2 = cv4Var.e;
                String str3 = cv4Var.f;
                String str4 = cv4Var.g;
                k63.h("ConnectingHelper", "Register succeed - juid:" + j2 + ", registrationId:" + str3 + ", deviceId:" + str4);
                if (nl5.i(str3) || 0 == j2) {
                    k63.e("ConnectingHelper", "Unexpected: registrationId/juid should not be empty. ");
                    return -1;
                }
                bw2.j(context, str4);
                bw2.s(context, j2, str2, str3);
            }
            return i;
        } catch (JException e) {
            k63.n("ConnectingHelper", "Register failed - recv msg failed with error:" + e);
            return -1;
        }
    }

    public static byte[] p(byte[] bArr) throws JException {
        if (bArr == null || bArr.length == 0) {
            throw new JException(4, "response is empty!");
        }
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.getShort();
            byteBufferWrap.getShort();
            int i = byteBufferWrap.getInt();
            int i2 = i >>> 24;
            long j = i & 16777215;
            byteBufferWrap.getShort();
            int iRemaining = byteBufferWrap.remaining();
            byte[] bArrA = new byte[iRemaining];
            byteBufferWrap.get(bArrA, 0, iRemaining);
            if (j != 0) {
                String strH = n45.h(j);
                try {
                    bArrA = n45.a(bArrA, strH, strH.substring(0, 16), false);
                    if (bArrA == null) {
                        throw new JException(5, "decrypt response error");
                    }
                } catch (Exception unused) {
                    throw new JException(5, "decrypt response error");
                }
            }
            if ((i2 & 1) != 1) {
                return bArrA;
            }
            try {
                return z86.c(bArrA);
            } catch (IOException unused2) {
                return bArrA;
            }
        } catch (Throwable th) {
            throw new JException(4, "parse head error:" + th.getMessage());
        }
    }
}
