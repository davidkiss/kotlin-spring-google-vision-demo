
import com.kaviddiss.example.service.GoogleVisionApiClient
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class SearchController(val googleVisionApiClient: GoogleVisionApiClient)
{

    @GetMapping("/image-annotation")
    fun annotateImageWithUrl(@RequestParam(value = "imageUrl") imageUrl: String,
                             @RequestHeader(value = HttpHeaders.ACCEPT_LANGUAGE, required = false, defaultValue = "en") acceptLang: String)
            = googleVisionApiClient.annotateImage(imageUrl = imageUrl, lang = acceptLang)
}