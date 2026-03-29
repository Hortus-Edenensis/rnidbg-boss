package com.zenmen.palmchat.battery;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class BatterySaveConfig {
    private boolean test = false;
    private boolean masterSwitch = false;
    private boolean dcLogSwitch = false;
    private boolean getuiSwitch = false;
    private boolean ybaoSwitch = false;
    private boolean selfSwitch = false;
    private boolean wkSwitch = false;
    private boolean jiguangSwitch = false;
    private boolean mobSwitch = false;
    private boolean reConnectPolicySwitch = false;
    private boolean moveFrontSwitch = false;
    private boolean syncSwitch = false;
    private boolean alarmManagerSwitch = false;
    private boolean mdaSwitch = false;
    private boolean videoCallUdpSwitch = false;
    private boolean proguardReboot = false;

    public boolean isAlarmManagerSwitch() {
        return this.alarmManagerSwitch || this.test;
    }

    public boolean isDcLogSwitch() {
        return this.dcLogSwitch || this.test;
    }

    public boolean isGetuiSwitch() {
        return this.getuiSwitch || this.test;
    }

    public boolean isJiguangSwitch() {
        return this.jiguangSwitch;
    }

    public boolean isMasterSwitch() {
        return this.masterSwitch;
    }

    public boolean isMdaSwitch() {
        return this.mdaSwitch || this.test;
    }

    public boolean isMobSwitch() {
        return this.mobSwitch;
    }

    public boolean isMoveFrontSwitch() {
        return this.moveFrontSwitch || this.test;
    }

    public boolean isProguardReboot() {
        return this.proguardReboot || this.test;
    }

    public boolean isReConnectPolicySwitch() {
        return this.reConnectPolicySwitch || this.test;
    }

    public boolean isSelfSwitch() {
        return this.selfSwitch || this.test;
    }

    public boolean isSyncSwitch() {
        return this.syncSwitch || this.test;
    }

    public boolean isVideoCallUdpSwitch() {
        return this.videoCallUdpSwitch || this.test;
    }

    public boolean isWkSwitch() {
        return this.wkSwitch || this.test;
    }

    public boolean isYbaoSwitch() {
        return this.ybaoSwitch || this.test;
    }

    public void setAlarmManagerSwitch(boolean z) {
        this.alarmManagerSwitch = z;
    }

    public void setDcLogSwitch(boolean z) {
        this.dcLogSwitch = z;
    }

    public void setGetuiSwitch(boolean z) {
        this.getuiSwitch = z;
    }

    public void setJiguangSwitch(boolean z) {
        this.jiguangSwitch = z;
    }

    public void setMasterSwitch(boolean z) {
        this.masterSwitch = z;
    }

    public void setMdaSwitch(boolean z) {
        this.mdaSwitch = z;
    }

    public void setMobSwitch(boolean z) {
        this.mobSwitch = z;
    }

    public void setMoveFrontSwitch(boolean z) {
        this.moveFrontSwitch = z;
    }

    public void setProguardReboot(boolean z) {
        this.proguardReboot = z;
    }

    public void setReConnectPolicySwitch(boolean z) {
        this.reConnectPolicySwitch = z;
    }

    public void setSelfSwitch(boolean z) {
        this.selfSwitch = z;
    }

    public void setSyncSwitch(boolean z) {
        this.syncSwitch = z;
    }

    public void setVideoCallUdpSwitch(boolean z) {
        this.videoCallUdpSwitch = z;
    }

    public void setWkSwitch(boolean z) {
        this.wkSwitch = z;
    }

    public void setYbaoSwitch(boolean z) {
        this.ybaoSwitch = z;
    }

    public String toString() {
        return "BatterySaveConfig{test=" + this.test + ", masterSwitch=" + this.masterSwitch + ", dcLogSwitch=" + this.dcLogSwitch + ", getuiSwitch=" + this.getuiSwitch + ", ybaoSwitch=" + this.ybaoSwitch + ", selfSwitch=" + this.selfSwitch + ", wkSwitch=" + this.wkSwitch + ", reConnectPolicySwitch=" + this.reConnectPolicySwitch + ", moveFrontSwitch=" + this.moveFrontSwitch + ", syncSwitch=" + this.syncSwitch + ", alarmManagerSwitch=" + this.alarmManagerSwitch + ", mdaSwitch=" + this.mdaSwitch + ", videoCallUdpSwitch=" + this.videoCallUdpSwitch + '}';
    }
}
