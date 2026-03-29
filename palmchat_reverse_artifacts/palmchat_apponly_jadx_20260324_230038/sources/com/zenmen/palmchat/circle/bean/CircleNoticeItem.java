package com.zenmen.palmchat.circle.bean;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.CircleNotice;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import defpackage.az2;
import defpackage.ho3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleNoticeItem implements Parcelable {
    public static final Parcelable.Creator<CircleNoticeItem> CREATOR = new Parcelable.Creator<CircleNoticeItem>() { // from class: com.zenmen.palmchat.circle.bean.CircleNoticeItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CircleNoticeItem createFromParcel(Parcel parcel) {
            return new CircleNoticeItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CircleNoticeItem[] newArray(int i) {
            return new CircleNoticeItem[i];
        }
    };
    public static final String KEY_THREAD_HAS_NOTICE = "key_thread_has_notice_of_";
    public static final int STATUS_AUDITING = 1;
    public static final int STATUS_DELETE = 9;
    public static final int STATUS_LOCAL_SHOW_ALREADY = 1;
    public static final int STATUS_LOCAL_SHOW_NEVER = 0;
    public static final int STATUS_NORMAL = 2;
    public static final int STATUS_REJECT = 3;
    public static final int TYPE_CONFIRM_NEED = 1;
    public static final int TYPE_CONFIRM_NOT_NEED = 0;
    private String authorId;
    private String authorNickname;
    private String avatarUrl;
    private int confirm;
    private int confirmCount;
    private String content;
    private int localShowStatus;
    private int mediaType;
    private String mediaUrl;
    private List<CircleMemberItem> membersList;
    private long noticeId;
    private int readCount;
    private long releaseTime;
    private String rid;
    private int status;
    private int toTop;
    private int topChatWindow;

    public CircleNoticeItem() {
    }

    public static void circleThreadHasNoticeStatus(String str, int i) {
        SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).edit().putInt(KEY_THREAD_HAS_NOTICE + AccountUtils.p(AppContext.getContext()) + "_" + str, i).apply();
    }

    public static int getCircleThreadHasNoticeStatus(String str) {
        return SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).getInt(KEY_THREAD_HAS_NOTICE + AccountUtils.p(AppContext.getContext()) + "_" + str, 0);
    }

    private static CircleNoticeItem getItemFromCursor(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        CircleNoticeItem circleNoticeItem = new CircleNoticeItem();
        String string = cursor.getString(cursor.getColumnIndex("msg_extend"));
        if (TextUtils.isEmpty(string)) {
            return circleNoticeItem;
        }
        try {
            return (CircleNoticeItem) new Gson().fromJson(new JSONObject(string).optJSONObject("notice").toString(), CircleNoticeItem.class);
        } catch (Exception unused) {
            return circleNoticeItem;
        }
    }

    public static CircleNoticeItem getLatestCircleNote(String str) {
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.a(ho3.class, 0), null, "contact_relate=? and msg_type=?", new String[]{str + DomainHelper.Domains.DOMAIN_GROUPCHAT.domain, String.valueOf(53)}, "_id DESC");
        CircleNoticeItem circleNoticeItem = null;
        if (cursorQuery != null) {
            if (cursorQuery.moveToNext()) {
                CircleNoticeItem itemFromCursor = getItemFromCursor(cursorQuery);
                if (itemFromCursor.getStatus() != 3 && itemFromCursor.getStatus() != 9) {
                    circleNoticeItem = itemFromCursor;
                }
            }
            cursorQuery.close();
        }
        return circleNoticeItem;
    }

    public static ArrayList<CircleNoticeItem> getLatestCircleNotes(String str) {
        Set<String> setLocalShownNoticeIds = localShownNoticeIds();
        String[] strArr = {str + DomainHelper.Domains.DOMAIN_GROUPCHAT.domain, String.valueOf(53)};
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.a(ho3.class, 0), null, "contact_relate=? and msg_type=?", strArr, "_id DESC");
        if (cursorQuery == null) {
            return null;
        }
        ArrayList<CircleNoticeItem> arrayList = new ArrayList<>();
        while (cursorQuery.moveToNext()) {
            CircleNoticeItem itemFromCursor = getItemFromCursor(cursorQuery);
            long noticeId = itemFromCursor.getNoticeId();
            if (itemFromCursor.getStatus() == 9) {
                hashSet2.add(Long.valueOf(noticeId));
            } else if (itemFromCursor.getStatus() == 2 && !hashSet.contains(Long.valueOf(noticeId)) && !hashSet2.contains(Long.valueOf(noticeId)) && (setLocalShownNoticeIds == null || !setLocalShownNoticeIds.contains(String.valueOf(noticeId)))) {
                arrayList.add(itemFromCursor);
                hashSet.add(Long.valueOf(noticeId));
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    public static boolean isInvalidateCircleNotice(ContentValues contentValues) {
        CircleNotice circleNotice;
        if (contentValues == null || !contentValues.containsKey("msg_type") || contentValues.getAsInteger("msg_type").intValue() != 53 || !contentValues.containsKey("msg_extend")) {
            return false;
        }
        String asString = contentValues.getAsString("msg_extend");
        return (TextUtils.isEmpty(asString) || (circleNotice = (CircleNotice) az2.a(asString, CircleNotice.class)) == null || circleNotice.getNotice() == null || circleNotice.getNotice().getStatus() == 2) ? false : true;
    }

    public static Set<String> localShownNoticeIds() {
        return SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).getStringSet("key_circle_notice_local_show_status_of_" + AccountUtils.p(AppContext.getContext()), null);
    }

    public static void markLocalShownStatus(long j) {
        String str = "key_circle_notice_local_show_status_of_" + AccountUtils.p(AppContext.getContext());
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CIRCLE;
        HashSet hashSet = new HashSet(sPUtil.m(scene).getStringSet(str, new HashSet()));
        if (hashSet.contains(String.valueOf(j))) {
            return;
        }
        hashSet.add(String.valueOf(j));
        sPUtil.m(scene).edit().putStringSet(str, new HashSet(hashSet)).apply();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    public String getAuthorNickname() {
        return this.authorNickname;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getConfirm() {
        return this.confirm;
    }

    public int getConfirmCount() {
        return this.confirmCount;
    }

    public String getContent() {
        return this.content;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getMediaUrl() {
        return this.mediaUrl;
    }

    public List<CircleMemberItem> getMembersList() {
        return this.membersList;
    }

    public long getNoticeId() {
        return this.noticeId;
    }

    public int getReadCount() {
        return this.readCount;
    }

    public long getReleaseTime() {
        return this.releaseTime;
    }

    public String getRid() {
        return this.rid;
    }

    public int getStatus() {
        return this.status;
    }

    public int getToTop() {
        return this.toTop;
    }

    public int getTopChatWindow() {
        return this.topChatWindow;
    }

    public void setAuthorId(String str) {
        this.authorId = str;
    }

    public void setAuthorNickname(String str) {
        this.authorNickname = str;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setConfirm(int i) {
        this.confirm = i;
    }

    public void setConfirmCount(int i) {
        this.confirmCount = i;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setMediaType(int i) {
        this.mediaType = i;
    }

    public void setMediaUrl(String str) {
        this.mediaUrl = str;
    }

    public void setMembersList(List<CircleMemberItem> list) {
        this.membersList = list;
    }

    public void setNoticeId(long j) {
        this.noticeId = j;
    }

    public void setReadCount(int i) {
        this.readCount = i;
    }

    public void setReleaseTime(long j) {
        this.releaseTime = j;
    }

    public void setRid(String str) {
        this.rid = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setToTop(int i) {
        this.toTop = i;
    }

    public void setTopChatWindow(int i) {
        this.topChatWindow = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.avatarUrl);
        parcel.writeString(this.rid);
        parcel.writeLong(this.noticeId);
        parcel.writeString(this.content);
        parcel.writeInt(this.mediaType);
        parcel.writeString(this.mediaUrl);
        parcel.writeInt(this.confirm);
        parcel.writeInt(this.toTop);
        parcel.writeInt(this.topChatWindow);
        parcel.writeString(this.authorId);
        parcel.writeString(this.authorNickname);
        parcel.writeLong(this.releaseTime);
        parcel.writeInt(this.readCount);
        parcel.writeInt(this.confirmCount);
        parcel.writeInt(this.status);
        parcel.writeTypedList(this.membersList);
    }

    public CircleNoticeItem(Parcel parcel) {
        this.avatarUrl = parcel.readString();
        this.rid = parcel.readString();
        this.noticeId = parcel.readLong();
        this.content = parcel.readString();
        this.mediaType = parcel.readInt();
        this.mediaUrl = parcel.readString();
        this.confirm = parcel.readInt();
        this.toTop = parcel.readInt();
        this.topChatWindow = parcel.readInt();
        this.authorId = parcel.readString();
        this.authorNickname = parcel.readString();
        this.releaseTime = parcel.readLong();
        this.readCount = parcel.readInt();
        this.confirmCount = parcel.readInt();
        this.status = parcel.readInt();
        this.membersList = parcel.createTypedArrayList(CircleMemberItem.CREATOR);
    }
}
