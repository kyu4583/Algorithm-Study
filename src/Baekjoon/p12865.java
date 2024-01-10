package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p12865 {
    static List<Component> components = new ArrayList<>();
    static int[] maxValueTable;
    static int N;
    static int K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        maxValueTable = new int[K];
        maxValueTable[0] = 0;
        for (int i=1; i<K; i++) {
            maxValueTable[i] = -1;
        }

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            Component component = new Component(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            components.add(component);
        }

        bw.write(Integer.toString(maxValue(K)));
        bw.flush();
    }

    private static int maxValue(int weight) {
        if (weight == 0) {
            return 0;
        }
        int max = maxValue(weight - 1);
        for (int i=0; i<N; i++) {
            Component nowComponent = components.get(i);
            int targetWeight = weight - nowComponent.getWeight();
            if(targetWeight >= 0) {
                if(maxValueTable[targetWeight] == -1) {
                    maxValueTable[targetWeight] = maxValue(targetWeight);
                }
                if(maxValueTable[targetWeight] + nowComponent.getValue() > max) {
                    max = maxValueTable[targetWeight] + nowComponent.getValue();
                }
            }
        }
        return max;
    }

    private static class Component{
        int weight;
        int value;

        public Component(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
