package com.zenmen.palmchat.contacts.userdetail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.photoview.PhotoViewActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.peoplematch.view.LoopingPagerAdapter;
import defpackage.bo0;
import defpackage.cg4;
import defpackage.gu;
import defpackage.hc2;
import defpackage.je1;
import defpackage.k86;
import defpackage.l50;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserDetailGalleryAdapter extends LoopingPagerAdapter<b> {
    public je1 f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f13671a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.userdetail.UserDetailGalleryAdapter$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1030a extends HashMap<String, Object> {
            public C1030a() {
                put("targetUid", a.this.f13671a.c.getUid());
            }
        }

        public a(b bVar, int i) {
            this.f13671a = bVar;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l50.a() && this.f13671a.b) {
                Intent intent = new Intent();
                intent.setClass(UserDetailGalleryAdapter.this.f14916a, PhotoViewActivity.class);
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (int i = 0; i < UserDetailGalleryAdapter.this.getCount(); i++) {
                    b bVarG = UserDetailGalleryAdapter.this.g(i);
                    if (bVarG != null && bVarG.f13673a != null && bVarG.b) {
                        MediaItem mediaItem = new MediaItem();
                        ContactInfoItem.Portrait portrait = bVarG.f13673a;
                        mediaItem.fileFullPath = portrait.headImg;
                        mediaItem.thumbnailPath = portrait.headIcon;
                        arrayList.add(mediaItem);
                    }
                }
                intent.putParcelableArrayListExtra("mediaList", arrayList);
                intent.putExtra("selectIndex", this.b);
                intent.putExtra("extra_is_friend", bo0.r().w(this.f13671a.c.getUid()));
                intent.putExtra("show_mode", 0);
                UserDetailGalleryAdapter.this.f14916a.startActivity(intent);
                zn6.j("newpageprofil_headclick", "click", new C1030a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ContactInfoItem.Portrait f13673a;
        public boolean b;
        public ContactInfoItem c;
    }

    public UserDetailGalleryAdapter(Context context) {
        super(context);
        this.f = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.default_portrait).A(R.drawable.default_portrait).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(R.drawable.default_portrait).r();
    }

    @Override // com.zenmen.palmchat.peoplematch.view.LoopingPagerAdapter
    public void f(View view, int i, int i2) {
        b bVarG = g(i);
        if (bVarG == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.people_gallery_image);
        String str = bVarG.f13673a.headImg;
        if (TextUtils.isEmpty(str)) {
            str = bVarG.f13673a.headIcon;
        }
        if (bVarG.b) {
            cg4.a(k86.p(str), imageView, this.f);
        } else {
            hc2.a(this.f14916a).load(k86.p(str)).placeholder(R.drawable.default_portrait).transform(new gu(50, 2)).into(imageView);
        }
        view.setOnClickListener(new a(bVarG, i));
    }

    @Override // com.zenmen.palmchat.peoplematch.view.LoopingPagerAdapter
    public View i(int i, ViewGroup viewGroup, int i2) {
        return LayoutInflater.from(this.f14916a).inflate(R.layout.list_item_people_match_gallery, viewGroup, false);
    }
}
