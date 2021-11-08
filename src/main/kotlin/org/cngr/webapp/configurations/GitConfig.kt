package org.cngr.webapp.configurations

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
@PropertySource("classpath:/application-gitconfig.properties")
class GitConfig {

    @Value("\${git.commit.id}")
    lateinit var commitId :String

    @PostConstruct
    fun getStoreConfiguration() {
        print("Store size is $commitId meter square\n")
    }

}