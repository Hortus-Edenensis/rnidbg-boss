package com.google.common.cache;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class RemovalCause {
    public static final RemovalCause EXPLICIT = new a("EXPLICIT", 0);
    public static final RemovalCause REPLACED = new RemovalCause("REPLACED", 1) { // from class: com.google.common.cache.RemovalCause.b
        {
            a aVar = null;
        }

        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return false;
        }
    };
    public static final RemovalCause COLLECTED = new RemovalCause("COLLECTED", 2) { // from class: com.google.common.cache.RemovalCause.c
        {
            a aVar = null;
        }

        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    };
    public static final RemovalCause EXPIRED = new RemovalCause("EXPIRED", 3) { // from class: com.google.common.cache.RemovalCause.d
        {
            a aVar = null;
        }

        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    };
    public static final RemovalCause SIZE = new RemovalCause("SIZE", 4) { // from class: com.google.common.cache.RemovalCause.e
        {
            a aVar = null;
        }

        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    };
    private static final /* synthetic */ RemovalCause[] $VALUES = $values();

    /* JADX INFO: compiled from: SearchBox */
    public enum a extends RemovalCause {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return false;
        }
    }

    private static /* synthetic */ RemovalCause[] $values() {
        return new RemovalCause[]{EXPLICIT, REPLACED, COLLECTED, EXPIRED, SIZE};
    }

    private RemovalCause(String str, int i) {
    }

    public static RemovalCause valueOf(String str) {
        return (RemovalCause) Enum.valueOf(RemovalCause.class, str);
    }

    public static RemovalCause[] values() {
        return (RemovalCause[]) $VALUES.clone();
    }

    public abstract boolean wasEvicted();

    public /* synthetic */ RemovalCause(String str, int i, a aVar) {
        this(str, i);
    }
}
