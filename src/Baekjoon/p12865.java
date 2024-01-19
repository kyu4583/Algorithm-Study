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
    static MaxSolution[] maxValueTable;
    static int N;
    static int K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        maxValueTable = new MaxSolution[K+1];
        maxValueTable[0] = new MaxSolution(0, new ArrayList<>());
        for (int i=1; i<=K; i++) {
            maxValueTable[i] = new MaxSolution(-1, new ArrayList<>());
        }

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            Component component = new Component(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            components.add(component);
        }
        int answer = createMaxSolution(K).getMaxValue();
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static MaxSolution createMaxSolution(int weight) {
        if (weight == 0) {
            return new MaxSolution(0, new ArrayList<>());
        }
        MaxSolution maxSolution = createMaxSolution(weight - 1);
        for (int i=0; i<N; i++) {
            Component nowComponent = components.get(i);
            int targetWeight = weight - nowComponent.getWeight();
            if(targetWeight >= 0) {
                if(maxValueTable[targetWeight].getMaxValue() == -1) {
                    maxValueTable[targetWeight] = createMaxSolution(targetWeight);
                }
                if (maxValueTable[targetWeight].getIncludedIndex().contains(i)){
                    continue;
                }
                if(maxValueTable[targetWeight].getMaxValue() + nowComponent.getValue() > maxSolution.getMaxValue()) {
                    maxSolution.setMaxValue(maxValueTable[targetWeight].getMaxValue() + nowComponent.getValue());
                    maxSolution.addIncludedIndex(i);
                }
            }
        }
        maxValueTable[weight] = maxSolution;
        return maxSolution;
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

    private static class MaxSolution{
        int maxValue;
        List<Integer> includedIndex;

        public MaxSolution(int maxValue, List<Integer> includedIndex) {
            this.maxValue = maxValue;
            this.includedIndex = includedIndex;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(int maxValue) {
            this.maxValue = maxValue;
        }

        public List<Integer> getIncludedIndex() {
            return includedIndex;
        }

        public void setIncludedIndex(List<Integer> includedIndex) {
            this.includedIndex = includedIndex;
        }

        public void addIncludedIndex(int includedIndex) {
            this.includedIndex.add(includedIndex);
        }
    }
}
