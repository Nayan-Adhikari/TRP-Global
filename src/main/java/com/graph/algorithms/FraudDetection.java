package com.graph.algorithms;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.alg.cycle.CycleDetector;

import java.util.Set;

public class FraudDetection {

    // 🔴 Detect SoD Violations
    public void detectSODViolations(Graph<String, DefaultEdge> graph) {
        System.out.println("\n🔴 Detecting Segregation of Duties (SoD) Violations:");
        for (String node : graph.vertexSet()) {
            Set<DefaultEdge> edges = graph.outgoingEdgesOf(node);
            for (DefaultEdge edge : edges) {
                String target = graph.getEdgeTarget(edge);
                if (graph.containsEdge(target, node)) {
                    System.out.println("🚩 Conflict detected between " + node + " and " + target);
                }
            }
        }
    }

    // 🔄 Detect Circular Role Hierarchies
    public void detectRoleCycles(Graph<String, DefaultEdge> graph) {
        CycleDetector<String, DefaultEdge> cycleDetector = new CycleDetector<>(graph);
        Set<String> cycleNodes = cycleDetector.findCycles();

        if (!cycleNodes.isEmpty()) {
            System.out.println("\n🔴 Circular Role Hierarchy Detected:");
            cycleNodes.forEach(node -> System.out.println("🚩 Role in Cycle: " + node));
        } else {
            System.out.println("\n✅ No Circular Role Hierarchy Detected.");
        }
    }

    // 🚨 Detect Privilege Escalation
    public void detectPrivilegeEscalation(Graph<String, DefaultEdge> graph, String adminPrivilege) {
        System.out.println("\n🚨 Detecting Privilege Escalation:");
        for (String node : graph.vertexSet()) {
            Set<DefaultEdge> edges = graph.outgoingEdgesOf(node);
            for (DefaultEdge edge : edges) {
                String target = graph.getEdgeTarget(edge);
                if (target.equals(adminPrivilege)) {
                    System.out.println("⚠ Escalation detected: " + node + " -> " + target);
                }
            }
        }
    }
}
