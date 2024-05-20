package com.akash.assignmentstack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Job {
    private String name;
    private int processingTime;
    private int waitingTime;
    private int turnaroundTime;

    public Job(String name, int processingTime) {
        this.name = name;
        this.processingTime = processingTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }

    public String getName() {
        return name;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }
}

public class Question3 {

    public static void main(String[] args) {
        int numJobs = 5;
        int maxProcessingTime = 10;
        simulateJobScheduling(numJobs, maxProcessingTime);
    }

    public static void simulateJobScheduling(int numJobs, int maxProcessingTime) {
        Queue<Job> jobsQueue = new LinkedList<>();
        Random random = new Random();
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        for (int i = 0; i < numJobs; i++) {
            String jobName = "Job" + (i + 1);
            int processingTime = random.nextInt(maxProcessingTime) + 1;
            Job job = new Job(jobName, processingTime);
            jobsQueue.add(job);
        }

        int currentTime = 0;

        while (!jobsQueue.isEmpty()) {
            Job currentJob = jobsQueue.poll();

            currentJob.setWaitingTime(currentTime);

            System.out.println("Processing " + currentJob.getName() + " (Time needed: " + currentJob.getProcessingTime() + ")");
            currentTime += currentJob.getProcessingTime();

            currentJob.setTurnaroundTime(currentTime);

            totalWaitingTime += currentJob.getWaitingTime();
            totalTurnaroundTime += currentJob.getTurnaroundTime() - currentJob.getWaitingTime();
        }

        double avgWaitingTime = (double) totalWaitingTime / numJobs;
        double avgTurnaroundTime = (double) totalTurnaroundTime / numJobs;

        System.out.println("\nJob scheduling simulation results:");
        System.out.println("Total number of jobs: " + numJobs);
        System.out.printf("Average waiting time: %.2f units\n", avgWaitingTime);
        System.out.printf("Average turnaround time: %.2f units\n", avgTurnaroundTime);
    }
}