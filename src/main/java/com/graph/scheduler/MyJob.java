package com.graph.scheduler;

import com.graph.algorithms.FraudDetection;
import com.graph.algorithms.GraphBuilder;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("🔍 Executing MyJob: Running Fraud Detection...");

        try {
            // Step 1: Build the graph
            GraphBuilder builder = new GraphBuilder();
            Graph<String, DefaultEdge> graph = builder.getGraph();

            // Sample graph building (you may replace it with actual data loading)
            builder.addVertex("User1");
            builder.addVertex("Role1");
            builder.addVertex("Privilege1");
            builder.addEdge("User1", "Role1");
            builder.addEdge("Role1", "Privilege1");

            // Step 2: Run Fraud Detection Algorithms
            FraudDetection detection = new FraudDetection();
            detection.detectSODViolations(graph);
            detection.detectRoleCycles(graph);
            detection.detectPrivilegeEscalation(graph, "ADMIN");

            System.out.println("✅ Fraud Detection Completed Successfully.");

        } catch (Exception e) {
            System.err.println("❌ Error during Fraud Detection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}