package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f9420a;

    public static e a() {
        if (f9420a == null) {
            synchronized (e.class) {
                if (f9420a == null) {
                    f9420a = new e();
                }
            }
        }
        return f9420a;
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.SHAKE;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008b A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // com.opos.mobad.template.e.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        com.opos.mobad.template.e.c.b.b bVar;
        if (i != 27) {
            if (i != 28) {
                if (i != 2009) {
                    if (i == 2010) {
                        return new com.opos.mobad.template.e.c.d(context, b(), 1, false);
                    }
                    if (i != 2114 && i != 2115) {
                        if (i != 2138 && i != 2139) {
                            switch (i) {
                                case 7:
                                case 2007:
                                    break;
                                case 48:
                                case 2085:
                                    break;
                                case 56:
                                case 62:
                                case 68:
                                case 2024:
                                case 2041:
                                case 2053:
                                case 2058:
                                case 2061:
                                case 2073:
                                    return new com.opos.mobad.template.e.c.d.d(context, b(), 0);
                                case 59:
                                    return new com.opos.mobad.template.e.c.d.d(context, b(), 1);
                                case 71:
                                    return new com.opos.mobad.template.e.c.d.e(context, b());
                                case 2124:
                                case 2141:
                                case 2142:
                                case 2143:
                                case 2144:
                                case 2145:
                                case 2146:
                                case 2147:
                                    break;
                                case 2148:
                                    com.opos.mobad.template.e.c.b.b bVar2 = new com.opos.mobad.template.e.c.b.b(context, b(), 0, false, null);
                                    if (bVar2.c() != null) {
                                        return bVar2;
                                    }
                                    return null;
                                case 2160:
                                case 2161:
                                    return new com.opos.mobad.template.e.c.c.a(context, b());
                                default:
                                    switch (i) {
                                        case 12:
                                        case 14:
                                            break;
                                        case 13:
                                        case 15:
                                            break;
                                        default:
                                            switch (i) {
                                                case 2028:
                                                case 2030:
                                                    break;
                                                case 2029:
                                                case 2031:
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 2126:
                                                            com.opos.mobad.template.e.c.b.b bVar3 = new com.opos.mobad.template.e.c.b.b(context, b(), 1, true, "#0066FF");
                                                            if (bVar3.c() != null) {
                                                                return bVar3;
                                                            }
                                                            return null;
                                                        default:
                                                            switch (i) {
                                                                default:
                                                                    switch (i) {
                                                                        case 2150:
                                                                        case 2152:
                                                                            break;
                                                                        case 2151:
                                                                        case 2153:
                                                                            break;
                                                                        default:
                                                                            return null;
                                                                    }
                                                                case 2132:
                                                                case 2133:
                                                                case 2134:
                                                                case 2135:
                                                                case 2136:
                                                                    bVar = new com.opos.mobad.template.e.c.b.b(context, b(), 0, true, null);
                                                                    if (bVar.c() == null) {
                                                                        return bVar;
                                                                    }
                                                                    return null;
                                                            }
                                                        case 2127:
                                                        case 2128:
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                        }
                        bVar = new com.opos.mobad.template.e.c.b.b(context, b(), 0, true, null);
                        if (bVar.c() == null) {
                        }
                    }
                }
            }
            return new com.opos.mobad.template.e.c.d(context, b(), 0, false);
        }
        return new com.opos.mobad.template.e.c.d(context, b(), 0, true);
    }
}
