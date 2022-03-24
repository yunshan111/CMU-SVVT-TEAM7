package edu.stanford.nlp.graph;

import java.util.*;

import edu.stanford.nlp.util.CollectionUtils;
import junit.framework.TestCase;

public class DirectedMultiGraphTest extends TestCase {

  DirectedMultiGraph<Integer, String> graph =
          new DirectedMultiGraph<Integer, String>();
  public DirectedMultiGraph<Integer, String> g = new DirectedMultiGraph<Integer, String>();

  public void setUp() {
    graph.clear();

  }

  /**
   * Check that the graph's incoming and outgoing edges are consistent.
   */
  public void test_add_sourceNotExist_desNotExist_edgeNotExist_dataNotExist() {

    g.add(1, 2, "data1");
    assertEquals(2, g.getNumVertices());
    assertEquals(1, g.getNumEdges());
  }
  public void test_add_sourceNotExist_desExist_edgeNotExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    assertEquals(3, g.getNumVertices());
    assertEquals(2, g.getNumEdges());
  }

  public void test_add_sourceNotExist_desExist_edgeExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    assertEquals(4, g.getNumVertices());
    assertEquals(3, g.getNumEdges());
  }

  public void test_add_sourceExist_desExist_edgeNotExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    assertEquals(4, g.getNumVertices());
    assertEquals(4, g.getNumEdges());
  }

  public void test_add_sourceExist_desNotExist_edgeNotExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    g.add(3, 5, "data5");
    assertEquals(5, g.getNumVertices());
    assertEquals(5, g.getNumEdges());
  }

  public void test_add_sourceExist_desExist_edgeExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    g.add(3, 5, "data5");
    g.add(1, 2, "data6");
    assertEquals(5, g.getNumVertices());
    assertEquals(6, g.getNumEdges());
  }

  public void test_add_sourceExist_desNotExist_edgeExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    g.add(3, 5, "data5");
    g.add(1, 2, "data6");
    g.add(3, 6, "data7");
    assertEquals(6, g.getNumVertices());
    assertEquals(7, g.getNumEdges());
  }

  public void test_add_sourceNotExist_desNotExist_edgeExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    g.add(3, 5, "data5");
    g.add(1, 2, "data6");
    g.add(3, 6, "data7");
    g.add(7, 8, "data8");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceExist_desExist_edgeExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    g.add(3, 5, "data5");
    g.add(1, 2, "data6");
    g.add(3, 6, "data7");
    g.add(7, 8, "data8");
    g.removeEdge(1, 2, "data9");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceExist_desExist_edgeNotExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    g.add(3, 5, "data5");
    g.add(1, 2, "data6");
    g.add(3, 6, "data7");
    g.add(7, 8, "data8");
    g.removeEdge(1, 7, "data10");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceExist_desNotExist_edgeExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    g.add(3, 5, "data5");
    g.add(1, 2, "data6");
    g.add(3, 6, "data7");
    g.add(7, 8, "data8");
    g.removeEdge(3, 9, "data11");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceExist_desNotExist_edgeNotExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    g.add(3, 5, "data5");
    g.add(1, 2, "data6");
    g.add(3, 6, "data7");
    g.add(7, 8, "data8");
    g.removeEdge(7, 10, "data12");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceNotExist_desExist_edgeExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    g.add(3, 5, "data5");
    g.add(1, 2, "data6");
    g.add(3, 6, "data7");
    g.add(7, 8, "data8");
    g.removeEdge(11, 5, "data13");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceNotExist_desExist_edgeNotExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    g.add(3, 5, "data5");
    g.add(1, 2, "data6");
    g.add(3, 6, "data7");
    g.add(7, 8, "data8");
    g.removeEdge(12, 2, "data14");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceNotExist_desNotExist_edgeExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    g.add(3, 5, "data5");
    g.add(1, 2, "data6");
    g.add(3, 6, "data7");
    g.add(7, 8, "data8");
    g.removeEdge(13, 14, "data15");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceNotExist_desNotExist_edgeNotExist_dataNotExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data2");
    g.add(2, 4, "data3");
    g.add(1, 4, "data4");
    g.add(3, 5, "data5");
    g.add(1, 2, "data6");
    g.add(3, 6, "data7");
    g.add(7, 8, "data8");
    g.removeEdge(15, 16, "data16");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_add_sourceNotExist_desNotExist_edgeNotExist_dataExist() {

    g.add(1, 2, "data1");
    assertEquals(2, g.getNumVertices());
    assertEquals(1, g.getNumEdges());
  }
  public void test_add_sourceNotExist_desExist_edgeNotExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    assertEquals(3, g.getNumVertices());
    assertEquals(2, g.getNumEdges());
  }

  public void test_add_sourceNotExist_desExist_edgeExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    assertEquals(4, g.getNumVertices());
    assertEquals(3, g.getNumEdges());
  }

  public void test_add_sourceExist_desExist_edgeNotExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    assertEquals(4, g.getNumVertices());
    assertEquals(4, g.getNumEdges());
  }

  public void test_add_sourceExist_desNotExist_edgeNotExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    g.add(3, 5, "data1");
    assertEquals(5, g.getNumVertices());
    assertEquals(5, g.getNumEdges());
  }

  public void test_add_sourceExist_desExist_edgeExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    g.add(3, 5, "data1");
    g.add(1, 2, "data1");
    assertEquals(5, g.getNumVertices());
    assertEquals(6, g.getNumEdges());
  }

  public void test_add_sourceExist_desNotExist_edgeExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    g.add(3, 5, "data1");
    g.add(1, 2, "data1");
    g.add(3, 6, "data1");
    assertEquals(6, g.getNumVertices());
    assertEquals(7, g.getNumEdges());
  }

  public void test_add_sourceNotExist_desNotExist_edgeExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    g.add(3, 5, "data1");
    g.add(1, 2, "data1");
    g.add(3, 6, "data1");
    g.add(7, 8, "data1");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceExist_desExist_edgeExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    g.add(3, 5, "data1");
    g.add(1, 2, "data1");
    g.add(3, 6, "data1");
    g.add(7, 8, "data1");
    g.removeEdge(1, 2, "data1");
    assertEquals(8, g.getNumVertices());
    assertEquals(7, g.getNumEdges());
  }

  public void test_remove_sourceExist_desExist_edgeNotExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    g.add(3, 5, "data1");
    g.add(1, 2, "data1");
    g.add(3, 6, "data1");
    g.add(7, 8, "data1");
    g.removeEdge(1, 7, "data1");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceExist_desNotExist_edgeExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    g.add(3, 5, "data1");
    g.add(1, 2, "data1");
    g.add(3, 6, "data1");
    g.add(7, 8, "data1");
    g.removeEdge(3, 9, "data1");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceExist_desNotExist_edgeNotExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    g.add(3, 5, "data1");
    g.add(1, 2, "data1");
    g.add(3, 6, "data1");
    g.add(7, 8, "data1");
    g.removeEdge(7, 10, "data1");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceNotExist_desExist_edgeExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    g.add(3, 5, "data1");
    g.add(1, 2, "data1");
    g.add(3, 6, "data1");
    g.add(7, 8, "data1");
    g.removeEdge(11, 5, "data1");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceNotExist_desExist_edgeNotExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    g.add(3, 5, "data1");
    g.add(1, 2, "data1");
    g.add(3, 6, "data1");
    g.add(7, 8, "data1");
    g.removeEdge(12, 2, "data1");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceNotExist_desNotExist_edgeExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    g.add(3, 5, "data1");
    g.add(1, 2, "data1");
    g.add(3, 6, "data1");
    g.add(7, 8, "data1");
    g.removeEdge(13, 14, "data1");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceNotExist_desNotExist_edgeNotExist_dataExist() {
    g.add(1, 2, "data1");
    g.add(2, 3, "data1");
    g.add(2, 4, "data1");
    g.add(1, 4, "data1");
    g.add(3, 5, "data1");
    g.add(1, 2, "data1");
    g.add(3, 6, "data1");
    g.add(7, 8, "data1");
    g.removeEdge(15, 16, "data1");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_add_sourceNotExist_desNotExist_edgeNotExist() {

    g.add(1, 2, "");
    assertEquals(2, g.getNumVertices());
    assertEquals(1, g.getNumEdges());
  }
  public void test_add_sourceNotExist_desExist_edgeNotExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    assertEquals(3, g.getNumVertices());
    assertEquals(2, g.getNumEdges());
  }

  public void test_add_sourceNotExist_desExist_edgeExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    assertEquals(4, g.getNumVertices());
    assertEquals(3, g.getNumEdges());
  }

  public void test_add_sourceExist_desExist_edgeNotExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    assertEquals(4, g.getNumVertices());
    assertEquals(4, g.getNumEdges());
  }

  public void test_add_sourceExist_desNotExist_edgeNotExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    g.add(3, 5, "");
    assertEquals(5, g.getNumVertices());
    assertEquals(5, g.getNumEdges());
  }

  public void test_add_sourceExist_desExist_edgeExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    g.add(3, 5, "");
    g.add(1, 2, "");
    assertEquals(5, g.getNumVertices());
    assertEquals(6, g.getNumEdges());
  }

  public void test_add_sourceExist_desNotExist_edgeExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    g.add(3, 5, "");
    g.add(1, 2, "");
    g.add(3, 6, "");
    assertEquals(6, g.getNumVertices());
    assertEquals(7, g.getNumEdges());
  }

  public void test_add_sourceNotExist_desNotExist_edgeExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    g.add(3, 5, "");
    g.add(1, 2, "");
    g.add(3, 6, "");
    g.add(7, 8, "");
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceExist_desExist_edgeExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    g.add(3, 5, "");
    g.add(1, 2, "");
    g.add(3, 6, "");
    g.add(7, 8, "");
    g.removeEdges(1, 2);
    assertEquals(8, g.getNumVertices());
    assertEquals(6, g.getNumEdges());
  }

  public void test_remove_sourceExist_desExist_edgeNotExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    g.add(3, 5, "");
    g.add(1, 2, "");
    g.add(3, 6, "");
    g.add(7, 8, "");
    g.removeEdges(1, 7);
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceExist_desNotExist_edgeExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    g.add(3, 5, "");
    g.add(1, 2, "");
    g.add(3, 6, "");
    g.add(7, 8, "");
    g.removeEdges(3, 9);
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceExist_desNotExist_edgeNotExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    g.add(3, 5, "");
    g.add(1, 2, "");
    g.add(3, 6, "");
    g.add(7, 8, "");
    g.removeEdges(7, 10);
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceNotExist_desExist_edgeExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    g.add(3, 5, "");
    g.add(1, 2, "");
    g.add(3, 6, "");
    g.add(7, 8, "");
    g.removeEdges(11, 5);
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceNotExist_desExist_edgeNotExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    g.add(3, 5, "");
    g.add(1, 2, "");
    g.add(3, 6, "");
    g.add(7, 8, "");
    g.removeEdges(12, 2);
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceNotExist_desNotExist_edgeExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    g.add(3, 5, "");
    g.add(1, 2, "");
    g.add(3, 6, "");
    g.add(7, 8, "");
    g.removeEdges(13, 14);
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }

  public void test_remove_sourceNotExist_desNotExist_edgeNotExist() {
    g.add(1, 2, "");
    g.add(2, 3, "");
    g.add(2, 4, "");
    g.add(1, 4, "");
    g.add(3, 5, "");
    g.add(1, 2, "");
    g.add(3, 6, "");
    g.add(7, 8, "");
    g.removeEdges(15, 16);
    assertEquals(8, g.getNumVertices());
    assertEquals(8, g.getNumEdges());
  }


  public void test_remove_collection_sourceExist() {
    g.add(1, 2, "");
    g.add(1, 4, "");
    Collection items = new ArrayList<>();
    items.add(1);
    items.add(2);
    boolean result = g.removeVertices(items);
    assertTrue(result);
    assertEquals(1, g.getNumVertices());
    assertEquals(0, g.getNumEdges());
  }

  public void test_remove_collection_sourceNotExist() {
    g.add(1, 2, "");
    g.add(1, 4, "");
    Collection items = new ArrayList<>();
    items.add(1);
    items.add(2);
    g.removeVertices(items);
    boolean result = g.removeVertices(items);
    assertFalse(result);
    assertEquals(1, g.getNumVertices());
    assertEquals(0, g.getNumEdges());
  }

  public void test_remove_vertex_sourceExist() {
    g.add(1, 2, "");
    g.add(1, 4, "");
    boolean result = g.removeVertex(1);
    assertTrue(result);
    assertEquals(2, g.getNumVertices());
    assertEquals(0, g.getNumEdges());
  }

  public void test_remove_vertex_sourceNotExist() {
    g.add(1, 2, "");
    g.add(1, 4, "");
    g.removeVertex(1);
    boolean result = g.removeVertex(1);
    assertFalse(result);
    assertEquals(2, g.getNumVertices());
    assertEquals(0, g.getNumEdges());
  }

  public void test_add_vertex_sourceExist() {
    g.add(1, 2, "");
    g.add(1, 4, "");
    g.addVertex(4);
    assertEquals(3, g.getNumVertices());
    assertEquals(2, g.getNumEdges());
  }

  public void test_add_vertex_sourceNotExist() {
    g.add(1, 2, "");
    g.add(1, 4, "");
    g.addVertex(5);
    assertEquals(4, g.getNumVertices());
    assertEquals(2, g.getNumEdges());
  }

  //********************************Step 2-2A1-1 2-2A2-1 2-2A1-2 2-2A2-2 - Test Cases ******************************************
  public void testFindShortestPathEdges_Sensitive_notZeroNode_ManyConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<String> nodes = graph.getShortestPathEdges(1, 4, directionSensitive);
    assertEquals(3, nodes.size());
