package defpackage;

import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.umeng.analytics.pro.bt;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.palmchat.contacts.ContactInfoItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class we2 {
    public static int d;
    public static Uri e = je2.f18392a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f21685a;
    public Context b;
    public LoaderManager.LoaderCallbacks<Cursor> c;

    public we2(Context context, long j) {
        this.b = context;
        this.f21685a = j;
        b();
    }

    public static boolean c(long j, long j2) {
        Cursor cursorQuery;
        boolean z = true;
        try {
            cursorQuery = RTCParameters.c().getContentResolver().query(je2.f18392a, null, "group_id=? ", new String[]{Long.toString(j)}, null);
        } catch (Exception unused) {
        }
        if (cursorQuery != null && cursorQuery.getCount() != 0) {
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("group_id"));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("group_member_state"));
                if (string.equals(Long.toString(j)) && string2.equals(Long.toString(j2)) && i == 1) {
                    com.zenmen.media.roomchat.a.e(new Intent("INTENT_ACTION_GROUPLOAD_MEMBER_INACTIVE"));
                } else if (string.equals(Long.toString(j)) && i == 0) {
                    ContactInfoItem contactInfoItem = new ContactInfoItem();
                    contactInfoItem.setUid(cursorQuery.getString(cursorQuery.getColumnIndex("name")));
                    contactInfoItem.setRemarkName(cursorQuery.getString(cursorQuery.getColumnIndex("remark_name")));
                    contactInfoItem.setRemarkFirstPinyin(cursorQuery.getString(cursorQuery.getColumnIndex("remark_name_first_pinyin")));
                    contactInfoItem.setRemarkAllPinyin(cursorQuery.getString(cursorQuery.getColumnIndex("remark_name_all_pinyin")));
                    contactInfoItem.setGroupRemarkName(cursorQuery.getString(cursorQuery.getColumnIndex(bt.s)));
                    contactInfoItem.setNickName(cursorQuery.getString(cursorQuery.getColumnIndex("nick_name")));
                    contactInfoItem.setFirstPinyin(cursorQuery.getString(cursorQuery.getColumnIndex("nick_name_first_pinyin")));
                    contactInfoItem.setAllPinyin(cursorQuery.getString(cursorQuery.getColumnIndex("nick_name_all_pinyin")));
                    contactInfoItem.setIconURL(cursorQuery.getString(cursorQuery.getColumnIndex("head_icon_url")));
                    ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItem.getUid());
                    if (contactInfoItemL != null) {
                        contactInfoItem.setBigIconURL(contactInfoItemL.getBigIconURL());
                    }
                    ct2.b(Long.parseLong(contactInfoItem.getUid()), contactInfoItem.getChatName(), 0, contactInfoItem.getIconURL(), contactInfoItem.getBigIconURL());
                }
            }
            cursorQuery.close();
            return z;
        }
        com.zenmen.media.roomchat.a.e(new Intent("INTENT_ACTION_GROUPLOAD_MEMBER_INACTIVE"));
        z = false;
        cursorQuery.close();
        return z;
    }

    public void b() {
        this.c = new a();
    }

    public final void d(Cursor cursor) {
        ct2.e();
        while (cursor.moveToNext()) {
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            contactInfoItem.setUid(cursor.getString(cursor.getColumnIndex("name")));
            contactInfoItem.setRemarkName(cursor.getString(cursor.getColumnIndex("remark_name")));
            contactInfoItem.setRemarkFirstPinyin(cursor.getString(cursor.getColumnIndex("remark_name_first_pinyin")));
            contactInfoItem.setRemarkAllPinyin(cursor.getString(cursor.getColumnIndex("remark_name_all_pinyin")));
            contactInfoItem.setGroupRemarkName(cursor.getString(cursor.getColumnIndex(bt.s)));
            contactInfoItem.setNickName(cursor.getString(cursor.getColumnIndex("nick_name")));
            contactInfoItem.setFirstPinyin(cursor.getString(cursor.getColumnIndex("nick_name_first_pinyin")));
            contactInfoItem.setAllPinyin(cursor.getString(cursor.getColumnIndex("nick_name_all_pinyin")));
            contactInfoItem.setIconURL(cursor.getString(cursor.getColumnIndex("head_icon_url")));
            ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItem.getUid());
            if (contactInfoItemL != null) {
                contactInfoItem.setBigIconURL(contactInfoItemL.getBigIconURL());
            }
            ct2.b(Long.parseLong(contactInfoItem.getUid()), contactInfoItem.getChatName(), 0, contactInfoItem.getIconURL(), contactInfoItem.getBigIconURL());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements LoaderManager.LoaderCallbacks<Cursor> {
        public a() {
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
            if (loader.getId() == we2.d) {
                we2.this.d(cursor);
                com.zenmen.media.roomchat.a.e(new Intent("INTENT_ACTION_GROUPLOAD_FINISH"));
            }
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            return new CursorLoader(we2.this.b, je2.f18392a, null, "group_id=? and group_member_state=?", new String[]{Long.toString(we2.this.f21685a), Integer.toString(0)}, null);
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<Cursor> loader) {
        }
    }
}
