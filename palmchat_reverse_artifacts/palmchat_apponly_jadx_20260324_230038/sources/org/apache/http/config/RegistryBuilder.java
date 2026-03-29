package org.apache.http.config;

import com.opos.acs.st.STManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
@NotThreadSafe
public final class RegistryBuilder<I> {
    private final Map<String, I> items = new HashMap();

    public static <I> RegistryBuilder<I> create() {
        return new RegistryBuilder<>();
    }

    public Registry<I> build() {
        return new Registry<>(this.items);
    }

    public RegistryBuilder<I> register(String str, I i) {
        Args.notEmpty(str, STManager.REGION_OF_ID);
        Args.notNull(i, "Item");
        this.items.put(str.toLowerCase(Locale.ENGLISH), i);
        return this;
    }

    public String toString() {
        return this.items.toString();
    }
}
