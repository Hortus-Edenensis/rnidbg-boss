package defpackage;

import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.ad.constant.bq;
import com.litesuits.async.AsyncTask;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.h;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bn2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class nk3 extends Observable {
    public static volatile nk3 c = null;
    public static int d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bn2.b f19526a = new bn2.b();
    public Handler b = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AsyncTask<Integer, Void, bn2.b> {

        /* JADX INFO: renamed from: nk3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1251a implements Comparator<MediaItem> {
            public C1251a() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(MediaItem mediaItem, MediaItem mediaItem2) {
                return Long.valueOf(mediaItem2.modifyTime).compareTo(Long.valueOf(mediaItem.modifyTime));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Comparator<MediaItem> {
            public b() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(MediaItem mediaItem, MediaItem mediaItem2) {
                return Long.valueOf(mediaItem2.modifyTime).compareTo(Long.valueOf(mediaItem.modifyTime));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements Comparator<MediaItem> {
            public c() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(MediaItem mediaItem, MediaItem mediaItem2) {
                return Long.valueOf(mediaItem2.modifyTime).compareTo(Long.valueOf(mediaItem.modifyTime));
            }
        }

        public a() {
        }

        @Override // com.litesuits.async.AsyncTask
        public void o() {
            LogUtil.i("MediaPickHelpers", "onPreExecute");
        }

        /* JADX WARN: Removed duplicated region for block: B:162:0x0474  */
        /* JADX WARN: Removed duplicated region for block: B:165:0x0485  */
        /* JADX WARN: Removed duplicated region for block: B:168:0x04a6  */
        /* JADX WARN: Removed duplicated region for block: B:172:0x04e3  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x04e7  */
        /* JADX WARN: Removed duplicated region for block: B:177:0x0509  */
        /* JADX WARN: Removed duplicated region for block: B:184:0x054f  */
        /* JADX WARN: Removed duplicated region for block: B:188:0x058c  */
        /* JADX WARN: Removed duplicated region for block: B:189:0x0590  */
        /* JADX WARN: Removed duplicated region for block: B:193:0x05b2  */
        /* JADX WARN: Removed duplicated region for block: B:200:0x05ff  */
        /* JADX WARN: Removed duplicated region for block: B:214:0x069f  */
        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public bn2.b g(Integer... numArr) {
            int i;
            int i2;
            String str;
            Uri uri;
            String[] strArr;
            Cursor cursorQuery;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            long j;
            String str8;
            String str9;
            ArrayList<MediaItem> arrayList;
            boolean z;
            a aVar;
            ArrayList arrayList2;
            int i3;
            int i4;
            int i5;
            int i6;
            String str10;
            Cursor cursorQuery2;
            ArrayList<MediaItem> arrayList3;
            boolean z2;
            StringBuilder sb;
            int count;
            String str11 = "duration";
            bn2.b bVar = new bn2.b();
            int iIntValue = numArr[0].intValue();
            bVar.f1774a = iIntValue;
            int i7 = iIntValue & 2;
            String str12 = "MediaPickHelpers";
            String str13 = "bucket_display_name";
            String str14 = "bucket_id";
            String str15 = "_size";
            String str16 = "date_modified";
            String str17 = "_display_name";
            String str18 = "_data";
            ArrayList arrayList4 = new ArrayList();
            String str19 = "_id";
            String str20 = "height";
            String str21 = "width";
            if (i7 == 2) {
                try {
                    uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    strArr = new String[]{"_id", "_data", "_display_name", "date_modified", "_size", "bucket_id", "bucket_display_name"};
                    i2 = i7;
                } catch (Exception e) {
                    e = e;
                    i = iIntValue;
                    i2 = i7;
                }
                try {
                    Pair<String, String[]> pairJ = nk3.this.j((iIntValue & 1) == 1);
                    try {
                        cursorQuery = AppContext.getContext().getContentResolver().query(uri, strArr, (String) pairJ.first, (String[]) pairJ.second, "date_modified DESC");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("loadImage size");
                        sb2.append(cursorQuery != null ? cursorQuery.getCount() : 0);
                        LogUtil.i("MediaPickHelpers", sb2.toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        cursorQuery = null;
                    }
                    while (cursorQuery != null) {
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        int i8 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(str18));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(str17));
                        str = str12;
                        try {
                            str6 = str16;
                            str7 = str18;
                            j = cursorQuery.getLong(cursorQuery.getColumnIndex(str16));
                            str8 = str17;
                            i = iIntValue;
                        } catch (Exception e3) {
                            e = e3;
                            i = iIntValue;
                            aVar = this;
                            arrayList2 = arrayList4;
                            e.printStackTrace();
                            i3 = i2;
                            if (i3 == 2) {
                            }
                            i4 = i & 4;
                            if (i4 == 4) {
                            }
                            Collections.sort(bVar.b.f1773a, aVar.new c());
                            int i9 = R.string.photo_grid_all;
                            if (i3 == 2) {
                                HashMap map = new HashMap();
                                bn2.c cVar = new bn2.c();
                                cVar.b = bVar.c.f1773a.get(0).fileID;
                                cVar.d = bVar.c.f1773a.get(0).fileFullPath;
                                cVar.c = AppContext.getContext().getResources().getString(i4 != 4 ? R.string.photo_grid_all : R.string.photo_grid_all_image);
                                bVar.c.b.clear();
                                bVar.c.b.add(cVar);
                                while (i6 < bVar.c.f1773a.size()) {
                                }
                            }
                            if (i4 == 4) {
                                HashMap map2 = new HashMap();
                                bn2.c cVar2 = new bn2.c();
                                cVar2.b = bVar.d.f1773a.get(0).fileID;
                                cVar2.d = bVar.d.f1773a.get(0).fileFullPath;
                                cVar2.c = AppContext.getContext().getResources().getString(i4 != 4 ? R.string.photo_grid_all : R.string.photo_grid_all_image);
                                bVar.d.b.clear();
                                bVar.d.b.add(cVar2);
                                while (i5 < bVar.d.f1773a.size()) {
                                }
                            }
                            if (!bVar.b.f1773a.isEmpty()) {
                            }
                            if (arrayList2.size() != 0) {
                            }
                            return bVar;
                        }
                        try {
                            long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
                            int i10 = cursorQuery.getInt(cursorQuery.getColumnIndex("bucket_id"));
                            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("bucket_display_name"));
                            if (j2 == 0 || TextUtils.isEmpty(string)) {
                                str9 = str11;
                            } else {
                                str9 = str11;
                                if (new File(string).exists()) {
                                    MediaItem mediaItem = new MediaItem();
                                    mediaItem.fileID = i8;
                                    mediaItem.fileFullPath = string;
                                    mediaItem.fileName = string2;
                                    mediaItem.modifyTime = j;
                                    mediaItem.fileSize = j2;
                                    mediaItem.mid = String.valueOf(i10);
                                    mediaItem.extension = string3;
                                    mediaItem.mimeType = 0;
                                    bVar.c.f1773a.add(mediaItem);
                                    if (bVar.c.c.containsKey(mediaItem.mid)) {
                                        arrayList = bVar.c.c.get(mediaItem.mid);
                                    } else {
                                        arrayList = new ArrayList<>();
                                        bVar.c.c.put(mediaItem.mid, arrayList);
                                    }
                                    Iterator<MediaItem> it = arrayList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            z = false;
                                            break;
                                        }
                                        if (it.next().fileID == mediaItem.fileID) {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (!z) {
                                        arrayList.add(mediaItem);
                                    }
                                }
                            }
                            str12 = str;
                            str16 = str6;
                            str18 = str7;
                            iIntValue = i;
                            str17 = str8;
                            str11 = str9;
                        } catch (Exception e4) {
                            e = e4;
                            aVar = this;
                            arrayList2 = arrayList4;
                            e.printStackTrace();
                            i3 = i2;
                            if (i3 == 2) {
                            }
                            i4 = i & 4;
                            if (i4 == 4) {
                            }
                            Collections.sort(bVar.b.f1773a, aVar.new c());
                            int i92 = R.string.photo_grid_all;
                            if (i3 == 2) {
                            }
                            if (i4 == 4) {
                            }
                            if (!bVar.b.f1773a.isEmpty()) {
                            }
                            if (arrayList2.size() != 0) {
                            }
                            return bVar;
                        }
                    }
                    str2 = str11;
                    str3 = str17;
                    i = iIntValue;
                    str4 = str16;
                    str5 = str18;
                    str = str12;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    Iterator<MediaItem> it2 = bVar.c.f1773a.iterator();
                    while (it2.hasNext()) {
                        bVar.b.f1773a.add(it2.next());
                    }
                    for (Map.Entry<String, ArrayList<MediaItem>> entry : bVar.c.c.entrySet()) {
                        ArrayList<MediaItem> arrayList5 = new ArrayList<>();
                        Iterator<MediaItem> it3 = entry.getValue().iterator();
                        while (it3.hasNext()) {
                            arrayList5.add(it3.next());
                        }
                        bVar.b.c.put(entry.getKey(), arrayList5);
                    }
                } catch (Exception e5) {
                    e = e5;
                    i = iIntValue;
                    str = str12;
                    aVar = this;
                    arrayList2 = arrayList4;
                    e.printStackTrace();
                    i3 = i2;
                    if (i3 == 2) {
                    }
                    i4 = i & 4;
                    if (i4 == 4) {
                    }
                    Collections.sort(bVar.b.f1773a, aVar.new c());
                    int i922 = R.string.photo_grid_all;
                    if (i3 == 2) {
                    }
                    if (i4 == 4) {
                    }
                    if (!bVar.b.f1773a.isEmpty()) {
                    }
                    if (arrayList2.size() != 0) {
                    }
                    return bVar;
                }
            } else {
                str2 = "duration";
                str3 = "_display_name";
                i = iIntValue;
                i2 = i7;
                str4 = "date_modified";
                str5 = "_data";
                str = "MediaPickHelpers";
            }
            if ((i & 4) == 4) {
                Uri uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                String[] strArr2 = {"_id", str5, str3, str4, "_size", "bucket_id", "bucket_display_name", str2, str21, str20, bq.f.V};
                aVar = this;
                try {
                    Pair<String, String[]> pairJ2 = nk3.this.j((i & 1) == 1);
                    try {
                        cursorQuery2 = AppContext.getContext().getContentResolver().query(uri2, strArr2, (String) pairJ2.first, (String[]) pairJ2.second, "date_modified DESC");
                        sb = new StringBuilder();
                        sb.append("loadVideo size");
                        if (cursorQuery2 != null) {
                            try {
                                count = cursorQuery2.getCount();
                            } catch (Exception unused) {
                                str10 = str;
                                cursorQuery2 = null;
                            }
                        } else {
                            count = 0;
                        }
                        sb.append(count);
                        str10 = str;
                    } catch (Exception unused2) {
                        str10 = str;
                    }
                    try {
                        LogUtil.i(str10, sb.toString());
                    } catch (Exception unused3) {
                        cursorQuery2 = null;
                    }
                } catch (Exception e6) {
                    e = e6;
                }
                while (cursorQuery2 != null) {
                    try {
                        if (!cursorQuery2.moveToNext()) {
                            break;
                        }
                        int i11 = cursorQuery2.getInt(cursorQuery2.getColumnIndex(str19));
                        String str22 = str5;
                        String string4 = cursorQuery2.getString(cursorQuery2.getColumnIndex(str22));
                        String str23 = str3;
                        String string5 = cursorQuery2.getString(cursorQuery2.getColumnIndex(str23));
                        String str24 = str4;
                        str3 = str23;
                        String str25 = str19;
                        long j3 = cursorQuery2.getLong(cursorQuery2.getColumnIndex(str24));
                        String str26 = str15;
                        str4 = str24;
                        long j4 = cursorQuery2.getLong(cursorQuery2.getColumnIndex(str15));
                        int i12 = cursorQuery2.getInt(cursorQuery2.getColumnIndex(str14));
                        str5 = str22;
                        String string6 = cursorQuery2.getString(cursorQuery2.getColumnIndex(str13));
                        String str27 = str14;
                        String str28 = str13;
                        String str29 = str2;
                        long j5 = cursorQuery2.getInt(cursorQuery2.getColumnIndexOrThrow(str29));
                        str = str10;
                        str2 = str29;
                        String str30 = str21;
                        int i13 = cursorQuery2.getInt(cursorQuery2.getColumnIndexOrThrow(str30));
                        String str31 = str20;
                        int i14 = cursorQuery2.getInt(cursorQuery2.getColumnIndexOrThrow(str31));
                        int i15 = cursorQuery2.getInt(cursorQuery2.getColumnIndexOrThrow(bq.f.V));
                        if (j4 == 0 || TextUtils.isEmpty(string4) || !new File(string4).exists()) {
                            arrayList2 = arrayList4;
                        } else {
                            MediaItem mediaItem2 = new MediaItem();
                            mediaItem2.fileID = i11;
                            mediaItem2.fileFullPath = string4;
                            mediaItem2.fileName = string5;
                            mediaItem2.modifyTime = j3;
                            mediaItem2.fileSize = j4;
                            mediaItem2.mid = String.valueOf(i12);
                            mediaItem2.extension = string6;
                            mediaItem2.playLength = j5;
                            mediaItem2.mimeType = 1;
                            mediaItem2.localPath = string4;
                            boolean z3 = i15 == 90 || i15 == 270;
                            mediaItem2.width = z3 ? i14 : i13;
                            mediaItem2.height = z3 ? i13 : i14;
                            bVar.d.f1773a.add(mediaItem2);
                            if (bVar.d.c.containsKey(mediaItem2.mid)) {
                                arrayList3 = bVar.d.c.get(mediaItem2.mid);
                            } else {
                                arrayList3 = new ArrayList<>();
                                bVar.d.c.put(mediaItem2.mid, arrayList3);
                            }
                            Iterator<MediaItem> it4 = arrayList3.iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    z2 = false;
                                    break;
                                }
                                if (it4.next().fileID == mediaItem2.fileID) {
                                    z2 = true;
                                    break;
                                }
                            }
                            if (!z2) {
                                arrayList3.add(mediaItem2);
                            }
                            arrayList2 = arrayList4;
                            try {
                                arrayList2.add(new d(mediaItem2, cursorQuery2.getCount()));
                            } catch (Exception e7) {
                                e = e7;
                            }
                        }
                        arrayList4 = arrayList2;
                        str15 = str26;
                        str14 = str27;
                        str13 = str28;
                        str19 = str25;
                        str21 = str30;
                        str10 = str;
                        str20 = str31;
                    } catch (Exception e8) {
                        e = e8;
                        str = str10;
                        arrayList2 = arrayList4;
                        e.printStackTrace();
                    }
                    arrayList2 = arrayList4;
                    e.printStackTrace();
                }
                str = str10;
                arrayList2 = arrayList4;
                if (cursorQuery2 != null) {
                    cursorQuery2.close();
                }
                bVar.b.f1773a.addAll(bVar.d.f1773a);
                for (Map.Entry<String, ArrayList<MediaItem>> entry2 : bVar.d.c.entrySet()) {
                    if (bVar.b.c.containsKey(entry2.getKey())) {
                        Iterator<MediaItem> it5 = entry2.getValue().iterator();
                        while (it5.hasNext()) {
                            bVar.b.c.get(entry2.getKey()).add(it5.next());
                        }
                    } else {
                        bVar.b.c.put(entry2.getKey(), entry2.getValue());
                    }
                }
            } else {
                aVar = this;
                arrayList2 = arrayList4;
            }
            i3 = i2;
            if (i3 == 2) {
                Collections.sort(bVar.c.f1773a, aVar.new C1251a());
            }
            i4 = i & 4;
            if (i4 == 4) {
                Collections.sort(bVar.d.f1773a, aVar.new b());
            }
            Collections.sort(bVar.b.f1773a, aVar.new c());
            int i9222 = R.string.photo_grid_all;
            if (i3 == 2 && !bVar.c.f1773a.isEmpty()) {
                HashMap map3 = new HashMap();
                bn2.c cVar3 = new bn2.c();
                cVar3.b = bVar.c.f1773a.get(0).fileID;
                cVar3.d = bVar.c.f1773a.get(0).fileFullPath;
                cVar3.c = AppContext.getContext().getResources().getString(i4 != 4 ? R.string.photo_grid_all : R.string.photo_grid_all_image);
                bVar.c.b.clear();
                bVar.c.b.add(cVar3);
                for (i6 = 0; i6 < bVar.c.f1773a.size(); i6++) {
                    MediaItem mediaItem3 = bVar.c.f1773a.get(i6);
                    String str32 = mediaItem3.mid;
                    if (map3.containsKey(str32)) {
                        ((bn2.c) map3.get(str32)).e++;
                    } else {
                        bn2.c cVar4 = new bn2.c();
                        cVar4.f1775a = str32;
                        cVar4.d = mediaItem3.fileFullPath;
                        cVar4.b = mediaItem3.fileID;
                        cVar4.c = mediaItem3.extension;
                        cVar4.e = 1;
                        map3.put(str32, cVar4);
                        bVar.c.b.add(cVar4);
                    }
                }
            }
            if (i4 == 4 && !bVar.d.f1773a.isEmpty()) {
                HashMap map22 = new HashMap();
                bn2.c cVar22 = new bn2.c();
                cVar22.b = bVar.d.f1773a.get(0).fileID;
                cVar22.d = bVar.d.f1773a.get(0).fileFullPath;
                cVar22.c = AppContext.getContext().getResources().getString(i4 != 4 ? R.string.photo_grid_all : R.string.photo_grid_all_image);
                bVar.d.b.clear();
                bVar.d.b.add(cVar22);
                for (i5 = 0; i5 < bVar.d.f1773a.size(); i5++) {
                    MediaItem mediaItem4 = bVar.d.f1773a.get(i5);
                    String str33 = mediaItem4.mid;
                    if (map22.containsKey(str33)) {
                        ((bn2.c) map22.get(str33)).e++;
                    } else {
                        bn2.c cVar5 = new bn2.c();
                        cVar5.f1775a = str33;
                        cVar5.d = mediaItem4.fileFullPath;
                        cVar5.b = mediaItem4.fileID;
                        cVar5.c = mediaItem4.extension;
                        cVar5.e = 1;
                        map22.put(str33, cVar5);
                        bVar.d.b.add(cVar5);
                    }
                }
            }
            if (!bVar.b.f1773a.isEmpty()) {
                HashMap map4 = new HashMap();
                bn2.c cVar6 = new bn2.c();
                cVar6.b = bVar.b.f1773a.get(0).fileID;
                cVar6.d = bVar.b.f1773a.get(0).fileFullPath;
                Resources resources = AppContext.getContext().getResources();
                if (i4 != 4) {
                    i9222 = R.string.photo_grid_all_image;
                }
                cVar6.c = resources.getString(i9222);
                bVar.b.b.clear();
                bVar.b.b.add(cVar6);
                for (int i16 = 0; i16 < bVar.b.f1773a.size(); i16++) {
                    MediaItem mediaItem5 = bVar.b.f1773a.get(i16);
                    String str34 = mediaItem5.mid;
                    if (map4.containsKey(str34)) {
                        ((bn2.c) map4.get(str34)).e++;
                    } else {
                        bn2.c cVar7 = new bn2.c();
                        cVar7.f1775a = str34;
                        cVar7.d = mediaItem5.fileFullPath;
                        cVar7.b = mediaItem5.fileID;
                        cVar7.c = mediaItem5.extension;
                        cVar7.e = 1;
                        map4.put(str34, cVar7);
                        bVar.b.b.add(cVar7);
                    }
                }
            }
            if (arrayList2.size() != 0) {
                LogUtil.i(str, "updateThumbForVideo ， size = " + arrayList2.size());
                nk3.this.new c(bVar, arrayList2).start();
            }
            return bVar;
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void n(bn2.b bVar) {
            LogUtil.i("MediaPickHelpers", "onPostExecute");
            if (tg4.b(AppContext.getContext(), BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList)) {
                bVar.e = true;
            }
            if ((bVar.f1774a & 1) != 1) {
                LogUtil.i("logmedia", "Loaded: " + bVar.b.f1773a.size());
                nk3.this.setChanged();
                nk3.this.notifyObservers(bVar);
                return;
            }
            LogUtil.i("logmedia", "PreLoaded: " + bVar.b.f1773a.size());
            nk3.this.setChanged();
            nk3.this.notifyObservers(bVar);
            nk3.this.f19526a = bVar;
            nk3 nk3Var = nk3.this;
            int i = bVar.f1774a & (-2);
            bVar.f1774a = i;
            nk3Var.k(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == nk3.d) {
                nk3.this.setChanged();
                nk3.this.notifyObservers(message.obj);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends g13 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public bn2.b f19531a;
        public ArrayList<d> b;

        public c(bn2.b bVar, ArrayList<d> arrayList) {
            this.f19531a = bVar;
            this.b = arrayList;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                HashMap map = new HashMap();
                Cursor cursorQuery = null;
                try {
                    try {
                        cursorQuery = AppContext.getContext().getContentResolver().query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_data", "video_id"}, null, null, null);
                        if (cursorQuery != null) {
                            while (cursorQuery.moveToNext()) {
                                int i = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("video_id"));
                                map.put(Integer.valueOf(i), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")));
                                LogUtil.i("MediaPickHelper_THUMB", "CreateThumbThread, put = " + i);
                            }
                        }
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (cursorQuery != null) {
                    }
                }
                for (d dVar : this.b) {
                    LogUtil.i("MediaPickHelper_THUMB", "CreateThumbThread, index = " + dVar.b);
                    String strH = nk3.h((String) map.get(Integer.valueOf(dVar.f19532a.fileID)), dVar.f19532a.fileID, dVar.f19532a.fileFullPath);
                    if (!TextUtils.isEmpty(strH)) {
                        for (MediaItem mediaItem : this.f19531a.d.f1773a) {
                            if (mediaItem.fileID == dVar.f19532a.fileID) {
                                mediaItem.thumbnailPath = strH;
                                mediaItem.localThumbPath = strH;
                                LogUtil.i("MediaPickHelper_THUMB", "CreateThumbThread, fileID = " + mediaItem.fileID + "， path = " + strH);
                            }
                        }
                    }
                }
                Message message = new Message();
                message.what = nk3.d;
                message.obj = this.f19531a;
                nk3.this.b.sendMessage(message);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaItem f19532a;
        public int b;

        public d(MediaItem mediaItem, int i) {
            this.b = i;
            this.f19532a = mediaItem;
        }
    }

    public static String h(String str, int i, String str2) {
        Bitmap bitmapCreateVideoThumbnail;
        if (str == null || !pu1.b(str)) {
            String str3 = (pu1.f + File.separator) + i + ".thumbnail";
            if (pu1.b(str3)) {
                LogUtil.i("MediaPickHelper_THUMB", "thumbnailPath getfrom cache， fileid = " + i);
                str = str3;
            }
        }
        if ((str != null && pu1.b(str)) || !h.f(str2) || (bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str2, 1)) == null) {
            return str;
        }
        File file = new File(pu1.f);
        if (!file.exists()) {
            file.mkdirs();
            LogUtil.i("MediaPickHelper_THUMB", "create dir");
        }
        File file2 = new File((pu1.f + File.separator) + i + ".thumbnail");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmapCreateVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            String absolutePath = file2.getAbsolutePath();
            LogUtil.i("MediaPickHelper_THUMB", "CreateThumbThread create, filePath = " + absolutePath);
            return absolutePath;
        } catch (IOException unused) {
            return null;
        }
    }

    public static nk3 i() {
        if (c == null) {
            synchronized (nk3.class) {
                if (c == null) {
                    c = new nk3();
                }
            }
        }
        return c;
    }

    @Override // java.util.Observable
    public void addObserver(Observer observer) {
        super.addObserver(observer);
    }

    public Pair<String, String[]> j(boolean z) {
        String[] strArr;
        String str;
        if (z) {
            strArr = new String[]{String.valueOf((ir5.b() - 2592000000L) / 1000)};
            str = "date_modified>?";
        } else {
            strArr = null;
            str = null;
        }
        return new Pair<>(str, strArr);
    }

    public final void k(int i) {
        new a().h(Integer.valueOf(i));
    }

    public void l(Observer observer) {
        k(7);
        observer.update(this, this.f19526a);
    }
}
