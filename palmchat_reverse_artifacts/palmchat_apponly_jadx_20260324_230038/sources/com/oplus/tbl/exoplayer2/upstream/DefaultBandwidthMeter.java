package com.oplus.tbl.exoplayer2.upstream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.bef.effectsdk.RequirementDefine;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.sdk.PushConsts;
import com.oplus.tbl.exoplayer2.upstream.BandwidthMeter;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Clock;
import com.oplus.tbl.exoplayer2.util.SlidingPercentile;
import com.oplus.tbl.exoplayer2.util.Util;
import com.opos.acs.st.STManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.zm.fissionsdk.ZW2Vz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {
    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    private static final int COUNTRY_GROUP_INDEX_2G = 1;
    private static final int COUNTRY_GROUP_INDEX_3G = 2;
    private static final int COUNTRY_GROUP_INDEX_4G = 3;
    private static final int COUNTRY_GROUP_INDEX_5G_NSA = 4;
    private static final int COUNTRY_GROUP_INDEX_WIFI = 0;
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;

    @Nullable
    private static DefaultBandwidthMeter singletonInstance;
    private long bitrateEstimate;
    private final Clock clock;

    @Nullable
    private final Context context;
    private final BandwidthMeter.EventListener.EventDispatcher eventDispatcher;
    private final ImmutableMap<Integer, Long> initialBitrateEstimates;
    private long lastReportedBitrateEstimate;
    private int networkType;
    private int networkTypeOverride;
    private boolean networkTypeOverrideSet;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;
    public static final ImmutableListMultimap<String, Integer> DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS = createInitialBitrateCountryGroupAssignment();
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = ImmutableList.of(6100000L, 3800000L, 2100000L, 1300000L, 590000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = ImmutableList.of(218000L, 159000L, 145000L, 130000L, 112000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = ImmutableList.of(2200000L, 1300000L, 930000L, 730000L, 530000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = ImmutableList.of(4800000L, 2700000L, 1800000L, 1200000L, 630000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA = ImmutableList.of(12000000L, 8800000L, 5900000L, 3500000L, 1800000L);

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private Clock clock;

        @Nullable
        private final Context context;
        private Map<Integer, Long> initialBitrateEstimates;
        private boolean resetOnNetworkTypeChange;
        private int slidingWindowMaxWeight;

        public Builder(Context context) {
            this.context = context == null ? null : context.getApplicationContext();
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Util.getCountryCode(context));
            this.slidingWindowMaxWeight = 2000;
            this.clock = Clock.DEFAULT;
            this.resetOnNetworkTypeChange = true;
        }

        private static ImmutableList<Integer> getCountryGroupIndices(String str) {
            ImmutableList<Integer> immutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS.get(str);
            return immutableList.isEmpty() ? ImmutableList.of(2, 2, 2, 2, 2) : immutableList;
        }

        private static Map<Integer, Long> getInitialBitrateEstimatesForCountry(String str) {
            ImmutableList<Integer> countryGroupIndices = getCountryGroupIndices(str);
            HashMap map = new HashMap(6);
            map.put(0, 1000000L);
            ImmutableList<Long> immutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI;
            map.put(2, immutableList.get(countryGroupIndices.get(0).intValue()));
            map.put(3, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G.get(countryGroupIndices.get(1).intValue()));
            map.put(4, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G.get(countryGroupIndices.get(2).intValue()));
            map.put(5, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G.get(countryGroupIndices.get(3).intValue()));
            map.put(9, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA.get(countryGroupIndices.get(4).intValue()));
            map.put(7, immutableList.get(countryGroupIndices.get(0).intValue()));
            return map;
        }

        public DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.context, this.initialBitrateEstimates, this.slidingWindowMaxWeight, this.clock, this.resetOnNetworkTypeChange);
        }

        public Builder setClock(Clock clock) {
            this.clock = clock;
            return this;
        }

        public Builder setInitialBitrateEstimate(int i, long j) {
            this.initialBitrateEstimates.put(Integer.valueOf(i), Long.valueOf(j));
            return this;
        }

        public Builder setResetOnNetworkTypeChange(boolean z) {
            this.resetOnNetworkTypeChange = z;
            return this;
        }

        public Builder setSlidingWindowMaxWeight(int i) {
            this.slidingWindowMaxWeight = i;
            return this;
        }

        public Builder setInitialBitrateEstimate(long j) {
            Iterator<Integer> it = this.initialBitrateEstimates.keySet().iterator();
            while (it.hasNext()) {
                setInitialBitrateEstimate(it.next().intValue(), j);
            }
            return this;
        }

        public Builder setInitialBitrateEstimate(String str) {
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Util.toUpperInvariant(str));
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ConnectivityActionReceiver extends BroadcastReceiver {
        private static ConnectivityActionReceiver staticInstance;
        private final Handler mainHandler = new Handler(Looper.getMainLooper());
        private final ArrayList<WeakReference<DefaultBandwidthMeter>> bandwidthMeters = new ArrayList<>();

        private ConnectivityActionReceiver() {
        }

        public static synchronized ConnectivityActionReceiver getInstance(Context context) {
            if (staticInstance == null) {
                staticInstance = new ConnectivityActionReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                if (Util.SDK_INT >= 33) {
                    context.registerReceiver(staticInstance, intentFilter, 2);
                } else {
                    context.registerReceiver(staticInstance, intentFilter);
                }
            }
            return staticInstance;
        }

        private void removeClearedReferences() {
            for (int size = this.bandwidthMeters.size() - 1; size >= 0; size--) {
                if (this.bandwidthMeters.get(size).get() == null) {
                    this.bandwidthMeters.remove(size);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: updateBandwidthMeter, reason: merged with bridge method [inline-methods] */
        public void lambda$register$0(DefaultBandwidthMeter defaultBandwidthMeter) {
            defaultBandwidthMeter.onConnectivityAction();
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            removeClearedReferences();
            for (int i = 0; i < this.bandwidthMeters.size(); i++) {
                DefaultBandwidthMeter defaultBandwidthMeter = this.bandwidthMeters.get(i).get();
                if (defaultBandwidthMeter != null) {
                    lambda$register$0(defaultBandwidthMeter);
                }
            }
        }

        public synchronized void register(final DefaultBandwidthMeter defaultBandwidthMeter) {
            removeClearedReferences();
            this.bandwidthMeters.add(new WeakReference<>(defaultBandwidthMeter));
            this.mainHandler.post(new Runnable() { // from class: com.oplus.tbl.exoplayer2.upstream.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7672a.lambda$register$0(defaultBandwidthMeter);
                }
            });
        }
    }

    @Deprecated
    public DefaultBandwidthMeter() {
        this(null, ImmutableMap.of(), 2000, Clock.DEFAULT, false);
    }

    private static ImmutableListMultimap<String, Integer> createInitialBitrateCountryGroupAssignment() {
        ImmutableListMultimap.a aVarBuilder = ImmutableListMultimap.builder();
        aVarBuilder.q("AD", 1, 2, 0, 0, 2);
        aVarBuilder.q("AE", 1, 4, 4, 4, 1);
        aVarBuilder.q("AF", 4, 4, 3, 4, 2);
        aVarBuilder.q("AG", 2, 2, 1, 1, 2);
        aVarBuilder.q("AI", 1, 2, 2, 2, 2);
        aVarBuilder.q("AL", 1, 1, 0, 1, 2);
        aVarBuilder.q("AM", 2, 2, 1, 2, 2);
        aVarBuilder.q("AO", 3, 4, 4, 2, 2);
        aVarBuilder.q(RequirementDefine.REQUIREMENT_AR_TAG, 2, 4, 2, 2, 2);
        aVarBuilder.q("AS", 2, 2, 4, 3, 2);
        aVarBuilder.q("AT", 0, 3, 0, 0, 2);
        aVarBuilder.q("AU", 0, 2, 0, 1, 1);
        aVarBuilder.q("AW", 1, 2, 0, 4, 2);
        aVarBuilder.q("AX", 0, 2, 2, 2, 2);
        aVarBuilder.q("AZ", 3, 3, 3, 4, 2);
        aVarBuilder.q("BA", 1, 1, 0, 1, 2);
        aVarBuilder.q("BB", 0, 2, 0, 0, 2);
        aVarBuilder.q(GlobalSetting.BD_SDK_WRAPPER, 2, 0, 3, 3, 2);
        aVarBuilder.q("BE", 0, 1, 2, 3, 2);
        aVarBuilder.q("BF", 4, 4, 4, 2, 2);
        aVarBuilder.q("BG", 0, 1, 0, 0, 2);
        aVarBuilder.q("BH", 1, 0, 2, 4, 2);
        aVarBuilder.q("BI", 4, 4, 4, 4, 2);
        aVarBuilder.q("BJ", 4, 4, 3, 4, 2);
        aVarBuilder.q("BL", 1, 2, 2, 2, 2);
        aVarBuilder.q("BM", 1, 2, 0, 0, 2);
        aVarBuilder.q("BN", 4, 0, 1, 1, 2);
        aVarBuilder.q("BO", 2, 3, 3, 2, 2);
        aVarBuilder.q("BQ", 1, 2, 1, 2, 2);
        aVarBuilder.q("BR", 2, 4, 2, 1, 2);
        aVarBuilder.q("BS", 3, 2, 2, 3, 2);
        aVarBuilder.q("BT", 3, 0, 3, 2, 2);
        aVarBuilder.q("BW", 3, 4, 2, 2, 2);
        aVarBuilder.q("BY", 1, 0, 2, 1, 2);
        aVarBuilder.q("BZ", 2, 2, 2, 1, 2);
        aVarBuilder.q("CA", 0, 3, 1, 2, 3);
        aVarBuilder.q("CD", 4, 3, 2, 2, 2);
        aVarBuilder.q("CF", 4, 2, 2, 2, 2);
        aVarBuilder.q("CG", 3, 4, 1, 1, 2);
        aVarBuilder.q("CH", 0, 1, 0, 0, 0);
        aVarBuilder.q("CI", 3, 3, 3, 3, 2);
        aVarBuilder.q("CK", 3, 2, 1, 0, 2);
        aVarBuilder.q("CL", 1, 1, 2, 3, 2);
        aVarBuilder.q("CM", 3, 4, 3, 2, 2);
        aVarBuilder.q("CN", 2, 2, 2, 1, 3);
        aVarBuilder.q("CO", 2, 4, 3, 2, 2);
        aVarBuilder.q("CR", 2, 3, 4, 4, 2);
        aVarBuilder.q("CU", 4, 4, 2, 1, 2);
        aVarBuilder.q("CV", 2, 3, 3, 3, 2);
        aVarBuilder.q("CW", 1, 2, 0, 0, 2);
        aVarBuilder.q("CY", 1, 2, 0, 0, 2);
        aVarBuilder.q("CZ", 0, 1, 0, 0, 2);
        aVarBuilder.q("DE", 0, 1, 1, 2, 0);
        aVarBuilder.q("DJ", 4, 1, 4, 4, 2);
        aVarBuilder.q("DK", 0, 0, 1, 0, 2);
        aVarBuilder.q("DM", 1, 2, 2, 2, 2);
        aVarBuilder.q("DO", 3, 4, 4, 4, 2);
        aVarBuilder.q("DZ", 3, 2, 4, 4, 2);
        aVarBuilder.q("EC", 2, 4, 3, 2, 2);
        aVarBuilder.q("EE", 0, 0, 0, 0, 2);
        aVarBuilder.q("EG", 3, 4, 2, 1, 2);
        aVarBuilder.q("EH", 2, 2, 2, 2, 2);
        aVarBuilder.q("ER", 4, 2, 2, 2, 2);
        aVarBuilder.q("ES", 0, 1, 2, 1, 2);
        aVarBuilder.q("ET", 4, 4, 4, 1, 2);
        aVarBuilder.q("FI", 0, 0, 1, 0, 0);
        aVarBuilder.q("FJ", 3, 0, 3, 3, 2);
        aVarBuilder.q("FK", 2, 2, 2, 2, 2);
        aVarBuilder.q("FM", 4, 2, 4, 3, 2);
        aVarBuilder.q("FO", 0, 2, 0, 0, 2);
        aVarBuilder.q("FR", 1, 0, 2, 1, 2);
        aVarBuilder.q("GA", 3, 3, 1, 0, 2);
        aVarBuilder.q("GB", 0, 0, 1, 2, 2);
        aVarBuilder.q("GD", 1, 2, 2, 2, 2);
        aVarBuilder.q("GE", 1, 0, 1, 3, 2);
        aVarBuilder.q("GF", 2, 2, 2, 4, 2);
        aVarBuilder.q("GG", 0, 2, 0, 0, 2);
        aVarBuilder.q("GH", 3, 2, 3, 2, 2);
        aVarBuilder.q("GI", 0, 2, 0, 0, 2);
        aVarBuilder.q("GL", 1, 2, 2, 1, 2);
        aVarBuilder.q("GM", 4, 3, 2, 4, 2);
        aVarBuilder.q("GN", 4, 3, 4, 2, 2);
        aVarBuilder.q("GP", 2, 2, 3, 4, 2);
        aVarBuilder.q("GQ", 4, 2, 3, 4, 2);
        aVarBuilder.q("GR", 1, 1, 0, 1, 2);
        aVarBuilder.q(com.igexin.push.core.b.j, 3, 2, 3, 2, 2);
        aVarBuilder.q("GU", 1, 2, 4, 4, 2);
        aVarBuilder.q("GW", 3, 4, 4, 3, 2);
        aVarBuilder.q("GY", 3, 3, 1, 0, 2);
        aVarBuilder.q("HK", 0, 2, 3, 4, 2);
        aVarBuilder.q("HN", 3, 0, 3, 3, 2);
        aVarBuilder.q("HR", 1, 1, 0, 1, 2);
        aVarBuilder.q("HT", 4, 3, 4, 4, 2);
        aVarBuilder.q("HU", 0, 1, 0, 0, 2);
        aVarBuilder.q(STManager.REGION_OF_ID, 3, 2, 2, 3, 2);
        aVarBuilder.q("IE", 0, 0, 1, 1, 2);
        aVarBuilder.q("IL", 1, 0, 2, 3, 2);
        aVarBuilder.q("IM", 0, 2, 0, 1, 2);
        aVarBuilder.q(STManager.REGION_OF_IN, 2, 1, 3, 3, 2);
        aVarBuilder.q("IO", 4, 2, 2, 4, 2);
        aVarBuilder.q("IQ", 3, 2, 4, 3, 2);
        aVarBuilder.q("IR", 4, 2, 3, 4, 2);
        aVarBuilder.q("IS", 0, 2, 0, 0, 2);
        aVarBuilder.q("IT", 0, 0, 1, 1, 2);
        aVarBuilder.q("JE", 2, 2, 0, 2, 2);
        aVarBuilder.q("JM", 3, 3, 4, 4, 2);
        aVarBuilder.q("JO", 1, 2, 1, 1, 2);
        aVarBuilder.q("JP", 0, 2, 0, 1, 3);
        aVarBuilder.q("KE", 3, 4, 2, 2, 2);
        aVarBuilder.q("KG", 1, 0, 2, 2, 2);
        aVarBuilder.q("KH", 2, 0, 4, 3, 2);
        aVarBuilder.q("KI", 4, 2, 3, 1, 2);
        aVarBuilder.q("KM", 4, 2, 2, 3, 2);
        aVarBuilder.q("KN", 1, 2, 2, 2, 2);
        aVarBuilder.q("KP", 4, 2, 2, 2, 2);
        aVarBuilder.q("KR", 0, 2, 1, 1, 1);
        aVarBuilder.q("KW", 2, 3, 1, 1, 1);
        aVarBuilder.q("KY", 1, 2, 0, 0, 2);
        aVarBuilder.q("KZ", 1, 2, 2, 3, 2);
        aVarBuilder.q("LA", 2, 2, 1, 1, 2);
        aVarBuilder.q("LB", 3, 2, 0, 0, 2);
        aVarBuilder.q("LC", 1, 1, 0, 0, 2);
        aVarBuilder.q("LI", 0, 2, 2, 2, 2);
        aVarBuilder.q("LK", 2, 0, 2, 3, 2);
        aVarBuilder.q("LR", 3, 4, 3, 2, 2);
        aVarBuilder.q("LS", 3, 3, 2, 3, 2);
        aVarBuilder.q("LT", 0, 0, 0, 0, 2);
        aVarBuilder.q("LU", 0, 0, 0, 0, 2);
        aVarBuilder.q("LV", 0, 0, 0, 0, 2);
        aVarBuilder.q("LY", 4, 2, 4, 3, 2);
        aVarBuilder.q("MA", 2, 1, 2, 1, 2);
        aVarBuilder.q("MC", 0, 2, 2, 2, 2);
        aVarBuilder.q("MD", 1, 2, 0, 0, 2);
        aVarBuilder.q("ME", 1, 2, 1, 2, 2);
        aVarBuilder.q("MF", 1, 2, 1, 0, 2);
        aVarBuilder.q("MG", 3, 4, 3, 3, 2);
        aVarBuilder.q("MH", 4, 2, 2, 4, 2);
        aVarBuilder.q("MK", 1, 0, 0, 0, 2);
        aVarBuilder.q("ML", 4, 4, 1, 1, 2);
        aVarBuilder.q("MM", 2, 3, 2, 2, 2);
        aVarBuilder.q("MN", 2, 4, 1, 1, 2);
        aVarBuilder.q("MO", 0, 2, 4, 4, 2);
        aVarBuilder.q("MP", 0, 2, 2, 2, 2);
        aVarBuilder.q("MQ", 2, 2, 2, 3, 2);
        aVarBuilder.q(ZW2Vz.c, 3, 0, 4, 2, 2);
        aVarBuilder.q("MS", 1, 2, 2, 2, 2);
        aVarBuilder.q("MT", 0, 2, 0, 1, 2);
        aVarBuilder.q("MU", 3, 1, 2, 3, 2);
        aVarBuilder.q("MV", 4, 3, 1, 4, 2);
        aVarBuilder.q("MW", 4, 1, 1, 0, 2);
        aVarBuilder.q("MX", 2, 4, 3, 3, 2);
        aVarBuilder.q(STManager.REGION_OF_MY, 2, 0, 3, 3, 2);
        aVarBuilder.q("MZ", 3, 3, 2, 3, 2);
        aVarBuilder.q("NA", 4, 3, 2, 2, 2);
        aVarBuilder.q("NC", 2, 0, 4, 4, 2);
        aVarBuilder.q("NE", 4, 4, 4, 4, 2);
        aVarBuilder.q("NF", 2, 2, 2, 2, 2);
        aVarBuilder.q("NG", 3, 3, 2, 2, 2);
        aVarBuilder.q("NI", 3, 1, 4, 4, 2);
        aVarBuilder.q("NL", 0, 2, 4, 2, 0);
        aVarBuilder.q("NO", 0, 1, 1, 0, 2);
        aVarBuilder.q("NP", 2, 0, 4, 3, 2);
        aVarBuilder.q("NR", 4, 2, 3, 1, 2);
        aVarBuilder.q("NU", 4, 2, 2, 2, 2);
        aVarBuilder.q("NZ", 0, 2, 1, 2, 4);
        aVarBuilder.q("OM", 2, 2, 0, 2, 2);
        aVarBuilder.q("PA", 1, 3, 3, 4, 2);
        aVarBuilder.q("PE", 2, 4, 4, 4, 2);
        aVarBuilder.q("PF", 2, 2, 1, 1, 2);
        aVarBuilder.q("PG", 4, 3, 3, 2, 2);
        aVarBuilder.q(STManager.REGION_OF_PH, 3, 0, 3, 4, 4);
        aVarBuilder.q("PK", 3, 2, 3, 3, 2);
        aVarBuilder.q("PL", 1, 0, 2, 2, 2);
        aVarBuilder.q("PM", 0, 2, 2, 2, 2);
        aVarBuilder.q("PR", 1, 2, 2, 3, 4);
        aVarBuilder.q("PS", 3, 3, 2, 2, 2);
        aVarBuilder.q(AssistPushConsts.MSG_VALUE_PAYLOAD, 1, 1, 0, 0, 2);
        aVarBuilder.q("PW", 1, 2, 3, 0, 2);
        aVarBuilder.q("PY", 2, 0, 3, 3, 2);
        aVarBuilder.q("QA", 2, 3, 1, 2, 2);
        aVarBuilder.q("RE", 1, 0, 2, 1, 2);
        aVarBuilder.q("RO", 1, 1, 1, 2, 2);
        aVarBuilder.q("RS", 1, 2, 0, 0, 2);
        aVarBuilder.q("RU", 0, 1, 0, 1, 2);
        aVarBuilder.q("RW", 4, 3, 3, 4, 2);
        aVarBuilder.q("SA", 2, 2, 2, 1, 2);
        aVarBuilder.q("SB", 4, 2, 4, 2, 2);
        aVarBuilder.q("SC", 4, 2, 0, 1, 2);
        aVarBuilder.q("SD", 4, 4, 4, 3, 2);
        aVarBuilder.q("SE", 0, 0, 0, 0, 2);
        aVarBuilder.q("SG", 0, 0, 3, 3, 4);
        aVarBuilder.q("SH", 4, 2, 2, 2, 2);
        aVarBuilder.q("SI", 0, 1, 0, 0, 2);
        aVarBuilder.q("SJ", 2, 2, 2, 2, 2);
        aVarBuilder.q("SK", 0, 1, 0, 0, 2);
        aVarBuilder.q("SL", 4, 3, 3, 1, 2);
        aVarBuilder.q("SM", 0, 2, 2, 2, 2);
        aVarBuilder.q("SN", 4, 4, 4, 3, 2);
        aVarBuilder.q("SO", 3, 4, 4, 4, 2);
        aVarBuilder.q("SR", 3, 2, 3, 1, 2);
        aVarBuilder.q("SS", 4, 1, 4, 2, 2);
        aVarBuilder.q("ST", 2, 2, 1, 2, 2);
        aVarBuilder.q("SV", 2, 1, 4, 4, 2);
        aVarBuilder.q("SX", 2, 2, 1, 0, 2);
        aVarBuilder.q("SY", 4, 3, 2, 2, 2);
        aVarBuilder.q("SZ", 3, 4, 3, 4, 2);
        aVarBuilder.q("TC", 1, 2, 1, 0, 2);
        aVarBuilder.q("TD", 4, 4, 4, 4, 2);
        aVarBuilder.q("TG", 3, 2, 1, 0, 2);
        aVarBuilder.q(STManager.REGION_OF_TH, 1, 3, 4, 3, 0);
        aVarBuilder.q("TJ", 4, 4, 4, 4, 2);
        aVarBuilder.q("TL", 4, 1, 4, 4, 2);
        aVarBuilder.q("TM", 4, 2, 1, 2, 2);
        aVarBuilder.q("TN", 2, 1, 1, 1, 2);
        aVarBuilder.q("TO", 3, 3, 4, 2, 2);
        aVarBuilder.q("TR", 1, 2, 1, 1, 2);
        aVarBuilder.q(GlobalSetting.TT_SDK_WRAPPER, 1, 3, 1, 3, 2);
        aVarBuilder.q("TV", 3, 2, 2, 4, 2);
        aVarBuilder.q(STManager.REGION_OF_TW, 0, 0, 0, 0, 1);
        aVarBuilder.q("TZ", 3, 3, 3, 2, 2);
        aVarBuilder.q("UA", 0, 3, 0, 0, 2);
        aVarBuilder.q("UG", 3, 2, 2, 3, 2);
        aVarBuilder.q("US", 0, 1, 3, 3, 3);
        aVarBuilder.q("UY", 2, 1, 1, 1, 2);
        aVarBuilder.q("UZ", 2, 0, 3, 2, 2);
        aVarBuilder.q("VC", 2, 2, 2, 2, 2);
        aVarBuilder.q("VE", 4, 4, 4, 4, 2);
        aVarBuilder.q("VG", 2, 2, 1, 2, 2);
        aVarBuilder.q("VI", 1, 2, 2, 4, 2);
        aVarBuilder.q(STManager.REGION_OF_VN, 0, 1, 4, 4, 2);
        aVarBuilder.q("VU", 4, 1, 3, 1, 2);
        aVarBuilder.q("WS", 3, 1, 4, 2, 2);
        aVarBuilder.q("XK", 1, 1, 1, 0, 2);
        aVarBuilder.q("YE", 4, 4, 4, 4, 2);
        aVarBuilder.q("YT", 3, 2, 1, 3, 2);
        aVarBuilder.q("ZA", 2, 3, 2, 2, 2);
        aVarBuilder.q("ZM", 3, 2, 2, 3, 2);
        aVarBuilder.q("ZW", 3, 3, 3, 3, 2);
        return aVarBuilder.k();
    }

    private long getInitialBitrateEstimateForNetworkType(int i) {
        Long l = this.initialBitrateEstimates.get(Integer.valueOf(i));
        if (l == null) {
            l = this.initialBitrateEstimates.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    public static synchronized DefaultBandwidthMeter getSingletonInstance(Context context) {
        if (singletonInstance == null) {
            singletonInstance = new Builder(context).build();
        }
        return singletonInstance;
    }

    private static boolean isTransferAtFullNetworkSpeed(DataSpec dataSpec, boolean z) {
        return z && !dataSpec.isFlagSet(8);
    }

    private void maybeNotifyBandwidthSample(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.lastReportedBitrateEstimate) {
            return;
        }
        this.lastReportedBitrateEstimate = j2;
        this.eventDispatcher.bandwidthSample(i, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onConnectivityAction() {
        int networkType;
        if (this.networkTypeOverrideSet) {
            networkType = this.networkTypeOverride;
        } else {
            Context context = this.context;
            networkType = context == null ? 0 : Util.getNetworkType(context);
        }
        if (this.networkType == networkType) {
            return;
        }
        this.networkType = networkType;
        if (networkType != 1 && networkType != 0 && networkType != 8) {
            this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(networkType);
            long jElapsedRealtime = this.clock.elapsedRealtime();
            maybeNotifyBandwidthSample(this.streamCount > 0 ? (int) (jElapsedRealtime - this.sampleStartTimeMs) : 0, this.sampleBytesTransferred, this.bitrateEstimate);
            this.sampleStartTimeMs = jElapsedRealtime;
            this.sampleBytesTransferred = 0L;
            this.totalBytesTransferred = 0L;
            this.totalElapsedTimeMs = 0L;
            this.slidingPercentile.reset();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.BandwidthMeter
    public void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(eventListener);
        this.eventDispatcher.addListener(handler, eventListener);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
    public synchronized void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int i) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            this.sampleBytesTransferred += (long) i;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
    public synchronized void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            Assertions.checkState(this.streamCount > 0);
            long jElapsedRealtime = this.clock.elapsedRealtime();
            int i = (int) (jElapsedRealtime - this.sampleStartTimeMs);
            this.totalElapsedTimeMs += (long) i;
            long j = this.totalBytesTransferred;
            long j2 = this.sampleBytesTransferred;
            this.totalBytesTransferred = j + j2;
            if (i > 0) {
                this.slidingPercentile.addSample((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                if (this.totalElapsedTimeMs >= 2000 || this.totalBytesTransferred >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.bitrateEstimate = (long) this.slidingPercentile.getPercentile(0.5f);
                }
                maybeNotifyBandwidthSample(i, this.sampleBytesTransferred, this.bitrateEstimate);
                this.sampleStartTimeMs = jElapsedRealtime;
                this.sampleBytesTransferred = 0L;
            }
            this.streamCount--;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
    public synchronized void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            if (this.streamCount == 0) {
                this.sampleStartTimeMs = this.clock.elapsedRealtime();
            }
            this.streamCount++;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.BandwidthMeter
    public void removeEventListener(BandwidthMeter.EventListener eventListener) {
        this.eventDispatcher.removeListener(eventListener);
    }

    public synchronized void setNetworkTypeOverride(int i) {
        this.networkTypeOverride = i;
        this.networkTypeOverrideSet = true;
        onConnectivityAction();
    }

    private DefaultBandwidthMeter(@Nullable Context context, Map<Integer, Long> map, int i, Clock clock, boolean z) {
        this.context = context == null ? null : context.getApplicationContext();
        this.initialBitrateEstimates = ImmutableMap.copyOf((Map) map);
        this.eventDispatcher = new BandwidthMeter.EventListener.EventDispatcher();
        this.slidingPercentile = new SlidingPercentile(i);
        this.clock = clock;
        int networkType = context == null ? 0 : Util.getNetworkType(context);
        this.networkType = networkType;
        this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(networkType);
        if (context == null || !z) {
            return;
        }
        ConnectivityActionReceiver.getInstance(context).register(this);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.BandwidthMeter
    public TransferListener getTransferListener() {
        return this;
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }
}