//      System.out.println("directed path nodes btw 1 and 3 is " + nodes);
  }
  public void testFindShortestPathEdges_Sensitive_ZeroNode_ManyConnect_sourcenotExist_desnotExist_connectedGraph() {
    boolean directionSensitive = true;
    List<String> nodes = graph.getShortestPathEdges(1, 2, directionSensitive);
    assertNull(nodes);
  }
  public void testFindShortestPathEdges_Sensitive_notZeroNode_zeroConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    List<String> nodes = graph.getShortestPathEdges(1, 4, directionSensitive);
    assertEquals(null, nodes);
  }
  public void testFindShortestPathEdges_Sensitive_notZeroNode_oneConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    List<String> nodes = graph.getShortestPathEdges(1, 2, directionSensitive);
    assertEquals(1, nodes.size());
  }
  public void testFindShortestPathEdges_Sensitive_notZeroNode_twoConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    List<String> nodes = graph.getShortestPathEdges(1, 3, directionSensitive);
    assertEquals(2, nodes.size());
  }
  public void testFindShortestPathEdges_Sensitive_notZeroNode_tooManyConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    graph.add(4, 5, "4->5");
    graph.add(5, 6, "5->6");
    graph.add(6, 7, "6->7");
    graph.add(7, 8, "7->8");
    graph.add(8, 9, "8->9");
    graph.add(9, 10, "9->10");
    graph.add(10, 11, "10->11");
    graph.add(11, 12, "11->12");
    graph.add(12, 13, "12->13");
    List<String> nodes = graph.getShortestPathEdges(1, 13, directionSensitive);
    assertEquals(12, nodes.size());
  }
  public void testFindShortestPathEdges_Sensitive_notZeroNode_ManyConnect_sourceNotExist_desExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<String> nodes = graph.getShortestPathEdges(666, 4, directionSensitive);
    assertEquals(null, nodes);
  }
  public void testFindShortestPathEdges_Sensitive_notZeroNode_ManyConnect_sourceExist_desNotExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<String> nodes = graph.getShortestPathEdges(1, 44, directionSensitive);
    assertEquals(null, nodes);
  }
  public void testFindShortestPathEdges_Sensitive_notZeroNode_ManyConnect_sourceExist_desExist_disconnectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    List<String> nodes = graph.getShortestPathEdges(1, 5, directionSensitive);
    assertEquals(null, nodes);
  }

  public void testFindShortestPathEdges_notSensitive_notZeroNode_ManyConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<String> nodes = graph.getShortestPathEdges(1, 4, directionSensitive);
    assertEquals(3, nodes.size());
