class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        // Make the adjacency matrix
        // Basically, all the courses that depend on a given course
        List<List<Integer>> adjacencyMatrix = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyMatrix.add(new ArrayList<>());
        }


        // Populate the indegree array 

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            // We get from the adj matrix the index from passin in the prereq because the adj matrix is for all the dependents of a given course. so we are looking to get the list of the dependents of the prereq course, so we can add a course to that list
            adjacencyMatrix.get(prereq).add(course);
            indegree[course]++;
        }


        // Now we do BFS

        Queue<Integer> queue = new ArrayDeque<>();


        // add courses with indegree 0 because they dont need prereqs so we can do those first
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int coursesTaken = 0;
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            coursesTaken++;
            indegree[course]--;

            for (int dependent : adjacencyMatrix.get(course)) {
                indegree[dependent]--;
                if (indegree[dependent] == 0) queue.offer(dependent);
            }
        }

        return coursesTaken == numCourses;
    }
}











