package com.kaviddiss.example.model

data class ImagesAnnotateReq (val requests: List<AnnotateImageRequest>)

data class AnnotateImageRequest (val image: Image, val features: List<Feature>, val imageContext: ImageContext)

data class Feature (val type: FeatureType, val maxResults: Int)

enum class FeatureType {
    TYPE_UNSPECIFIED, FACE_DETECTION, LANDMARK_DETECTION, LOGO_DETECTION, LABEL_DETECTION, TEXT_DETECTION, DOCUMENT_TEXT_DETECTION,
    SAFE_SEARCH_DETECTION, IMAGE_PROPERTIES, CROP_HINTS, WEB_DETECTION
}

data class Image(val content: String? = null, val source: ImageSource? = null)

data class ImageSource(val imageUri: String?)

data class ImageContext (val languageHints: List<String>)
