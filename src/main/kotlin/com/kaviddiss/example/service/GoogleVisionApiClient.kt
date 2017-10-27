package com.kaviddiss.example.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.kaviddiss.example.model.*
import com.kaviddiss.example.repo.GoogleVisionApiRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GoogleVisionApiClient(val visionApiRepo: GoogleVisionApiRepo,
                            @Value("\${google.vision-api.max-results}") val maxResults: Int) {
    val log = LoggerFactory.getLogger(this.javaClass)
    val objectMapper = jacksonObjectMapper()

    fun annotateImage(imageUrl: String, lang: String = "en") : AnnotateImageResponse {
        log.info("Annotating image at url ${imageUrl} with lang=${lang}")
        val image = Image(source = ImageSource(imageUri = imageUrl))

        val features = listOf(
                FeatureType.TYPE_UNSPECIFIED,
//                FeatureType.TEXT_DETECTION,
//                FeatureType.SAFE_SEARCH_DETECTION,
//                FeatureType.LOGO_DETECTION,
                FeatureType.LANDMARK_DETECTION,
                FeatureType.WEB_DETECTION,
                FeatureType.LABEL_DETECTION).map { featureType -> Feature(featureType, maxResults = maxResults) }

        val imageContext = ImageContext(languageHints = listOf(lang))

        val req = ImagesAnnotateReq(requests = listOf(AnnotateImageRequest(image = image, features = features, imageContext = imageContext)))

        val annotateImageResponse = visionApiRepo.annotateImages(req).responses[0]
        val jsonResp = objectMapper.writeValueAsString(annotateImageResponse)
        log.debug("Google Vision Api response: ${jsonResp}")
        return annotateImageResponse
    }
}