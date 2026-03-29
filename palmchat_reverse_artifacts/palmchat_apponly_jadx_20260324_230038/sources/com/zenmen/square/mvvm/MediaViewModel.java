package com.zenmen.square.mvvm;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.dn0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MediaViewModel extends AndroidViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<SquareFeed> f16456a;
    public final MutableLiveData<ContactInfoItem> b;

    public MediaViewModel(@NonNull Application application) {
        super(application);
        this.f16456a = new MutableLiveData<>();
        this.b = new MutableLiveData<>();
    }

    public LiveData<ContactInfoItem> a() {
        return this.b;
    }

    public SquareFeed b() {
        return this.f16456a.getValue();
    }

    public LiveData<SquareFeed> c() {
        return this.f16456a;
    }

    public void d() {
        e(dn0.b(b().exid));
    }

    public void e(ContactInfoItem contactInfoItem) {
        this.b.setValue(contactInfoItem);
    }

    public void f(SquareFeed squareFeed) {
        this.f16456a.setValue(squareFeed);
    }
}
