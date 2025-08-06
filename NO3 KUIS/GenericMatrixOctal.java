

public class GenericMatrixOctal extends GenericMatrix<Integer> {

    public GenericMatrixOctal() { }

    public Integer add(Integer o1, Integer o2){
        String str_o1 = o1.toString();
        int desimal_o1 = Integer.parseInt(str_o1,8);

        String str_o2 = o2.toString();
        int desimal_o2 = Integer.parseInt(str_o2,8);

        int sum_desimal = desimal_o1 + desimal_o2;

        String octal_sum = Integer.toOctalString(sum_desimal);
        return Integer.parseInt(octal_sum);
    }

    public Integer multiply(Integer o1, Integer o2){
        String str_o1 = o1.toString();
        int desimal_o1 = Integer.parseInt(str_o1,8);

        String str_o2 = o2.toString();
        int desimal_o2 = Integer.parseInt(str_o2,8);

        int mult_desimal = desimal_o1 * desimal_o2;

        String octal_mult = Integer.toOctalString(mult_desimal);
        return Integer.parseInt(octal_mult);

    }

    public Integer zero(){
        return 0;
    }
    
}
