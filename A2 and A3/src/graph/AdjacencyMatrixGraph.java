package graph;

import staff.Graph;
import staff.Vertex;
import java.util.*;

public class AdjacencyMatrixGraph implements Graph {

  public void addVertex(Vertex v) {
    if (adjMatrix.containsKey(v)) {
      return;
    }
    adjMatrix.put(v, new HashMap<Vertex, Boolean>());
    for (Vertex v1 : adjMatrix.keySet()) {
      adjMatrix.get(v1).put(v, false);
      adjMatrix.get(v).put(v1, false);
    }
  }

  public void addEdge(Vertex v1, Vertex v2) {
    if (!adjMatrix.containsKey(v1) || !adjMatrix.containsKey(v2)) {
      return;
    }
    adjMatrix.get(v1).put(v2, true);
  }

  public boolean edgeExists(Vertex v1, Vertex v2) {
    if (!adjMatrix.containsKey(v1) || !adjMatrix.containsKey(v2)) {
      return false;
    } else if (adjMatrix.get(v1).get(v2)) {
      return true;
    }
    return false;
  }

  public List<Vertex> getDownstreamNeighbors(Vertex v) {
    List<Vertex> downstream = new ArrayList<Vertex>();
    if (!adjMatrix.containsKey(v)) {
      return downstream;
    }
    for (Vertex v1 : adjMatrix.get(v).keySet()) {
      if (adjMatrix.get(v).get(v1)) {
        downstream.add(v1);
      }
    }
    return downstream;
  }

  public List<Vertex> getUpstreamNeighbors(Vertex v) {
    List<Vertex> upstream = new ArrayList<Vertex>();
    if (!adjMatrix.containsKey(v)) {
      return upstream;
    }
    for (Vertex v1 : adjMatrix.keySet()) {
      if (adjMatrix.get(v1).get(v)) {
        upstream.add(v1);
      }
    }
    return upstream;
  }

  public List<Vertex> getVertices() {
    List<Vertex> vertices = new ArrayList<Vertex>();
    for (Vertex v : adjMatrix.keySet()) {
      vertices.add(v);
    }
    return vertices;
  }

  private Map<Vertex, Map<Vertex, Boolean>> adjMatrix = new HashMap<Vertex, Map<Vertex, Boolean>>();

  public AdjacencyMatrixGraph() {
    adjMatrix = new HashMap<Vertex, Map<Vertex, Boolean>>();
  }

}
