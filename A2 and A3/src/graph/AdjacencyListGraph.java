package graph;

import staff.Graph;
import staff.Vertex;
import java.util.*;

public class AdjacencyListGraph implements Graph {
  public void addVertex(Vertex v) {
    if (adjVertices.containsKey(v)) {
      return;
    }
    adjVertices.put(v, new ArrayList<Vertex>());
  }

  public void addEdge(Vertex v1, Vertex v2) {
    if (!adjVertices.containsKey(v1) || !adjVertices.containsKey(v2)) {
      return;
    }
    adjVertices.get(v1).add(v2);
  }

  public boolean edgeExists(Vertex v1, Vertex v2) {
    if (!adjVertices.containsKey(v1) || !adjVertices.containsKey(v2)) {
      return false;
    }
    return adjVertices.get(v1).contains(v2);
  }

  public List<Vertex> getDownstreamNeighbors(Vertex v) {
    if (!adjVertices.containsKey(v)) {
      return new ArrayList<Vertex>();
    }
    return adjVertices.get(v);
  }

  public List<Vertex> getUpstreamNeighbors(Vertex v) {
    List<Vertex> upstream = new ArrayList<Vertex>();
    for (Vertex v1 : adjVertices.keySet()) {
      if (adjVertices.get(v1).contains(v)) {
        upstream.add(v1);
      }
    }
    return upstream;
  }

  public List<Vertex> getVertices() {
    return new ArrayList<Vertex>(adjVertices.keySet());
  }

  public Map<Vertex, List<Vertex>> adjVertices;

  public AdjacencyListGraph() {
    adjVertices = new HashMap<Vertex, List<Vertex>>();
  }

}