//      System.out.println("directed path nodes btw 1 and 3 is " + nodes);
  }
  public void testFindShortestPathEdges_notSensitive_ZeroNode_ManyConnect_sourcenotExist_desnotExist_connectedGraph() {
    boolean directionSensitive = false;
    List<String> nodes = graph.getShortestPathEdges(1, 2, directionSensitive);
    assertNull(nodes);
  }
  public void testFindShortestPathEdges_notSensitive_notZeroNode_zeroConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    List<String> nodes = graph.getShortestPathEdges(1, 4, directionSensitive);
    assertEquals(null, nodes);
  }
  public void testFindShortestPathEdges_notSensitive_notZeroNode_oneConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    List<String> nodes = graph.getShortestPathEdges(1, 2, directionSensitive);
    assertEquals(1, nodes.size());
  }
  public void testFindShortestPathEdges_notSensitive_notZeroNode_twoConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    List<String> nodes = graph.getShortestPathEdges(1, 3, directionSensitive);
    assertEquals(2, nodes.size());
  }
  public void testFindShortestPathEdges_notSensitive_notZeroNode_tooManyConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    graph.add(4, 5, "4->5");
    graph.add(5, 6, "5->6");
    graph.add(6, 7, "6->7");
    graph.add(7, 8, "7->8");
    graph.add(8, 9, "8->9");
    graph.add(9, 10, "9->10");
    graph.add(10, 11, "10->11");
    graph.add(11, 12, "11->12");
    graph.add(12, 13, "12->13");
    List<String> nodes = graph.getShortestPathEdges(1, 13, directionSensitive);
    assertEquals(12, nodes.size());
  }
  public void testFindShortestPathEdges_notSensitive_notZeroNode_ManyConnect_sourceNotExist_desExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<String> nodes = graph.getShortestPathEdges(16, 4, directionSensitive);
    assertEquals(null, nodes);
  }
  public void testFindShortestPathEdges_notSensitive_notZeroNode_ManyConnect_sourceExist_desNotExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<String> nodes = graph.getShortestPathEdges(1, 44, directionSensitive);
    assertEquals(null, nodes);
  }
  public void testFindShortestPathEdges_notSensitive_notZeroNode_ManyConnect_sourceExist_desExist_disconnectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    List<String> nodes = graph.getShortestPathEdges(1, 5, directionSensitive);
    assertEquals(null, nodes);
  }

  public void testFindShortestPathEdges_SensitiveNotInput_notZeroNode_ManyConnect_sourceExist_desExist_connectedGraph() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<String> nodes = graph.getShortestPathEdges(1, 4);
    assertNotNull(nodes);
    assertEquals("[1->2, 2->3, 3->4]", nodes.toString());
//      System.out.println("directed path nodes btw 1 and 3 is " + nodes);
  }
  public void testFindShortestPathEdges_SensitiveNotInput_ZeroNode_ManyConnect_sourcenotExist_desnotExist_connectedGraph() {
    List<String> nodes = graph.getShortestPathEdges(1, 2);
    assertNull(nodes);
  }
  public void testFindShortestPathEdges_SensitiveNotInput_notZeroNode_zeroConnect_sourceExist_desExist_connectedGraph() {
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    List<String> nodes = graph.getShortestPathEdges(1, 4);
    assertEquals(null, nodes);
  }
  public void testFindShortestPathEdges_SensitiveNotInput_notZeroNode_oneConnect_sourceExist_desExist_connectedGraph() {
    graph.add(1, 2, "1->2");
    List<String> nodes = graph.getShortestPathEdges(1, 2);
    assertNotNull(nodes);
    assertEquals(1, nodes.size());
  }
  public void testFindShortestPathEdges_SensitiveNotInput_notZeroNode_twoConnect_sourceExist_desExist_connectedGraph() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    List<String> nodes = graph.getShortestPathEdges(1, 3);
    assertNotNull(nodes);
    assertEquals(2, nodes.size());
  }
  public void testFindShortestPathEdges_SensitiveNotInput_notZeroNode_tooManyConnect_sourceExist_desExist_connectedGraph() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "4->3");
    graph.add(4, 5, "4->5");
    graph.add(5, 6, "5->6");
    graph.add(6, 7, "6->7");
    graph.add(7, 8, "7->8");
    graph.add(8, 9, "8->9");
    graph.add(9, 10, "9->10");
    graph.add(10, 11, "10->11");
    graph.add(11, 12, "11->12");
    graph.add(12, 13, "12->13");
    List<String> nodes = graph.getShortestPathEdges(1, 13);
    assertNotNull(nodes);
    assertEquals(12, nodes.size());
  }
  public void testFindShortestPathEdges_SensitiveNotInput_notZeroNode_ManyConnect_sourceNotExist_desExist_connectedGraph() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<String> nodes = graph.getShortestPathEdges(16, 4);
    assertEquals(null, nodes);
  }
  public void testFindShortestPathEdges_SensitiveNotInput_notZeroNode_ManyConnect_sourceExist_desNotExist_connectedGraph() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<String> nodes = graph.getShortestPathEdges(1, 44);
    assertEquals(null, nodes);
  }
  public void testFindShortestPathEdges_SensitiveNotInput_notZeroNode_ManyConnect_sourceExist_desExist_disconnectedGraph() {
//      graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.addVertex(1);
    List<String> nodes = graph.getShortestPathEdges(1, 4);
    assertEquals(null, nodes);
  }

  public void testFindShortestPath_Sensitive_notZeroNode_ManyConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<Integer> nodes = graph.getShortestPath(1, 4, directionSensitive);
    assertEquals(4, nodes.size());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
    assertEquals(3, nodes.get(2).intValue());
    assertEquals(3, nodes.get(2).intValue());
