package com.opos.exoplayer.core.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Entry[] f8254a;

    /* JADX INFO: compiled from: SearchBox */
    public interface Entry extends Parcelable {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Parcelable.Creator<Metadata> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Metadata[] newArray(int i) {
            return new Metadata[0];
        }
    }

    public Metadata(Parcel parcel) {
        this.f8254a = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            Entry[] entryArr = this.f8254a;
            if (i >= entryArr.length) {
                return;
            }
            entryArr[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
            i++;
        }
    }

    public int a() {
        return this.f8254a.length;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f8254a, ((Metadata) obj).f8254a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f8254a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8254a.length);
        for (Entry entry : this.f8254a) {
            parcel.writeParcelable(entry, 0);
        }
    }

    public Metadata(List<? extends Entry> list) {
        if (list == null) {
            this.f8254a = new Entry[0];
            return;
        }
        Entry[] entryArr = new Entry[list.size()];
        this.f8254a = entryArr;
        list.toArray(entryArr);
    }

    public Entry a(int i) {
        return this.f8254a[i];
    }

    public Metadata(Entry... entryArr) {
        this.f8254a = entryArr == null ? new Entry[0] : entryArr;
    }
}
