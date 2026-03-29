package defpackage;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ju0 implements Key {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Key f18499a;
    public final Key b;

    public ju0(Key key, Key key2) {
        this.f18499a = key;
        this.b = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof ju0)) {
            return false;
        }
        ju0 ju0Var = (ju0) obj;
        return this.f18499a.equals(ju0Var.f18499a) && this.b.equals(ju0Var.b);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.f18499a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f18499a + ", signature=" + this.b + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f18499a.updateDiskCacheKey(messageDigest);
        this.b.updateDiskCacheKey(messageDigest);
    }
}
