package com.projects.documentprocessor.pdf

import com.projects.documentprocessor.tika.TikaService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/api/v0/file")
class FileProcessorController(private val tikaService: TikaService) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/extract-content")
    fun processPdf(@RequestBody file: MultipartFile): ResponseEntity<String> {
        log.info("Processing file: ${file.originalFilename}")
        val start = System.currentTimeMillis()
        val pdfText = tikaService.getFileContent(file)
        log.info("Processing file: ${file.originalFilename} took ${System.currentTimeMillis() - start}ms")
        return ResponseEntity.ok(pdfText)
    }
}