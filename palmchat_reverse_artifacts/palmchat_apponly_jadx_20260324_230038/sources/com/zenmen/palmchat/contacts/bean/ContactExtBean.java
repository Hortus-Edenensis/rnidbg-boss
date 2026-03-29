package com.zenmen.palmchat.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import defpackage.hs1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ContactExtBean implements Parcelable {
    public static final Parcelable.Creator<ContactExtBean> CREATOR = new Parcelable.Creator<ContactExtBean>() { // from class: com.zenmen.palmchat.contacts.bean.ContactExtBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactExtBean createFromParcel(Parcel parcel) {
            return new ContactExtBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactExtBean[] newArray(int i) {
            return new ContactExtBean[i];
        }
    };
    private Car car;
    private int chatMateType;
    private List<HobbyItem> fond;
    private HomeTown homeTown;
    private int income;
    private long initedTime;
    private int[] intention;
    private String[] likepersonality;
    private int occupation;
    private int official;
    private Amulet ornament;
    private String[] personality;
    private int prcRealName;
    private Realestate realestate;
    private Skip skip;
    private Vip vip;

    public ContactExtBean(Parcel parcel) {
        this.official = parcel.readInt();
        this.skip = (Skip) parcel.readParcelable(Skip.class.getClassLoader());
        this.vip = (Vip) parcel.readParcelable(Vip.class.getClassLoader());
        this.intention = parcel.createIntArray();
        this.occupation = parcel.readInt();
        this.income = parcel.readInt();
        this.initedTime = parcel.readLong();
        this.ornament = (Amulet) parcel.readParcelable(Amulet.class.getClassLoader());
        this.homeTown = (HomeTown) parcel.readParcelable(HomeTown.class.getClassLoader());
        this.personality = parcel.createStringArray();
        this.likepersonality = parcel.createStringArray();
        this.fond = parcel.createTypedArrayList(HobbyItem.CREATOR);
        this.realestate = (Realestate) parcel.readParcelable(Realestate.class.getClassLoader());
        this.car = (Car) parcel.readParcelable(Car.class.getClassLoader());
        this.prcRealName = parcel.readInt();
        this.chatMateType = parcel.readInt();
    }

    private ArrayList<String> getItemsForShow(String[] strArr, Map<String, String> map) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (strArr != null && strArr.length > 0 && map != null) {
            for (String str : strArr) {
                String str2 = map.get(str);
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Amulet getAmulet() {
        return this.ornament;
    }

    public Car getCar() {
        return this.car;
    }

    public int getChatMateType() {
        return this.chatMateType;
    }

    public List<HobbyItem> getFond() {
        return this.fond;
    }

    public String[] getFondForShow() {
        ArrayList arrayList = new ArrayList();
        List<HobbyItem> list = this.fond;
        if (list != null) {
            for (HobbyItem hobbyItem : list) {
                arrayList.addAll(getItemsForShow(hobbyItem.items, hs1.e().a().e.get(hobbyItem.key)));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public HomeTown getHomeTown() {
        return this.homeTown;
    }

    public String getHomeTownForShow() {
        return hs1.e().b(this.homeTown);
    }

    public int getIncome() {
        return this.income;
    }

    public String getIncomeForShow() {
        return hs1.e().d(getIncome());
    }

    public long getInitedTime() {
        return this.initedTime;
    }

    public int[] getIntention() {
        return this.intention;
    }

    public String[] getIntentionForShow() {
        int[] intention = getIntention();
        if (intention == null || intention.length <= 0) {
            return null;
        }
        String[] strArr = new String[intention.length];
        for (int i = 0; i < intention.length; i++) {
            strArr[i] = hs1.e().f(intention[i]);
        }
        return strArr;
    }

    @Deprecated
    public String[] getLikePersonalityForShow() {
        return getLikePersonalityForShow(false);
    }

    public String[] getLikepersonality() {
        return this.likepersonality;
    }

    public int getOccupation() {
        return this.occupation;
    }

    public String getOccupationForShow() {
        return hs1.e().h(getOccupation());
    }

    public int getOfficial() {
        return this.official;
    }

    public String[] getPersonality() {
        return this.personality;
    }

    @Deprecated
    public String[] getPersonalityForShow() {
        return getPersonalityForShow(false);
    }

    public int getPrcRealName() {
        return this.prcRealName;
    }

    public Realestate getRealestate() {
        return this.realestate;
    }

    public String getRealestateForShow() {
        Realestate realestate = this.realestate;
        if (realestate == null) {
            return null;
        }
        if (realestate.realestate != 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        hs1 hs1VarE = hs1.e();
        Realestate realestate2 = this.realestate;
        sb.append(hs1VarE.b(new HomeTown(realestate2.nation, realestate2.province, realestate2.city)));
        sb.append("有房");
        return sb.toString();
    }

    public Skip getSkip() {
        return this.skip;
    }

    public Vip getVip() {
        return this.vip;
    }

    public void setAmulet(Amulet amulet) {
        this.ornament = amulet;
    }

    public void setChatMateType(int i) {
        this.chatMateType = i;
    }

    public void setFond(List<HobbyItem> list) {
        this.fond = list;
    }

    public void setHomeTown(HomeTown homeTown) {
        this.homeTown = homeTown;
    }

    public void setIncome(int i) {
        this.income = i;
    }

    public void setInitedTime(long j) {
        this.initedTime = j;
    }

    public void setIntention(int[] iArr) {
        this.intention = iArr;
    }

    public void setLikepersonality(String[] strArr) {
        this.likepersonality = strArr;
    }

    public void setOccupation(int i) {
        this.occupation = i;
    }

    public void setOfficial(int i) {
        this.official = i;
    }

    public void setPersonality(String[] strArr) {
        this.personality = strArr;
    }

    public void setPrcRealName(int i) {
        this.prcRealName = i;
    }

    public void setRealestate(Realestate realestate) {
        this.realestate = realestate;
    }

    public void setSkip(Skip skip) {
        this.skip = skip;
    }

    public void setVip(Vip vip) {
        this.vip = vip;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.official);
        parcel.writeParcelable(this.skip, i);
        parcel.writeParcelable(this.vip, i);
        parcel.writeIntArray(this.intention);
        parcel.writeInt(this.occupation);
        parcel.writeInt(this.income);
        parcel.writeLong(this.initedTime);
        parcel.writeParcelable(this.ornament, i);
        parcel.writeParcelable(this.homeTown, i);
        parcel.writeStringArray(this.personality);
        parcel.writeStringArray(this.likepersonality);
        parcel.writeTypedList(this.fond);
        parcel.writeParcelable(this.realestate, i);
        parcel.writeParcelable(this.car, i);
        parcel.writeInt(this.prcRealName);
        parcel.writeInt(this.chatMateType);
    }

    public String[] getLikePersonalityForShow(boolean z) {
        return (String[]) getItemsForShow(getLikepersonality(), !z ? hs1.e().a().b : hs1.e().a().f18488a).toArray(new String[0]);
    }

    public String[] getPersonalityForShow(boolean z) {
        return (String[]) getItemsForShow(getPersonality(), !z ? hs1.e().a().d : hs1.e().a().c).toArray(new String[0]);
    }
}