//      System.out.println("directed path nodes btw 1 and 3 is " + nodes);
  }
  public void testFindShortestPath_Sensitive_ZeroNode_ManyConnect_sourcenotExist_desnotExist_connectedGraph() {
    boolean directionSensitive = true;
    List<Integer> nodes = graph.getShortestPath(1, 2, directionSensitive);
    assertNull(nodes);
  }
  public void testFindShortestPath_Sensitive_notZeroNode_zeroConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    List<Integer> nodes = graph.getShortestPath(1, 4, directionSensitive);
    assertEquals(null, nodes);
  }
  public void testFindShortestPath_Sensitive_notZeroNode_oneConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    List<Integer> nodes = graph.getShortestPath(1, 2, directionSensitive);
    assertEquals(2, nodes.size());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
  }
  public void testFindShortestPath_Sensitive_notZeroNode_twoConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    List<Integer> nodes = graph.getShortestPath(1, 3, directionSensitive);
    assertEquals(3, nodes.size());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
    assertEquals(3, nodes.get(2).intValue());
  }
  public void testFindShortestPath_Sensitive_notZeroNode_tooManyConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    graph.add(4, 5, "4->5");
    graph.add(5, 6, "5->6");
    graph.add(6, 7, "6->7");
    graph.add(7, 8, "7->8");
    graph.add(8, 9, "8->9");
    graph.add(9, 10, "9->10");
    graph.add(10, 11, "10->11");
    graph.add(11, 12, "11->12");
    graph.add(12, 13, "12->13");
    List<Integer> nodes = graph.getShortestPath(1, 13, directionSensitive);
    assertEquals(13, nodes.size());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
    assertEquals(3, nodes.get(2).intValue());
    assertEquals(13, nodes.get(12).intValue());
  }
  public void testFindShortestPath_Sensitive_notZeroNode_ManyConnect_sourceNotExist_desExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<Integer> nodes = graph.getShortestPath(16, 4, directionSensitive);
    assertEquals(null, nodes);
  }
  public void testFindShortestPath_Sensitive_notZeroNode_ManyConnect_sourceExist_desNotExist_connectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<Integer> nodes = graph.getShortestPath(1, 44, directionSensitive);
    assertEquals(null, nodes);
  }
  public void testFindShortestPath_Sensitive_notZeroNode_ManyConnect_sourceExist_desExist_disconnectedGraph() {
    boolean directionSensitive = true;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    List<Integer> nodes = graph.getShortestPath(1, 5, directionSensitive);
    assertEquals(null, nodes);
  }

  public void testFindShortestPath_notSensitive_notZeroNode_ManyConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<Integer> nodes = graph.getShortestPath(1, 4, directionSensitive);
    assertEquals(4, nodes.size());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
    assertEquals(3, nodes.get(2).intValue());
    assertEquals(3, nodes.get(2).intValue());
//      System.out.println("directed path nodes btw 1 and 3 is " + nodes);
  }
  public void testFindShortestPath_notSensitive_ZeroNode_ManyConnect_sourcenotExist_desnotExist_connectedGraph() {
    boolean directionSensitive = false;
    List<Integer> nodes = graph.getShortestPath(1, 2, directionSensitive);
    assertNull(nodes);
  }
  public void testFindShortestPath_notSensitive_notZeroNode_zeroConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    List<Integer> nodes = graph.getShortestPath(1, 4, directionSensitive);
    assertEquals(null, nodes);
  }
  public void testFindShortestPath_notSensitive_notZeroNode_oneConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    List<Integer> nodes = graph.getShortestPath(1, 2, directionSensitive);
    assertEquals(2, nodes.size());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
  }
  public void testFindShortestPath_notSensitive_notZeroNode_twoConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    List<Integer> nodes = graph.getShortestPath(1, 3, directionSensitive);
    assertEquals(3, nodes.size());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
    assertEquals(3, nodes.get(2).intValue());
  }
  public void testFindShortestPath_notSensitive_notZeroNode_tooManyConnect_sourceExist_desExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    graph.add(4, 5, "4->5");
    graph.add(5, 6, "5->6");
    graph.add(6, 7, "6->7");
    graph.add(7, 8, "7->8");
    graph.add(8, 9, "8->9");
    graph.add(9, 10, "9->10");
    graph.add(10, 11, "10->11");
    graph.add(11, 12, "11->12");
    graph.add(12, 13, "12->13");
    List<Integer> nodes = graph.getShortestPath(1, 13, directionSensitive);
    assertEquals(13, nodes.size());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
    assertEquals(3, nodes.get(2).intValue());
    assertEquals(13, nodes.get(12).intValue());
  }
  public void testFindShortestPath_notSensitive_notZeroNode_ManyConnect_sourceNotExist_desExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<Integer> nodes = graph.getShortestPath(16, 4, directionSensitive);
    assertEquals(null, nodes);
  }
  public void testFindShortestPath_notSensitive_notZeroNode_ManyConnect_sourceExist_desNotExist_connectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<Integer> nodes = graph.getShortestPath(1, 44, directionSensitive);
    assertEquals(null, nodes);
  }
  public void testFindShortestPath_notSensitive_notZeroNode_ManyConnect_sourceExist_desExist_disconnectedGraph() {
    boolean directionSensitive = false;
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    List<Integer> nodes = graph.getShortestPath(1, 5, directionSensitive);
    assertEquals(null, nodes);
  }

  public void testFindShortestPath_SensitiveNotInput_notZeroNode_ManyConnect_sourceExist_desExist_connectedGraph() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<Integer> nodes = graph.getShortestPath(1, 4);
    assertNotNull(nodes);
    assertEquals("[1, 2, 3, 4]", nodes.toString());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
    assertEquals(3, nodes.get(2).intValue());
    assertEquals(3, nodes.get(2).intValue());
