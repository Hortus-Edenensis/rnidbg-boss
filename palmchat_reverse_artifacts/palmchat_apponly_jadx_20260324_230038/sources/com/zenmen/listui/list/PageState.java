package com.zenmen.listui.list;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class PageState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f11843a;
    public String b;
    public int c;

    /* JADX INFO: compiled from: SearchBox */
    public enum State {
        EMPTY,
        ERROR,
        LOADING,
        NORMAL
    }

    public PageState(State state, String str) {
        this.f11843a = state;
        this.b = str;
    }
}
