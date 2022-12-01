package graph;

import staff.Graph;
import staff.Vertex;
import java.util.*;

public class AdjacencyListGraph implements Graph {
  public void addVertex(Vertex v) {
    if (adjList.containsKey(v)) {
      return;
    }
    adjList.put(v, new HashSet<Vertex>());
  }

  public void addEdge(Vertex v1, Vertex v2) {
    if (!adjList.containsKey(v1) || !adjList.containsKey(v2)) {
      return;
    }
    adjList.get(v1).add(v2);
  }

  public boolean edgeExists(Vertex v1, Vertex v2) {
    if (!adjList.containsKey(v1) || !adjList.containsKey(v2)) {
      return false;
    } else if (adjList.get(v1).contains(v2)) {
      return true;
    }
    return false;
  }

  public List<Vertex> getDownstreamNeighbors(Vertex v) {
    List<Vertex> downstream = new ArrayList<Vertex>();
    if (!adjList.containsKey(v)) {
      return downstream;
    }
    for (Vertex v1 : adjList.get(v)) {
      downstream.add(v1);
    }
    return downstream;
  }

  public List<Vertex> getUpstreamNeighbors(Vertex v) {
    List<Vertex> upstream = new ArrayList<Vertex>();
    if (!adjList.containsKey(v)) {
      return upstream;
    }
    for (Vertex v1 : adjList.keySet()) {
      if (adjList.get(v1).contains(v)) {
        upstream.add(v1);
      }
    }
    return upstream;
  }

  public List<Vertex> getVertices() {
    List<Vertex> vertices = new ArrayList<Vertex>();
    for (Vertex v : adjList.keySet()) {
      vertices.add(v);
    }
    return vertices;
  }

  private Map<Vertex, Set<Vertex>> adjList = new HashMap<Vertex, Set<Vertex>>();

}
