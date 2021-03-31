package level5.expanding.nebula;

public class SolutionTesterForNebula {

    public static void main(String[] args) {

        System.out.println(Solution.solution(new boolean[][]{{true, false, true}, {false, true, false}, {true, false, true}}));
        System.out.println(Solution.solution(new boolean[][]{{true, false, true, false, false, true, true, true}, {true, false, true, false, false, false, true, false}, {true, true, true, false, false, false, true, false}, {true, false, true, false, false, false, true, false}, {true, false, true, false, false, true, true, true}}));
        System.out.println(Solution.solution(new boolean[][]{{true, true, false, true, false, true, false, true, true, false}, {true, true, false, false, false, false, true, true, true, false}, {true, true, false, false, false, false, false, false, false, true}, {false, true, false, false, false, false, true, true, false, false}}));
    }
}
