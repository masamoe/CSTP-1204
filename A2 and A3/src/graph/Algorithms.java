package graph;

import staff.Graph;
import staff.Vertex;
import java.util.*;

public class Algorithms {

  /**
   * *********************** Algorithms ****************************
   * 
   * Please see the README for the machine problem for a more detailed
   * specification of the behavior of each method that one should implement.
   */

  /**
   * This is provided as an example to indicate that this method and other
   * methods should be implemented here.
   * 
   * You should write the specs for this and all other methods.
   * 
   * @param graph
   * @param a
   * @param b
   * @return
   */
  public static int shortestDistance(Graph graph, Vertex a, Vertex b) throws IllegalArgumentException {
    if (!graph.getVertices().contains(a) || !graph.getVertices().contains(b)) {
      return -1;
    }
    if (a.equals(b)) {
      IllegalArgumentException e = new IllegalArgumentException();
      throw e;
    }
    Queue<Vertex> queue = new LinkedList<Vertex>();
    Map<Vertex, Integer> distance = new HashMap<Vertex, Integer>();
    for (Vertex v : graph.getVertices()) {
      distance.put(v, -1);
    }
    distance.put(a, 0);
    queue.add(a);
    while (!queue.isEmpty()) {
      Vertex v = queue.remove();
      for (Vertex w : graph.getDownstreamNeighbors(v)) {
        if (distance.get(w) == -1) {
          distance.put(w, distance.get(v) + 1);
          queue.add(w);
        }
      }
    }
    return distance.get(b);
  }

  public static List<Vertex> commonUpStream(Graph graph, Vertex a, Vertex b) {
    List<Vertex> common = new ArrayList<Vertex>();
    if (!graph.getVertices().contains(a) || !graph.getVertices().contains(b)) {
      return common;
    }
    for (Vertex v : graph.getUpstreamNeighbors(a)) {
      if (graph.getUpstreamNeighbors(b).contains(v)) {
        common.add(v);
      }
    }
    return common;
  }

  public static List<Vertex> commonDownStream(Graph graph, Vertex a, Vertex b) {
    List<Vertex> common = new ArrayList<Vertex>();
    if (!graph.getVertices().contains(a) || !graph.getVertices().contains(b)) {
      return common;
    }
    for (Vertex v : graph.getDownstreamNeighbors(a)) {
      if (graph.getDownstreamNeighbors(b).contains(v)) {
        common.add(v);
      }
    }
    return common;
  }

  public static List<Vertex> commonInfluencers(Graph graph, Vertex a, Vertex b) {
    List<Vertex> common = new ArrayList<Vertex>();
    for (Vertex v : graph.getUpstreamNeighbors(a)) {
      if (graph.getUpstreamNeighbors(b).contains(v)) {
        common.add(v);
      }
    }
    return common;
  }

  public static List<Vertex> numRetweets(Graph graph, Vertex a, Vertex b) {
    List<Vertex> retweets = new ArrayList<Vertex>();
    for (Vertex v : graph.getVertices()) {
      if (graph.getDownstreamNeighbors(v).contains(a) && graph.getDownstreamNeighbors(v).contains(b)) {
        retweets.add(v);
      }
    }
    return retweets;
  }

  public static Set<List<Vertex>> breadthFirstSearch(Graph aGraph) {
    Set<List<Vertex>> paths = new HashSet<List<Vertex>>();
    Queue<Vertex> queue = new LinkedList<Vertex>();
    Map<Vertex, Vertex> parent = new HashMap<Vertex, Vertex>();
    for (Vertex v : aGraph.getVertices()) {
      parent.put(v, null);
    }
    for (Vertex v : aGraph.getVertices()) {
      if (parent.get(v) == null) {
        queue.add(v);
        parent.put(v, v);
        while (!queue.isEmpty()) {
          Vertex u = queue.remove();
          for (Vertex w : aGraph.getDownstreamNeighbors(u)) {
            if (parent.get(w) == null) {
              parent.put(w, u);
              queue.add(w);
            }
          }
        }
      }
    }
    for (Vertex v : aGraph.getVertices()) {
      List<Vertex> path = new ArrayList<Vertex>();
      Vertex u = v;
      while (u != parent.get(u)) {
        path.add(u);
        u = parent.get(u);
      }
      path.add(u);
      Collections.reverse(path);
      paths.add(path);
    }
    return paths;
  }

  public static Set<List<Vertex>> depthFirstSearch(Graph graph) {
    Set<List<Vertex>> paths = new HashSet<List<Vertex>>();
    Queue<Vertex> queue = new LinkedList<Vertex>();
    Map<Vertex, Vertex> parent = new HashMap<Vertex, Vertex>();
    for (Vertex v : graph.getVertices()) {
      parent.put(v, null);
    }
    for (Vertex v : graph.getVertices()) {
      if (parent.get(v) == null) {
        queue.add(v);
        parent.put(v, v);
        while (!queue.isEmpty()) {
          Vertex u = queue.remove();
          for (Vertex w : graph.getDownstreamNeighbors(u)) {
            if (parent.get(w) == null) {
              parent.put(w, u);
              queue.add(w);
            }
          }
        }
      }
    }
    for (Vertex v : graph.getVertices()) {
      List<Vertex> path = new ArrayList<Vertex>();
      Vertex u = v;
      while (u != parent.get(u)) {
        path.add(u);
        u = parent.get(u);
      }
      path.add(u);
      Collections.reverse(path);
      paths.add(path);
    }
    return paths;
  }

}
