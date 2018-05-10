package CtCi_v6;

import java.util.*;

public class Prob4_7_BuildOrder {

    // Given a list of projects and list of dependencies, find a build order that will allow the projects to be built
    /*
        a,b,c,d,e,f
        (a,d),(f,b),(b,d),(f,a),(d,c)
     */
    public static void main(String[] args) {
        List<Project> projects = Arrays.asList(new Project('a'), new Project('b'), new Project('c'), new Project('d'), new Project('e'), new Project('f'));
        List<List<Project>> deps = Arrays.asList(
                Arrays.asList(projects.get(0), projects.get(3)),
                Arrays.asList(projects.get(5), projects.get(1)),
                Arrays.asList(projects.get(1), projects.get(3)),
                Arrays.asList(projects.get(5), projects.get(0)),
                Arrays.asList(projects.get(3), projects.get(2))
        );
        // Linear approach O(n^2) where n is # of projs
        System.out.println(buildOrder(projects, deps));

        System.out.println(buildOrdeDFS(projects,deps));
    }

    public static List<Project> buildOrdeDFS(List<Project> projects, List<List<Project>> dependencies) {
        List<Project> order = new ArrayList<>();
        if (projects == null || projects.isEmpty()) return order;
        dependencies.stream().forEach(l -> l.get(1).setDependentOn(l.get(0)));
        Set<Project> set = new HashSet<>();
        for (Project project : projects) {
            addIt(order, project, set);
        }
        return order;
    }

    private static void addIt(List<Project> order, Project project, Set<Project> set) {
        if (project == null)
            return;
        addIt(order, project.getDependentOn(), set);
        if (set.add(project))
            order.add(project);
    }

    public static List<Project> buildOrder(List<Project> projects, List<List<Project>> dependencies) {
        List<Project> order = new ArrayList<>();
        if (projects == null || projects.isEmpty()) return order;
        dependencies.stream().forEach(l -> l.get(1).setDependentOn(l.get(0)));

        for (Project project : projects) {
            int first = order.indexOf(project.getDependentOn());
            int second = order.indexOf(project);

            if (first == -1 && second == -1) {
                order.add(project.getDependentOn());
                order.add(project);
            }
            else if (first == -1 && second != -1) {
                order.add(second, project.getDependentOn());
            }
            else if (first != -1 && second == -1)
                order.add(project);
            else {
                if (first > second) {
                    order.remove(first);
                    order.add(second, project.getDependentOn());
                }
            }
        }

        order.remove(0);

        return order;
    }
}

class Project {
    private char p_name;
    private Project dependentOn;
    public Project(char c) {
        p_name = c;
    }

    public Project getDependentOn() {
        return dependentOn;
    }

    public void setDependentOn(Project dependentOn) {
        this.dependentOn = dependentOn;
    }

    @Override
    public String toString() {
        return p_name+" ";
    }
}