package com.ticketmaster.structurizr

import com.structurizr.Workspace
import com.structurizr.export.WorkspaceExport
import com.structurizr.export.WorkspaceExporter


open class ThreagileWorkspaceExporter : WorkspaceExporter {
    override fun export(workspace: Workspace?): WorkspaceExport {
        return try {
            YamlWorkspaceExport("Some yaml")
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}