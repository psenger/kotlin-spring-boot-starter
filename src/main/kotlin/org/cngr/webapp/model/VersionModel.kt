package org.cngr.webapp.model

data class VersionModel(var gitCommitId: String = "", var gitNow: String = "") {
    var commitId :String = gitCommitId
    var now: String = gitNow
}