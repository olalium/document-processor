package com.projects.documentprocessor.tika

import org.apache.tika.parser.AutoDetectParser
import org.apache.tika.sax.BodyContentHandler
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class TikaService {

    fun getFileContent(file: MultipartFile): String {
        val parser = AutoDetectParser()
        val contentHandler = BodyContentHandler(-1)
        val metadata = org.apache.tika.metadata.Metadata()
        val parseContext = org.apache.tika.parser.ParseContext()

        parser.parse(file.inputStream, contentHandler, metadata, parseContext)

        return contentHandler.toString()
    }
}