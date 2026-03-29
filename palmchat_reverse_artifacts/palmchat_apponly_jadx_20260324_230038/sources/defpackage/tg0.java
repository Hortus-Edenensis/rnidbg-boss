package defpackage;

import org.jsoup.nodes.f;
import org.jsoup.nodes.g;
import org.jsoup.select.Elements;
import org.jsoup.select.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class tg0 {
    public static Elements a(b bVar, f fVar) {
        Elements elements = new Elements();
        new qy3(new a(fVar, elements, bVar)).a(fVar);
        return elements;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements sy3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f20980a;
        public final Elements b;
        public final b c;

        public a(f fVar, Elements elements, b bVar) {
            this.f20980a = fVar;
            this.b = elements;
            this.c = bVar;
        }

        @Override // defpackage.sy3
        public void b(g gVar, int i) {
            if (gVar instanceof f) {
                f fVar = (f) gVar;
                if (this.c.a(this.f20980a, fVar)) {
                    this.b.add(fVar);
                }
            }
        }

        @Override // defpackage.sy3
        public void a(g gVar, int i) {
        }
    }
}
