package hw8_21000710_chuquoctuan.ex2;

import hw8_21000710_chuquoctuan.ex1.GraphNoHasDirection;

import java.util.ArrayList;
import java.util.List;

public class HasDirectionGraphMatrix implements GraphHasDirection{
    private int[][] matrixGraph;
    private int numVertices;

    public HasDirectionGraphMatrix() {
        this.matrixGraph = null;
        this.numVertices = 0;
    }
    @Override
    public int numVertices() {
        return numVertices;
    }

    @Override
    public void vertices() {
        System.out.println("Vertex is : ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " ");
        }
    }

    @Override
    public int numEdges() {
        int count = 0;
        for (int i = 0; i < matrixGraph.length; i++) {
            for (int j = i + 1; j < matrixGraph[0].length; j++) {
                if(matrixGraph[i][j] != 0){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public void edges() {
        System.out.println("Edges:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (matrixGraph[i][j] != 0) {
                    System.out.print("(" + i + " - " + j + ") ");
                }
            }
        }
    }

    @Override
    public Edge getEdge(int vertex1, int vertex2) {
        if(matrixGraph[vertex1][vertex2] != 0){
            return new Edge(vertex1 ,vertex2);
        }else {
            return new Edge(vertex2 ,vertex1);
        }
    }

    @Override
    public int[] endVertices(Edge e) {
        int[] vertices = new int[2];
        vertices[0] = e.getVertex1();
        vertices[1] = e.getVertex2();
        return vertices;
    }

    @Override
    public int opposite(int vertex, Edge e) {
        if(e.getVertex1() == vertex){
            return e.getVertex2();
        } else if (e.getVertex2() == vertex) {
            return e.getVertex1();
        }else {
            throw new IllegalArgumentException("No is vertex");
        }
    }

    @Override
    public int outDegree(int vertice) {
        int count = 0;
        for (int i = 0; i < matrixGraph.length; i++) {
            if(1 == matrixGraph[i][vertice]){
                count++;
            }
        }
        return count;
    }

    @Override
    public int inDegree(int vertice) {
        return 0;
    }

    @Override
    public void outGoingEges(int vertex1) {
        for (int i = 0; i < numVertices; i++) {
            if(matrixGraph[vertex1][i] != 0){
                System.out.println("(" + i + " - " + vertex1 + ") ");
            }
        }
    }

    @Override
    public void inGoingEges(int vertex1) {
        for (int i = 0; i < numVertices; i++) {
            if(matrixGraph[i][vertex1] != 0){
                System.out.println("(" + i + " - " + vertex1 + ") ");
            }
        }
    }

    @Override
    public int insertVertex() {
        if (numVertices == 0) {
            matrixGraph = new int[1][1];
            numVertices++;
            return 0;
        }
        int[][] matrix = new int[numVertices + 1][numVertices + 1];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrix[i][j] = matrixGraph[i][j];
            }
        }
        matrixGraph = matrix;
        numVertices++;
        return numVertices - 1;
    }

    @Override
    public Edge insertEdge(int vertexStart, int vertexEnd ,int data) {
        matrixGraph[vertexStart][vertexEnd] = data;
        return new Edge(vertexStart ,vertexEnd);
    }

    @Override
    public int removeVertex(int vertex) {
        for (int i = 0; i < numVertices; i++) {
            matrixGraph[i][vertex] = 0;
            matrixGraph[vertex][i] = 0;
        }
        numVertices--;
        return vertex;
    }

    @Override
    public Edge removeEdge(Edge edge) {
        matrixGraph[edge.getVertex1()][edge.getVertex2()] = 0;

        return edge;
    }

    @Override
    public void print() {
        System.out.print("    ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
        for (int i = 0; i < matrixGraph.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < matrixGraph[0].length; j++) {
                System.out.print("  " + matrixGraph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
