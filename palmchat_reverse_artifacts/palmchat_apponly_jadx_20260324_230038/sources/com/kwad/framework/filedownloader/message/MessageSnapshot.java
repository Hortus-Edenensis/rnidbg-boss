package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.framework.filedownloader.message.d;
import com.kwad.framework.filedownloader.message.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class MessageSnapshot implements Parcelable, c {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new Parcelable.Creator<MessageSnapshot>() { // from class: com.kwad.framework.filedownloader.message.MessageSnapshot.1
        /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static MessageSnapshot c(Parcel parcel) {
            MessageSnapshot jVar;
            MessageSnapshot messageSnapshot;
            boolean z = parcel.readByte() == 1;
            byte b2 = parcel.readByte();
            if (b2 == -4) {
                jVar = z ? new d.j(parcel) : new h.j(parcel);
            } else if (b2 == -3) {
                jVar = z ? new d.b(parcel) : new h.b(parcel);
            } else if (b2 == -1) {
                jVar = z ? new d.C0588d(parcel) : new h.d(parcel);
            } else if (b2 == 1) {
                jVar = z ? new d.f(parcel) : new h.f(parcel);
            } else if (b2 == 2) {
                jVar = z ? new d.c(parcel) : new h.c(parcel);
            } else if (b2 == 3) {
                jVar = z ? new d.g(parcel) : new h.g(parcel);
            } else if (b2 == 5) {
                jVar = z ? new d.h(parcel) : new h.C0589h(parcel);
            } else {
                if (b2 != 6) {
                    messageSnapshot = null;
                    if (messageSnapshot == null) {
                        messageSnapshot.asR = z;
                        return messageSnapshot;
                    }
                    throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) b2));
                }
                jVar = new b(parcel);
            }
            messageSnapshot = jVar;
            if (messageSnapshot == null) {
            }
        }

        private static MessageSnapshot[] cl(int i) {
            return new MessageSnapshot[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot[] newArray(int i) {
            return cl(i);
        }
    };
    protected boolean asR;
    private final int id;

    /* JADX INFO: compiled from: SearchBox */
    public static class NoFieldException extends IllegalStateException {
        public NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(com.kwad.framework.filedownloader.f.f.c("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.yn()), messageSnapshot.getClass().getName()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        MessageSnapshot Aw();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends MessageSnapshot {
        public b(int i) {
            super(i);
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte yn() {
            return (byte) 6;
        }

        public b(Parcel parcel) {
            super(parcel);
        }
    }

    public MessageSnapshot(int i) {
        this.id = i;
    }

    public boolean Ai() {
        throw new NoFieldException("isResuming", this);
    }

    public int Aq() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    public int Ar() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    public long As() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    public boolean At() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    public long Au() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    public Throwable Av() {
        throw new NoFieldException("getThrowable", this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEtag() {
        throw new NoFieldException("getEtag", this);
    }

    public String getFileName() {
        throw new NoFieldException("getFileName", this);
    }

    public final int getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.asR ? (byte) 1 : (byte) 0);
        parcel.writeByte(yn());
        parcel.writeInt(this.id);
    }

    public int yr() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    public final boolean yt() {
        return this.asR;
    }

    public MessageSnapshot(Parcel parcel) {
        this.id = parcel.readInt();
    }
}
