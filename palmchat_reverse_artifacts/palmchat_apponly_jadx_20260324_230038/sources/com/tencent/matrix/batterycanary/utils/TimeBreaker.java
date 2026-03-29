package com.tencent.matrix.batterycanary.utils;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class TimeBreaker {

    /* JADX INFO: compiled from: SearchBox */
    public static final class StatRecord {
        long millis;
        long weight;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class TimePortions {
        public long totalUptime;
        public List<Portion> portions = Collections.emptyList();
        private boolean mIsValid = true;

        /* JADX INFO: compiled from: SearchBox */
        public static final class Portion {
            public final String key;
            public final int ratio;
            public long totalStatMillis = 0;

            public Portion(String str, int i) {
                this.key = str;
                this.ratio = i;
            }
        }

        public static TimePortions ofInvalid() {
            TimePortions timePortions = new TimePortions();
            timePortions.mIsValid = false;
            return timePortions;
        }

        public int getRatio(String str) {
            for (Portion portion : this.portions) {
                String str2 = portion.key;
                if (str2 != null && str2.equals(str)) {
                    return portion.ratio;
                }
            }
            return 0;
        }

        public boolean isValid() {
            return this.mIsValid;
        }

        @Nullable
        public Portion top1() {
            if (this.portions.size() >= 1) {
                return this.portions.get(0);
            }
            return null;
        }

        @Nullable
        public Portion top2() {
            if (this.portions.size() >= 2) {
                return this.portions.get(1);
            }
            return null;
        }
    }

    public static TimePortions configurePortions(List<? extends Stamp> list, long j) {
        return configurePortions(list, j, 10L, new Stamp.Stamper() { // from class: com.tencent.matrix.batterycanary.utils.TimeBreaker.1
            @Override // com.tencent.matrix.batterycanary.utils.TimeBreaker.Stamp.Stamper
            public Stamp stamp(String str) {
                return new Stamp(str);
            }
        });
    }

    public static int configureRatio(long j, long j2) {
        long jRound = Math.round((j / j2) * 100.0d);
        if (jRound >= 100) {
            return 100;
        }
        if (jRound <= 0) {
            return 0;
        }
        return (int) jRound;
    }

    public static void gcList(List<?> list) {
        int size;
        int size2;
        int i;
        if (list != null && (size2 = (size = list.size()) / 2) < size - 1) {
            list.subList(size2, i).clear();
        }
    }

    public static TimePortions configurePortions(List<? extends Stamp> list, long j, long j2, Stamp.Stamper stamper) {
        long j3;
        ArrayList<Stamp> arrayList = new ArrayList(list);
        if (!arrayList.isEmpty()) {
            Stamp stamp = stamper.stamp("CURR_STAMP");
            if (stamp.upTime - ((Stamp) arrayList.get(0)).upTime > j2) {
                arrayList.add(0, stamp);
            }
        }
        HashMap map = new HashMap();
        if (j > 0) {
            Iterator it = arrayList.iterator();
            long j4 = Long.MIN_VALUE;
            long j5 = Long.MIN_VALUE;
            j3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Stamp stamp2 = (Stamp) it.next();
                if (j4 != Long.MIN_VALUE) {
                    long j6 = stamp2.upTime;
                    if (j4 < j6) {
                        break;
                    }
                    long j7 = j4 - j6;
                    long j8 = j3 + j7;
                    if (j8 >= j) {
                        long j9 = j - j3;
                        j3 += j9;
                        StatRecord statRecord = (StatRecord) map.get(stamp2.key);
                        if (statRecord == null) {
                            statRecord = new StatRecord();
                            map.put(stamp2.key, statRecord);
                        }
                        statRecord.weight += j9;
                        statRecord.millis = (long) (statRecord.millis + ((j5 - stamp2.statMillis) * (j9 / j7)));
                    } else {
                        StatRecord statRecord2 = (StatRecord) map.get(stamp2.key);
                        if (statRecord2 == null) {
                            statRecord2 = new StatRecord();
                            map.put(stamp2.key, statRecord2);
                        }
                        statRecord2.weight += j7;
                        statRecord2.millis += j5 - stamp2.statMillis;
                        j3 = j8;
                    }
                }
                j4 = stamp2.upTime;
                j5 = stamp2.statMillis;
            }
        } else {
            j3 = 0;
            long j10 = Long.MIN_VALUE;
            long j11 = Long.MIN_VALUE;
            for (Stamp stamp3 : arrayList) {
                if (j10 != Long.MIN_VALUE) {
                    long j12 = stamp3.upTime;
                    if (j10 < j12) {
                        break;
                    }
                    long j13 = j10 - j12;
                    j3 += j13;
                    StatRecord statRecord3 = (StatRecord) map.get(stamp3.key);
                    if (statRecord3 == null) {
                        statRecord3 = new StatRecord();
                        map.put(stamp3.key, statRecord3);
                    }
                    statRecord3.weight += j13;
                    statRecord3.millis += j11 - stamp3.statMillis;
                }
                j10 = stamp3.upTime;
                j11 = stamp3.statMillis;
            }
        }
        TimePortions timePortions = new TimePortions();
        if (j3 <= 0) {
            timePortions.mIsValid = false;
        } else {
            if (j > j3) {
                timePortions.mIsValid = false;
            }
            timePortions.totalUptime = j3;
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                StatRecord statRecord4 = (StatRecord) entry.getValue();
                TimePortions.Portion portion = new TimePortions.Portion(str, configureRatio(statRecord4.weight, j3));
                portion.totalStatMillis = statRecord4.millis;
                arrayList2.add(portion);
            }
            Collections.sort(arrayList2, new Comparator<TimePortions.Portion>() { // from class: com.tencent.matrix.batterycanary.utils.TimeBreaker.2
                @Override // java.util.Comparator
                public int compare(TimePortions.Portion portion2, TimePortions.Portion portion3) {
                    long j14 = portion2.ratio - portion3.ratio;
                    if (j14 == 0) {
                        return 0;
                    }
                    return j14 > 0 ? -1 : 1;
                }
            });
            timePortions.portions = arrayList2;
        }
        return timePortions;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Stamp {
        public final String key;
        public final long statMillis;
        public final long upTime;

        /* JADX INFO: compiled from: SearchBox */
        public interface Stamper {
            Stamp stamp(String str);
        }

        public Stamp(String str) {
            this.key = str;
            this.upTime = SystemClock.uptimeMillis();
            this.statMillis = System.currentTimeMillis();
        }

        public Stamp(String str, long j) {
            this.key = str;
            this.upTime = j;
            this.statMillis = System.currentTimeMillis();
        }
    }
}
