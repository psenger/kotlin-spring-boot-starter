package org.cngr.webapp.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import org.cngr.webapp.configurations.GitConfig
import org.cngr.webapp.model.VersionModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class VersionController( @Autowired val gitConfig: GitConfig ) {


    @GetMapping(value = ["/version"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun helloWorld(): ResponseEntity<Any?> {
        return ResponseEntity.ok(ObjectMapper().writeValueAsString(VersionModel(
            commitId = gitConfig.commitId,
            now = System.currentTimeMillis().toString(),
        )))
    }
}
