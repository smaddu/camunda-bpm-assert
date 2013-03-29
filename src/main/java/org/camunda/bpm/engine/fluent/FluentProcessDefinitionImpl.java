package org.camunda.bpm.engine.fluent;

import org.camunda.bpm.engine.repository.ProcessDefinition;

/**
 * @author Martin Schimak <martin.schimak@plexiti.com>
 */
public class FluentProcessDefinitionImpl implements FluentProcessDefinition {

    private ProcessDefinition delegate;

    public FluentProcessDefinitionImpl(ProcessDefinition delegate) {
        this.delegate = delegate;
    }

    @Override
    public ProcessDefinition getDelegate() {
        return delegate;
    }

    @Override
    public String getId() {
        return delegate.getId();
    }

    @Override
    public String getCategory() {
        return delegate.getCategory();
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public String getKey() {
        return delegate.getKey();
    }

    @Override
    public String getDescription() {
        return delegate.getDescription();
    }

    @Override
    public int getVersion() {
        return delegate.getVersion();
    }

    @Override
    public String getResourceName() {
        return delegate.getResourceName();
    }

    @Override
    public String getDeploymentId() {
        return delegate.getDeploymentId();
    }

    @Override
    public String getDiagramResourceName() {
        return delegate.getDiagramResourceName();
    }

    @Override
    public boolean hasStartFormKey() {
        return delegate.hasStartFormKey();
    }

    @Override
    public boolean isSuspended() {
        return delegate.isSuspended();
    }

}