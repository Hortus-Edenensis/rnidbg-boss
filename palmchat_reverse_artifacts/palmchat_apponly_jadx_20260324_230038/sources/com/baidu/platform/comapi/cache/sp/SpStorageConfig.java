package com.baidu.platform.comapi.cache.sp;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class SpStorageConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4131a;
    private boolean b;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4132a;
        private boolean b;

        public Builder() {
            this(null);
        }

        public SpStorageConfig build() {
            return new SpStorageConfig(this.f4132a, this.b);
        }

        public Builder setCacheModel(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setStorageName(String str) {
            this.f4132a = str;
            return this;
        }

        public Builder(SpStorageConfig spStorageConfig) {
            if (spStorageConfig != null) {
                this.f4132a = spStorageConfig.f4131a;
                this.b = spStorageConfig.b;
            }
        }
    }

    public String getStorageName() {
        return this.f4131a;
    }

    public boolean isCacheModel() {
        return this.b;
    }

    private SpStorageConfig() {
    }

    private SpStorageConfig(String str, boolean z) {
        this.f4131a = str;
        this.b = z;
    }
}
