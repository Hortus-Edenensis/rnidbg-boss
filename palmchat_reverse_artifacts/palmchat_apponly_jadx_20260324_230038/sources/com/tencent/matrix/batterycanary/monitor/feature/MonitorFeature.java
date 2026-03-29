package com.tencent.matrix.batterycanary.monitor.feature;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface MonitorFeature {
    void configure(BatteryMonitorCore batteryMonitorCore);

    void onBackgroundCheck(long j);

    void onForeground(boolean z);

    void onTurnOff();

    void onTurnOn();

    int weight();

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class Snapshot<RECORD extends Snapshot> {
        public boolean isDelta = false;
        private boolean mIsValid = true;
        public final long time = getTimeStamps();

        /* JADX INFO: compiled from: SearchBox */
        public static abstract class Delta<RECORD extends Snapshot> {
            public final RECORD bgn;
            public final RECORD dlt;
            public final long during;
            public final RECORD end;

            public Delta(RECORD record, RECORD record2) {
                this.bgn = record;
                this.end = record2;
                this.during = record2.time - record.time;
                RECORD record3 = (RECORD) computeDelta();
                this.dlt = record3;
                record3.isDelta = true;
            }

            public abstract RECORD computeDelta();

            public boolean isValid() {
                return this.bgn.isValid() && this.end.isValid();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public interface Differ<ENTRY extends Entry> {

            /* JADX INFO: compiled from: SearchBox */
            public static class BeanDiffer<BEAN> implements Differ<Entry.BeanEntry<BEAN>> {
                static final BeanDiffer sGlobal = new BeanDiffer();

                @NonNull
                public static <BEAN> Entry.BeanEntry<BEAN> globalDiff(@NonNull Entry.BeanEntry<BEAN> beanEntry, @NonNull Entry.BeanEntry<BEAN> beanEntry2) {
                    return sGlobal.diff((Entry.BeanEntry) beanEntry, (Entry.BeanEntry) beanEntry2);
                }

                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Differ
                @NonNull
                public Entry.BeanEntry<BEAN> diff(@NonNull Entry.BeanEntry<BEAN> beanEntry, @NonNull Entry.BeanEntry<BEAN> beanEntry2) {
                    return (beanEntry2 == beanEntry || beanEntry2.equals(beanEntry)) ? (Entry.BeanEntry<BEAN>) Entry.BeanEntry.sEmpty : beanEntry2;
                }
            }

            /* JADX INFO: compiled from: SearchBox */
            public static class DigitDiffer<DIGIT extends Number> implements Differ<Entry.DigitEntry<DIGIT>> {
                static final DigitDiffer sGlobal = new DigitDiffer();

                @NonNull
                public static <DIGIT extends Number> Entry.DigitEntry<DIGIT> globalDiff(@NonNull Entry.DigitEntry<DIGIT> digitEntry, @NonNull Entry.DigitEntry<DIGIT> digitEntry2) {
                    return sGlobal.diff((Entry.DigitEntry) digitEntry, (Entry.DigitEntry) digitEntry2);
                }

                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Differ
                @NonNull
                public Entry.DigitEntry<DIGIT> diff(@NonNull Entry.DigitEntry<DIGIT> digitEntry, @NonNull Entry.DigitEntry<DIGIT> digitEntry2) {
                    return Entry.DigitEntry.of(digitEntry2.diff(digitEntry.value));
                }
            }

            /* JADX INFO: compiled from: SearchBox */
            public static class ListDiffer<ENTRY extends Entry> implements Differ<Entry.ListEntry<ENTRY>> {
                static final ListDiffer sGlobal = new ListDiffer();

                @NonNull
                public static <ENTRY extends Entry> Entry.ListEntry<ENTRY> globalDiff(@NonNull Entry.ListEntry<ENTRY> listEntry, @NonNull Entry.ListEntry<ENTRY> listEntry2) {
                    return sGlobal.diff((Entry.ListEntry) listEntry, (Entry.ListEntry) listEntry2);
                }

                /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Differ
                @NonNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Entry.ListEntry<ENTRY> diff(@NonNull Entry.ListEntry<ENTRY> listEntry, @NonNull Entry.ListEntry<ENTRY> listEntry2) {
                    boolean z;
                    Entry.ListEntry<ENTRY> listEntryOfEmpty = Entry.ListEntry.ofEmpty();
                    for (int i = 0; i < listEntry2.list.size(); i++) {
                        Entry entry = (Entry) listEntry2.list.get(i);
                        if (entry instanceof Entry.DigitEntry) {
                            if (listEntry.list.size() > i) {
                                Entry entry2 = (Entry) listEntry.list.get(i);
                                if (entry2 instanceof Entry.DigitEntry) {
                                    listEntryOfEmpty.list.add(DigitDiffer.globalDiff((Entry.DigitEntry) entry2, (Entry.DigitEntry) entry));
                                } else {
                                    listEntryOfEmpty.list.add(Entry.DigitEntry.of(((Entry.DigitEntry) entry).value).setValid(false));
                                }
                            }
                        } else if ((entry instanceof Entry.BeanEntry) && !listEntry.list.contains(entry)) {
                            Iterator it = listEntry.list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                Entry entry3 = (Entry) it.next();
                                if ((entry3 instanceof Entry.BeanEntry) && BeanDiffer.globalDiff((Entry.BeanEntry) entry3, (Entry.BeanEntry) entry) == Entry.BeanEntry.sEmpty) {
                                    z = true;
                                    break;
                                }
                            }
                            if (!z) {
                                listEntryOfEmpty.list.add(entry);
                            }
                        }
                    }
                    return listEntryOfEmpty;
                }
            }

            @NonNull
            ENTRY diff(@NonNull ENTRY entry, @NonNull ENTRY entry2);
        }

        public abstract Delta<RECORD> diff(RECORD record);

        public long getTimeStamps() {
            return SystemClock.uptimeMillis();
        }

        public boolean isValid() {
            return this.mIsValid;
        }

        public Snapshot<RECORD> setValid(boolean z) {
            this.mIsValid = z;
            return this;
        }

        /* JADX INFO: compiled from: SearchBox */
        public static abstract class Entry<ENTRY> {
            private boolean mIsValid = true;

            /* JADX INFO: compiled from: SearchBox */
            public static class BeanEntry<BEAN> extends Entry<BeanEntry> {
                public static final BeanEntry<?> sEmpty = new BeanEntry<Void>(null) { // from class: com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Entry.BeanEntry.1
                    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Entry.BeanEntry
                    public boolean isEmpty() {
                        return true;
                    }
                };
                BEAN value;

                public BeanEntry(BEAN bean) {
                    this.value = bean;
                }

                public static <BEAN> BeanEntry<BEAN> of(BEAN bean) {
                    return new BeanEntry<>(bean);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    return String.valueOf(this.value).equals(String.valueOf(((BeanEntry) obj).value));
                }

                public BEAN get() {
                    return this.value;
                }

                public int hashCode() {
                    return Objects.hash(this.value);
                }

                public boolean isEmpty() {
                    return false;
                }

                @NonNull
                public String toString() {
                    return String.valueOf(this.value);
                }
            }

            /* JADX INFO: compiled from: SearchBox */
            public static abstract class DigitEntry<DIGIT extends Number> extends Entry<DigitEntry> {
                DIGIT value;

                /* JADX INFO: compiled from: SearchBox */
                public static class DoubleDigit extends DigitEntry<Double> {
                    public DoubleDigit(Double d) {
                        super(d);
                    }

                    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Entry.DigitEntry
                    public Double diff(Double d) {
                        return Double.valueOf(((Double) this.value).doubleValue() - d.doubleValue());
                    }
                }

                /* JADX INFO: compiled from: SearchBox */
                public static class FloatDigit extends DigitEntry<Float> {
                    public FloatDigit(Float f) {
                        super(f);
                    }

                    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Entry.DigitEntry
                    public Float diff(Float f) {
                        return Float.valueOf(((Float) this.value).floatValue() - f.floatValue());
                    }
                }

                /* JADX INFO: compiled from: SearchBox */
                public static class IntDigit extends DigitEntry<Integer> {
                    public IntDigit(Integer num) {
                        super(num);
                    }

                    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Entry.DigitEntry
                    public Integer diff(Integer num) {
                        return Integer.valueOf(((Integer) this.value).intValue() - num.intValue());
                    }
                }

                /* JADX INFO: compiled from: SearchBox */
                public static class LongDigit extends DigitEntry<Long> {
                    public LongDigit(Long l) {
                        super(l);
                    }

                    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Entry.DigitEntry
                    public Long diff(Long l) {
                        return Long.valueOf(((Long) this.value).longValue() - l.longValue());
                    }
                }

                public DigitEntry(DIGIT digit) {
                    this.value = digit;
                }

                public static <DIGIT extends Number> DigitEntry<DIGIT> of(DIGIT digit) {
                    if (digit instanceof Integer) {
                        return new IntDigit((Integer) digit);
                    }
                    if (digit instanceof Long) {
                        return new LongDigit((Long) digit);
                    }
                    if (digit instanceof Float) {
                        return new FloatDigit((Float) digit);
                    }
                    if (digit instanceof Double) {
                        return new DoubleDigit((Double) digit);
                    }
                    throw new RuntimeException("unsupported digit: " + digit.getClass());
                }

                public abstract DIGIT diff(DIGIT digit);

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    return this.value.equals(((DigitEntry) obj).value);
                }

                public DIGIT get() {
                    return this.value;
                }

                public int hashCode() {
                    return Objects.hash(this.value);
                }

                @NonNull
                public String toString() {
                    return String.valueOf(this.value);
                }
            }

            public boolean isValid() {
                return this.mIsValid;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public ENTRY setValid(boolean z) {
                this.mIsValid = z;
                return this;
            }

            /* JADX INFO: compiled from: SearchBox */
            public static class ListEntry<ITEM extends Entry> extends Entry<ListEntry> {
                List<ITEM> list;

                private ListEntry() {
                }

                public static <ITEM extends Entry> ListEntry<ITEM> of(List<ITEM> list) {
                    ListEntry<ITEM> listEntry = new ListEntry<>();
                    listEntry.list = list;
                    return listEntry;
                }

                public static <BEAN> ListEntry<BeanEntry<BEAN>> ofBeans(List<BEAN> list) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<BEAN> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(BeanEntry.of(it.next()));
                    }
                    return of(arrayList);
                }

                public static <DIGIT extends Number> ListEntry<DigitEntry<DIGIT>> ofDigits(List<DIGIT> list) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<DIGIT> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(DigitEntry.of(it.next()));
                    }
                    ListEntry<DigitEntry<DIGIT>> listEntry = new ListEntry<>();
                    listEntry.list = arrayList;
                    return listEntry;
                }

                public static <ITEM extends Entry> ListEntry<ITEM> ofEmpty() {
                    ListEntry<ITEM> listEntry = new ListEntry<>();
                    listEntry.list = new ArrayList();
                    return listEntry;
                }

                public List<ITEM> getList() {
                    return this.list;
                }

                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Entry
                public boolean isValid() {
                    Iterator<ITEM> it = this.list.iterator();
                    while (it.hasNext()) {
                        if (!it.next().isValid()) {
                            return false;
                        }
                    }
                    return super.isValid();
                }

                public static <DIGIT extends Number> ListEntry<DigitEntry<DIGIT>> ofDigits(DIGIT[] digitArr) {
                    return ofDigits(Arrays.asList(digitArr));
                }

                public static ListEntry<DigitEntry<Integer>> ofDigits(int[] iArr) {
                    ArrayList arrayList = new ArrayList();
                    for (int i : iArr) {
                        arrayList.add(DigitEntry.of(Integer.valueOf(i)));
                    }
                    ListEntry<DigitEntry<Integer>> listEntry = new ListEntry<>();
                    listEntry.list = arrayList;
                    return listEntry;
                }

                public static ListEntry<DigitEntry<Long>> ofDigits(long[] jArr) {
                    ArrayList arrayList = new ArrayList();
                    for (long j : jArr) {
                        arrayList.add(DigitEntry.of(Long.valueOf(j)));
                    }
                    ListEntry<DigitEntry<Long>> listEntry = new ListEntry<>();
                    listEntry.list = arrayList;
                    return listEntry;
                }

                public static ListEntry<DigitEntry<Float>> ofDigits(float[] fArr) {
                    ArrayList arrayList = new ArrayList();
                    for (float f : fArr) {
                        arrayList.add(DigitEntry.of(Float.valueOf(f)));
                    }
                    ListEntry<DigitEntry<Float>> listEntry = new ListEntry<>();
                    listEntry.list = arrayList;
                    return listEntry;
                }

                public static ListEntry<DigitEntry<Double>> ofDigits(double[] dArr) {
                    ArrayList arrayList = new ArrayList();
                    for (double d : dArr) {
                        arrayList.add(DigitEntry.of(Double.valueOf(d)));
                    }
                    ListEntry<DigitEntry<Double>> listEntry = new ListEntry<>();
                    listEntry.list = arrayList;
                    return listEntry;
                }
            }
        }
    }
}
