package com.umeng.umcrash;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IUMCrashCallbackWithType {

    /* JADX INFO: compiled from: SearchBox */
    public enum CrashType {
        CRASH_TYPE_NATIVE(1),
        CRASH_TYPE_JAVA(2),
        CRASH_TYPE_ANR(3),
        CRASH_TYPE_BLOCK(4),
        CRASH_TYPE_CUSTOM_LOG(5);

        int mType;

        CrashType(int i) {
            this.mType = i;
        }

        public int getType() {
            return this.mType;
        }
    }

    String onCallback(CrashType crashType);
}
