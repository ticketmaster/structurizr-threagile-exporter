package com.ticketmaster.structurizr

import com.structurizr.export.WorkspaceExport


open class YamlWorkspaceExport(definition: String?) : WorkspaceExport(definition) {

    override fun getFileExtension(): String {
        return "yaml"
    }

}