package defpackage;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.igexin.assist.sdk.AssistPushConsts;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.opos.acs.st.STManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import com.zm.fissionsdk.ZW2Vz;
import defpackage.dp;
import defpackage.ww3;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class x31 implements dp, u06 {
    public static final ImmutableList<Long> p = ImmutableList.of(4400000L, 3200000L, 2300000L, 1600000L, 810000L);
    public static final ImmutableList<Long> q = ImmutableList.of(1400000L, 990000L, 730000L, 510000L, 230000L);
    public static final ImmutableList<Long> r = ImmutableList.of(2100000L, 1400000L, 1000000L, 890000L, 640000L);
    public static final ImmutableList<Long> s = ImmutableList.of(2600000L, 1700000L, 1300000L, 1000000L, 700000L);
    public static final ImmutableList<Long> t = ImmutableList.of(5700000L, 3700000L, 2300000L, 1700000L, 990000L);
    public static final ImmutableList<Long> u = ImmutableList.of(2800000L, 1800000L, 1400000L, 1100000L, 870000L);

    @Nullable
    public static x31 v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableMap<Integer, Long> f21865a;
    public final dp.a.C1184a b;
    public final we5 c;
    public final ed0 d;
    public final boolean e;
    public int f;
    public long g;
    public long h;
    public int i;
    public long j;
    public long k;
    public long l;
    public long m;
    public boolean n;
    public int o;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Context f21866a;
        public Map<Integer, Long> b;
        public int c;
        public ed0 d;
        public boolean e;

        public b(Context context) {
            this.f21866a = context == null ? null : context.getApplicationContext();
            this.b = b(g86.M(context));
            this.c = 2000;
            this.d = ed0.f17276a;
            this.e = true;
        }

        public static Map<Integer, Long> b(String str) {
            int[] iArrI = x31.i(str);
            HashMap map = new HashMap(8);
            map.put(0, 1000000L);
            ImmutableList<Long> immutableList = x31.p;
            map.put(2, immutableList.get(iArrI[0]));
            map.put(3, x31.q.get(iArrI[1]));
            map.put(4, x31.r.get(iArrI[2]));
            map.put(5, x31.s.get(iArrI[3]));
            map.put(10, x31.t.get(iArrI[4]));
            map.put(9, x31.u.get(iArrI[5]));
            map.put(7, immutableList.get(iArrI[0]));
            return map;
        }

        public x31 a() {
            return new x31(this.f21866a, this.b, this.c, this.d, this.e);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int[] i(String str) {
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case 2083:
                if (str.equals("AD")) {
                    b2 = 0;
                }
                break;
            case 2084:
                if (str.equals("AE")) {
                    b2 = 1;
                }
                break;
            case 2085:
                if (str.equals("AF")) {
                    b2 = 2;
                }
                break;
            case 2086:
                if (str.equals("AG")) {
                    b2 = 3;
                }
                break;
            case 2088:
                if (str.equals("AI")) {
                    b2 = 4;
                }
                break;
            case 2091:
                if (str.equals("AL")) {
                    b2 = 5;
                }
                break;
            case 2092:
                if (str.equals("AM")) {
                    b2 = 6;
                }
                break;
            case 2094:
                if (str.equals("AO")) {
                    b2 = 7;
                }
                break;
            case 2096:
                if (str.equals("AQ")) {
                    b2 = 8;
                }
                break;
            case 2098:
                if (str.equals("AS")) {
                    b2 = 9;
                }
                break;
            case 2099:
                if (str.equals("AT")) {
                    b2 = 10;
                }
                break;
            case 2100:
                if (str.equals("AU")) {
                    b2 = 11;
                }
                break;
            case 2102:
                if (str.equals("AW")) {
                    b2 = 12;
                }
                break;
            case 2103:
                if (str.equals("AX")) {
                    b2 = dn.k;
                }
                break;
            case 2105:
                if (str.equals("AZ")) {
                    b2 = dn.l;
                }
                break;
            case 2111:
                if (str.equals("BA")) {
                    b2 = 15;
                }
                break;
            case 2112:
                if (str.equals("BB")) {
                    b2 = 16;
                }
                break;
            case 2114:
                if (str.equals(GlobalSetting.BD_SDK_WRAPPER)) {
                    b2 = 17;
                }
                break;
            case 2115:
                if (str.equals("BE")) {
                    b2 = 18;
                }
                break;
            case 2116:
                if (str.equals("BF")) {
                    b2 = 19;
                }
                break;
            case 2117:
                if (str.equals("BG")) {
                    b2 = 20;
                }
                break;
            case 2118:
                if (str.equals("BH")) {
                    b2 = 21;
                }
                break;
            case 2119:
                if (str.equals("BI")) {
                    b2 = 22;
                }
                break;
            case 2120:
                if (str.equals("BJ")) {
                    b2 = 23;
                }
                break;
            case 2122:
                if (str.equals("BL")) {
                    b2 = 24;
                }
                break;
            case 2123:
                if (str.equals("BM")) {
                    b2 = 25;
                }
                break;
            case 2124:
                if (str.equals("BN")) {
                    b2 = 26;
                }
                break;
            case 2125:
                if (str.equals("BO")) {
                    b2 = 27;
                }
                break;
            case 2127:
                if (str.equals("BQ")) {
                    b2 = 28;
                }
                break;
            case 2128:
                if (str.equals("BR")) {
                    b2 = 29;
                }
                break;
            case 2129:
                if (str.equals("BS")) {
                    b2 = 30;
                }
                break;
            case 2130:
                if (str.equals("BT")) {
                    b2 = TELogUtils.DEBUG_LEVEL_V;
                }
                break;
            case 2133:
                if (str.equals("BW")) {
                    b2 = 32;
                }
                break;
            case 2135:
                if (str.equals("BY")) {
                    b2 = 33;
                }
                break;
            case 2136:
                if (str.equals("BZ")) {
                    b2 = 34;
                }
                break;
            case 2142:
                if (str.equals("CA")) {
                    b2 = 35;
                }
                break;
            case 2145:
                if (str.equals("CD")) {
                    b2 = 36;
                }
                break;
            case 2147:
                if (str.equals("CF")) {
                    b2 = 37;
                }
                break;
            case 2148:
                if (str.equals("CG")) {
                    b2 = 38;
                }
                break;
            case 2149:
                if (str.equals("CH")) {
                    b2 = 39;
                }
                break;
            case 2150:
                if (str.equals("CI")) {
                    b2 = 40;
                }
                break;
            case 2152:
                if (str.equals("CK")) {
                    b2 = 41;
                }
                break;
            case 2153:
                if (str.equals("CL")) {
                    b2 = 42;
                }
                break;
            case 2154:
                if (str.equals("CM")) {
                    b2 = 43;
                }
                break;
            case 2155:
                if (str.equals("CN")) {
                    b2 = 44;
                }
                break;
            case 2156:
                if (str.equals("CO")) {
                    b2 = 45;
                }
                break;
            case 2159:
                if (str.equals("CR")) {
                    b2 = 46;
                }
                break;
            case 2162:
                if (str.equals("CU")) {
                    b2 = 47;
                }
                break;
            case 2163:
                if (str.equals("CV")) {
                    b2 = 48;
                }
                break;
            case 2164:
                if (str.equals("CW")) {
                    b2 = 49;
                }
                break;
            case 2165:
                if (str.equals("CX")) {
                    b2 = 50;
                }
                break;
            case 2166:
                if (str.equals("CY")) {
                    b2 = 51;
                }
                break;
            case 2167:
                if (str.equals("CZ")) {
                    b2 = 52;
                }
                break;
            case 2177:
                if (str.equals("DE")) {
                    b2 = 53;
                }
                break;
            case 2182:
                if (str.equals("DJ")) {
                    b2 = 54;
                }
                break;
            case 2183:
                if (str.equals("DK")) {
                    b2 = 55;
                }
                break;
            case 2185:
                if (str.equals("DM")) {
                    b2 = 56;
                }
                break;
            case 2187:
                if (str.equals("DO")) {
                    b2 = 57;
                }
                break;
            case 2198:
                if (str.equals("DZ")) {
                    b2 = 58;
                }
                break;
            case 2206:
                if (str.equals("EC")) {
                    b2 = 59;
                }
                break;
            case 2208:
                if (str.equals("EE")) {
                    b2 = 60;
                }
                break;
            case 2210:
                if (str.equals("EG")) {
                    b2 = Base64.padSymbol;
                }
                break;
            case 2221:
                if (str.equals("ER")) {
                    b2 = 62;
                }
                break;
            case 2222:
                if (str.equals("ES")) {
                    b2 = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case 2223:
                if (str.equals("ET")) {
                    b2 = 64;
                }
                break;
            case 2243:
                if (str.equals("FI")) {
                    b2 = 65;
                }
                break;
            case 2244:
                if (str.equals("FJ")) {
                    b2 = 66;
                }
                break;
            case 2247:
                if (str.equals("FM")) {
                    b2 = 67;
                }
                break;
            case 2249:
                if (str.equals("FO")) {
                    b2 = 68;
                }
                break;
            case 2252:
                if (str.equals("FR")) {
                    b2 = 69;
                }
                break;
            case 2266:
                if (str.equals("GA")) {
                    b2 = 70;
                }
                break;
            case 2267:
                if (str.equals("GB")) {
                    b2 = 71;
                }
                break;
            case 2269:
                if (str.equals("GD")) {
                    b2 = 72;
                }
                break;
            case 2270:
                if (str.equals("GE")) {
                    b2 = 73;
                }
                break;
            case 2271:
                if (str.equals("GF")) {
                    b2 = 74;
                }
                break;
            case 2272:
                if (str.equals("GG")) {
                    b2 = 75;
                }
                break;
            case 2273:
                if (str.equals("GH")) {
                    b2 = 76;
                }
                break;
            case 2274:
                if (str.equals("GI")) {
                    b2 = 77;
                }
                break;
            case 2277:
                if (str.equals("GL")) {
                    b2 = 78;
                }
                break;
            case 2278:
                if (str.equals("GM")) {
                    b2 = 79;
                }
                break;
            case 2279:
                if (str.equals("GN")) {
                    b2 = 80;
                }
                break;
            case 2281:
                if (str.equals("GP")) {
                    b2 = 81;
                }
                break;
            case 2282:
                if (str.equals("GQ")) {
                    b2 = 82;
                }
                break;
            case 2283:
                if (str.equals("GR")) {
                    b2 = 83;
                }
                break;
            case 2285:
                if (str.equals(com.igexin.push.core.b.j)) {
                    b2 = 84;
                }
                break;
            case 2286:
                if (str.equals("GU")) {
                    b2 = 85;
                }
                break;
            case 2288:
                if (str.equals("GW")) {
                    b2 = 86;
                }
                break;
            case 2290:
                if (str.equals("GY")) {
                    b2 = 87;
                }
                break;
            case 2307:
                if (str.equals("HK")) {
                    b2 = 88;
                }
                break;
            case 2310:
                if (str.equals("HN")) {
                    b2 = 89;
                }
                break;
            case 2314:
                if (str.equals("HR")) {
                    b2 = 90;
                }
                break;
            case 2316:
                if (str.equals("HT")) {
                    b2 = 91;
                }
                break;
            case 2317:
                if (str.equals("HU")) {
                    b2 = 92;
                }
                break;
            case 2331:
                if (str.equals(STManager.REGION_OF_ID)) {
                    b2 = 93;
                }
                break;
            case 2332:
                if (str.equals("IE")) {
                    b2 = 94;
                }
                break;
            case 2339:
                if (str.equals("IL")) {
                    b2 = 95;
                }
                break;
            case 2340:
                if (str.equals("IM")) {
                    b2 = 96;
                }
                break;
            case 2341:
                if (str.equals(STManager.REGION_OF_IN)) {
                    b2 = 97;
                }
                break;
            case 2342:
                if (str.equals("IO")) {
                    b2 = 98;
                }
                break;
            case 2344:
                if (str.equals("IQ")) {
                    b2 = 99;
                }
                break;
            case 2345:
                if (str.equals("IR")) {
                    b2 = 100;
                }
                break;
            case 2346:
                if (str.equals("IS")) {
                    b2 = 101;
                }
                break;
            case 2347:
                if (str.equals("IT")) {
                    b2 = 102;
                }
                break;
            case 2363:
                if (str.equals("JE")) {
                    b2 = 103;
                }
                break;
            case 2371:
                if (str.equals("JM")) {
                    b2 = 104;
                }
                break;
            case 2373:
                if (str.equals("JO")) {
                    b2 = 105;
                }
                break;
            case 2374:
                if (str.equals("JP")) {
                    b2 = 106;
                }
                break;
            case 2394:
                if (str.equals("KE")) {
                    b2 = 107;
                }
                break;
            case 2396:
                if (str.equals("KG")) {
                    b2 = 108;
                }
                break;
            case 2397:
                if (str.equals("KH")) {
                    b2 = 109;
                }
                break;
            case 2398:
                if (str.equals("KI")) {
                    b2 = 110;
                }
                break;
            case 2402:
                if (str.equals("KM")) {
                    b2 = 111;
                }
                break;
            case 2403:
                if (str.equals("KN")) {
                    b2 = 112;
                }
                break;
            case 2407:
                if (str.equals("KR")) {
                    b2 = 113;
                }
                break;
            case 2412:
                if (str.equals("KW")) {
                    b2 = 114;
                }
                break;
            case 2414:
                if (str.equals("KY")) {
                    b2 = 115;
                }
                break;
            case 2415:
                if (str.equals("KZ")) {
                    b2 = 116;
                }
                break;
            case 2421:
                if (str.equals("LA")) {
                    b2 = 117;
                }
                break;
            case 2422:
                if (str.equals("LB")) {
                    b2 = 118;
                }
                break;
            case 2423:
                if (str.equals("LC")) {
                    b2 = 119;
                }
                break;
            case 2429:
                if (str.equals("LI")) {
                    b2 = 120;
                }
                break;
            case 2431:
                if (str.equals("LK")) {
                    b2 = 121;
                }
                break;
            case 2438:
                if (str.equals("LR")) {
                    b2 = 122;
                }
                break;
            case 2439:
                if (str.equals("LS")) {
                    b2 = 123;
                }
                break;
            case 2440:
                if (str.equals("LT")) {
                    b2 = 124;
                }
                break;
            case 2441:
                if (str.equals("LU")) {
                    b2 = 125;
                }
                break;
            case 2442:
                if (str.equals("LV")) {
                    b2 = 126;
                }
                break;
            case 2445:
                if (str.equals("LY")) {
                    b2 = ByteCompanionObject.MAX_VALUE;
                }
                break;
            case 2452:
                if (str.equals("MA")) {
                    b2 = ByteCompanionObject.MIN_VALUE;
                }
                break;
            case 2454:
                if (str.equals("MC")) {
                    b2 = 129;
                }
                break;
            case 2455:
                if (str.equals("MD")) {
                    b2 = 130;
                }
                break;
            case 2456:
                if (str.equals("ME")) {
                    b2 = 131;
                }
                break;
            case 2457:
                if (str.equals("MF")) {
                    b2 = 132;
                }
                break;
            case 2458:
                if (str.equals("MG")) {
                    b2 = 133;
                }
                break;
            case 2459:
                if (str.equals("MH")) {
                    b2 = 134;
                }
                break;
            case 2462:
                if (str.equals("MK")) {
                    b2 = 135;
                }
                break;
            case 2463:
                if (str.equals("ML")) {
                    b2 = 136;
                }
                break;
            case 2464:
                if (str.equals("MM")) {
                    b2 = 137;
                }
                break;
            case 2465:
                if (str.equals("MN")) {
                    b2 = 138;
                }
                break;
            case 2466:
                if (str.equals("MO")) {
                    b2 = 139;
                }
                break;
            case 2467:
                if (str.equals("MP")) {
                    b2 = 140;
                }
                break;
            case 2468:
                if (str.equals("MQ")) {
                    b2 = 141;
                }
                break;
            case 2469:
                if (str.equals(ZW2Vz.c)) {
                    b2 = 142;
                }
                break;
            case 2470:
                if (str.equals("MS")) {
                    b2 = 143;
                }
                break;
            case 2471:
                if (str.equals("MT")) {
                    b2 = 144;
                }
                break;
            case 2472:
                if (str.equals("MU")) {
                    b2 = 145;
                }
                break;
            case 2473:
                if (str.equals("MV")) {
                    b2 = 146;
                }
                break;
            case 2474:
                if (str.equals("MW")) {
                    b2 = 147;
                }
                break;
            case 2475:
                if (str.equals("MX")) {
                    b2 = 148;
                }
                break;
            case 2476:
                if (str.equals(STManager.REGION_OF_MY)) {
                    b2 = 149;
                }
                break;
            case 2477:
                if (str.equals("MZ")) {
                    b2 = 150;
                }
                break;
            case 2483:
                if (str.equals("NA")) {
                    b2 = 151;
                }
                break;
            case 2485:
                if (str.equals("NC")) {
                    b2 = 152;
                }
                break;
            case 2487:
                if (str.equals("NE")) {
                    b2 = 153;
                }
                break;
            case 2489:
                if (str.equals("NG")) {
                    b2 = 154;
                }
                break;
            case 2491:
                if (str.equals("NI")) {
                    b2 = 155;
                }
                break;
            case 2494:
                if (str.equals("NL")) {
                    b2 = 156;
                }
                break;
            case 2497:
                if (str.equals("NO")) {
                    b2 = 157;
                }
                break;
            case 2498:
                if (str.equals("NP")) {
                    b2 = 158;
                }
                break;
            case 2500:
                if (str.equals("NR")) {
                    b2 = 159;
                }
                break;
            case 2503:
                if (str.equals("NU")) {
                    b2 = 160;
                }
                break;
            case AVMDLDataLoader.KeyIsEnablePreconnect /* 2508 */:
                if (str.equals("NZ")) {
                    b2 = 161;
                }
                break;
            case 2526:
                if (str.equals("OM")) {
                    b2 = 162;
                }
                break;
            case 2545:
                if (str.equals("PA")) {
                    b2 = 163;
                }
                break;
            case 2549:
                if (str.equals("PE")) {
                    b2 = 164;
                }
                break;
            case 2550:
                if (str.equals("PF")) {
                    b2 = 165;
                }
                break;
            case 2551:
                if (str.equals("PG")) {
                    b2 = 166;
                }
                break;
            case 2552:
                if (str.equals(STManager.REGION_OF_PH)) {
                    b2 = 167;
                }
                break;
            case 2555:
                if (str.equals("PK")) {
                    b2 = 168;
                }
                break;
            case 2556:
                if (str.equals("PL")) {
                    b2 = 169;
                }
                break;
            case 2557:
                if (str.equals("PM")) {
                    b2 = 170;
                }
                break;
            case 2562:
                if (str.equals("PR")) {
                    b2 = 171;
                }
                break;
            case 2563:
                if (str.equals("PS")) {
                    b2 = 172;
                }
                break;
            case 2564:
                if (str.equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                    b2 = 173;
                }
                break;
            case 2567:
                if (str.equals("PW")) {
                    b2 = 174;
                }
                break;
            case 2569:
                if (str.equals("PY")) {
                    b2 = 175;
                }
                break;
            case 2576:
                if (str.equals("QA")) {
                    b2 = 176;
                }
                break;
            case 2611:
                if (str.equals("RE")) {
                    b2 = 177;
                }
                break;
            case 2621:
                if (str.equals("RO")) {
                    b2 = 178;
                }
                break;
            case 2625:
                if (str.equals("RS")) {
                    b2 = 179;
                }
                break;
            case 2627:
                if (str.equals("RU")) {
                    b2 = 180;
                }
                break;
            case 2629:
                if (str.equals("RW")) {
                    b2 = 181;
                }
                break;
            case 2638:
                if (str.equals("SA")) {
                    b2 = 182;
                }
                break;
            case 2639:
                if (str.equals("SB")) {
                    b2 = 183;
                }
                break;
            case 2640:
                if (str.equals("SC")) {
                    b2 = 184;
                }
                break;
            case 2641:
                if (str.equals("SD")) {
                    b2 = 185;
                }
                break;
            case 2642:
                if (str.equals("SE")) {
                    b2 = 186;
                }
                break;
            case 2644:
                if (str.equals("SG")) {
                    b2 = 187;
                }
                break;
            case 2645:
                if (str.equals("SH")) {
                    b2 = 188;
                }
                break;
            case 2646:
                if (str.equals("SI")) {
                    b2 = 189;
                }
                break;
            case 2647:
                if (str.equals("SJ")) {
                    b2 = 190;
                }
                break;
            case 2648:
                if (str.equals("SK")) {
                    b2 = 191;
                }
                break;
            case 2649:
                if (str.equals("SL")) {
                    b2 = 192;
                }
                break;
            case 2650:
                if (str.equals("SM")) {
                    b2 = 193;
                }
                break;
            case 2651:
                if (str.equals("SN")) {
                    b2 = 194;
                }
                break;
            case 2652:
                if (str.equals("SO")) {
                    b2 = 195;
                }
                break;
            case 2655:
                if (str.equals("SR")) {
                    b2 = 196;
                }
                break;
            case 2656:
                if (str.equals("SS")) {
                    b2 = 197;
                }
                break;
            case 2657:
                if (str.equals("ST")) {
                    b2 = 198;
                }
                break;
            case 2659:
                if (str.equals("SV")) {
                    b2 = 199;
                }
                break;
            case 2661:
                if (str.equals("SX")) {
                    b2 = 200;
                }
                break;
            case 2662:
                if (str.equals("SY")) {
                    b2 = 201;
                }
                break;
            case 2663:
                if (str.equals("SZ")) {
                    b2 = 202;
                }
                break;
            case 2671:
                if (str.equals("TC")) {
                    b2 = 203;
                }
                break;
            case 2672:
                if (str.equals("TD")) {
                    b2 = 204;
                }
                break;
            case 2675:
                if (str.equals("TG")) {
                    b2 = 205;
                }
                break;
            case 2676:
                if (str.equals(STManager.REGION_OF_TH)) {
                    b2 = 206;
                }
                break;
            case 2678:
                if (str.equals("TJ")) {
                    b2 = 207;
                }
                break;
            case 2679:
                if (str.equals("TK")) {
                    b2 = 208;
                }
                break;
            case 2680:
                if (str.equals("TL")) {
                    b2 = 209;
                }
                break;
            case 2681:
                if (str.equals("TM")) {
                    b2 = 210;
                }
                break;
            case 2682:
                if (str.equals("TN")) {
                    b2 = 211;
                }
                break;
            case 2683:
                if (str.equals("TO")) {
                    b2 = 212;
                }
                break;
            case 2686:
                if (str.equals("TR")) {
                    b2 = 213;
                }
                break;
            case 2688:
                if (str.equals(GlobalSetting.TT_SDK_WRAPPER)) {
                    b2 = 214;
                }
                break;
            case 2690:
                if (str.equals("TV")) {
                    b2 = 215;
                }
                break;
            case 2691:
                if (str.equals(STManager.REGION_OF_TW)) {
                    b2 = 216;
                }
                break;
            case 2694:
                if (str.equals("TZ")) {
                    b2 = 217;
                }
                break;
            case 2700:
                if (str.equals("UA")) {
                    b2 = 218;
                }
                break;
            case 2706:
                if (str.equals("UG")) {
                    b2 = 219;
                }
                break;
            case 2718:
                if (str.equals("US")) {
                    b2 = 220;
                }
                break;
            case 2724:
                if (str.equals("UY")) {
                    b2 = 221;
                }
                break;
            case 2725:
                if (str.equals("UZ")) {
                    b2 = 222;
                }
                break;
            case 2731:
                if (str.equals("VA")) {
                    b2 = 223;
                }
                break;
            case 2733:
                if (str.equals("VC")) {
                    b2 = 224;
                }
                break;
            case 2735:
                if (str.equals("VE")) {
                    b2 = 225;
                }
                break;
            case 2737:
                if (str.equals("VG")) {
                    b2 = 226;
                }
                break;
            case 2739:
                if (str.equals("VI")) {
                    b2 = 227;
                }
                break;
            case 2744:
                if (str.equals(STManager.REGION_OF_VN)) {
                    b2 = 228;
                }
                break;
            case 2751:
                if (str.equals("VU")) {
                    b2 = 229;
                }
                break;
            case 2767:
                if (str.equals("WF")) {
                    b2 = 230;
                }
                break;
            case 2780:
                if (str.equals("WS")) {
                    b2 = 231;
                }
                break;
            case 2803:
                if (str.equals("XK")) {
                    b2 = 232;
                }
                break;
            case 2828:
                if (str.equals("YE")) {
                    b2 = 233;
                }
                break;
            case 2843:
                if (str.equals("YT")) {
                    b2 = 234;
                }
                break;
            case 2855:
                if (str.equals("ZA")) {
                    b2 = 235;
                }
                break;
            case 2867:
                if (str.equals("ZM")) {
                    b2 = 236;
                }
                break;
            case 2877:
                if (str.equals("ZW")) {
                    b2 = 237;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 49:
                return new int[]{2, 2, 0, 0, 2, 2};
            case 1:
                return new int[]{1, 4, 3, 4, 4, 2};
            case 2:
            case 166:
                return new int[]{4, 3, 3, 3, 2, 2};
            case 3:
                return new int[]{2, 4, 3, 4, 2, 2};
            case 4:
            case 16:
            case 25:
            case 28:
            case 56:
            case 68:
                return new int[]{0, 2, 0, 0, 2, 2};
            case 5:
                return new int[]{1, 1, 1, 3, 2, 2};
            case 6:
                return new int[]{2, 3, 2, 3, 2, 2};
            case 7:
                return new int[]{4, 4, 4, 3, 2, 2};
            case 8:
            case 62:
            case 188:
                return new int[]{4, 2, 2, 2, 2, 2};
            case 9:
                return new int[]{2, 2, 3, 3, 2, 2};
            case 10:
                return new int[]{1, 2, 1, 4, 1, 4};
            case 11:
                return new int[]{0, 2, 1, 1, 3, 0};
            case 12:
            case 85:
                return new int[]{1, 2, 4, 4, 2, 2};
            case 13:
            case 50:
            case 120:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID /* 140 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE /* 143 */:
            case 170:
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT /* 193 */:
            case 223:
                return new int[]{0, 2, 2, 2, 2, 2};
            case 14:
            case 19:
            case 58:
                return new int[]{3, 3, 4, 4, 2, 2};
            case 15:
            case 94:
                return new int[]{1, 1, 1, 1, 2, 2};
            case 17:
            case 116:
                return new int[]{2, 1, 2, 2, 2, 2};
            case 18:
                return new int[]{0, 1, 4, 4, 3, 2};
            case 20:
            case 63:
            case 83:
            case 189:
                return new int[]{0, 0, 0, 0, 1, 2};
            case 21:
                return new int[]{1, 3, 1, 4, 4, 2};
            case 22:
            case 91:
            case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START /* 133 */:
            case 153:
            case 204:
            case 225:
            case 233:
                return new int[]{4, 4, 4, 4, 2, 2};
            case 23:
                return new int[]{4, 4, 2, 3, 2, 2};
            case 24:
            case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA /* 132 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED /* 175 */:
                return new int[]{1, 2, 2, 2, 2, 2};
            case 26:
                return new int[]{3, 2, 0, 1, 2, 2};
            case 27:
                return new int[]{1, 2, 3, 2, 2, 2};
            case 29:
                return new int[]{1, 1, 2, 1, 1, 0};
            case 30:
            case 118:
                return new int[]{3, 2, 1, 2, 2, 2};
            case 31:
            case 150:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR /* 231 */:
                return new int[]{3, 1, 2, 1, 2, 2};
            case 32:
                return new int[]{3, 2, 1, 0, 2, 2};
            case 33:
                return new int[]{1, 1, 2, 3, 2, 2};
            case 34:
            case 41:
                return new int[]{2, 2, 2, 1, 2, 2};
            case 35:
                return new int[]{0, 2, 3, 3, 3, 3};
            case 36:
            case 111:
                return new int[]{4, 3, 3, 2, 2, 2};
            case 37:
            case MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND /* 183 */:
                return new int[]{4, 2, 4, 2, 2, 2};
            case 38:
            case 76:
                return new int[]{3, 3, 3, 3, 2, 2};
            case 39:
                return new int[]{0, 0, 0, 0, 0, 3};
            case 40:
            case 61:
                return new int[]{3, 4, 3, 3, 2, 2};
            case 42:
                return new int[]{1, 1, 2, 1, 3, 2};
            case 43:
                return new int[]{4, 3, 3, 4, 2, 2};
            case 44:
                return new int[]{2, 0, 4, 3, 3, 1};
            case 45:
                return new int[]{2, 3, 4, 2, 2, 2};
            case 46:
                return new int[]{2, 4, 4, 4, 2, 2};
            case 47:
            case 110:
                return new int[]{4, 2, 4, 3, 2, 2};
            case 48:
                return new int[]{2, 3, 0, 1, 2, 2};
            case 51:
            case 90:
            case 126:
                return new int[]{1, 0, 0, 0, 0, 2};
            case 52:
                return new int[]{0, 0, 2, 0, 1, 2};
            case 53:
                return new int[]{0, 1, 3, 2, 2, 2};
            case 54:
            case 201:
            case 207:
                return new int[]{4, 3, 4, 4, 2, 2};
            case 55:
            case 60:
            case 92:
            case 124:
            case 144:
                return new int[]{0, 0, 0, 0, 0, 2};
            case 57:
                return new int[]{3, 4, 4, 4, 4, 2};
            case 59:
                return new int[]{1, 3, 2, 1, 2, 2};
            case 64:
            case MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY /* 194 */:
                return new int[]{4, 4, 3, 2, 2, 2};
            case 65:
                return new int[]{0, 0, 0, 2, 0, 2};
            case 66:
                return new int[]{3, 1, 2, 3, 2, 2};
            case 67:
                return new int[]{4, 2, 3, 0, 2, 2};
            case 69:
                return new int[]{1, 1, 2, 1, 1, 2};
            case 70:
            case 205:
                return new int[]{3, 4, 1, 0, 2, 2};
            case 71:
                return new int[]{0, 1, 1, 2, 1, 2};
            case 72:
            case 112:
            case 115:
            case 119:
            case 200:
            case 224:
                return new int[]{1, 2, 0, 0, 2, 2};
            case 73:
                return new int[]{1, 0, 0, 2, 2, 2};
            case 74:
            case 168:
            case 192:
                return new int[]{3, 2, 3, 3, 2, 2};
            case 75:
                return new int[]{0, 2, 1, 0, 2, 2};
            case 77:
            case 103:
                return new int[]{1, 2, 0, 1, 2, 2};
            case 78:
            case 208:
                return new int[]{2, 2, 2, 4, 2, 2};
            case 79:
                return new int[]{4, 3, 2, 4, 2, 2};
            case 80:
                return new int[]{4, 4, 4, 2, 2, 2};
            case 81:
                return new int[]{3, 1, 1, 3, 2, 2};
            case 82:
                return new int[]{4, 4, 3, 3, 2, 2};
            case 84:
                return new int[]{2, 2, 2, 1, 1, 2};
            case 86:
                return new int[]{4, 4, 2, 2, 2, 2};
            case 87:
                return new int[]{3, 0, 1, 1, 2, 2};
            case 88:
                return new int[]{0, 1, 1, 3, 2, 0};
            case 89:
                return new int[]{3, 3, 2, 2, 2, 2};
            case 93:
                return new int[]{3, 1, 1, 2, 3, 2};
            case 95:
                return new int[]{1, 2, 2, 3, 4, 2};
            case 96:
                return new int[]{0, 2, 0, 1, 2, 2};
            case 97:
                return new int[]{1, 1, 2, 1, 2, 1};
            case 98:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY /* 215 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT /* 230 */:
                return new int[]{4, 2, 2, 4, 2, 2};
            case 99:
            case MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME /* 190 */:
                return new int[]{3, 2, 2, 2, 2, 2};
            case 100:
                return new int[]{4, 2, 3, 3, 4, 2};
            case 101:
                return new int[]{0, 0, 1, 0, 0, 2};
            case 102:
                return new int[]{0, 0, 1, 1, 1, 2};
            case 104:
                return new int[]{2, 4, 2, 1, 2, 2};
            case 105:
                return new int[]{2, 0, 1, 1, 2, 2};
            case 106:
                return new int[]{0, 3, 3, 3, 4, 4};
            case 107:
                return new int[]{3, 2, 2, 1, 2, 2};
            case 108:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID /* 141 */:
                return new int[]{2, 1, 1, 2, 2, 2};
            case 109:
                return new int[]{1, 0, 4, 2, 2, 2};
            case 113:
                return new int[]{0, 2, 2, 4, 4, 4};
            case 114:
                return new int[]{1, 0, 1, 0, 0, 2};
            case 117:
                return new int[]{1, 2, 1, 3, 2, 2};
            case 121:
                return new int[]{3, 2, 3, 4, 4, 2};
            case 122:
                return new int[]{3, 4, 3, 4, 2, 2};
            case 123:
            case 219:
                return new int[]{3, 3, 3, 2, 2, 2};
            case 125:
                return new int[]{1, 1, 4, 2, 0, 2};
            case 127:
            case 212:
            case 237:
                return new int[]{3, 2, 4, 3, 2, 2};
            case 128:
                return new int[]{3, 3, 2, 1, 2, 2};
            case 129:
                return new int[]{0, 2, 2, 0, 2, 2};
            case 130:
                return new int[]{1, 0, 0, 0, 2, 2};
            case 131:
                return new int[]{2, 0, 0, 1, 1, 2};
            case 134:
                return new int[]{4, 2, 1, 3, 2, 2};
            case 135:
                return new int[]{2, 0, 0, 1, 3, 2};
            case 136:
            case 217:
                return new int[]{3, 4, 2, 2, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME /* 137 */:
                return new int[]{2, 2, 2, 3, 4, 2};
            case 138:
                return new int[]{2, 0, 1, 2, 2, 2};
            case 139:
                return new int[]{0, 2, 4, 4, 4, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO /* 142 */:
                return new int[]{4, 2, 3, 4, 2, 2};
            case 145:
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID /* 182 */:
                return new int[]{3, 1, 1, 2, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK /* 146 */:
                return new int[]{3, 4, 1, 3, 3, 2};
            case 147:
                return new int[]{4, 2, 3, 3, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK /* 148 */:
                return new int[]{3, 4, 4, 4, 2, 2};
            case 149:
                return new int[]{1, 0, 4, 1, 2, 2};
            case 151:
                return new int[]{3, 4, 3, 2, 2, 2};
            case 152:
                return new int[]{3, 2, 3, 4, 2, 2};
            case 154:
                return new int[]{3, 4, 2, 1, 2, 2};
            case 155:
                return new int[]{2, 3, 4, 3, 2, 2};
            case 156:
                return new int[]{0, 2, 3, 3, 0, 4};
            case 157:
                return new int[]{0, 1, 2, 1, 1, 2};
            case 158:
                return new int[]{2, 1, 4, 3, 2, 2};
            case 159:
                return new int[]{4, 0, 3, 2, 2, 2};
            case 160:
                return new int[]{4, 2, 2, 1, 2, 2};
            case 161:
                return new int[]{1, 0, 2, 2, 4, 2};
            case 162:
                return new int[]{2, 3, 1, 3, 4, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME /* 163 */:
                return new int[]{2, 3, 3, 3, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME /* 164 */:
                return new int[]{1, 2, 4, 4, 3, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION /* 165 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH /* 199 */:
                return new int[]{2, 3, 3, 1, 2, 2};
            case 167:
                return new int[]{2, 1, 3, 2, 2, 0};
            case 169:
                return new int[]{2, 1, 2, 2, 4, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE /* 171 */:
                return new int[]{2, 0, 2, 0, 2, 1};
            case 172:
                return new int[]{3, 4, 1, 4, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT /* 173 */:
                return new int[]{1, 0, 0, 0, 1, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE /* 174 */:
                return new int[]{2, 2, 4, 2, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD /* 176 */:
                return new int[]{1, 4, 4, 4, 4, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD /* 177 */:
                return new int[]{1, 2, 2, 3, 1, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD /* 178 */:
                return new int[]{0, 0, 1, 2, 1, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT /* 179 */:
                return new int[]{2, 0, 0, 0, 2, 2};
            case EffectConstants.ROTATION_DEGREES_180 /* 180 */:
                return new int[]{1, 0, 0, 0, 3, 3};
            case MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC /* 181 */:
                return new int[]{3, 3, 1, 0, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO /* 184 */:
                return new int[]{4, 3, 1, 1, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY /* 185 */:
                return new int[]{4, 3, 4, 2, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS /* 186 */:
                return new int[]{0, 1, 1, 1, 0, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME /* 187 */:
                return new int[]{2, 3, 3, 3, 3, 3};
            case MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED /* 191 */:
                return new int[]{1, 1, 1, 1, 3, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO /* 195 */:
                return new int[]{3, 2, 2, 4, 4, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE /* 196 */:
                return new int[]{2, 4, 3, 0, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY /* 197 */:
            case 210:
                return new int[]{4, 2, 2, 3, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS /* 198 */:
                return new int[]{2, 2, 1, 2, 2, 2};
            case 202:
                return new int[]{4, 4, 3, 4, 2, 2};
            case 203:
                return new int[]{2, 2, 1, 3, 2, 2};
            case 206:
                return new int[]{0, 1, 2, 1, 2, 2};
            case 209:
                return new int[]{4, 2, 4, 4, 2, 2};
            case 211:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR /* 221 */:
                return new int[]{2, 1, 1, 1, 2, 2};
            case 213:
                return new int[]{1, 0, 0, 1, 3, 2};
            case 214:
                return new int[]{1, 4, 0, 0, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF /* 216 */:
                return new int[]{0, 2, 0, 0, 0, 0};
            case 218:
                return new int[]{0, 1, 1, 2, 4, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM /* 220 */:
                return new int[]{1, 1, 4, 1, 3, 1};
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR /* 222 */:
                return new int[]{2, 2, 3, 4, 3, 2};
            case 226:
                return new int[]{2, 2, 0, 1, 2, 2};
            case 227:
                return new int[]{0, 2, 1, 2, 2, 2};
            case 228:
                return new int[]{0, 0, 1, 2, 2, 1};
            case 229:
                return new int[]{4, 3, 3, 1, 2, 2};
            case 232:
                return new int[]{1, 2, 1, 1, 2, 2};
            case 234:
                return new int[]{2, 3, 3, 4, 2, 2};
            case 235:
                return new int[]{2, 3, 2, 1, 2, 2};
            case 236:
                return new int[]{4, 4, 4, 3, 3, 2};
            default:
                return new int[]{2, 2, 2, 2, 2, 2};
        }
    }

    public static synchronized x31 k(Context context) {
        if (v == null) {
            v = new b(context).a();
        }
        return v;
    }

    public static boolean l(com.google.android.exoplayer2.upstream.b bVar, boolean z) {
        return z && !bVar.d(8);
    }

    @Override // defpackage.u06
    public synchronized void a(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z) {
        if (l(bVar, z)) {
            vh.g(this.f > 0);
            long jElapsedRealtime = this.d.elapsedRealtime();
            int i = (int) (jElapsedRealtime - this.g);
            this.j += (long) i;
            long j = this.k;
            long j2 = this.h;
            this.k = j + j2;
            if (i > 0) {
                this.c.c((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                if (this.j >= 2000 || this.k >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.l = (long) this.c.f(0.5f);
                }
                m(i, this.h, this.l);
                this.g = jElapsedRealtime;
                this.h = 0L;
            }
            this.f--;
        }
    }

    @Override // defpackage.u06
    public synchronized void b(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z, int i) {
        if (l(bVar, z)) {
            this.h += (long) i;
        }
    }

    @Override // defpackage.u06
    public synchronized void c(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z) {
        if (l(bVar, z)) {
            if (this.f == 0) {
                this.g = this.d.elapsedRealtime();
            }
            this.f++;
        }
    }

    @Override // defpackage.dp
    public void d(dp.a aVar) {
        this.b.e(aVar);
    }

    @Override // defpackage.dp
    public void e(Handler handler, dp.a aVar) {
        vh.e(handler);
        vh.e(aVar);
        this.b.b(handler, aVar);
    }

    @Override // defpackage.dp
    public synchronized long getBitrateEstimate() {
        return this.l;
    }

    @Override // defpackage.dp
    public /* synthetic */ long getTimeToFirstByteEstimateUs() {
        return ap.a(this);
    }

    public final long j(int i) {
        Long l = this.f21865a.get(Integer.valueOf(i));
        if (l == null) {
            l = this.f21865a.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    public final void m(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.m) {
            return;
        }
        this.m = j2;
        this.b.c(i, j, j2);
    }

    public final synchronized void n(int i) {
        int i2 = this.i;
        if (i2 == 0 || this.e) {
            if (this.n) {
                i = this.o;
            }
            if (i2 == i) {
                return;
            }
            this.i = i;
            if (i != 1 && i != 0 && i != 8) {
                this.l = j(i);
                long jElapsedRealtime = this.d.elapsedRealtime();
                m(this.f > 0 ? (int) (jElapsedRealtime - this.g) : 0, this.h, this.l);
                this.g = jElapsedRealtime;
                this.h = 0L;
                this.k = 0L;
                this.j = 0L;
                this.c.i();
            }
        }
    }

    public x31(@Nullable Context context, Map<Integer, Long> map, int i, ed0 ed0Var, boolean z) {
        this.f21865a = ImmutableMap.copyOf((Map) map);
        this.b = new dp.a.C1184a();
        this.c = new we5(i);
        this.d = ed0Var;
        this.e = z;
        if (context == null) {
            this.i = 0;
            this.l = j(0);
            return;
        }
        ww3 ww3VarD = ww3.d(context);
        int iF = ww3VarD.f();
        this.i = iF;
        this.l = j(iF);
        ww3VarD.i(new ww3.c() { // from class: v31
            @Override // ww3.c
            public final void onNetworkTypeChanged(int i2) {
                this.f21341a.n(i2);
            }
        });
    }

    @Override // defpackage.dp
    public u06 getTransferListener() {
        return this;
    }

    @Override // defpackage.u06
    public void f(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z) {
    }
}
