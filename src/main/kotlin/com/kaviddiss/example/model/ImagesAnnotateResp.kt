package com.kaviddiss.example.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

data class ImagesAnnotateResp (val responses: List<AnnotateImageResponse>)

@JsonIgnoreProperties(ignoreUnknown = true)
data class AnnotateImageResponse (val landmarkAnnotations: List<EntityAnnotation>?, val logoAnnotations: List<EntityAnnotation>?,
                                  val labelAnnotations: List<EntityAnnotation>?, val textAnnotations: List<EntityAnnotation>?,
                                  val safeSearchAnnotation: SafeSearchAnnotation?, val webDetection: WebDetection?, val error: Status?)

@JsonIgnoreProperties(ignoreUnknown = true)
data class EntityAnnotation (val mid: String?, val description: String, val score: Double, val boundingPoly: BoundingPoly?,
                             val locations: List<LocationInfo> = listOf())

data class BoundingPoly (val vertices: List<Vertex>)

data class Vertex (val x: Double, val y: Double)

data class LocationInfo (val latLng: LatLng)

data class LatLng (val latitude: Double, val longitude: Double)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Property (val name: String, val value: String, val uint64Value: String)

data class SafeSearchAnnotation (val adult: Likelihood, val spoof: Likelihood, val medical: Likelihood, val violence: Likelihood)

enum class Likelihood {
    UNKNOWN, VERY_UNLIKELY, UNLIKELY, POSSIBLE, LIKELY, VERY_LIKELY
}

data class WebDetection (val webEntities: List<WebEntity>)

@JsonIgnoreProperties(ignoreUnknown = true)
data class WebEntity (val entityId: String, val score: Double, val description: String?)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Status (val code: Int, val message: String, val details: Any?)