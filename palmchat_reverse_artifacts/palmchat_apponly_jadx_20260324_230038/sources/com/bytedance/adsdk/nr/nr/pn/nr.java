package com.bytedance.adsdk.nr.nr.pn;

import com.bytedance.adsdk.nr.nr.b.b;
import com.bytedance.adsdk.nr.nr.b.fx;
import com.bytedance.adsdk.nr.nr.nr.u.a;
import com.bytedance.adsdk.nr.nr.nr.u.bg;
import com.bytedance.adsdk.nr.nr.nr.u.iz;
import com.bytedance.adsdk.nr.nr.nr.u.l;
import com.bytedance.adsdk.nr.nr.nr.u.mv;
import com.bytedance.adsdk.nr.nr.nr.u.n;
import com.bytedance.adsdk.nr.nr.nr.u.o;
import com.bytedance.adsdk.nr.nr.nr.u.pn;
import com.bytedance.adsdk.nr.nr.nr.u.s;
import com.bytedance.adsdk.nr.nr.nr.u.sx;
import com.bytedance.adsdk.nr.nr.nr.u.t;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr {

    /* JADX INFO: renamed from: com.bytedance.adsdk.nr.nr.pn.nr$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[fx.values().length];
            u = iArr;
            try {
                iArr[fx.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[fx.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                u[fx.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                u[fx.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                u[fx.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                u[fx.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                u[fx.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                u[fx.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                u[fx.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                u[fx.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                u[fx.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                u[fx.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                u[fx.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static void fx(List<com.bytedance.adsdk.nr.nr.nr.u> list, String str, int i) {
        Iterator<com.bytedance.adsdk.nr.nr.nr.u> it = list.iterator();
        while (it.hasNext()) {
            if (b.u(it.next().u())) {
                throw new IllegalArgumentException(str.substring(0, i));
            }
        }
    }

    private static Deque<com.bytedance.adsdk.nr.nr.nr.u> nr(List<com.bytedance.adsdk.nr.nr.nr.u> list, String str, int i) {
        LinkedList<com.bytedance.adsdk.nr.nr.nr.u> linkedList = new LinkedList(list);
        int i2 = 5;
        while (i2 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.bytedance.adsdk.nr.nr.nr.u uVar : linkedList) {
                if (!linkedList2.isEmpty() && fx.u(((com.bytedance.adsdk.nr.nr.nr.u) linkedList2.peekLast()).u()) && ((fx) ((com.bytedance.adsdk.nr.nr.nr.u) linkedList2.peekLast()).u()).nr() == i2) {
                    com.bytedance.adsdk.nr.nr.nr.u uVar2 = (com.bytedance.adsdk.nr.nr.nr.u) linkedList2.pollLast();
                    com.bytedance.adsdk.nr.nr.nr.u uVar3 = (com.bytedance.adsdk.nr.nr.nr.u) linkedList2.pollLast();
                    if (fx.u(uVar3.u()) || fx.u(uVar.u())) {
                        throw new IllegalArgumentException(str.substring(0, i));
                    }
                    linkedList2.addLast(u(uVar3, uVar2, uVar));
                } else {
                    linkedList2.addLast(uVar);
                }
            }
            i2--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    public static com.bytedance.adsdk.nr.nr.nr.u u(List<com.bytedance.adsdk.nr.nr.nr.u> list, String str, int i) {
        fx(list, str, i);
        Deque<com.bytedance.adsdk.nr.nr.nr.u> dequeU = u(nr(list, str, i));
        if (dequeU.size() == 1) {
            return dequeU.getFirst();
        }
        throw new IllegalStateException();
    }

    private static Deque<com.bytedance.adsdk.nr.nr.nr.u> u(Deque<com.bytedance.adsdk.nr.nr.nr.u> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.adsdk.nr.nr.nr.u uVar : deque) {
            if (!linkedList.isEmpty() && ((com.bytedance.adsdk.nr.nr.nr.u) linkedList.peekLast()).u() == fx.COLON) {
                linkedList.pollLast();
                com.bytedance.adsdk.nr.nr.nr.u uVar2 = (com.bytedance.adsdk.nr.nr.nr.u) linkedList.pollLast();
                if (((com.bytedance.adsdk.nr.nr.nr.u) linkedList.pollLast()).u() == fx.QUESTION) {
                    com.bytedance.adsdk.nr.nr.nr.u uVar3 = (com.bytedance.adsdk.nr.nr.nr.u) linkedList.pollLast();
                    bg bgVar = new bg();
                    bgVar.u(uVar3);
                    bgVar.nr(uVar2);
                    bgVar.fx(uVar);
                    linkedList.addLast(bgVar);
                } else {
                    throw new IllegalStateException();
                }
            } else {
                linkedList.addLast(uVar);
            }
        }
        return linkedList;
    }

    private static com.bytedance.adsdk.nr.nr.nr.u u(com.bytedance.adsdk.nr.nr.nr.u uVar, com.bytedance.adsdk.nr.nr.nr.u uVar2, com.bytedance.adsdk.nr.nr.nr.u uVar3) {
        o tVar;
        switch (AnonymousClass1.u[((fx) uVar2.u()).ordinal()]) {
            case 1:
                tVar = new t();
                break;
            case 2:
                tVar = new sx();
                break;
            case 3:
                tVar = new com.bytedance.adsdk.nr.nr.nr.u.u();
                break;
            case 4:
                tVar = new mv();
                break;
            case 5:
                tVar = new l();
                break;
            case 6:
                tVar = new com.bytedance.adsdk.nr.nr.nr.u.b();
                break;
            case 7:
                tVar = new s();
                break;
            case 8:
                tVar = new iz();
                break;
            case 9:
                tVar = new a();
                break;
            case 10:
                tVar = new pn();
                break;
            case 11:
                tVar = new n();
                break;
            case 12:
                tVar = new com.bytedance.adsdk.nr.nr.nr.u.nr();
                break;
            case 13:
                tVar = new com.bytedance.adsdk.nr.nr.nr.u.fx();
                break;
            default:
                throw new UnsupportedOperationException(uVar2.u().toString());
        }
        tVar.u(uVar);
        tVar.nr(uVar3);
        return tVar;
    }

    public static boolean u(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }
}
