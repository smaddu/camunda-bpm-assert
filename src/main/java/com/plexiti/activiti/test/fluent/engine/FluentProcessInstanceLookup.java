package com.plexiti.activiti.test.fluent.engine;

import org.camunda.bpm.engine.repository.ProcessDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * @author Martin Schimak <martin.schimak@plexiti.com>
 * @author Rafael Cordones <rafael.cordones@plexiti.com>
 */
public class FluentProcessInstanceLookup {

    private static ThreadLocal<Map<String, FluentProcessInstance>> testProcessInstances = new ThreadLocal<Map<String, FluentProcessInstance>>();

    protected static void before(Object junitTest) {}

    protected static void after(Object junitTest) {
        testProcessInstances.set(null);
    }

    protected static Map<String, FluentProcessInstance> getTestProcessInstances() {
        Map<String, FluentProcessInstance> processes = testProcessInstances.get();
        if (processes == null)
            testProcessInstances.set(processes = new HashMap<String, FluentProcessInstance>());
        return processes;
    }

    /**
     * @see com.plexiti.activiti.test.fluent.FluentProcessEngineTests#newProcessInstance(String)
     */
    public static FluentProcessInstance newProcessInstance(String processDefinitionId) {
        if (!getTestProcessInstances().containsKey(processDefinitionId)) {
            getTestProcessInstances().put(processDefinitionId, new FluentProcessInstanceImpl(processDefinitionId));
        }
        return getTestProcessInstances().get(processDefinitionId);
    }

    public static FluentProcessInstance processInstance() {
        assertThat(getTestProcessInstances()).hasSize(1);
        return getTestProcessInstances().values().iterator().next();
    }

    public static ProcessDefinition processDefinition(String processDefinitionId) {
        List<ProcessDefinition> definitions = FluentLookups.getRepositoryService().createProcessDefinitionQuery()
                .processDefinitionName(processDefinitionId).list();

        assertThat(definitions)
                .overridingErrorMessage("Unable to find a deployed processInstance definition with name '%s'", processDefinitionId)
                .hasSize(1);

        return definitions.get(0);
    }

}