//      System.out.println("directed path nodes btw 1 and 3 is " + nodes);
  }
  public void testFindShortestPath_SensitiveNotInput_ZeroNode_ManyConnect_sourcenotExist_desnotExist_connectedGraph() {
    List<Integer> nodes = graph.getShortestPath(1, 2);
    assertNull(nodes);
  }
  public void testFindShortestPath_SensitiveNotInput_notZeroNode_zeroConnect_sourceExist_desExist_connectedGraph() {
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    List<Integer> nodes = graph.getShortestPath(1, 4);
    assertEquals(null, nodes);
  }
  public void testFindShortestPath_SensitiveNotInput_notZeroNode_oneConnect_sourceExist_desExist_connectedGraph() {
    graph.add(1, 2, "1->2");
    List<Integer> nodes = graph.getShortestPath(1, 2);
    assertNotNull(nodes);
    assertEquals("[1, 2]", nodes.toString());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
  }
  public void testFindShortestPath_SensitiveNotInput_notZeroNode_twoConnect_sourceExist_desExist_connectedGraph() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    List<Integer> nodes = graph.getShortestPath(1, 3);
    assertNotNull(nodes);
    assertEquals(3, nodes.size());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
    assertEquals(3, nodes.get(2).intValue());
  }
  public void testFindShortestPath_SensitiveNotInput_notZeroNode_tooManyConnect_sourceExist_desExist_connectedGraph() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "4->3");
    graph.add(4, 5, "4->5");
    graph.add(5, 6, "5->6");
    graph.add(6, 7, "6->7");
    graph.add(7, 8, "7->8");
    graph.add(8, 9, "8->9");
    graph.add(9, 10, "9->10");
    graph.add(10, 11, "10->11");
    graph.add(11, 12, "11->12");
    graph.add(12, 13, "12->13");
    List<Integer> nodes = graph.getShortestPath(1, 13);
    assertNotNull(nodes);
    assertEquals(13, nodes.size());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
    assertEquals(3, nodes.get(2).intValue());
    assertEquals(13, nodes.get(12).intValue());
  }
  public void testFindShortestPath_SensitiveNotInput_notZeroNode_ManyConnect_sourceNotExist_desExist_connectedGraph() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<Integer> nodes = graph.getShortestPath(16, 4);
    assertEquals(null, nodes);
  }
  public void testFindShortestPath_SensitiveNotInput_notZeroNode_ManyConnect_sourceExist_desNotExist_connectedGraph() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    List<Integer> nodes = graph.getShortestPath(1, 44);
    assertEquals(null, nodes);
  }
  public void testFindShortestPath_SensitiveNotInput_notZeroNode_ManyConnect_sourceExist_desExist_disconnectedGraph() {
//      graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.addVertex(1);
    List<Integer> nodes = graph.getShortestPath(1, 4);
    assertEquals(null, nodes);
  }

  //Step2A12-2
  public void testFindShortestPathEdges_notSameSourceAndDestiantion_terationNotOnlyOnce_ManyConnect() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    graph.add(4, 5, "4->5");
    List<String> nodes = graph.getShortestPathEdges(1, 5);
    assertNotNull(nodes);
    assertEquals(4, nodes.size());
    assertEquals("1->2", nodes.get(0).toString());
    assertEquals("2->3", nodes.get(1).toString());
    assertEquals("3->4", nodes.get(2).toString());
  }
  public void testFindShortestPathEdges_SameSourceAndDestiantion_terationNotOnlyOnce_ManyConnect() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    graph.add(4, 5, "4->5");
    List<String> nodes = graph.getShortestPathEdges(1, 1);
    assertNotNull(nodes);
    assertEquals(0, nodes.size());
