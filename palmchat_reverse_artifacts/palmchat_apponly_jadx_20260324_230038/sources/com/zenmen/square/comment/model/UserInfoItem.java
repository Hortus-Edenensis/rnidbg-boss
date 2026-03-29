package com.zenmen.square.comment.model;

import android.text.TextUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import com.zenmen.square.comment.struct.SquareCommentBean;
import defpackage.az2;
import defpackage.dn0;
import defpackage.fg6;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class UserInfoItem implements Serializable {
    String accFrom;
    String bizId;
    int businessFrom;
    ContactExtBean contactExtBean;
    String country;
    String coverUrl;
    long createDt;
    private String exid;
    String firstLetter;
    private String headUrl;
    String hostUid;
    String introduce;
    boolean isRiskSafe;
    String language;
    String name;
    String registryDate;
    int sex;
    String thumbnailHeadUrl;
    private String uid;
    int verifiedType;
    String wid;

    public static UserInfoItem fromFansItem() {
        return new UserInfoItem();
    }

    public static UserInfoItem fromMessageBoxItem() {
        return new UserInfoItem();
    }

    public static UserInfoItem fromPbUser() {
        return new UserInfoItem();
    }

    public static UserInfoItem fromUserInfo(SquareCommentBean squareCommentBean) {
        ContactInfoItem contactInfoItemB;
        String nameForShow;
        ContactExtBean ext;
        UserInfoItem userInfoItem = new UserInfoItem();
        userInfoItem.setHeadUrl(squareCommentBean.headImgUrl);
        if (squareCommentBean.businessFrom == 1) {
            contactInfoItemB = dn0.a(squareCommentBean.exFromUid);
            userInfoItem.setUid(squareCommentBean.exFromUid);
        } else {
            contactInfoItemB = dn0.b(squareCommentBean.exFromUid);
            userInfoItem.setExid(squareCommentBean.exFromUid);
        }
        if (contactInfoItemB != null) {
            nameForShow = contactInfoItemB.getNameForShow();
            ext = contactInfoItemB.getExt();
        } else {
            nameForShow = null;
            ext = null;
        }
        if (TextUtils.isEmpty(nameForShow)) {
            nameForShow = squareCommentBean.nickname;
        }
        if (!fg6.q(fg6.g(ext))) {
            ext = (ContactExtBean) az2.a(squareCommentBean.userExt, ContactExtBean.class);
        }
        userInfoItem.setName(nameForShow);
        userInfoItem.setSex(squareCommentBean.sex);
        userInfoItem.setHostUid("");
        userInfoItem.setAccFrom("");
        userInfoItem.setRiskSafe(true);
        userInfoItem.setContactExtBean(ext);
        userInfoItem.wid = "";
        userInfoItem.verifiedType = 0;
        return userInfoItem;
    }

    public static UserInfoItem fromUserInfoItem(UserInfoItem userInfoItem) {
        UserInfoItem userInfoItem2 = new UserInfoItem();
        userInfoItem2.setHeadUrl(userInfoItem.getHeadUrl());
        userInfoItem2.setName(userInfoItem.name);
        userInfoItem2.setSex(userInfoItem.sex);
        userInfoItem2.setUid(userInfoItem.getUid());
        userInfoItem2.setExid(userInfoItem.getExid());
        userInfoItem2.setHostUid(userInfoItem.hostUid);
        userInfoItem2.setAccFrom(userInfoItem.getAccFrom());
        userInfoItem2.setRiskSafe(userInfoItem.isRiskSafe);
        userInfoItem2.setContactExtBean(userInfoItem.contactExtBean);
        userInfoItem2.wid = userInfoItem.wid;
        userInfoItem2.verifiedType = userInfoItem.verifiedType;
        return userInfoItem2;
    }

    public String getAccFrom() {
        return this.accFrom;
    }

    public int getBusinessFrom() {
        return this.businessFrom;
    }

    public ContactExtBean getContactExtBean() {
        return this.contactExtBean;
    }

    public String getExid() {
        return this.businessFrom == 1 ? this.uid : this.exid;
    }

    public String getHeadUrl() {
        return this.headUrl;
    }

    public String getHostUid() {
        return this.hostUid;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? "游客" : this.name;
    }

    public int getSex() {
        return this.sex;
    }

    public String getThumbnailHeadUrl() {
        return this.thumbnailHeadUrl;
    }

    public String getUid() {
        return this.uid;
    }

    public int getVerifiedType() {
        return this.verifiedType;
    }

    public String getWid() {
        return this.wid;
    }

    public boolean isRiskSafe() {
        return this.isRiskSafe;
    }

    public void setAccFrom(String str) {
        this.accFrom = str;
    }

    public void setBusinessFrom(int i) {
        this.businessFrom = i;
    }

    public void setContactExtBean(ContactExtBean contactExtBean) {
        this.contactExtBean = contactExtBean;
    }

    public void setExid(String str) {
        this.exid = str;
    }

    public void setHeadUrl(String str) {
        this.headUrl = str;
    }

    public void setHostUid(String str) {
        this.hostUid = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRiskSafe(boolean z) {
        this.isRiskSafe = z;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setThumbnailHeadUrl(String str) {
        this.thumbnailHeadUrl = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setVerifiedType(int i) {
        this.verifiedType = i;
    }

    public void setWid(String str) {
        this.wid = str;
    }

    public String toString() {
        return "UserModel{uid='" + this.uid + "', wid='" + this.wid + "', hostUid='" + this.hostUid + "', name='" + this.name + "', headUrl='" + this.headUrl + "', bizId='" + this.bizId + "', firstLetter='" + this.firstLetter + "', thumbnailHeadUrl='" + this.thumbnailHeadUrl + "', sex='" + this.sex + "', introduce='" + this.introduce + "', registryDate='" + this.registryDate + "', coverUrl='" + this.coverUrl + "', country='" + this.country + "', language='" + this.language + "', createDt=" + this.createDt + '}';
    }
}
