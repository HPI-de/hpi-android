package de.hpi.android.myhpi.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import de.hpi.android.myhpi.domain.Action
import de.hpi.android.myhpi.domain.InfoBit
import io.reactivex.Observable
import org.threeten.bp.LocalDateTime
import java.net.URL

object InfoBitRepository : Repository<InfoBitDto>() {
    private val infoBits = listOf(
        InfoBitDto(
            id = "set-up",
            title = "Need help setting up your laptop?",
            text = "We know it can be hard, even for HPI students. But this interactive guide got you covered.",
            actions = listOf(
                ActionDto.Link(
                    id = "vpn",
                    icon = URL("https://example.com/icon.png"),
                    title = "Add VPN",
                    url = URL("https://example.com")
                ),
                ActionDto.Link(
                    id = "wifi",
                    icon = URL("https://example.com/icon.png"),
                    title = "Connect to WiFi",
                    url = URL("https://example.com")
                ),
                ActionDto.Link(
                    id = "printer",
                    icon = URL("https://example.com/icon.png"),
                    title = "Add printer",
                    url = URL("https://example.com")
                )
            )
        ),
        InfoBitDto(
            id = "about-hpi",
            title = "What's an \"HPI\"?",
            text = "You're studying at the HPI, which is a faculty of the Uni Potsdam. But what exactly does that mean and how does it impact you?",
            actions = listOf(
                ActionDto.Link(
                    id = "find-out",
                    icon = URL("https://example.com/icon.png"),
                    title = "Found out",
                    url = URL("https://example.com")
                )
            )
        )
    )

    override fun get(id: Id<InfoBitDto>): Observable<Result<InfoBitDto>> {
        val infoBit = infoBits.firstOrNull { it.id == id }
        return Observable.just(
            infoBit?.success()
                ?: IllegalArgumentException("ArticleDto with ID $id was not found").error()
        )
    }

    override fun getAll(): Observable<Result<List<InfoBitDto>>> {
        return Observable.just(infoBits.success())
    }
}
