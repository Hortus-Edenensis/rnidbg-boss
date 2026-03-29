package defpackage;

import com.zenmen.square.comment.model.UserInfoItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface pi0 {
    String getCRCity();

    String getCRContent();

    long getCRId();

    int getCRLikeCnt();

    String getCRLocation();

    int getCRReplyCnt();

    long getCRTime();

    UserInfoItem getCRUser();

    int getDiscussionType();

    String getExToUid();

    long getToDiscussionId();

    String getToNickname();

    long getVersion();

    boolean isAuthor();

    boolean isAuthorLike();

    boolean isCRLike();

    boolean isMediaUser();

    void setCRCity(String str);

    void setCRContent(String str);

    void setCRId(long j);

    void setCRLike(boolean z);

    void setCRLikeCnt(int i);

    void setCRLocation(String str);

    void setCRReplyCnt(int i);

    void setCRTime(long j);

    void setCRUser(UserInfoItem userInfoItem);

    void setDiscussionType(int i);

    void setExToUid(String str);

    void setIsAuthor(boolean z);

    void setIsAuthorLike(boolean z);

    void setToDiscussionId(long j);

    void setToNickname(String str);

    void setVersion(long j);
}
