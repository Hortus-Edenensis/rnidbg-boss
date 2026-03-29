package defpackage;

import android.content.SharedPreferences;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.paidservices.superexpose.bean.FreTimeCount;
import com.zenmen.palmchat.paidservices.superexpose.bean.Fredata;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1953a = false;
    public static Fredata b;

    public static boolean a(int i) {
        ArrayList<Integer> arrayList;
        int i2;
        long j;
        String str;
        String str2 = "super_dialog_pre_1_alltime_done";
        try {
            LogUtil.d("SuperExpose", "checkNeedShowBuyDialog type " + i);
            Fredata fredata = b;
            if (fredata != null && (arrayList = fredata.when) != null && arrayList.contains(Integer.valueOf(i))) {
                int i3 = b.interval;
                SharedPreferences sharedPreferences = c.b().getSharedPreferences("super_dialog_pre_name", 0);
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j2 = jCurrentTimeMillis - sharedPreferences.getLong("super_dialog_pre_last_show", jCurrentTimeMillis);
                boolean z = sharedPreferences.getBoolean("super_dialog_pre_1_alltime_done", false);
                LogUtil.d("SuperExpose", "checkNeedShowBuyDialog curTime " + jCurrentTimeMillis + " interval " + i3 + " config1Done " + z);
                ArrayList<FreTimeCount> arrayList2 = b.preTiming;
                if (arrayList2 == null || arrayList2.size() <= 0 || z) {
                    i2 = i3;
                    j = 0;
                } else {
                    c(jCurrentTimeMillis);
                    int size = b.preTiming.size();
                    long j3 = jCurrentTimeMillis - sharedPreferences.getLong("super_dialog_pre_time_1_start", jCurrentTimeMillis);
                    int i4 = 0;
                    long j4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            str = str2;
                            i2 = i3;
                            i4 = -1;
                            break;
                        }
                        i2 = i3;
                        long j5 = j4 + ((long) (b.preTiming.get(i4).time * 60 * 60 * 1000));
                        StringBuilder sb = new StringBuilder();
                        str = str2;
                        sb.append("checkNeedShowBuyDialog  allowAllTimeHour1 ");
                        sb.append(j5);
                        LogUtil.d("SuperExpose", sb.toString());
                        if (j3 <= j5) {
                            LogUtil.d("SuperExpose", "checkNeedShowBuyDialog find  curCount success " + i4 + " allowAllTimeHour " + j5);
                            j4 = j5;
                            break;
                        }
                        i4++;
                        j4 = j5;
                        i3 = i2;
                        str2 = str;
                    }
                    String str3 = "super_dialog_show_count_1_" + i4;
                    LogUtil.d("SuperExpose", "checkNeedShowBuyDialog showCountKey " + str3);
                    if (i4 >= 0 && i4 < size) {
                        int i5 = b.preTiming.get(i4).count;
                        int i6 = sharedPreferences.getInt(str3, 0);
                        LogUtil.d("SuperExpose", "checkNeedShowBuyDialog allowCount " + i5 + " lastShowCount " + i6);
                        if (i6 >= i5) {
                            LogUtil.d("SuperExpose", "checkNeedShowBuyDialog return false preTiming not allow curCount " + i4);
                            return false;
                        }
                        if (j2 < i2 * 60 * 1000 && j2 != 0) {
                            LogUtil.d("SuperExpose", "checkNeedShowBuyDialog return false interval time not allow curCount " + i4);
                            return false;
                        }
                        int i7 = i6 + 1;
                        sharedPreferences.edit().putInt(str3, i7).apply();
                        sharedPreferences.edit().putLong("super_dialog_pre_last_show", jCurrentTimeMillis).apply();
                        LogUtil.d("SuperExpose", "checkNeedShowBuyDialog return true curTime " + jCurrentTimeMillis + " showCountKey " + str3 + " count " + i7);
                        return true;
                    }
                    if (j3 > j4) {
                        LogUtil.d("SuperExpose", "checkNeedShowBuyDialog curTime > allowAllTimeHour1 配置1判断完成");
                        sharedPreferences.edit().putBoolean(str, true).apply();
                    }
                    j = j4;
                }
                if (b.timing != null) {
                    d(jCurrentTimeMillis);
                    long j6 = jCurrentTimeMillis - sharedPreferences.getLong("super_dialog_pre_time_2_start", jCurrentTimeMillis);
                    LogUtil.d("SuperExpose", "checkNeedShowBuyDialog timing2 duration2 " + j6 + " allowAllTimeHour1 " + j);
                    int i8 = b.timing.time;
                    int i9 = (int) (j6 / (((i8 * 1000.0f) * 60.0f) * 60.0f));
                    String str4 = "super_dialog_show_count_2_" + i9;
                    int i10 = sharedPreferences.getInt(str4, 0);
                    int i11 = b.timing.count;
                    LogUtil.d("SuperExpose", "checkNeedShowBuyDialog timing2 timeGap " + i8 + " curCount " + i9 + " showCountKey " + str4 + " lastShowCount " + i10 + " allowCount " + i11);
                    if (i10 < i11 && (j2 >= i2 * 60 * 1000 || j2 == 0)) {
                        int i12 = i10 + 1;
                        sharedPreferences.edit().putInt(str4, i12).apply();
                        sharedPreferences.edit().putLong("super_dialog_pre_last_show", jCurrentTimeMillis).apply();
                        LogUtil.d("SuperExpose", "checkNeedShowBuyDialog return true timing2 " + jCurrentTimeMillis + " showCountKey " + str4 + " count " + i12);
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            LogUtil.d("SuperExpose", "checkNeedShowBuyDialog Exception e:" + e.toString());
        }
        LogUtil.d("SuperExpose", "checkNeedShowBuyDialog return false");
        return false;
    }

    public static void b() {
        if (f1953a) {
            Fredata fredata = new Fredata();
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(1);
            arrayList.add(2);
            ArrayList<FreTimeCount> arrayList2 = new ArrayList<>();
            FreTimeCount freTimeCount = new FreTimeCount();
            freTimeCount.time = 1;
            freTimeCount.count = 3;
            arrayList2.add(freTimeCount);
            FreTimeCount freTimeCount2 = new FreTimeCount();
            freTimeCount2.time = 1;
            freTimeCount2.count = 1;
            arrayList2.add(freTimeCount2);
            FreTimeCount freTimeCount3 = new FreTimeCount();
            freTimeCount3.time = 1;
            freTimeCount3.count = 1;
            fredata.when = arrayList;
            fredata.preTiming = arrayList2;
            fredata.timing = freTimeCount3;
            fredata.interval = 1;
            e(fredata);
            LogUtil.d("SuperExpose", "checkNeedShowBuyDialog fredata " + fredata);
        }
    }

    public static void c(long j) {
        if (b != null) {
            SharedPreferences sharedPreferences = c.b().getSharedPreferences("super_dialog_pre_name", 0);
            ArrayList<FreTimeCount> arrayList = b.preTiming;
            if (arrayList == null || arrayList.size() <= 0 || sharedPreferences.getLong("super_dialog_pre_time_1_start", -1L) >= 0) {
                return;
            }
            sharedPreferences.edit().putLong("super_dialog_pre_time_1_start", j).apply();
        }
    }

    public static void d(long j) {
        if (b != null) {
            SharedPreferences sharedPreferences = c.b().getSharedPreferences("super_dialog_pre_name", 0);
            if (b.timing == null || sharedPreferences.getLong("super_dialog_pre_time_2_start", -1L) >= 0) {
                return;
            }
            sharedPreferences.edit().putLong("super_dialog_pre_time_2_start", j).apply();
        }
    }

    public static void e(Fredata fredata) {
        b = fredata;
    }
}
