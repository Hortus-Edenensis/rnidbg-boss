package com.zenmen.palmchat.maintab.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.k86;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class TabItem implements Parcelable, Cloneable {
    public static final Parcelable.Creator<TabItem> CREATOR = new a();
    public String appId;
    public List<GroupItem> groups;
    public String icon;
    public String invisibleModel;
    public boolean isDisabled = false;
    public boolean isIgnore = false;
    public String kitCode;
    public String name;
    public String nameEn;
    public String selectedColor;
    public String selectedIcon;
    public String tag;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<TabItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TabItem createFromParcel(Parcel parcel) {
            return new TabItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TabItem[] newArray(int i) {
            return new TabItem[i];
        }
    }

    public TabItem(String str, String str2, String str3, String str4, List<GroupItem> list) {
        this.name = str;
        this.nameEn = str2;
        this.kitCode = str3;
        this.tag = str4;
        this.groups = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getNameForShow() {
        return k86.G() ? this.name : this.nameEn;
    }

    public boolean isAdditionalTab() {
        return isVideoTab() || isDirectJumpTab();
    }

    public boolean isDirectJumpTab() {
        String str = this.tag;
        return str != null && (str.equals("tab_square_publish") || this.tag.equals("tab_people_match_jump"));
    }

    public boolean isEnable() {
        return !this.isDisabled;
    }

    public boolean isFindFriendTab() {
        String str = this.tag;
        return str != null && str.equals("tab_find_friend");
    }

    public boolean isMsgTab() {
        String str = this.tag;
        return str != null && str.equals("tab_msg");
    }

    public boolean isPeopleMatchTab() {
        String str = this.tag;
        return str != null && str.equals("tab_people_match");
    }

    public boolean isSame(TabItem tabItem) {
        return false;
    }

    public boolean isSquarePublishTab() {
        String str = this.tag;
        return str != null && str.equals("tab_square_publish");
    }

    public boolean isSquareTab() {
        String str = this.tag;
        return str != null && str.equals("tab_square");
    }

    public boolean isVideoTab() {
        String str = this.tag;
        return str != null && str.equals("tab_small_video");
    }

    public void jump() {
        if (TextUtils.isEmpty(this.kitCode)) {
            return;
        }
        LogUtil.uploadInfoImmediate(this.kitCode, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.nameEn);
        parcel.writeString(this.kitCode);
        parcel.writeString(this.icon);
        parcel.writeString(this.selectedIcon);
        parcel.writeString(this.selectedColor);
        parcel.writeString(this.tag);
        parcel.writeString(this.invisibleModel);
        parcel.writeString(this.appId);
        parcel.writeTypedList(this.groups);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TabItem m793clone() {
        TabItem tabItem;
        CloneNotSupportedException e;
        try {
            tabItem = (TabItem) super.clone();
        } catch (CloneNotSupportedException e2) {
            tabItem = null;
            e = e2;
        }
        try {
            if (this.groups != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.groups);
                tabItem.groups = arrayList;
            }
        } catch (CloneNotSupportedException e3) {
            e = e3;
            e.printStackTrace();
        }
        return tabItem;
    }

    public TabItem(Parcel parcel) {
        this.name = parcel.readString();
        this.nameEn = parcel.readString();
        this.kitCode = parcel.readString();
        this.icon = parcel.readString();
        this.selectedIcon = parcel.readString();
        this.selectedColor = parcel.readString();
        this.tag = parcel.readString();
        this.invisibleModel = parcel.readString();
        this.appId = parcel.readString();
        this.groups = parcel.createTypedArrayList(GroupItem.CREATOR);
    }
}
