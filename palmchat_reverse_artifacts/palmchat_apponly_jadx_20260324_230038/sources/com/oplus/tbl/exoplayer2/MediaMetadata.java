package com.oplus.tbl.exoplayer2;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.util.Util;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class MediaMetadata {

    @Nullable
    public final String title;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {

        @Nullable
        private String title;

        public MediaMetadata build() {
            return new MediaMetadata(this.title);
        }

        public Builder setTitle(@Nullable String str) {
            this.title = str;
            return this;
        }
    }

    private MediaMetadata(@Nullable String str) {
        this.title = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaMetadata.class != obj.getClass()) {
            return false;
        }
        return Util.areEqual(this.title, ((MediaMetadata) obj).title);
    }

    public int hashCode() {
        String str = this.title;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }
}
