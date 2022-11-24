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
  public static int shortestDistance(Graph graph, Vertex a, Vertex b) {
    if (!graph.getVertices().contains(a) || !graph.getVertices().contains(b)) {
      return -1;
    }
    if (a.equals(b)) {
      return 0;
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

  public static List<Vertex> commonUpstreamVertices(Graph graph, Vertex a, Vertex b) {
    List<Vertex> common = new ArrayList<Vertex>();
    for (Vertex v : graph.getUpstreamNeighbors(a)) {
      if (graph.getUpstreamNeighbors(b).contains(v)) {
        common.add(v);
      }
    }
    return common;
  }

  public static List<Vertex> commonDownstreamVertices(Graph graph, Vertex a, Vertex b) {
    List<Vertex> common = new ArrayList<Vertex>();
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

  public Set<List<Vertex>> breadthFirstSearch(Graph graph, Vertex start) {
    Set<List<Vertex>> paths = new HashSet<List<Vertex>>();
    Queue<List<Vertex>> queue = new LinkedList<List<Vertex>>();
    List<Vertex> path = new ArrayList<Vertex>();
    path.add(start);
    queue.add(path);
    while (!queue.isEmpty()) {
      path = queue.remove();
      Vertex last = path.get(path.size() - 1);
      if (last.equals(start)) {
        paths.add(path);
      }
      for (Vertex v : graph.getDownstreamNeighbors(last)) {
        if (!path.contains(v)) {
          List<Vertex> newPath = new ArrayList<Vertex>(path);
          newPath.add(v);
          queue.add(newPath);
        }
      }
    }
    return paths;
  }

  public Set<List<Vertex>> depthFirstSearch(Graph graph, Vertex start) {
    Set<List<Vertex>> paths = new HashSet<List<Vertex>>();
    Stack<List<Vertex>> stack = new Stack<List<Vertex>>();
    List<Vertex> path = new ArrayList<Vertex>();
    path.add(start);
    stack.push(path);
    while (!stack.isEmpty()) {
      path = stack.pop();
      Vertex last = path.get(path.size() - 1);
      if (last.equals(start)) {
        paths.add(path);
      }
      for (Vertex v : graph.getDownstreamNeighbors(last)) {
        if (!path.contains(v)) {
          List<Vertex> newPath = new ArrayList<Vertex>(path);
          newPath.add(v);
          stack.push(newPath);
        }
      }
    }
    return paths;
  }

}
