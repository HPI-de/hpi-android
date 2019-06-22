package de.hpi.android.news.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import io.reactivex.Observable
import org.threeten.bp.LocalDateTime
import java.net.URL

object ArticleRepository : Repository<ArticleDto>() {
    private val articles = listOf(
        ArticleDto(
            id = "1",
            sourceId = "hpi",
            link = URL("https://hpi.de/news/jahrgaenge/2019/die-schul-cloud-fuer-brandenburg-bildungsministerin-britta-ernst-unterzeichnet-absichtserklaerung-zur-nutzung-der-hpi-schul-cloud.html"),
            title = "Die Schul-Cloud für Brandenburg: Bildungsministerin Britta Ernst unterzeichnet Absichtserklärung zur Nutzung der HPI Schul-Cloud",
            authors = emptySet(),
            date = LocalDateTime.of(2019, 3, 1, 16, 0, 0),
            teaser = "Künftig sollen viel mehr Schulen in Brandenburg die HPI Schul-Cloud nutzen und sich miteinander vernetzen können. Eine entsprechende Absichtserklärung unterzeichneten am 01. März 2019 die Bildungsministerin Britta Ernst, HPI-Direktor Professor Christoph Meinel und die Projektpartner in Potsdam.",
            content = """
                        Seit 2016 entwickelt das Hasso-Plattner-Institut unter der Leitung von Professor Christoph Meinel zusammen mit dem nationalen Excellence-Schulnetzwerk MINT-EC und gefördert durch das Bundesministerium für Bildung und Forschung die HPI Schul-Cloud. Sie soll die technische Grundlage schaffen, dass Lehrkräfte und Schüler in jedem Unterrichtsfach auch moderne digitale Lehr- und Lerninhalte nutzen können, und zwar so einfach, wie Apps über Smartphones oder Tablets nutzbar sind. Von August 2019 bis Juli 2021 wird nun auch eine Brandenburgische Version der Schul-Cloud entwickelt und evaluiert werden. Dazu haben heute in Potsdam Bildungsministerin Britta Ernst, der Gründungsgeschäftsführer der DigitalAgentur Brandenburg GmbH, Olav Wilms, und der Direktor des Hasso-Plattner-Instituts (HPI) und Leiter des Lehrstuhls Internet-Technologien und Systeme, Prof. Christoph Meinel, eine Absichtserklärung zur Pilotierung einer Schul-Cloud im Land Brandenburg unterzeichnet. Für die Pilotierung haben sich bereits 27 „medienfit sek I“-Schulen angemeldet. Weitere medienfit-Grundschulen werden folgen. Die schrittweise Inbetriebnahme der Cloud ist bis zum Schuljahr 2021/22 angestrebt.

                        Bildungsministerin Britta Ernst betonte: „Das Lernen mit digitalen Medien ist die Herausforderung mit der größten Dynamik. Dazu braucht es eine leistungsfähige digitale Infrastruktur. Zu den wichtigsten Vorhaben gehört die im Hasso-Plattner-Institut entwickelte Schul-Cloud. Sie soll die Schulen des Landes vernetzen, so dass Lehrkräfte, Schülerinnen und Schüler jederzeit und überall Zugang zu Lern- und Lehrmaterialien haben. Die professionelle zentrale Wartung für alle Schulen verringert deutlich den Verwaltungs- und Betreuungsaufwand. Wir versprechen uns von der Schul-Cloud einen deutlichen Schub in der digitalen Bildung und freuen uns auf den Start des Projekts.“

                        Auch HPI-Direktor Professor Christoph Meinel freut sich über die Kooperation mit dem Land Brandenburg. „Mit der HPI Schul-Cloud können Lehrkräfte und Schüler in jedem Unterrichtsfach sehr einfach digitale Lehr- und Lerninhalte nutzen und das unter Einhaltung der hohen gesetzlichen Datenschutzregelungen. Ich freue mich daher sehr, dass ab dem neuen Schuljahr weitere Schulen in Brandenburg mit der Schul-Cloud arbeiten werden.“

                        Derzeit arbeiten bundesweit bereits 100 ausgewählte MINT-EC-Schulen mit der HPI Schul-Cloud. Dazu kommen 43 Schulen der Niedersächsischen Bildungscloud (NBC).
                    """.trimIndent(),
            categories = emptySet(),
            tags = emptySet(),
            cover = URL("https://hpi.de/fileadmin/user_upload/hpi/bilder/teaser_news/2019/HPI_Schul_Cloud_2019_1020x420.jpg")
        ),
        ArticleDto(
            id = "2",
            sourceId = "hpi-mgzn",
            link = URL("https://hpimgzn.de/2019/von-wurmmehlkeksen-bis-hin-zu-kompostieranlagen/"),
            title = "Von Wurmmehlkeksen bis hin zu Kompostieranlagen",
            authors = setOf("Lilith Diringer"),
            date = LocalDateTime.of(2019, 2, 15, 18, 49, 8),
            teaser = "Am 16.12 hat der Nachhaltigkeitsklub seinen ersten Workshop angeboten. Von Bokashianlagenbau bis hin zur Herstellung selbstgemachter Weihnachtsgeschenke. Lest hier mehr.",
            content = """
                        „Wollt ihr auch einmal Heuschrecken kosten?“ Diese Frage kursiert am 16.12. im HPI Hauptgebäude. Woher sie kommt? Aus Richtung der Teeküche, in der sich für den heutigen Tag eine Mischung aus Nachhaltigkeitsklubmitgliedern und externen Interessierten eingefunden hat. Welcher Anlass? Unser erster Nachhaltigkeitsworkshoptag.

                        Warum muss man immer alles kaufen? Heute wollen wir selbst Hand anlegen. Und so geht es gleich mit den ersten selbst gemachten Müsliriegeln los. Schon bald wird das Erdgeschoss des Hauptgebäudes mit Müsliriegelduft durchströmt. Aus dem Ofen können wir nach einiger Backzeit nicht nur ansehnliche, sondern auch sehr leckere Müslischnitten entnehmen.

                        Die Nachwärme der Herdplatte, den wir zum Nüsserösten verwendet haben, nutzen wir gleich weiter, um etwas anderes zu rösten: Heuschrecken und Mehlwürmer, sowie Buffalowürmer. Als diese fertig sind, können wir diese etwas ungewöhnliche Proteinquelle verspeisen sowie die von einer Teilnehmerin mitgebrachten Buffalomehlkekse probieren. Interessant!


                        Natürlich gibt es zwischendurch auch etwas Leckeres zu essen – unter anderem Biogemüse.
                        Der Workshop geht weiter mit der Herstellung von Badekugeln und Waschmittel, sowie dem Bau einer Bokashi-Anlage – einem Innenkomposter. Für alle, die Lust haben davon etwas nachzumachen gibt es die Anleitungen hier.


                        Einer dieser Innenkomposter steht inzwischen auch in der Teeküche für euch bereit. Ihr seid herzlich dazu eingeladen, eure Bioabfälle in diesem zu entsorgen und auch, ab in ca. zwei Wochen, wenn der erste Dünger entstanden sein sollte, euch daran zu bedienen – eure Küchenpflanzen werden sich freuen.


                        Bei der Herstellung unserer Kompostieranlagen hat uns die Kreativität gepackt.



                        Geplant ist es, auch in Zukunft, einmal monatlich einen Workshoptag anzubieten. Dabei werden wir Trinkschokoladensticks sowie vegane Milchalternativen selbst herstellen, Shampoo produzieren, das Stricken von Hausschuhen erlernen…

                        Besonders sollen diese Workshops als Austauschplattform und zum Ausprobieren von Alternativen dienen, sowie Freiräume zum Diskutieren bieten.

                        Kommt bei Ideen einfach auf uns zu oder schreibt uns an:
                        Lilith.Diringer@student.hpi.de
                        Malte.Barth@student.hpi.de
                    """.trimIndent(),
            categories = setOf("allgemein", "klubs", "klubs/nachhaltigkeitsklub"),
            cover = URL("https://hpimgzn.de/wp-content/uploads/2018/12/photo_2018-12-16_20-19-43.jpg"),
            tags = setOf("nachhaltigkeitsklub", "essen", "selbstgemacht"),
            viewCount = 107
        )
    )

    override fun get(id: Id<ArticleDto>): Observable<Result<ArticleDto>> {
        val article = articles.firstOrNull { it.id == id }
        return Observable.just(
            article?.success()
                ?: IllegalArgumentException("ArticleDto with ID $id was not found").error()
        )
    }

    override fun getAll(): Observable<Result<List<ArticleDto>>> {
        return Observable.just(articles.success())
    }
}
