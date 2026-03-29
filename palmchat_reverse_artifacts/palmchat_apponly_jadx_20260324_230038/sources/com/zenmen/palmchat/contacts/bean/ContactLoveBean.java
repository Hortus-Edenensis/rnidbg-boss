package com.zenmen.palmchat.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ContactLoveBean implements Parcelable {
    public static final Parcelable.Creator<ContactLoveBean> CREATOR = new Parcelable.Creator<ContactLoveBean>() { // from class: com.zenmen.palmchat.contacts.bean.ContactLoveBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactLoveBean createFromParcel(Parcel parcel) {
            return new ContactLoveBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactLoveBean[] newArray(int i) {
            return new ContactLoveBean[i];
        }
    };
    private String recentQuestionAnswer;
    private String recentQuestionId;
    private String recentQuestionTitle;

    public ContactLoveBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getRecentQuestionAnswer() {
        return this.recentQuestionAnswer;
    }

    public String getRecentQuestionId() {
        return this.recentQuestionId;
    }

    public String getRecentQuestionTitle() {
        return this.recentQuestionTitle;
    }

    public void setRecentQuestionAnswer(String str) {
        this.recentQuestionAnswer = str;
    }

    public void setRecentQuestionId(String str) {
        this.recentQuestionId = str;
    }

    public void setRecentQuestionTitle(String str) {
        this.recentQuestionTitle = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.recentQuestionId);
        parcel.writeString(this.recentQuestionTitle);
        parcel.writeString(this.recentQuestionAnswer);
    }

    public ContactLoveBean(Parcel parcel) {
        this.recentQuestionId = parcel.readString();
        this.recentQuestionTitle = parcel.readString();
        this.recentQuestionAnswer = parcel.readString();
    }
}