//    assertEquals(1, nodes.get(0));
  }
  public void testFindShortestPathEdges_notSameSourceAndDestiantion_terationOnce_ManyConnect() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    graph.add(4, 5, "4->5");
    List<String> nodes = graph.getShortestPathEdges(1, 2);
    assertNotNull(nodes);
    assertEquals(1, nodes.size());
    assertEquals("1->2", nodes.get(0));
  }
  public void testFindShortestPathEdges_notSameSourceAndDestiantion_terationNotOnlyOnce_zeroConnect() {
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    List<String> nodes = graph.getShortestPathEdges(1, 3);
    assertEquals(null, nodes);
  }
  public void testFindShortestPathEdges_notSameSourceAndDestiantion_terationNotOnlyOnce_oneConnect() {
    graph.addVertex(1);
    graph.add(2, 3, "2->3");
    List<String> nodes = graph.getShortestPathEdges(1, 3);
    assertEquals(null, nodes);
  }
  public void testFindShortestPathEdges_notSameSourceAndDestiantion_terationNotOnlyOnce_twoConnect() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    List<String> nodes = graph.getShortestPathEdges(1, 3);
    assertNotNull(nodes);
    assertEquals(2, nodes.size());
  }
  public void testFindShortestPathEdges_notSameSourceAndDestiantion_terationNotOnlyOnce_tooManyConnect() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    graph.add(4, 5, "4->5");
    graph.add(5, 6, "5->6");
    graph.add(6, 7, "6->7");
    graph.add(7, 8, "7->8");
    graph.add(8, 9, "8->9");
    graph.add(9, 10, "9->10");
    graph.add(10, 11, "10->11");
    graph.add(11, 12, "11->12");
    graph.add(12, 13, "12->13");
    List<String> nodes = graph.getShortestPathEdges(1, 3);
    assertNotNull(nodes);
    assertEquals(2, nodes.size());
  }
  //
  public void testFindShortestPath_notSameSourceAndDestiantion_terationNotOnlyOnce_ManyConnect() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    graph.add(4, 5, "4->5");
    List<Integer> nodes = graph.getShortestPath(1, 5);
    assertNotNull(nodes);
    assertEquals("[1, 2, 3, 4, 5]", nodes.toString());
    assertEquals(1, nodes.get(0).intValue());
    assertEquals(2, nodes.get(1).intValue());
    assertEquals(3, nodes.get(2).intValue());
  }

  public void testFindShortestPath_SameSourceAndDestiantion_terationNotOnlyOnce_ManyConnect() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    graph.add(4, 5, "4->5");
    List<Integer> nodes = graph.getShortestPath(1, 1);
    assertNotNull(nodes);
    assertEquals("[1]", nodes.toString());
    assertEquals(1, nodes.get(0).intValue());
  }
  public void testFindShortestPath_notSameSourceAndDestiantion_terationOnce_ManyConnect() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    graph.add(4, 5, "4->5");
    List<Integer> nodes = graph.getShortestPath(1, 2);
    assertNotNull(nodes);
    assertEquals("[1, 2]", nodes.toString());
    assertEquals(1, nodes.get(0).intValue());
  }
  public void testFindShortestPath_notSameSourceAndDestiantion_terationNotOnlyOnce_zeroConnect() {
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    List<Integer> nodes = graph.getShortestPath(1, 3);
    assertEquals(null, nodes);
  }
  public void testFindShortestPath_notSameSourceAndDestiantion_terationNotOnlyOnce_oneConnect() {
    graph.addVertex(1);
    graph.add(2, 3, "2->3");
    List<Integer> nodes = graph.getShortestPath(1, 3);
    assertEquals(null, nodes);
  }
  public void testFindShortestPath_notSameSourceAndDestiantion_terationNotOnlyOnce_twoConnect() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    List<Integer> nodes = graph.getShortestPath(1, 3);
    assertNotNull(nodes);
    assertEquals("[1, 2, 3]", nodes.toString());
  }
  public void testFindShortestPath_notSameSourceAndDestiantion_terationNotOnlyOnce_tooManyConnect() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
    graph.add(4, 5, "4->5");
    graph.add(5, 6, "5->6");
    graph.add(6, 7, "6->7");
    graph.add(7, 8, "7->8");
    graph.add(8, 9, "8->9");
    graph.add(9, 10, "9->10");
    graph.add(10, 11, "10->11");
    graph.add(11, 12, "11->12");
    graph.add(12, 13, "12->13");
    List<Integer> nodes = graph.getShortestPath(1, 3);
    assertNotNull(nodes);
    assertEquals(3, nodes.size());
  }

  //********************************Step 2-2B - Test Cases ******************************************

  public void testRemoveZeroDegreeNodes_connected_nodeExist_containOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.add(5, 4, "5->4");
    graph.add(5, 6, "5->6");
    graph.addVertex(9);
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(true, graph.containsVertex(4));
  }
  public void testRemoveZeroDegreeNodes_connected_nodeNotExist_containOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.add(5, 4, "5->4");
    graph.add(5, 6, "5->6");
    graph.addVertex(9);
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(false, graph.containsVertex(99));
  }
  public void testRemoveZeroDegreeNodes_connected_nodeExist_notContainOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.add(5, 4, "5->4");
    graph.add(5, 6, "5->6");
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(true, graph.containsVertex(4));
  }
  public void testRemoveZeroDegreeNodes_connected_nodeNotExist_notContainOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.add(5, 4, "5->4");
    graph.add(5, 6, "5->6");
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(false, graph.containsVertex(99));
  }
  //
  public void testRemoveZeroDegreeNodes_zeroDegreeIncoming_nodeExist_containOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.addVertex(9);
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(true, graph.containsVertex(4));
  }
  public void testRemoveZeroDegreeNodes_zeroDegreeIncoming_nodeNotExist_containOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.addVertex(9);
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(false, graph.containsVertex(99));
  }
  public void testRemoveZeroDegreeNodes_zeroDegreeIncoming_nodeExist_notContainOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(true, graph.containsVertex(4));
  }
  public void testRemoveZeroDegreeNodes_zeroDegreeIncoming_nodeNotExist_notContainOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(false, graph.containsVertex(99));
  }
  //
  public void testRemoveZeroDegreeNodes_zeroDegreeOutgoing_nodeExist_containOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(5, 4, "5->4");
    graph.addVertex(9);
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(true, graph.containsVertex(4));
  }
  public void testRemoveZeroDegreeNodes_zeroDegreeOutgoing_nodeNotExist_containOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(5, 4, "5->4");
    graph.addVertex(9);
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(false, graph.containsVertex(99));
  }
  public void testRemoveZeroDegreeNodes_zeroDegreeOutgoing_nodeExist_notContainOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(5, 4, "5->4");
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(true, graph.containsVertex(4));
  }
  public void testRemoveZeroDegreeNodes_zeroDegreeOutgoing_nodeNotExist_NOTcontainOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(5, 4, "5->4");
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(false, graph.containsVertex(99));
  }
  //
  public void testRemoveZeroDegreeNodes_disconnected_nodeExist_containOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.addVertex(9);
    graph.addVertex(99);
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(false, graph.containsVertex(9));
  }
  public void testRemoveZeroDegreeNodes_disconnected_nodeNotExist_containOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.addVertex(99);
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(false, graph.containsVertex(9));
  }
  public void testRemoveZeroDegreeNodes_disconnected_nodeExist_notContainOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.addVertex(9);
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(false, graph.containsVertex(9));
  }
  public void testRemoveZeroDegreeNodes_disconnected_nodeNotExist_notContainOtherZeroDegreeNode() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.removeZeroDegreeNodes();
    //test if node successfully removed
    assertEquals(false, graph.containsVertex(9));
  }

  //********************************Step 2-2C - Test Cases ******************************************


  public void testGetDegree_connected_nodeExist_basedOnIncoming() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.add(5, 4, "5->4");
    graph.add(5, 6, "5->6");
    assertEquals(1, graph.getInDegree(4));
  }
  public void testGetDegree_connected_nodeNotExist_basedOnIncoming() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.add(5, 4, "5->4");
    graph.add(5, 6, "5->6");
    assertEquals(0, graph.getInDegree(99));
  }
  public void testGetDegree_connected_nodeExist_basedOnOutgoing() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.add(5, 4, "5->4");
    graph.add(5, 6, "5->6");
    assertEquals(1, graph.getOutDegree(4));
  }
  public void testGetDegree_connected_nodeNotExist_basedOnOutgoing() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    graph.add(5, 4, "5->4");
    graph.add(5, 6, "5->6");
    assertEquals(0, graph.getOutDegree(99));
  }
  //
  public void testGetDegree_zeroDegreeIncoming_nodeExist_basedOnIncoming() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    assertEquals(0, graph.getInDegree(4));
  }
  public void testGetDegree_zeroDegreeIncoming_nodeNotExist_basedOnIncoming() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    assertEquals(0, graph.getInDegree(99));
  }
  public void testGetDegree_zeroDegreeIncoming_nodeExist_basedOnOutgoing() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    assertEquals(1, graph.getOutDegree(4));
  }
  public void testGetDegree_zeroDegreeIncoming_nodeNotExist_basedOnOutgoing() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(4, 5, "4->5");
    assertEquals(0, graph.getOutDegree(99));
  }
  //
  public void testGetDegree_zeroDegreeOutgoing_nodeExist_basedOnIncoming() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(5, 4, "5->4");
    assertEquals(1, graph.getInDegree(4));
  }

  //Capability 1 - Step 1A: All combination to test adding and removing edges in a graph.
  //Capability 1 - Step 1B: Structural testing - We consider those related methods as branches:{removeVertex(V vertex),removeVertices(Collection<V> vertices),addVertex(V v)}
  // All combination of branches to test adding and removing vertex in a graph.
  public void testGetDegree_zeroDegreeOutgoing_nodeNotExist_basedOnIncoming() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(5, 4, "5->4");
    assertEquals(0, graph.getInDegree(99));
  }
  public void testGetDegree_zeroDegreeOutgoing_nodeExist_basedOnOutgoing() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(5, 4, "5->4");
    assertEquals(0, graph.getOutDegree(4));
  }
  public void testGetDegree_zeroDegreeOutgoing_nodeNotExist_basedOnOutgoing() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(5, 4, "5->4");
    assertEquals(0, graph.getOutDegree(99));
  }
  //
  public void testGetDegree_disconnected_nodeExist_basedOnIncoming() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.addVertex(9);
    assertEquals(0, graph.getInDegree(9));
  }
  public void testGetDegree_disconnected_nodeNotExist_basedOnIncoming() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.addVertex(9);
    assertEquals(0, graph.getInDegree(99));
  }
  public void testGetDegree_disconnected_nodeExist_basedOnOutgoing() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.addVertex(9);
    assertEquals(0, graph.getOutDegree(9));
  }
  public void testGetDegree_disconnected_nodeNotExist_basedOnOutgoing() {
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.addVertex(9);
    assertEquals(0, graph.getOutDegree(99));
  }


  public void nullGraph(int n){
    /*
     *  V: {1,... n}
     *  E: {}
     * */
    for (int i=1; i<=n; i++)
      graph.addVertex(i);
  }

  public void trivialGraph(int connectivity){
    /*
     *  V: {1}
     *  E: {1->1-1,...1->1.n}
     * */
    graph.addVertex(1);
    for (int i=1; i<=connectivity; i++)
      graph.add(1, 1, "1->1->"+i);
  }

  public void baseDisconnectGraph(){
    /*
     *  V: {1, 2, 3, 4}
     *  E: {
     *         1->2
     *         3->4
     *    }
     * */
    graph.add(1, 2, "1->2");
    graph.add(3, 4, "3->4");
  }

  public void baseConnectedGraph(){
    /*
     * V: {1, 2, 3, 4}
     * E: {
     *       1->2->3->4
     *   }
     * */
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 4, "3->4");
  }

  public void extendedConnectedGraph(int n){
    /*
     * V: {1, 2, 3, 4, ... n+1}
     * E: {
     *       1->2->3->4->...n+1
     *   }
     * */
    for (int i=1; i<n+1; i++)
      graph.add(i, i+1, String.format("%d->%d",i, i+1));
  }

  public void baseCyclicGraph(){
    /*
     * V: {1, 2, 3}
     * E: {
     *       1->2->3->1
     *   }
     * */
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    graph.add(3, 1, "3->1");
  }

  public void baseCompleteGraph(){
    /*
     * V: {1, 2, 3}
     * E: {
     *       1<->2<->3<->1
     *   }
     * */
    graph.add(1, 2, "1->2");
    graph.add(2, 1, "2->1");
    graph.add(2, 3, "2->3");
    graph.add(3, 2, "3->2");
    graph.add(3, 1, "3->1");
    graph.add(1, 3, "1->3");
  }



  public DirectedMultiGraph<Integer, String> copyGraph(DirectedMultiGraph<Integer, String> g){
    return new DirectedMultiGraph<>(g);
  }

  public <E> void checkIterator(Iterable<E> edges, E ... expected) {
    List<E> expectedList = Arrays.asList(expected);
    List<E> foundList = new ArrayList<E>();
    for (E edge : edges) {
      foundList.add(edge);
    }
    assertEquals(expectedList, foundList);
    //System.out.println(foundList);
  }

  /* Test Iterator */

  public void testRemove_SingleIterator_ManyConnect_ConnectedGraph_lowConnectivity(){
    baseConnectedGraph();
    Iterator<String> iter = graph.outgoingEdgeIterator(1);
    while (iter.hasNext()) {
      if (iter.next().equals("1->2")) {
        iter.remove();
      }
    }
    checkIterator(graph.edgeIterable(), "2->3", "3->4");
  }

  public void testRemove_SingleIterator_ManyConnect_ConnectedGraph_midConnectivity(){
    graph.add(1, 2, "1->2");
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    Iterator<String> iter = graph.outgoingEdgeIterator(1);
    iter.next();
    iter.remove();
    checkIterator(graph.edgeIterable(), "1->2", "2->3");
  }

  public void testRemove_SingleIterator_ManyConnect_ConnectedGraph_highConnectivity(){
    graph.add(1, 2, "1->2");
    graph.add(1, 2, "1->2");
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    Iterator<String> iter = graph.outgoingEdgeIterator(1);
    iter.next();
    iter.remove();
    checkIterator(graph.edgeIterable(), "1->2", "1->2", "2->3");
  }

  public void testRemove_SingleIterator_ManyConnect_TrivialGraph_lowConnectivity(){
    trivialGraph(1);
    Iterator<String> iter = graph.outgoingEdgeIterator(1);
    iter.next();
    iter.remove();
    checkIterator(graph.edgeIterable());
  }

  public void testRemove_SingleIterator_ManyConnect_DisconnectedGraph_lowConnectivity(){
    baseDisconnectGraph();
    Iterator<String> iter = graph.outgoingEdgeIterator(1);
    iter.next();
    iter.remove();
    checkIterator(graph.edgeIterable(), "3->4");
  }

  public void testRemove_SingleIterator_ManyConnect_CyclicGraph_lowConnectivity(){
    baseCyclicGraph();
    Iterator<String> iter = graph.outgoingEdgeIterator(1);
    iter.next();
    iter.remove();
    checkIterator(graph.edgeIterable(), "2->3", "3->1");
  }

  public void testRemove_SingleIterator_ManyConnect_CompleteGraph_lowConnectivity(){
    baseCompleteGraph();
    Iterator<String> iter = graph.outgoingEdgeIterator(1);
    iter.next();
    iter.remove();
    checkIterator(graph.edgeIterable(),  "1->3","2->1", "2->3", "3->1" ,"3->2");
  }

  public void testRemove_SingleIterator_1Connect_ConnectedGraph_lowConnectivity(){
    graph.add(1, 2, "1->2");
    Iterator<String> iter = graph.outgoingEdgeIterator(1);
    iter.next();
    iter.remove();
    checkIterator(graph.edgeIterable());
  }

  public void testRemove_SingleIterator_2Connect_ConnectedGraph_lowConnectivity(){
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    Iterator<String> iter = graph.outgoingEdgeIterator(1);
    iter.next();
    iter.remove();
    checkIterator(graph.edgeIterable(), "2->3");
  }

  public void testRemove_SingleIterator_NumerousConnect_ConnectedGraph_lowConnectivity(){
    extendedConnectedGraph(11);
    Iterator<String> iter = graph.outgoingEdgeIterator(1);
    iter.next();
    iter.remove();
    List<String> edgeList = new ArrayList<>();
    for (String edge : graph.edgeIterable()) {
      edgeList.add(edge);
    }
    assertEquals(edgeList.size(), 10);
  }

  public void testRemove_SingleIterator_BrokenConnect_ConnectedGraph_lowConnectivity(){
    baseConnectedGraph();
    graph.outgoingEdges.clear();

    Iterator<String> iter = graph.outgoingEdgeIterator(1);
    assertFalse(iter.hasNext());
  }

  public void testRemove_SingleIterator_ManyConnect_ConnectedGraph_lowConnectivity_AbsentVertex(){
    baseConnectedGraph();
    Iterator<String> iter = new DirectedMultiGraph.EdgeIterator<>(0, graph.outgoingEdges, graph.incomingEdges);
    assertFalse(iter.hasNext());
  }

  public void checkWholeIterator(DirectedMultiGraph<Integer, String> g){
    for (String edge : g.getAllEdges()) {
      // Create copy and remove edge from copy manually
      DirectedMultiGraph<Integer, String> manCopy = copyGraph(g);
      DirectedMultiGraph<Integer, String> itrCopy = copyGraph(g);
      String[] v = edge.split("->");
      manCopy.removeEdge(Integer.parseInt(v[0]), Integer.parseInt(v[1]), edge);

      // Use iter.remove()
      Iterator<String> iter = itrCopy.edgeIterator();
      while (iter.hasNext()) {
        if (iter.next().equals(edge)) {
          iter.remove();
        }
      }
      assertEquals(manCopy.toString(),itrCopy.toString());
    }
  }

  public void testRemove_WholeIterator_ManyConnect_ConnectedGraph_lowConnectivity(){
    baseConnectedGraph();
    checkWholeIterator(graph);
  }

  public void testRemove_WholeIterator_ManyConnect_ConnectedGraph_midConnectivity(){
    baseConnectedGraph();
    graph.add(1,2, "1->2->2");
    checkWholeIterator(graph);
  }

  public void testRemove_WholeIterator_ManyConnect_ConnectedGraph_highConnectivity(){
    baseConnectedGraph();
    graph.add(1,2, "1->2->2");
    graph.add(1,2, "1->2->3");
    checkWholeIterator(graph);
  }


  public void testRemove_WholeIterator_ManyConnect_TrivialGraph_lowConnectivity(){
    trivialGraph(1);
    checkWholeIterator(graph);
  }

  public void testRemove_WholeIterator_ManyConnect_TrivialGraph_9Connectivity(){
    trivialGraph(9);
    checkWholeIterator(graph);
  }

  public void testRemove_WholeIterator_ManyConnect_TrivialGraph_11Connectivity(){
    trivialGraph(11);
    checkWholeIterator(graph);
  }

  public void testRemove_WholeIterator_ManyConnect_DisconnectedGraph_lowConnectivity(){
    baseDisconnectGraph();
    checkWholeIterator(graph);
  }

  public void testRemove_WholeIterator_ManyConnect_CyclicGraph_lowConnectivity(){
    baseCyclicGraph();
    checkWholeIterator(graph);
  }

  public void testRemove_WholeIterator_ManyConnect_CompleteGraph_lowConnectivity(){
    baseCompleteGraph();
    checkWholeIterator(graph);
  }

  public void testRemove_WholeIterator_1Connect_ConnectedGraph_lowConnectivity(){
    graph.add(1, 2, "1->2");
    checkWholeIterator(graph);
  }

  public void testRemove_WholeIterator_2Connect_ConnectedGraph_lowConnectivity(){
    graph.add(1, 2, "1->2");
    graph.add(2, 3, "2->3");
    checkWholeIterator(graph);
  }

  public void testRemove_WholeIterator_NumerousConnect_ConnectedGraph_lowConnectivity(){
    extendedConnectedGraph(11);
    checkWholeIterator(graph);
  }

  public void testRemove_WholeIterator_0Connect_NullGraph_0Connectivity(){
    graph.addVertex(1);
    graph.addVertex(2);
    checkWholeIterator(graph);
  }

  public void testRemove_WholeIterator_0Connect_TrialGraph_0Connectivity(){
    graph.addVertex(1);
    checkWholeIterator(graph);
  }

  /* Test Sort */

  public void checkSortResult(List<Integer> result, Integer ... expected){
    List<Integer> expectedList = Arrays.asList(expected);
    assertEquals(expectedList, result);
  }

  public void expectIllegalState(){
    try{
      graph.topologicalSort();
      fail("Expect IllegalStateException to be thrown.");
    }catch (IllegalStateException e){
    }
  }

  public void testSort_0Connect_NullGraph_0Connectivity(){
    graph.addVertex(1);
    graph.addVertex(2);
    checkSortResult(graph.topologicalSort(), 2,1);
  }

  public void testSort_0Connect_TrivialGraph_0Connectivity(){
    graph.addVertex(1);
    checkSortResult(graph.topologicalSort(), 1);
  }

  public void testSort_1Connect_TrivialGraph_lowConnectivity(){
    graph.addVertex(1);
    graph.add(1, 1, "1-1");
    expectIllegalState();
  }

  public void testSort_1Connect_DisconnectedGraph_lowConnectivity(){
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.add(1, 2, "1-2");
    checkSortResult(graph.topologicalSort(), 3,1,2);
  }

  public void testSort_1Connect_ConnectedGraph_lowConnectivity(){
    graph.add(1, 2, "1-2");
    checkSortResult(graph.topologicalSort(), 1,2);
  }

  public void testSort_2Connect_TrivialGraph_midConnectivity(){
    graph.add(1, 1, "1-1a");
    graph.add(1, 1, "1-1b");
    expectIllegalState();
  }

  public void testSort_2Connect_DisconnectedGraph_lowConnectivity(){
    graph.add(1, 2, "1-2");
    graph.add(3, 4, "3-4");
    checkSortResult(graph.topologicalSort(), 3,4,1,2);
  }

  public void testSort_2Connect_DisconnectedGraph_midConnectivity(){
    graph.add(1, 2, "1-2a");
    graph.add(1, 2, "1-2b");
    graph.addVertex(3); graph.addVertex(4);
    checkSortResult(graph.topologicalSort(), 4,3,1,2);
  }

  public void testSort_2Connect_ConnectedGraph_lowConnectivity(){
    graph.add(1, 2, "1-2");
    graph.add(2, 3, "2-3");
    checkSortResult(graph.topologicalSort(), 1,2,3);
  }

  public void testSort_2Connect_ConnectedGraph_midConnectivity(){
    graph.add(1, 2, "1-2a");
    graph.add(1, 2, "1-2b");
    checkSortResult(graph.topologicalSort(), 1,2);
  }

  public void testSort_2Connect_CompleteGraph_lowConnectivity(){
    graph.add(1, 2, "1-2");
    graph.add(2, 1, "2-1");
    expectIllegalState();
  }

  public void testSort_manyConnect_TrivialGraph_highConnectivity(){
    trivialGraph(3);
    expectIllegalState();
  }

  public void testSort_manyConnect_DisconnectedGraph_lowConnectivity(){
    baseDisconnectGraph();
    graph.add(5,6, "5->6");
    checkSortResult(graph.topologicalSort(), 5,6,3,4,1,2);
  }

  public void testSort_manyConnect_DisconnectedGraph_midConnectivity(){
    baseDisconnectGraph();
    graph.add(5,6, "5->6");
    baseDisconnectGraph();
    checkSortResult(graph.topologicalSort(), 5,6,3,4,1,2);
  }

  public void testSort_manyConnect_DisconnectedGraph_highConnectivity(){
    baseDisconnectGraph();
    graph.add(5,6, "5->6");
    baseDisconnectGraph();
    baseDisconnectGraph();
    checkSortResult(graph.topologicalSort(), 5,6,3,4,1,2);
  }

  public void testSort_manyConnect_ConnectedGraph_lowConnectivity(){
    baseConnectedGraph();
    checkSortResult(graph.topologicalSort(), 1,2,3,4);
  }

  public void testSort_manyConnect_ConnectedGraph_midConnectivity(){
    baseConnectedGraph();
    baseConnectedGraph();
    checkSortResult(graph.topologicalSort(), 1,2,3,4);
  }

  public void testSort_manyConnect_ConnectedGraph_highConnectivity(){
    baseConnectedGraph();
    baseConnectedGraph();
    baseConnectedGraph();
    checkSortResult(graph.topologicalSort(), 1,2,3,4);
  }

  public void testSort_manyConnect_CyclicGraph_lowConnectivity(){
    baseCyclicGraph();
    expectIllegalState();
  }


  public void testSort_manyConnect_CompleteGraph_lowConnectivity(){
    baseCompleteGraph();
    expectIllegalState();
  }

  public void testSort_NumerousConnect_DisconnectedGraph_lowConnectivity(){
    extendedConnectedGraph(10);
    graph.add(99,100,"99->100");
    checkSortResult(graph.topologicalSort(),
            99,100,1,2,3,4,5,6,7,8,9,10,11);
  }

  public void testSort_NumerousConnect_DisconnectedGraph_midConnectivity(){
    extendedConnectedGraph(5);
    extendedConnectedGraph(5);
    graph.add(99,100,"99->100");
    graph.add(99,100,"99->100");
    checkSortResult(graph.topologicalSort(),
            99,100,1,2,3,4,5,6);
  }

  public void testSort_NumerousConnect_DisconnectedGraph_highConnectivity(){
    extendedConnectedGraph(3);
    extendedConnectedGraph(3);
    extendedConnectedGraph(3);
    graph.add(99,100,"99->100");
    checkSortResult(graph.topologicalSort(),
            99,100,1,2,3,4);
  }

  public void testSort_NumerousConnect_ConnectedGraph_lowConnectivity(){
    extendedConnectedGraph(10);
    checkSortResult(graph.topologicalSort(),
            1,2,3,4,5,6,7,8,9,10,11);
  }

  public void testSort_NumerousConnect_ConnectedGraph_midConnectivity(){
    extendedConnectedGraph(5);
    extendedConnectedGraph(6);
    checkSortResult(graph.topologicalSort(),
            1,2,3,4,5,6,7);
  }

  public void testSort_NumerousConnect_ConnectedGraph_highConnectivity(){
    extendedConnectedGraph(3);
    extendedConnectedGraph(3);
    extendedConnectedGraph(3);
    checkSortResult(graph.topologicalSort(),
            1,2,3,4);
  }

  public void testSort_NumerousConnect_CyclicGraph_lowConnectivity(){
    extendedConnectedGraph(10);
    graph.add(11,1, "11-1");
    expectIllegalState();
  }

  public void testSort_NumerousConnect_CompleteGraph_lowConnectivity(){
    extendedConnectedGraph(6);
    for (int i=7; i>1;i--){
      graph.add(i, i-1, "");
    }
    expectIllegalState();
  }
}
