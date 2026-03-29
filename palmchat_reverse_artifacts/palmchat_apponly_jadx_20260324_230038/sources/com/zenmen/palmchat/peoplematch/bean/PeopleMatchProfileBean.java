package com.zenmen.palmchat.peoplematch.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class PeopleMatchProfileBean extends PeopleMatchCardBean {
    public static final Parcelable.Creator<PeopleMatchProfileBean> CREATOR = new Parcelable.Creator<PeopleMatchProfileBean>() { // from class: com.zenmen.palmchat.peoplematch.bean.PeopleMatchProfileBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeopleMatchProfileBean createFromParcel(Parcel parcel) {
            return new PeopleMatchProfileBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeopleMatchProfileBean[] newArray(int i) {
            return new PeopleMatchProfileBean[i];
        }
    };
    private int allowPictureNum;
    private int maxAge;
    private double maxQueryDist;
    private int minAge;
    private PeopleMatchPrivilegeInfo privilegeInfo;
    private Signature signature;

    /* JADX INFO: compiled from: SearchBox */
    public static class PeopleMatchPrivilegeInfo implements Parcelable {
        public static final Parcelable.Creator<PeopleMatchPrivilegeInfo> CREATOR = new Parcelable.Creator<PeopleMatchPrivilegeInfo>() { // from class: com.zenmen.palmchat.peoplematch.bean.PeopleMatchProfileBean.PeopleMatchPrivilegeInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PeopleMatchPrivilegeInfo createFromParcel(Parcel parcel) {
                return new PeopleMatchPrivilegeInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PeopleMatchPrivilegeInfo[] newArray(int i) {
                return new PeopleMatchPrivilegeInfo[i];
            }
        };
        private String buttonName;
        private String privilegeText;

        public PeopleMatchPrivilegeInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getButtonName() {
            return this.buttonName;
        }

        public String getPrivilegeText() {
            return this.privilegeText;
        }

        public void setButtonName(String str) {
            this.buttonName = str;
        }

        public void setPrivilegeText(String str) {
            this.privilegeText = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.buttonName);
            parcel.writeString(this.privilegeText);
        }

        public PeopleMatchPrivilegeInfo(Parcel parcel) {
            this.buttonName = parcel.readString();
            this.privilegeText = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Signature implements Parcelable {
        public static final Parcelable.Creator<Signature> CREATOR = new Parcelable.Creator<Signature>() { // from class: com.zenmen.palmchat.peoplematch.bean.PeopleMatchProfileBean.Signature.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Signature createFromParcel(Parcel parcel) {
                return new Signature(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Signature[] newArray(int i) {
                return new Signature[i];
            }
        };
        private String content;
        private int status;

        public Signature() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getContent() {
            return this.content;
        }

        public int getStatus() {
            return this.status;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.content);
            parcel.writeInt(this.status);
        }

        public Signature(Parcel parcel) {
            this.content = parcel.readString();
            this.status = parcel.readInt();
        }
    }

    public PeopleMatchProfileBean() {
    }

    public int getAllowPictureNum() {
        return this.allowPictureNum;
    }

    public int getMaxAge() {
        return this.maxAge;
    }

    public double getMaxQueryDist() {
        return this.maxQueryDist;
    }

    public int getMinAge() {
        return this.minAge;
    }

    public PeopleMatchPrivilegeInfo getPrivilegeInfo() {
        return this.privilegeInfo;
    }

    public Signature getSignature() {
        return this.signature;
    }

    public boolean isShowBirthday() {
        return this.isShowBirthday;
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }

    public void setAllowPictureNum(int i) {
        this.allowPictureNum = i;
    }

    public void setMaxAge(int i) {
        this.maxAge = i;
    }

    public void setMaxQueryDist(double d) {
        this.maxQueryDist = d;
    }

    public void setMinAge(int i) {
        this.minAge = i;
    }

    public void setPrivilegeInfo(PeopleMatchPrivilegeInfo peopleMatchPrivilegeInfo) {
        this.privilegeInfo = peopleMatchPrivilegeInfo;
    }

    public void setShowBirthday(boolean z) {
        this.isShowBirthday = z;
    }

    public void setShowLocation(boolean z) {
        this.isShowLocation = z;
    }

    public void setSignature(Signature signature) {
        this.signature = signature;
    }

    @Override // com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.allowPictureNum);
        parcel.writeInt(this.isShowBirthday ? 1 : 0);
        parcel.writeInt(this.isShowLocation ? 1 : 0);
        parcel.writeParcelable(this.signature, i);
        parcel.writeDouble(this.maxQueryDist);
        parcel.writeInt(this.minAge);
        parcel.writeInt(this.maxAge);
        parcel.writeParcelable(this.privilegeInfo, i);
    }

    public PeopleMatchProfileBean(Parcel parcel) {
        super(parcel);
        this.allowPictureNum = parcel.readInt();
        this.isShowBirthday = parcel.readInt() == 1;
        this.isShowLocation = parcel.readInt() == 1;
        this.signature = (Signature) parcel.readParcelable(getClass().getClassLoader());
        this.maxQueryDist = parcel.readDouble();
        this.minAge = parcel.readInt();
        this.maxAge = parcel.readInt();
        this.privilegeInfo = (PeopleMatchPrivilegeInfo) parcel.readParcelable(getClass().getClassLoader());
    }
}
