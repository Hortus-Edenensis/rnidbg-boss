package com.zenmen.square.mvvm;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.photoview.FeedBean;
import defpackage.dn0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MediaFriendViewModel extends AndroidViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<FeedBean> f16455a;
    public final MutableLiveData<ContactInfoItem> b;

    public MediaFriendViewModel(@NonNull Application application) {
        super(application);
        this.f16455a = new MutableLiveData<>();
        this.b = new MutableLiveData<>();
    }

    public ContactInfoItem a() {
        return this.b.getValue();
    }

    public LiveData<ContactInfoItem> b() {
        return this.b;
    }

    public FeedBean c() {
        return this.f16455a.getValue();
    }

    public void d(ContactInfoItem contactInfoItem) {
        if (contactInfoItem == null) {
            contactInfoItem = dn0.a(c().getUid());
        }
        e(contactInfoItem);
    }

    public void e(ContactInfoItem contactInfoItem) {
        this.b.setValue(contactInfoItem);
    }

    public void f(FeedBean feedBean) {
        this.f16455a.setValue(feedBean);
    }
}
