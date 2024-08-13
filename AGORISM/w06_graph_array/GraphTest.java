package graphArray;

import java.util.*;


class GraphTest {
    public static void main(String args[]) {
        Graph gr = new Graph(6);

        gr.insertEdge(0, 1);
        gr.insertEdge(0, 2);
        gr.insertEdge(1, 2);
        gr.insertEdge(1, 3);
        gr.insertEdge(2, 3);
        gr.insertEdge(2, 4);
        gr.insertEdge(3, 4);
        gr.insertEdge(3, 5);
        gr.insertEdge(4, 5);
        gr.insertEdge(1, 5);

        System.out.println();
        int[] adj;
        for (int i = 0; i < 6; i++) {

            adj = gr.adjacency(i);
            System.out.print(i + ": ");
            for (int e : adj) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
/*
        gr.bfs(1);
        System.out.println();
        gr.dfs(1);
*/
        System.out.println();
        System.out.println("==================");



        gr = new Graph(7);
        System.out.println("\nremove함수 전\n");
        gr.insertEdge(0, 1);
        gr.insertEdge(0, 2);
        gr.insertEdge(0, 3);
        gr.insertEdge(1, 4);
        gr.insertEdge(2, 4);
        gr.insertEdge(2, 5);
        gr.insertEdge(3, 5);
        gr.insertEdge(4, 6);
        gr.insertEdge(5, 6);

        System.out.println();
//        int[] adj;
        for (int i = 0; i < 7; i++) {

            adj = gr.adjacency(i);
            System.out.print(i + ": ");
            for (int e : adj) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        
        System.out.println("\nremove(0,2)함수 후\n");
        gr.removeEdge(0, 2);
//        int[] adj;
        for (int i = 0; i < 7; i++) {

            adj = gr.adjacency(i);
            System.out.print(i + ": ");
            for (int e : adj) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        
/*
        gr.bfs(4);
        System.out.println();
        gr.dfs(4);
*/
    }
}
