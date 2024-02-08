package DIP.violacao;

public class CPFServices {
    public static boolean isValid(String cpf) {
        return cpf.length() == 11;
    }
}
