package com.zenmen.palmchat.greendao.model;

import com.zenmen.palmchat.greendao.greendaogen.UnreadMessageDao;
import defpackage.yt0;
import org.greenrobot.greendao.DaoException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class UnreadMessage {
    private long createTime;
    private transient yt0 daoSession;
    private int deleted;
    private String extension;
    private Long id;
    private String mid;
    private transient UnreadMessageDao myDao;
    private int read;
    private int subType;

    public UnreadMessage(Long l, String str, long j, int i, String str2, int i2, int i3) {
        this.id = l;
        this.mid = str;
        this.createTime = j;
        this.subType = i;
        this.extension = str2;
        this.deleted = i2;
        this.read = i3;
    }

    public void __setDaoSession(yt0 yt0Var) {
        this.daoSession = yt0Var;
        this.myDao = yt0Var != null ? yt0Var.d() : null;
    }

    public void delete() {
        UnreadMessageDao unreadMessageDao = this.myDao;
        if (unreadMessageDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        unreadMessageDao.delete(this);
    }

    public Long getCreateTime() {
        return Long.valueOf(this.createTime);
    }

    public int getDeleted() {
        return this.deleted;
    }

    public String getExtension() {
        return this.extension;
    }

    public Long getId() {
        return this.id;
    }

    public String getMid() {
        return this.mid;
    }

    public int getRead() {
        return this.read;
    }

    public Integer getSubType() {
        return Integer.valueOf(this.subType);
    }

    public boolean hasDeleted() {
        return this.deleted == 1;
    }

    public boolean hasRead() {
        return this.read == 1;
    }

    public void refresh() {
        UnreadMessageDao unreadMessageDao = this.myDao;
        if (unreadMessageDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        unreadMessageDao.refresh(this);
    }

    public void setCreateTime(Long l) {
        this.createTime = l.longValue();
    }

    public void setDeleted(int i) {
        this.deleted = i;
    }

    public void setExtension(String str) {
        this.extension = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public void setRead(int i) {
        this.read = i;
    }

    public void setSubType(Integer num) {
        this.subType = num.intValue();
    }

    public void update() {
        UnreadMessageDao unreadMessageDao = this.myDao;
        if (unreadMessageDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        unreadMessageDao.update(this);
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setSubType(int i) {
        this.subType = i;
    }

    public UnreadMessage() {
    }
}
