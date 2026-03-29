package androidx.room;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public @interface Update {
    int onConflict() default 3;
}
