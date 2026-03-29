package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[][] f20041a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<GifViewSavedState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GifViewSavedState createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GifViewSavedState[] newArray(int i) {
            return new GifViewSavedState[i];
        }
    }

    public /* synthetic */ GifViewSavedState(Parcel parcel, a aVar) {
        this(parcel);
    }

    public void a(Drawable drawable, int i) {
        if (this.f20041a[i] == null || !(drawable instanceof pl.droidsonroids.gif.a)) {
            return;
        }
        ((pl.droidsonroids.gif.a) drawable).j(r3.g.x(r4, r3.f));
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f20041a.length);
        for (long[] jArr : this.f20041a) {
            parcel.writeLongArray(jArr);
        }
    }

    public GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f20041a = new long[drawableArr.length][];
        for (int i = 0; i < drawableArr.length; i++) {
            Drawable drawable = drawableArr[i];
            if (drawable instanceof pl.droidsonroids.gif.a) {
                this.f20041a[i] = ((pl.droidsonroids.gif.a) drawable).g.m();
            } else {
                this.f20041a[i] = null;
            }
        }
    }

    public GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.f20041a = new long[parcel.readInt()][];
        int i = 0;
        while (true) {
            long[][] jArr = this.f20041a;
            if (i >= jArr.length) {
                return;
            }
            jArr[i] = parcel.createLongArray();
            i++;
        }
    }

    public GifViewSavedState(Parcelable parcelable, long[] jArr) {
        super(parcelable);
        this.f20041a = new long[][]{jArr};
    }
}
