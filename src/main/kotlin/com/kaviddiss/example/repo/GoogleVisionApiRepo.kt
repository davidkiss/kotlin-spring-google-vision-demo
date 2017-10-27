package com.kaviddiss.example.repo

import com.kaviddiss.example.model.ImagesAnnotateReq
import com.kaviddiss.example.model.ImagesAnnotateResp
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(value = "google-vision", url = "\${google.vision-api.baseUrl}")
interface GoogleVisionApiRepo {

    @RequestMapping(value = "v1/images:annotate?alt=json&key=\${google.api-key}",
            method = arrayOf(RequestMethod.POST),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun annotateImages(@RequestBody body: ImagesAnnotateReq): ImagesAnnotateResp
}