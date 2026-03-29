package com.ss.bytertc.audio.device.webrtc;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import androidx.annotation.Nullable;
import com.bytedance.realx.base.RXLogging;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WebRtcAudioEffects {
    private static final boolean DEBUG = false;
    private static final String TAG = "WebRtcAudioEffects";

    @Nullable
    private static AudioEffect.Descriptor[] cachedEffects;

    @Nullable
    private AcousticEchoCanceler aec;

    @Nullable
    private NoiseSuppressor ns;
    private boolean shouldEnableAec;
    private boolean shouldEnableNs;
    private static Map<String, List<String>> audioEffectBlackList = new HashMap();
    private static final UUID AOSP_ACOUSTIC_ECHO_CANCELER = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
    private static final UUID AOSP_NOISE_SUPPRESSOR = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");

    private WebRtcAudioEffects() {
        RXLogging.i(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
    }

    public static boolean IsAudioEffectSupported() {
        if (audioEffectBlackList.isEmpty()) {
            initAudioEffectBlackList();
        }
        String productBrand = WebRtcAudioUtils.getProductBrand();
        if (productBrand.isEmpty() || !audioEffectBlackList.containsKey(productBrand)) {
            return true;
        }
        String romVersion = WebRtcAudioUtils.getRomVersion(productBrand);
        boolean zContains = audioEffectBlackList.get(productBrand).contains(romVersion);
        RXLogging.w(TAG, "IsAudioEffectSupported, " + productBrand + ", " + romVersion + ", in black list = " + zContains);
        return !zContains;
    }

    private static void assertTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    public static boolean canUseAcousticEchoCanceler() {
        boolean z = (!isAcousticEchoCancelerSupported() || WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler() || isAcousticEchoCancelerBlacklisted()) ? false : true;
        RXLogging.i(TAG, "canUseAcousticEchoCanceler: " + z);
        return z;
    }

    public static boolean canUseNoiseSuppressor() {
        boolean z = (!isNoiseSuppressorSupported() || WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor() || isNoiseSuppressorBlacklisted()) ? false : true;
        RXLogging.i(TAG, "canUseNoiseSuppressor: " + z);
        return z;
    }

    public static WebRtcAudioEffects create() {
        return new WebRtcAudioEffects();
    }

    private boolean effectTypeIsVoIP(UUID uuid) {
        return (AudioEffect.EFFECT_TYPE_AEC.equals(uuid) && isAcousticEchoCancelerSupported()) || (AudioEffect.EFFECT_TYPE_NS.equals(uuid) && isNoiseSuppressorSupported());
    }

    @Nullable
    private static AudioEffect.Descriptor[] getAvailableEffects() {
        AudioEffect.Descriptor[] descriptorArr = cachedEffects;
        if (descriptorArr != null) {
            return descriptorArr;
        }
        try {
            AudioEffect.Descriptor[] descriptorArrQueryEffects = AudioEffect.queryEffects();
            cachedEffects = descriptorArrQueryEffects;
            return descriptorArrQueryEffects;
        } catch (Exception e) {
            e.printStackTrace();
            return cachedEffects;
        }
    }

    private static void initAudioEffectBlackList() {
        audioEffectBlackList.put("vivo", new ArrayList());
        audioEffectBlackList.get("vivo").add("Funtouch OS_3.1_PD1616_D_7.17.5");
    }

    public static boolean isAcousticEchoCancelerBlacklisted() {
        List<String> blackListedModelsForAecUsage = WebRtcAudioUtils.getBlackListedModelsForAecUsage();
        String str = Build.MODEL;
        boolean zContains = blackListedModelsForAecUsage.contains(str);
        if (zContains) {
            RXLogging.w(TAG, str + " is blacklisted for HW AEC usage!");
        }
        return zContains;
    }

    private static boolean isAcousticEchoCancelerEffectAvailable() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC);
    }

    private static boolean isAcousticEchoCancelerExcludedByUUID() {
        for (AudioEffect.Descriptor descriptor : getAvailableEffects()) {
            if (descriptor.type.equals(AudioEffect.EFFECT_TYPE_AEC) && descriptor.uuid.equals(AOSP_ACOUSTIC_ECHO_CANCELER)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return isAcousticEchoCancelerEffectAvailable();
    }

    private static boolean isEffectTypeAvailable(UUID uuid) {
        AudioEffect.Descriptor[] availableEffects = getAvailableEffects();
        if (availableEffects == null) {
            return false;
        }
        for (AudioEffect.Descriptor descriptor : availableEffects) {
            if (descriptor.type.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNoiseSuppressorBlacklisted() {
        List<String> blackListedModelsForNsUsage = WebRtcAudioUtils.getBlackListedModelsForNsUsage();
        String str = Build.MODEL;
        boolean zContains = blackListedModelsForNsUsage.contains(str);
        if (zContains) {
            RXLogging.w(TAG, str + " is blacklisted for HW NS usage!");
        }
        return zContains;
    }

    private static boolean isNoiseSuppressorEffectAvailable() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS);
    }

    private static boolean isNoiseSuppressorExcludedByUUID() {
        for (AudioEffect.Descriptor descriptor : getAvailableEffects()) {
            if (descriptor.type.equals(AudioEffect.EFFECT_TYPE_NS) && descriptor.uuid.equals(AOSP_NOISE_SUPPRESSOR)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNoiseSuppressorSupported() {
        return isNoiseSuppressorEffectAvailable();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void enable(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean enabled;
        boolean enabled2;
        AcousticEchoCanceler acousticEchoCancelerCreate;
        boolean z4;
        boolean z5;
        boolean enabled3;
        RXLogging.i(TAG, "enable(audioSession=" + i + ")");
        boolean z6 = false;
        if (isAcousticEchoCancelerSupported()) {
            try {
                if (this.aec != null) {
                    RXLogging.e(TAG, "Release previous aec instance");
                    this.aec.release();
                    this.aec = null;
                }
                acousticEchoCancelerCreate = AcousticEchoCanceler.create(i);
                this.aec = acousticEchoCancelerCreate;
            } catch (Exception e) {
                e = e;
                z = false;
                z2 = false;
            }
            if (acousticEchoCancelerCreate != null) {
                enabled = acousticEchoCancelerCreate.getEnabled();
                try {
                } catch (Exception e2) {
                    z2 = false;
                    z = enabled;
                    e = e2;
                }
                if (this.shouldEnableAec) {
                    z3 = canUseAcousticEchoCanceler();
                    try {
                        if (this.aec.setEnabled(z3) != 0) {
                            RXLogging.e(TAG, "Failed to set the AcousticEchoCanceler state");
                        }
                        enabled2 = this.aec.getEnabled();
                    } catch (Exception e3) {
                        boolean z7 = z3;
                        z = enabled;
                        e = e3;
                        z2 = z7;
                        e.printStackTrace();
                        enabled = z;
                        z3 = z2;
                        enabled2 = false;
                    }
                    if (this.aec != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("AcousticEchoCanceler: was ");
                        sb.append(enabled ? "enabled" : "disabled");
                        sb.append(", enable: ");
                        sb.append(z3);
                        sb.append(", is now: ");
                        sb.append(enabled2 ? "enabled" : "disabled");
                        RXLogging.i(TAG, sb.toString());
                    } else {
                        RXLogging.e(TAG, "Failed to create the AcousticEchoCanceler instance");
                    }
                }
            } else {
                enabled = false;
                z3 = false;
                enabled2 = false;
                if (this.aec != null) {
                }
            }
            e.printStackTrace();
            enabled = z;
            z3 = z2;
            enabled2 = false;
            if (this.aec != null) {
            }
        }
        if (isNoiseSuppressorSupported()) {
            try {
                if (this.ns != null) {
                    RXLogging.e(TAG, "Release previous ns instance");
                    this.ns.release();
                    this.ns = null;
                }
                NoiseSuppressor noiseSuppressorCreate = NoiseSuppressor.create(i);
                this.ns = noiseSuppressorCreate;
                if (noiseSuppressorCreate != null) {
                    boolean enabled4 = noiseSuppressorCreate.getEnabled();
                    try {
                        if (this.shouldEnableNs) {
                            z5 = canUseNoiseSuppressor();
                            try {
                                if (this.ns.setEnabled(z5) != 0) {
                                    RXLogging.e(TAG, "Failed to set the NoiseSuppressor state");
                                }
                                z6 = enabled4;
                                enabled3 = this.ns.getEnabled();
                            } catch (Exception e4) {
                                e = e4;
                                Exception exc = e;
                                z4 = enabled4;
                                e = exc;
                                e.printStackTrace();
                                z6 = z4;
                                enabled3 = false;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        z5 = false;
                    }
                } else {
                    enabled3 = false;
                    z5 = false;
                }
            } catch (Exception e6) {
                e = e6;
                z4 = false;
                z5 = false;
            }
            if (this.ns == null) {
                RXLogging.e(TAG, "Failed to create the NoiseSuppressor instance");
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NoiseSuppressor: was ");
            sb2.append(z6 ? "enabled" : "disabled");
            sb2.append(", enable: ");
            sb2.append(z5);
            sb2.append(", is now: ");
            sb2.append(enabled3 ? "enabled" : "disabled");
            RXLogging.i(TAG, sb2.toString());
        }
    }

    public void release() {
        RXLogging.i(TAG, "release");
        try {
            AcousticEchoCanceler acousticEchoCanceler = this.aec;
            if (acousticEchoCanceler != null) {
                acousticEchoCanceler.release();
                this.aec = null;
            }
            NoiseSuppressor noiseSuppressor = this.ns;
            if (noiseSuppressor != null) {
                noiseSuppressor.release();
                this.ns = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.aec = null;
            this.ns = null;
        }
    }

    public boolean setAEC(boolean z) {
        RXLogging.i(TAG, "setAEC(" + z + ")");
        if (!canUseAcousticEchoCanceler()) {
            RXLogging.w(TAG, "Platform AEC is not supported");
            this.shouldEnableAec = false;
            return false;
        }
        if (this.aec == null || z == this.shouldEnableAec) {
            this.shouldEnableAec = z;
            return true;
        }
        RXLogging.e(TAG, "Platform AEC state can't be modified while recording");
        return false;
    }

    public boolean setNS(boolean z) {
        RXLogging.i(TAG, "setNS(" + z + ")");
        if (!canUseNoiseSuppressor()) {
            RXLogging.w(TAG, "Platform NS is not supported");
            this.shouldEnableNs = false;
            return false;
        }
        if (this.ns == null || z == this.shouldEnableNs) {
            this.shouldEnableNs = z;
            return true;
        }
        RXLogging.e(TAG, "Platform NS state can't be modified while recording");
        return false;
    }
}
